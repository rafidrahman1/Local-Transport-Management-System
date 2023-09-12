import 'package:flutter/material.dart';
import 'package:ltms_frontend/buttons/custom_buttons.dart'; // Import the CustomApiButtons class

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Homepage'),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          CustomApiButtons(), // Include the buttons here
          // Other content of your page
        ],
      ),
    );
  }
}

// ... Rest of the code ...



