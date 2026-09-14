package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes.dex */
public final class zznm implements zznl {
    private final byte[] data;
    private Uri uri;
    private int zzbej;
    private int zzbek;

    public zznm(byte[] bArr) {
        zzoc.checkNotNull(bArr);
        zzoc.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final void close() {
        this.uri = null;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzbek;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.zzbej, bArr, i, min);
        this.zzbej += min;
        this.zzbek -= min;
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final long zza(zznq zznqVar) {
        this.uri = zznqVar.uri;
        long j = zznqVar.zzamw;
        this.zzbej = (int) j;
        long j2 = zznqVar.zzce;
        if (j2 == -1) {
            j2 = this.data.length - j;
        }
        this.zzbek = (int) j2;
        int i = this.zzbek;
        if (i > 0 && this.zzbej + i <= this.data.length) {
            return i;
        }
        int i2 = this.zzbej;
        long j3 = zznqVar.zzce;
        int length = this.data.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i2);
        sb.append(", ");
        sb.append(j3);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }
}
