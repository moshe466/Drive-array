package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class zzbbr implements zznl {
    private boolean isOpen;
    private Uri uri;
    private InputStream zzebt;
    private final zznl zzebu;

    @Nullable
    private final zznz<zznl> zzebv;
    private final zzbbq zzebw;
    private final Context zzup;

    public zzbbr(Context context, zznl zznlVar, zznz<zznl> zznzVar, zzbbq zzbbqVar) {
        this.zzup = context;
        this.zzebu = zznlVar;
        this.zzebv = zznzVar;
        this.zzebw = zzbbqVar;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final void close() {
        if (!this.isOpen) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.isOpen = false;
        this.uri = null;
        InputStream inputStream = this.zzebt;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.zzebt = null;
        } else {
            this.zzebu.close();
        }
        zznz<zznl> zznzVar = this.zzebv;
        if (zznzVar != null) {
            zznzVar.zze(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final int read(byte[] bArr, int i, int i2) {
        if (!this.isOpen) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.zzebt;
        int read = inputStream != null ? inputStream.read(bArr, i, i2) : this.zzebu.read(bArr, i, i2);
        zznz<zznl> zznzVar = this.zzebv;
        if (zznzVar != null) {
            zznzVar.zzc(this, read);
        }
        return read;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x011e  */
    @Override // com.google.android.gms.internal.ads.zznl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zza(com.google.android.gms.internal.ads.zznq r21) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbr.zza(com.google.android.gms.internal.ads.zznq):long");
    }
}
