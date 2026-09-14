package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s6 extends q6 {

    /* renamed from: a, reason: collision with root package name */
    private int f5587a;

    /* renamed from: b, reason: collision with root package name */
    private int f5588b;

    /* renamed from: c, reason: collision with root package name */
    private int f5589c;

    /* renamed from: d, reason: collision with root package name */
    private int f5590d;

    /* renamed from: e, reason: collision with root package name */
    private int f5591e;

    private s6(byte[] bArr, int i10, int i11, boolean z10) {
        super();
        this.f5591e = Integer.MAX_VALUE;
        this.f5587a = i11 + i10;
        this.f5589c = i10;
        this.f5590d = i10;
    }

    private final void f() {
        int i10 = this.f5587a + this.f5588b;
        this.f5587a = i10;
        int i11 = i10 - this.f5590d;
        int i12 = this.f5591e;
        if (i11 <= i12) {
            this.f5588b = 0;
            return;
        }
        int i13 = i11 - i12;
        this.f5588b = i13;
        this.f5587a = i10 - i13;
    }

    @Override // com.google.android.gms.internal.measurement.q6
    public final int c(int i10) {
        if (i10 < 0) {
            throw x7.b();
        }
        int e10 = i10 + e();
        int i11 = this.f5591e;
        if (e10 > i11) {
            throw x7.a();
        }
        this.f5591e = e10;
        f();
        return i11;
    }

    @Override // com.google.android.gms.internal.measurement.q6
    public final int e() {
        return this.f5589c - this.f5590d;
    }
}
