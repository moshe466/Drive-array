package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.bc;
import com.google.android.gms.internal.measurement.pf;
import com.google.android.gms.internal.measurement.rf;
import java.util.Map;

@DynamiteApi
/* loaded from: classes.dex */
public class AppMeasurementDynamiteService extends pf {

    /* renamed from: a, reason: collision with root package name */
    t4 f5790a = null;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, v2.l> f5791b = new l.a();

    /* loaded from: classes.dex */
    class a implements v2.j {

        /* renamed from: a, reason: collision with root package name */
        private com.google.android.gms.internal.measurement.c f5792a;

        a(com.google.android.gms.internal.measurement.c cVar) {
            this.f5792a = cVar;
        }

        @Override // v2.j
        public final void a(String str, String str2, Bundle bundle, long j10) {
            try {
                this.f5792a.C(str, str2, bundle, j10);
            } catch (RemoteException e10) {
                AppMeasurementDynamiteService.this.f5790a.h().I().b("Event interceptor threw exception", e10);
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements v2.l {

        /* renamed from: a, reason: collision with root package name */
        private com.google.android.gms.internal.measurement.c f5794a;

        b(com.google.android.gms.internal.measurement.c cVar) {
            this.f5794a = cVar;
        }

        @Override // v2.l
        public final void a(String str, String str2, Bundle bundle, long j10) {
            try {
                this.f5794a.C(str, str2, bundle, j10);
            } catch (RemoteException e10) {
                AppMeasurementDynamiteService.this.f5790a.h().I().b("Event listener threw exception", e10);
            }
        }
    }

    private final void n() {
        if (this.f5790a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void p(rf rfVar, String str) {
        this.f5790a.G().R(rfVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void beginAdUnitExposure(String str, long j10) {
        n();
        this.f5790a.S().z(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        n();
        this.f5790a.F().u0(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void clearMeasurementEnabled(long j10) {
        n();
        this.f5790a.F().L(null);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void endAdUnitExposure(String str, long j10) {
        n();
        this.f5790a.S().D(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void generateEventId(rf rfVar) {
        n();
        this.f5790a.G().P(rfVar, this.f5790a.G().E0());
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void getAppInstanceId(rf rfVar) {
        n();
        this.f5790a.e().z(new u5(this, rfVar));
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void getCachedAppInstanceId(rf rfVar) {
        n();
        p(rfVar, this.f5790a.F().i0());
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void getConditionalUserProperties(String str, String str2, rf rfVar) {
        n();
        this.f5790a.e().z(new s8(this, rfVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void getCurrentScreenClass(rf rfVar) {
        n();
        p(rfVar, this.f5790a.F().l0());
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void getCurrentScreenName(rf rfVar) {
        n();
        p(rfVar, this.f5790a.F().k0());
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void getGmpAppId(rf rfVar) {
        n();
        p(rfVar, this.f5790a.F().m0());
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void getMaxUserProperties(String str, rf rfVar) {
        n();
        this.f5790a.F();
        b2.p.g(str);
        this.f5790a.G().O(rfVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void getTestFlag(rf rfVar, int i10) {
        n();
        if (i10 == 0) {
            this.f5790a.G().R(rfVar, this.f5790a.F().e0());
            return;
        }
        if (i10 == 1) {
            this.f5790a.G().P(rfVar, this.f5790a.F().f0().longValue());
            return;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                this.f5790a.G().O(rfVar, this.f5790a.F().g0().intValue());
                return;
            } else {
                if (i10 != 4) {
                    return;
                }
                this.f5790a.G().T(rfVar, this.f5790a.F().d0().booleanValue());
                return;
            }
        }
        o9 G = this.f5790a.G();
        double doubleValue = this.f5790a.F().h0().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", doubleValue);
        try {
            rfVar.f(bundle);
        } catch (RemoteException e10) {
            G.f6381a.h().I().b("Error returning double value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void getUserProperties(String str, String str2, boolean z10, rf rfVar) {
        n();
        this.f5790a.e().z(new u6(this, rfVar, str, str2, z10));
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void initForTests(Map map) {
        n();
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void initialize(j2.a aVar, com.google.android.gms.internal.measurement.f fVar, long j10) {
        Context context = (Context) j2.b.p(aVar);
        t4 t4Var = this.f5790a;
        if (t4Var == null) {
            this.f5790a = t4.b(context, fVar, Long.valueOf(j10));
        } else {
            t4Var.h().I().a("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void isDataCollectionEnabled(rf rfVar) {
        n();
        this.f5790a.e().z(new u9(this, rfVar));
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        n();
        this.f5790a.F().T(str, str2, bundle, z10, z11, j10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void logEventAndBundle(String str, String str2, Bundle bundle, rf rfVar, long j10) {
        n();
        b2.p.g(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.f5790a.e().z(new s7(this, rfVar, new q(str2, new p(bundle), "app", j10), str));
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void logHealthData(int i10, String str, j2.a aVar, j2.a aVar2, j2.a aVar3) {
        n();
        this.f5790a.h().B(i10, true, false, str, aVar == null ? null : j2.b.p(aVar), aVar2 == null ? null : j2.b.p(aVar2), aVar3 != null ? j2.b.p(aVar3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void onActivityCreated(j2.a aVar, Bundle bundle, long j10) {
        n();
        s6 s6Var = this.f5790a.F().f6587c;
        if (s6Var != null) {
            this.f5790a.F().c0();
            s6Var.onActivityCreated((Activity) j2.b.p(aVar), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void onActivityDestroyed(j2.a aVar, long j10) {
        n();
        s6 s6Var = this.f5790a.F().f6587c;
        if (s6Var != null) {
            this.f5790a.F().c0();
            s6Var.onActivityDestroyed((Activity) j2.b.p(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void onActivityPaused(j2.a aVar, long j10) {
        n();
        s6 s6Var = this.f5790a.F().f6587c;
        if (s6Var != null) {
            this.f5790a.F().c0();
            s6Var.onActivityPaused((Activity) j2.b.p(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void onActivityResumed(j2.a aVar, long j10) {
        n();
        s6 s6Var = this.f5790a.F().f6587c;
        if (s6Var != null) {
            this.f5790a.F().c0();
            s6Var.onActivityResumed((Activity) j2.b.p(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void onActivitySaveInstanceState(j2.a aVar, rf rfVar, long j10) {
        n();
        s6 s6Var = this.f5790a.F().f6587c;
        Bundle bundle = new Bundle();
        if (s6Var != null) {
            this.f5790a.F().c0();
            s6Var.onActivitySaveInstanceState((Activity) j2.b.p(aVar), bundle);
        }
        try {
            rfVar.f(bundle);
        } catch (RemoteException e10) {
            this.f5790a.h().I().b("Error returning bundle value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void onActivityStarted(j2.a aVar, long j10) {
        n();
        s6 s6Var = this.f5790a.F().f6587c;
        if (s6Var != null) {
            this.f5790a.F().c0();
            s6Var.onActivityStarted((Activity) j2.b.p(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void onActivityStopped(j2.a aVar, long j10) {
        n();
        s6 s6Var = this.f5790a.F().f6587c;
        if (s6Var != null) {
            this.f5790a.F().c0();
            s6Var.onActivityStopped((Activity) j2.b.p(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void performAction(Bundle bundle, rf rfVar, long j10) {
        n();
        rfVar.f(null);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.c cVar) {
        v2.l lVar;
        n();
        synchronized (this.f5791b) {
            lVar = this.f5791b.get(Integer.valueOf(cVar.zza()));
            if (lVar == null) {
                lVar = new b(cVar);
                this.f5791b.put(Integer.valueOf(cVar.zza()), lVar);
            }
        }
        this.f5790a.F().b0(lVar);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void resetAnalyticsData(long j10) {
        n();
        w5 F = this.f5790a.F();
        F.N(null);
        F.e().z(new f6(F, j10));
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setConditionalUserProperty(Bundle bundle, long j10) {
        n();
        if (bundle == null) {
            this.f5790a.h().F().a("Conditional user property must not be null");
        } else {
            this.f5790a.F().G(bundle, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setConsent(Bundle bundle, long j10) {
        n();
        w5 F = this.f5790a.F();
        if (bc.a() && F.m().A(null, s.H0)) {
            F.F(bundle, 30, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setConsentThirdParty(Bundle bundle, long j10) {
        n();
        w5 F = this.f5790a.F();
        if (bc.a() && F.m().A(null, s.I0)) {
            F.F(bundle, 10, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setCurrentScreen(j2.a aVar, String str, String str2, long j10) {
        n();
        this.f5790a.O().I((Activity) j2.b.p(aVar), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setDataCollectionEnabled(boolean z10) {
        n();
        w5 F = this.f5790a.F();
        F.w();
        F.e().z(new a6(F, z10));
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setDefaultEventParameters(Bundle bundle) {
        n();
        final w5 F = this.f5790a.F();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        F.e().z(new Runnable(F, bundle2) { // from class: com.google.android.gms.measurement.internal.v5

            /* renamed from: f, reason: collision with root package name */
            private final w5 f6550f;

            /* renamed from: g, reason: collision with root package name */
            private final Bundle f6551g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f6550f = F;
                this.f6551g = bundle2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f6550f.o0(this.f6551g);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setEventInterceptor(com.google.android.gms.internal.measurement.c cVar) {
        n();
        a aVar = new a(cVar);
        if (this.f5790a.e().I()) {
            this.f5790a.F().a0(aVar);
        } else {
            this.f5790a.e().z(new t9(this, aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.d dVar) {
        n();
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setMeasurementEnabled(boolean z10, long j10) {
        n();
        this.f5790a.F().L(Boolean.valueOf(z10));
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setMinimumSessionDuration(long j10) {
        n();
        w5 F = this.f5790a.F();
        F.e().z(new c6(F, j10));
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setSessionTimeoutDuration(long j10) {
        n();
        w5 F = this.f5790a.F();
        F.e().z(new b6(F, j10));
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setUserId(String str, long j10) {
        n();
        this.f5790a.F().W(null, "_id", str, true, j10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void setUserProperty(String str, String str2, j2.a aVar, boolean z10, long j10) {
        n();
        this.f5790a.F().W(str, str2, j2.b.p(aVar), z10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.c cVar) {
        v2.l remove;
        n();
        synchronized (this.f5791b) {
            remove = this.f5791b.remove(Integer.valueOf(cVar.zza()));
        }
        if (remove == null) {
            remove = new b(cVar);
        }
        this.f5790a.F().s0(remove);
    }
}
