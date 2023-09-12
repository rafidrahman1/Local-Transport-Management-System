import 'package:flutter/material.dart';

class BusDetailsPage extends StatelessWidget {
  final Map<String, dynamic> busDetails;

  const BusDetailsPage({required this.busDetails});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Bus Details'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('ID: ${busDetails['id']}'),
            Text('Name: ${busDetails['name']}'),
            Text('Price: ${busDetails['price']}'),
            Text('Route: ${busDetails['route']}'),
          ],
        ),
      ),
    );
  }
}
