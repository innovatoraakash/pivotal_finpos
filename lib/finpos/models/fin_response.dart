class FinResponse {
  int? code;
  String? message;

  FinResponse({this.code, this.message});

  @override
  String toString() => 'FinResponse(code: $code, message: $message)';

  factory FinResponse.fromJson(Map<String, dynamic> json) => FinResponse(
        code: json['code'] as int?,
        message: json['message'] as String?,
      );

  Map<String, dynamic> toJson() => {
        'code': code,
        'message': message,
      };
}
