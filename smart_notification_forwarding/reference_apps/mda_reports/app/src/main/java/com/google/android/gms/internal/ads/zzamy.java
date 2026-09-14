package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzamy extends zzgc implements zzamw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzamw
    public final void zzdl(String str) {
        Parcel c = c();
        c.writeString(str);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzamw
    public final void zzx(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(1, c);
    }
}
