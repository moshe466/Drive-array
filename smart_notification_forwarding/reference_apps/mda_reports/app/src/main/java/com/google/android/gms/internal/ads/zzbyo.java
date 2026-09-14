package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbyo implements zzded<zzo, Bitmap> {
    private final /* synthetic */ double zzfop;
    private final /* synthetic */ boolean zzfoq;
    private final /* synthetic */ zzbyl zzfor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbyo(zzbyl zzbylVar, double d, boolean z) {
        this.zzfor = zzbylVar;
        this.zzfop = d;
        this.zzfoq = z;
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final /* synthetic */ Bitmap apply(zzo zzoVar) {
        Bitmap zza;
        zza = this.zzfor.zza(zzoVar.data, this.zzfop, this.zzfoq);
        return zza;
    }
}
