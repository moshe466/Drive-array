package com.google.android.gms.internal.ads;

import android.net.Uri;

/* loaded from: classes.dex */
final class zzbcd implements zznl {
    private Uri uri;
    private final zznl zzecs;
    private final long zzect;
    private final zznl zzecu;
    private long zzecv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcd(zznl zznlVar, int i, zznl zznlVar2) {
        this.zzecs = zznlVar;
        this.zzect = i;
        this.zzecu = zznlVar2;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final void close() {
        this.zzecs.close();
        this.zzecu.close();
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final int read(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.zzecv;
        long j2 = this.zzect;
        if (j < j2) {
            i3 = this.zzecs.read(bArr, i, (int) Math.min(i2, j2 - j));
            this.zzecv += i3;
        } else {
            i3 = 0;
        }
        if (this.zzecv < this.zzect) {
            return i3;
        }
        int read = this.zzecu.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.zzecv += read;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final long zza(zznq zznqVar) {
        zznq zznqVar2;
        zznq zznqVar3;
        this.uri = zznqVar.uri;
        long j = zznqVar.zzamw;
        long j2 = this.zzect;
        if (j >= j2) {
            zznqVar2 = null;
        } else {
            long j3 = zznqVar.zzce;
            long j4 = j2 - j;
            if (j3 != -1) {
                j4 = Math.min(j3, j4);
            }
            zznqVar2 = new zznq(zznqVar.uri, j, j4, null);
        }
        long j5 = zznqVar.zzce;
        if (j5 == -1 || zznqVar.zzamw + j5 > this.zzect) {
            long max = Math.max(this.zzect, zznqVar.zzamw);
            long j6 = zznqVar.zzce;
            zznqVar3 = new zznq(zznqVar.uri, max, j6 != -1 ? Math.min(j6, (zznqVar.zzamw + j6) - this.zzect) : -1L, null);
        } else {
            zznqVar3 = null;
        }
        long zza = zznqVar2 != null ? this.zzecs.zza(zznqVar2) : 0L;
        long zza2 = zznqVar3 != null ? this.zzecu.zza(zznqVar3) : 0L;
        this.zzecv = zznqVar.zzamw;
        if (zza == -1 || zza2 == -1) {
            return -1L;
        }
        return zza + zza2;
    }
}
