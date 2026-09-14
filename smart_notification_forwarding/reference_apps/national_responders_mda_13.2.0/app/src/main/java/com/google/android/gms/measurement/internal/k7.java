package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bc;
import com.google.android.gms.internal.measurement.rf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class k7 extends z4 {

    /* renamed from: c, reason: collision with root package name */
    private final e8 f6163c;

    /* renamed from: d, reason: collision with root package name */
    private v2.c f6164d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Boolean f6165e;

    /* renamed from: f, reason: collision with root package name */
    private final i f6166f;

    /* renamed from: g, reason: collision with root package name */
    private final x8 f6167g;

    /* renamed from: h, reason: collision with root package name */
    private final List<Runnable> f6168h;

    /* renamed from: i, reason: collision with root package name */
    private final i f6169i;

    /* JADX INFO: Access modifiers changed from: protected */
    public k7(t4 t4Var) {
        super(t4Var);
        this.f6168h = new ArrayList();
        this.f6167g = new x8(t4Var.f());
        this.f6163c = new e8(this);
        this.f6166f = new j7(this, t4Var);
        this.f6169i = new t7(this, t4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ v2.c C(k7 k7Var, v2.c cVar) {
        k7Var.f6164d = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(ComponentName componentName) {
        c();
        if (this.f6164d != null) {
            this.f6164d = null;
            h().N().b("Disconnected from device MeasurementService", componentName);
            c();
            Z();
        }
    }

    private final void O(Runnable runnable) {
        c();
        if (V()) {
            runnable.run();
        } else {
            if (this.f6168h.size() >= 1000) {
                h().F().a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f6168h.add(runnable);
            this.f6169i.c(60000L);
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        c();
        this.f6167g.a();
        this.f6166f.c(s.J.a(null).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean f0() {
        /*
            r5 = this;
            r5.c()
            r5.w()
            java.lang.Boolean r0 = r5.f6165e
            if (r0 != 0) goto Lfb
            r5.c()
            r5.w()
            com.google.android.gms.measurement.internal.e4 r0 = r5.l()
            java.lang.Boolean r0 = r0.H()
            r1 = 1
            if (r0 == 0) goto L23
            boolean r2 = r0.booleanValue()
            if (r2 == 0) goto L23
            goto Lf5
        L23:
            com.google.android.gms.measurement.internal.o3 r2 = r5.q()
            int r2 = r2.H()
            r3 = 0
            if (r2 != r1) goto L31
        L2e:
            r0 = 1
            goto Ld1
        L31:
            com.google.android.gms.measurement.internal.r3 r2 = r5.h()
            com.google.android.gms.measurement.internal.t3 r2 = r2.N()
            java.lang.String r4 = "Checking service availability"
            r2.a(r4)
            com.google.android.gms.measurement.internal.o9 r2 = r5.k()
            r4 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r2 = r2.u(r4)
            if (r2 == 0) goto Lc2
            if (r2 == r1) goto Lb2
            r4 = 2
            if (r2 == r4) goto L92
            r0 = 3
            if (r2 == r0) goto L83
            r0 = 9
            if (r2 == r0) goto L78
            r0 = 18
            if (r2 == r0) goto L6d
            com.google.android.gms.measurement.internal.r3 r0 = r5.h()
            com.google.android.gms.measurement.internal.t3 r0 = r0.I()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "Unexpected service status"
            r0.b(r2, r1)
            goto L90
        L6d:
            com.google.android.gms.measurement.internal.r3 r0 = r5.h()
            com.google.android.gms.measurement.internal.t3 r0 = r0.I()
            java.lang.String r2 = "Service updating"
            goto Lcc
        L78:
            com.google.android.gms.measurement.internal.r3 r0 = r5.h()
            com.google.android.gms.measurement.internal.t3 r0 = r0.I()
            java.lang.String r1 = "Service invalid"
            goto L8d
        L83:
            com.google.android.gms.measurement.internal.r3 r0 = r5.h()
            com.google.android.gms.measurement.internal.t3 r0 = r0.I()
            java.lang.String r1 = "Service disabled"
        L8d:
            r0.a(r1)
        L90:
            r0 = 0
            goto Lc0
        L92:
            com.google.android.gms.measurement.internal.r3 r2 = r5.h()
            com.google.android.gms.measurement.internal.t3 r2 = r2.M()
            java.lang.String r4 = "Service container out of date"
            r2.a(r4)
            com.google.android.gms.measurement.internal.o9 r2 = r5.k()
            int r2 = r2.K0()
            r4 = 17443(0x4423, float:2.4443E-41)
            if (r2 >= r4) goto Lac
            goto Lbf
        Lac:
            if (r0 != 0) goto Laf
            goto Lb0
        Laf:
            r1 = 0
        Lb0:
            r0 = 0
            goto Ld1
        Lb2:
            com.google.android.gms.measurement.internal.r3 r0 = r5.h()
            com.google.android.gms.measurement.internal.t3 r0 = r0.N()
            java.lang.String r2 = "Service missing"
            r0.a(r2)
        Lbf:
            r0 = 1
        Lc0:
            r1 = 0
            goto Ld1
        Lc2:
            com.google.android.gms.measurement.internal.r3 r0 = r5.h()
            com.google.android.gms.measurement.internal.t3 r0 = r0.N()
            java.lang.String r2 = "Service available"
        Lcc:
            r0.a(r2)
            goto L2e
        Ld1:
            if (r1 != 0) goto Leb
            com.google.android.gms.measurement.internal.c r2 = r5.m()
            boolean r2 = r2.T()
            if (r2 == 0) goto Leb
            com.google.android.gms.measurement.internal.r3 r0 = r5.h()
            com.google.android.gms.measurement.internal.t3 r0 = r0.F()
            java.lang.String r2 = "No way to upload. Consider using the full version of Analytics"
            r0.a(r2)
            goto Lec
        Leb:
            r3 = r0
        Lec:
            if (r3 == 0) goto Lf5
            com.google.android.gms.measurement.internal.e4 r0 = r5.l()
            r0.w(r1)
        Lf5:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r5.f6165e = r0
        Lfb:
            java.lang.Boolean r0 = r5.f6165e
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.k7.f0():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        c();
        if (V()) {
            h().N().a("Inactivity, disconnecting from the service");
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        c();
        h().N().b("Processing queued up service tasks", Integer.valueOf(this.f6168h.size()));
        Iterator<Runnable> it = this.f6168h.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e10) {
                h().F().b("Task exception while flushing queue", e10);
            }
        }
        this.f6168h.clear();
        this.f6169i.e();
    }

    private final v9 i0(boolean z10) {
        return q().B(z10 ? h().O() : null);
    }

    public final void E(Bundle bundle) {
        c();
        w();
        O(new u7(this, bundle, i0(false)));
    }

    public final void F(rf rfVar) {
        c();
        w();
        O(new o7(this, i0(false), rfVar));
    }

    public final void G(rf rfVar, q qVar, String str) {
        c();
        w();
        if (k().u(com.google.android.gms.common.e.f5095a) == 0) {
            O(new w7(this, qVar, str, rfVar));
        } else {
            h().I().a("Not bundling data. Service unavailable or out of date");
            k().U(rfVar, new byte[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void H(rf rfVar, String str, String str2) {
        c();
        w();
        O(new c8(this, str, str2, i0(false), rfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I(rf rfVar, String str, String str2, boolean z10) {
        c();
        w();
        O(new m7(this, str, str2, z10, i0(false), rfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J(q qVar, String str) {
        b2.p.k(qVar);
        c();
        w();
        O(new x7(this, true, t().E(qVar), qVar, i0(true), str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(c7 c7Var) {
        c();
        w();
        O(new q7(this, c7Var));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M(n9 n9Var) {
        c();
        w();
        O(new l7(this, t().F(n9Var), n9Var, i0(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N(ha haVar) {
        b2.p.k(haVar);
        c();
        w();
        O(new a8(this, true, t().G(haVar), new ha(haVar), i0(true), haVar));
    }

    public final void P(AtomicReference<String> atomicReference) {
        c();
        w();
        O(new p7(this, atomicReference, i0(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q(AtomicReference<List<ha>> atomicReference, String str, String str2, String str3) {
        c();
        w();
        O(new z7(this, atomicReference, str, str2, str3, i0(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R(AtomicReference<List<n9>> atomicReference, String str, String str2, String str3, boolean z10) {
        c();
        w();
        O(new b8(this, atomicReference, str, str2, str3, z10, i0(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void S(v2.c cVar) {
        c();
        b2.p.k(cVar);
        this.f6164d = cVar;
        e0();
        h0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void T(v2.c cVar, c2.a aVar, v9 v9Var) {
        int i10;
        t3 F;
        String str;
        c();
        w();
        int i11 = 0;
        int i12 = 100;
        while (i11 < 1001 && i12 == 100) {
            ArrayList arrayList = new ArrayList();
            List<c2.a> C = t().C(100);
            if (C != null) {
                arrayList.addAll(C);
                i10 = C.size();
            } else {
                i10 = 0;
            }
            if (aVar != null && i10 < 100) {
                arrayList.add(aVar);
            }
            int size = arrayList.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj = arrayList.get(i13);
                i13++;
                c2.a aVar2 = (c2.a) obj;
                if (aVar2 instanceof q) {
                    try {
                        cVar.V((q) aVar2, v9Var);
                    } catch (RemoteException e10) {
                        e = e10;
                        F = h().F();
                        str = "Failed to send event to the service";
                        F.b(str, e);
                    }
                } else if (aVar2 instanceof n9) {
                    try {
                        cVar.g0((n9) aVar2, v9Var);
                    } catch (RemoteException e11) {
                        e = e11;
                        F = h().F();
                        str = "Failed to send user property to the service";
                        F.b(str, e);
                    }
                } else if (aVar2 instanceof ha) {
                    try {
                        cVar.l0((ha) aVar2, v9Var);
                    } catch (RemoteException e12) {
                        e = e12;
                        F = h().F();
                        str = "Failed to send conditional user property to the service";
                        F.b(str, e);
                    }
                } else {
                    h().F().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i11++;
            i12 = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U(boolean z10) {
        if (bc.a() && m().t(s.H0)) {
            c();
            w();
            if (z10) {
                t().H();
            }
            if (d0()) {
                O(new y7(this, i0(false)));
            }
        }
    }

    public final boolean V() {
        c();
        w();
        return this.f6164d != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void W() {
        c();
        w();
        O(new v7(this, i0(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void X() {
        c();
        w();
        v9 i02 = i0(false);
        t().H();
        O(new n7(this, i02));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y() {
        c();
        w();
        v9 i02 = i0(true);
        t().I();
        O(new r7(this, i02));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Z() {
        c();
        w();
        if (V()) {
            return;
        }
        if (f0()) {
            this.f6163c.d();
            return;
        }
        if (m().T()) {
            return;
        }
        List<ResolveInfo> queryIntentServices = i().getPackageManager().queryIntentServices(new Intent().setClassName(i(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (!(queryIntentServices != null && queryIntentServices.size() > 0)) {
            h().F().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(i(), "com.google.android.gms.measurement.AppMeasurementService"));
        this.f6163c.b(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean a0() {
        return this.f6165e;
    }

    public final void b0() {
        c();
        w();
        this.f6163c.a();
        try {
            f2.a.b().c(i(), this.f6163c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f6164d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c0() {
        c();
        w();
        return !f0() || k().K0() >= 200900;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d0() {
        c();
        w();
        if (m().t(s.J0)) {
            return !f0() || k().K0() >= s.K0.a(null).intValue();
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.z4
    protected final boolean z() {
        return false;
    }
}
