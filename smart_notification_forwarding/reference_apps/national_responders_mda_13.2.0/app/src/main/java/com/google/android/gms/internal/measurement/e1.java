package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
public final class e1 extends l7<e1, a> implements a9 {
    private static final e1 zzf;
    private static volatile g9<e1> zzg;
    private int zzc;
    private String zzd = "";
    private long zze;

    /* loaded from: classes.dex */
    public static final class a extends l7.b<e1, a> implements a9 {
        private a() {
            super(e1.zzf);
        }

        /* synthetic */ a(n1 n1Var) {
            this();
        }

        public final a u(long j10) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((e1) this.f5446g).B(j10);
            return this;
        }

        public final a w(String str) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            ((e1) this.f5446g).E(str);
            return this;
        }
    }

    static {
        e1 e1Var = new e1();
        zzf = e1Var;
        l7.t(e1.class, e1Var);
    }

    private e1() {
    }

    public static a A() {
        return zzf.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j10) {
        this.zzc |= 2;
        this.zze = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.l7
    public final Object q(int i10, Object obj, Object obj2) {
        n1 n1Var = null;
        switch (n1.f5488a[i10 - 1]) {
            case 1:
                return new e1();
            case 2:
                return new a(n1Var);
            case 3:
                return l7.r(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                g9<e1> g9Var = zzg;
                if (g9Var == null) {
                    synchronized (e1.class) {
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
