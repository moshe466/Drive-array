package io.flutter.plugins.firebase.crashlytics;

import a1.C0230a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.FlutterFirebaseCrashlyticsInternal;
import com.google.firebase.crashlytics.internal.Logger;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class FlutterFirebaseCrashlyticsPlugin implements FlutterFirebasePlugin, FlutterPlugin, MethodChannel.MethodCallHandler {
    private static final String FIREBASE_CRASHLYTICS_COLLECTION_ENABLED = "firebase_crashlytics_collection_enabled";
    public static final String TAG = "FLTFirebaseCrashlytics";
    private MethodChannel channel;

    /* renamed from: io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends HashMap<String, Object> {
        final /* synthetic */ boolean val$unsentReports;

        public AnonymousClass1(boolean z3) {
            this.val$unsentReports = z3;
            put(Constants.UNSENT_REPORTS, Boolean.valueOf(z3));
        }
    }

    /* renamed from: io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends HashMap<String, Object> {
        final /* synthetic */ boolean val$didCrashOnPreviousExecution;

        public AnonymousClass2(boolean z3) {
            this.val$didCrashOnPreviousExecution = z3;
            put(Constants.DID_CRASH_ON_PREVIOUS_EXECUTION, Boolean.valueOf(z3));
        }
    }

    /* renamed from: io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 extends HashMap<String, Object> {
        public AnonymousClass3() {
            put(Constants.IS_CRASHLYTICS_COLLECTION_ENABLED, Boolean.valueOf(FlutterFirebaseCrashlyticsPlugin.this.isCrashlyticsCollectionEnabled(FirebaseApp.getInstance())));
        }
    }

    /* renamed from: io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin$4 */
    /* loaded from: classes.dex */
    public class AnonymousClass4 extends HashMap<String, Object> {
        final /* synthetic */ FirebaseApp val$firebaseApp;

        public AnonymousClass4(FirebaseApp firebaseApp) {
            this.val$firebaseApp = firebaseApp;
            if (firebaseApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                put(Constants.IS_CRASHLYTICS_COLLECTION_ENABLED, Boolean.valueOf(FlutterFirebaseCrashlyticsPlugin.this.isCrashlyticsCollectionEnabled(FirebaseApp.getInstance())));
            }
        }
    }

    private Task<Map<String, Object>> checkForUnsentReports() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new c(this, taskCompletionSource, 0));
        return taskCompletionSource.getTask();
    }

    private void crash() {
        new Handler(Looper.myLooper()).postDelayed(new com.google.firebase.crashlytics.internal.concurrency.b(1), 50L);
    }

    private Task<Void> deleteUnsentReports() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new io.flutter.plugins.firebase.core.c(1, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task<Map<String, Object>> didCrashOnPreviousExecution() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new c(this, taskCompletionSource, 1));
        return taskCompletionSource.getTask();
    }

    private StackTraceElement generateStackTraceElement(Map<String, String> map) {
        try {
            String str = map.get(Constants.FILE);
            String str2 = map.get(Constants.LINE);
            String str3 = map.get(Constants.CLASS);
            String str4 = map.get(Constants.METHOD);
            if (str3 == null) {
                str3 = "";
            }
            Objects.requireNonNull(str2);
            return new StackTraceElement(str3, str4, str, Integer.parseInt(str2));
        } catch (Exception unused) {
            Log.e(TAG, "Unable to generate stack trace element from Dart error.");
            return null;
        }
    }

    private SharedPreferences getCrashlyticsSharedPrefs(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    private void initInstance(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_crashlytics");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_crashlytics", this);
    }

    public boolean isCrashlyticsCollectionEnabled(FirebaseApp firebaseApp) {
        SharedPreferences crashlyticsSharedPrefs = getCrashlyticsSharedPrefs(firebaseApp.getApplicationContext());
        if (crashlyticsSharedPrefs.contains(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED)) {
            return crashlyticsSharedPrefs.getBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED, true);
        }
        Boolean readCrashlyticsDataCollectionEnabledFromManifest = readCrashlyticsDataCollectionEnabledFromManifest(firebaseApp.getApplicationContext());
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(readCrashlyticsDataCollectionEnabledFromManifest);
        return readCrashlyticsDataCollectionEnabledFromManifest.booleanValue();
    }

    public /* synthetic */ void lambda$checkForUnsentReports$0(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap<String, Object>(((Boolean) Tasks.await(FirebaseCrashlytics.getInstance().checkForUnsentReports())).booleanValue()) { // from class: io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin.1
                final /* synthetic */ boolean val$unsentReports;

                public AnonymousClass1(boolean z3) {
                    this.val$unsentReports = z3;
                    put(Constants.UNSENT_REPORTS, Boolean.valueOf(z3));
                }
            });
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void lambda$crash$1() {
        throw new FirebaseCrashlyticsTestCrash();
    }

    public static /* synthetic */ void lambda$deleteUnsentReports$2(TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseCrashlytics.getInstance().deleteUnsentReports();
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public /* synthetic */ void lambda$didCrashOnPreviousExecution$3(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap<String, Object>(FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution()) { // from class: io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin.2
                final /* synthetic */ boolean val$didCrashOnPreviousExecution;

                public AnonymousClass2(boolean z3) {
                    this.val$didCrashOnPreviousExecution = z3;
                    put(Constants.DID_CRASH_ON_PREVIOUS_EXECUTION, Boolean.valueOf(z3));
                }
            });
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void lambda$didReinitializeFirebaseCore$12(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public /* synthetic */ void lambda$getPluginConstantsForFirebaseApp$11(TaskCompletionSource taskCompletionSource, FirebaseApp firebaseApp) {
        try {
            taskCompletionSource.setResult(new HashMap<String, Object>(firebaseApp) { // from class: io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin.4
                final /* synthetic */ FirebaseApp val$firebaseApp;

                public AnonymousClass4(FirebaseApp firebaseApp2) {
                    this.val$firebaseApp = firebaseApp2;
                    if (firebaseApp2.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                        put(Constants.IS_CRASHLYTICS_COLLECTION_ENABLED, Boolean.valueOf(FlutterFirebaseCrashlyticsPlugin.this.isCrashlyticsCollectionEnabled(FirebaseApp.getInstance())));
                    }
                }
            });
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void lambda$log$5(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get(Constants.MESSAGE);
            Objects.requireNonNull(obj);
            FirebaseCrashlytics.getInstance().log((String) obj);
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void lambda$onMethodCall$10(MethodChannel.Result result, Task task) {
        String str;
        if (task.isSuccessful()) {
            result.success(task.getResult());
            return;
        }
        Exception exception = task.getException();
        if (exception != null) {
            str = exception.getMessage();
        } else {
            str = "An unknown error occurred";
        }
        result.error("firebase_crashlytics", str, null);
    }

    public /* synthetic */ void lambda$recordError$4(Map map, TaskCompletionSource taskCompletionSource) {
        FlutterError flutterError;
        try {
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            Object obj = map.get(Constants.EXCEPTION);
            Objects.requireNonNull(obj);
            String str = (String) obj;
            String str2 = (String) map.get(Constants.REASON);
            Object obj2 = map.get(Constants.INFORMATION);
            Objects.requireNonNull(obj2);
            String str3 = (String) obj2;
            Object obj3 = map.get(Constants.FATAL);
            Objects.requireNonNull(obj3);
            boolean booleanValue = ((Boolean) obj3).booleanValue();
            Object obj4 = map.get(Constants.BUILD_ID);
            Objects.requireNonNull(obj4);
            String str4 = (String) obj4;
            Object obj5 = map.get(Constants.LOADING_UNITS);
            Objects.requireNonNull(obj5);
            List list = (List) obj5;
            if (str4.length() > 0) {
                FlutterFirebaseCrashlyticsInternal.setFlutterBuildId(str4);
            }
            FlutterFirebaseCrashlyticsInternal.setLoadingUnits(list);
            if (str2 != null) {
                firebaseCrashlytics.setCustomKey(Constants.FLUTTER_ERROR_REASON, "thrown ".concat(str2));
                flutterError = new FlutterError(str + ". Error thrown " + str2 + ".");
            } else {
                flutterError = new FlutterError(str);
            }
            firebaseCrashlytics.setCustomKey(Constants.FLUTTER_ERROR_EXCEPTION, str);
            ArrayList arrayList = new ArrayList();
            Object obj6 = map.get(Constants.STACK_TRACE_ELEMENTS);
            Objects.requireNonNull(obj6);
            Iterator it = ((List) obj6).iterator();
            while (it.hasNext()) {
                StackTraceElement generateStackTraceElement = generateStackTraceElement((Map) it.next());
                if (generateStackTraceElement != null) {
                    arrayList.add(generateStackTraceElement);
                }
            }
            flutterError.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            if (!str3.isEmpty()) {
                firebaseCrashlytics.log(str3);
            }
            if (booleanValue) {
                FlutterFirebaseCrashlyticsInternal.recordFatalException(flutterError);
            } else {
                firebaseCrashlytics.recordException(flutterError);
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void lambda$sendUnsentReports$6(TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseCrashlytics.getInstance().sendUnsentReports();
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public /* synthetic */ void lambda$setCrashlyticsCollectionEnabled$7(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get(Constants.ENABLED);
            Objects.requireNonNull(obj);
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled((Boolean) obj);
            taskCompletionSource.setResult(new HashMap<String, Object>() { // from class: io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin.3
                public AnonymousClass3() {
                    put(Constants.IS_CRASHLYTICS_COLLECTION_ENABLED, Boolean.valueOf(FlutterFirebaseCrashlyticsPlugin.this.isCrashlyticsCollectionEnabled(FirebaseApp.getInstance())));
                }
            });
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void lambda$setCustomKey$9(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get("key");
            Objects.requireNonNull(obj);
            Object obj2 = map.get("value");
            Objects.requireNonNull(obj2);
            FirebaseCrashlytics.getInstance().setCustomKey((String) obj, (String) obj2);
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void lambda$setUserIdentifier$8(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get(Constants.IDENTIFIER);
            Objects.requireNonNull(obj);
            FirebaseCrashlytics.getInstance().setUserId((String) obj);
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private Task<Void> log(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new b(map, taskCompletionSource, 0));
        return taskCompletionSource.getTask();
    }

    private static Boolean readCrashlyticsDataCollectionEnabledFromManifest(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED)) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED));
            }
        } catch (PackageManager.NameNotFoundException e4) {
            Logger.getLogger().e("Could not read data collection permission from manifest", e4);
        }
        return Boolean.TRUE;
    }

    private Task<Void> recordError(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new a(this, map, taskCompletionSource, 0));
        return taskCompletionSource.getTask();
    }

    private Task<Void> sendUnsentReports() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new io.flutter.plugins.firebase.core.c(2, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task<Map<String, Object>> setCrashlyticsCollectionEnabled(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new a(this, map, taskCompletionSource, 1));
        return taskCompletionSource.getTask();
    }

    private Task<Void> setCustomKey(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new b(map, taskCompletionSource, 2));
        return taskCompletionSource.getTask();
    }

    private Task<Void> setUserIdentifier(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new b(map, taskCompletionSource, 1));
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new io.flutter.plugins.firebase.core.c(3, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new K0.b(this, taskCompletionSource, firebaseApp, 7));
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
            this.channel = null;
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Task didCrashOnPreviousExecution;
        String str = methodCall.method;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -2094964816:
                if (str.equals("Crashlytics#didCrashOnPreviousExecution")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1437158995:
                if (str.equals("Crashlytics#recordError")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1025128541:
                if (str.equals("Crashlytics#checkForUnsentReports")) {
                    c4 = 2;
                    break;
                }
                break;
            case -424770276:
                if (str.equals("Crashlytics#sendUnsentReports")) {
                    c4 = 3;
                    break;
                }
                break;
            case -108157790:
                if (str.equals("Crashlytics#setCrashlyticsCollectionEnabled")) {
                    c4 = 4;
                    break;
                }
                break;
            case 28093114:
                if (str.equals("Crashlytics#log")) {
                    c4 = 5;
                    break;
                }
                break;
            case 108415030:
                if (str.equals("Crashlytics#setCustomKey")) {
                    c4 = 6;
                    break;
                }
                break;
            case 213629529:
                if (str.equals("Crashlytics#deleteUnsentReports")) {
                    c4 = 7;
                    break;
                }
                break;
            case 679831756:
                if (str.equals("Crashlytics#setUserIdentifier")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1219454365:
                if (str.equals("Crashlytics#crash")) {
                    c4 = '\t';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                didCrashOnPreviousExecution = didCrashOnPreviousExecution();
                break;
            case 1:
                didCrashOnPreviousExecution = recordError((Map) methodCall.arguments());
                break;
            case 2:
                didCrashOnPreviousExecution = checkForUnsentReports();
                break;
            case 3:
                didCrashOnPreviousExecution = sendUnsentReports();
                break;
            case 4:
                didCrashOnPreviousExecution = setCrashlyticsCollectionEnabled((Map) methodCall.arguments());
                break;
            case 5:
                didCrashOnPreviousExecution = log((Map) methodCall.arguments());
                break;
            case 6:
                didCrashOnPreviousExecution = setCustomKey((Map) methodCall.arguments());
                break;
            case 7:
                didCrashOnPreviousExecution = deleteUnsentReports();
                break;
            case '\b':
                didCrashOnPreviousExecution = setUserIdentifier((Map) methodCall.arguments());
                break;
            case '\t':
                crash();
                return;
            default:
                result.notImplemented();
                return;
        }
        didCrashOnPreviousExecution.addOnCompleteListener(new C0230a(3, result));
    }
}
