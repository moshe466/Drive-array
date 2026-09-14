package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.InputStream;

@VisibleForTesting
/* loaded from: classes.dex */
final class zzaq extends FilterInputStream {
    private final long zzce;
    private long zzcf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(InputStream inputStream, long j) {
        super(inputStream);
        this.zzce = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a() {
        return this.zzce - this.zzcf;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int read = super.read();
        if (read != -1) {
            this.zzcf++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.zzcf += read;
        }
        return read;
    }
}
