# Time spy app

This app use intent filter
> android.intent.action.TIME_SET
to track a broadcast receiver when the date of the device was changed.
When the method onReceive is call the app creates a new alert and send to firebase.
