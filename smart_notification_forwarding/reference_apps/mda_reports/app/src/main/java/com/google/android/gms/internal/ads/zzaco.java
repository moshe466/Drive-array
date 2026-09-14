package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzaco extends zzgc implements zzacm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaco(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void destroy() {
        b(4, c());
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zza(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zza(zzacd zzacdVar) {
        Parcel c = c();
        zzge.zza(c, zzacdVar);
        b(8, c);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zzb(String str, IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        c.writeString(str);
        zzge.zza(c, iObjectWrapper);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zzc(IObjectWrapper iObjectWrapper, int i) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeInt(i);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final IObjectWrapper zzco(String str) {
        Parcel c = c();
        c.writeString(str);
        Parcel a = a(2, c);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zze(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(6, c);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zzf(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zzg(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(9, c);
    }
}
