package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfh extends zzfw {
    private static final Object zzzs = new Object();
    private static volatile String zzzv;

    public zzfh(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        this.b.zzaf(ExifInterface.LONGITUDE_EAST);
        if (zzzv == null) {
            synchronized (zzzs) {
                if (zzzv == null) {
                    zzzv = (String) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.zzaf(zzzv);
        }
    }
}
