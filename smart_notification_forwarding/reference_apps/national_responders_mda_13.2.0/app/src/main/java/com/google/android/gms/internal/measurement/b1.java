package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.j1;
import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class b1 extends l7<b1, a> implements a9 {
    private static final b1 zzh;
    private static volatile g9<b1> zzi;
    private int zzc;
    private int zzd;
    private j1 zze;
    private j1 zzf;
    private boolean zzg;

    /* loaded from: classes.dex */
    public static final class a extends l7.b<b1, a> implements a9 {
        private a() {
            super(b1.zzh);
        }

        /* synthetic */ a(n1 n1Var) {
            this();
        }

        public final a u(int i10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((b1) this.f5446g).A(i10);
            return this;
        }

        public final a w(j1.a aVar) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((b1) this.f5446g).E((j1) ((l7) aVar.g()));
            return this;
        }

        public final a x(j1 j1Var) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((b1) this.f5446g).K(j1Var);
            return this;
        }

        public final a y(boolean z10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((b1) this.f5446g).F(z10);
            return this;
        }
    }

    static {
        b1 b1Var = new b1();
        zzh = b1Var;
        l7.t(b1.class, b1Var);
    }

    private b1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(int i10) {
        this.zzc |= 1;
        this.zzd = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(j1 j1Var) {
        j1Var.getClass();
        this.zze = j1Var;
        this.zzc |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(boolean z10) {
        this.zzc |= 8;
        this.zzg = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(j1 j1Var) {
        j1Var.getClass();
        this.zzf = j1Var;
        this.zzc |= 4;
    }

    public static a S() {
        return zzh.v();
    }

    public final boolean G() {
        return (this.zzc & 1) != 0;
    }

    public final int I() {
        return this.zzd;
    }

    public final j1 L() {
        j1 j1Var = this.zze;
        return j1Var == null ? j1.c0() : j1Var;
    }

    public final boolean O() {
        return (this.zzc & 4) != 0;
    }

    public final j1 P() {
        j1 j1Var = this.zzf;
        return j1Var == null ? j1.c0() : j1Var;
    }

    public final boolean Q() {
        return (this.zzc & 8) != 0;
    }

    public final boolean R() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        n1 n1Var = null;
        switch (n1.f5488a[i10 - 1]) {
            case 1:
                return new b1();
            case 2:
                return new a(n1Var);
            case 3:
                return l7.r(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                g9<b1> g9Var = zzi;
                if (g9Var == null) {
                    synchronized (b1.class) {
                        g9Var = zzi;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzh);
                            zzi = g9Var;
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
