package com.google.firebase.messaging;

import F0.AbstractC0008a;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class NotificationParams {
    private static final int COLOR_TRANSPARENT_IN_HEX = -16777216;
    private static final int EMPTY_JSON_ARRAY_LENGTH = 1;
    private static final String TAG = "NotificationParams";
    private static final int VISIBILITY_MAX = 1;
    private static final int VISIBILITY_MIN = -1;
    private final Bundle data;

    public NotificationParams(Bundle bundle) {
        if (bundle != null) {
            this.data = new Bundle(bundle);
            return;
        }
        throw new NullPointerException(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
    }

    private static int getLightColor(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != COLOR_TRANSPARENT_IN_HEX) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean isAnalyticsKey(String str) {
        if (!str.startsWith(Constants.AnalyticsKeys.PREFIX) && !str.equals(Constants.MessagePayloadKeys.FROM)) {
            return false;
        }
        return true;
    }

    private static boolean isReservedKey(String str) {
        if (!str.startsWith(Constants.MessagePayloadKeys.RESERVED_CLIENT_LIB_PREFIX) && !str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) && !str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD)) {
            return false;
        }
        return true;
    }

    private static String keyWithOldPrefix(String str) {
        if (!str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX)) {
            return str;
        }
        return str.replace(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX, Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD);
    }

    private String normalizePrefix(String str) {
        if (!this.data.containsKey(str) && str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX)) {
            String keyWithOldPrefix = keyWithOldPrefix(str);
            if (this.data.containsKey(keyWithOldPrefix)) {
                return keyWithOldPrefix;
            }
        }
        return str;
    }

    private static String userFriendlyKey(String str) {
        if (str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX)) {
            return str.substring(6);
        }
        return str;
    }

    public boolean getBoolean(String str) {
        String string = getString(str);
        if (!"1".equals(string) && !Boolean.parseBoolean(string)) {
            return false;
        }
        return true;
    }

    public Integer getInteger(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            try {
                return Integer.valueOf(Integer.parseInt(string));
            } catch (NumberFormatException unused) {
                userFriendlyKey(str);
                return null;
            }
        }
        return null;
    }

    public JSONArray getJSONArray(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONArray(string);
            } catch (JSONException unused) {
                userFriendlyKey(str);
                return null;
            }
        }
        return null;
    }

    public int[] getLightSettings() {
        JSONArray jSONArray = getJSONArray(Constants.MessageNotificationKeys.LIGHT_SETTINGS);
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArray.length() == 3) {
                iArr[0] = getLightColor(jSONArray.optString(0));
                iArr[1] = jSONArray.optInt(1);
                iArr[2] = jSONArray.optInt(2);
                return iArr;
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (IllegalArgumentException e4) {
            jSONArray.toString();
            e4.getMessage();
            return null;
        } catch (JSONException unused) {
            jSONArray.toString();
            return null;
        }
    }

    public Uri getLink() {
        String string = getString(Constants.MessageNotificationKeys.LINK_ANDROID);
        if (TextUtils.isEmpty(string)) {
            string = getString(Constants.MessageNotificationKeys.LINK);
        }
        if (!TextUtils.isEmpty(string)) {
            return Uri.parse(string);
        }
        return null;
    }

    public Object[] getLocalizationArgsForKey(String str) {
        JSONArray jSONArray = getJSONArray(str + Constants.MessageNotificationKeys.TEXT_ARGS_SUFFIX);
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    public String getLocalizationResourceForKey(String str) {
        return getString(str + Constants.MessageNotificationKeys.TEXT_RESOURCE_SUFFIX);
    }

    public String getLocalizedString(Resources resources, String str, String str2) {
        String localizationResourceForKey = getLocalizationResourceForKey(str2);
        if (TextUtils.isEmpty(localizationResourceForKey)) {
            return null;
        }
        int identifier = resources.getIdentifier(localizationResourceForKey, "string", str);
        if (identifier == 0) {
            userFriendlyKey(AbstractC0008a.n(str2, Constants.MessageNotificationKeys.TEXT_RESOURCE_SUFFIX));
            return null;
        }
        Object[] localizationArgsForKey = getLocalizationArgsForKey(str2);
        if (localizationArgsForKey == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, localizationArgsForKey);
        } catch (MissingFormatArgumentException unused) {
            userFriendlyKey(str2);
            Arrays.toString(localizationArgsForKey);
            return null;
        }
    }

    public Long getLong(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            try {
                return Long.valueOf(Long.parseLong(string));
            } catch (NumberFormatException unused) {
                userFriendlyKey(str);
                return null;
            }
        }
        return null;
    }

    public String getNotificationChannelId() {
        return getString(Constants.MessageNotificationKeys.CHANNEL);
    }

    public Integer getNotificationCount() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.NOTIFICATION_COUNT);
        if (integer == null || integer.intValue() < 0) {
            return null;
        }
        return integer;
    }

    public Integer getNotificationPriority() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.NOTIFICATION_PRIORITY);
        if (integer == null || integer.intValue() < -2 || integer.intValue() > 2) {
            return null;
        }
        return integer;
    }

    public String getPossiblyLocalizedString(Resources resources, String str, String str2) {
        String string = getString(str2);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return getLocalizedString(resources, str, str2);
    }

    public String getSoundResourceName() {
        String string = getString(Constants.MessageNotificationKeys.SOUND_2);
        if (TextUtils.isEmpty(string)) {
            return getString(Constants.MessageNotificationKeys.SOUND);
        }
        return string;
    }

    public String getString(String str) {
        return this.data.getString(normalizePrefix(str));
    }

    public long[] getVibrateTimings() {
        JSONArray jSONArray = getJSONArray(Constants.MessageNotificationKeys.VIBRATE_TIMINGS);
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() > 1) {
                int length = jSONArray.length();
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    jArr[i] = jSONArray.optLong(i);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            jSONArray.toString();
            return null;
        }
    }

    public Integer getVisibility() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.VISIBILITY);
        if (integer == null || integer.intValue() < -1 || integer.intValue() > 1) {
            return null;
        }
        return integer;
    }

    public boolean hasImage() {
        return !TextUtils.isEmpty(getString(Constants.MessageNotificationKeys.IMAGE_URL));
    }

    public boolean isNotification() {
        return getBoolean(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION);
    }

    public Bundle paramsForAnalyticsIntent() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (!isAnalyticsKey(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle paramsWithReservedKeysRemoved() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (isReservedKey(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public static boolean isNotification(Bundle bundle) {
        return "1".equals(bundle.getString(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)) || "1".equals(bundle.getString(keyWithOldPrefix(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)));
    }
}
