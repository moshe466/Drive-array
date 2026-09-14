package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class ConnectionErrorMessages {

    @GuardedBy("sCache")
    private static final SimpleArrayMap<String, String> zaog = new SimpleArrayMap<>();

    private ConnectionErrorMessages() {
    }

    public static String getAppName(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String getDefaultNotificationChannelName(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    @NonNull
    public static String getErrorDialogButtonMessage(Context context, int i) {
        return context.getResources().getString(i != 1 ? i != 2 ? i != 3 ? android.R.string.ok : R.string.common_google_play_services_enable_button : R.string.common_google_play_services_update_button : R.string.common_google_play_services_install_button);
    }

    @NonNull
    public static String getErrorMessage(Context context, int i) {
        Resources resources = context.getResources();
        String appName = getAppName(context);
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, appName);
        }
        if (i == 2) {
            return DeviceProperties.isWearableWithoutPlayStore(context) ? resources.getString(R.string.common_google_play_services_wear_update_text) : resources.getString(R.string.common_google_play_services_update_text, appName);
        }
        if (i == 3) {
            return resources.getString(R.string.common_google_play_services_enable_text, appName);
        }
        if (i == 5) {
            return zaa(context, "common_google_play_services_invalid_account_text", appName);
        }
        if (i == 7) {
            return zaa(context, "common_google_play_services_network_error_text", appName);
        }
        if (i == 9) {
            return resources.getString(R.string.common_google_play_services_unsupported_text, appName);
        }
        if (i == 20) {
            return zaa(context, "common_google_play_services_restricted_profile_text", appName);
        }
        switch (i) {
            case 16:
                return zaa(context, "common_google_play_services_api_unavailable_text", appName);
            case 17:
                return zaa(context, "common_google_play_services_sign_in_failed_text", appName);
            case 18:
                return resources.getString(R.string.common_google_play_services_updating_text, appName);
            default:
                return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, appName);
        }
    }

    @NonNull
    public static String getErrorNotificationMessage(Context context, int i) {
        return i == 6 ? zaa(context, "common_google_play_services_resolution_required_text", getAppName(context)) : getErrorMessage(context, i);
    }

    @NonNull
    public static String getErrorNotificationTitle(Context context, int i) {
        String zaa = i == 6 ? zaa(context, "common_google_play_services_resolution_required_title") : getErrorTitle(context, i);
        return zaa == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : zaa;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    @Nullable
    public static String getErrorTitle(Context context, int i) {
        String str;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zaa(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zaa(context, "common_google_play_services_network_error_title");
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                Log.e("GoogleApiAvailability", str);
                return null;
            case 9:
                str = "Google Play services is invalid. Cannot recover.";
                Log.e("GoogleApiAvailability", str);
                return null;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                Log.e("GoogleApiAvailability", str);
                return null;
            case 11:
                str = "The application is not licensed to the user.";
                Log.e("GoogleApiAvailability", str);
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i);
                str = sb.toString();
                Log.e("GoogleApiAvailability", str);
                return null;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                Log.e("GoogleApiAvailability", str);
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zaa(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zaa(context, "common_google_play_services_restricted_profile_title");
        }
    }

    @Nullable
    private static String zaa(Context context, String str) {
        synchronized (zaog) {
            String str2 = zaog.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (!TextUtils.isEmpty(string)) {
                zaog.put(str, string);
                return string;
            }
            String valueOf2 = String.valueOf(str);
            Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
            return null;
        }
    }

    private static String zaa(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zaa = zaa(context, str);
        if (zaa == null) {
            zaa = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zaa, str2);
    }
}
