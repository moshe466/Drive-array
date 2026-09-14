package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class y0 extends l7<y0, a> implements a9 {
    private static final y0 zzf;
    private static volatile g9<y0> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    /* loaded from: classes.dex */
    public static final class a extends l7.b<y0, a> implements a9 {
        private a() {
            super(y0.zzf);
        }

        /* synthetic */ a(a1 a1Var) {
            this();
        }
    }

    static {
        y0 y0Var = new y0();
        zzf = y0Var;
        l7.t(y0.class, y0Var);
    }

    private y0() {
    }

    public final String A() {
        return this.zzd;
    }

    public final String B() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        a1 a1Var = null;
        switch (a1.f5155a[i10 - 1]) {
            case 1:
                return new y0();
            case 2:
                return new a(a1Var);
            case 3:
                return l7.r(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                g9<y0> g9Var = zzg;
                if (g9Var == null) {
                    synchronized (y0.class) {
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
