package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlr extends zzdrt<zzdlr, zza> implements zzdtg {
    private static volatile zzdtn<zzdlr> zzdz;
    private static final zzdlr zzhaw;
    private int zzhaf;
    private zzdls zzhau;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlr, zza> implements zzdtg {
        private zza() {
            super(zzdlr.zzhaw);
        }

        /* synthetic */ zza(zzdlq zzdlqVar) {
            this();
        }
    }

    static {
        zzdlr zzdlrVar = new zzdlr();
        zzhaw = zzdlrVar;
        zzdrt.a((Class<zzdlr>) zzdlr.class, zzdlrVar);
    }

    private zzdlr() {
    }

    public static zzdlr zzad(zzdqk zzdqkVar) {
        return (zzdlr) zzdrt.a(zzhaw, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdlq zzdlqVar = null;
        switch (zzdlq.a[i - 1]) {
            case 1:
                return new zzdlr();
            case 2:
                return new zza(zzdlqVar);
            case 3:
                return zzdrt.a(zzhaw, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzhau", "zzhaf"});
            case 4:
                return zzhaw;
            case 5:
                zzdtn<zzdlr> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlr.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhaw);
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

    public final zzdls zzatq() {
        zzdls zzdlsVar = this.zzhau;
        return zzdlsVar == null ? zzdls.zzatu() : zzdlsVar;
    }
}
