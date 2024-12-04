import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class HceScreen extends StatelessWidget {
  static final platform = MethodChannel('com.example.hce_flutter_app/hce');

  Future<void> startHceService() async {
    try {
      final data = "1234567890ABCD"; // Example static data
      final result = await platform.invokeMethod('startHceService', {"data": data});
      print(result); // HCE Service started
    } on PlatformException catch (e) {
      print("Failed to start HCE service: ${e.message}");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("HCE Flutter App"),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: startHceService,
          child: Text("Start HCE Service"),
        ),
      ),
    );
  }
}
