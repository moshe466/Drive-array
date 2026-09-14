package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzee extends zzef {
    protected final byte[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzee(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.a = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    protected final int a(int i, int i2, int i3) {
        return zzff.a(i, this.a, b(), i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    protected final String a(Charset charset) {
        return new String(this.a, b(), zza(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void a(zzdv zzdvVar) {
        zzdvVar.zza(this.a, b(), zza());
    }

    final boolean a(zzdu zzduVar, int i, int i2) {
        if (i2 > zzduVar.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzduVar.zza()) {
            int zza2 = zzduVar.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(zza2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(zzduVar instanceof zzee)) {
            return zzduVar.zza(0, i2).equals(zza(0, i2));
        }
        zzee zzeeVar = (zzee) zzduVar;
        byte[] bArr = this.a;
        byte[] bArr2 = zzeeVar.a;
        int b = b() + i2;
        int b2 = b();
        int b3 = zzeeVar.b();
        while (b2 < b) {
            if (bArr[b2] != bArr2[b3]) {
                return false;
            }
            b2++;
            b3++;
        }
        return true;
    }

    protected int b() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdu) || zza() != ((zzdu) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzee)) {
            return obj.equals(this);
        }
        zzee zzeeVar = (zzee) obj;
        int a = a();
        int a2 = zzeeVar.a();
        if (a == 0 || a2 == 0 || a == a2) {
            return a(zzeeVar, 0, zza());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public byte zza(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public int zza() {
        return this.a.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final zzdu zza(int i, int i2) {
        int b = zzdu.b(0, i2, zza());
        return b == 0 ? zzdu.zza : new zzeb(this.a, b(), b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdu
    public byte zzb(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final boolean zzc() {
        int b = b();
        return zzie.zza(this.a, b, zza() + b);
    }
}
