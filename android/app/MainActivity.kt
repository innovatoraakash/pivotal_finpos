package com.dynamictechnosoft.dynamic_erp


import com.google.gson.Gson
import global.citytech.finpossmart.sdk.FinPosSmartSdk
import global.citytech.finpossmart.sdk.api.SmartSdk
import com.dynamictechnosoft.dynamic_erp.print.PrintHelper
import com.dynamictechnosoft.dynamic_erp.print.PrintDataModel

import global.citytech.payment.sdk.api.PaymentService
import global.citytech.payment.sdk.api.PosPaymentApi
import global.citytech.payment.sdk.api.PosPaymentConfiguration
import global.citytech.payment.sdk.api.requests.PurchasePaymentRequest
import global.citytech.payment.sdk.api.requests.VoidPaymentRequest
import global.citytech.payment.sdk.api.responses.PaymentResponse
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterFragmentActivity

class MainActivity: FlutterActivity()
{
   private val channel = "finpos-native"
   private lateinit var paymentService: PaymentService
   private val gson = Gson()

   companion object {
       const val INVOKED_DEMO_PRINT = "demo-print"
       const val INVOKED_KEY_EXCHANGE = "key-exchange"
       const val INVOKED_SALE = "sale"
       const val INVOKED_VOID_SALE = "void-sale"
       const val INVOKED_SETTLEMENT = "settlement"

       private const val VENDOR_NAME = "finPOS Payment Demo"
       private const val FINPOS_PUBLIC_KEY =
           "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDraingswxsE8qczssx38bYNIoV0JxuFt8h9olYwcrUZvJzwMrtnY4xnyD6ecqNXCF8W/vV+rF1JksuDVwRnYSpyeGMZiwIVzJGef3vLjVwLW4QLetOOc+xNgGQOW+pSaRjXLe27c7Tp1nq92X5iYaOgpXhfby01PwelbqNPPBUqQIDAQAB"
       private const val VENDOR_PRIVATE_KEY =
           "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIZCaRRWa5K06oMcKzPS2O933sVnRaRcOriNlzg0yRNynaj31LrRxi2D0npfy4VEx3lToukl8vpbqfp2cCig5AIVQNXAXCk/SH5NfQPU+x9p9AOyMmz3HfCt6/7dpqkG7OaIO04mbu3Y9kgD8vWMZI7i5kBJu5ddge97eBvQOg0NAgMBAAECgYEAhTkK2gJzFg1tkxH1kKQNXXod1NYIFfLq1cyyHDTMvf6CkXLyZTrZIrrmtUWvRxubsDmcsytT8rfYcE7sNnSIKlTNcGKQ2brr70q7OHxaiKjPOg8q9Us0WV6uPE/TBp7vvu2bG3vR+QmR0rjU4Ly2m/QzKsqicnsjrAgHS0KZZIECQQDAVH65ovCygXmfhrIuTzqHqQrhYimuXdaZVLQA8ECF9+6MXDAnawW7o5DKH2E0Sv5HOe574omxVf4dXbgHQ4uhAkEAsrSR0rRerztR45qfjMPE9/3j5CRfvrsx02cXyeb218fgKokiSo95k7pthcfPj1ImkK2CKG6BX9MvGzESPTUp7QJAMM3AEm8MUN+V8ysEz8d+/KmifyqflQVuzR23R32vgc82ExvZhEcd/000EnX//nsBJyXGJF2JvxwpDV6Ysg8rwQJATlwRSSQgFJRdTwEhDvdU6i0g/YvZk+e/bGRbMQQenvWc3Onu6GTLObTYi33XDJBIKs56MUJrZlpS4Ih+5+nk7QJADyUHgcJumbLvVdzLrLvOVN706mINd+k+w2UWM6AnZAHiGBGiQd12gBQErG3rZAVJ4uemJe5sk4EPjMf63Ya5MA=="
       private const val TRANSACTION_CURRENCY_CODE_NPR = "0524"
   }


   override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
       super.configureFlutterEngine(flutterEngine)
       
