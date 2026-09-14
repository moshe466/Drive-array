package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public abstract class zzajp implements Serializable, Iterable<Byte> {
    public static final zzajp zza = new zzajw(zzalb.zzb);
    private static final zzajs zzb = new zzajz();
    private int zzc = 0;

    static {
        new zzajr();
    }

    public static /* synthetic */ int zza(byte b4) {
        return b4 & ForkServer.ERROR;
    }

    public static zzajp zzb(byte[] bArr) {
        return new zzajw(bArr);
    }

    public static zzaju zzc(int i) {
        return new zzaju(i);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzb2 = zzb();
            i = zzb(zzb2, 0, zzb2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzajo(this);
    }

    public final String toString() {
        String n4;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int zzb2 = zzb();
        if (zzb() <= 50) {
            n4 = zzanh.zza(this);
        } else {
            n4 = AbstractC0008a.n(zzanh.zza(zza(0, 47)), "...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(zzb2);
        sb.append(" contents=\"");
        return AbstractC0008a.u(sb, n4, "\">");
    }

    public abstract byte zza(int i);

    public abstract zzajp zza(int i, int i3);

    public abstract void zza(zzajm zzajmVar);

    public abstract void zza(byte[] bArr, int i, int i3, int i4);

    public abstract byte zzb(int i);

    public abstract int zzb();

    public abstract int zzb(int i, int i3, int i4);

    public abstract zzakb zzc();

    public final byte[] zzd() {
        int zzb2 = zzb();
        if (zzb2 == 0) {
            return zzalb.zzb;
        }
        byte[] bArr = new byte[zzb2];
        zza(bArr, 0, 0, zzb2);
        return bArr;
    }

    public static int zza(int i, int i3, int i4) {
        int i5 = i3 - i;
        if ((i | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(AbstractC0008a.j(i, "Beginning index: ", " < 0"));
        }
        if (i3 < i) {
            throw new IndexOutOfBoundsException(AbstractC0008a.k("Beginning index larger than ending index: ", i, i3, ", "));
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("End index: ", i3, i4, " >= "));
    }

    public final int zza() {
        return this.zzc;
    }

    public static zzajp zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzajp zza(byte[] bArr, int i, int i3) {
        zza(i, i + i3, bArr.length);
        return new zzajw(zzb.zza(bArr, i, i3));
    }

    public static zzajp zza(String str) {
        return new zzajw(str.getBytes(zzalb.zza));
    }
}
