package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class w0 extends l7<w0, a> implements a9 {
    private static final w0 zzh;
    private static volatile g9<w0> zzi;
    private int zzc;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    /* loaded from: classes.dex */
    public static final class a extends l7.b<w0, a> implements a9 {
        private a() {
            super(w0.zzh);
        }

        /* synthetic */ a(a1 a1Var) {
            this();
        }

        public final int A() {
            return ((w0) this.f5446g).G();
        }

        public final a u(String str) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((w0) this.f5446g).C(str);
            return this;
        }

        public final String w() {
            return ((w0) this.f5446g).A();
        }

        public final boolean x() {
            return ((w0) this.f5446g).D();
        }

        public final boolean y() {
            return ((w0) this.f5446g).E();
        }

        public final boolean z() {
            return ((w0) this.f5446g).F();
        }
    }

    static {
        w0 w0Var = new w0();
        zzh = w0Var;
        l7.t(w0.class, w0Var);
    }

    private w0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    public final String A() {
        return this.zzd;
    }

    public final boolean D() {
        return this.zze;
    }

    public final boolean E() {
        return this.zzf;
    }

    public final boolean F() {
        return (this.zzc & 8) != 0;
    }

    public final int G() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        a1 a1Var = null;
        switch (a1.f5155a[i10 - 1]) {
            case 1:
                return new w0();
            case 2:
                return new a(a1Var);
            case 3:
                return l7.r(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                g9<w0> g9Var = zzi;
                if (g9Var == null) {
                    synchronized (w0.class) {
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
