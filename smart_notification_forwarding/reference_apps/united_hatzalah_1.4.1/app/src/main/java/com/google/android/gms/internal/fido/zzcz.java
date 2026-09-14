package com.google.android.gms.internal.fido;

import F0.AbstractC0008a;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class zzcz implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzcz zzb = new zzcw(zzde.zzd);
    private static final zzcy zzd;
    private int zzc = 0;

    static {
        int i = zzcp.zza;
        zzd = new zzcy(null);
        zza = new zzcr();
    }

    public static int zzj(int i, int i3, int i4) {
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

    public static zzcz zzl(byte[] bArr, int i, int i3) {
        zzj(0, i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return new zzcw(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzd2 = zzd();
            i = zzf(zzd2, 0, zzd2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzcq(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int zzd2 = zzd();
        if (zzd() <= 50) {
            concat = zzdg.zza(this);
        } else {
            concat = zzdg.zza(zzg(0, 47)).concat("...");
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

    public abstract void zze(byte[] bArr, int i, int i3, int i4);

    public abstract int zzf(int i, int i3, int i4);

    public abstract zzcz zzg(int i, int i3);

    public abstract InputStream zzh();

    public abstract ByteBuffer zzi();

    public final int zzk() {
        return this.zzc;
    }

    public final byte[] zzm() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzde.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }
}
