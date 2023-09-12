import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:ltms_frontend/screen/faq_page.dart';
import 'package:ltms_frontend/screen/buses_page.dart';
import 'package:ltms_frontend/screen/login_registration_page.dart';

import '../screen/bus_details_page.dart';

class CustomApiButtons extends StatelessWidget {
  final String baseUrl = 'http://localhost:8080';
  int busId = 1;


  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: [
        CustomApiButton(
          label: 'Add Money',
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => LoginRegistrationPage(),
              ),
            );
          },
        ),
        CustomApiButton(
          label: 'Route',
          onPressed: () => _showRouteInputPopup(context),
        ),
        ApiButton(
          label: 'Buses',
          apiUrl: '$baseUrl/bus/all',
          onSuccess: (jsonData) {
            final List<Map<String, dynamic>> busData = jsonData.map((bus) {
              return {
                'id': bus['id'],
                'name': bus['name'],
                'price': bus['price'],
                'route': bus['route'],
              };
            }).toList();

            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => BusesPage(busData: busData),
              ),
            );
          },
        ),
        ApiButton(
          label: 'Faq',
          apiUrl: '$baseUrl/help/all',
          onSuccess: (jsonData) {
            final List<Map<String, dynamic>> faqData = jsonData.where((
                item) => item['answer'] != null).map((item) =>
            {
              'question': item['question'],
              'answer': item['answer'],
            }).toList();

            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => FaqPage(faqData: faqData),
              ),
            );
          },
        ),
      ],
    );
  }

  void _showRouteInputPopup(BuildContext context) {
    final TextEditingController routeController = TextEditingController();

    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Enter Route'),
          content: TextField(
            controller: routeController,
            decoration: InputDecoration(labelText: 'Route'),
          ),
          actions: <Widget>[
            TextButton(
              onPressed: () {
                Navigator.of(context).pop(routeController.text);
              },
              child: Text('Submit'),
            ),
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('Cancel'),
            ),
          ],
        );
      },
    ).then((input) {
      if (input != null && input.isNotEmpty) {
        int busId = int.parse(input);
        _fetchBusDetails(context, busId);
      }
    });
  }

  void _fetchBusDetails(BuildContext context, int busId) async {
    final apiUrl = '$baseUrl/bus/$busId';

    try {
      final response = await http.get(Uri.parse(apiUrl));

      if (response.statusCode == 200) {
        final busDetails = json.decode(response.body) as Map<String, dynamic>;

        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => BusDetailsPage(busDetails: busDetails),
          ),
        );
      } else {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Failed to fetch bus details')),
        );
      }
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Error: $e')),
      );
    }
  }
}

class ApiButton extends StatelessWidget {
  final String label;
  final String apiUrl;
  final Function(List<dynamic>)? onSuccess;

  const ApiButton({required this.label, required this.apiUrl, this.onSuccess});

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () => _callApi(context),
      child: Text(label),
    );
  }

  void _callApi(BuildContext context) async {
    try {
      final response = await http.get(Uri.parse(apiUrl));

      if (response.statusCode == 200 && onSuccess != null) {
        final List<dynamic> jsonData = json.decode(response.body);
        onSuccess!(jsonData);
      }
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Error: $e')),
      );
    }
  }
}

class CustomApiButton extends StatelessWidget {
  final String label;
  final VoidCallback? onPressed;

  const CustomApiButton({required this.label, this.onPressed});

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: onPressed,
      child: Text(label),
    );
  }
}
