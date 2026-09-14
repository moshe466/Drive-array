package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdmj extends zzdrt<zzdmj, zza> implements zzdtg {
    private static volatile zzdtn<zzdmj> zzdz;
    private static final zzdmj zzhbp;
    private zzdmo zzhbm;
    private zzdmf zzhbn;
    private int zzhbo;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdmj, zza> implements zzdtg {
        private zza() {
            super(zzdmj.zzhbp);
        }

        /* synthetic */ zza(zzdmi zzdmiVar) {
            this();
        }
    }

    static {
        zzdmj zzdmjVar = new zzdmj();
        zzhbp = zzdmjVar;
        zzdrt.a((Class<zzdmj>) zzdmj.class, zzdmjVar);
    }

    private zzdmj() {
    }

    public static zzdmj zzauk() {
        return zzhbp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdmi zzdmiVar = null;
        switch (zzdmi.a[i - 1]) {
            case 1:
                return new zzdmj();
            case 2:
                return new zza(zzdmiVar);
            case 3:
                return zzdrt.a(zzhbp, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzhbm", "zzhbn", "zzhbo"});
            case 4:
                return zzhbp;
            case 5:
                zzdtn<zzdmj> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdmj.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhbp);
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

    public final zzdmo zzauh() {
        zzdmo zzdmoVar = this.zzhbm;
        return zzdmoVar == null ? zzdmo.zzaux() : zzdmoVar;
    }

    public final zzdmf zzaui() {
        zzdmf zzdmfVar = this.zzhbn;
        return zzdmfVar == null ? zzdmf.zzaud() : zzdmfVar;
    }

    public final zzdmd zzauj() {
        zzdmd zzei = zzdmd.zzei(this.zzhbo);
        return zzei == null ? zzdmd.UNRECOGNIZED : zzei;
    }
}
