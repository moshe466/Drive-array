package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class v1 extends l7<v1, b> implements a9 {
    private static final v1 zzk;
    private static volatile g9<v1> zzl;
    private int zzc;
    private int zzd;
    private boolean zzf;
    private long zzg;
    private double zzh;
    private String zze = "";
    private u7<v1> zzi = l7.z();
    private String zzj = "";

    /* loaded from: classes.dex */
    public enum a implements r7 {
        UNKNOWN(0),
        STRING(1),
        NUMBER(2),
        BOOLEAN(3),
        STATEMENT(4);

        private static final q7<a> zzf = new y1();
        private final int zzg;

        a(int i10) {
            this.zzg = i10;
        }

        public static a zza(int i10) {
            if (i10 == 0) {
                return UNKNOWN;
            }
            if (i10 == 1) {
                return STRING;
            }
            if (i10 == 2) {
                return NUMBER;
            }
            if (i10 == 3) {
                return BOOLEAN;
            }
            if (i10 != 4) {
                return null;
            }
            return STATEMENT;
        }

        public static t7 zzb() {
            return x1.f5667a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.r7
        public final int zza() {
            return this.zzg;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends l7.b<v1, b> implements a9 {
        private b() {
            super(v1.zzk);
        }

        /* synthetic */ b(w1 w1Var) {
            this();
        }
    }

    static {
        v1 v1Var = new v1();
        zzk = v1Var;
        l7.t(v1.class, v1Var);
    }

    private v1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        w1 w1Var = null;
        switch (w1.f5657a[i10 - 1]) {
            case 1:
                return new v1();
            case 2:
                return new b(w1Var);
            case 3:
                return l7.r(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005က\u0004\u0006\u001b\u0007ဈ\u0005", new Object[]{"zzc", "zzd", a.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", v1.class, "zzj"});
            case 4:
                return zzk;
            case 5:
                g9<v1> g9Var = zzl;
                if (g9Var == null) {
                    synchronized (v1.class) {
                        g9Var = zzl;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzk);
                            zzl = g9Var;
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
