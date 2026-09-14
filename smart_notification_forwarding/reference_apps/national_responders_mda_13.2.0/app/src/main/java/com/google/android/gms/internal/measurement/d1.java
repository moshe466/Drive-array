package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.f1;
import com.google.android.gms.internal.measurement.l7;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class d1 extends l7<d1, a> implements a9 {
    private static final d1 zzi;
    private static volatile g9<d1> zzj;
    private int zzc;
    private u7<f1> zzd = l7.z();
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;

    /* loaded from: classes.dex */
    public static final class a extends l7.b<d1, a> implements a9 {
        private a() {
            super(d1.zzi);
        }

        /* synthetic */ a(n1 n1Var) {
            this();
        }

        public final a A(Iterable<? extends f1> iterable) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((d1) this.f5446g).P(iterable);
            return this;
        }

        public final a B(String str) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((d1) this.f5446g).Q(str);
            return this;
        }

        public final f1 C(int i10) {
            return ((d1) this.f5446g).A(i10);
        }

        public final List<f1> E() {
            return Collections.unmodifiableList(((d1) this.f5446g).B());
        }

        public final int F() {
            return ((d1) this.f5446g).R();
        }

        public final a G(int i10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((d1) this.f5446g).S(i10);
            return this;
        }

        public final a I(long j10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((d1) this.f5446g).T(j10);
            return this;
        }

        public final a J() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((d1) this.f5446g).f0();
            return this;
        }

        public final String K() {
            return ((d1) this.f5446g).V();
        }

        public final boolean L() {
            return ((d1) this.f5446g).W();
        }

        public final long O() {
            return ((d1) this.f5446g).X();
        }

        public final long P() {
            return ((d1) this.f5446g).Z();
        }

        public final a u(int i10, f1.a aVar) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((d1) this.f5446g).C(i10, (f1) ((l7) aVar.g()));
            return this;
        }

        public final a w(int i10, f1 f1Var) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((d1) this.f5446g).C(i10, f1Var);
            return this;
        }

        public final a x(long j10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((d1) this.f5446g).D(j10);
            return this;
        }

        public final a y(f1.a aVar) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((d1) this.f5446g).O((f1) ((l7) aVar.g()));
            return this;
        }

        public final a z(f1 f1Var) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((d1) this.f5446g).O(f1Var);
            return this;
        }
    }

    static {
        d1 d1Var = new d1();
        zzi = d1Var;
        l7.t(d1.class, d1Var);
    }

    private d1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int i10, f1 f1Var) {
        f1Var.getClass();
        e0();
        this.zzd.set(i10, f1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(long j10) {
        this.zzc |= 2;
        this.zzf = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(f1 f1Var) {
        f1Var.getClass();
        e0();
        this.zzd.add(f1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(Iterable<? extends f1> iterable) {
        e0();
        u5.c(iterable, this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(int i10) {
        e0();
        this.zzd.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(long j10) {
        this.zzc |= 4;
        this.zzg = j10;
    }

    public static a c0() {
        return zzi.v();
    }

    private final void e0() {
        u7<f1> u7Var = this.zzd;
        if (u7Var.zza()) {
            return;
        }
        this.zzd = l7.o(u7Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        this.zzd = l7.z();
    }

    public final f1 A(int i10) {
        return this.zzd.get(i10);
    }

    public final List<f1> B() {
        return this.zzd;
    }

    public final int R() {
        return this.zzd.size();
    }

    public final String V() {
        return this.zze;
    }

    public final boolean W() {
        return (this.zzc & 2) != 0;
    }

    public final long X() {
        return this.zzf;
    }

    public final boolean Y() {
        return (this.zzc & 4) != 0;
    }

    public final long Z() {
        return this.zzg;
    }

    public final boolean a0() {
        return (this.zzc & 8) != 0;
    }

    public final int b0() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        n1 n1Var = null;
        switch (n1.f5488a[i10 - 1]) {
            case 1:
                return new d1();
            case 2:
                return new a(n1Var);
            case 3:
                return l7.r(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", f1.class, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                g9<d1> g9Var = zzj;
                if (g9Var == null) {
                    synchronized (d1.class) {
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
