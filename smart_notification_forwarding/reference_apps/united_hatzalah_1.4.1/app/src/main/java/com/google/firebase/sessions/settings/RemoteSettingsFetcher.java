package com.google.firebase.sessions.settings;

import F2.p;
import P2.G;
import android.net.Uri;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.sessions.ApplicationInfo;
import java.net.URL;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import s2.C0684i;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public final class RemoteSettingsFetcher implements CrashlyticsSettingsFetcher {
    public static final Companion Companion = new Companion(null);
    private static final String FIREBASE_PLATFORM = "android";
    private static final String FIREBASE_SESSIONS_BASE_URL_STRING = "firebase-settings.crashlytics.com";
    private final ApplicationInfo appInfo;
    private final InterfaceC0768i blockingDispatcher;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public RemoteSettingsFetcher(ApplicationInfo appInfo, @Background InterfaceC0768i blockingDispatcher) {
        j.e(appInfo, "appInfo");
        j.e(blockingDispatcher, "blockingDispatcher");
        this.appInfo = appInfo;
        this.blockingDispatcher = blockingDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URL settingsUrl() {
        return new URL(new Uri.Builder().scheme("https").authority(FIREBASE_SESSIONS_BASE_URL_STRING).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath(FIREBASE_PLATFORM).appendPath("gmp").appendPath(this.appInfo.getAppId()).appendPath("settings").appendQueryParameter("build_version", this.appInfo.getAndroidAppInfo().getAppBuildVersion()).appendQueryParameter("display_version", this.appInfo.getAndroidAppInfo().getVersionName()).build().toString());
    }

    @Override // com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher
    public Object doConfigFetch(Map<String, String> map, p pVar, p pVar2, InterfaceC0763d interfaceC0763d) {
        Object z3 = G.z(this.blockingDispatcher, new RemoteSettingsFetcher$doConfigFetch$2(this, map, pVar, pVar2, null), interfaceC0763d);
        if (z3 == EnumC0779a.f6740a) {
            return z3;
        }
        return C0684i.f6340a;
    }
}
