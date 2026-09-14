package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzhm implements zzgx {
    public static final zzhm zza = new zzhm();

    private zzhm() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) {
        if (zzueVarArr.length == 1) {
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str != null) {
                zzgdVar.zzf(str);
                return;
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 3, null);
    }
}
