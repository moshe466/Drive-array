package com.lt.plugin.lt_plugin.utils;

import A1.f;
import A1.i;
import F0.Q2;
import F0.RunnableC0064o;
import J.C0119g;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.lt.plugin.lt_plugin.config.PluginConfig;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FirebaseHelper {
    private static FirebaseHelper _instance;
    private DatabaseReference _dataref;
    private FirebaseAuth _fireAuth;
    private FirebaseRemoteConfig _remoteConfig;
    private FirebaseAuth.AuthStateListener authStateListener;
    private Context context;
    private String listenedFbUserID;
    public final Task<Object> onFirebaseRemoteConfigComplete;
    private PluginConfig pluginConfig;
    private ValueEventListener usersAppRealtimeListener;
    private final String TAG = "FirebaseHelper";
    private volatile boolean suppressListenerDuringLogin = false;

    /* renamed from: com.lt.plugin.lt_plugin.utils.FirebaseHelper$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ValueEventListener {
        public AnonymousClass1() {
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
            databaseError.getMessage();
            if (FirebaseHelper.isRtdbPermissionDenied(databaseError.toException())) {
                FirebaseHelper.this.endSessionInvalidUsersApp();
            }
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(DataSnapshot dataSnapshot) {
            Object obj;
            if (FirebaseHelper.this.suppressListenerDuringLogin) {
                return;
            }
            if (dataSnapshot != null && dataSnapshot.exists()) {
                JSONObject jSONObject = new JSONObject();
                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                    try {
                        String key = dataSnapshot2.getKey();
                        if (key != null) {
                            Object value = dataSnapshot2.getValue((Class<Object>) Object.class);
                            if (value == null) {
                                value = JSONObject.NULL;
                            }
                            jSONObject.put(key, value);
                        }
                    } catch (JSONException e4) {
                        Log.e("FirebaseHelper", "UsersApp json", e4);
                    }
                }
                String str = null;
                try {
                    if (jSONObject.has("sfID") && (obj = jSONObject.get("sfID")) != null) {
                        str = obj.toString();
                    }
                } catch (JSONException e5) {
                    Log.e("FirebaseHelper", "UsersApp sfID", e5);
                }
                if (str != null && !str.isEmpty()) {
                    FirebaseHelper.this.context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).edit().putString("flutter.webview.fbData", jSONObject.toString()).apply();
                    LogHelper.d("FirebaseHelper", "UsersApp: fbData updated (realtime)");
                    SessionPreferencesHelper.notifyReloadSharedPreferences();
                    return;
                } else {
                    LogHelper.d("FirebaseHelper", "UsersApp: sfID missing — ending session");
                    FirebaseHelper.this.endSessionInvalidUsersApp();
                    return;
                }
            }
            LogHelper.d("FirebaseHelper", "UsersApp: node removed — ending session");
            FirebaseHelper.this.endSessionInvalidUsersApp();
        }
    }

    private FirebaseHelper(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        PluginConfig pluginConfig = PluginConfig.getInstance(applicationContext);
        this.pluginConfig = pluginConfig;
        if (!pluginConfig.isFirebaseEnabled()) {
            this.onFirebaseRemoteConfigComplete = Tasks.forResult(null);
        } else {
            this.onFirebaseRemoteConfigComplete = remoteConfig().fetchAndActivate().continueWith(new a(this));
        }
    }

    public static FirebaseHelper Instance(Context context) {
        if (_instance == null) {
            _instance = new FirebaseHelper(context);
        }
        return _instance;
    }

    private void attachUsersAppRealtimeListener(String str) {
        if (shouldUseRealtimeListener()) {
            if (str.equals(this.listenedFbUserID) && this.usersAppRealtimeListener != null) {
                return;
            }
            detachUsersAppRealtimeListener();
            this.listenedFbUserID = str;
            LogHelper.d("FirebaseHelper", "UsersApp: attaching realtime listener for ".concat(str));
            this.usersAppRealtimeListener = new ValueEventListener() { // from class: com.lt.plugin.lt_plugin.utils.FirebaseHelper.1
                public AnonymousClass1() {
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                    databaseError.getMessage();
                    if (FirebaseHelper.isRtdbPermissionDenied(databaseError.toException())) {
                        FirebaseHelper.this.endSessionInvalidUsersApp();
                    }
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Object obj;
                    if (FirebaseHelper.this.suppressListenerDuringLogin) {
                        return;
                    }
                    if (dataSnapshot != null && dataSnapshot.exists()) {
                        JSONObject jSONObject = new JSONObject();
                        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                            try {
                                String key = dataSnapshot2.getKey();
                                if (key != null) {
                                    Object value = dataSnapshot2.getValue((Class<Object>) Object.class);
                                    if (value == null) {
                                        value = JSONObject.NULL;
                                    }
                                    jSONObject.put(key, value);
                                }
                            } catch (JSONException e4) {
                                Log.e("FirebaseHelper", "UsersApp json", e4);
                            }
                        }
                        String str2 = null;
                        try {
                            if (jSONObject.has("sfID") && (obj = jSONObject.get("sfID")) != null) {
                                str2 = obj.toString();
                            }
                        } catch (JSONException e5) {
                            Log.e("FirebaseHelper", "UsersApp sfID", e5);
                        }
                        if (str2 != null && !str2.isEmpty()) {
                            FirebaseHelper.this.context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).edit().putString("flutter.webview.fbData", jSONObject.toString()).apply();
                            LogHelper.d("FirebaseHelper", "UsersApp: fbData updated (realtime)");
                            SessionPreferencesHelper.notifyReloadSharedPreferences();
                            return;
                        } else {
                            LogHelper.d("FirebaseHelper", "UsersApp: sfID missing — ending session");
                            FirebaseHelper.this.endSessionInvalidUsersApp();
                            return;
                        }
                    }
                    LogHelper.d("FirebaseHelper", "UsersApp: node removed — ending session");
                    FirebaseHelper.this.endSessionInvalidUsersApp();
                }
            };
            firebaseDatabase().child("UsersApp").child(str).addValueEventListener(this.usersAppRealtimeListener);
        }
    }

    private void detachUsersAppRealtimeListener() {
        if (this.usersAppRealtimeListener != null && this.listenedFbUserID != null) {
            try {
                firebaseDatabase().child("UsersApp").child(this.listenedFbUserID).removeEventListener(this.usersAppRealtimeListener);
            } catch (Exception unused) {
            }
        }
        this.usersAppRealtimeListener = null;
        this.listenedFbUserID = null;
    }

    public void endSessionInvalidUsersApp() {
        detachUsersAppRealtimeListener();
        boolean z3 = false;
        String string = this.context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).getString("flutter.webview.JWTToken", null);
        if (string != null && !string.isEmpty()) {
            z3 = true;
        }
        try {
            if (firebaseAuth().getCurrentUser() != null) {
                firebaseAuth().signOut();
            }
        } catch (Exception unused) {
        }
        if (z3) {
            LogHelper.d("FirebaseHelper", "UsersApp: active session found — full clear + reload");
            SessionPreferencesHelper.clearAllSessionData(this.context);
        } else {
            LogHelper.d("FirebaseHelper", "UsersApp: no active session — quiet cleanup (no reload)");
        }
    }

    public static boolean isRtdbPermissionDenied(Exception exc) {
        while (exc != null) {
            String message = exc.getMessage();
            if (message != null && (message.contains("PERMISSION_DENIED") || message.contains("DatabaseError: Permission") || message.contains("Client doesn't have permission"))) {
                return true;
            }
            Throwable cause = exc.getCause();
            if (cause instanceof Exception) {
                exc = (Exception) cause;
            } else {
                exc = null;
            }
        }
        return false;
    }

    public static /* synthetic */ String lambda$getToFbUserAsync$10(Task task) {
        DataSnapshot dataSnapshot;
        if (!task.isSuccessful() || (dataSnapshot = (DataSnapshot) task.getResult()) == null || dataSnapshot.getValue() == null) {
            return null;
        }
        return dataSnapshot.getValue().toString();
    }

    public /* synthetic */ void lambda$logOut$3() {
        firebaseAuth().signOut();
        SessionPreferencesHelper.clearAllSessionData(this.context);
    }

    public /* synthetic */ void lambda$logOut$4(Runnable runnable, Task task) {
        if (!task.isSuccessful()) {
            task.getException();
        }
        runnable.run();
    }

    public /* synthetic */ void lambda$loginAnonimus$5(FirebaseUser firebaseUser) {
        this.suppressListenerDuringLogin = false;
        attachUsersAppRealtimeListener(firebaseUser.getUid());
        Instance(this.context).registerToken();
    }

    public /* synthetic */ void lambda$loginAnonimus$6(String str, Task task) {
        if (task.isSuccessful()) {
            FirebaseUser currentUser = firebaseAuth().getCurrentUser();
            if (currentUser != null) {
                this.context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).edit().putString("flutter.webview.fbUserID", currentUser.getUid()).commit();
                SessionPreferencesHelper.notifyReloadSharedPreferences();
                if (str != null && !str.isEmpty()) {
                    saveToFbUser("sfID", str, new RunnableC0064o(8, this, currentUser));
                    return;
                } else {
                    this.suppressListenerDuringLogin = false;
                    Instance(this.context).registerToken();
                    return;
                }
            }
            return;
        }
        this.suppressListenerDuringLogin = false;
        Log.e("FirebaseHelper", "Anonymous login failed", task.getException());
    }

    public /* synthetic */ void lambda$loginAnonimusMdm$7(String str, Task task) {
        this.suppressListenerDuringLogin = false;
        if (task.isSuccessful()) {
            attachUsersAppRealtimeListener(str);
            Instance(this.context).registerToken();
        } else {
            task.getException();
        }
    }

    public /* synthetic */ void lambda$loginAnonimusMdm$8(String str, Task task) {
        if (task.isSuccessful()) {
            FirebaseUser currentUser = firebaseAuth().getCurrentUser();
            if (currentUser != null) {
                SharedPreferences sharedPreferences = this.context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0);
                String uid = currentUser.getUid();
                sharedPreferences.edit().putString("flutter.webview.fbUserID", uid).commit();
                SessionPreferencesHelper.notifyReloadSharedPreferences();
                String iMEIDeviceId = AndroidUtilities.getIMEIDeviceId(this.context);
                HashMap hashMap = new HashMap();
                if (str != null && !str.isEmpty()) {
                    hashMap.put("sfID", str);
                }
                if (iMEIDeviceId != null && !iMEIDeviceId.isEmpty()) {
                    hashMap.put("mdmimei", iMEIDeviceId);
                }
                if (!hashMap.isEmpty()) {
                    firebaseDatabase().child("/UsersApp/" + uid).updateChildren(hashMap).addOnCompleteListener(new b(this, uid, 2));
                    return;
                }
                this.suppressListenerDuringLogin = false;
                attachUsersAppRealtimeListener(uid);
                Instance(this.context).registerToken();
                return;
            }
            return;
        }
        this.suppressListenerDuringLogin = false;
        Log.e("FirebaseHelper", "Anonymous login failed (MDM)", task.getException());
    }

    public /* synthetic */ Object lambda$new$0(Task task) {
        try {
            if (task.isSuccessful()) {
                LogHelper.d("FirebaseHelper", "Remote config fetched successfully");
            }
            return task.getResult();
        } catch (Exception e4) {
            Log.e("FirebaseHelper", "Remote config fetch error: " + e4.getMessage());
            return Boolean.FALSE;
        }
    }

    public /* synthetic */ void lambda$registerAuthStateListener$9(FirebaseAuth firebaseAuth) {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null && !this.suppressListenerDuringLogin) {
            attachUsersAppRealtimeListener(currentUser.getUid());
        } else if (currentUser == null) {
            detachUsersAppRealtimeListener();
        }
    }

    public /* synthetic */ void lambda$registerToken$1(Task task) {
        if (!task.isSuccessful()) {
            task.getException();
            return;
        }
        String str = (String) task.getResult();
        if (str != null && !str.isEmpty() && "native".equals(this.pluginConfig.getFirebaseLocation())) {
            publishFcmTokenToUserApp(str);
        }
    }

    public /* synthetic */ void lambda$saveToFbUser$2(Runnable runnable, String str, Task task) {
        LogHelper.d("FirebaseHelper", "saveToFbUser: " + task);
        if (task.isSuccessful()) {
            if (runnable != null) {
                runnable.run();
            }
        } else {
            task.getException();
            if (runnable != null) {
                Instance(this.context).registerToken();
            }
        }
    }

    private void registerAuthStateListener() {
        if (this.authStateListener != null) {
            return;
        }
        this.authStateListener = new FirebaseAuth.AuthStateListener() { // from class: com.lt.plugin.lt_plugin.utils.c
            @Override // com.google.firebase.auth.FirebaseAuth.AuthStateListener
            public final void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                FirebaseHelper.this.lambda$registerAuthStateListener$9(firebaseAuth);
            }
        };
        firebaseAuth().addAuthStateListener(this.authStateListener);
    }

    private boolean shouldUseRealtimeListener() {
        if (this.pluginConfig.isFirebaseEnabled() && this.pluginConfig.isFirebaseAuthEnabled() && this.pluginConfig.isFirebaseDataServiceEnabled() && "native".equals(this.pluginConfig.getFirebaseLocation())) {
            return true;
        }
        return false;
    }

    public FirebaseAuth firebaseAuth() {
        if (this._fireAuth == null) {
            this._fireAuth = FirebaseAuth.getInstance();
        }
        return this._fireAuth;
    }

    public DatabaseReference firebaseDatabase() {
        if (this._dataref == null) {
            this._dataref = FirebaseDatabase.getInstance().getReference();
        }
        return this._dataref;
    }

    public Map<String, FirebaseRemoteConfigValue> getAllRemoteConfigValues() {
        if (!this.pluginConfig.isFirebaseRemoteConfigEnabled()) {
            return null;
        }
        return remoteConfig().getAll();
    }

    public String getFirebaseRemoteConfigValue(String str) {
        String string;
        if (!this.pluginConfig.isFirebaseRemoteConfigEnabled() || (string = remoteConfig().getString(str)) == null || string.isEmpty()) {
            return null;
        }
        return string;
    }

    public String getFirebaseRemoteConfigValueOrDefault(String str, Object obj) {
        String firebaseRemoteConfigValue = getFirebaseRemoteConfigValue(str);
        if (firebaseRemoteConfigValue == null) {
            return obj.toString();
        }
        return firebaseRemoteConfigValue;
    }

    public String getToFbUser(String str) {
        String string;
        if (this.pluginConfig.isFirebaseEnabled() && (string = this.context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).getString("flutter.webview.fbUserID", null)) != null) {
            LogHelper.d("FirebaseHelper", "getToFbUser: " + str + " for user: " + string);
        }
        return null;
    }

    public Task<String> getToFbUserAsync(String str) {
        if (!this.pluginConfig.isFirebaseEnabled()) {
            return Tasks.forResult(null);
        }
        String string = this.context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).getString("flutter.webview.fbUserID", null);
        if (string != null && !string.isEmpty()) {
            return firebaseDatabase().child("/UsersApp/" + string + RemoteSettings.FORWARD_SLASH_STRING + str).get().continueWith(new C0119g(28));
        }
        return Tasks.forResult(null);
    }

    public void logOut() {
        FirebaseUser currentUser;
        if (this.pluginConfig.isFirebaseEnabled() && this.pluginConfig.isFirebaseAuthEnabled()) {
            LogHelper.d("FirebaseHelper", "logOut");
            detachUsersAppRealtimeListener();
            String string = this.context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).getString("flutter.webview.fbUserID", null);
            if (string == null && (currentUser = firebaseAuth().getCurrentUser()) != null) {
                string = currentUser.getUid();
            }
            Q2 q22 = new Q2(this, 7);
            if (string != null) {
                LogHelper.d("FirebaseHelper", string);
                firebaseDatabase().child("/UsersApp/".concat(string)).removeValue().addOnCompleteListener(new f(5, this, q22));
            } else {
                q22.run();
            }
        }
    }

    public void loginAnonimus(String str) {
        if (this.pluginConfig.isFirebaseEnabled() && this.pluginConfig.isFirebaseAuthEnabled()) {
            this.suppressListenerDuringLogin = true;
            firebaseAuth().signInAnonymously().addOnCompleteListener(new b(this, str, 1));
        }
    }

    public void loginAnonimusMdm(String str) {
        if (this.pluginConfig.isFirebaseEnabled() && this.pluginConfig.isFirebaseAuthEnabled()) {
            this.suppressListenerDuringLogin = true;
            firebaseAuth().signInAnonymously().addOnCompleteListener(new b(this, str, 0));
        }
    }

    public void publishFcmTokenToUserApp(String str) {
        if (str != null && !str.isEmpty() && this.pluginConfig.isFirebaseEnabled() && "native".equals(this.pluginConfig.getFirebaseLocation())) {
            this.context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).edit().putString("flutter.webview.firebaseToken", str).apply();
            String fcmTokenDbKeyAndroid = this.pluginConfig.getFcmTokenDbKeyAndroid();
            if (fcmTokenDbKeyAndroid == null || fcmTokenDbKeyAndroid.isEmpty()) {
                fcmTokenDbKeyAndroid = "androidToken";
            }
            saveToFbUser(fcmTokenDbKeyAndroid, str);
            String fcmTokenDbKeyAndroidLegacy = this.pluginConfig.getFcmTokenDbKeyAndroidLegacy();
            if (fcmTokenDbKeyAndroidLegacy != null && !fcmTokenDbKeyAndroidLegacy.isEmpty() && !fcmTokenDbKeyAndroidLegacy.equals(fcmTokenDbKeyAndroid)) {
                saveToFbUser(fcmTokenDbKeyAndroidLegacy, str);
            }
        }
    }

    public void refreshUsersAppSessionOnForeground() {
    }

    public void registerToken() {
        if (!this.pluginConfig.isFirebaseEnabled()) {
            return;
        }
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new a(this));
    }

    public FirebaseRemoteConfig remoteConfig() {
        if (this._remoteConfig == null) {
            this._remoteConfig = FirebaseRemoteConfig.getInstance();
            this._remoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(TimeUnit.HOURS.toSeconds(1L)).build());
        }
        return this._remoteConfig;
    }

    public void resetColdStartFlag() {
    }

    public void saveToFbUser(String str, Object obj) {
        saveToFbUser(str, obj, null);
    }

    public void startRealtimeListenerIfNeeded() {
        if (shouldUseRealtimeListener()) {
            registerAuthStateListener();
        }
    }

    public void saveToFbUser(String str, Object obj, Runnable runnable) {
        if (this.pluginConfig.isFirebaseEnabled()) {
            LogHelper.d("FirebaseHelper", "saveToFbUser: " + str);
            LogHelper.d("FirebaseHelper", "saveToFbUser: " + obj.toString());
            String string = this.context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).getString("flutter.webview.fbUserID", null);
            if (string == null || string.isEmpty()) {
                return;
            }
            LogHelper.d("FirebaseHelper", "saveToFbUser: ".concat(string));
            firebaseDatabase().child("/UsersApp/".concat(string)).child(str).setValue(obj).addOnCompleteListener(new i(this, runnable, str, 7));
        }
    }
}
