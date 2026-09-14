package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class n0 extends l7<n0, a> implements a9 {
    private static final n0 zzh;
    private static volatile g9<n0> zzi;
    private int zzc;
    private q0 zzd;
    private o0 zze;
    private boolean zzf;
    private String zzg = "";

    /* loaded from: classes.dex */
    public static final class a extends l7.b<n0, a> implements a9 {
        private a() {
            super(n0.zzh);
        }

        /* synthetic */ a(r0 r0Var) {
            this();
        }

        public final a u(String str) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((n0) this.f5446g).B(str);
            return this;
        }
    }

    static {
        n0 n0Var = new n0();
        zzh = n0Var;
        l7.t(n0.class, n0Var);
    }

    private n0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(String str) {
        str.getClass();
        this.zzc |= 8;
        this.zzg = str;
    }

    public static n0 L() {
        return zzh;
    }

    public final boolean C() {
        return (this.zzc & 1) != 0;
    }

    public final q0 D() {
        q0 q0Var = this.zzd;
        return q0Var == null ? q0.J() : q0Var;
    }

    public final boolean E() {
        return (this.zzc & 2) != 0;
    }

    public final o0 F() {
        o0 o0Var = this.zze;
        return o0Var == null ? o0.L() : o0Var;
    }

    public final boolean G() {
        return (this.zzc & 4) != 0;
    }

    public final boolean I() {
        return this.zzf;
    }

    public final boolean J() {
        return (this.zzc & 8) != 0;
    }

    public final String K() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        r0 r0Var = null;
        switch (r0.f5564a[i10 - 1]) {
            case 1:
                return new n0();
            case 2:
                return new a(r0Var);
            case 3:
                return l7.r(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                g9<n0> g9Var = zzi;
                if (g9Var == null) {
                    synchronized (n0.class) {
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
