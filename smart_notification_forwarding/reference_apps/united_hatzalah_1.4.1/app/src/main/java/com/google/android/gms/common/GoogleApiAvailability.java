package com.google.android.gms.common;

import F0.m3;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.fragment.app.G;
import androidx.fragment.app.L;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.zaq;
import com.google.android.gms.common.internal.zad;
import com.google.android.gms.common.internal.zaf;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zan;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.Tasks;
import e.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import w.h;
import w.n;
import x.AbstractC0773d;

/* loaded from: classes.dex */
public class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    private String zac;
    private zad zad;
    private static final Object zaa = new Object();
    private static final GoogleApiAvailability zab = new GoogleApiAvailability();
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    public static GoogleApiAvailability getInstance() {
        return zab;
    }

    public Task<Void> checkApiAvailability(GoogleApi<?> googleApi, GoogleApi<?>... googleApiArr) {
        return checkApiAvailability(TaskExecutors.MAIN_THREAD, googleApi, googleApiArr);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int getClientVersion(Context context) {
        return super.getClientVersion(context);
    }

    public Dialog getErrorDialog(Activity activity, int i, int i3) {
        return getErrorDialog(activity, i, i3, (DialogInterface.OnCancelListener) null);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public Intent getErrorResolutionIntent(Context context, int i, String str) {
        return super.getErrorResolutionIntent(context, i, str);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i3) {
        return super.getErrorResolutionPendingIntent(context, i, i3);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final String getErrorString(int i) {
        return super.getErrorString(i);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final boolean isUserResolvableError(int i) {
        return super.isUserResolvableError(i);
    }

    public Task<Void> makeGooglePlayServicesAvailable(Activity activity) {
        int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(activity, i);
        if (isGooglePlayServicesAvailable == 0) {
            return Tasks.forResult(null);
        }
        zabw zaa2 = zabw.zaa(activity);
        zaa2.zaf(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        return zaa2.zab();
    }

    public void setDefaultNotificationChannelId(Context context, String str) {
        NotificationChannel notificationChannel;
        if (PlatformVersion.isAtLeastO()) {
            notificationChannel = ((NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"))).getNotificationChannel(str);
            Preconditions.checkNotNull(notificationChannel);
        }
        synchronized (zaa) {
            this.zac = str;
        }
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int i3) {
        return showErrorDialogFragment(activity, i, i3, (DialogInterface.OnCancelListener) null);
    }

    public void showErrorNotification(Context context, int i) {
        zac(context, new ConnectionResult(i, getErrorResolutionPendingIntent(context, i, 0, "n")), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Dialog zaa(Context context, int i, zaj zajVar, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(zaf.zac(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String zae = zaf.zae(context, i);
        if (zae != null) {
            if (zajVar == null) {
                zajVar = onClickListener;
            }
            builder.setPositiveButton(zae, zajVar);
        }
        String zaa2 = zaf.zaa(context, i);
        if (zaa2 != null) {
            builder.setTitle(zaa2);
        }
        new StringBuilder("Creating dialog for Google Play services availability issue. ConnectionResult=").append(i);
        new IllegalArgumentException();
        return builder.create();
    }

    public final boolean zab(Activity activity, LifecycleFragment lifecycleFragment, int i, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog zaa2 = zaa(activity, i, zaj.zad(lifecycleFragment, getErrorResolutionIntent(activity, i, "d"), 2), onCancelListener, null);
        if (zaa2 == null) {
            return false;
        }
        zah(activity, zaa2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [F0.t, w.l, java.lang.Object] */
    public final void zac(Context context, ConnectionResult connectionResult, String str) {
        int i;
        String str2;
        NotificationChannel notificationChannel;
        CharSequence name;
        int errorCode = connectionResult.getErrorCode();
        new IllegalArgumentException();
        if (errorCode == 18) {
            zai(context);
            return;
        }
        PendingIntent resolution = connectionResult.getResolution();
        if (resolution == null) {
            return;
        }
        String zab2 = zaf.zab(context, errorCode);
        String zad = zaf.zad(context, errorCode);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"));
        n nVar = new n(context, null);
        nVar.f6660o = true;
        nVar.d(16, true);
        nVar.f6651e = n.b(zab2);
        ?? obj = new Object();
        obj.f6646b = n.b(zad);
        nVar.g(obj);
        boolean isWearable = DeviceProperties.isWearable(context);
        int i3 = android.R.drawable.stat_sys_warning;
        if (isWearable) {
            int i4 = context.getApplicationInfo().icon;
            if (i4 != 0) {
                i3 = i4;
            }
            nVar.f6666v.icon = i3;
            nVar.f6655j = 2;
            if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                nVar.f6648b.add(new h(com.google.android.gms.base.R.drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R.string.common_open_on_phone), resolution));
            } else {
                nVar.f6653g = resolution;
            }
        } else {
            nVar.f6666v.icon = android.R.drawable.stat_sys_warning;
            String string = resources.getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker);
            nVar.f6666v.tickerText = n.b(string);
            nVar.f6666v.when = System.currentTimeMillis();
            nVar.f6653g = resolution;
            nVar.f6652f = n.b(zad);
        }
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkState(PlatformVersion.isAtLeastO());
            synchronized (zaa) {
                str2 = this.zac;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string2 = context.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_channel_name);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(m3.c(string2));
                } else {
                    name = notificationChannel.getName();
                    if (!string2.contentEquals(name)) {
                        notificationChannel.setName(string2);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
            }
            nVar.f6664t = str2;
        }
        Notification a2 = nVar.a();
        if (errorCode != 1 && errorCode != 2 && errorCode != 3) {
            i = 39789;
        } else {
            GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
            i = 10436;
        }
        notificationManager.notify(i, a2);
        zae(context, connectionResult, false);
    }

    public final boolean zad(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent errorResolutionPendingIntent;
        if (InstantApps.isInstantApp(context) || (errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult)) == null) {
            return false;
        }
        zac(context, new ConnectionResult(connectionResult.getErrorCode(), zan.zaa(context, 0, GoogleApiActivity.zaa(context, errorResolutionPendingIntent, i, true), zan.zaa | 134217728), connectionResult.getErrorMessage(), connectionResult.getClientMethodKey()), null);
        return true;
    }

    public final void zae(Context context, ConnectionResult connectionResult, boolean z3) {
        int intValue;
        Integer clientMethodKey = connectionResult.getClientMethodKey();
        if (clientMethodKey == null) {
            intValue = -1;
        } else {
            intValue = clientMethodKey.intValue();
        }
        com.google.android.gms.common.internal.zab zabVar = new com.google.android.gms.common.internal.zab(intValue, context.getPackageName(), System.currentTimeMillis(), connectionResult.getErrorCode(), z3);
        if (this.zad == null) {
            this.zad = new zaq(context);
        }
        this.zad.zaa(zabVar);
    }

    public final Dialog zaf(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(zaf.zac(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        zah(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final zabr zag(Context context, zabq zabqVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabr zabrVar = new zabr(zabqVar);
        AbstractC0773d.c(context, zabrVar, intentFilter);
        zabrVar.zaa(context);
        if (!isUninstalledAppPossiblyUpdating(context, "com.google.android.gms")) {
            zabqVar.zaa();
            zabrVar.zab();
            return null;
        }
        return zabrVar;
    }

    public final void zah(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof L) {
                SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((L) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public final void zai(Context context) {
        new zac(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean zaj(int i) {
        if (i == 9) {
            return true;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                switch (i) {
                    case 17:
                    case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    case 19:
                    case 20:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public Task<Void> checkApiAvailability(HasApiKey<?> hasApiKey, HasApiKey<?>... hasApiKeyArr) {
        return checkApiAvailability(TaskExecutors.MAIN_THREAD, hasApiKey, hasApiKeyArr);
    }

    public Dialog getErrorDialog(Activity activity, int i, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return zaa(activity, i, zaj.zab(activity, getErrorResolutionIntent(activity, i, "d"), i3), onCancelListener, null);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            return connectionResult.getResolution();
        }
        return getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int isGooglePlayServicesAvailable(Context context, int i) {
        return super.isGooglePlayServicesAvailable(context, i);
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i, i3, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        zah(activity, errorDialog, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public Task<Void> checkApiAvailability(Executor executor, HasApiKey<?> hasApiKey, HasApiKey<?>... hasApiKeyArr) {
        Preconditions.checkNotNull(hasApiKey, "Requested API must not be null.");
        for (HasApiKey<?> hasApiKey2 : hasApiKeyArr) {
            Preconditions.checkNotNull(hasApiKey2, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(hasApiKeyArr.length + 1);
        arrayList.add(hasApiKey);
        arrayList.addAll(Arrays.asList(hasApiKeyArr));
        return GoogleApiManager.zab().zah(arrayList).onSuccessTask(executor, zab.zaa);
    }

    public void showErrorNotification(Context context, ConnectionResult connectionResult) {
        zac(context, new ConnectionResult(connectionResult.getErrorCode(), getErrorResolutionPendingIntent(context, connectionResult), connectionResult.getErrorMessage(), connectionResult.getClientMethodKey()), null);
    }

    public Dialog getErrorDialog(G g3, int i, int i3) {
        return getErrorDialog(g3, i, i3, (DialogInterface.OnCancelListener) null);
    }

    public boolean showErrorDialogFragment(Activity activity, int i, c cVar, DialogInterface.OnCancelListener onCancelListener) {
        Dialog zaa2 = zaa(activity, i, null, onCancelListener, new zaa(this, activity, i, cVar));
        if (zaa2 == null) {
            return false;
        }
        zah(activity, zaa2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public Dialog getErrorDialog(G g3, int i, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return zaa(g3.requireContext(), i, zaj.zac(g3, getErrorResolutionIntent(g3.requireContext(), i, "d"), i3), onCancelListener, null);
    }
}
