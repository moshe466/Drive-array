package com.google.firebase.database.core;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.android.AndroidPlatform;
import com.google.firebase.database.connection.ConnectionAuthTokenProvider;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class Context {
    private static final long DEFAULT_CACHE_SIZE = 10485760;
    protected Logger a;
    protected EventTarget b;
    protected AuthTokenProvider c;
    protected RunLoop d;
    protected String e;
    protected List<String> f;
    private PersistenceManager forcedPersistenceManager;
    protected String g;
    protected boolean i;
    protected FirebaseApp k;
    private Platform platform;
    protected Logger.Level h = Logger.Level.INFO;
    protected long j = DEFAULT_CACHE_SIZE;
    private boolean frozen = false;
    private boolean stopped = false;

    /* renamed from: com.google.firebase.database.core.Context$1 */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements AuthTokenProvider.GetTokenCompletionListener {
        final /* synthetic */ ScheduledExecutorService a;
        final /* synthetic */ ConnectionAuthTokenProvider.GetTokenCallback b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass1(ScheduledExecutorService scheduledExecutorService, ConnectionAuthTokenProvider.GetTokenCallback getTokenCallback) {
            this.a = scheduledExecutorService;
            this.b = getTokenCallback;
        }

        @Override // com.google.firebase.database.core.AuthTokenProvider.GetTokenCompletionListener
        public void onError(String str) {
            this.a.execute(Context$1$$Lambda$4.lambdaFactory$(this.b, str));
        }

        @Override // com.google.firebase.database.core.AuthTokenProvider.GetTokenCompletionListener
        public void onSuccess(String str) {
            this.a.execute(Context$1$$Lambda$1.lambdaFactory$(this.b, str));
        }
    }

    private String buildUserAgent(String str) {
        return "Firebase/5/" + FirebaseDatabase.getSdkVersion() + "/" + str;
    }

    private void ensureAuthTokenProvider() {
        Preconditions.checkNotNull(this.c, "You must register an authTokenProvider before initializing Context.");
    }

    private void ensureEventTarget() {
        if (this.b == null) {
            this.b = getPlatform().newEventTarget(this);
        }
    }

    private void ensureLogger() {
        if (this.a == null) {
            this.a = getPlatform().newLogger(this, this.h, this.f);
        }
    }

    private void ensureRunLoop() {
        if (this.d == null) {
            this.d = this.platform.newRunLoop(this);
        }
    }

    private void ensureSessionIdentifier() {
        if (this.e == null) {
            this.e = "default";
        }
    }

    private void ensureUserAgent() {
        if (this.g == null) {
            this.g = buildUserAgent(getPlatform().getUserAgent(this));
        }
    }

    private ScheduledExecutorService getExecutorService() {
        RunLoop runLoop = getRunLoop();
        if (runLoop instanceof DefaultRunLoop) {
            return ((DefaultRunLoop) runLoop).getExecutorService();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private Platform getPlatform() {
        if (this.platform == null) {
            initializeAndroidPlatform();
        }
        return this.platform;
    }

    private void initServices() {
        ensureLogger();
        getPlatform();
        ensureUserAgent();
        ensureEventTarget();
        ensureRunLoop();
        ensureSessionIdentifier();
        ensureAuthTokenProvider();
    }

    private synchronized void initializeAndroidPlatform() {
        this.platform = new AndroidPlatform(this.k);
    }

    private void restartServices() {
        this.b.restart();
        this.d.restart();
    }

    private static ConnectionAuthTokenProvider wrapAuthTokenProvider(AuthTokenProvider authTokenProvider, ScheduledExecutorService scheduledExecutorService) {
        return Context$$Lambda$1.lambdaFactory$(authTokenProvider, scheduledExecutorService);
    }

    public PersistenceManager a(String str) {
        PersistenceManager persistenceManager = this.forcedPersistenceManager;
        if (persistenceManager != null) {
            return persistenceManager;
        }
        if (!this.i) {
            return new NoopPersistenceManager();
        }
        PersistenceManager createPersistenceManager = this.platform.createPersistenceManager(this, str);
        if (createPersistenceManager != null) {
            return createPersistenceManager;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }

    public void a() {
        if (isFrozen()) {
            throw new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public synchronized void b() {
        if (!this.frozen) {
            this.frozen = true;
            initServices();
        }
    }

    public void c() {
        this.stopped = true;
        this.b.shutdown();
        this.d.shutdown();
    }

    public AuthTokenProvider getAuthTokenProvider() {
        return this.c;
    }

    public ConnectionContext getConnectionContext() {
        return new ConnectionContext(getLogger(), wrapAuthTokenProvider(getAuthTokenProvider(), getExecutorService()), getExecutorService(), isPersistenceEnabled(), FirebaseDatabase.getSdkVersion(), getUserAgent(), getSSLCacheDirectory().getAbsolutePath());
    }

    public EventTarget getEventTarget() {
        return this.b;
    }

    public Logger.Level getLogLevel() {
        return this.h;
    }

    public LogWrapper getLogger(String str) {
        return new LogWrapper(this.a, str);
    }

    public LogWrapper getLogger(String str, String str2) {
        return new LogWrapper(this.a, str, str2);
    }

    public Logger getLogger() {
        return this.a;
    }

    public List<String> getOptDebugLogComponents() {
        return this.f;
    }

    public long getPersistenceCacheSizeBytes() {
        return this.j;
    }

    public String getPlatformVersion() {
        return getPlatform().getPlatformVersion();
    }

    public RunLoop getRunLoop() {
        return this.d;
    }

    public File getSSLCacheDirectory() {
        return getPlatform().getSSLCacheDirectory();
    }

    public String getSessionPersistenceKey() {
        return this.e;
    }

    public String getUserAgent() {
        return this.g;
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    public boolean isPersistenceEnabled() {
        return this.i;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    public PersistentConnection newPersistentConnection(HostInfo hostInfo, PersistentConnection.Delegate delegate) {
        return getPlatform().newPersistentConnection(this, getConnectionContext(), hostInfo, delegate);
    }

    public void requireStarted() {
        if (this.stopped) {
            restartServices();
            this.stopped = false;
        }
    }
}
