package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
final class zzcm implements Runnable {
    private zzcm() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzck.a(MessageDigest.getInstance("MD5"));
        } catch (NoSuchAlgorithmException unused) {
        } catch (Throwable th) {
            zzck.a.countDown();
            throw th;
        }
        zzck.a.countDown();
    }
}
