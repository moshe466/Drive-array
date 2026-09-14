package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;
import java.util.List;

/* loaded from: classes.dex */
public final class q0 extends l7<q0, a> implements a9 {
    private static final q0 zzh;
    private static volatile g9<q0> zzi;
    private int zzc;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private u7<String> zzg = l7.z();

    /* loaded from: classes.dex */
    public static final class a extends l7.b<q0, a> implements a9 {
        private a() {
            super(q0.zzh);
        }

        /* synthetic */ a(r0 r0Var) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public enum b implements r7 {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);

        private static final q7<b> zzh = new u0();
        private final int zzi;

        b(int i10) {
            this.zzi = i10;
        }

        public static b zza(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }

        public static t7 zzb() {
            return z0.f5733a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.r7
        public final int zza() {
            return this.zzi;
        }
    }

    static {
        q0 q0Var = new q0();
        zzh = q0Var;
        l7.t(q0.class, q0Var);
    }

    private q0() {
    }

    public static q0 J() {
        return zzh;
    }

    public final boolean A() {
        return (this.zzc & 1) != 0;
    }

    public final b B() {
        b zza = b.zza(this.zzd);
        return zza == null ? b.UNKNOWN_MATCH_TYPE : zza;
    }

    public final boolean C() {
        return (this.zzc & 2) != 0;
    }

    public final String D() {
        return this.zze;
    }

    public final boolean E() {
        return (this.zzc & 4) != 0;
    }

    public final boolean F() {
        return this.zzf;
    }

    public final List<String> G() {
        return this.zzg;
    }

    public final int I() {
        return this.zzg.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        r0 r0Var = null;
        switch (r0.f5564a[i10 - 1]) {
            case 1:
                return new q0();
            case 2:
                return new a(r0Var);
            case 3:
                return l7.r(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", b.zzb(), "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                g9<q0> g9Var = zzi;
                if (g9Var == null) {
                    synchronized (q0.class) {
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
