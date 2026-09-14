package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;
import com.google.android.gms.internal.measurement.m0;
import com.google.android.gms.internal.measurement.p0;
import java.util.List;

/* loaded from: classes.dex */
public final class l0 extends l7<l0, a> implements a9 {
    private static final l0 zzi;
    private static volatile g9<l0> zzj;
    private int zzc;
    private int zzd;
    private u7<p0> zze = l7.z();
    private u7<m0> zzf = l7.z();
    private boolean zzg;
    private boolean zzh;

    /* loaded from: classes.dex */
    public static final class a extends l7.b<l0, a> implements a9 {
        private a() {
            super(l0.zzi);
        }

        /* synthetic */ a(r0 r0Var) {
            this();
        }

        public final m0 A(int i10) {
            return ((l0) this.f5446g).I(i10);
        }

        public final int u() {
            return ((l0) this.f5446g).K();
        }

        public final a w(int i10, m0.a aVar) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((l0) this.f5446g).B(i10, (m0) ((l7) aVar.g()));
            return this;
        }

        public final a x(int i10, p0.a aVar) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((l0) this.f5446g).C(i10, (p0) ((l7) aVar.g()));
            return this;
        }

        public final p0 y(int i10) {
            return ((l0) this.f5446g).A(i10);
        }

        public final int z() {
            return ((l0) this.f5446g).O();
        }
    }

    static {
        l0 l0Var = new l0();
        zzi = l0Var;
        l7.t(l0.class, l0Var);
    }

    private l0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(int i10, m0 m0Var) {
        m0Var.getClass();
        u7<m0> u7Var = this.zzf;
        if (!u7Var.zza()) {
            this.zzf = l7.o(u7Var);
        }
        this.zzf.set(i10, m0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int i10, p0 p0Var) {
        p0Var.getClass();
        u7<p0> u7Var = this.zze;
        if (!u7Var.zza()) {
            this.zze = l7.o(u7Var);
        }
        this.zze.set(i10, p0Var);
    }

    public final p0 A(int i10) {
        return this.zze.get(i10);
    }

    public final boolean F() {
        return (this.zzc & 1) != 0;
    }

    public final int G() {
        return this.zzd;
    }

    public final m0 I(int i10) {
        return this.zzf.get(i10);
    }

    public final List<p0> J() {
        return this.zze;
    }

    public final int K() {
        return this.zze.size();
    }

    public final List<m0> L() {
        return this.zzf;
    }

    public final int O() {
        return this.zzf.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        r0 r0Var = null;
        switch (r0.f5564a[i10 - 1]) {
            case 1:
                return new l0();
            case 2:
                return new a(r0Var);
            case 3:
                return l7.r(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", p0.class, "zzf", m0.class, "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                g9<l0> g9Var = zzj;
                if (g9Var == null) {
                    synchronized (l0.class) {
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