       initializePaymentSdk()
       MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channel ).setMethodCallHandler{
               call, result ->
           when(call.method) {
               
               INVOKED_DEMO_PRINT -> initiateDemoPrint(call.arguments as String,result)
               INVOKED_KEY_EXCHANGE -> initiateKeyExchange(result)
               INVOKED_SALE -> initiateSaleTransaction(call.arguments as String,result)
               INVOKED_VOID_SALE ->  initiateVoidSaleTransaction(call.arguments as List<String>,result)

               INVOKED_SETTLEMENT -> initiateSettlement(result)
           }
       }
   }


   private fun initiateKeyExchange(result: MethodChannel.Result) {
       println("Key Exchange initiated...")
       Thread {
           try {
//                initializePaymentSdk()
               val response = paymentService.performKeyExchange()
               println("initiateKeyExchange...")
               result.success(gson.toJson(response))
           } catch (ex: Exception) {
               ex.printStackTrace()
           }
       }.start()
   }

   private fun initiateSaleTransaction(amount: String,result: MethodChannel.Result) {
       println("Sale initiated...")
       Thread {
           try {
              var response= initiateSale(amount)
               result.success(response)
           } catch (exception: Exception) {
               result.error(exception.hashCode().toString(),exception.message,"something went wrong")
               exception.printStackTrace()
           }
       }.start()
   }

   private fun initiateVoidSaleTransaction(parameters: List<String>, result: MethodChannel.Result ) {
       val rrn = parameters[0]
       var response ="init"
       val billedAmount = parameters[1]
       println("Void sale initiated...")
       Thread {
           try {
               response =  initiateVoidSale(rrn, billedAmount)
               println("in 2 "+response)
               result.success(response)
           } catch (exception: Exception) {
               result.error(exception.hashCode().toString(),exception.message,"something went wrong")

               exception.printStackTrace()
           }
       }.start()

   }
    private fun initiateDemoPrint(jsonData: String, result: MethodChannel.Result ){
        println("Printing initiated...")
        Thread{
            val smartSdk: SmartSdk = FinPosSmartSdk.getInstance(context)
            val printRequest  = PrintHelper.preparePrintRequest(context, PrintDataModel.fromJson(jsonData))
            smartSdk.print(printRequest)
        }.start()
    }

   private fun initiateSettlement(result: MethodChannel.Result) {
       println("Settlement initiated...")
       Thread {
           try {
               val response = paymentService.performSettlement()
               println("initiateSettlement...")
               result.success(gson.toJson(response))
               //Handle response from here
           } catch (exception: Exception) {
               result.error(exception.hashCode().toString(),exception.message,"something went wrong")
               exception.printStackTrace()
           }
       }.start()
   }

   private fun initiateSale(amount: String):String {
       val purchasePaymentRequest = PurchasePaymentRequest(
           amount.toDouble(),
           TRANSACTION_CURRENCY_CODE_NPR
       )
       val paymentResponse: PaymentResponse = paymentService.doPurchase(purchasePaymentRequest)
       val toReturn = gson.toJson(paymentResponse)

       println("initiateSale...")
       println(paymentResponse.message)
       return toReturn
//        return paymentResponse
       //Handle Payment Response from Here
   }

   private fun initiateVoidSale(rrn: String, billedAmount: String):String {
       val voidPaymentRequest = VoidPaymentRequest(
           rrn,
           billedAmount.toDouble()
       )
       val paymentResponse: PaymentResponse = paymentService.performVoid(voidPaymentRequest)
       val toReturn = gson.toJson(paymentResponse)

       println("initiateVoidSale...")
       println("in 5 "+toReturn)
       return toReturn
       //Handle Payment Response from Here
   }

   private fun initializePaymentSdk() {
    Thread {

       val posPaymentConfiguration: PosPaymentConfiguration = getPosPaymentConfiguration()
       paymentService = PosPaymentApi.getInstance(
           this,
           posPaymentConfiguration
       )
    }.start()

   }

   private fun getPosPaymentConfiguration(): PosPaymentConfiguration {
       val applicationIdentifier = applicationContext.packageName
       return PosPaymentConfiguration(
           applicationIdentifier,
           VENDOR_NAME,
           FINPOS_PUBLIC_KEY,
           VENDOR_PRIVATE_KEY
       )
   }
}
