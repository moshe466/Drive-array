package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public final class zzdny extends zzdrt<zzdny, zza> implements zzdtg {
    private static volatile zzdtn<zzdny> zzdz;
    private static final zzdny zzhes;
    private String zzheq = "";
    private zzdsb<zzdnh> zzher = zzdrt.d();

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdny, zza> implements zzdtg {
        private zza() {
            super(zzdny.zzhes);
        }

        /* synthetic */ zza(zzdnx zzdnxVar) {
            this();
        }
    }

    static {
        zzdny zzdnyVar = new zzdny();
        zzhes = zzdnyVar;
        zzdrt.a((Class<zzdny>) zzdny.class, zzdnyVar);
    }

    private zzdny() {
    }

    public static zzdny zzawv() {
        return zzhes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdnx zzdnxVar = null;
        switch (zzdnx.a[i - 1]) {
            case 1:
                return new zzdny();
            case 2:
                return new zza(zzdnxVar);
            case 3:
                return zzdrt.a(zzhes, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzheq", "zzher", zzdnh.class});
            case 4:
                return zzhes;
            case 5:
                zzdtn<zzdny> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdny.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhes);
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

    public final List<zzdnh> zzawu() {
        return this.zzher;
    }
}
