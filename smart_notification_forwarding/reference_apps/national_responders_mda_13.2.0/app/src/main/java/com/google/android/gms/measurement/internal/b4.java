package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b4 {
    private long A;
    private long B;
    private long C;
    private String D;
    private boolean E;
    private long F;
    private long G;

    /* renamed from: a, reason: collision with root package name */
    private final t4 f5827a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5828b;

    /* renamed from: c, reason: collision with root package name */
    private String f5829c;

    /* renamed from: d, reason: collision with root package name */
    private String f5830d;

    /* renamed from: e, reason: collision with root package name */
    private String f5831e;

    /* renamed from: f, reason: collision with root package name */
    private String f5832f;

    /* renamed from: g, reason: collision with root package name */
    private long f5833g;

    /* renamed from: h, reason: collision with root package name */
    private long f5834h;

    /* renamed from: i, reason: collision with root package name */
    private long f5835i;

    /* renamed from: j, reason: collision with root package name */
    private String f5836j;

    /* renamed from: k, reason: collision with root package name */
    private long f5837k;

    /* renamed from: l, reason: collision with root package name */
    private String f5838l;

    /* renamed from: m, reason: collision with root package name */
    private long f5839m;

    /* renamed from: n, reason: collision with root package name */
    private long f5840n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5841o;

    /* renamed from: p, reason: collision with root package name */
    private long f5842p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5843q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5844r;

    /* renamed from: s, reason: collision with root package name */
    private String f5845s;

    /* renamed from: t, reason: collision with root package name */
    private Boolean f5846t;

    /* renamed from: u, reason: collision with root package name */
    private long f5847u;

    /* renamed from: v, reason: collision with root package name */
    private List<String> f5848v;

    /* renamed from: w, reason: collision with root package name */
    private String f5849w;

    /* renamed from: x, reason: collision with root package name */
    private long f5850x;

    /* renamed from: y, reason: collision with root package name */
    private long f5851y;

    /* renamed from: z, reason: collision with root package name */
    private long f5852z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b4(t4 t4Var, String str) {
        b2.p.k(t4Var);
        b2.p.g(str);
        this.f5827a = t4Var;
        this.f5828b = str;
        t4Var.e().c();
    }

    public final String A() {
        this.f5827a.e().c();
        return this.f5830d;
    }

    public final void B(long j10) {
        this.f5827a.e().c();
        this.E |= this.f5840n != j10;
        this.f5840n = j10;
    }

    public final void C(String str) {
        this.f5827a.e().c();
        this.E |= !o9.B0(this.f5831e, str);
        this.f5831e = str;
    }

    public final String D() {
        this.f5827a.e().c();
        return this.f5845s;
    }

    public final void E(long j10) {
        this.f5827a.e().c();
        this.E |= this.f5847u != j10;
        this.f5847u = j10;
    }

    public final void F(String str) {
        this.f5827a.e().c();
        this.E |= !o9.B0(this.f5832f, str);
        this.f5832f = str;
    }

    public final String G() {
        this.f5827a.e().c();
        return this.f5849w;
    }

    public final void H(long j10) {
        b2.p.a(j10 >= 0);
        this.f5827a.e().c();
        this.E = (this.f5833g != j10) | this.E;
        this.f5833g = j10;
    }

    public final void I(String str) {
        this.f5827a.e().c();
        this.E |= !o9.B0(this.f5836j, str);
        this.f5836j = str;
    }

    public final String J() {
        this.f5827a.e().c();
        return this.f5831e;
    }

    public final void K(long j10) {
        this.f5827a.e().c();
        this.E |= this.F != j10;
        this.F = j10;
    }

    public final void L(String str) {
        this.f5827a.e().c();
        this.E |= !o9.B0(this.f5838l, str);
        this.f5838l = str;
    }

    public final String M() {
        this.f5827a.e().c();
        return this.f5832f;
    }

    public final void N(long j10) {
        this.f5827a.e().c();
        this.E |= this.G != j10;
        this.G = j10;
    }

    public final void O(String str) {
        this.f5827a.e().c();
        this.E |= !o9.B0(this.D, str);
        this.D = str;
    }

    public final long P() {
        this.f5827a.e().c();
        return this.f5834h;
    }

    public final void Q(long j10) {
        this.f5827a.e().c();
        this.E |= this.f5850x != j10;
        this.f5850x = j10;
    }

    public final long R() {
        this.f5827a.e().c();
        return this.f5835i;
    }

    public final void S(long j10) {
        this.f5827a.e().c();
        this.E |= this.f5851y != j10;
        this.f5851y = j10;
    }

    public final String T() {
        this.f5827a.e().c();
        return this.f5836j;
    }

    public final void U(long j10) {
        this.f5827a.e().c();
        this.E |= this.f5852z != j10;
        this.f5852z = j10;
    }

    public final long V() {
        this.f5827a.e().c();
        return this.f5837k;
    }

    public final void W(long j10) {
        this.f5827a.e().c();
        this.E |= this.A != j10;
        this.A = j10;
    }

    public final String X() {
        this.f5827a.e().c();
        return this.f5838l;
    }

    public final void Y(long j10) {
        this.f5827a.e().c();
        this.E |= this.C != j10;
        this.C = j10;
    }

    public final long Z() {
        this.f5827a.e().c();
        return this.f5839m;
    }

    public final void a(long j10) {
        this.f5827a.e().c();
        this.E |= this.f5834h != j10;
        this.f5834h = j10;
    }

    public final void a0(long j10) {
        this.f5827a.e().c();
        this.E |= this.B != j10;
        this.B = j10;
    }

    public final void b(Boolean bool) {
        this.f5827a.e().c();
        this.E |= !o9.c0(this.f5846t, bool);
        this.f5846t = bool;
    }

    public final long b0() {
        this.f5827a.e().c();
        return this.f5840n;
    }

    public final void c(String str) {
        this.f5827a.e().c();
        this.E |= !o9.B0(this.f5829c, str);
        this.f5829c = str;
    }

    public final void c0(long j10) {
        this.f5827a.e().c();
        this.E |= this.f5842p != j10;
        this.f5842p = j10;
    }

    public final void d(List<String> list) {
        this.f5827a.e().c();
        if (o9.o0(this.f5848v, list)) {
            return;
        }
        this.E = true;
        this.f5848v = list != null ? new ArrayList(list) : null;
    }

    public final long d0() {
        this.f5827a.e().c();
        return this.f5847u;
    }

    public final void e(boolean z10) {
        this.f5827a.e().c();
        this.E |= this.f5841o != z10;
        this.f5841o = z10;
    }

    public final boolean e0() {
        this.f5827a.e().c();
        return this.f5841o;
    }

    public final boolean f() {
        this.f5827a.e().c();
        return this.E;
    }

    public final long f0() {
        this.f5827a.e().c();
        return this.f5833g;
    }

    public final long g() {
        this.f5827a.e().c();
        return this.C;
    }

    public final long g0() {
        this.f5827a.e().c();
        return this.F;
    }

    public final long h() {
        this.f5827a.e().c();
        return this.B;
    }

    public final long h0() {
        this.f5827a.e().c();
        return this.G;
    }

    public final String i() {
        this.f5827a.e().c();
        return this.D;
    }

    public final void i0() {
        this.f5827a.e().c();
        long j10 = this.f5833g + 1;
        if (j10 > 2147483647L) {
            this.f5827a.h().I().b("Bundle index overflow. appId", r3.x(this.f5828b));
            j10 = 0;
        }
        this.E = true;
        this.f5833g = j10;
    }

    public final String j() {
        this.f5827a.e().c();
        String str = this.D;
        O(null);
        return str;
    }

    public final long j0() {
        this.f5827a.e().c();
        return this.f5850x;
    }

    public final long k() {
        this.f5827a.e().c();
        return this.f5842p;
    }

    public final long k0() {
        this.f5827a.e().c();
        return this.f5851y;
    }

    public final boolean l() {
        this.f5827a.e().c();
        return this.f5843q;
    }

    public final long l0() {
        this.f5827a.e().c();
        return this.f5852z;
    }

    public final boolean m() {
        this.f5827a.e().c();
        return this.f5844r;
    }

    public final long m0() {
        this.f5827a.e().c();
        return this.A;
    }

    public final Boolean n() {
        this.f5827a.e().c();
        return this.f5846t;
    }

    public final List<String> o() {
        this.f5827a.e().c();
        return this.f5848v;
    }

    public final void p() {
        this.f5827a.e().c();
        this.E = false;
    }

    public final void q(long j10) {
        this.f5827a.e().c();
        this.E |= this.f5835i != j10;
        this.f5835i = j10;
    }

    public final void r(String str) {
        this.f5827a.e().c();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !o9.B0(this.f5830d, str);
        this.f5830d = str;
    }

    public final void s(boolean z10) {
        this.f5827a.e().c();
        this.E |= this.f5843q != z10;
        this.f5843q = z10;
    }

    public final String t() {
        this.f5827a.e().c();
        return this.f5828b;
    }

    public final void u(long j10) {
        this.f5827a.e().c();
        this.E |= this.f5837k != j10;
        this.f5837k = j10;
    }

    public final void v(String str) {
        this.f5827a.e().c();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !o9.B0(this.f5845s, str);
        this.f5845s = str;
    }

    public final void w(boolean z10) {
        this.f5827a.e().c();
        this.E |= this.f5844r != z10;
        this.f5844r = z10;
    }

    public final String x() {
        this.f5827a.e().c();
        return this.f5829c;
    }

    public final void y(long j10) {
        this.f5827a.e().c();
        this.E |= this.f5839m != j10;
        this.f5839m = j10;
    }

    public final void z(String str) {
        this.f5827a.e().c();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !o9.B0(this.f5849w, str);
        this.f5849w = str;
    }
}
