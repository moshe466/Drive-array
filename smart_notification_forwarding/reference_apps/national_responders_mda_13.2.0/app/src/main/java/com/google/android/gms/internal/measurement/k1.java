package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;
import java.util.List;

/* loaded from: classes.dex */
public final class k1 extends l7<k1, a> implements a9 {
    private static final k1 zzf;
    private static volatile g9<k1> zzg;
    private int zzc;
    private int zzd;
    private v7 zze = l7.y();

    /* loaded from: classes.dex */
    public static final class a extends l7.b<k1, a> implements a9 {
        private a() {
            super(k1.zzf);
        }

        /* synthetic */ a(n1 n1Var) {
            this();
        }

        public final a u(int i10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((k1) this.f5446g).G(i10);
            return this;
        }

        public final a w(Iterable<? extends Long> iterable) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((k1) this.f5446g).D(iterable);
            return this;
        }
    }

    static {
        k1 k1Var = new k1();
        zzf = k1Var;
        l7.t(k1.class, k1Var);
    }

    private k1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Iterable<? extends Long> iterable) {
        v7 v7Var = this.zze;
        if (!v7Var.zza()) {
            this.zze = l7.p(v7Var);
        }
        u5.c(iterable, this.zze);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(int i10) {
        this.zzc |= 1;
        this.zzd = i10;
    }

    public static a K() {
        return zzf.v();
    }

    public final long A(int i10) {
        return this.zze.d(i10);
    }

    public final boolean E() {
        return (this.zzc & 1) != 0;
    }

    public final int F() {
        return this.zzd;
    }

    public final List<Long> I() {
        return this.zze;
    }

    public final int J() {
        return this.zze.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        n1 n1Var = null;
        switch (n1.f5488a[i10 - 1]) {
            case 1:
                return new k1();
            case 2:
                return new a(n1Var);
            case 3:
                return l7.r(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                g9<k1> g9Var = zzg;
                if (g9Var == null) {
                    synchronized (k1.class) {
                        g9Var = zzg;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzf);
                            zzg = g9Var;
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
