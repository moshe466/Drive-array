package com.google.firebase.sessions.settings;

import O2.c;
import P2.G;
import T.b;
import Y2.a;
import Y2.e;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.Lazy;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String FORWARD_SLASH_STRING = "/";

    @Deprecated
    public static final String TAG = "SessionConfigFetcher";
    private final ApplicationInfo appInfo;
    private final InterfaceC0768i backgroundDispatcher;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final a fetchInProgress;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final Lazy<SettingsCache> lazySettingsCache;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public RemoteSettings(@Background InterfaceC0768i backgroundDispatcher, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo appInfo, CrashlyticsSettingsFetcher configsFetcher, Lazy<SettingsCache> lazySettingsCache) {
        j.e(backgroundDispatcher, "backgroundDispatcher");
        j.e(firebaseInstallationsApi, "firebaseInstallationsApi");
        j.e(appInfo, "appInfo");
        j.e(configsFetcher, "configsFetcher");
        j.e(lazySettingsCache, "lazySettingsCache");
        this.backgroundDispatcher = backgroundDispatcher;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.appInfo = appInfo;
        this.configsFetcher = configsFetcher;
        this.lazySettingsCache = lazySettingsCache;
        this.fetchInProgress = e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsCache getSettingsCache() {
        SettingsCache settingsCache = this.lazySettingsCache.get();
        j.d(settingsCache, "lazySettingsCache.get()");
        return settingsCache;
    }

    private final String removeForwardSlashesIn(String input) {
        Pattern compile = Pattern.compile(FORWARD_SLASH_STRING);
        j.d(compile, "compile(...)");
        j.e(input, "input");
        String replaceAll = compile.matcher(input).replaceAll("");
        j.d(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    public final void clearCachedSettings$com_google_firebase_firebase_sessions() {
        G.r(G.b(this.backgroundDispatcher), null, new RemoteSettings$clearCachedSettings$1(this, null), 3);
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double getSamplingRate() {
        return getSettingsCache().sessionSamplingRate();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean getSessionEnabled() {
        return getSettingsCache().sessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /* renamed from: getSessionRestartTimeout-FghU774 */
    public O2.a mo12getSessionRestartTimeoutFghU774() {
        Integer sessionRestartTimeout = getSettingsCache().sessionRestartTimeout();
        if (sessionRestartTimeout != null) {
            int i = O2.a.f1537d;
            return new O2.a(b.M(sessionRestartTimeout.intValue(), c.f1542d));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public boolean isSettingsStale() {
        return getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1 A[Catch: all -> 0x004c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x004c, blocks: (B:25:0x0048, B:26:0x00ad, B:30:0x00c1), top: B:24:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098 A[Catch: all -> 0x013e, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x013e, blocks: (B:39:0x0088, B:43:0x0098), top: B:38:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Type inference failed for: r2v11, types: [Y2.a] */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object updateSettings(w2.InterfaceC0763d r15) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.updateSettings(w2.d):java.lang.Object");
    }
}
