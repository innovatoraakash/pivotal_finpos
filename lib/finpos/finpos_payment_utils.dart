import 'dart:convert';
import 'dart:developer';


import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_easyloading/flutter_easyloading.dart';
import 'models/fin_response.dart';
import 'models/payment_response.dart';
import 'models/petrol_pump_print_data_model.dart';

class FinposPaymentUtils {
  static const keyExchange = "key-exchange";
  static const sale = "sale";
  static const voudSale = "void-sale";
  static const settlement = "settlement";
  static const channel = "finpos-native";
  static const demoPrint = "demo-print";
  static const platform = MethodChannel(channel);
  Future<dynamic> initiateKeyExchange() async {
    await platform.invokeMethod(keyExchange).then((value) {
      final response = FinResponse.fromJson(jsonDecode(value));
      log(response.toString());
      if (response.code == 0) {
        EasyLoading.showToast("Key Exchnage Success");
      } else {
        EasyLoading.showToast(response.message ?? "Key Exchange Failed");
      }
    });
  }

  Future<PaymentResponse> initiateSale(String amount) async {
    final value = await platform.invokeMethod(sale, amount);

    final response = PaymentResponse.fromJson(jsonDecode(value));
    // saveSalesInvoice(response);
    log(response.toString());
    return response;
  }

  Future<dynamic> initiateVoidSale(
    String retrievalReferenceNumber,
    String billedAmount,
  ) async {
    List<String> parameters = [retrievalReferenceNumber, billedAmount];

    platform.invokeMethod(voudSale, parameters).then((value) async {
      final response = PaymentResponse.fromJson(jsonDecode(value));
      // await saveSalesInvoice(response, billedAmount);
      log(response.toString());
    });
  }

  // Future<void> saveSalesInvoice(PaymentResponse response, amount) async {
  //   if (response.resultCode == 0) {
  //     var mapOfdata = {
  //       'voucherDate': DateTime.now().toLocalFormatted(),
  //       'ManualVoucherNO': "",
  //       'VoucherId': 14,
  //       'Narration': "",
  //       'TotalAmount': amount,
  //     };

  //     final formData = FormData.fromMap(
  //       {
  //         'paraDataColl': mapOfdata,
  //       },
  //     );

  //     final rId = await PurchaseSaleService.savePurchaseSale(
  //       formData,
  //       'SaveSalesInvoice',
  //     );
  //     log(rId.toString());
  //   } else {
  //     EasyLoading.showToast(response.message.toString());
  //   }
  // }

  Future<dynamic> initiateSettlement() async {
    platform.invokeMethod(settlement).then((value) {
      final response = FinResponse.fromJson(jsonDecode(value));
      EasyLoading.showToast(response.message.toString());

      log(response.toString());
    });
  }

  Future<dynamic> printData(PetrolPumpPrintDataModel data) async {
    platform.invokeMethod(demoPrint, json.encode(data.toJson())).then((value) {
      log(value.toString());
    });
  }
}
