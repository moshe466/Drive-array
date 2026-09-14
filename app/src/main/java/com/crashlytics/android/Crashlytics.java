package com.crashlytics.android;

import android.util.Log;

public class Crashlytics {
    private static final String TAG = "Crashlytics";

    public static void log(String msg) {
        if (msg != null) {
            Log.d(TAG, msg);
        }
    }

    public static void log(int priority, String tag, String msg) {
        if (msg != null) {
            Log.println(priority, tag != null ? tag : TAG, msg);
        }
    }

    public static void logException(Throwable t) {
        if (t != null) {
            Log.e(TAG, "Exception: ", t);
        }
    }

    public static void setUserIdentifier(String id) {}
    public static void setUserName(String name) {}
    public static void setUserEmail(String email) {}
    public static void setString(String key, String value) {}
    public static void setBool(String key, boolean value) {}
    public static void setInt(String key, int value) {}
    public static void setFloat(String key, float value) {}
    public static void setLong(String key, long value) {}
    public static Crashlytics getInstance() { return new Crashlytics(); }
}
