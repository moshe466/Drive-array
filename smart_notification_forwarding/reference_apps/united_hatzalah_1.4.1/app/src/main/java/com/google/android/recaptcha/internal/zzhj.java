package com.google.android.recaptcha.internal;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Objects;
import t2.AbstractC0705g;

/* loaded from: classes.dex */
public final class zzhj implements zzgx {
    public static final zzhj zza = new zzhj();

    private zzhj() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) {
        Constructor<?> constructor;
        int length = zzueVarArr.length;
        if (length != 0) {
            Constructor<?> zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != Objects.nonNull(zza2)) {
                zza2 = null;
            }
            if (zza2 != null) {
                if (zza2 instanceof Constructor) {
                    constructor = zza2;
                } else {
                    constructor = zza2.getClass().getConstructor(null);
                }
                Object[] zzg = zzgdVar.zzc().zzg(AbstractC0705g.R(zzueVarArr).subList(1, length));
                try {
                    zzgdVar.zzc().zze(i, constructor.newInstance(Arrays.copyOf(zzg, zzg.length)));
                    return;
                } catch (Exception e4) {
                    throw new zzce(6, 14, e4);
                }
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 3, null);
    }
}
