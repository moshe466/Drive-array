package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;
import java.util.List;

/* loaded from: classes.dex */
public final class f1 extends l7<f1, a> implements a9 {
    private static final f1 zzj;
    private static volatile g9<f1> zzk;
    private int zzc;
    private long zzf;
    private float zzg;
    private double zzh;
    private String zzd = "";
    private String zze = "";
    private u7<f1> zzi = l7.z();

    /* loaded from: classes.dex */
    public static final class a extends l7.b<f1, a> implements a9 {
        private a() {
            super(f1.zzj);
        }

        /* synthetic */ a(n1 n1Var) {
            this();
        }

        public final a A(String str) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((f1) this.f5446g).K(str);
            return this;
        }

        public final a B() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((f1) this.f5446g).i0();
            return this;
        }

        public final a C(String str) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((f1) this.f5446g).R(str);
            return this;
        }

        public final a E() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((f1) this.f5446g).j0();
            return this;
        }

        public final int F() {
            return ((f1) this.f5446g).e0();
        }

        public final a G() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((f1) this.f5446g).l0();
            return this;
        }

        public final a u() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((f1) this.f5446g).h0();
            return this;
        }

        public final a w(double d10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((f1) this.f5446g).A(d10);
            return this;
        }

        public final a x(long j10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((f1) this.f5446g).B(j10);
            return this;
        }

        public final a y(a aVar) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((f1) this.f5446g).W((f1) ((l7) aVar.g()));
            return this;
        }

        public final a z(Iterable<? extends f1> iterable) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((f1) this.f5446g).J(iterable);
            return this;
        }
    }

    static {
        f1 f1Var = new f1();
        zzj = f1Var;
        l7.t(f1.class, f1Var);
    }

    private f1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(double d10) {
        this.zzc |= 16;
        this.zzh = d10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j10) {
        this.zzc |= 4;
        this.zzf = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(Iterable<? extends f1> iterable) {
        k0();
        u5.c(iterable, this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(f1 f1Var) {
        f1Var.getClass();
        k0();
        this.zzi.add(f1Var);
    }

    public static a f0() {
        return zzj.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        this.zzc &= -3;
        this.zze = zzj.zze;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        this.zzc &= -5;
        this.zzf = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        this.zzc &= -17;
        this.zzh = 0.0d;
    }

    private final void k0() {
        u7<f1> u7Var = this.zzi;
        if (u7Var.zza()) {
            return;
        }
        this.zzi = l7.o(u7Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        this.zzi = l7.z();
    }

    public final boolean L() {
        return (this.zzc & 1) != 0;
    }

    public final String O() {
        return this.zzd;
    }

    public final boolean T() {
        return (this.zzc & 2) != 0;
    }

    public final String U() {
        return this.zze;
    }

    public final boolean X() {
        return (this.zzc & 4) != 0;
    }

    public final long Y() {
        return this.zzf;
    }

    public final boolean Z() {
        return (this.zzc & 8) != 0;
    }

    public final float a0() {
        return this.zzg;
    }

    public final boolean b0() {
        return (this.zzc & 16) != 0;
    }

    public final double c0() {
        return this.zzh;
    }

    public final List<f1> d0() {
        return this.zzi;
    }

    public final int e0() {
        return this.zzi.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        n1 n1Var = null;
        switch (n1.f5488a[i10 - 1]) {
            case 1:
                return new f1();
            case 2:
                return new a(n1Var);
            case 3:
                return l7.r(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", f1.class});
            case 4:
                return zzj;
            case 5:
                g9<f1> g9Var = zzk;
                if (g9Var == null) {
                    synchronized (f1.class) {
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
