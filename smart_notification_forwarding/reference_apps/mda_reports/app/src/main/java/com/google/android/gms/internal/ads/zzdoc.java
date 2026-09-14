package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdoc extends zzdrt<zzdoc, zza> implements zzdtg {
    private static volatile zzdtn<zzdoc> zzdz;
    private static final zzdoc zzheu;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdoc, zza> implements zzdtg {
        private zza() {
            super(zzdoc.zzheu);
        }

        /* synthetic */ zza(zzdob zzdobVar) {
            this();
        }
    }

    static {
        zzdoc zzdocVar = new zzdoc();
        zzheu = zzdocVar;
        zzdrt.a((Class<zzdoc>) zzdoc.class, zzdocVar);
    }

    private zzdoc() {
    }

    public static zzdoc zzbd(zzdqk zzdqkVar) {
        return (zzdoc) zzdrt.a(zzheu, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdob zzdobVar = null;
        switch (zzdob.a[i - 1]) {
            case 1:
                return new zzdoc();
            case 2:
                return new zza(zzdobVar);
            case 3:
                return zzdrt.a(zzheu, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzheu;
            case 5:
                zzdtn<zzdoc> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdoc.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzheu);
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
