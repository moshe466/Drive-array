package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlc extends zzdrt<zzdlc, zza> implements zzdtg {
    private static volatile zzdtn<zzdlc> zzdz;
    private static final zzdlc zzhai;
    private int zzhah;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlc, zza> implements zzdtg {
        private zza() {
            super(zzdlc.zzhai);
        }

        /* synthetic */ zza(zzdld zzdldVar) {
            this();
        }
    }

    static {
        zzdlc zzdlcVar = new zzdlc();
        zzhai = zzdlcVar;
        zzdrt.a((Class<zzdlc>) zzdlc.class, zzdlcVar);
    }

    private zzdlc() {
    }

    public static zzdlc zzasy() {
        return zzhai;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdld zzdldVar = null;
        switch (zzdld.a[i - 1]) {
            case 1:
                return new zzdlc();
            case 2:
                return new zza(zzdldVar);
            case 3:
                return zzdrt.a(zzhai, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhah"});
            case 4:
                return zzhai;
            case 5:
                zzdtn<zzdlc> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlc.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhai);
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
}
