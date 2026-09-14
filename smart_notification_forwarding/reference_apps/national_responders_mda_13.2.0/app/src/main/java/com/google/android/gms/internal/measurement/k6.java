package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class k6 extends n6 {

    /* renamed from: j, reason: collision with root package name */
    private final int f5424j;

    /* renamed from: k, reason: collision with root package name */
    private final int f5425k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k6(byte[] bArr, int i10, int i11) {
        super(bArr);
        d6.y(i10, i10 + i11, bArr.length);
        this.f5424j = i10;
        this.f5425k = i11;
    }

    @Override // com.google.android.gms.internal.measurement.n6
    protected final int E() {
        return this.f5424j;
    }

    @Override // com.google.android.gms.internal.measurement.n6, com.google.android.gms.internal.measurement.d6
    public final byte c(int i10) {
        int f10 = f();
        if (((f10 - (i10 + 1)) | i10) >= 0) {
            return this.f5492i[this.f5424j + i10];
        }
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append("Index < 0: ");
            sb2.append(i10);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(40);
        sb3.append("Index > length: ");
        sb3.append(i10);
        sb3.append(", ");
        sb3.append(f10);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }

    @Override // com.google.android.gms.internal.measurement.n6, com.google.android.gms.internal.measurement.d6
    public final int f() {
        return this.f5425k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.n6, com.google.android.gms.internal.measurement.d6
    public final byte w(int i10) {
        return this.f5492i[this.f5424j + i10];
    }
}
