package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zznq {
    public final int flags;
    public final Uri uri;
    public final long zzamw;
    public final byte[] zzbet;
    public final long zzbeu;
    public final String zzcc;
    public final long zzce;

    public zznq(Uri uri) {
        this(uri, 0);
    }

    private zznq(Uri uri, int i) {
        this(uri, 0L, -1L, null, 0);
    }

    private zznq(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public zznq(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    private zznq(Uri uri, long j, long j2, String str, int i) {
        this(uri, 0L, 0L, -1L, null, 0);
    }

    public zznq(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzoc.checkArgument(j >= 0);
        zzoc.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zzoc.checkArgument(z);
        this.uri = uri;
        this.zzbet = bArr;
        this.zzbeu = j;
        this.zzamw = j2;
        this.zzce = j3;
        this.zzcc = str;
        this.flags = i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.uri);
        String arrays = Arrays.toString(this.zzbet);
        long j = this.zzbeu;
        long j2 = this.zzamw;
        long j3 = this.zzce;
        String str = this.zzcc;
        int i = this.flags;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 93 + String.valueOf(arrays).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(arrays);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zzbb(int i) {
        return (this.flags & 1) == 1;
    }
}
