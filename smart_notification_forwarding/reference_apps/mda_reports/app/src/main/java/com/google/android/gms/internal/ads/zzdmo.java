package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdmo extends zzdrt<zzdmo, zza> implements zzdtg {
    private static volatile zzdtn<zzdmo> zzdz;
    private static final zzdmo zzhby;
    private int zzhbv;
    private int zzhbw;
    private zzdqk zzhbx = zzdqk.zzhhx;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdmo, zza> implements zzdtg {
        private zza() {
            super(zzdmo.zzhby);
        }

        /* synthetic */ zza(zzdmp zzdmpVar) {
            this();
        }
    }

    static {
        zzdmo zzdmoVar = new zzdmo();
        zzhby = zzdmoVar;
        zzdrt.a((Class<zzdmo>) zzdmo.class, zzdmoVar);
    }

    private zzdmo() {
    }

    public static zzdmo zzaux() {
        return zzhby;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdmp zzdmpVar = null;
        switch (zzdmp.a[i - 1]) {
            case 1:
                return new zzdmo();
            case 2:
                return new zza(zzdmpVar);
            case 3:
                return zzdrt.a(zzhby, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzhbv", "zzhbw", "zzhbx"});
            case 4:
                return zzhby;
            case 5:
                zzdtn<zzdmo> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdmo.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhby);
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

    public final zzdmr zzauu() {
        zzdmr zzel = zzdmr.zzel(this.zzhbv);
        return zzel == null ? zzdmr.UNRECOGNIZED : zzel;
    }

    public final zzdmt zzauv() {
        zzdmt zzem = zzdmt.zzem(this.zzhbw);
        return zzem == null ? zzdmt.UNRECOGNIZED : zzem;
    }

    public final zzdqk zzauw() {
        return this.zzhbx;
    }
}
