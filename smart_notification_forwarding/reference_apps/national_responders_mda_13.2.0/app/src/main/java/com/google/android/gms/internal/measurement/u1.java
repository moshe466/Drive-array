package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class u1 extends l7<u1, a> implements a9 {
    private static final u1 zzf;
    private static volatile g9<u1> zzg;
    private int zzc;
    private u7<v1> zzd = l7.z();
    private s1 zze;

    /* loaded from: classes.dex */
    public static final class a extends l7.b<u1, a> implements a9 {
        private a() {
            super(u1.zzf);
        }

        /* synthetic */ a(w1 w1Var) {
            this();
        }
    }

    static {
        u1 u1Var = new u1();
        zzf = u1Var;
        l7.t(u1.class, u1Var);
    }

    private u1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        w1 w1Var = null;
        switch (w1.f5657a[i10 - 1]) {
            case 1:
                return new u1();
            case 2:
                return new a(w1Var);
            case 3:
                return l7.r(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", v1.class, "zze"});
            case 4:
                return zzf;
            case 5:
                g9<u1> g9Var = zzg;
                if (g9Var == null) {
                    synchronized (u1.class) {
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
