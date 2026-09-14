package com.google.android.recaptcha.internal;

import T.b;

/* loaded from: classes.dex */
public final class zzgc {
    public static final Class zza(Object obj) {
        Class cls;
        if (obj instanceof Class) {
            return (Class) obj;
        }
        if (obj instanceof Integer) {
            int intValue = ((Number) obj).intValue();
            if (intValue == 1) {
                cls = Integer.TYPE;
            } else if (intValue == 2) {
                cls = Short.TYPE;
            } else if (intValue == 3) {
                cls = Byte.TYPE;
            } else if (intValue == 4) {
                cls = Long.TYPE;
            } else if (intValue == 5) {
                cls = Character.TYPE;
            } else if (intValue == 6) {
                cls = Float.TYPE;
            } else if (intValue == 7) {
                cls = Double.TYPE;
            } else if (intValue == 8) {
                cls = Boolean.TYPE;
            } else {
                cls = null;
            }
            if (cls != null) {
                return cls;
            }
            throw new zzce(4, 6, null);
        }
        if (obj instanceof String) {
            try {
                String str = (String) obj;
                Class<?> cls2 = Class.forName(str);
                int i = zzav.zza;
                if (((zzfu) b.A(zzgb.zza).a()).zzb(str)) {
                    return cls2;
                }
                throw new zzce(6, 47, null);
            } catch (Exception e4) {
                throw new zzce(6, 8, e4);
            }
        }
        throw new zzce(4, 5, null);
    }
}
