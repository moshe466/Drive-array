package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.security.ProviderInstaller;
import java.security.Provider;
import java.util.Iterator;

/* loaded from: classes.dex */
final class zzzg<JcePrimitiveT> implements zzzh<JcePrimitiveT> {
    private final zzzj<JcePrimitiveT> zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzzh
    public final JcePrimitiveT zza(String str) {
        Iterator<Provider> it = zzzd.zza(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL").iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return this.zza.zza(str, it.next());
            } catch (Exception e4) {
                if (exc == null) {
                    exc = e4;
                }
            }
        }
        return this.zza.zza(str, null);
    }

    private zzzg(zzzj<JcePrimitiveT> zzzjVar) {
        this.zza = zzzjVar;
    }
}
