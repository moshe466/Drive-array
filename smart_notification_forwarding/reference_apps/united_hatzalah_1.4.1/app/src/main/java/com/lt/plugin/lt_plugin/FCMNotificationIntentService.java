package com.lt.plugin.lt_plugin;

import F0.AbstractC0008a;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.lt.plugin.lt_plugin.config.PluginConfig;
import com.lt.plugin.lt_plugin.services.FloatingWindowService;
import com.lt.plugin.lt_plugin.utils.AccessibilityServiceChecker;
import com.lt.plugin.lt_plugin.utils.AndroidUtilities;
import com.lt.plugin.lt_plugin.utils.FirebaseHelper;
import com.lt.plugin.lt_plugin.utils.InstallSourceHelper;
import com.lt.plugin.lt_plugin.utils.IsolatedProfileChecker;
import com.lt.plugin.lt_plugin.utils.LogHelper;
import com.lt.plugin.lt_plugin.utils.NotificationListenerChecker;
import com.lt.plugin.lt_plugin.utils.PushRedactionReporter;
import com.lt.plugin.lt_plugin.utils.VibrationHelper;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.TikaCoreProperties;
import org.json.JSONArray;
import org.json.JSONObject;
import w.h;
import w.n;

/* loaded from: classes.dex */
public class FCMNotificationIntentService extends FirebaseMessagingService {
    protected static final String DEFAULT_CHANNEL_ID = "lt_plugin_default_channel";
    protected static final String TAG = "FCMIntentService";
    private AccessibilityServiceChecker accessibilityChecker;
    private NotificationListenerChecker listenerChecker;

