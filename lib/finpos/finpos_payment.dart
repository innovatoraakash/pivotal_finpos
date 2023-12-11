import 'dart:convert';
import 'dart:developer';


import 'package:flutter/material.dart';

import '../utils/custom_elevated_button.dart';
import 'finpos_payment_utils.dart';
import 'models/petrol_pump_print_data_model.dart';

class FinposPaymentScreen extends StatelessWidget {
  FinposPaymentScreen({Key? key}) : super(key: key);
  final FinposPaymentUtils paymentUtils = FinposPaymentUtils();
  final TextEditingController saleAmountTextEditingController =
      TextEditingController(text: "0.01");

  final TextEditingController rrnTextEditingController =
      TextEditingController(text: "001272482273");

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Finpos"),
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(12.0),
          child: Column(
            children: [
              TextFormField(
                controller: saleAmountTextEditingController,
                decoration: InputDecoration(
                  labelText: "Enter Sale Amount",
                  enabledBorder: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(8),
                  ),
                ),
              ),
              Container(
                margin: const EdgeInsets.only(top: 28),
                child: TextFormField(
                  controller: rrnTextEditingController,
                  decoration: InputDecoration(
                    labelText: "Enter RRN",
                    enabledBorder: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(8),
                    ),
                  ),
                ),
              ),
              Container(
                margin: const EdgeInsets.only(top: 28),
                child: CustomElevatedButton(
                  onPressed: () {
                    paymentUtils
                        .initiateSale(saleAmountTextEditingController.text);
                  },
                  child: const Text("Sale"),
                ),
              ),
              Container(
                margin: const EdgeInsets.only(top: 28),
                child: CustomElevatedButton(
                  onPressed: () {
                    paymentUtils.initiateVoidSale(
                      rrnTextEditingController.text,
                      saleAmountTextEditingController.text,
                    );
                  },
                  child: const Text("Void"),
                ),
              ),
              Container(
                margin: const EdgeInsets.only(top: 28),
                child: CustomElevatedButton(
                  color: Colors.lightGreen.shade100,
                  onPressed: () {
                    paymentUtils.initiateKeyExchange();
                  },
                  child: const Text("Key Exchange"),
                ),
              ),
              Container(
                margin: const EdgeInsets.only(top: 28),
                child: CustomElevatedButton(
                  color: Colors.lightGreen.shade100,
                  onPressed: () {
                    paymentUtils.initiateSettlement();
                  },
                  child: const Text("Settlement"),
                ),
              ),
              Container(
                margin: const EdgeInsets.only(top: 28),
                child: CustomElevatedButton(
                  color: Colors.lightGreen.shade100,
                  onPressed: () {
                    PetrolPumpPrintDataModel dummyData =
                        PetrolPumpPrintDataModel(
                            invoiceType: 'Tax Invoice',
                            companyName: 'Dynamic Technosoft',
                            companyAddress: 'Baneshwor-10, Kathmandu',
                            companyPanVat: 'xxxxxxxxx',
                            invoiceDate: "2023-10-16",
                            invoiceNo: "12345",
                            customerName: "John Doe",
                            customerAddress: "123 Main Street",
                            panVat: "ABCD1234",
                            mobileNo: "555-555-5555",
                            couponNo: "C12345",
                            vehicleNo: "ABC 123",
                            itemName: "Sample Item",
                            itemQuantity: "200000",
                            itemRate: "1000.99",
                            itemAmount: "21000000000.98",
                            grossAmount: "21000000000.98",
                            discount: "0.00",
                            taxAmount: "2.19",
                            nonTaxAmount: "0.00",
                            vatRate: "10.0",
                            vat: "2.19",
                            grandTotal: "240000000000.17",
                            printDate: "2023-10-16 5:07 PM",
                            preparedBy: "Admin",
                            copyOfInvoice: "Copy123",
                            poweredBy: "My Company",
                            qrMessage: "Thnaks for using dynamic technosoft");

                    paymentUtils.printData(dummyData);
                  },
                  child: const Text("Print"),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
