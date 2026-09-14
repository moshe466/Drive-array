package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzadw extends zzgc implements zzadu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final void zza(zzvu zzvuVar, IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, zzvuVar);
        zzge.zza(c, iObjectWrapper);
        b(1, c);
    }
}
