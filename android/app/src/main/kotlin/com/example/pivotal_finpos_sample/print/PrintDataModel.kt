package com.dynamictechnosoft.dynamic_erp.print;


import org.json.JSONObject

public data class PrintDataModel(
    // company details
    @JvmField var invoiceType: String = "Tax Invoice",
    @JvmField var companyName: String = "Dynamic Technosoft",
    @JvmField var companyAddress: String = "Baneshwor-10, Kathmandu",
    @JvmField var companyPanVat: String = "xxxxxxxxx",
    // voucher details
    @JvmField var invoiceDate: String,
    @JvmField var invoiceNo: String,
    @JvmField var customerName: String,
    @JvmField var customerAddress: String,
    @JvmField var panVat: String,
    @JvmField var mobileNo: String,
    @JvmField var couponNo: String,
    @JvmField var vehicleNo: String,
    @JvmField var itemName: String,
    @JvmField var itemQuantity: String,
    @JvmField var itemRate: String,
    @JvmField var itemAmount: String,
    // item details
    @JvmField var grossAmount: String,
    @JvmField var discount: String,
    @JvmField var taxAmount: String,
    @JvmField var nonTaxAmount: String,
    @JvmField var vatRate: String,
    @JvmField var vat: String,
    @JvmField var grandTotal: String,
    // print details
    @JvmField var printDate: String,
    @JvmField var preparedBy: String, 
    @JvmField var paymentMethods: String, 
    @JvmField var copyOfInvoice: String?,
    @JvmField var qrMessage: String = "",
    // powered by
    @JvmField var poweredBy: String = "Dynamic Technosoft"){


      companion object {
    fun fromJson(jsonString: String): PrintDataModel {
            val jsonObject = JSONObject(jsonString)
            return PrintDataModel(
                invoiceType = jsonObject.optString("invoiceType", "Tax Invoice"),
                companyName = jsonObject.optString("companyName", "Dynamic Technosoft"),
                companyAddress = jsonObject.optString("companyAddress", "Baneshwor-10, Kathmandu"),
                companyPanVat = jsonObject.optString("companyPanVat", "xxxxxxxxx"),
                invoiceDate = jsonObject.getString("invoiceDate"),
                invoiceNo = jsonObject.getString("invoiceNo"),
                customerName = jsonObject.getString("customerName"),
                customerAddress = jsonObject.getString("customerAddress"),
                panVat = jsonObject.getString("panVat"),
                mobileNo = jsonObject.getString("mobileNo"),
                couponNo = jsonObject.getString("couponNo"),
                vehicleNo = jsonObject.getString("vehicleNo"),
                itemName = jsonObject.getString("itemName"),
                itemQuantity = jsonObject.getString("itemQuantity"),
                itemRate = jsonObject.getString("itemRate"),
                itemAmount = jsonObject.getString("itemAmount"),
                grossAmount = jsonObject.getString("grossAmount"),
                discount = jsonObject.getString("discount"),
                taxAmount = jsonObject.getString("taxAmount"),
                nonTaxAmount = jsonObject.getString("nonTaxAmount"),
                vatRate = jsonObject.getString("vatRate"),
                vat = jsonObject.getString("vat"),
                grandTotal = jsonObject.getString("grandTotal"),
                printDate = jsonObject.getString("printDate"),
                preparedBy = jsonObject.getString("preparedBy"),
                qrMessage = jsonObject.getString("qrMessage"),
                paymentMethods = jsonObject.getString("paymentMethods"),
                poweredBy = jsonObject.optString("poweredBy", "Dynamic Technosoft"),
                copyOfInvoice = jsonObject.optString("copyOfInvoice", null)
            )
        }
    }

    fun toJson(): String {
        val jsonObject = JSONObject()
        jsonObject.put("invoiceType", invoiceType)
        jsonObject.put("companyName", companyName)
        jsonObject.put("companyAddress", companyAddress)
        jsonObject.put("companyPanVat", companyPanVat)
        jsonObject.put("invoiceDate", invoiceDate)
        jsonObject.put("invoiceNo", invoiceNo)
        jsonObject.put("customerName", customerName)
        jsonObject.put("customerAddress", customerAddress)
        jsonObject.put("panVat", panVat)
        jsonObject.put("mobileNo", mobileNo)
        jsonObject.put("couponNo", couponNo)
        jsonObject.put("vehicleNo", vehicleNo)
        jsonObject.put("itemName", itemName)
        jsonObject.put("itemQuantity", itemQuantity)
        jsonObject.put("itemRate", itemRate)
        jsonObject.put("itemAmount", itemAmount)
        jsonObject.put("grossAmount", grossAmount)
        jsonObject.put("discount", discount)
        jsonObject.put("taxAmount", taxAmount)
        jsonObject.put("nonTaxAmount", nonTaxAmount)
        jsonObject.put("vatRate", vatRate)
        jsonObject.put("vat", vat)
        jsonObject.put("grandTotal", grandTotal)
        jsonObject.put("printDate", printDate)
        jsonObject.put("preparedBy", preparedBy)
        jsonObject.put("poweredBy", poweredBy)
        jsonObject.put("qrMessage", qrMessage)
        jsonObject.put("paymentMethods", paymentMethods)
        jsonObject.put("copyOfInvoice", copyOfInvoice)

        return jsonObject.toString()
    }
    }
