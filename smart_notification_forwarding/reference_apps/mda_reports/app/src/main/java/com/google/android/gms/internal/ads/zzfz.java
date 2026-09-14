package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzfz extends zzdrt<zzfz, zza> implements zzdtg {
    private static final zzfz zzaat;
    private static volatile zzdtn<zzfz> zzdz;
    private String zzaao = "";
    private String zzaap = "";
    private long zzaaq;
    private long zzaar;
    private long zzaas;
    private int zzdl;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzfz, zza> implements zzdtg {
        private zza() {
            super(zzfz.zzaat);
        }

        /* synthetic */ zza(zzga zzgaVar) {
            this();
        }

        public final zza zzay(String str) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzfz) this.a).zzaw(str);
            return this;
        }

        public final zza zzaz(String str) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzfz) this.a).zzax(str);
            return this;
        }

        public final zza zzdj(long j) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzfz) this.a).zzdg(j);
            return this;
        }

        public final zza zzdk(long j) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzfz) this.a).zzdh(j);
            return this;
        }

        public final zza zzdl(long j) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzfz) this.a).zzdi(j);
            return this;
        }
    }

    static {
        zzfz zzfzVar = new zzfz();
        zzaat = zzfzVar;
        zzdrt.a((Class<zzfz>) zzfz.class, zzfzVar);
    }

    private zzfz() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaw(String str) {
        str.getClass();
        this.zzdl |= 1;
        this.zzaao = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzax(String str) {
        str.getClass();
        this.zzdl |= 2;
        this.zzaap = str;
    }

    public static zza zzdc() {
        return zzaat.b();
    }

    public static zzfz zzdd() {
        return zzaat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdg(long j) {
        this.zzdl |= 4;
        this.zzaaq = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdh(long j) {
        this.zzdl |= 8;
        this.zzaar = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdi(long j) {
        this.zzdl |= 16;
        this.zzaas = j;
    }

    public static zzfz zzl(zzdqk zzdqkVar) {
        return (zzfz) zzdrt.a(zzaat, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzga zzgaVar = null;
        switch (zzga.a[i - 1]) {
            case 1:
                return new zzfz();
            case 2:
                return new zza(zzgaVar);
            case 3:
                return zzdrt.a(zzaat, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0003\u0002\u0004\u0003\u0003\u0005\u0003\u0004", new Object[]{"zzdl", "zzaao", "zzaap", "zzaaq", "zzaar", "zzaas"});
            case 4:
                return zzaat;
            case 5:
                zzdtn<zzfz> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzfz.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzaat);
                            zzdz = zzdtnVar;
                        }
                    }
                }
                return zzdtnVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final String zzcx() {
        return this.zzaao;
    }

    public final String zzcy() {
        return this.zzaap;
    }

    public final long zzcz() {
        return this.zzaaq;
    }

    public final long zzda() {
        return this.zzaar;
    }

    public final long zzdb() {
        return this.zzaas;
    }
}
