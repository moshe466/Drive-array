package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.ad;
import com.google.android.gms.internal.measurement.bc;
import com.google.android.gms.internal.measurement.db;
import com.google.android.gms.internal.measurement.nd;
import com.google.android.gms.internal.measurement.oc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class w5 extends z4 {

    /* renamed from: c, reason: collision with root package name */
    protected s6 f6587c;

    /* renamed from: d, reason: collision with root package name */
    private v2.j f6588d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<v2.l> f6589e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6590f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicReference<String> f6591g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f6592h;

    /* renamed from: i, reason: collision with root package name */
    private v2.a f6593i;

    /* renamed from: j, reason: collision with root package name */
    private int f6594j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicLong f6595k;

    /* renamed from: l, reason: collision with root package name */
    private long f6596l;

    /* renamed from: m, reason: collision with root package name */
    private int f6597m;

    /* renamed from: n, reason: collision with root package name */
    final w9 f6598n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6599o;

    /* renamed from: p, reason: collision with root package name */
    private final r9 f6600p;

    /* JADX INFO: Access modifiers changed from: protected */
    public w5(t4 t4Var) {
        super(t4Var);
        this.f6589e = new CopyOnWriteArraySet();
        this.f6592h = new Object();
        this.f6599o = true;
        this.f6600p = new k6(this);
        this.f6591g = new AtomicReference<>();
        this.f6593i = new v2.a(null, null);
        this.f6594j = 100;
        this.f6596l = -1L;
        this.f6597m = 100;
        this.f6595k = new AtomicLong(0L);
        this.f6598n = new w9(t4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(Boolean bool, boolean z10) {
        c();
        w();
        h().M().b("Setting app measurement enabled (FE)", bool);
        l().v(bool);
        if (bc.a() && m().t(s.H0) && z10) {
            l().A(bool);
        }
        if (bc.a() && m().t(s.H0) && !this.f6381a.r() && bool.booleanValue()) {
            return;
        }
        n0();
    }

    private final void Q(String str, String str2, long j10, Object obj) {
        e().z(new d6(this, str, str2, obj, j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(v2.a aVar, int i10, long j10, boolean z10, boolean z11) {
        c();
        w();
        if (j10 <= this.f6596l && v2.a.g(this.f6597m, i10)) {
            h().L().b("Dropped out-of-date consent setting, proposed settings", aVar);
            return;
        }
        if (!l().z(aVar, i10)) {
            h().L().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(i10));
            return;
        }
        this.f6596l = j10;
        this.f6597m = i10;
        r().U(z10);
        if (z11) {
            r().P(new AtomicReference<>());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        c();
        String a10 = l().f5972s.a();
        if (a10 != null) {
            if ("unset".equals(a10)) {
                U("app", "_npa", null, f().a());
            } else {
                U("app", "_npa", Long.valueOf("true".equals(a10) ? 1L : 0L), f().a());
            }
        }
        if (!this.f6381a.p() || !this.f6599o) {
            h().M().a("Updating Scion state (FE)");
            r().W();
            return;
        }
        h().M().a("Recording app launch after enabling measurement for the first time (FE)");
        j0();
        if (ad.a() && m().t(s.f6425q0)) {
            u().f6325d.a();
        }
        if (oc.a() && m().t(s.f6431t0)) {
            if (!(this.f6381a.D().f6248a.x().f5964k.a() > 0)) {
                n4 D = this.f6381a.D();
                D.b(D.f6248a.i().getPackageName());
            }
        }
        if (m().t(s.D0)) {
            e().z(new z5(this));
        }
    }

    private final void q0(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        e().z(new e6(this, str, str2, j10, o9.s0(bundle), z10, z11, z12, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(Bundle bundle) {
        c();
        w();
        b2.p.k(bundle);
        b2.p.g(bundle.getString("name"));
        b2.p.g(bundle.getString("origin"));
        b2.p.k(bundle.get("value"));
        if (!this.f6381a.p()) {
            h().N().a("Conditional property not set since app measurement is disabled");
            return;
        }
        try {
            r().N(new ha(bundle.getString("app_id"), bundle.getString("origin"), new n9(bundle.getString("name"), bundle.getLong("triggered_timestamp"), bundle.get("value"), bundle.getString("origin")), bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), k().F(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), bundle.getString("origin"), 0L, true, false, db.a() && m().t(s.L0)), bundle.getLong("trigger_timeout"), k().F(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), bundle.getString("origin"), 0L, true, false, db.a() && m().t(s.L0)), bundle.getLong("time_to_live"), k().F(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), 0L, true, false, db.a() && m().t(s.L0))));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(Bundle bundle) {
        c();
        w();
        b2.p.k(bundle);
        b2.p.g(bundle.getString("name"));
        if (!this.f6381a.p()) {
            h().N().a("Conditional property not cleared since app measurement is disabled");
        } else {
            try {
                r().N(new ha(bundle.getString("app_id"), bundle.getString("origin"), new n9(bundle.getString("name"), 0L, null, null), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), k().F(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), bundle.getLong("creation_timestamp"), true, false, db.a() && m().t(s.L0))));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public final ArrayList<Bundle> B(String str, String str2) {
        if (e().I()) {
            h().F().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (ea.a()) {
            h().F().a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f6381a.e().v(atomicReference, 5000L, "get conditional user properties", new i6(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return o9.t0(list);
        }
        h().F().b("Timed out waiting for get conditional user properties", null);
        return new ArrayList<>();
    }

    public final Map<String, Object> C(String str, String str2, boolean z10) {
        t3 F;
        String str3;
        if (e().I()) {
            F = h().F();
            str3 = "Cannot get user properties from analytics worker thread";
        } else {
            if (!ea.a()) {
                AtomicReference atomicReference = new AtomicReference();
                this.f6381a.e().v(atomicReference, 5000L, "get user properties", new l6(this, atomicReference, null, str, str2, z10));
                List<n9> list = (List) atomicReference.get();
                if (list == null) {
                    h().F().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z10));
                    return Collections.emptyMap();
                }
                l.a aVar = new l.a(list.size());
                for (n9 n9Var : list) {
                    aVar.put(n9Var.f6259g, n9Var.g());
                }
                return aVar;
            }
            F = h().F();
            str3 = "Cannot get user properties from main thread";
        }
        F.a(str3);
        return Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void D(long j10, boolean z10) {
        c();
        w();
        h().M().a("Resetting analytics data (FE)");
        p8 u10 = u();
        u10.c();
        u10.f6326e.a();
        boolean p10 = this.f6381a.p();
        e4 l10 = l();
        l10.f5963j.b(j10);
        if (!TextUtils.isEmpty(l10.l().f5979z.a())) {
            l10.f5979z.b(null);
        }
        if (ad.a() && l10.m().t(s.f6425q0)) {
            l10.f5974u.b(0L);
        }
        if (!l10.m().F()) {
            l10.C(!p10);
        }
        l10.A.b(null);
        l10.B.b(0L);
        l10.C.b(null);
        if (z10) {
            r().X();
        }
        if (ad.a() && m().t(s.f6425q0)) {
            u().f6325d.a();
        }
        this.f6599o = !p10;
    }

    public final void E(Bundle bundle) {
        G(bundle, f().a());
    }

    public final void F(Bundle bundle, int i10, long j10) {
        if (bc.a() && m().t(s.H0)) {
            w();
            String e10 = v2.a.e(bundle);
            if (e10 != null) {
                h().K().b("Ignoring invalid consent setting", e10);
                h().K().a("Valid consent values are 'granted', 'denied'");
            }
            Y(v2.a.l(bundle), i10, j10);
        }
    }

    public final void G(Bundle bundle, long j10) {
        b2.p.k(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            h().I().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        b2.p.k(bundle2);
        v2.g.a(bundle2, "app_id", String.class, null);
        v2.g.a(bundle2, "origin", String.class, null);
        v2.g.a(bundle2, "name", String.class, null);
        v2.g.a(bundle2, "value", Object.class, null);
        v2.g.a(bundle2, "trigger_event_name", String.class, null);
        v2.g.a(bundle2, "trigger_timeout", Long.class, 0L);
        v2.g.a(bundle2, "timed_out_event_name", String.class, null);
        v2.g.a(bundle2, "timed_out_event_params", Bundle.class, null);
        v2.g.a(bundle2, "triggered_event_name", String.class, null);
        v2.g.a(bundle2, "triggered_event_params", Bundle.class, null);
        v2.g.a(bundle2, "time_to_live", Long.class, 0L);
        v2.g.a(bundle2, "expired_event_name", String.class, null);
        v2.g.a(bundle2, "expired_event_params", Bundle.class, null);
        b2.p.g(bundle2.getString("name"));
        b2.p.g(bundle2.getString("origin"));
        b2.p.k(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j10);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (k().q0(string) != 0) {
            h().F().b("Invalid conditional user property name", j().A(string));
            return;
        }
        if (k().r0(string, obj) != 0) {
            h().F().c("Invalid conditional user property value", j().A(string), obj);
            return;
        }
        Object y02 = k().y0(string, obj);
        if (y02 == null) {
            h().F().c("Unable to normalize conditional user property value", j().A(string), obj);
            return;
        }
        v2.g.b(bundle2, y02);
        long j11 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j11 > 15552000000L || j11 < 1)) {
            h().F().c("Invalid conditional user property timeout", j().A(string), Long.valueOf(j11));
            return;
        }
        long j12 = bundle2.getLong("time_to_live");
        if (j12 > 15552000000L || j12 < 1) {
            h().F().c("Invalid conditional user property time to live", j().A(string), Long.valueOf(j12));
        } else {
            e().z(new h6(this, bundle2));
        }
    }

    public final void L(Boolean bool) {
        w();
        e().z(new o6(this, bool));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(String str) {
        this.f6591g.set(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(String str, String str2, long j10, Bundle bundle) {
        c();
        P(str, str2, j10, bundle, true, this.f6588d == null || o9.C0(str2), false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0146, code lost:
    
        r6 = 13;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P(java.lang.String r20, java.lang.String r21, long r22, android.os.Bundle r24, boolean r25, boolean r26, boolean r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 1210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.w5.P(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void R(String str, String str2, Bundle bundle) {
        T(str, str2, bundle, true, true, f().a());
    }

    public final void S(String str, String str2, Bundle bundle, String str3) {
        a();
        q0(str, str2, f().a(), bundle, false, true, false, str3);
    }

    public final void T(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (m().t(s.f6435v0) && o9.B0(str2, "screen_view")) {
            s().J(bundle2, j10);
            return;
        }
        q0(str3, str2, j10, bundle2, z11, !z11 || this.f6588d == null || o9.C0(str2), !z10, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            b2.p.g(r9)
            b2.p.g(r10)
            r8.c()
            r8.w()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L60
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L50
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L50
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L35
            r4 = r2
            goto L37
        L35:
            r4 = 0
        L37:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.e4 r0 = r8.l()
            com.google.android.gms.measurement.internal.k4 r0 = r0.f5972s
            long r4 = r10.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L4b
            java.lang.String r11 = "true"
        L4b:
            r0.b(r11)
            r6 = r10
            goto L5e
        L50:
            if (r11 != 0) goto L60
            com.google.android.gms.measurement.internal.e4 r10 = r8.l()
            com.google.android.gms.measurement.internal.k4 r10 = r10.f5972s
            java.lang.String r0 = "unset"
            r10.b(r0)
            r6 = r11
        L5e:
            r3 = r1
            goto L62
        L60:
            r3 = r10
            r6 = r11
        L62:
            com.google.android.gms.measurement.internal.t4 r10 = r8.f6381a
            boolean r10 = r10.p()
            if (r10 != 0) goto L78
            com.google.android.gms.measurement.internal.r3 r9 = r8.h()
            com.google.android.gms.measurement.internal.t3 r9 = r9.N()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L78:
            com.google.android.gms.measurement.internal.t4 r10 = r8.f6381a
            boolean r10 = r10.u()
            if (r10 != 0) goto L81
            return
        L81:
            com.google.android.gms.measurement.internal.n9 r10 = new com.google.android.gms.measurement.internal.n9
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.k7 r9 = r8.r()
            r9.M(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.w5.U(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void V(String str, String str2, Object obj, boolean z10) {
        W(str, str2, obj, true, f().a());
    }

    public final void W(String str, String str2, Object obj, boolean z10, long j10) {
        int i10;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z10) {
            i10 = k().q0(str2);
        } else {
            o9 k10 = k();
            if (k10.h0("user property", str2)) {
                if (!k10.m0("user property", v2.k.f14631a, str2)) {
                    i10 = 15;
                } else if (k10.g0("user property", 24, str2)) {
                    i10 = 0;
                }
            }
            i10 = 6;
        }
        if (i10 != 0) {
            k();
            this.f6381a.G().W(this.f6600p, i10, "_ev", o9.I(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj == null) {
            Q(str3, str2, j10, null);
            return;
        }
        int r02 = k().r0(str2, obj);
        if (r02 != 0) {
            k();
            this.f6381a.G().W(this.f6600p, r02, "_ev", o9.I(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
        } else {
            Object y02 = k().y0(str2, obj);
            if (y02 != null) {
                Q(str3, str2, j10, y02);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void X(v2.a aVar) {
        c();
        boolean z10 = (aVar.q() && aVar.o()) || r().d0();
        if (z10 != this.f6381a.r()) {
            this.f6381a.A(z10);
            Boolean K = l().K();
            if (!z10 || K == null || K.booleanValue()) {
                M(Boolean.valueOf(z10), false);
            }
        }
    }

    public final void Y(v2.a aVar, int i10, long j10) {
        boolean z10;
        v2.a aVar2;
        boolean z11;
        boolean z12;
        if (bc.a() && m().t(s.H0)) {
            w();
            if (!(m().t(s.I0) && i10 == 20) && aVar.j() == null && aVar.p() == null) {
                h().K().a("Discarding empty consent settings");
                return;
            }
            synchronized (this.f6592h) {
                z10 = false;
                if (v2.a.g(i10, this.f6594j)) {
                    z12 = aVar.h(this.f6593i);
                    if (aVar.q() && !this.f6593i.q()) {
                        z10 = true;
                    }
                    v2.a n10 = aVar.n(this.f6593i);
                    this.f6593i = n10;
                    this.f6594j = i10;
                    aVar2 = n10;
                    z11 = z10;
                    z10 = true;
                } else {
                    aVar2 = aVar;
                    z11 = false;
                    z12 = false;
                }
            }
            if (!z10) {
                h().L().b("Ignoring lower-priority consent settings, proposed settings", aVar2);
                return;
            }
            long andIncrement = this.f6595k.getAndIncrement();
            if (z12) {
                N(null);
                e().C(new r6(this, aVar2, j10, i10, andIncrement, z11));
            } else if (m().t(s.I0) && (i10 == 40 || i10 == 20)) {
                e().C(new q6(this, aVar2, i10, andIncrement, z11));
            } else {
                e().z(new t6(this, aVar2, i10, andIncrement, z11));
            }
        }
    }

    public final void a0(v2.j jVar) {
        v2.j jVar2;
        c();
        w();
        if (jVar != null && jVar != (jVar2 = this.f6588d)) {
            b2.p.o(jVar2 == null, "EventInterceptor already set.");
        }
        this.f6588d = jVar;
    }

    public final void b0(v2.l lVar) {
        w();
        b2.p.k(lVar);
        if (this.f6589e.add(lVar)) {
            return;
        }
        h().I().a("OnEventListener already registered");
    }

    public final void c0() {
        if (i().getApplicationContext() instanceof Application) {
            ((Application) i().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f6587c);
        }
    }

    public final Boolean d0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) e().v(atomicReference, 15000L, "boolean test flag value", new x5(this, atomicReference));
    }

    public final String e0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) e().v(atomicReference, 15000L, "String test flag value", new g6(this, atomicReference));
    }

    public final Long f0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) e().v(atomicReference, 15000L, "long test flag value", new n6(this, atomicReference));
    }

    public final Integer g0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) e().v(atomicReference, 15000L, "int test flag value", new m6(this, atomicReference));
    }

    public final Double h0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) e().v(atomicReference, 15000L, "double test flag value", new p6(this, atomicReference));
    }

    public final String i0() {
        return this.f6591g.get();
    }

    public final void j0() {
        c();
        w();
        if (this.f6381a.u()) {
            if (m().t(s.f6399d0)) {
                Boolean E = m().E("google_analytics_deferred_deep_link_enabled");
                if (E != null && E.booleanValue()) {
                    h().M().a("Deferred Deep Link feature enabled.");
                    e().z(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.y5

                        /* renamed from: f, reason: collision with root package name */
                        private final w5 f6636f;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f6636f = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            w5 w5Var = this.f6636f;
                            w5Var.c();
                            if (w5Var.l().f5977x.b()) {
                                w5Var.h().M().a("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long a10 = w5Var.l().f5978y.a();
                            w5Var.l().f5978y.b(1 + a10);
                            if (a10 < 5) {
                                w5Var.f6381a.v();
                            } else {
                                w5Var.h().I().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                w5Var.l().f5977x.a(true);
                            }
                        }
                    });
                }
            }
            r().Y();
            this.f6599o = false;
            String N = l().N();
            if (TextUtils.isEmpty(N)) {
                return;
            }
            d().q();
            if (N.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", N);
            R("auto", "_ou", bundle);
        }
    }

    public final String k0() {
        c7 S = this.f6381a.O().S();
        if (S != null) {
            return S.f5901a;
        }
        return null;
    }

    public final String l0() {
        c7 S = this.f6381a.O().S();
        if (S != null) {
            return S.f5902b;
        }
        return null;
    }

    public final String m0() {
        if (this.f6381a.K() != null) {
            return this.f6381a.K();
        }
        try {
            return v2.n.a(i(), "google_app_id");
        } catch (IllegalStateException e10) {
            this.f6381a.h().F().b("getGoogleAppId failed with exception", e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void o0(Bundle bundle) {
        if (nd.a() && m().t(s.f6443z0)) {
            if (bundle == null) {
                l().C.b(new Bundle());
                return;
            }
            Bundle a10 = l().C.a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    k();
                    if (o9.d0(obj)) {
                        k().W(this.f6600p, 27, null, null, 0);
                    }
                    h().K().c("Invalid default event parameter type. Name, value", str, obj);
                } else if (o9.C0(str)) {
                    h().K().b("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    a10.remove(str);
                } else if (k().i0("param", str, 100, obj)) {
                    k().N(a10, str, obj);
                }
            }
            k();
            if (o9.b0(a10, m().y())) {
                k().W(this.f6600p, 26, null, null, 0);
                h().K().a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            l().C.b(a10);
            r().E(a10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r0(String str, String str2, Bundle bundle) {
        c();
        O(str, str2, f().a(), bundle);
    }

    public final void s0(v2.l lVar) {
        w();
        b2.p.k(lVar);
        if (this.f6589e.remove(lVar)) {
            return;
        }
        h().I().a("OnEventListener had not been registered");
    }

    public final void u0(String str, String str2, Bundle bundle) {
        long a10 = f().a();
        b2.p.g(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", a10);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        e().z(new j6(this, bundle2));
    }

    @Override // com.google.android.gms.measurement.internal.z4
    protected final boolean z() {
        return false;
    }
}
