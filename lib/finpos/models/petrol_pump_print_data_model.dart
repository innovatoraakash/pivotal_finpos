// ignore_for_file: public_member_api_docs, sort_constructors_first
class PetrolPumpPrintDataModel {
  // company details
  String invoiceType;
  String companyName;
  String companyAddress;
  String companyPanVat;

  // voucher details
  String invoiceDate;
  String invoiceNo;
  String customerName;
  String customerAddress;
  String panVat;
  String mobileNo;
  String couponNo;
  String vehicleNo;
  String paymentMethods;

  // item details
  String itemName;
  String itemQuantity;
  String itemRate;
  String itemAmount;

  // item amount details
  String grossAmount;
  String discount;
  String taxAmount;
  String nonTaxAmount;
  String vatRate;
  String vat;
  String grandTotal;

  // print details
  String printDate;
  String preparedBy;
  String? copyOfInvoice;

  // powered by
  String poweredBy;
  String? qrMessage;

  PetrolPumpPrintDataModel({
    // company details
    this.invoiceType = 'Tax Invoice',
    this.companyName = 'Dynamic Technosoft',
    this.companyAddress = 'Baneshwor-10, Kathmandu',
    this.companyPanVat = 'xxxxxxxxx',
    // voucher details
    required this.invoiceDate,
    required this.invoiceNo,
    required this.customerName,
    required this.customerAddress,
    required this.panVat,
    required this.mobileNo,
    required this.couponNo,
    required this.vehicleNo,
    this.paymentMethods = "",
    required this.itemName,
    required this.itemQuantity,
    required this.itemRate,
    required this.itemAmount,
    // item details
    required this.grossAmount,
    required this.discount,
    required this.taxAmount,
    required this.nonTaxAmount,
    required this.vatRate,
    required this.vat,
    required this.grandTotal,
    // print details
    required this.printDate,
    required this.preparedBy,
    required this.copyOfInvoice,
    this.qrMessage,

    // powered by
    this.poweredBy = 'Dynamic Technosoft',
  });

  PetrolPumpPrintDataModel copyWith({
    String? invoiceType,
    String? companyName,
    String? companyAddress,
    String? companyPanVat,
    String? invoiceDate,
    String? invoiceNo,
    String? customerName,
    String? customerAddress,
    String? panVat,
    String? mobileNo,
    String? couponNo,
    String? vehicleNo,
    String? paymentMethods,
    String? itemName,
    String? itemQuantity,
    String? itemRate,
    String? itemAmount,
    String? grossAmount,
    String? discount,
    String? taxAmount,
    String? nonTaxAmount,
    String? vatRate,
    String? vat,
    String? grandTotal,
    String? printDate,
    String? preparedBy,
    String? poweredBy,
    String? copyOfInvoice,
    String? qrMessage,
  }) {
    return PetrolPumpPrintDataModel(
      invoiceType: invoiceType ?? this.invoiceType,
      companyName: companyName ?? this.companyName,
      companyAddress: companyAddress ?? this.companyAddress,
      companyPanVat: companyPanVat ?? this.companyPanVat,
      invoiceDate: invoiceDate ?? this.invoiceDate,
      invoiceNo: invoiceNo ?? this.invoiceNo,
      customerName: customerName ?? this.customerName,
      customerAddress: customerAddress ?? this.customerAddress,
      panVat: panVat ?? this.panVat,
      mobileNo: mobileNo ?? this.mobileNo,
      couponNo: couponNo ?? this.couponNo,
      vehicleNo: vehicleNo ?? this.vehicleNo,
      paymentMethods: paymentMethods ?? this.paymentMethods,
      itemName: itemName ?? this.itemName,
      itemQuantity: itemQuantity ?? this.itemQuantity,
      itemRate: itemRate ?? this.itemRate,
      itemAmount: itemAmount ?? this.itemAmount,
      grossAmount: grossAmount ?? this.grossAmount,
      discount: discount ?? this.discount,
      taxAmount: taxAmount ?? this.taxAmount,
      nonTaxAmount: nonTaxAmount ?? this.nonTaxAmount,
      vatRate: vatRate ?? this.vatRate,
      vat: vat ?? this.vat,
      grandTotal: grandTotal ?? this.grandTotal,
      printDate: printDate ?? this.printDate,
      preparedBy: preparedBy ?? this.preparedBy,
      poweredBy: poweredBy ?? this.poweredBy,
      copyOfInvoice: copyOfInvoice ?? this.copyOfInvoice,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      // company details
      'invoiceType': invoiceType,
      'companyName': companyName,
      'companyAddress': companyAddress,
      'companyPanVat': companyPanVat,
      // voucher details
      'invoiceDate': invoiceDate,
      'invoiceNo': invoiceNo,
      'customerName': customerName,
      'customerAddress': customerAddress,
      'panVat': panVat,
      'mobileNo': mobileNo,
      'couponNo': couponNo,
      'vehicleNo': vehicleNo,
      'paymentMethods': paymentMethods,
      'itemName': itemName,
      'itemQuantity': itemQuantity,
      'itemRate': itemRate,
      'itemAmount': itemAmount,
      // item details
      'grossAmount': grossAmount,
      'discount': discount,
      'taxAmount': taxAmount,
      'nonTaxAmount': nonTaxAmount,
      'vatRate': vatRate,
      'vat': vat,
      'grandTotal': grandTotal,
      'qrMessage': qrMessage,
      // print details
      'printDate': printDate,
      'preparedBy': preparedBy,
      'poweredBy': poweredBy,
      'copyOfInvoice': copyOfInvoice,
    };
  }
}
