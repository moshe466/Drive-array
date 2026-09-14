package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class p0 extends l7<p0, a> implements a9 {
    private static final p0 zzj;
    private static volatile g9<p0> zzk;
    private int zzc;
    private int zzd;
    private String zze = "";
    private n0 zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    /* loaded from: classes.dex */
    public static final class a extends l7.b<p0, a> implements a9 {
        private a() {
            super(p0.zzj);
        }

        /* synthetic */ a(r0 r0Var) {
            this();
        }

        public final a u(String str) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((p0) this.f5446g).B(str);
            return this;
        }
    }

    static {
        p0 p0Var = new p0();
        zzj = p0Var;
        l7.t(p0.class, p0Var);
    }

    private p0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    public static a L() {
        return zzj.v();
    }

    public final boolean C() {
        return (this.zzc & 1) != 0;
    }

    public final int D() {
        return this.zzd;
    }

    public final String E() {
        return this.zze;
    }

    public final n0 F() {
        n0 n0Var = this.zzf;
        return n0Var == null ? n0.L() : n0Var;
    }

    public final boolean G() {
        return this.zzg;
    }

    public final boolean I() {
        return this.zzh;
    }

    public final boolean J() {
        return (this.zzc & 32) != 0;
    }

    public final boolean K() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        r0 r0Var = null;
        switch (r0.f5564a[i10 - 1]) {
            case 1:
                return new p0();
            case 2:
                return new a(r0Var);
            case 3:
                return l7.r(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                g9<p0> g9Var = zzk;
                if (g9Var == null) {
                    synchronized (p0.class) {
                        g9Var = zzk;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzj);
                            zzk = g9Var;
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
