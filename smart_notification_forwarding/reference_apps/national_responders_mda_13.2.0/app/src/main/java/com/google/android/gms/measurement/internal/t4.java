package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.bc;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class t4 implements s5 {
    private static volatile t4 H;
    private volatile Boolean A;
    private Boolean B;
    private Boolean C;
    private volatile boolean D;
    private int E;
    final long G;

    /* renamed from: a, reason: collision with root package name */
    private final Context f6467a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6468b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6469c;

    /* renamed from: d, reason: collision with root package name */
    private final String f6470d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f6471e;

    /* renamed from: f, reason: collision with root package name */
    private final ea f6472f;

    /* renamed from: g, reason: collision with root package name */
    private final c f6473g;

    /* renamed from: h, reason: collision with root package name */
    private final e4 f6474h;

    /* renamed from: i, reason: collision with root package name */
    private final r3 f6475i;

    /* renamed from: j, reason: collision with root package name */
    private final q4 f6476j;

    /* renamed from: k, reason: collision with root package name */
    private final p8 f6477k;

    /* renamed from: l, reason: collision with root package name */
    private final o9 f6478l;

    /* renamed from: m, reason: collision with root package name */
    private final p3 f6479m;

    /* renamed from: n, reason: collision with root package name */
    private final g2.e f6480n;

    /* renamed from: o, reason: collision with root package name */
    private final b7 f6481o;

    /* renamed from: p, reason: collision with root package name */
    private final w5 f6482p;

    /* renamed from: q, reason: collision with root package name */
    private final a f6483q;

    /* renamed from: r, reason: collision with root package name */
    private final x6 f6484r;

    /* renamed from: s, reason: collision with root package name */
    private n3 f6485s;

    /* renamed from: t, reason: collision with root package name */
    private k7 f6486t;

    /* renamed from: u, reason: collision with root package name */
    private k f6487u;

    /* renamed from: v, reason: collision with root package name */
    private o3 f6488v;

    /* renamed from: w, reason: collision with root package name */
    private n4 f6489w;

    /* renamed from: y, reason: collision with root package name */
    private Boolean f6491y;

    /* renamed from: z, reason: collision with root package name */
    private long f6492z;

    /* renamed from: x, reason: collision with root package name */
    private boolean f6490x = false;
    private AtomicInteger F = new AtomicInteger(0);

    private t4(t5 t5Var) {
        t3 I;
        String str;
        Bundle bundle;
        boolean z10 = false;
        b2.p.k(t5Var);
        ea eaVar = new ea(t5Var.f6493a);
        this.f6472f = eaVar;
        j3.f6131a = eaVar;
        Context context = t5Var.f6493a;
        this.f6467a = context;
        this.f6468b = t5Var.f6494b;
        this.f6469c = t5Var.f6495c;
        this.f6470d = t5Var.f6496d;
        this.f6471e = t5Var.f6500h;
        this.A = t5Var.f6497e;
        this.D = true;
        com.google.android.gms.internal.measurement.f fVar = t5Var.f6499g;
        if (fVar != null && (bundle = fVar.f5301l) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.B = (Boolean) obj;
            }
            Object obj2 = fVar.f5301l.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.C = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.t2.h(context);
        g2.e d10 = g2.h.d();
        this.f6480n = d10;
        Long l10 = t5Var.f6501i;
        this.G = l10 != null ? l10.longValue() : d10.a();
        this.f6473g = new c(this);
        e4 e4Var = new e4(this);
        e4Var.r();
        this.f6474h = e4Var;
        r3 r3Var = new r3(this);
        r3Var.r();
        this.f6475i = r3Var;
        o9 o9Var = new o9(this);
        o9Var.r();
        this.f6478l = o9Var;
        p3 p3Var = new p3(this);
        p3Var.r();
        this.f6479m = p3Var;
        this.f6483q = new a(this);
        b7 b7Var = new b7(this);
        b7Var.x();
        this.f6481o = b7Var;
        w5 w5Var = new w5(this);
        w5Var.x();
        this.f6482p = w5Var;
        p8 p8Var = new p8(this);
        p8Var.x();
        this.f6477k = p8Var;
        x6 x6Var = new x6(this);
        x6Var.r();
        this.f6484r = x6Var;
        q4 q4Var = new q4(this);
        q4Var.r();
        this.f6476j = q4Var;
        com.google.android.gms.internal.measurement.f fVar2 = t5Var.f6499g;
        if (fVar2 != null && fVar2.f5296g != 0) {
            z10 = true;
        }
        boolean z11 = !z10;
        if (context.getApplicationContext() instanceof Application) {
            w5 F = F();
            if (F.i().getApplicationContext() instanceof Application) {
                Application application = (Application) F.i().getApplicationContext();
                if (F.f6587c == null) {
                    F.f6587c = new s6(F, null);
                }
                if (z11) {
                    application.unregisterActivityLifecycleCallbacks(F.f6587c);
                    application.registerActivityLifecycleCallbacks(F.f6587c);
                    I = F.h().N();
                    str = "Registered activity lifecycle callback";
                }
            }
            q4Var.z(new v4(this, t5Var));
        }
        I = h().I();
        str = "Application context is not an Application";
        I.a(str);
        q4Var.z(new v4(this, t5Var));
    }

    public static t4 b(Context context, com.google.android.gms.internal.measurement.f fVar, Long l10) {
        Bundle bundle;
        if (fVar != null && (fVar.f5299j == null || fVar.f5300k == null)) {
            fVar = new com.google.android.gms.internal.measurement.f(fVar.f5295f, fVar.f5296g, fVar.f5297h, fVar.f5298i, null, null, fVar.f5301l);
        }
        b2.p.k(context);
        b2.p.k(context.getApplicationContext());
        if (H == null) {
            synchronized (t4.class) {
                if (H == null) {
                    H = new t4(new t5(context, fVar, l10));
                }
            }
        } else if (fVar != null && (bundle = fVar.f5301l) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            H.o(fVar.f5301l.getBoolean("dataCollectionDefaultEnabled"));
        }
        return H;
    }

    private static void k(r5 r5Var) {
        if (r5Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(t5 t5Var) {
        String concat;
        t3 t3Var;
        e().c();
        k kVar = new k(this);
        kVar.r();
        this.f6487u = kVar;
        o3 o3Var = new o3(this, t5Var.f6498f);
        o3Var.x();
        this.f6488v = o3Var;
        n3 n3Var = new n3(this);
        n3Var.x();
        this.f6485s = n3Var;
        k7 k7Var = new k7(this);
        k7Var.x();
        this.f6486t = k7Var;
        this.f6478l.s();
        this.f6474h.s();
        this.f6489w = new n4(this);
        this.f6488v.y();
        h().L().b("App measurement initialized, version", 33025L);
        h().L().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String C = o3Var.C();
        if (TextUtils.isEmpty(this.f6468b)) {
            if (G().D0(C)) {
                t3Var = h().L();
                concat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                t3 L = h().L();
                String valueOf = String.valueOf(C);
                concat = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                t3Var = L;
            }
            t3Var.a(concat);
        }
        h().M().a("Debug-level message logging enabled");
        if (this.E != this.F.get()) {
            h().F().c("Not all components initialized", Integer.valueOf(this.E), Integer.valueOf(this.F.get()));
        }
        this.f6490x = true;
    }

    private final x6 w() {
        z(this.f6484r);
        return this.f6484r;
    }

    private static void y(z4 z4Var) {
        if (z4Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (z4Var.v()) {
            return;
        }
        String valueOf = String.valueOf(z4Var.getClass());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 27);
        sb2.append("Component not initialized: ");
        sb2.append(valueOf);
        throw new IllegalStateException(sb2.toString());
    }

    private static void z(q5 q5Var) {
        if (q5Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (q5Var.p()) {
            return;
        }
        String valueOf = String.valueOf(q5Var.getClass());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 27);
        sb2.append("Component not initialized: ");
        sb2.append(valueOf);
        throw new IllegalStateException(sb2.toString());
    }

    public final void A(boolean z10) {
        e().c();
        this.D = z10;
    }

    public final r3 B() {
        r3 r3Var = this.f6475i;
        if (r3Var == null || !r3Var.p()) {
            return null;
        }
        return this.f6475i;
    }

    public final p8 C() {
        y(this.f6477k);
        return this.f6477k;
    }

    public final n4 D() {
        return this.f6489w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final q4 E() {
        return this.f6476j;
    }

    public final w5 F() {
        y(this.f6482p);
        return this.f6482p;
    }

    public final o9 G() {
        k(this.f6478l);
        return this.f6478l;
    }

    public final p3 H() {
        k(this.f6479m);
        return this.f6479m;
    }

    public final n3 I() {
        y(this.f6485s);
        return this.f6485s;
    }

    public final boolean J() {
        return TextUtils.isEmpty(this.f6468b);
    }

    public final String K() {
        return this.f6468b;
    }

    public final String L() {
        return this.f6469c;
    }

    public final String M() {
        return this.f6470d;
    }

    public final boolean N() {
        return this.f6471e;
    }

    public final b7 O() {
        y(this.f6481o);
        return this.f6481o;
    }

    public final k7 P() {
        y(this.f6486t);
        return this.f6486t;
    }

    public final k Q() {
        z(this.f6487u);
        return this.f6487u;
    }

    public final o3 R() {
        y(this.f6488v);
        return this.f6488v;
    }

    public final a S() {
        a aVar = this.f6483q;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public final boolean T() {
        return this.A != null && this.A.booleanValue();
    }

    public final c a() {
        return this.f6473g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009a, code lost:
    
        if (r10 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00bb, code lost:
    
        F().Y(r10, r5, r9.G);
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
    
        if (r10.equals(v2.a.f14619c) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b9, code lost:
    
        if (r10.equals(v2.a.f14619c) == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(com.google.android.gms.internal.measurement.f r10) {
        /*
            Method dump skipped, instructions count: 861
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.t4.c(com.google.android.gms.internal.measurement.f):void");
    }

    @Override // com.google.android.gms.measurement.internal.s5
    public final q4 e() {
        z(this.f6476j);
        return this.f6476j;
    }

    @Override // com.google.android.gms.measurement.internal.s5
    public final g2.e f() {
        return this.f6480n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(z4 z4Var) {
        this.E++;
    }

    @Override // com.google.android.gms.measurement.internal.s5
    public final r3 h() {
        z(this.f6475i);
        return this.f6475i;
    }

    @Override // com.google.android.gms.measurement.internal.s5
    public final Context i() {
        return this.f6467a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(q5 q5Var) {
        this.E++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void m(String str, int i10, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z10 = true;
        if (!((i10 == 200 || i10 == 204 || i10 == 304) && th == null)) {
            h().I().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i10), th);
            return;
        }
        x().f5977x.a(true);
        if (bArr.length == 0) {
            h().M().a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                h().M().a("Deferred Deep Link is empty.");
                return;
            }
            o9 G = G();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = G.i().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z10 = false;
            }
            if (!z10) {
                h().I().c("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.f6482p.R("auto", "_cmp", bundle);
            o9 G2 = G();
            if (TextUtils.isEmpty(optString) || !G2.f0(optString, optDouble)) {
                return;
            }
            G2.i().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e10) {
            h().F().b("Failed to parse the Deferred Deep Link response. exception", e10);
        }
    }

    @Override // com.google.android.gms.measurement.internal.s5
    public final ea n() {
        return this.f6472f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o(boolean z10) {
        this.A = Boolean.valueOf(z10);
    }

    public final boolean p() {
        return q() == 0;
    }

    public final int q() {
        e().c();
        if (this.f6473g.F()) {
            return 1;
        }
        Boolean bool = this.C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (bc.a() && this.f6473g.t(s.H0) && !r()) {
            return 8;
        }
        Boolean J = x().J();
        if (J != null) {
            return J.booleanValue() ? 0 : 3;
        }
        Boolean E = this.f6473g.E("firebase_analytics_collection_enabled");
        if (E != null) {
            return E.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.B;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        if (com.google.android.gms.common.api.internal.h.d()) {
            return 6;
        }
        return (!this.f6473g.t(s.S) || this.A == null || this.A.booleanValue()) ? 0 : 7;
    }

    public final boolean r() {
        e().c();
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t() {
        this.F.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean u() {
        if (!this.f6490x) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        e().c();
        Boolean bool = this.f6491y;
        if (bool == null || this.f6492z == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.f6480n.b() - this.f6492z) > 1000)) {
            this.f6492z = this.f6480n.b();
            boolean z10 = true;
            Boolean valueOf = Boolean.valueOf(G().A0("android.permission.INTERNET") && G().A0("android.permission.ACCESS_NETWORK_STATE") && (i2.c.a(this.f6467a).f() || this.f6473g.T() || (v2.e.b(this.f6467a) && o9.Z(this.f6467a, false))));
            this.f6491y = valueOf;
            if (valueOf.booleanValue()) {
                if (!G().j0(R().D(), R().E(), R().F()) && TextUtils.isEmpty(R().E())) {
                    z10 = false;
                }
                this.f6491y = Boolean.valueOf(z10);
            }
        }
        return this.f6491y.booleanValue();
    }

    public final void v() {
        e().c();
        z(w());
        String C = R().C();
        Pair<String, Boolean> u10 = x().u(C);
        if (!this.f6473g.G().booleanValue() || ((Boolean) u10.second).booleanValue() || TextUtils.isEmpty((CharSequence) u10.first)) {
            h().M().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        if (!w().x()) {
            h().I().a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        o9 G = G();
        R();
        URL J = G.J(33025L, C, (String) u10.first, x().f5978y.a() - 1);
        x6 w10 = w();
        w6 w6Var = new w6(this) { // from class: com.google.android.gms.measurement.internal.w4

            /* renamed from: a, reason: collision with root package name */
            private final t4 f6586a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f6586a = this;
            }

            @Override // com.google.android.gms.measurement.internal.w6
            public final void a(String str, int i10, Throwable th, byte[] bArr, Map map) {
                this.f6586a.m(str, i10, th, bArr, map);
            }
        };
        w10.c();
        w10.q();
        b2.p.k(J);
        b2.p.k(w6Var);
        w10.e().F(new z6(w10, C, J, null, null, w6Var));
    }

    public final e4 x() {
        k(this.f6474h);
        return this.f6474h;
    }
}
