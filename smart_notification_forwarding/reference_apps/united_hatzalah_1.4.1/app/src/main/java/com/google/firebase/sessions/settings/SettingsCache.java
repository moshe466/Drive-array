package com.google.firebase.sessions.settings;

import F2.p;
import P2.E;
import P2.G;
import R.InterfaceC0183h;
import S2.d;
import S2.z;
import T.b;
import U.f;
import U.h;
import a.AbstractC0228a;
import com.google.firebase.sessions.SessionConfigsDataStore;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.j;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

/* loaded from: classes.dex */
public final class SettingsCache {

    @Deprecated
    public static final String TAG = "SettingsCache";
    private final InterfaceC0183h dataStore;
    private SessionConfigs sessionConfigs;
    private static final Companion Companion = new Companion(null);
    private static final f SESSIONS_ENABLED = b.c(LocalOverrideSettings.SESSIONS_ENABLED);
    private static final f SAMPLING_RATE = new f(LocalOverrideSettings.SAMPLING_RATE);
    private static final f RESTART_TIMEOUT_SECONDS = new f("firebase_sessions_restart_timeout");
    private static final f CACHE_DURATION_SECONDS = new f("firebase_sessions_cache_duration");
    private static final f CACHE_UPDATED_TIME = new f("firebase_sessions_cache_updated_time");

