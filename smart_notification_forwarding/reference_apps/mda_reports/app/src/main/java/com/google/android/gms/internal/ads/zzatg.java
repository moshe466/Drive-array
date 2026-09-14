package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import com.google.android.gms.internal.ads.zzdvx;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
final class zzatg implements Runnable {
    private final /* synthetic */ Bitmap val$bitmap;
    private final /* synthetic */ zzatf zzdop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatg(zzatf zzatfVar, Bitmap bitmap) {
        this.zzdop = zzatfVar;
        this.val$bitmap = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        zzdwi zzdwiVar;
        zzdwi zzdwiVar2;
        zzdwi zzdwiVar3;
        zzdwi zzdwiVar4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.val$bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        obj = this.zzdop.lock;
        synchronized (obj) {
            zzdwiVar = this.zzdop.zzdoe;
            zzdwiVar.zzhxy = new zzdwj();
            zzdwiVar2 = this.zzdop.zzdoe;
            zzdwiVar2.zzhxy.zzhyj = byteArrayOutputStream.toByteArray();
            zzdwiVar3 = this.zzdop.zzdoe;
            zzdwiVar3.zzhxy.mimeType = "image/png";
            zzdwiVar4 = this.zzdop.zzdoe;
            zzdwiVar4.zzhxy.zzhyi = zzdvx.zzb.zzf.EnumC0021zzb.TYPE_CREATIVE;
        }
    }
}
