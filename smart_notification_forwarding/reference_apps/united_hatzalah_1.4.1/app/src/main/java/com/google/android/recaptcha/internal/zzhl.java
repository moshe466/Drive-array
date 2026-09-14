package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzhl implements zzgx {
    public static final zzhl zza = new zzhl();

    private zzhl() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) {
        if (zzueVarArr.length == 1) {
            zzgdVar.zzc().zze(i, zzgdVar.zzc().zza(zzueVarArr[0]));
            return;
        }
        throw new zzce(4, 3, null);
    }
}
