package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzdqu extends zzdqr {
    protected final byte[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdqu(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.a = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public byte a(int i) {
        return this.a[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public final int a(int i, int i2, int i3) {
        int d = d() + i2;
        return zzdva.zzb(i, this.a, d, i3 + d);
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    protected final String a(Charset charset) {
        return new String(this.a, d(), size(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public final void a(zzdqh zzdqhVar) {
        zzdqhVar.zzh(this.a, d(), size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzdqr
    final boolean a(zzdqk zzdqkVar, int i, int i2) {
        if (i2 > zzdqkVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int i3 = i + i2;
        if (i3 > zzdqkVar.size()) {
            int size2 = zzdqkVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(zzdqkVar instanceof zzdqu)) {
            return zzdqkVar.zzy(i, i3).equals(zzy(0, i2));
        }
        zzdqu zzdquVar = (zzdqu) zzdqkVar;
        byte[] bArr = this.a;
        byte[] bArr2 = zzdquVar.a;
        int d = d() + i2;
        int d2 = d();
        int d3 = zzdquVar.d() + i;
        while (d2 < d) {
            if (bArr[d2] != bArr2[d3]) {
                return false;
            }
            d2++;
            d3++;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public final int b(int i, int i2, int i3) {
        return zzdrv.a(i, this.a, d() + i2, i3);
    }

    protected int d() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdqk) || size() != ((zzdqk) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzdqu)) {
            return obj.equals(this);
        }
        zzdqu zzdquVar = (zzdqu) obj;
        int c = c();
        int c2 = zzdquVar.c();
        if (c == 0 || c2 == 0 || c == c2) {
            return a(zzdquVar, 0, size());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public int size() {
        return this.a.length;
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public final boolean zzaxu() {
        int d = d();
        return zzdva.zzm(this.a, d, size() + d);
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public final zzdqw zzaxv() {
        return zzdqw.a(this.a, d(), size(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public byte zzfe(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public final zzdqk zzy(int i, int i2) {
        int c = zzdqk.c(i, i2, size());
        return c == 0 ? zzdqk.zzhhx : new zzdqn(this.a, d() + i, c);
    }
}
