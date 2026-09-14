package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class zzg extends zze {
    private static final WeakReference<byte[]> zzw = new WeakReference<>(null);
    private WeakReference<byte[]> zzv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(byte[] bArr) {
        super(bArr);
        this.zzv = zzw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.zze
    public final byte[] c() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zzv.get();
            if (bArr == null) {
                bArr = d();
                this.zzv = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] d();
}
