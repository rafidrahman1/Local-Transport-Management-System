class _CustomApiButtonsState extends State<CustomApiButtons> {
  String? selectedBusId;

  void _showRouteInputPopup(BuildContext context) {
    final TextEditingController routeController = TextEditingController();

    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Enter Bus ID'),
          content: TextField(
            controller: routeController,
            decoration: InputDecoration(labelText: 'Bus ID'),
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
    ).then((busId) {
      if (busId != null && busId.isNotEmpty) {
        setState(() {
          selectedBusId = busId;
        });
        _fetchBusDetails(context, busId);
      }
    });
  }