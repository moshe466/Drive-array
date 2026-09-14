package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class o0 extends l7<o0, b> implements a9 {
    private static final o0 zzi;
    private static volatile g9<o0> zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    /* loaded from: classes.dex */
    public enum a implements r7 {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);

        private static final q7<a> zzf = new t0();
        private final int zzg;

        a(int i10) {
            this.zzg = i10;
        }

        public static a zza(int i10) {
            if (i10 == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i10 == 1) {
                return LESS_THAN;
            }
            if (i10 == 2) {
                return GREATER_THAN;
            }
            if (i10 == 3) {
                return EQUAL;
            }
            if (i10 != 4) {
                return null;
            }
            return BETWEEN;
        }

        public static t7 zzb() {
            return s0.f5581a;
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
    public static final class b extends l7.b<o0, b> implements a9 {
        private b() {
            super(o0.zzi);
        }

        /* synthetic */ b(r0 r0Var) {
            this();
        }
    }

    static {
        o0 o0Var = new o0();
        zzi = o0Var;
        l7.t(o0.class, o0Var);
    }

    private o0() {
    }

    public static o0 L() {
        return zzi;
    }

    public final boolean A() {
        return (this.zzc & 1) != 0;
    }

    public final a B() {
        a zza = a.zza(this.zzd);
        return zza == null ? a.UNKNOWN_COMPARISON_TYPE : zza;
    }

    public final boolean C() {
        return (this.zzc & 2) != 0;
    }

    public final boolean D() {
        return this.zze;
    }

    public final boolean E() {
        return (this.zzc & 4) != 0;
    }

    public final String F() {
        return this.zzf;
    }

    public final boolean G() {
        return (this.zzc & 8) != 0;
    }

    public final String I() {
        return this.zzg;
    }

    public final boolean J() {
        return (this.zzc & 16) != 0;
    }

    public final String K() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        r0 r0Var = null;
        switch (r0.f5564a[i10 - 1]) {
            case 1:
                return new o0();
            case 2:
                return new b(r0Var);
            case 3:
                return l7.r(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", a.zzb(), "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                g9<o0> g9Var = zzj;
                if (g9Var == null) {
                    synchronized (o0.class) {
                        g9Var = zzj;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzi);
                            zzj = g9Var;
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
