package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdmv extends zzdrt<zzdmv, zza> implements zzdtg {
    private static volatile zzdtn<zzdmv> zzdz;
    private static final zzdmv zzhco;
    private int zzhaa;
    private zzdqk zzhab = zzdqk.zzhhx;
    private zzdmz zzhcn;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdmv, zza> implements zzdtg {
        private zza() {
            super(zzdmv.zzhco);
        }

        /* synthetic */ zza(zzdmu zzdmuVar) {
            this();
        }

        public final zza zzau(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdmv) this.a).zzs(zzdqkVar);
            return this;
        }

        public final zza zzd(zzdmz zzdmzVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdmv) this.a).zzc(zzdmzVar);
            return this;
        }

        public final zza zzen(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdmv) this.a).setVersion(0);
            return this;
        }
    }

    static {
        zzdmv zzdmvVar = new zzdmv();
        zzhco = zzdmvVar;
        zzdrt.a((Class<zzdmv>) zzdmv.class, zzdmvVar);
    }

    private zzdmv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    public static zzdmv zzas(zzdqk zzdqkVar) {
        return (zzdmv) zzdrt.a(zzhco, zzdqkVar);
    }

    public static zza zzava() {
        return zzhco.b();
    }

    public static zzdmv zzavb() {
        return zzhco;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzdmz zzdmzVar) {
        zzdmzVar.getClass();
        this.zzhcn = zzdmzVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhab = zzdqkVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdmu zzdmuVar = null;
        switch (zzdmu.a[i - 1]) {
            case 1:
                return new zzdmv();
            case 2:
                return new zza(zzdmuVar);
            case 3:
                return zzdrt.a(zzhco, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhaa", "zzhcn", "zzhab"});
            case 4:
                return zzhco;
            case 5:
                zzdtn<zzdmv> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdmv.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhco);
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

    public final zzdqk zzass() {
        return this.zzhab;
    }

    public final zzdmz zzauz() {
        zzdmz zzdmzVar = this.zzhcn;
        return zzdmzVar == null ? zzdmz.zzavg() : zzdmzVar;
    }
}
