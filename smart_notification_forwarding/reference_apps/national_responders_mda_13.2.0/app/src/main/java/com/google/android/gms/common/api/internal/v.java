package com.google.android.gms.common.api.internal;

import a2.a;
import a2.a.b;
import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public abstract class v<A extends a.b, ResultT> {

    /* renamed from: a, reason: collision with root package name */
    private final z1.c[] f5020a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5021b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5022c;

    /* loaded from: classes.dex */
    public static class a<A extends a.b, ResultT> {

        /* renamed from: a, reason: collision with root package name */
        private r f5023a;

        /* renamed from: c, reason: collision with root package name */
        private z1.c[] f5025c;

        /* renamed from: b, reason: collision with root package name */
        private boolean f5024b = true;

        /* renamed from: d, reason: collision with root package name */
        private int f5026d = 0;

        /* synthetic */ a(o2 o2Var) {
        }

        public v<A, ResultT> a() {
            b2.p.b(this.f5023a != null, "execute parameter required");
            return new n2(this, this.f5025c, this.f5024b, this.f5026d);
        }

        public a<A, ResultT> b(r<A, z2.m<ResultT>> rVar) {
            this.f5023a = rVar;
            return this;
        }

        public a<A, ResultT> c(boolean z10) {
            this.f5024b = z10;
            return this;
        }

        public a<A, ResultT> d(Feature... featureArr) {
            this.f5025c = featureArr;
            return this;
        }

        public a<A, ResultT> e(int i10) {
            this.f5026d = i10;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(z1.c[] cVarArr, boolean z10, int i10) {
        this.f5020a = cVarArr;
        boolean z11 = false;
        if (cVarArr != null && z10) {
            z11 = true;
        }
        this.f5021b = z11;
        this.f5022c = i10;
    }

    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(A a10, z2.m<ResultT> mVar);

    public boolean c() {
        return this.f5021b;
    }

    public final int d() {
        return this.f5022c;
    }

    public final z1.c[] e() {
        return this.f5020a;
    }
}
