package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class zzdqk implements Serializable, Iterable<Byte> {
    public static final zzdqk zzhhx = new zzdqu(zzdrv.zzhng);
    private static final zzdqq zzhhy;
    private static final Comparator<zzdqk> zzhhz;
    private int zzhhd = 0;

    static {
        zzdqj zzdqjVar = null;
        zzhhy = zzdqd.a() ? new zzdqt(zzdqjVar) : new zzdqo(zzdqjVar);
        zzhhz = new zzdqm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdqk a(byte[] bArr) {
        return new zzdqu(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdqs b(int i) {
        return new zzdqs(i, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, int i2, int i3) {
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

    private static zzdqk zza(Iterator<zzdqk> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        zzdqk zza = zza(it, i2);
        zzdqk zza2 = zza(it, i - i2);
        if (Integer.MAX_VALUE - zza.size() >= zza2.size()) {
            return zzdtt.a(zza, zza2);
        }
        int size = zza.size();
        int size2 = zza2.size();
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & 255;
    }

    public static zzdqk zzf(InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            zzdqk zzi = i2 == 0 ? null : zzi(bArr, 0, i2);
            if (zzi == null) {
                break;
            }
            arrayList.add(zzi);
            i = Math.min(i << 1, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? zzhhx : zza(arrayList.iterator(), size);
    }

    public static zzdqk zzhf(String str) {
        return new zzdqu(str.getBytes(zzdrv.a));
    }

    public static zzdqk zzi(byte[] bArr, int i, int i2) {
        c(i, i + i2, bArr.length);
        return new zzdqu(zzhhy.zzj(bArr, i, i2));
    }

    public static zzdqk zzu(byte[] bArr) {
        return zzi(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int a(int i, int i2, int i3);

    protected abstract String a(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(zzdqh zzdqhVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(byte[] bArr, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int b(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int c() {
        return this.zzhhd;
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzhhd;
        if (i == 0) {
            int size = size();
            i = b(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzhhd = i;
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzdrv.zzhng;
        }
        byte[] bArr = new byte[size];
        a(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? zzduo.a(this) : String.valueOf(zzduo.a(zzy(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    @Deprecated
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        c(i, i + i3, size());
        c(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            a(bArr, i, i2, i3);
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: zzaxs, reason: merged with bridge method [inline-methods] */
    public zzdqp iterator() {
        return new zzdqj(this);
    }

    public final String zzaxt() {
        return size() == 0 ? "" : a(zzdrv.a);
    }

    public abstract boolean zzaxu();

    public abstract zzdqw zzaxv();

    public abstract byte zzfe(int i);

    public abstract zzdqk zzy(int i, int i2);
}
