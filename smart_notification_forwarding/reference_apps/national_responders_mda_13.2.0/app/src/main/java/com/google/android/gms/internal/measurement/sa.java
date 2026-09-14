package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
abstract class sa {
    abstract int a(int i10, byte[] bArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int b(CharSequence charSequence, byte[] bArr, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String c(byte[] bArr, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(byte[] bArr, int i10, int i11) {
        return a(0, bArr, i10, i11) == 0;
    }
}