    @InterfaceC0789e(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {52}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends AbstractC0793i implements p {
        Object L$0;
        int label;

        public AnonymousClass1(InterfaceC0763d interfaceC0763d) {
            super(2, interfaceC0763d);
        }

        @Override // y2.AbstractC0785a
        public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
            return new AnonymousClass1(interfaceC0763d);
        }

        @Override // F2.p
        public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
            return ((AnonymousClass1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
        }

        @Override // y2.AbstractC0785a
        public final Object invokeSuspend(Object obj) {
            SettingsCache settingsCache;
            EnumC0779a enumC0779a = EnumC0779a.f6740a;
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    settingsCache = (SettingsCache) this.L$0;
                    AbstractC0228a.C(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                AbstractC0228a.C(obj);
                SettingsCache settingsCache2 = SettingsCache.this;
                d data = settingsCache2.dataStore.getData();
                this.L$0 = settingsCache2;
                this.label = 1;
                Object e4 = z.e(data, this);
                if (e4 == enumC0779a) {
                    return enumC0779a;
                }
                settingsCache = settingsCache2;
                obj = e4;
            }
            settingsCache.updateSessionConfigs(new U.b(new LinkedHashMap(((h) obj).a()), true));
            return C0684i.f6340a;
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final f getCACHE_DURATION_SECONDS() {
            return SettingsCache.CACHE_DURATION_SECONDS;
        }

        public final f getCACHE_UPDATED_TIME() {
            return SettingsCache.CACHE_UPDATED_TIME;
        }

        public final f getRESTART_TIMEOUT_SECONDS() {
            return SettingsCache.RESTART_TIMEOUT_SECONDS;
        }

        public final f getSAMPLING_RATE() {
            return SettingsCache.SAMPLING_RATE;
        }

        public final f getSESSIONS_ENABLED() {
            return SettingsCache.SESSIONS_ENABLED;
        }

        private Companion() {
        }
    }

    public SettingsCache(@SessionConfigsDataStore InterfaceC0183h dataStore) {
        j.e(dataStore, "dataStore");
        this.dataStore = dataStore;
        G.v(new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|24|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0027, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        r6.toString();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object updateConfigValue(U.f r6, T r7, w2.InterfaceC0763d r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            if (r0 == 0) goto L13
            r0 = r8
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            a.AbstractC0228a.C(r8)     // Catch: java.io.IOException -> L27
            goto L48
        L27:
            r6 = move-exception
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            a.AbstractC0228a.C(r8)
            R.h r8 = r5.dataStore     // Catch: java.io.IOException -> L27
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2     // Catch: java.io.IOException -> L27
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch: java.io.IOException -> L27
            r0.label = r3     // Catch: java.io.IOException -> L27
            java.lang.Object r6 = a.AbstractC0228a.m(r8, r2, r0)     // Catch: java.io.IOException -> L27
            if (r6 != r1) goto L48
            return r1
        L45:
            r6.toString()
        L48:
            s2.i r6 = s2.C0684i.f6340a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.updateConfigValue(U.f, java.lang.Object, w2.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSessionConfigs(h hVar) {
        this.sessionConfigs = new SessionConfigs((Boolean) hVar.b(SESSIONS_ENABLED), (Double) hVar.b(SAMPLING_RATE), (Integer) hVar.b(RESTART_TIMEOUT_SECONDS), (Integer) hVar.b(CACHE_DURATION_SECONDS), (Long) hVar.b(CACHE_UPDATED_TIME));
    }

    public final boolean hasCacheExpired$com_google_firebase_firebase_sessions() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs != null) {
            Long cacheUpdatedTime = sessionConfigs.getCacheUpdatedTime();
            SessionConfigs sessionConfigs2 = this.sessionConfigs;
            if (sessionConfigs2 != null) {
                Integer cacheDuration = sessionConfigs2.getCacheDuration();
                if (cacheUpdatedTime != null && cacheDuration != null && (System.currentTimeMillis() - cacheUpdatedTime.longValue()) / 1000 < cacheDuration.intValue()) {
                    return false;
                }
                return true;
            }
            j.i("sessionConfigs");
            throw null;
        }
        j.i("sessionConfigs");
        throw null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|24|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0027, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        r6.toString();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object removeConfigs$com_google_firebase_firebase_sessions(w2.InterfaceC0763d r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1
            if (r0 == 0) goto L13
            r0 = r6
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            a.AbstractC0228a.C(r6)     // Catch: java.io.IOException -> L27
            goto L48
        L27:
            r6 = move-exception
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            a.AbstractC0228a.C(r6)
            R.h r6 = r5.dataStore     // Catch: java.io.IOException -> L27
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2     // Catch: java.io.IOException -> L27
            r4 = 0
            r2.<init>(r5, r4)     // Catch: java.io.IOException -> L27
            r0.label = r3     // Catch: java.io.IOException -> L27
            java.lang.Object r6 = a.AbstractC0228a.m(r6, r2, r0)     // Catch: java.io.IOException -> L27
            if (r6 != r1) goto L48
            return r1
        L45:
            r6.toString()
        L48:
            s2.i r6 = s2.C0684i.f6340a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.removeConfigs$com_google_firebase_firebase_sessions(w2.d):java.lang.Object");
    }

    public final Integer sessionRestartTimeout() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs != null) {
            return sessionConfigs.getSessionRestartTimeout();
        }
        j.i("sessionConfigs");
        throw null;
    }

    public final Double sessionSamplingRate() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs != null) {
            return sessionConfigs.getSessionSamplingRate();
        }
        j.i("sessionConfigs");
        throw null;
    }

    public final Boolean sessionsEnabled() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs != null) {
            return sessionConfigs.getSessionEnabled();
        }
        j.i("sessionConfigs");
        throw null;
    }

    public final Object updateSamplingRate(Double d2, InterfaceC0763d interfaceC0763d) {
        Object updateConfigValue = updateConfigValue(SAMPLING_RATE, d2, interfaceC0763d);
        if (updateConfigValue == EnumC0779a.f6740a) {
            return updateConfigValue;
        }
        return C0684i.f6340a;
    }

    public final Object updateSessionCacheDuration(Integer num, InterfaceC0763d interfaceC0763d) {
        Object updateConfigValue = updateConfigValue(CACHE_DURATION_SECONDS, num, interfaceC0763d);
        if (updateConfigValue == EnumC0779a.f6740a) {
            return updateConfigValue;
        }
        return C0684i.f6340a;
    }

    public final Object updateSessionCacheUpdatedTime(Long l3, InterfaceC0763d interfaceC0763d) {
        Object updateConfigValue = updateConfigValue(CACHE_UPDATED_TIME, l3, interfaceC0763d);
        if (updateConfigValue == EnumC0779a.f6740a) {
            return updateConfigValue;
        }
        return C0684i.f6340a;
    }

    public final Object updateSessionRestartTimeout(Integer num, InterfaceC0763d interfaceC0763d) {
        Object updateConfigValue = updateConfigValue(RESTART_TIMEOUT_SECONDS, num, interfaceC0763d);
        if (updateConfigValue == EnumC0779a.f6740a) {
            return updateConfigValue;
        }
        return C0684i.f6340a;
    }

    public final Object updateSettingsEnabled(Boolean bool, InterfaceC0763d interfaceC0763d) {
        Object updateConfigValue = updateConfigValue(SESSIONS_ENABLED, bool, interfaceC0763d);
        if (updateConfigValue == EnumC0779a.f6740a) {
            return updateConfigValue;
        }
        return C0684i.f6340a;
    }
}
