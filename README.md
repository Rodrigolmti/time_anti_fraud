# Time spy app

This app use intent filter

> android.intent.action.TIME_SET

to track a broadcast receiver when the date of the device was changed.
When the method onReceive is call the app creates a new alert and send to firebase.

> This solution has an issue, if you have on your phone auto time and data, android frequently will check the time and data on some server, and that will send the broadcast.
