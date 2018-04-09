# Time spy app

This app use intent filter
    > android.intent.action.TIME_SET
to track a broadcast receiver when the of the device is changed.
When the method onReceive is call the app creates a new alert and send to firebase.
