package com.google.android.recaptcha.internal;

import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public final class zzgt implements zzgx {
    public static final zzgt zza = new zzgt();

    private zzgt() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) {
        int length = zzueVarArr.length;
        Object obj = null;
        if (length != 4 && length != 5) {
            throw new zzce(4, 3, null);
        }
        Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
        if (true != (zza2 instanceof Integer)) {
            zza2 = null;
        }
        Integer num = (Integer) zza2;
        if (num != null) {
            int intValue = num.intValue();
            Object zza3 = zzgdVar.zzc().zza(zzueVarArr[1]);
            if (true != (zza3 instanceof Integer)) {
                zza3 = null;
            }
            Integer num2 = (Integer) zza3;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                Object zza4 = zzgdVar.zzc().zza(zzueVarArr[2]);
                if (true != (zza4 instanceof String)) {
                    zza4 = null;
                }
                String str = (String) zza4;
                if (str != null) {
                    String zza5 = zzgdVar.zzh().zza(str);
                    Object zza6 = zzgdVar.zzc().zza(zzueVarArr[3]);
                    if (true != (zza6 instanceof String)) {
                        zza6 = null;
                    }
                    String str2 = (String) zza6;
                    if (str2 != null) {
                        String zza7 = zzgdVar.zzh().zza(str2);
                        if (length == 5) {
                            obj = zzgdVar.zzc().zza(zzueVarArr[4]);
                        }
                        zzfz zzfzVar = new zzfz(intValue2);
                        try {
                            Class zza8 = zzgc.zza(zza5);
                            zzgdVar.zzc().zze(intValue, Proxy.newProxyInstance(zza8.getClassLoader(), new Class[]{zza8}, new zzga(zzfzVar, zza7, obj)));
                            zzgdVar.zzc().zze(i, zzfzVar);
                            return;
                        } catch (Exception e4) {
                            throw new zzce(6, 20, e4);
                        }
                    }
                    throw new zzce(4, 5, null);
                }
                throw new zzce(4, 5, null);
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 5, null);
    }
}
