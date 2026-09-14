package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public final class zzdpn {
    private static final ThreadLocal<SecureRandom> zzhgx = new zzdpm();

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom zzaxf() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzey(int i) {
        byte[] bArr = new byte[i];
        zzhgx.get().nextBytes(bArr);
        return bArr;
    }
}
