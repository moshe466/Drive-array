package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m9 implements w8 {

    /* renamed from: a, reason: collision with root package name */
    private final y8 f5476a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5477b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f5478c;

    /* renamed from: d, reason: collision with root package name */
    private final int f5479d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m9(y8 y8Var, String str, Object[] objArr) {
        this.f5476a = y8Var;
        this.f5477b = str;
        this.f5478c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f5479d = charAt;
            return;
        }
        int i10 = charAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char charAt2 = str.charAt(i12);
            if (charAt2 < 55296) {
                this.f5479d = i10 | (charAt2 << i11);
                return;
            } else {
                i10 |= (charAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean a() {
        return (this.f5479d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final y8 b() {
        return this.f5476a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        return this.f5477b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] d() {
        return this.f5478c;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int zza() {
        return (this.f5479d & 1) == 1 ? i9.f5388a : i9.f5389b;
    }
}
