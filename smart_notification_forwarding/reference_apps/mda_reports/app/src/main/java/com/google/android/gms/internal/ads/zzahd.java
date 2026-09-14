package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzahd extends zzgc implements zzahb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final void destroy() {
        b(4, c());
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzxb getVideoController() {
        Parcel a = a(3, c());
        zzxb zzj = zzxe.zzj(a.readStrongBinder());
        a.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final void zza(IObjectWrapper iObjectWrapper, zzahg zzahgVar) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzahgVar);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final void zzr(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(6, c);
    }
}
