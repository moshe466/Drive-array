package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class l1 extends l7<l1, a> implements a9 {
    private static final l1 zzj;
    private static volatile g9<l1> zzk;
    private int zzc;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    /* loaded from: classes.dex */
    public static final class a extends l7.b<l1, a> implements a9 {
        private a() {
            super(l1.zzj);
        }

        /* synthetic */ a(n1 n1Var) {
            this();
        }

        public final a A(long j10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((l1) this.f5446g).K(j10);
            return this;
        }

        public final a B(String str) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((l1) this.f5446g).Q(str);
            return this;
        }

        public final a C() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((l1) this.f5446g).d0();
            return this;
        }

        public final a u() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((l1) this.f5446g).b0();
            return this;
        }

        public final a w(double d10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((l1) this.f5446g).A(d10);
            return this;
        }

        public final a x(long j10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((l1) this.f5446g).B(j10);
            return this;
        }

        public final a y(String str) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((l1) this.f5446g).G(str);
            return this;
        }

        public final a z() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((l1) this.f5446g).c0();
            return this;
        }
    }

    static {
        l1 l1Var = new l1();
        zzj = l1Var;
        l7.t(l1.class, l1Var);
    }

    private l1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(double d10) {
        this.zzc |= 32;
        this.zzi = d10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j10) {
        this.zzc |= 1;
        this.zzd = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(long j10) {
        this.zzc |= 8;
        this.zzg = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(String str) {
        str.getClass();
        this.zzc |= 4;
        this.zzf = str;
    }

    public static a Z() {
        return zzj.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        this.zzc &= -5;
        this.zzf = zzj.zzf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        this.zzc &= -9;
        this.zzg = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        this.zzc &= -33;
        this.zzi = 0.0d;
    }

    public final boolean I() {
        return (this.zzc & 1) != 0;
    }

    public final long J() {
        return this.zzd;
    }

    public final String R() {
        return this.zze;
    }

    public final boolean T() {
        return (this.zzc & 4) != 0;
    }

    public final String U() {
        return this.zzf;
    }

    public final boolean V() {
        return (this.zzc & 8) != 0;
    }

    public final long W() {
        return this.zzg;
    }

    public final boolean X() {
        return (this.zzc & 32) != 0;
    }

    public final double Y() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        n1 n1Var = null;
        switch (n1.f5488a[i10 - 1]) {
            case 1:
                return new l1();
            case 2:
                return new a(n1Var);
            case 3:
                return l7.r(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                g9<l1> g9Var = zzk;
                if (g9Var == null) {
                    synchronized (l1.class) {
                        g9Var = zzk;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzj);
                            zzk = g9Var;
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
