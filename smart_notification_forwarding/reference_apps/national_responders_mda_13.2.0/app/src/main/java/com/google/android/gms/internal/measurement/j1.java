package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;
import java.util.List;

/* loaded from: classes.dex */
public final class j1 extends l7<j1, a> implements a9 {
    private static final j1 zzg;
    private static volatile g9<j1> zzh;
    private v7 zzc = l7.y();
    private v7 zzd = l7.y();
    private u7<c1> zze = l7.z();
    private u7<k1> zzf = l7.z();

    /* loaded from: classes.dex */
    public static final class a extends l7.b<j1, a> implements a9 {
        private a() {
            super(j1.zzg);
        }

        /* synthetic */ a(n1 n1Var) {
            this();
        }

        public final a A(Iterable<? extends Long> iterable) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((j1) this.f5446g).O(iterable);
            return this;
        }

        public final a B(Iterable<? extends c1> iterable) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((j1) this.f5446g).R(iterable);
            return this;
        }

        public final a C(Iterable<? extends k1> iterable) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((j1) this.f5446g).V(iterable);
            return this;
        }

        public final a u() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((j1) this.f5446g).e0();
            return this;
        }

        public final a w(int i10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((j1) this.f5446g).T(i10);
            return this;
        }

        public final a x(Iterable<? extends Long> iterable) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((j1) this.f5446g).F(iterable);
            return this;
        }

        public final a y() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((j1) this.f5446g).f0();
            return this;
        }

        public final a z(int i10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((j1) this.f5446g).X(i10);
            return this;
        }
    }

    static {
        j1 j1Var = new j1();
        zzg = j1Var;
        l7.t(j1.class, j1Var);
    }

    private j1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(Iterable<? extends Long> iterable) {
        v7 v7Var = this.zzc;
        if (!v7Var.zza()) {
            this.zzc = l7.p(v7Var);
        }
        u5.c(iterable, this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(Iterable<? extends Long> iterable) {
        v7 v7Var = this.zzd;
        if (!v7Var.zza()) {
            this.zzd = l7.p(v7Var);
        }
        u5.c(iterable, this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(Iterable<? extends c1> iterable) {
        g0();
        u5.c(iterable, this.zze);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(int i10) {
        g0();
        this.zze.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(Iterable<? extends k1> iterable) {
        h0();
        u5.c(iterable, this.zzf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(int i10) {
        h0();
        this.zzf.remove(i10);
    }

    public static a b0() {
        return zzg.v();
    }

    public static j1 c0() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        this.zzc = l7.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        this.zzd = l7.y();
    }

    private final void g0() {
        u7<c1> u7Var = this.zze;
        if (u7Var.zza()) {
            return;
        }
        this.zze = l7.o(u7Var);
    }

    private final void h0() {
        u7<k1> u7Var = this.zzf;
        if (u7Var.zza()) {
            return;
        }
        this.zzf = l7.o(u7Var);
    }

    public final c1 A(int i10) {
        return this.zze.get(i10);
    }

    public final List<Long> B() {
        return this.zzc;
    }

    public final int G() {
        return this.zzc.size();
    }

    public final k1 I(int i10) {
        return this.zzf.get(i10);
    }

    public final List<Long> P() {
        return this.zzd;
    }

    public final int S() {
        return this.zzd.size();
    }

    public final List<c1> W() {
        return this.zze;
    }

    public final int Y() {
        return this.zze.size();
    }

    public final List<k1> Z() {
        return this.zzf;
    }

    public final int a0() {
        return this.zzf.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        n1 n1Var = null;
        switch (n1.f5488a[i10 - 1]) {
            case 1:
                return new j1();
            case 2:
                return new a(n1Var);
            case 3:
                return l7.r(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", c1.class, "zzf", k1.class});
            case 4:
                return zzg;
            case 5:
                g9<j1> g9Var = zzh;
                if (g9Var == null) {
                    synchronized (j1.class) {
                        g9Var = zzh;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzg);
                            zzh = g9Var;
                        }
                    }
                }
                return g9Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
