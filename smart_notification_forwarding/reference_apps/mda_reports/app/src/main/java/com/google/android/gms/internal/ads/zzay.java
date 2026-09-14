package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public final class zzay extends ByteArrayOutputStream {
    private final zzaj zzbw;

    public zzay(zzaj zzajVar, int i) {
        this.zzbw = zzajVar;
        ((ByteArrayOutputStream) this).buf = this.zzbw.zzc(Math.max(i, 256));
    }

    private final void zzd(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] zzc = this.zzbw.zzc((i2 + i) << 1);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, zzc, 0, ((ByteArrayOutputStream) this).count);
        this.zzbw.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = zzc;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zzbw.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.zzbw.zza(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        zzd(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzd(i2);
        super.write(bArr, i, i2);
    }
}
