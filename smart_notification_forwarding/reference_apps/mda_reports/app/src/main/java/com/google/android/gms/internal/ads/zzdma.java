package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdma extends zzdrt<zzdma, zza> implements zzdtg {
    private static volatile zzdtn<zzdma> zzdz;
    private static final zzdma zzhbb;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdma, zza> implements zzdtg {
        private zza() {
            super(zzdma.zzhbb);
        }

        /* synthetic */ zza(zzdmb zzdmbVar) {
            this();
        }
    }

    static {
        zzdma zzdmaVar = new zzdma();
        zzhbb = zzdmaVar;
        zzdrt.a((Class<zzdma>) zzdma.class, zzdmaVar);
    }

    private zzdma() {
    }

    public static zzdma zzai(zzdqk zzdqkVar) {
        return (zzdma) zzdrt.a(zzhbb, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdmb zzdmbVar = null;
        switch (zzdmb.a[i - 1]) {
            case 1:
                return new zzdma();
            case 2:
                return new zza(zzdmbVar);
            case 3:
                return zzdrt.a(zzhbb, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzhbb;
            case 5:
                zzdtn<zzdma> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdma.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhbb);
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
}
