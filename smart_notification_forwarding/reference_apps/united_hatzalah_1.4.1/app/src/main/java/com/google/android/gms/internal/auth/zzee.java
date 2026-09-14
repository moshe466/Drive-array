package com.google.android.gms.internal.auth;

import F0.AbstractC0008a;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class zzee implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzee zzb = new zzeb(zzez.zzd);
    private static final zzed zzd;
    private int zzc = 0;

    static {
        int i = zzdr.zza;
        zzd = new zzed(null);
        zza = new zzdw();
    }

    public static int zzi(int i, int i3, int i4) {
        int i5 = i3 - i;
        if ((i | i3 | i5 | (i4 - i3)) < 0) {
            if (i >= 0) {
                if (i3 < i) {
                    throw new IndexOutOfBoundsException(AbstractC0008a.k("Beginning index larger than ending index: ", i, i3, ", "));
                }
                throw new IndexOutOfBoundsException(AbstractC0008a.k("End index: ", i3, i4, " >= "));
            }
            throw new IndexOutOfBoundsException(AbstractC0008a.j(i, "Beginning index: ", " < 0"));
        }
        return i5;
    }

    public static zzee zzk(byte[] bArr, int i, int i3) {
        zzi(i, i + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new zzeb(bArr2);
    }

    public static zzee zzl(String str) {
        return new zzeb(str.getBytes(zzez.zzb));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzd2 = zzd();
            i = zze(zzd2, 0, zzd2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzdv(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int zzd2 = zzd();
        if (zzd() <= 50) {
            concat = zzgw.zza(this);
        } else {
            concat = zzgw.zza(zzf(0, 47)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(zzd2);
        sb.append(" contents=\"");
        return AbstractC0008a.u(sb, concat, "\">");
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzd();

    public abstract int zze(int i, int i3, int i4);

    public abstract zzee zzf(int i, int i3);

    public abstract String zzg(Charset charset);

    public abstract boolean zzh();

    public final int zzj() {
        return this.zzc;
    }

    public final String zzm(Charset charset) {
        if (zzd() == 0) {
            return "";
        }
        return zzg(charset);
    }
}
