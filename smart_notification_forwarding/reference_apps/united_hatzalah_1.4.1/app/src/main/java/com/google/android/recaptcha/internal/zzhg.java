package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import t2.AbstractC0705g;

/* loaded from: classes.dex */
public final class zzhg implements zzgx {
    public static final zzhg zza = new zzhg();

    private zzhg() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) {
        int length = zzueVarArr.length;
        if (length != 0) {
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != (zza2 instanceof Method)) {
                zza2 = null;
            }
            Method method = (Method) zza2;
            if (method != null) {
                Object[] zzg = zzgdVar.zzc().zzg(AbstractC0705g.R(zzueVarArr).subList(1, length));
                try {
                    zzgdVar.zzc().zze(i, method.invoke(null, Arrays.copyOf(zzg, zzg.length)));
                    return;
                } catch (Exception e4) {
                    throw new zzce(6, 15, e4);
                }
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 3, null);
    }
}
