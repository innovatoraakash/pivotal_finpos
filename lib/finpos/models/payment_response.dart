// ignore_for_file: public_member_api_docs, sort_constructors_first
class PaymentResponse {
  String? authCode;
  String? cardNumber;
  String? message;
  String? paymentMode;
  String? paymentNetwork;
  int? resultCode;
  String? retrievalReferenceNumber;
  String? systemTraceAuditNumber;
  String? transactionTimeStamp;

  PaymentResponse({
    this.authCode,
    this.cardNumber,
    this.message,
    this.paymentMode,
    this.paymentNetwork,
    this.resultCode,
    this.retrievalReferenceNumber,
    this.systemTraceAuditNumber,
    this.transactionTimeStamp,
  });

  factory PaymentResponse.fromJson(Map<String, dynamic> json) {
    return PaymentResponse(
      authCode: json['authCode'] as String?,
      cardNumber: json['cardNumber'] as String?,
      message: json['message'] as String?,
      paymentMode: json['paymentMode'] as String?,
      paymentNetwork: json['paymentNetwork'] as String?,
      resultCode: json['resultCode'] as int?,
      retrievalReferenceNumber: json['retrievalReferenceNumber'] as String?,
      systemTraceAuditNumber: json['systemTraceAuditNumber'] as String?,
      transactionTimeStamp: json['transactionTimeStamp'] as String?,
    );
  }

  Map<String, dynamic> toJson() => {
        'authCode': authCode,
        'cardNumber': cardNumber,
        'message': message,
        'paymentMode': paymentMode,
        'paymentNetwork': paymentNetwork,
        'resultCode': resultCode,
        'retrievalReferenceNumber': retrievalReferenceNumber,
        'systemTraceAuditNumber': systemTraceAuditNumber,
        'transactionTimeStamp': transactionTimeStamp,
      };

  @override
  String toString() {
    return 'PaymentResponse(authCode: $authCode, cardNumber: $cardNumber, message: $message, paymentMode: $paymentMode, paymentNetwork: $paymentNetwork, resultCode: $resultCode, retrievalReferenceNumber: $retrievalReferenceNumber, systemTraceAuditNumber: $systemTraceAuditNumber, transactionTimeStamp: $transactionTimeStamp)';
  }
}
