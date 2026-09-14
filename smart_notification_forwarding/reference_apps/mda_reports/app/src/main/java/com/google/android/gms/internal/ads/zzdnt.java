package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdnt extends zzdrt<zzdnt, zza> implements zzdtg {
    private static volatile zzdtn<zzdnt> zzdz;
    private static final zzdnt zzhei;
    private String zzheg = "";
    private zzdng zzheh;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdnt, zza> implements zzdtg {
        private zza() {
            super(zzdnt.zzhei);
        }

        /* synthetic */ zza(zzdnu zzdnuVar) {
            this();
        }
    }

    static {
        zzdnt zzdntVar = new zzdnt();
        zzhei = zzdntVar;
        zzdrt.a((Class<zzdnt>) zzdnt.class, zzdntVar);
    }

    private zzdnt() {
    }

    public static zzdnt zzaws() {
        return zzhei;
    }

    public static zzdnt zzba(zzdqk zzdqkVar) {
        return (zzdnt) zzdrt.a(zzhei, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdnu zzdnuVar = null;
        switch (zzdnu.a[i - 1]) {
            case 1:
                return new zzdnt();
            case 2:
                return new zza(zzdnuVar);
            case 3:
                return zzdrt.a(zzhei, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzheg", "zzheh"});
            case 4:
                return zzhei;
            case 5:
                zzdtn<zzdnt> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdnt.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhei);
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

    public final String zzawq() {
        return this.zzheg;
    }

    public final zzdng zzawr() {
        zzdng zzdngVar = this.zzheh;
        return zzdngVar == null ? zzdng.zzavo() : zzdngVar;
    }
}
