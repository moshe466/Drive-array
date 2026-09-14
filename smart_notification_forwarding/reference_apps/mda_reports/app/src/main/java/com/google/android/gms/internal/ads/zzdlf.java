package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlf extends zzdrt<zzdlf, zza> implements zzdtg {
    private static volatile zzdtn<zzdlf> zzdz;
    private static final zzdlf zzhal;
    private int zzhaa;
    private zzdlj zzhaj;
    private zzdmv zzhak;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlf, zza> implements zzdtg {
        private zza() {
            super(zzdlf.zzhal);
        }

        /* synthetic */ zza(zzdle zzdleVar) {
            this();
        }

        public final zza zzb(zzdlj zzdljVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlf) this.a).zza(zzdljVar);
            return this;
        }

        public final zza zzb(zzdmv zzdmvVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlf) this.a).zza(zzdmvVar);
            return this;
        }

        public final zza zzed(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlf) this.a).setVersion(i);
            return this;
        }
    }

    static {
        zzdlf zzdlfVar = new zzdlf();
        zzhal = zzdlfVar;
        zzdrt.a((Class<zzdlf>) zzdlf.class, zzdlfVar);
    }

    private zzdlf() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdlj zzdljVar) {
        zzdljVar.getClass();
        this.zzhaj = zzdljVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdmv zzdmvVar) {
        zzdmvVar.getClass();
        this.zzhak = zzdmvVar;
    }

    public static zza zzatc() {
        return zzhal.b();
    }

    public static zzdlf zzw(zzdqk zzdqkVar) {
        return (zzdlf) zzdrt.a(zzhal, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdle zzdleVar = null;
        switch (zzdle.a[i - 1]) {
            case 1:
                return new zzdlf();
            case 2:
                return new zza(zzdleVar);
            case 3:
                return zzdrt.a(zzhal, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzhaa", "zzhaj", "zzhak"});
            case 4:
                return zzhal;
            case 5:
                zzdtn<zzdlf> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlf.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhal);
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

    public final int getVersion() {
        return this.zzhaa;
    }

    public final zzdlj zzata() {
        zzdlj zzdljVar = this.zzhaj;
        return zzdljVar == null ? zzdlj.zzatj() : zzdljVar;
    }

    public final zzdmv zzatb() {
        zzdmv zzdmvVar = this.zzhak;
        return zzdmvVar == null ? zzdmv.zzavb() : zzdmvVar;
    }
}
