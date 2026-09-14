package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdmw extends zzdrt<zzdmw, zza> implements zzdtg {
    private static volatile zzdtn<zzdmw> zzdz;
    private static final zzdmw zzhcp;
    private int zzhaf;
    private zzdmz zzhcn;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdmw, zza> implements zzdtg {
        private zza() {
            super(zzdmw.zzhcp);
        }

        /* synthetic */ zza(zzdmx zzdmxVar) {
            this();
        }
    }

    static {
        zzdmw zzdmwVar = new zzdmw();
        zzhcp = zzdmwVar;
        zzdrt.a((Class<zzdmw>) zzdmw.class, zzdmwVar);
    }

    private zzdmw() {
    }

    public static zzdmw zzat(zzdqk zzdqkVar) {
        return (zzdmw) zzdrt.a(zzhcp, zzdqkVar);
    }

    public static zzdmw zzavd() {
        return zzhcp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdmx zzdmxVar = null;
        switch (zzdmx.a[i - 1]) {
            case 1:
                return new zzdmw();
            case 2:
                return new zza(zzdmxVar);
            case 3:
                return zzdrt.a(zzhcp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzhcn", "zzhaf"});
            case 4:
                return zzhcp;
            case 5:
                zzdtn<zzdmw> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdmw.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhcp);
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

    public final int getKeySize() {
        return this.zzhaf;
    }

    public final zzdmz zzauz() {
        zzdmz zzdmzVar = this.zzhcn;
        return zzdmzVar == null ? zzdmz.zzavg() : zzdmzVar;
    }
}
