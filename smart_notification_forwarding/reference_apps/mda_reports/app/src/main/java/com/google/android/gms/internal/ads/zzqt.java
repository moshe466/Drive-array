package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
/* loaded from: classes.dex */
final class zzqt {

    @VisibleForTesting
    private ByteArrayOutputStream zzbqk = new ByteArrayOutputStream(4096);

    @VisibleForTesting
    private Base64OutputStream zzbql = new Base64OutputStream(this.zzbqk, 10);

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        try {
            this.zzbql.close();
        } catch (IOException e) {
            zzayu.zzc("HashManager: Unable to convert to Base64.", e);
        }
        try {
            try {
                this.zzbqk.close();
                str = this.zzbqk.toString();
            } catch (IOException e2) {
                zzayu.zzc("HashManager: Unable to convert to Base64.", e2);
                str = "";
            }
            return str;
        } finally {
            this.zzbqk = null;
            this.zzbql = null;
        }
    }

    public final void write(byte[] bArr) {
        this.zzbql.write(bArr);
    }
}
