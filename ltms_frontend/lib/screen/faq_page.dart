import 'package:flutter/material.dart';
import 'package:ltms_frontend/screen/submit_question_page.dart'; // Import the SubmitQuestionPage class

class FaqPage extends StatelessWidget {
  final List<Map<String, dynamic>> faqData;

  const FaqPage({required this.faqData});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('FAQ'),
      ),
      body: ListView.builder(
        itemCount: faqData.length,
        itemBuilder: (context, index) {
          final question = faqData[index]['question'];
          final answer = faqData[index]['answer'];

          return Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Container(
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.red),
                  borderRadius: BorderRadius.circular(8),
                ),
                padding: EdgeInsets.all(8),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      'Question:',
                      style: TextStyle(color: Colors.red),
                    ),
                    Text(question),
                  ],
                ),
              ),
              SizedBox(height: 8),
              Container(
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.green),
                  borderRadius: BorderRadius.circular(8),
                ),
                padding: EdgeInsets.all(8),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      'Answer:',
                      style: TextStyle(color: Colors.green),
                    ),
                    Text(answer ?? 'No answer available'),
                  ],
                ),
              ),
              Divider(),
            ],
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => SubmitQuestionPage(),
            ),
          );
        },
        child: Icon(Icons.add),
      ),
    );
  }
}