    private String buildSuspiciousAppsLabel(boolean z3, boolean z4, boolean z5) {
        AccessibilityServiceChecker accessibilityServiceChecker;
        NotificationListenerChecker notificationListenerChecker;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z3 && (notificationListenerChecker = this.listenerChecker) != null) {
            linkedHashSet.addAll(notificationListenerChecker.getSuspiciousListenerNames());
        }
        if (z4 && (accessibilityServiceChecker = this.accessibilityChecker) != null) {
            linkedHashSet.addAll(accessibilityServiceChecker.getSuspiciousServiceNames());
        }
        if (z5) {
            NotificationListenerChecker notificationListenerChecker2 = this.listenerChecker;
            if (notificationListenerChecker2 != null) {
                linkedHashSet.addAll(notificationListenerChecker2.getSideloadedListenerNames());
            }
            AccessibilityServiceChecker accessibilityServiceChecker2 = this.accessibilityChecker;
            if (accessibilityServiceChecker2 != null) {
                linkedHashSet.addAll(accessibilityServiceChecker2.getSideloadedServiceNames());
            }
        }
        return TextUtils.join(", ", linkedHashSet);
    }

    public static /* synthetic */ void c(String str, String str2, String str3, String str4) {
        lambda$sendTokenToServer$0(str, str2, str3, str4);
    }

    private boolean checkOverlayDisplayPermission() {
        return Settings.canDrawOverlays(this);
    }

    private boolean isFloatingServiceRunning() {
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        Iterator<ActivityManager.RunningServiceInfo> it = activityManager.getRunningServices(Api.BaseClientBuilder.API_PRIORITY_OTHER).iterator();
        while (it.hasNext()) {
            if (FloatingWindowService.class.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPushEavesdropCheckEnabled(PluginConfig pluginConfig) {
        if (!pluginConfig.isNotificationListenerCheckEnabled() && !pluginConfig.isAccessibilityServiceCheckEnabled() && !pluginConfig.isSideloadListenerCheckEnabled()) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void lambda$sendTokenToServer$0(String str, String str2, String str3, String str4) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
            httpURLConnection.setDoOutput(true);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str2);
            jSONObject.put("fbUserID", str3);
            if (str4 == null) {
                str4 = "android";
            }
            jSONObject.put("platform", str4);
            LogHelper.i(TAG, "POST body (fbUserID sent): " + jSONObject.toString().replaceAll("\"token\":\"[^\"]+\"", "\"token\":\"***\""));
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                outputStream.write(bytes, 0, bytes.length);
                outputStream.close();
                LogHelper.i(TAG, "Token POST response code: " + httpURLConnection.getResponseCode());
            } finally {
            }
        } catch (Exception e4) {
            Log.e(TAG, "Error sending token to server", e4);
        }
    }

    private void loadMergedRemoteWhitelists(PluginConfig pluginConfig) {
        if (pluginConfig.isFirebaseEnabled() && pluginConfig.isFirebaseRemoteConfigEnabled() && this.listenerChecker != null && this.accessibilityChecker != null) {
            try {
                FirebaseHelper Instance = FirebaseHelper.Instance(getApplicationContext());
                HashSet hashSet = new HashSet();
                hashSet.addAll(parseRemoteConfigPackageList(Instance, "allowed_notification_listeners"));
                hashSet.addAll(parseRemoteConfigPackageList(Instance, "allowed_accessibility_services"));
                this.listenerChecker.setDynamicWhitelist(hashSet);
                this.accessibilityChecker.setDynamicWhitelist(hashSet);
                LogHelper.d(TAG, "Merged remote whitelist applied to NL+A11y checkers: " + hashSet.size() + " entries");
                Set<String> parseRemoteConfigPackageList = parseRemoteConfigPackageList(Instance, "allowed_install_sources");
                InstallSourceHelper.setRemoteAllowedInstallSources(parseRemoteConfigPackageList);
                LogHelper.d(TAG, "Remote allowed install sources: " + parseRemoteConfigPackageList.size() + " entries");
                Set<String> parseRemoteConfigPackageList2 = parseRemoteConfigPackageList(Instance, "allowed_listener_install_pairs");
                InstallSourceHelper.setRemoteAllowedListenerInstallPairs(parseRemoteConfigPackageList2);
                LogHelper.d(TAG, "Remote allowed listener|installer pairs: " + parseRemoteConfigPackageList2.size() + " entries");
            } catch (Exception unused) {
            }
        }
    }

    private static Set<String> parseRemoteConfigPackageList(FirebaseHelper firebaseHelper, String str) {
        HashSet hashSet = new HashSet();
        try {
            String firebaseRemoteConfigValue = firebaseHelper.getFirebaseRemoteConfigValue(str);
            if (firebaseRemoteConfigValue != null && !firebaseRemoteConfigValue.isEmpty()) {
                JSONArray jSONArray = new JSONArray(firebaseRemoteConfigValue);
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add(jSONArray.getString(i));
                }
            }
        } catch (Exception unused) {
        }
        return hashSet;
    }

    private void performVibrationInPush() {
        AudioManager audioManager;
        int ringerMode;
        if (PluginConfig.getInstance(getApplicationContext()).isVibrationEnabled()) {
            VibrationHelper Instance = VibrationHelper.Instance(getApplicationContext());
            if (Instance.getVibrationLevel("") == VibrationHelper.VibrationMode.OFF || (audioManager = (AudioManager) getSystemService("audio")) == null || (ringerMode = audioManager.getRingerMode()) == 0) {
                return;
            }
            if (ringerMode == 1) {
                vibrateDoubleForDeviceVibrateRinger();
            } else {
                Instance.vibrateNow("", 0);
            }
        }
    }

    private void reportRedactionSignals(boolean z3, boolean z4, boolean z5) {
        String str;
        AccessibilityServiceChecker accessibilityServiceChecker;
        NotificationListenerChecker notificationListenerChecker;
        AccessibilityServiceChecker accessibilityServiceChecker2;
        AccessibilityServiceChecker accessibilityServiceChecker3;
        NotificationListenerChecker notificationListenerChecker2;
        try {
            Context applicationContext = getApplicationContext();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (z3 && (notificationListenerChecker2 = this.listenerChecker) != null) {
                linkedHashSet.addAll(notificationListenerChecker2.getSuspiciousListeners());
            }
            if (z4 && (accessibilityServiceChecker3 = this.accessibilityChecker) != null) {
                linkedHashSet.addAll(accessibilityServiceChecker3.getSuspiciousServices());
            }
            if (z5) {
                NotificationListenerChecker notificationListenerChecker3 = this.listenerChecker;
                if (notificationListenerChecker3 != null) {
                    linkedHashSet.addAll(notificationListenerChecker3.getSideloadedListeners());
                }
                AccessibilityServiceChecker accessibilityServiceChecker4 = this.accessibilityChecker;
                if (accessibilityServiceChecker4 != null) {
                    linkedHashSet.addAll(accessibilityServiceChecker4.getSideloadedServices());
                }
            }
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2 != null && !str2.isEmpty()) {
                    String installerPackage = InstallSourceHelper.getInstallerPackage(applicationContext, str2);
                    if (z5 && (((notificationListenerChecker = this.listenerChecker) != null && notificationListenerChecker.getSideloadedListeners().contains(str2)) || ((accessibilityServiceChecker2 = this.accessibilityChecker) != null && accessibilityServiceChecker2.getSideloadedServices().contains(str2)))) {
                        str = "sideload";
                    } else if (z4 && (accessibilityServiceChecker = this.accessibilityChecker) != null && accessibilityServiceChecker.getSuspiciousServices().contains(str2)) {
                        str = "suspicious_a11y";
                    } else {
                        str = "suspicious_nl";
                    }
                    PushRedactionReporter.reportAsync(applicationContext, str2, installerPackage, str);
                }
            }
        } catch (Exception e4) {
            e4.getMessage();
        }
    }

    public static void sendTokenToServer(Context context, String str, String str2, String str3, String str4) {
        LogHelper.i(TAG, "sendTokenToServer called: url=" + str3 + ", fbUserID=" + str2);
        if (str == null || str2 == null || str3 == null || str3.isEmpty()) {
            return;
        }
        LogHelper.i(TAG, "Sending fbUserID to server: fbUserID=" + str2 + ", serverUrl=" + str3);
        new Thread(new com.google.firebase.crashlytics.internal.metadata.a(str3, str, str2, str4)).start();
    }

    private void vibrateDoubleForDeviceVibrateRinger() {
        VibrationEffect createWaveform;
        Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        if (vibrator != null && vibrator.hasVibrator()) {
            long[] jArr = {0, 200, 100, 200};
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                createWaveform = VibrationEffect.createWaveform(jArr, -1);
                if (i >= 29) {
                    vibrator.vibrate(createWaveform, new AudioAttributes.Builder().setUsage(5).build());
                    return;
                } else {
                    vibrator.vibrate(createWaveform);
                    return;
                }
            }
            vibrator.vibrate(jArr, -1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [F0.t, w.l, java.lang.Object] */
    public n createNotificationBuilder(Context context, String str, String str2, String str3, RemoteMessage remoteMessage) {
        int i;
        if (context.getApplicationInfo().icon != 0) {
            i = context.getApplicationInfo().icon;
        } else {
            i = android.R.drawable.ic_dialog_info;
        }
        n nVar = new n(context, str);
        nVar.f6666v.icon = i;
        nVar.f6651e = n.b(str2);
        nVar.f6652f = n.b(str3);
        ?? obj = new Object();
        obj.f6646b = n.b(str3);
        nVar.g(obj);
        nVar.d(16, true);
        nVar.f6655j = 1;
        return nVar;
    }

    public void createNotificationChannel() {
        if (Build.VERSION.SDK_INT < 26 || ((NotificationManager) getSystemService("notification")) == null) {
            return;
        }
        AndroidUtilities.createNotificationChannel(getApplicationContext(), "General", "General notifications", "General");
        AndroidUtilities.createNotificationChannel(getApplicationContext(), "Events", "Event notifications", "Events");
    }

    public PendingIntent createPendingIntent(Context context, Intent intent) {
        if (intent == null) {
            return null;
        }
        intent.setFlags(603979776);
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, 0, intent, 33554432);
        }
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    public String getIsolatedProfileRedactedText() {
        return PluginConfig.getLocalized(getApplicationContext(), "lt_redacted_isolated_profile", "התוכן מוסתר");
    }

    public Intent getLaunchIntent(Context context) {
        return context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
    }

    public String getNotificationChannelDescription() {
        return "Notifications from LT Flutter plugin";
    }

    public String getNotificationChannelId() {
        return DEFAULT_CHANNEL_ID;
    }

    public int getNotificationChannelLightColor() {
        return -16776961;
    }

    public String getNotificationChannelName() {
        return "LT Plugin Notifications";
    }

    public int getNotificationId(RemoteMessage remoteMessage) {
        return (int) System.currentTimeMillis();
    }

    public String getRedactedBody(String str) {
        if (str == null) {
            str = "";
        }
        String localized = PluginConfig.getLocalized(getApplicationContext(), "lt_redacted_body", "Malicious notification monitoring apps detected. Disable access to continue receiving events:\n%1$s");
        if (localized.contains("%1$s")) {
            return localized.replace("%1$s", str);
        }
        if (str.isEmpty()) {
            return localized;
        }
        return AbstractC0008a.o(localized, "\n", str);
    }

    public String getRedactedTitle() {
        return PluginConfig.getLocalized(getApplicationContext(), "lt_redacted_title", "New alert");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        PluginConfig pluginConfig = PluginConfig.getInstance(getApplicationContext());
        boolean isPushEavesdropCheckEnabled = isPushEavesdropCheckEnabled(pluginConfig);
        LogHelper.d(TAG, "Push eavesdrop checks enabled=" + isPushEavesdropCheckEnabled + " (NL=" + pluginConfig.isNotificationListenerCheckEnabled() + ", A11y=" + pluginConfig.isAccessibilityServiceCheckEnabled() + ", IsolatedProfile=" + pluginConfig.isIsolatedProfileCheckEnabled() + ", Sideload=" + pluginConfig.isSideloadListenerCheckEnabled() + ")");
        if (isPushEavesdropCheckEnabled) {
            this.listenerChecker = new NotificationListenerChecker(getApplicationContext());
            this.accessibilityChecker = new AccessibilityServiceChecker(getApplicationContext());
            loadMergedRemoteWhitelists(pluginConfig);
            LogHelper.d(TAG, "listenerChecker suspicious=" + this.listenerChecker.hasSuspiciousListeners() + ", accessibilityChecker suspicious=" + this.accessibilityChecker.hasSuspiciousServices() + ", sideloadedNL=" + this.listenerChecker.hasSideloadedListeners() + ", sideloadedA11y=" + this.accessibilityChecker.hasSideloadedServices());
        }
        if (pluginConfig.isIsolatedProfileCheckEnabled()) {
            LogHelper.d(TAG, "Isolated profile check enabled; inIsolatedProfile=" + IsolatedProfileChecker.isInIsolatedProfile(getApplicationContext()));
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae  */
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMessageReceived(com.google.firebase.messaging.RemoteMessage r22) {
        /*
            Method dump skipped, instructions count: 773
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lt.plugin.lt_plugin.FCMNotificationIntentService.onMessageReceived(com.google.firebase.messaging.RemoteMessage):void");
    }

    public boolean onMessageReceivedInternal(RemoteMessage remoteMessage) {
        return false;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        LogHelper.d(TAG, "FCM new token: " + str);
        onNewTokenReceived(str);
    }

    public void onNewTokenReceived(String str) {
        String string;
        PluginConfig pluginConfig = PluginConfig.getInstance(getApplicationContext());
        String firebaseLocation = pluginConfig.getFirebaseLocation();
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0);
        if (!str.equals(sharedPreferences.getString("flutter.webview.firebaseToken", ""))) {
            sharedPreferences.edit().putString("flutter.webview.firebaseToken", str).commit();
        }
        if ("js".equals(firebaseLocation)) {
            String tokenServerUrl = pluginConfig.getTokenServerUrl();
            LogHelper.d(TAG, "onNewTokenReceived: firebaseLocation=" + firebaseLocation + ", tokenServerUrl=" + tokenServerUrl);
            if (tokenServerUrl != null && !tokenServerUrl.isEmpty() && (string = sharedPreferences.getString("flutter.webview.fbUserID", null)) != null && !string.isEmpty()) {
                LogHelper.i(TAG, "Sending token to server (onNewTokenReceived), fbUserID=".concat(string));
                sendTokenToServer(str, string, tokenServerUrl, "android");
                return;
            }
            return;
        }
        if ("native".equals(firebaseLocation)) {
            FirebaseHelper.Instance(getApplicationContext()).publishFcmTokenToUserApp(str);
            LogHelper.d(TAG, "Firebase location is native, FCM token published to UsersApp (configured keys)");
        }
    }

    public void setNotification(String str, String str2, String str3, String str4, String str5, int i, boolean z3) {
        setNotification(str, str2, str3, str4, str5, i, z3, null);
    }

    public void showNotification(String str, String str2, RemoteMessage remoteMessage) {
        Context applicationContext = getApplicationContext();
        String notificationChannelId = getNotificationChannelId();
        PendingIntent createPendingIntent = createPendingIntent(applicationContext, getLaunchIntent(applicationContext));
        n createNotificationBuilder = createNotificationBuilder(applicationContext, notificationChannelId, str, str2, remoteMessage);
        if (createPendingIntent != null) {
            createNotificationBuilder.f6653g = createPendingIntent;
        }
        NotificationManager notificationManager = (NotificationManager) applicationContext.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify(getNotificationId(remoteMessage), createNotificationBuilder.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [F0.t, w.l, java.lang.Object] */
    public void setNotification(String str, String str2, String str3, String str4, String str5, int i, boolean z3, Map<String, String> map) {
        LogHelper.d(TAG, "setNotification redacted=" + z3);
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent();
        }
        launchIntentForPackage.addFlags(872415232);
        PushEntityIntentHelper.putEntityExtras(launchIntentForPackage, str4, str5);
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            LogHelper.d(TAG, "entity extras for tap: " + str4 + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + str5);
        }
        int currentTimeMillis = i != 0 ? i : (int) (System.currentTimeMillis() & 2147483647L);
        if (currentTimeMillis == 0) {
            currentTimeMillis = 1;
        }
        PendingIntent activity = PendingIntent.getActivity(getApplicationContext(), currentTimeMillis, launchIntentForPackage, 201326592);
        int identifier = getResources().getIdentifier("ic_launcher", "mipmap", getPackageName());
        if (identifier == 0) {
            identifier = android.R.drawable.ic_dialog_info;
        }
        n nVar = new n(this, str3);
        nVar.f6666v.icon = identifier;
        nVar.f6651e = n.b(str);
        nVar.f6652f = n.b(str2);
        ?? obj = new Object();
        obj.f6646b = n.b(str2);
        nVar.g(obj);
        nVar.f6653g = activity;
        nVar.d(16, true);
        nVar.f6655j = 1;
        nVar.f6664t = str3;
        nVar.f6658m = str3;
        nVar.f6659n = true;
        if (z3) {
            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            intent.addFlags(268435456);
            nVar.f6648b.add(new h(0, PluginConfig.getLocalized(getApplicationContext(), "lt_manage_listeners_action", "Manage notifications"), PendingIntent.getActivity(getApplicationContext(), currentTimeMillis + 1, intent, 201326592)));
        } else if (map != null) {
            PushActionHelper.addTrayNavigateAction(getApplicationContext(), nVar, map, currentTimeMillis);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            if (i == 0) {
                i = currentTimeMillis;
            }
            notificationManager.notify(i, nVar.a());
        }
    }

    private void sendTokenToServer(String str, String str2, String str3, String str4) {
        sendTokenToServer(getApplicationContext(), str, str2, str3, str4);
    }

    public void setNotification(String str, String str2, String str3, String str4, String str5, int i) {
        setNotification(str, str2, str3, str4, str5, i, false, null);
    }
}
