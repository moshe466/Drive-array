package androidx.datastore.preferences.protobuf;

import F0.AbstractC0008a;

/* renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0239f extends C0240g {

    /* renamed from: e, reason: collision with root package name */
    public final int f3164e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3165f;

    public C0239f(byte[] bArr, int i, int i3) {
        super(bArr);
        C0240g.h(i, i + i3, bArr.length);
        this.f3164e = i;
        this.f3165f = i3;
    }

    @Override // androidx.datastore.preferences.protobuf.C0240g
    public final byte g(int i) {
        int i3 = this.f3165f;
        if (((i3 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(e0.a.c(i, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(AbstractC0008a.k("Index > length: ", i, i3, ", "));
        }
        return this.f3176b[this.f3164e + i];
    }

    @Override // androidx.datastore.preferences.protobuf.C0240g
    public final void j(byte[] bArr, int i) {
        System.arraycopy(this.f3176b, this.f3164e, bArr, 0, i);
    }

    @Override // androidx.datastore.preferences.protobuf.C0240g
    public final int k() {
        return this.f3164e;
    }

    @Override // androidx.datastore.preferences.protobuf.C0240g
    public final byte l(int i) {
        return this.f3176b[this.f3164e + i];
    }

    @Override // androidx.datastore.preferences.protobuf.C0240g
    public final int size() {
        return this.f3165f;
    }
}
