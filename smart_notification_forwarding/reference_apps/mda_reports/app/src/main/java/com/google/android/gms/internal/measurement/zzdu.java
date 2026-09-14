package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class zzdu implements Serializable, Iterable<Byte> {
    public static final zzdu zza = new zzee(zzff.zzb);
    private static final zzea zzb;
    private static final Comparator<zzdu> zzd;
    private int zzc = 0;

    static {
        zzdx zzdxVar = null;
        zzb = zzdr.a() ? new zzeh(zzdxVar) : new zzdy(zzdxVar);
        zzd = new zzdw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdu a(byte[] bArr) {
        return new zzee(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public static zzdu zza(String str) {
        return new zzee(str.getBytes(zzff.a));
    }

    public static zzdu zza(byte[] bArr, int i, int i2) {
        b(i, i + i2, bArr.length);
        return new zzee(zzb.zza(bArr, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzec zzc(int i) {
        return new zzec(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a() {
        return this.zzc;
    }

    protected abstract int a(int i, int i2, int i3);

    protected abstract String a(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(zzdv zzdvVar);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zza2 = zza();
            i = a(zza2, 0, zza2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzdx(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zza());
        objArr[2] = zza() <= 50 ? zzhr.a(this) : String.valueOf(zzhr.a(zza(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    public abstract int zza();

    public abstract zzdu zza(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public final String zzb() {
        return zza() == 0 ? "" : a(zzff.a);
    }

    public abstract boolean zzc();
}
