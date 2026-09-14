package com.google.android.gms.common.api.internal;

import a2.a;
import a2.a.b;
import com.google.android.gms.common.api.internal.l;

/* loaded from: classes.dex */
public class q<A extends a.b, L> {

    /* renamed from: a, reason: collision with root package name */
    public final p<A, L> f4957a;

    /* renamed from: b, reason: collision with root package name */
    public final x f4958b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f4959c;

    /* loaded from: classes.dex */
    public static class a<A extends a.b, L> {

        /* renamed from: a, reason: collision with root package name */
        private r f4960a;

        /* renamed from: b, reason: collision with root package name */
        private r f4961b;

        /* renamed from: d, reason: collision with root package name */
        private l f4963d;

        /* renamed from: e, reason: collision with root package name */
        private z1.c[] f4964e;

        /* renamed from: g, reason: collision with root package name */
        private int f4966g;

        /* renamed from: c, reason: collision with root package name */
        private Runnable f4962c = new Runnable() { // from class: com.google.android.gms.common.api.internal.d2
            @Override // java.lang.Runnable
            public final void run() {
            }
        };

        /* renamed from: f, reason: collision with root package name */
        private boolean f4965f = true;

        /* synthetic */ a(g2 g2Var) {
        }

        public q<A, L> a() {
            b2.p.b(this.f4960a != null, "Must set register function");
            b2.p.b(this.f4961b != null, "Must set unregister function");
            b2.p.b(this.f4963d != null, "Must set holder");
            return new q<>(new e2(this, this.f4963d, this.f4964e, this.f4965f, this.f4966g), new f2(this, (l.a) b2.p.l(this.f4963d.b(), "Key must not be null")), this.f4962c, null);
        }

        public a<A, L> b(r<A, z2.m<Void>> rVar) {
            this.f4960a = rVar;
            return this;
        }

        public a<A, L> c(int i10) {
            this.f4966g = i10;
            return this;
        }

        public a<A, L> d(r<A, z2.m<Boolean>> rVar) {
            this.f4961b = rVar;
            return this;
        }

        public a<A, L> e(l<L> lVar) {
            this.f4963d = lVar;
            return this;
        }
    }

    /* synthetic */ q(p pVar, x xVar, Runnable runnable, h2 h2Var) {
        this.f4957a = pVar;
        this.f4958b = xVar;
        this.f4959c = runnable;
    }

    public static <A extends a.b, L> a<A, L> a() {
        return new a<>(null);
    }
}
