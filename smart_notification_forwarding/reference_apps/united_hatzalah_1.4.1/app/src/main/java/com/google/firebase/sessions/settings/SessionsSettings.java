package com.google.firebase.sessions.settings;

import O2.a;
import O2.c;
import T.b;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.LocalOverrideSettingsProvider;
import com.google.firebase.sessions.RemoteSettingsProvider;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class SessionsSettings {
    public static final Companion Companion = new Companion(null);
    private final SettingsProvider localOverrideSettings;
    private final SettingsProvider remoteSettings;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final SessionsSettings getInstance() {
            return ((FirebaseSessionsComponent) FirebaseKt.getApp(Firebase.INSTANCE).get(FirebaseSessionsComponent.class)).getSessionsSettings();
        }

        private Companion() {
        }
    }

    public SessionsSettings(@LocalOverrideSettingsProvider SettingsProvider localOverrideSettings, @RemoteSettingsProvider SettingsProvider remoteSettings) {
        j.e(localOverrideSettings, "localOverrideSettings");
        j.e(remoteSettings, "remoteSettings");
        this.localOverrideSettings = localOverrideSettings;
        this.remoteSettings = remoteSettings;
    }

    private final boolean isValidSamplingRate(double d2) {
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE <= d2 && d2 <= 1.0d;
    }

    /* renamed from: isValidSessionRestartTimeout-LRDsOJo, reason: not valid java name */
    private final boolean m13isValidSessionRestartTimeoutLRDsOJo(long j2) {
        int i = a.f1537d;
        if (j2 > 0 && !a.b(j2)) {
            return true;
        }
        return false;
    }

    public final double getSamplingRate() {
        Double samplingRate = this.localOverrideSettings.getSamplingRate();
        if (samplingRate != null) {
            double doubleValue = samplingRate.doubleValue();
            if (isValidSamplingRate(doubleValue)) {
                return doubleValue;
            }
        }
        Double samplingRate2 = this.remoteSettings.getSamplingRate();
        if (samplingRate2 != null) {
            double doubleValue2 = samplingRate2.doubleValue();
            if (isValidSamplingRate(doubleValue2)) {
                return doubleValue2;
            }
            return 1.0d;
        }
        return 1.0d;
    }

    /* renamed from: getSessionRestartTimeout-UwyO8pc, reason: not valid java name */
    public final long m14getSessionRestartTimeoutUwyO8pc() {
        a mo12getSessionRestartTimeoutFghU774 = this.localOverrideSettings.mo12getSessionRestartTimeoutFghU774();
        if (mo12getSessionRestartTimeoutFghU774 != null) {
            long j2 = mo12getSessionRestartTimeoutFghU774.f1538a;
            if (m13isValidSessionRestartTimeoutLRDsOJo(j2)) {
                return j2;
            }
        }
        a mo12getSessionRestartTimeoutFghU7742 = this.remoteSettings.mo12getSessionRestartTimeoutFghU774();
        if (mo12getSessionRestartTimeoutFghU7742 != null) {
            long j3 = mo12getSessionRestartTimeoutFghU7742.f1538a;
            if (m13isValidSessionRestartTimeoutLRDsOJo(j3)) {
                return j3;
            }
        }
        int i = a.f1537d;
        return b.M(30, c.f1543e);
    }

    public final boolean getSessionsEnabled() {
        Boolean sessionEnabled = this.localOverrideSettings.getSessionEnabled();
        if (sessionEnabled != null) {
            return sessionEnabled.booleanValue();
        }
        Boolean sessionEnabled2 = this.remoteSettings.getSessionEnabled();
        if (sessionEnabled2 != null) {
            return sessionEnabled2.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
    
        if (r6.updateSettings(r0) != r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateSettings(w2.InterfaceC0763d r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            if (r0 == 0) goto L13
            r0 = r6
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            a.AbstractC0228a.C(r6)
            goto L59
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            java.lang.Object r2 = r0.L$0
            com.google.firebase.sessions.settings.SessionsSettings r2 = (com.google.firebase.sessions.settings.SessionsSettings) r2
            a.AbstractC0228a.C(r6)
            goto L4b
        L3a:
            a.AbstractC0228a.C(r6)
            com.google.firebase.sessions.settings.SettingsProvider r6 = r5.localOverrideSettings
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.updateSettings(r0)
            if (r6 != r1) goto L4a
            goto L58
        L4a:
            r2 = r5
        L4b:
            com.google.firebase.sessions.settings.SettingsProvider r6 = r2.remoteSettings
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.updateSettings(r0)
            if (r6 != r1) goto L59
        L58:
            return r1
        L59:
            s2.i r6 = s2.C0684i.f6340a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SessionsSettings.updateSettings(w2.d):java.lang.Object");
    }
}
