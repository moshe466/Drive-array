package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class zzle implements Iterable, Serializable {
    public static final zzle zzb = new zzlc(zznl.zzb);
    private int zza = 0;

    static {
        int i = zzks.zza;
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

    public static zzle zzk(byte[] bArr, int i, int i3) {
        zzi(i, i + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new zzlc(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zza;
        if (i == 0) {
            int zzd = zzd();
            i = zzf(zzd, 0, zzd);
            if (i == 0) {
                i = 1;
            }
            this.zza = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzkx(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int zzd = zzd();
        if (zzd() <= 50) {
            concat = zzpg.zza(this);
        } else {
            concat = zzpg.zza(zzg(0, 47)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(zzd);
        sb.append(" contents=\"");
        return AbstractC0008a.u(sb, concat, "\">");
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i, int i3, int i4);

    public abstract int zzf(int i, int i3, int i4);

    public abstract zzle zzg(int i, int i3);

    public abstract void zzh(zzkw zzkwVar);

    public final int zzj() {
        return this.zza;
    }

    public final byte[] zzl() {
        int zzd = zzd();
        if (zzd == 0) {
            return zznl.zzb;
        }
        byte[] bArr = new byte[zzd];
        zze(bArr, 0, 0, zzd);
        return bArr;
    }
}
