package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
final class zzdru implements zzdtb {
    private static final zzdru zzhmn = new zzdru();

    private zzdru() {
    }

    public static zzdru zzbaa() {
        return zzhmn;
    }

    @Override // com.google.android.gms.internal.ads.zzdtb
    public final boolean zze(Class<?> cls) {
        return zzdrt.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzdtb
    public final zzdtc zzf(Class<?> cls) {
        if (!zzdrt.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzdtc) zzdrt.a(cls.asSubclass(zzdrt.class)).a(zzdrt.zze.zzhmu, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
