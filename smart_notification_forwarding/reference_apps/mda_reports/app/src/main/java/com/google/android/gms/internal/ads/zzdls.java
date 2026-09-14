package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdls extends zzdrt<zzdls, zza> implements zzdtg {
    private static volatile zzdtn<zzdls> zzdz;
    private static final zzdls zzhax;
    private int zzhas;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdls, zza> implements zzdtg {
        private zza() {
            super(zzdls.zzhax);
        }

        /* synthetic */ zza(zzdlt zzdltVar) {
            this();
        }
    }

    static {
        zzdls zzdlsVar = new zzdls();
        zzhax = zzdlsVar;
        zzdrt.a((Class<zzdls>) zzdls.class, zzdlsVar);
    }

    private zzdls() {
    }

    public static zzdls zzatu() {
        return zzhax;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdlt zzdltVar = null;
        switch (zzdlt.a[i - 1]) {
            case 1:
                return new zzdls();
            case 2:
                return new zza(zzdltVar);
            case 3:
                return zzdrt.a(zzhax, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhas"});
            case 4:
                return zzhax;
            case 5:
                zzdtn<zzdls> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdls.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhax);
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

    public final int zzatn() {
        return this.zzhas;
    }
}
