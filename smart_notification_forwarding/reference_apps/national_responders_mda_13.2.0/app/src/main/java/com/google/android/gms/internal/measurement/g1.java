package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h1;
import com.google.android.gms.internal.measurement.l7;
import java.util.List;

/* loaded from: classes.dex */
public final class g1 extends l7<g1, a> implements a9 {
    private static final g1 zzd;
    private static volatile g9<g1> zze;
    private u7<h1> zzc = l7.z();

    /* loaded from: classes.dex */
    public static final class a extends l7.b<g1, a> implements a9 {
        private a() {
            super(g1.zzd);
        }

        /* synthetic */ a(n1 n1Var) {
            this();
        }

        public final a u(h1.a aVar) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((g1) this.f5446g).D((h1) ((l7) aVar.g()));
            return this;
        }

        public final h1 w(int i10) {
            return ((g1) this.f5446g).A(0);
        }
    }

    static {
        g1 g1Var = new g1();
        zzd = g1Var;
        l7.t(g1.class, g1Var);
    }

    private g1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(h1 h1Var) {
        h1Var.getClass();
        u7<h1> u7Var = this.zzc;
        if (!u7Var.zza()) {
            this.zzc = l7.o(u7Var);
        }
        this.zzc.add(h1Var);
    }

    public static a E() {
        return zzd.v();
    }

    public final h1 A(int i10) {
        return this.zzc.get(0);
    }

    public final List<h1> B() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        n1 n1Var = null;
        switch (n1.f5488a[i10 - 1]) {
            case 1:
                return new g1();
            case 2:
                return new a(n1Var);
            case 3:
                return l7.r(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", h1.class});
            case 4:
                return zzd;
            case 5:
                g9<g1> g9Var = zze;
                if (g9Var == null) {
                    synchronized (g1.class) {
                        g9Var = zze;
                        if (g9Var == null) {
                            g9Var = new l7.a<>(zzd);
                            zze = g9Var;
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
