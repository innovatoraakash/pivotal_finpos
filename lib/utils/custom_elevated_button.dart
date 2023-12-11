import 'package:flutter/material.dart';


class CustomElevatedButton extends StatelessWidget {
  ///title text of button
  final String? title;
  final Color? color;
  final Color? borderColor;
  final Color? textColor;
  final VoidCallback onPressed;
  final double? height;
  final double? elevation;
  final double? width;
  final Widget? child;
  final bool? enabled;
  final bool expanded;
  final double verticalMargin;

  ///elevated button with custom functions
  const CustomElevatedButton({
    super.key,
    this.title,
    required this.onPressed,
    this.color,
    this.height,
    this.elevation = 2,
    this.width,
    this.child,
    this.borderColor,
    this.textColor,
    this.enabled,
    this.expanded = true,
    this.verticalMargin = 0,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 60,
      width: MediaQuery.of(context).size.width*0.8,
      margin: EdgeInsets.symmetric(
        horizontal: 12,
        vertical: verticalMargin,
      ),
      child: ElevatedButton(
        style: ElevatedButton.styleFrom(
          side: BorderSide(
            width: borderColor == null ? 0 : 2,
            color: borderColor ?? const Color.fromARGB(0, 33, 149, 243),
          ),
          backgroundColor: color,
          elevation: elevation,
        ),
        onPressed: (enabled ?? true) ? onPressed : null,
        child: child ??
            Text(
              title ?? "button text",
              style: TextStyle(color: textColor),
            ),
      ),
    );
  }
}
