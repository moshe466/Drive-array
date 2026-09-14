package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzaec extends zzgc implements zzaea {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaec(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final boolean zzm(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        Parcel a = a(2, c);
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }
}
