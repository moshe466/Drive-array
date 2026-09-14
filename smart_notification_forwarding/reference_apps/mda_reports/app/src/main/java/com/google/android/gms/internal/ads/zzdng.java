package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdng extends zzdrt<zzdng, zza> implements zzdtg {
    private static volatile zzdtn<zzdng> zzdz;
    private static final zzdng zzhdk;
    private String zzhcs = "";
    private zzdqk zzhct = zzdqk.zzhhx;
    private int zzhdj;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdng, zza> implements zzdtg {
        private zza() {
            super(zzdng.zzhdk);
        }

        /* synthetic */ zza(zzdnf zzdnfVar) {
            this();
        }
    }

    static {
        zzdng zzdngVar = new zzdng();
        zzhdk = zzdngVar;
        zzdrt.a((Class<zzdng>) zzdng.class, zzdngVar);
    }

    private zzdng() {
    }

    public static zzdng zzavo() {
        return zzhdk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdnf zzdnfVar = null;
        switch (zzdnf.a[i - 1]) {
            case 1:
                return new zzdng();
            case 2:
                return new zza(zzdnfVar);
            case 3:
                return zzdrt.a(zzhdk, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzhcs", "zzhct", "zzhdj"});
            case 4:
                return zzhdk;
            case 5:
                zzdtn<zzdng> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdng.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhdk);
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

    public final String zzavi() {
        return this.zzhcs;
    }

    public final zzdqk zzavj() {
        return this.zzhct;
    }
}
