package k1;

import android.content.Context;
import java.util.concurrent.Executor;
import k1.s;
import r1.b0;
import r1.c0;
import r1.i0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends s {

    /* renamed from: f, reason: collision with root package name */
    private k8.a<Executor> f11156f;

    /* renamed from: g, reason: collision with root package name */
    private k8.a<Context> f11157g;

    /* renamed from: h, reason: collision with root package name */
    private k8.a f11158h;

    /* renamed from: i, reason: collision with root package name */
    private k8.a f11159i;

    /* renamed from: j, reason: collision with root package name */
    private k8.a f11160j;

    /* renamed from: k, reason: collision with root package name */
    private k8.a<b0> f11161k;

    /* renamed from: l, reason: collision with root package name */
    private k8.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.e> f11162l;

    /* renamed from: m, reason: collision with root package name */
    private k8.a<q1.n> f11163m;

    /* renamed from: n, reason: collision with root package name */
    private k8.a<p1.c> f11164n;

    /* renamed from: o, reason: collision with root package name */
    private k8.a<q1.h> f11165o;

    /* renamed from: p, reason: collision with root package name */
    private k8.a<q1.l> f11166p;

    /* renamed from: q, reason: collision with root package name */
    private k8.a<r> f11167q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements s.a {

        /* renamed from: a, reason: collision with root package name */
        private Context f11168a;

        private b() {
        }

        @Override // k1.s.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f11168a = (Context) m1.d.b(context);
            return this;
        }

        @Override // k1.s.a
        public s c() {
            m1.d.a(this.f11168a, Context.class);
            return new d(this.f11168a);
        }
    }

    private d(Context context) {
        g(context);
    }

    public static s.a f() {
        return new b();
    }

    private void g(Context context) {
        this.f11156f = m1.a.a(j.a());
        m1.b a10 = m1.c.a(context);
        this.f11157g = a10;
        l1.d a11 = l1.d.a(a10, t1.c.a(), t1.d.a());
        this.f11158h = a11;
        this.f11159i = m1.a.a(l1.f.a(this.f11157g, a11));
        this.f11160j = i0.a(this.f11157g, r1.f.a(), r1.g.a());
        this.f11161k = m1.a.a(c0.a(t1.c.a(), t1.d.a(), r1.h.a(), this.f11160j));
        p1.g b10 = p1.g.b(t1.c.a());
        this.f11162l = b10;
        p1.i a12 = p1.i.a(this.f11157g, this.f11161k, b10, t1.d.a());
        this.f11163m = a12;
        k8.a<Executor> aVar = this.f11156f;
        k8.a aVar2 = this.f11159i;
        k8.a<b0> aVar3 = this.f11161k;
        this.f11164n = p1.d.a(aVar, aVar2, a12, aVar3, aVar3);
        k8.a<Context> aVar4 = this.f11157g;
        k8.a aVar5 = this.f11159i;
        k8.a<b0> aVar6 = this.f11161k;
        this.f11165o = q1.i.a(aVar4, aVar5, aVar6, this.f11163m, this.f11156f, aVar6, t1.c.a());
        k8.a<Executor> aVar7 = this.f11156f;
        k8.a<b0> aVar8 = this.f11161k;
        this.f11166p = q1.m.a(aVar7, aVar8, this.f11163m, aVar8);
        this.f11167q = m1.a.a(t.a(t1.c.a(), t1.d.a(), this.f11164n, this.f11165o, this.f11166p));
    }

    @Override // k1.s
    r1.c c() {
        return this.f11161k.get();
    }

    @Override // k1.s
    r d() {
        return this.f11167q.get();
    }
}
