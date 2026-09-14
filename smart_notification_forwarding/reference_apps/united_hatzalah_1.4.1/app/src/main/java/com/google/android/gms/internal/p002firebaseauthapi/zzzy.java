package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzzy extends ThreadLocal<Mac> {
    private final /* synthetic */ zzzv zza;

    public zzzy(zzzv zzzvVar) {
        this.zza = zzzvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.ThreadLocal
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        String str;
        Key key;
        try {
            zzzd<zzzq, Mac> zzzdVar = zzzd.zzb;
            str = this.zza.zzc;
            Mac zza = zzzdVar.zza(str);
            key = this.zza.zzd;
            zza.init(key);
            return zza;
        } catch (GeneralSecurityException e4) {
            throw new IllegalStateException(e4);
        }
    }
}
