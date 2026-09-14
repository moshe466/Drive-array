package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdmz extends zzdrt<zzdmz, zza> implements zzdtg {
    private static volatile zzdtn<zzdmz> zzdz;
    private static final zzdmz zzhcr;
    private int zzhah;
    private int zzhcq;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdmz, zza> implements zzdtg {
        private zza() {
            super(zzdmz.zzhcr);
        }

        /* synthetic */ zza(zzdmy zzdmyVar) {
            this();
        }
    }

    static {
        zzdmz zzdmzVar = new zzdmz();
        zzhcr = zzdmzVar;
        zzdrt.a((Class<zzdmz>) zzdmz.class, zzdmzVar);
    }

    private zzdmz() {
    }

    public static zzdmz zzavg() {
        return zzhcr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdmy zzdmyVar = null;
        switch (zzdmy.a[i - 1]) {
            case 1:
                return new zzdmz();
            case 2:
                return new zza(zzdmyVar);
            case 3:
                return zzdrt.a(zzhcr, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzhcq", "zzhah"});
            case 4:
                return zzhcr;
            case 5:
                zzdtn<zzdmz> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdmz.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhcr);
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

    public final int zzasx() {
        return this.zzhah;
    }

    public final zzdmt zzavf() {
        zzdmt zzem = zzdmt.zzem(this.zzhcq);
        return zzem == null ? zzdmt.UNRECOGNIZED : zzem;
    }
}
