package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;
import java.util.List;

/* loaded from: classes.dex */
public final class m0 extends l7<m0, a> implements a9 {
    private static final m0 zzl;
    private static volatile g9<m0> zzm;
    private int zzc;
    private int zzd;
    private String zze = "";
    private u7<n0> zzf = l7.z();
    private boolean zzg;
    private o0 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    /* loaded from: classes.dex */
    public static final class a extends l7.b<m0, a> implements a9 {
        private a() {
            super(m0.zzl);
        }

        /* synthetic */ a(r0 r0Var) {
            this();
        }

        public final a u(int i10, n0 n0Var) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((m0) this.f5446g).B(i10, n0Var);
            return this;
        }

        public final a w(String str) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((m0) this.f5446g).E(str);
            return this;
        }

        public final n0 x(int i10) {
            return ((m0) this.f5446g).A(i10);
        }

        public final String y() {
            return ((m0) this.f5446g).I();
        }

        public final int z() {
            return ((m0) this.f5446g).K();
        }
    }

    static {
        m0 m0Var = new m0();
        zzl = m0Var;
        l7.t(m0.class, m0Var);
    }

    private m0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(int i10, n0 n0Var) {
        n0Var.getClass();
        u7<n0> u7Var = this.zzf;
        if (!u7Var.zza()) {
            this.zzf = l7.o(u7Var);
        }
        this.zzf.set(i10, n0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    public static a T() {
        return zzl.v();
    }

    public final n0 A(int i10) {
        return this.zzf.get(i10);
    }

    public final boolean F() {
        return (this.zzc & 1) != 0;
    }

    public final int G() {
        return this.zzd;
    }

    public final String I() {
        return this.zze;
    }

    public final List<n0> J() {
        return this.zzf;
    }

    public final int K() {
        return this.zzf.size();
    }

    public final boolean L() {
        return (this.zzc & 8) != 0;
    }

    public final o0 O() {
        o0 o0Var = this.zzh;
        return o0Var == null ? o0.L() : o0Var;
    }

    public final boolean P() {
        return this.zzi;
    }

    public final boolean Q() {
        return this.zzj;
    }

    public final boolean R() {
        return (this.zzc & 64) != 0;
    }

    public final boolean S() {
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        r0 r0Var = null;
        switch (r0.f5564a[i10 - 1]) {
            case 1:
                return new m0();
            case 2:
                return new a(r0Var);
            case 3:
                return l7.r(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", n0.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                g9<m0> g9Var = zzm;
                if (g9Var == null) {
                    synchronized (m0.class) {
                        g9Var = zzm;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzl);
                            zzm = g9Var;
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
