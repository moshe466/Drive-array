package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: classes.dex */
final class zzsl extends PushbackInputStream {
    private final /* synthetic */ zzsg zzbsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzsl(zzsg zzsgVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zzbsa = zzsgVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.zzbsa.a.disconnect();
        super.close();
    }
}
