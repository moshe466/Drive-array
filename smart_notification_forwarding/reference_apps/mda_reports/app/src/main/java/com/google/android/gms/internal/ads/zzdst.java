package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdst implements zzdtb {
    private zzdtb[] zzhop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdst(zzdtb... zzdtbVarArr) {
        this.zzhop = zzdtbVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzdtb
    public final boolean zze(Class<?> cls) {
        for (zzdtb zzdtbVar : this.zzhop) {
            if (zzdtbVar.zze(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdtb
    public final zzdtc zzf(Class<?> cls) {
        for (zzdtb zzdtbVar : this.zzhop) {
            if (zzdtbVar.zze(cls)) {
                return zzdtbVar.zzf(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
