package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.e1;
import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class i1 extends l7<i1, a> implements a9 {
    private static final i1 zzf;
    private static volatile g9<i1> zzg;
    private int zzc;
    private int zzd = 1;
    private u7<e1> zze = l7.z();

    /* loaded from: classes.dex */
    public static final class a extends l7.b<i1, a> implements a9 {
        private a() {
            super(i1.zzf);
        }

        /* synthetic */ a(n1 n1Var) {
            this();
        }

        public final a u(e1.a aVar) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((i1) this.f5446g).B((e1) ((l7) aVar.g()));
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum b implements r7 {
        RADS(1),
        PROVISIONING(2);

        private static final q7<b> zzc = new q1();
        private final int zzd;

        b(int i10) {
            this.zzd = i10;
        }

        public static b zza(int i10) {
            if (i10 == 1) {
                return RADS;
            }
            if (i10 != 2) {
                return null;
            }
            return PROVISIONING;
        }

        public static t7 zzb() {
            return r1.f5565a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.r7
        public final int zza() {
            return this.zzd;
        }
    }

    static {
        i1 i1Var = new i1();
        zzf = i1Var;
        l7.t(i1.class, i1Var);
    }

    private i1() {
    }

    public static a A() {
        return zzf.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(e1 e1Var) {
        e1Var.getClass();
        u7<e1> u7Var = this.zze;
        if (!u7Var.zza()) {
            this.zze = l7.o(u7Var);
        }
        this.zze.add(e1Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        n1 n1Var = null;
        switch (n1.f5488a[i10 - 1]) {
            case 1:
                return new i1();
            case 2:
                return new a(n1Var);
            case 3:
                return l7.r(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", b.zzb(), "zze", e1.class});
            case 4:
                return zzf;
            case 5:
                g9<i1> g9Var = zzg;
                if (g9Var == null) {
                    synchronized (i1.class) {
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
