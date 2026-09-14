package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdky extends zzdrt<zzdky, zza> implements zzdtg {
    private static volatile zzdtn<zzdky> zzdz;
    private static final zzdky zzhad;
    private int zzhaa;
    private zzdqk zzhab = zzdqk.zzhhx;
    private zzdlc zzhac;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdky, zza> implements zzdtg {
        private zza() {
            super(zzdky.zzhad);
        }

        /* synthetic */ zza(zzdkz zzdkzVar) {
            this();
        }

        public final zza zzd(zzdlc zzdlcVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdky) this.a).zzc(zzdlcVar);
            return this;
        }

        public final zza zzec(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdky) this.a).setVersion(0);
            return this;
        }

        public final zza zzu(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdky) this.a).zzs(zzdqkVar);
            return this;
        }
    }

    static {
        zzdky zzdkyVar = new zzdky();
        zzhad = zzdkyVar;
        zzdrt.a((Class<zzdky>) zzdky.class, zzdkyVar);
    }

    private zzdky() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    public static zza zzasu() {
        return zzhad.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzdlc zzdlcVar) {
        zzdlcVar.getClass();
        this.zzhac = zzdlcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhab = zzdqkVar;
    }

    public static zzdky zzt(zzdqk zzdqkVar) {
        return (zzdky) zzdrt.a(zzhad, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdkz zzdkzVar = null;
        switch (zzdkz.a[i - 1]) {
            case 1:
                return new zzdky();
            case 2:
                return new zza(zzdkzVar);
            case 3:
                return zzdrt.a(zzhad, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzhaa", "zzhab", "zzhac"});
            case 4:
                return zzhad;
            case 5:
                zzdtn<zzdky> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdky.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhad);
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

    public final zzdlc zzast() {
        zzdlc zzdlcVar = this.zzhac;
        return zzdlcVar == null ? zzdlc.zzasy() : zzdlcVar;
    }
}
