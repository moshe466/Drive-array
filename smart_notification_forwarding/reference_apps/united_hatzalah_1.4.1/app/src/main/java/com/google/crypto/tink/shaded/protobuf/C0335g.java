package com.google.crypto.tink.shaded.protobuf;

import F0.AbstractC0008a;

/* renamed from: com.google.crypto.tink.shaded.protobuf.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0335g extends C0336h {

    /* renamed from: e, reason: collision with root package name */
    public final int f4102e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4103f;

    public C0335g(byte[] bArr, int i, int i3) {
        super(bArr);
        AbstractC0337i.h(i, i + i3, bArr.length);
        this.f4102e = i;
        this.f4103f = i3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0336h, com.google.crypto.tink.shaded.protobuf.AbstractC0337i
    public final byte g(int i) {
        int i3 = this.f4103f;
        if (((i3 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(e0.a.c(i, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(AbstractC0008a.k("Index > length: ", i, i3, ", "));
        }
        return this.f4105d[this.f4102e + i];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0336h, com.google.crypto.tink.shaded.protobuf.AbstractC0337i
    public final void j(byte[] bArr, int i) {
        System.arraycopy(this.f4105d, this.f4102e, bArr, 0, i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0336h
    public final int l() {
        return this.f4102e;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0336h
    public final byte m(int i) {
        return this.f4105d[this.f4102e + i];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0336h, com.google.crypto.tink.shaded.protobuf.AbstractC0337i
    public final int size() {
        return this.f4103f;
    }
}
