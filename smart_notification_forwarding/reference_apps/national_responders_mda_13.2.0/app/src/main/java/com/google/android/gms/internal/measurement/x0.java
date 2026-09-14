package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;
import com.google.android.gms.internal.measurement.w0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class x0 extends l7<x0, a> implements a9 {
    private static final x0 zzm;
    private static volatile g9<x0> zzn;
    private int zzc;
    private long zzd;
    private int zzf;
    private boolean zzk;
    private String zze = "";
    private u7<y0> zzg = l7.z();
    private u7<w0> zzh = l7.z();
    private u7<l0> zzi = l7.z();
    private String zzj = "";
    private u7<u1> zzl = l7.z();

    /* loaded from: classes.dex */
    public static final class a extends l7.b<x0, a> implements a9 {
        private a() {
            super(x0.zzm);
        }

        /* synthetic */ a(a1 a1Var) {
            this();
        }

        public final int u() {
            return ((x0) this.f5446g).K();
        }

        public final w0 w(int i10) {
            return ((x0) this.f5446g).A(i10);
        }

        public final a x(int i10, w0.a aVar) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((x0) this.f5446g).B(i10, (w0) ((l7) aVar.g()));
            return this;
        }

        public final List<l0> y() {
            return Collections.unmodifiableList(((x0) this.f5446g).L());
        }

        public final a z() {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((x0) this.f5446g).S();
            return this;
        }
    }

    static {
        x0 x0Var = new x0();
        zzm = x0Var;
        l7.t(x0.class, x0Var);
    }

    private x0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(int i10, w0 w0Var) {
        w0Var.getClass();
        u7<w0> u7Var = this.zzh;
        if (!u7Var.zza()) {
            this.zzh = l7.o(u7Var);
        }
        this.zzh.set(i10, w0Var);
    }

    public static a P() {
        return zzm.v();
    }

    public static x0 Q() {
        return zzm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        this.zzi = l7.z();
    }

    public final w0 A(int i10) {
        return this.zzh.get(i10);
    }

    public final boolean E() {
        return (this.zzc & 1) != 0;
    }

    public final long F() {
        return this.zzd;
    }

    public final boolean G() {
        return (this.zzc & 2) != 0;
    }

    public final String I() {
        return this.zze;
    }

    public final List<y0> J() {
        return this.zzg;
    }

    public final int K() {
        return this.zzh.size();
    }

    public final List<l0> L() {
        return this.zzi;
    }

    public final boolean O() {
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        a1 a1Var = null;
        switch (a1.f5155a[i10 - 1]) {
            case 1:
                return new x0();
            case 2:
                return new a(a1Var);
            case 3:
                return l7.r(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", y0.class, "zzh", w0.class, "zzi", l0.class, "zzj", "zzk", "zzl", u1.class});
            case 4:
                return zzm;
            case 5:
                g9<x0> g9Var = zzn;
                if (g9Var == null) {
                    synchronized (x0.class) {
                        g9Var = zzn;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzm);
                            zzn = g9Var;
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
