package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlw extends zzdrt<zzdlw, zza> implements zzdtg {
    private static volatile zzdtn<zzdlw> zzdz;
    private static final zzdlw zzhaz;
    private int zzhaf;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlw, zza> implements zzdtg {
        private zza() {
            super(zzdlw.zzhaz);
        }

        /* synthetic */ zza(zzdlx zzdlxVar) {
            this();
        }
    }

    static {
        zzdlw zzdlwVar = new zzdlw();
        zzhaz = zzdlwVar;
        zzdrt.a((Class<zzdlw>) zzdlw.class, zzdlwVar);
    }

    private zzdlw() {
    }

    public static zzdlw zzaf(zzdqk zzdqkVar) {
        return (zzdlw) zzdrt.a(zzhaz, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdlx zzdlxVar = null;
        switch (zzdlx.a[i - 1]) {
            case 1:
                return new zzdlw();
            case 2:
                return new zza(zzdlxVar);
            case 3:
                return zzdrt.a(zzhaz, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\u000b", new Object[]{"zzhaf"});
            case 4:
                return zzhaz;
            case 5:
                zzdtn<zzdlw> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlw.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhaz);
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
}
