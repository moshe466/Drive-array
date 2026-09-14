package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class zzbcc implements zzdws {
    private final ByteBuffer zzako;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcc(ByteBuffer byteBuffer) {
        this.zzako = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zzdws, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final long position() {
        return this.zzako.position();
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final int read(ByteBuffer byteBuffer) {
        if (this.zzako.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.zzako.remaining());
        byte[] bArr = new byte[min];
        this.zzako.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final long size() {
        return this.zzako.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final void zzfc(long j) {
        this.zzako.position((int) j);
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final ByteBuffer zzh(long j, long j2) {
        int position = this.zzako.position();
        this.zzako.position((int) j);
        ByteBuffer slice = this.zzako.slice();
        slice.limit((int) j2);
        this.zzako.position(position);
        return slice;
    }
}
