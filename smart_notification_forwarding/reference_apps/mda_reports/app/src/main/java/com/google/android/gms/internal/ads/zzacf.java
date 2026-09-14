package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzacf extends zzgc implements zzacd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final float getAspectRatio() {
        Parcel a = a(2, c());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final void zzo(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final IObjectWrapper zzre() {
        Parcel a = a(4, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }
}
