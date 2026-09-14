package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdqn extends zzdqu {
    private final int zzhia;
    private final int zzhib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdqn(byte[] bArr, int i, int i2) {
        super(bArr);
        zzdqk.c(i, i + i2, bArr.length);
        this.zzhia = i;
        this.zzhib = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdqu, com.google.android.gms.internal.ads.zzdqk
    public final byte a(int i) {
        return this.a[this.zzhia + i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdqu, com.google.android.gms.internal.ads.zzdqk
    public final void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, d() + i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzdqu
    protected final int d() {
        return this.zzhia;
    }

    @Override // com.google.android.gms.internal.ads.zzdqu, com.google.android.gms.internal.ads.zzdqk
    public final int size() {
        return this.zzhib;
    }

    @Override // com.google.android.gms.internal.ads.zzdqu, com.google.android.gms.internal.ads.zzdqk
    public final byte zzfe(int i) {
        zzdqk.a(i, size());
        return this.a[this.zzhia + i];
    }
}
