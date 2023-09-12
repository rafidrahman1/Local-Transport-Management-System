import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'faq_page.dart'; // Import the FaqPage class

class SubmitQuestionPage extends StatefulWidget {
  @override
  _SubmitQuestionPageState createState() => _SubmitQuestionPageState();
}

class _SubmitQuestionPageState extends State<SubmitQuestionPage> {
  final String baseUrl = 'http://localhost:8080';
  final TextEditingController questionController = TextEditingController();
  bool _isSubmitting = false;

  Future<void> _submitQuestion(BuildContext context) async {
    final String question = questionController.text;

    if (question.isEmpty) {
      // Display an error message if the question is empty
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Please enter a question')),
      );
      return;
    }

    setState(() {
      _isSubmitting = true;
    });

    final Map<String, dynamic> postData = {
      'question': question,
    };

    final Uri postUrl = Uri.parse('$baseUrl/help/create'); // Replace with your actual API URL

    final response = await http.post(
      postUrl,
      headers: <String, String>{
        'Content-Type': 'application/json',
      },
      body: jsonEncode(postData),
    );

    setState(() {
      _isSubmitting = false;
    });

    if (response.statusCode == 200) {
      // Show a SnackBar message
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Your question has been submitted')),
      );

      // Clear the text field
      questionController.clear();

      // Navigate back to the FAQ page after a delay
      Future.delayed(Duration(seconds: 2), () {
        Navigator.pop(context); // Pop the current page from the navigation stack
      });
    } else {
      // Failed to submit question
      // Handle error, show a message, etc.
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Ask a Question'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller: questionController,
              decoration: InputDecoration(labelText: 'Enter your question'),
            ),
            SizedBox(height: 16),
            ElevatedButton(
              onPressed: _isSubmitting ? null : () => _submitQuestion(context),
              child: Text('Ask'),
            ),
          ],
        ),
      ),
    );
  }
}
