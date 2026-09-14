package com.lt.plugin.lt_plugin.services;

import F0.AbstractC0008a;
import android.R;
import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import com.lt.plugin.lt_plugin.config.PluginConfig;
import com.lt.plugin.lt_plugin.utils.LogHelper;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.tika.metadata.HttpHeaders;
import org.json.JSONObject;
import w.n;

/* loaded from: classes.dex */
public class LocationService extends Service {
    private static final String CHANNEL_ID = "LocationServiceChannel";
    private static final int NOTIFICATION_ID = 2;
    private static final String TAG = "LocationService";
    private String appName;
    private FusedLocationProviderClient fusedLocationClient;
    private LocationCallback locationCallback;
    private SharedPreferences mPref;
    private NotificationManager notificationManager;
    private PluginConfig pluginConfig;
    private SharedPreferences webviewPrefs;
    private TrackingMode trackingMode = TrackingMode.OFF;
    private String lastLocationUpdateTime = "";

    /* renamed from: com.lt.plugin.lt_plugin.services.LocationService$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends LocationCallback {
        public AnonymousClass1() {
        }

        public static /* synthetic */ void lambda$onLocationResult$0(String str, Map map) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str + "/me/updateLocation").openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
                httpURLConnection.setDoOutput(true);
                JSONObject jSONObject = new JSONObject(map);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                    outputStream.write(bytes, 0, bytes.length);
                    outputStream.close();
                    LogHelper.i(LocationService.TAG, "updateLocation POST response code: " + httpURLConnection.getResponseCode());
                } finally {
                }
            } catch (Exception e4) {
                Log.e(LocationService.TAG, "Error updating location via POST", e4);
            }
        }

        @Override // com.google.android.gms.location.LocationCallback
        public void onLocationResult(LocationResult locationResult) {
            if (locationResult != null) {
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        if (LocationService.this.pluginConfig.isMockLocationBlockingEnabled() && LocationService.isMockLocation(location)) {
                            location.getLatitude();
                            location.getLongitude();
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.put("latitude", Double.valueOf(location.getLatitude()));
                            hashMap.put("longitude", Double.valueOf(location.getLongitude()));
                            if (LocationService.this.mPref != null && LocationService.this.mPref.getString("flutter.system.site_url", null) != null && LocationService.this.webviewPrefs.getString("flutter.webview.fbUserID", null) != null) {
                                String string = LocationService.this.webviewPrefs.getString("flutter.webview.fbUserID", "");
                                String string2 = LocationService.this.mPref.getString("flutter.system.site_url", null);
                                hashMap.put("fbUserID", string);
                                new Thread(new h(string2, new HashMap(hashMap))).start();
                            } else if (LocationService.this.webviewPrefs.getString("flutter.webview.fbUserID", null) == null || LocationService.this.webviewPrefs.getString("flutter.webview.fbUserID", "").isEmpty()) {
                                LocationService.this.stopSelf();
                                return;
                            }
                            LocationService.this.lastLocationUpdateTime = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy", Locale.getDefault()).format(new Date());
                            LocationService.this.updateNotification();
                            LogHelper.i(LocationService.TAG, "Location update: " + location.getLatitude() + "," + location.getLongitude() + " fbUserID:" + LocationService.this.webviewPrefs.getString("flutter.webview.fbUserID", "") + " site_url:" + LocationService.this.mPref.getString("flutter.system.site_url", null));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public enum TrackingMode {
        LOW,
        BALANCED,
        OFF
    }

    private LocationRequest buildLocationRequestForMode(TrackingMode trackingMode) {
        LocationRequest.Builder minUpdateIntervalMillis;
        if (trackingMode.ordinal() != 0) {
            minUpdateIntervalMillis = new LocationRequest.Builder(102, 300000L).setMinUpdateDistanceMeters(50.0f).setMinUpdateIntervalMillis(150000L);
        } else {
            minUpdateIntervalMillis = new LocationRequest.Builder(102, 600000L).setMinUpdateDistanceMeters(200.0f).setMinUpdateIntervalMillis(300000L);
        }
        return minUpdateIntervalMillis.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [F0.t, w.l, java.lang.Object] */
    private Notification buildNotification(TrackingMode trackingMode) {
        String localized;
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent();
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, launchIntentForPackage, 201326592);
        int ordinal = trackingMode.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                localized = PluginConfig.getLocalized(this, "lt_tracking_off", "Off");
            } else {
                localized = PluginConfig.getLocalized(this, "lt_tracking_balanced", "Balanced");
            }
        } else {
            localized = PluginConfig.getLocalized(this, "lt_tracking_low", "Low");
        }
        String localized2 = PluginConfig.getLocalized(this, "lt_tracking_status", "Tracking Status: %1$s", localized);
        if (!this.lastLocationUpdateTime.isEmpty()) {
            localized2 = AbstractC0008a.o(localized2, "\n", PluginConfig.getLocalized(this, "lt_last_location_update", "Last update: %1$s", this.lastLocationUpdateTime));
        }
        int identifier = getResources().getIdentifier("ic_launcher", "mipmap", getPackageName());
        if (identifier == 0) {
            identifier = R.drawable.ic_menu_mylocation;
        }
        n nVar = new n(this, CHANNEL_ID);
        nVar.f6666v.icon = identifier;
        nVar.f6651e = n.b(this.appName + " - " + PluginConfig.getLocalized(this, "lt_online", "Online"));
        nVar.f6652f = n.b(localized2);
        ?? obj = new Object();
        obj.f6646b = n.b(localized2);
        nVar.g(obj);
        nVar.f6653g = activity;
        nVar.d(2, true);
        return nVar.a();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            com.google.android.gms.common.wrappers.a.s();
            NotificationChannel z3 = a.z(this.appName);
            z3.enableLights(true);
            z3.setSound(null, null);
            z3.setImportance(2);
            z3.setShowBadge(false);
            NotificationManager notificationManager = this.notificationManager;
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(z3);
            }
        }
    }

    public static void getLastLocationAsync(Context context, Consumer<Location> consumer) {
        if (consumer == null) {
            return;
        }
        try {
            LocationServices.getFusedLocationProviderClient(context).getLastLocation().addOnCompleteListener(new J0.d(consumer, 18));
        } catch (SecurityException e4) {
            Log.e(TAG, "SecurityException getting current location", e4);
            consumer.accept(null);
        }
    }

    private void initLocationCallback() {
        this.locationCallback = new AnonymousClass1();
    }

    public static boolean isMockLocation(Location location) {
        boolean isMock;
        if (location == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            isMock = location.isMock();
            return isMock;
        }
        return location.isFromMockProvider();
    }

    public static /* synthetic */ void lambda$getLastLocationAsync$0(Consumer consumer, Task task) {
        Location location;
        if (task.isSuccessful() && task.getResult() != null) {
            location = (Location) task.getResult();
        } else {
            location = null;
        }
        consumer.accept(location);
    }

    private void startLocationUpdates() {
        try {
            stopLocationUpdates();
            this.fusedLocationClient.requestLocationUpdates(buildLocationRequestForMode(this.trackingMode), this.locationCallback, (Looper) null);
        } catch (SecurityException e4) {
            Log.e(TAG, "SecurityException starting location updates", e4);
            stopSelf();
        }
    }

    private void stopLocationUpdates() {
        LocationCallback locationCallback;
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        if (fusedLocationProviderClient != null && (locationCallback = this.locationCallback) != null) {
            fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        }
    }

    public void updateNotification() {
        try {
            Notification buildNotification = buildNotification(this.trackingMode);
            int i = Build.VERSION.SDK_INT;
            if (i >= 31) {
                try {
                    startForeground(2, buildNotification, 8);
                } catch (ForegroundServiceStartNotAllowedException unused) {
                    stopForeground(true);
                    stopSelf();
                }
            } else if (i >= 29) {
                startForeground(2, buildNotification, 8);
            } else {
                startForeground(2, buildNotification);
            }
        } catch (Exception e4) {
            Log.e(TAG, "Failed to start foreground service", e4);
            stopLocationUpdates();
            stopForeground(true);
            stopSelf();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogHelper.i(TAG, "onCreate");
        this.pluginConfig = PluginConfig.getInstance(getApplicationContext());
        try {
            PackageManager packageManager = getPackageManager();
            this.appName = packageManager.getApplicationLabel(packageManager.getApplicationInfo(getPackageName(), 0)).toString();
        } catch (Exception unused) {
            this.appName = "Location Service";
        }
        this.notificationManager = (NotificationManager) getSystemService("notification");
        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        this.mPref = getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0);
        this.webviewPrefs = getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0);
        createNotificationChannel();
        initLocationCallback();
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogHelper.i(TAG, "onDestroy");
        super.onDestroy();
        stopLocationUpdates();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i3) {
        if (!this.pluginConfig.isLocationServiceEnabled()) {
            LogHelper.i(TAG, "Location service disabled in config");
            stopSelf();
            return 2;
        }
        String string = this.webviewPrefs.getString("flutter.webview.trackingMode", "OFF");
        LogHelper.i(TAG, "onStartCommand " + string);
        try {
            this.trackingMode = TrackingMode.valueOf(string.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException unused) {
            this.trackingMode = TrackingMode.OFF;
        }
        if (this.trackingMode == TrackingMode.OFF) {
            stopLocationUpdates();
            stopSelf();
            return 2;
        }
        updateNotification();
        startLocationUpdates();
        return 1;
    }
}
