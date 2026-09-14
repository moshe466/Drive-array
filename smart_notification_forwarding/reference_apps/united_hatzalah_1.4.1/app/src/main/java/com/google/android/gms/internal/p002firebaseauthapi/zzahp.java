package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import e0.a;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* loaded from: classes.dex */
public final class zzahp {
    public static long zza(String str) {
        zzaho zzb = zzb(str);
        return zzb.zza().longValue() - zzb.zzb().longValue();
    }

    private static zzaho zzb(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> zza = zzv.zza('.').zza((CharSequence) str);
        if (zza.size() >= 2) {
            try {
                return zzaho.zza(new String(Base64Utils.decodeUrlSafeNoPadding(zza.get(1)), "UTF-8"));
            } catch (UnsupportedEncodingException e4) {
                throw new RuntimeException("Unable to decode token", e4);
            }
        }
        throw new RuntimeException(a.d("Invalid idToken ", str));
    }
}
