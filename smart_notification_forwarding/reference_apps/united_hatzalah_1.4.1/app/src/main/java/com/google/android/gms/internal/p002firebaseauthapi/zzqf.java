package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.SecureRandom;

/* loaded from: classes.dex */
final class zzqf extends ThreadLocal<SecureRandom> {
    @Override // java.lang.ThreadLocal
    public final /* synthetic */ SecureRandom initialValue() {
        return zzqg.zza();
    }
}
