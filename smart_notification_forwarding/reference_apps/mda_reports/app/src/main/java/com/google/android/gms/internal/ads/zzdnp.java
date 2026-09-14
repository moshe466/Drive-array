package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdnp extends zzdrt<zzdnp, zza> implements zzdtg {
    private static volatile zzdtn<zzdnp> zzdz;
    private static final zzdnp zzhed;
    private String zzhec = "";

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdnp, zza> implements zzdtg {
        private zza() {
            super(zzdnp.zzhed);
        }

        /* synthetic */ zza(zzdnq zzdnqVar) {
            this();
        }
    }

    static {
        zzdnp zzdnpVar = new zzdnp();
        zzhed = zzdnpVar;
        zzdrt.a((Class<zzdnp>) zzdnp.class, zzdnpVar);
    }

    private zzdnp() {
    }

    public static zzdnp zzawl() {
        return zzhed;
    }

    public static zzdnp zzay(zzdqk zzdqkVar) {
        return (zzdnp) zzdrt.a(zzhed, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdnq zzdnqVar = null;
        switch (zzdnq.a[i - 1]) {
            case 1:
                return new zzdnp();
            case 2:
                return new zza(zzdnqVar);
            case 3:
                return zzdrt.a(zzhed, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzhec"});
            case 4:
                return zzhed;
            case 5:
                zzdtn<zzdnp> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdnp.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhed);
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

    public final String zzawk() {
        return this.zzhec;
    }
}
