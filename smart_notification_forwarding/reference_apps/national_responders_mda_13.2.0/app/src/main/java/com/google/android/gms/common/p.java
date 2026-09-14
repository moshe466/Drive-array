package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class p extends n {

    /* renamed from: c, reason: collision with root package name */
    private static final WeakReference f5110c = new WeakReference(null);

    /* renamed from: b, reason: collision with root package name */
    private WeakReference f5111b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(byte[] bArr) {
        super(bArr);
        this.f5111b = f5110c;
    }

    protected abstract byte[] x0();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.n
    public final byte[] z() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f5111b.get();
            if (bArr == null) {
                bArr = x0();
                this.f5111b = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
