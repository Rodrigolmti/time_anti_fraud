package com.rodrigolmti.time_anti_fraud.model;

import java.util.Map;

/**
 * Created by rodrigolmti on 06/04/18. At Framework
 */
public class Alert {

    private final String type;
    private final Map<String, String> currentDate;
    private final String newDate;
    private final String deviceId;

    public Alert(String type, Map<String, String> currentDate, String newDate,
        String deviceId) {
        this.type = type;
        this.currentDate = currentDate;
        this.newDate = newDate;
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public Map<String, String> getCurrentDate() {
        return currentDate;
    }

    public String getNewDate() {
        return newDate;
    }

    public String getDeviceId() {
        return deviceId;
    }
}
