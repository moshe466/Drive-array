package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class s1 extends l7<s1, a> implements a9 {
    private static final s1 zzd;
    private static volatile g9<s1> zze;
    private u7<t1> zzc = l7.z();

    /* loaded from: classes.dex */
    public static final class a extends l7.b<s1, a> implements a9 {
        private a() {
            super(s1.zzd);
        }

        /* synthetic */ a(w1 w1Var) {
            this();
        }
    }

    static {
        s1 s1Var = new s1();
        zzd = s1Var;
        l7.t(s1.class, s1Var);
    }

    private s1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        w1 w1Var = null;
        switch (w1.f5657a[i10 - 1]) {
            case 1:
                return new s1();
            case 2:
                return new a(w1Var);
            case 3:
                return l7.r(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", t1.class});
            case 4:
                return zzd;
            case 5:
                g9<s1> g9Var = zze;
                if (g9Var == null) {
                    synchronized (s1.class) {
                        g9Var = zze;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzd);
                            zze = g9Var;
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
