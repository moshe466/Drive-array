package com.crashlytics.android.core;

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.answers.AppMeasurementEventLogger;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DataCollectionArbiter;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.FirebaseInfo;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;
import io.fabric.sdk.android.services.concurrency.Task;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;

@DependsOn({CrashlyticsNdkDataProvider.class})
/* loaded from: classes.dex */
public class CrashlyticsCore extends Kit<Void> {
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.";
    private static final String PREFERENCE_STORE_NAME = "com.crashlytics.android.core.CrashlyticsCore";
    public static final String TAG = "CrashlyticsCore";
    private final ConcurrentHashMap<String, String> attributes;
    private CrashlyticsBackgroundWorker backgroundWorker;
    private CrashlyticsController controller;
    private CrashlyticsFileMarker crashMarker;
    private CrashlyticsNdkDataProvider crashlyticsNdkDataProvider;
    private float delay;
    private boolean disabled;
    private HttpRequestFactory httpRequestFactory;
    private CrashlyticsFileMarker initializationMarker;
    private CrashlyticsListener listener;
    private final PinningInfoProvider pinningInfo;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;

    /* loaded from: classes.dex */
    public static class Builder {
        private float delay = -1.0f;
        private boolean disabled = false;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public CrashlyticsCore build() {
            if (this.delay < 0.0f) {
                this.delay = 1.0f;
            }
            return new CrashlyticsCore(this.delay, this.listener, this.pinningInfoProvider, this.disabled);
        }

