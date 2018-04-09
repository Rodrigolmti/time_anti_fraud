package com.rodrigolmti.time_anti_fraud.model;

/**
 * Created by rodrigolmti on 06/04/18. At Framework
 */
public enum AlertType {

    TIMEZONE_CHANGED(1L, "android.intent.action.TIMEZONE_CHANGED"),
    AIRPLANE_MODE(2L, "android.intent.action.AIRPLANE_MODE"),
    DATE_CHANGED(3L, "android.intent.action.DATE_CHANGED"),
    TIME_SET(4L, "android.intent.action.TIME_SET");

    private final String value;
    private final Long id;

    AlertType(Long id, String value) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public static AlertType getType(String type) {
        if (TIMEZONE_CHANGED.getValue().equals(type)) {
            return TIMEZONE_CHANGED;
        }
        if (AIRPLANE_MODE.getValue().equals(type)) {
            return AIRPLANE_MODE;
        }
        if (DATE_CHANGED.getValue().equals(type)) {
            return DATE_CHANGED;
        }
        if (TIME_SET.getValue().equals(type)) {
            return TIME_SET;
        }
        return null;
    }
}
