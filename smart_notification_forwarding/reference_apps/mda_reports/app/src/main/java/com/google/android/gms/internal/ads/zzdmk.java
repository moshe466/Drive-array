package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdmk extends zzdrt<zzdmk, zza> implements zzdtg {
    private static volatile zzdtn<zzdmk> zzdz;
    private static final zzdmk zzhbr;
    private int zzhaa;
    private zzdqk zzhab = zzdqk.zzhhx;
    private zzdmn zzhbq;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdmk, zza> implements zzdtg {
        private zza() {
            super(zzdmk.zzhbr);
        }

        /* synthetic */ zza(zzdml zzdmlVar) {
            this();
        }

        public final zza zzam(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdmk) this.a).zzs(zzdqkVar);
            return this;
        }

        public final zza zzb(zzdmn zzdmnVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdmk) this.a).zza(zzdmnVar);
            return this;
        }

        public final zza zzej(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdmk) this.a).setVersion(0);
            return this;
        }
    }

    static {
        zzdmk zzdmkVar = new zzdmk();
        zzhbr = zzdmkVar;
        zzdrt.a((Class<zzdmk>) zzdmk.class, zzdmkVar);
    }

    private zzdmk() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdmn zzdmnVar) {
        zzdmnVar.getClass();
        this.zzhbq = zzdmnVar;
    }

    public static zzdmk zzal(zzdqk zzdqkVar) {
        return (zzdmk) zzdrt.a(zzhbr, zzdqkVar);
    }

    public static zza zzaun() {
        return zzhbr.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhab = zzdqkVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdml zzdmlVar = null;
        switch (zzdml.a[i - 1]) {
            case 1:
                return new zzdmk();
            case 2:
                return new zza(zzdmlVar);
            case 3:
                return zzdrt.a(zzhbr, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhaa", "zzhbq", "zzhab"});
            case 4:
                return zzhbr;
            case 5:
                zzdtn<zzdmk> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdmk.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhbr);
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

    public final zzdmn zzaum() {
        zzdmn zzdmnVar = this.zzhbq;
        return zzdmnVar == null ? zzdmn.zzaus() : zzdmnVar;
    }
}
