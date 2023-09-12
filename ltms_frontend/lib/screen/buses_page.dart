import 'package:flutter/material.dart';

class BusesPage extends StatelessWidget {
  final List<Map<String, dynamic>> busData;

  const BusesPage({required this.busData});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Buses'),
      ),
      body: ListView.builder(
        itemCount: busData.length,
        itemBuilder: (context, index) {
          final bus = busData[index];
          final id = bus['id'];
          final name = bus['name'];
          final price = bus['price'];
          final route = bus['route'];

          return Container(
            margin: EdgeInsets.symmetric(vertical: 8, horizontal: 16),
            decoration: BoxDecoration(
              border: Border.all(color: Colors.grey),
              borderRadius: BorderRadius.circular(8),
            ),
            padding: EdgeInsets.all(16),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text('ID: $id'),
                Text(
                  'Name: $name',
                  style: TextStyle(color: Colors.blue),
                ),
                Text('Price: $price'),
                Text('Route: $route'),
              ],
            ),
          );
        },
      ),
    );
  }
}
