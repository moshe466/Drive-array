package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class c1 extends l7<c1, a> implements a9 {
    private static final c1 zzf;
    private static volatile g9<c1> zzg;
    private int zzc;
    private int zzd;
    private long zze;

    /* loaded from: classes.dex */
    public static final class a extends l7.b<c1, a> implements a9 {
        private a() {
            super(c1.zzf);
        }

        /* synthetic */ a(n1 n1Var) {
            this();
        }

        public final a u(int i10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((c1) this.f5446g).A(i10);
            return this;
        }

        public final a w(long j10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((c1) this.f5446g).B(j10);
            return this;
        }
    }

    static {
        c1 c1Var = new c1();
        zzf = c1Var;
        l7.t(c1.class, c1Var);
    }

    private c1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(int i10) {
        this.zzc |= 1;
        this.zzd = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j10) {
        this.zzc |= 2;
        this.zze = j10;
    }

    public static a J() {
        return zzf.v();
    }

    public final boolean E() {
        return (this.zzc & 1) != 0;
    }

    public final int F() {
        return this.zzd;
    }

    public final boolean G() {
        return (this.zzc & 2) != 0;
    }

    public final long I() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        n1 n1Var = null;
        switch (n1.f5488a[i10 - 1]) {
            case 1:
                return new c1();
            case 2:
                return new a(n1Var);
            case 3:
                return l7.r(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                g9<c1> g9Var = zzg;
                if (g9Var == null) {
                    synchronized (c1.class) {
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
