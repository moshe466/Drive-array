package com.google.android.gms.common;

import java.util.Arrays;

/* loaded from: classes.dex */
final class o extends n {

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f5109b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f5109b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.n
    public final byte[] z() {
        return this.f5109b;
    }
}
