package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class zzaep {
    private zzaep() {
    }

    public static Object zza(String str, Type type) {
        if (type == String.class) {
            try {
                zzagl zzaglVar = (zzagl) new zzagl().zza(str);
                if (zzaglVar.zzb()) {
                    return zzaglVar.zza();
                }
                throw new zzaci("No error message: " + str);
            } catch (Exception e4) {
                throw new zzaci(a.d("Json conversion failed! ", e4.getMessage()), e4);
            }
        }
        if (type == Void.class) {
            return null;
        }
        try {
            try {
                return ((zzaer) ((Class) type).getConstructor(null).newInstance(null)).zza(str);
            } catch (Exception e5) {
                throw new zzaci(a.d("Json conversion failed! ", e5.getMessage()), e5);
            }
        } catch (Exception e6) {
            throw new zzaci("Instantiation of JsonResponse failed! ".concat(String.valueOf(type)), e6);
        }
    }
}
