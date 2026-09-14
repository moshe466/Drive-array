package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlb extends zzdrt<zzdlb, zza> implements zzdtg {
    private static volatile zzdtn<zzdlb> zzdz;
    private static final zzdlb zzhag;
    private zzdlc zzhac;
    private int zzhaf;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlb, zza> implements zzdtg {
        private zza() {
            super(zzdlb.zzhag);
        }

        /* synthetic */ zza(zzdla zzdlaVar) {
            this();
        }
    }

    static {
        zzdlb zzdlbVar = new zzdlb();
        zzhag = zzdlbVar;
        zzdrt.a((Class<zzdlb>) zzdlb.class, zzdlbVar);
    }

    private zzdlb() {
    }

    public static zzdlb zzv(zzdqk zzdqkVar) {
        return (zzdlb) zzdrt.a(zzhag, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdla zzdlaVar = null;
        switch (zzdla.a[i - 1]) {
            case 1:
                return new zzdlb();
            case 2:
                return new zza(zzdlaVar);
            case 3:
                return zzdrt.a(zzhag, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhaf", "zzhac"});
            case 4:
                return zzhag;
            case 5:
                zzdtn<zzdlb> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlb.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhag);
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

    public final zzdlc zzast() {
        zzdlc zzdlcVar = this.zzhac;
        return zzdlcVar == null ? zzdlc.zzasy() : zzdlcVar;
    }
}
