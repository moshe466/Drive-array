package com.google.android.recaptcha.internal;

import java.util.Objects;

/* loaded from: classes.dex */
public final class zzgm implements zzgx {
    public static final zzgm zza = new zzgm();

    private zzgm() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) {
        boolean z3 = true;
        if (zzueVarArr.length == 1) {
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != Objects.nonNull(zza2)) {
                zza2 = null;
            }
            if (zza2 != null) {
                try {
                    try {
                        if (zza2 instanceof String) {
                            zza2 = zzgdVar.zzh().zza((String) zza2);
                        }
                        zzge zzc = zzgdVar.zzc();
                        try {
                            zzgc.zza(zza2);
                        } catch (zzce e4) {
                            if (e4.zzb() == 8 || e4.zzb() == 6) {
                                z3 = false;
                            } else if (e4.zzb() != 47) {
                                throw e4;
                            }
                        }
                        zzc.zze(i, Boolean.valueOf(z3));
                        return;
                    } catch (zzce e5) {
                        throw e5;
                    }
                } catch (Exception e6) {
                    throw new zzce(6, 8, e6);
                }
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 3, null);
    }
}
