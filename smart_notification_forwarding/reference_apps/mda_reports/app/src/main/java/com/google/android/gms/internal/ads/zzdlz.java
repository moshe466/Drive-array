package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlz extends zzdrt<zzdlz, zza> implements zzdtg {
    private static volatile zzdtn<zzdlz> zzdz;
    private static final zzdlz zzhba;
    private int zzhaa;
    private zzdqk zzhab = zzdqk.zzhhx;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlz, zza> implements zzdtg {
        private zza() {
            super(zzdlz.zzhba);
        }

        /* synthetic */ zza(zzdly zzdlyVar) {
            this();
        }

        public final zza zzaj(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlz) this.a).zzs(zzdqkVar);
            return this;
        }

        public final zza zzeh(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlz) this.a).setVersion(0);
            return this;
        }
    }

    static {
        zzdlz zzdlzVar = new zzdlz();
        zzhba = zzdlzVar;
        zzdrt.a((Class<zzdlz>) zzdlz.class, zzdlzVar);
    }

    private zzdlz() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    public static zzdlz zzah(zzdqk zzdqkVar) {
        return (zzdlz) zzdrt.a(zzhba, zzdqkVar);
    }

    public static zza zzatz() {
        return zzhba.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhab = zzdqkVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdly zzdlyVar = null;
        switch (zzdly.a[i - 1]) {
            case 1:
                return new zzdlz();
            case 2:
                return new zza(zzdlyVar);
            case 3:
                return zzdrt.a(zzhba, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzhaa", "zzhab"});
            case 4:
                return zzhba;
            case 5:
                zzdtn<zzdlz> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlz.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhba);
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
}
