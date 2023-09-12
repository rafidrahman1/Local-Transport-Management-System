import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

import 'login_registration_page.dart';

class InputPage extends StatefulWidget {
  final String userId;

  InputPage({required this.userId});

  static Route<dynamic> route(String userId) {
    return MaterialPageRoute(
      builder: (context) => InputPage(userId: userId),
    );
  }

  @override
  _InputPageState createState() => _InputPageState();
}

class _InputPageState extends State<InputPage> {
  TextEditingController inputController = TextEditingController();

  Future<void> _sendInput(BuildContext context) async {
    final String userInput = inputController.text;

    if (userInput.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Please enter an input')),
      );
      return;
    }

    final String apiUrl = 'http://localhost/user/process-input'; // Replace with your actual API URL

    try {
      final response = await http.post(
        Uri.parse(apiUrl),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode({'id': userInput, 'myId': widget.userId}),
      );

      if (response.statusCode == 200) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Input processed successfully')),
        );
      } else {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Failed to process input')),
        );
      }
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Error: $e')),
      );
    }
  }

  void _clearInputField() {
    inputController.clear();
  }

  Future<void> _logout() async {
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => LoginRegistrationPage(),
      ),
    );// Navigate back to the login page
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Input Page'),
        actions: [
          IconButton(
            icon: Icon(Icons.logout),
            onPressed: _logout,
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text('Logged in as: ${widget.userId}'),
            TextField(
              controller: inputController,
              decoration: InputDecoration(labelText: 'Input'),
            ),
            SizedBox(height: 16),
            ElevatedButton(
              onPressed: () => _sendInput(context),
              child: Text('Send Input'),
            ),
          ],
        ),
      ),
    );
  }
}
