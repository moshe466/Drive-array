package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zzqo {

    @Nullable
    private static MessageDigest zzbqe;
    protected Object a = new Object();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final MessageDigest a() {
        synchronized (this.a) {
            if (zzbqe != null) {
                return zzbqe;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbqe = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return zzbqe;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] zzbv(String str);
}
