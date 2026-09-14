package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class t1 extends l7<t1, a> implements a9 {
    private static final t1 zzf;
    private static volatile g9<t1> zzg;
    private int zzc;
    private String zzd = "";
    private u7<v1> zze = l7.z();

    /* loaded from: classes.dex */
    public static final class a extends l7.b<t1, a> implements a9 {
        private a() {
            super(t1.zzf);
        }

        /* synthetic */ a(w1 w1Var) {
            this();
        }
    }

    static {
        t1 t1Var = new t1();
        zzf = t1Var;
        l7.t(t1.class, t1Var);
    }

    private t1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        w1 w1Var = null;
        switch (w1.f5657a[i10 - 1]) {
            case 1:
                return new t1();
            case 2:
                return new a(w1Var);
            case 3:
                return l7.r(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", "zze", v1.class});
            case 4:
                return zzf;
            case 5:
                g9<t1> g9Var = zzg;
                if (g9Var == null) {
                    synchronized (t1.class) {
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