        public Builder delay(float f) {
            if (f <= 0.0f) {
                throw new IllegalArgumentException("delay must be greater than 0");
            }
            if (this.delay > 0.0f) {
                throw new IllegalStateException("delay already set.");
            }
            this.delay = f;
            return this;
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        public Builder listener(CrashlyticsListener crashlyticsListener) {
            if (crashlyticsListener == null) {
                throw new IllegalArgumentException("listener must not be null.");
            }
            if (this.listener != null) {
                throw new IllegalStateException("listener already set.");
            }
            this.listener = crashlyticsListener;
            return this;
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider) {
            if (pinningInfoProvider == null) {
                throw new IllegalArgumentException("pinningInfoProvider must not be null.");
            }
            if (this.pinningInfoProvider != null) {
                throw new IllegalStateException("pinningInfoProvider already set.");
            }
            this.pinningInfoProvider = pinningInfoProvider;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class CrashMarkerCheck implements Callable<Boolean> {
        private final CrashlyticsFileMarker crashMarker;

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.crashMarker = crashlyticsFileMarker;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            if (!this.crashMarker.isPresent()) {
                return Boolean.FALSE;
            }
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Found previous crash marker.");
            this.crashMarker.remove();
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes.dex */
    private static final class NoOpListener implements CrashlyticsListener {
        private NoOpListener() {
        }

        @Override // com.crashlytics.android.core.CrashlyticsListener
        public void crashlyticsDidDetectCrashDuringPreviousExecution() {
        }
    }

    public CrashlyticsCore() {
        this(1.0f, null, null, false);
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z) {
        this(f, crashlyticsListener, pinningInfoProvider, z, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.userEmail = null;
        this.userName = null;
        this.delay = f;
        this.listener = crashlyticsListener == null ? new NoOpListener() : crashlyticsListener;
        this.pinningInfo = pinningInfoProvider;
        this.disabled = z;
        this.backgroundWorker = new CrashlyticsBackgroundWorker(executorService);
        this.attributes = new ConcurrentHashMap<>();
        this.startTime = System.currentTimeMillis();
    }

    static boolean a(String str, boolean z) {
        if (!z) {
            Fabric.getLogger().d(TAG, "Configured not to require a build ID.");
            return true;
        }
        if (!CommonUtils.isNullOrEmpty(str)) {
            return true;
        }
        Log.e(TAG, ".");
        Log.e(TAG, ".     |  | ");
        Log.e(TAG, ".     |  |");
        Log.e(TAG, ".     |  |");
        Log.e(TAG, ".   \\ |  | /");
        Log.e(TAG, ".    \\    /");
        Log.e(TAG, ".     \\  /");
        Log.e(TAG, ".      \\/");
        Log.e(TAG, ".");
        Log.e(TAG, MISSING_BUILD_ID_MSG);
        Log.e(TAG, ".");
        Log.e(TAG, ".      /\\");
        Log.e(TAG, ".     /  \\");
        Log.e(TAG, ".    /    \\");
        Log.e(TAG, ".   / |  | \\");
        Log.e(TAG, ".     |  |");
        Log.e(TAG, ".     |  |");
        Log.e(TAG, ".     |  |");
        Log.e(TAG, ".");
        return false;
    }

    private void checkForPreviousCrash() {
        if (Boolean.TRUE.equals((Boolean) this.backgroundWorker.b(new CrashMarkerCheck(this.crashMarker)))) {
            try {
                this.listener.crashlyticsDidDetectCrashDuringPreviousExecution();
            } catch (Exception e) {
                Fabric.getLogger().e(TAG, "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    private void doLog(int i, String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging messages.")) {
            this.controller.a(System.currentTimeMillis() - this.startTime, formatLogMessage(i, str, str2));
        }
    }

    private static boolean ensureFabricWithCalled(String str) {
        CrashlyticsCore crashlyticsCore = getInstance();
        if (crashlyticsCore != null && crashlyticsCore.controller != null) {
            return true;
        }
        Fabric.getLogger().e(TAG, "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    private void finishInitSynchronously() {
        Logger logger;
        String str;
        PriorityCallable<Void> priorityCallable = new PriorityCallable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsCore.1
            @Override // java.util.concurrent.Callable
            public Void call() {
                return CrashlyticsCore.this.a();
            }

            @Override // io.fabric.sdk.android.services.concurrency.PriorityTask, io.fabric.sdk.android.services.concurrency.PriorityProvider
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };
        Iterator<Task> it = b().iterator();
        while (it.hasNext()) {
            priorityCallable.addDependency(it.next());
        }
        Future submit = getFabric().getExecutorService().submit(priorityCallable);
        Fabric.getLogger().d(TAG, "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            logger = Fabric.getLogger();
            str = "Crashlytics was interrupted during initialization.";
            logger.e(TAG, str, e);
        } catch (ExecutionException e2) {
            e = e2;
            logger = Fabric.getLogger();
            str = "Problem encountered during Crashlytics initialization.";
            logger.e(TAG, str, e);
        } catch (TimeoutException e3) {
            e = e3;
            logger = Fabric.getLogger();
            str = "Crashlytics timed out during initialization.";
            logger.e(TAG, str, e);
        }
    }

    private static String formatLogMessage(int i, String str, String str2) {
        return CommonUtils.logPriorityToString(i) + "/" + str + " " + str2;
    }

    public static CrashlyticsCore getInstance() {
        return (CrashlyticsCore) Fabric.getKit(CrashlyticsCore.class);
    }

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.Kit
    public Void a() {
        SettingsData awaitSettingsData;
        o();
        this.controller.a();
        try {
            try {
                this.controller.k();
                awaitSettingsData = Settings.getInstance().awaitSettingsData();
            } catch (Exception e) {
                Fabric.getLogger().e(TAG, "Crashlytics encountered a problem during asynchronous initialization.", e);
            }
            if (awaitSettingsData == null) {
                Fabric.getLogger().w(TAG, "Received null settings, skipping report submission!");
                return null;
            }
            this.controller.a(awaitSettingsData);
            if (!awaitSettingsData.featuresData.collectReports) {
                Fabric.getLogger().d(TAG, "Collection of crash reports disabled in Crashlytics settings.");
                return null;
            }
            if (!DataCollectionArbiter.getInstance(getContext()).isDataCollectionEnabled()) {
                Fabric.getLogger().d(TAG, "Automatic collection of crash reports disabled by Firebase settings.");
                return null;
            }
            CrashlyticsNdkData j = j();
            if (j != null && !this.controller.a(j)) {
                Fabric.getLogger().d(TAG, "Could not finalize previous NDK sessions.");
            }
            if (!this.controller.b(awaitSettingsData.sessionData)) {
                Fabric.getLogger().d(TAG, "Could not finalize previous sessions.");
            }
            this.controller.a(this.delay, awaitSettingsData);
            return null;
        } finally {
            n();
        }
    }

    boolean a(Context context) {
        String value;
        if (!DataCollectionArbiter.getInstance(context).isDataCollectionEnabled()) {
            Fabric.getLogger().d(TAG, "Crashlytics is disabled, because data collection is disabled by Firebase.");
            this.disabled = true;
        }
        if (this.disabled || (value = new ApiKey().getValue(context)) == null) {
            return false;
        }
        String resolveBuildId = CommonUtils.resolveBuildId(context);
        if (!a(resolveBuildId, CommonUtils.getBooleanResourceValue(context, "com.crashlytics.RequireBuildId", true))) {
            throw new UnmetDependencyException(MISSING_BUILD_ID_MSG);
        }
        try {
            Fabric.getLogger().i(TAG, "Initializing Crashlytics Core " + getVersion());
            FileStoreImpl fileStoreImpl = new FileStoreImpl(this);
            this.crashMarker = new CrashlyticsFileMarker("crash_marker", fileStoreImpl);
            this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, fileStoreImpl);
            PreferenceManager create = PreferenceManager.create(new PreferenceStoreImpl(getContext(), PREFERENCE_STORE_NAME), this);
            CrashlyticsPinningInfoProvider crashlyticsPinningInfoProvider = this.pinningInfo != null ? new CrashlyticsPinningInfoProvider(this.pinningInfo) : null;
            this.httpRequestFactory = new DefaultHttpRequestFactory(Fabric.getLogger());
            this.httpRequestFactory.setPinningInfoProvider(crashlyticsPinningInfoProvider);
            IdManager c = c();
            AppData create2 = AppData.create(context, c, value, resolveBuildId);
            this.controller = new CrashlyticsController(this, this.backgroundWorker, this.httpRequestFactory, c, create, fileStoreImpl, create2, new ResourceUnityVersionProvider(context, new ManifestUnityVersionProvider(context, create2.packageName)), new DefaultAppMeasurementEventListenerRegistrar(this), AppMeasurementEventLogger.getEventLogger(context));
            boolean h = h();
            checkForPreviousCrash();
            this.controller.a(Thread.getDefaultUncaughtExceptionHandler(), new FirebaseInfo().isFirebaseCrashlyticsEnabled(context));
            if (!h || !CommonUtils.canTryConnection(context)) {
                Fabric.getLogger().d(TAG, "Exception handling initialization successful");
                return true;
            }
            Fabric.getLogger().d(TAG, "Crashlytics did not finish previous background initialization. Initializing synchronously.");
            finishInitSynchronously();
            return false;
        } catch (Exception e) {
            Fabric.getLogger().e(TAG, "Crashlytics was not started due to an exception during initialization", e);
            this.controller = null;
            return false;
        }
    }

    boolean a(URL url) {
        if (getPinningInfoProvider() == null) {
            return false;
        }
        HttpRequest buildHttpRequest = this.httpRequestFactory.buildHttpRequest(HttpMethod.GET, url.toString());
        ((HttpsURLConnection) buildHttpRequest.getConnection()).setInstanceFollowRedirects(false);
        buildHttpRequest.code();
        return true;
    }

    public void crash() {
        new CrashTest().indexOutOfBounds();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.Kit
    public boolean f() {
        return a(super.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.crashMarker.create();
    }

    @Override // io.fabric.sdk.android.Kit
    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public PinningInfoProvider getPinningInfoProvider() {
        if (this.disabled) {
            return null;
        }
        return this.pinningInfo;
    }

    @Override // io.fabric.sdk.android.Kit
    public String getVersion() {
        return "2.7.0.33";
    }

    boolean h() {
        return this.initializationMarker.isPresent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> i() {
        return Collections.unmodifiableMap(this.attributes);
    }

    CrashlyticsNdkData j() {
        CrashlyticsNdkDataProvider crashlyticsNdkDataProvider = this.crashlyticsNdkDataProvider;
        if (crashlyticsNdkDataProvider != null) {
            return crashlyticsNdkDataProvider.getCrashlyticsNdkData();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        if (c().canCollectUserIds()) {
            return this.userEmail;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        if (c().canCollectUserIds()) {
            return this.userId;
        }
        return null;
    }

    public void log(int i, String str, String str2) {
        doLog(i, str, str2);
        Fabric.getLogger().log(i, "" + str, "" + str2, true);
    }

    public void log(String str) {
        doLog(3, TAG, str);
    }

    public void logException(Throwable th) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging exceptions.")) {
            if (th == null) {
                Fabric.getLogger().log(5, TAG, "Crashlytics is ignoring a request to log a null exception.");
            } else {
                this.controller.a(Thread.currentThread(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        if (c().canCollectUserIds()) {
            return this.userName;
        }
        return null;
    }

    void n() {
        this.backgroundWorker.a(new Callable<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsCore.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                try {
                    boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                    Fabric.getLogger().d(CrashlyticsCore.TAG, "Initialization marker file removed: " + remove);
                    return Boolean.valueOf(remove);
                } catch (Exception e) {
                    Fabric.getLogger().e(CrashlyticsCore.TAG, "Problem encountered deleting Crashlytics initialization marker.", e);
                    return false;
                }
            }
        });
    }

    void o() {
        this.backgroundWorker.b(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsCore.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                CrashlyticsCore.this.initializationMarker.create();
                Fabric.getLogger().d(CrashlyticsCore.TAG, "Initialization marker file created.");
                return null;
            }
        });
    }

    public void setBool(String str, boolean z) {
        setString(str, Boolean.toString(z));
    }

    public void setDouble(String str, double d) {
        setString(str, Double.toString(d));
    }

    public void setFloat(String str, float f) {
        setString(str, Float.toString(f));
    }

    public void setInt(String str, int i) {
        setString(str, Integer.toString(i));
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        Fabric.getLogger().w(TAG, "Use of setListener is deprecated.");
        if (crashlyticsListener == null) {
            throw new IllegalArgumentException("listener must not be null.");
        }
        this.listener = crashlyticsListener;
    }

    public void setLong(String str, long j) {
        setString(str, Long.toString(j));
    }

    public void setString(String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting keys.")) {
            if (str == null) {
                Context context = getContext();
                if (context != null && CommonUtils.isAppDebuggable(context)) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
                Fabric.getLogger().e(TAG, "Attempting to set custom attribute with null key, ignoring.", null);
                return;
            }
            String sanitizeAttribute = sanitizeAttribute(str);
            if (this.attributes.size() >= 64 && !this.attributes.containsKey(sanitizeAttribute)) {
                Fabric.getLogger().d(TAG, "Exceeded maximum number of custom attributes (64)");
            } else {
                this.attributes.put(sanitizeAttribute, str2 == null ? "" : sanitizeAttribute(str2));
                this.controller.a(this.attributes);
            }
        }
    }

    public void setUserEmail(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userEmail = sanitizeAttribute(str);
            this.controller.a(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserIdentifier(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userId = sanitizeAttribute(str);
            this.controller.a(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserName(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userName = sanitizeAttribute(str);
            this.controller.a(this.userId, this.userName, this.userEmail);
        }
    }

    public boolean verifyPinning(URL url) {
        try {
            return a(url);
        } catch (Exception e) {
            Fabric.getLogger().e(TAG, "Could not verify SSL pinning", e);
            return false;
        }
    }
}
