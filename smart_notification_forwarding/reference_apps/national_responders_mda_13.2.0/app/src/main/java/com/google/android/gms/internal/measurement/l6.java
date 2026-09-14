package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l6 {

    /* renamed from: a, reason: collision with root package name */
    private final v6 f5443a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f5444b;

    private l6(int i10) {
        byte[] bArr = new byte[i10];
        this.f5444b = bArr;
        this.f5443a = v6.f(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l6(int i10, g6 g6Var) {
        this(i10);
    }

    public final d6 a() {
        this.f5443a.N();
        return new n6(this.f5444b);
    }

    public final v6 b() {
        return this.f5443a;
    }
}
