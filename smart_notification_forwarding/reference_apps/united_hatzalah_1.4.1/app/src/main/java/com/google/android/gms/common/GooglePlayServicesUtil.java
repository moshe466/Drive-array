package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.fragment.app.G;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.zaj;

/* loaded from: classes.dex */
public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";

    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i3) {
        return getErrorDialog(i, activity, i3, null);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i3) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i, i3);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return GooglePlayServicesUtilLight.getErrorString(i);
    }

    public static Context getRemoteContext(Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i);
    }

    public static boolean isUsingBackgroundThreadExecutorForBindService() {
        return GoogleApiManager.zat();
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i3) {
        return showErrorDialogFragment(i, activity, i3, null);
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (!GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i) && !GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i)) {
            googleApiAvailability.showErrorNotification(context, i);
        } else {
            googleApiAvailability.zai(context);
        }
    }

    @Deprecated
    public static boolean useBackgroundThreadExecutorForBindService() {
        return true;
    }

    @Deprecated
    public static void useBackgroundThreadForConnectionCallback() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i, i3, onCancelListener);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context, int i) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i3, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, G g3, int i3, DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        int i4 = i;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (g3 == null) {
            return googleApiAvailability.showErrorDialogFragment(activity, i4, i3, onCancelListener);
        }
        Dialog zaa = googleApiAvailability.zaa(activity, i4, zaj.zac(g3, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i4, "d"), i3), onCancelListener, null);
        if (zaa == null) {
            return false;
        }
        googleApiAvailability.zah(activity, zaa, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
