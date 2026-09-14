package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzddg extends zzgc implements zzddf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzddg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    @Override // com.google.android.gms.internal.ads.zzddf
    public final String getVersion() {
        Parcel a = a(6, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzddf
    public final IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) {
        Parcel c = c();
        c.writeString(str);
        zzge.zza(c, iObjectWrapper);
        c.writeString(str2);
        c.writeString(str3);
        c.writeString(str4);
        c.writeString(str5);
        Parcel a = a(9, c);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzddf
    public final void zzab(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(4, c);
    }

    @Override // com.google.android.gms.internal.ads.zzddf
    public final void zzac(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.ads.zzddf
    public final boolean zzas(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        Parcel a = a(2, c);
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzddf
    public final void zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, iObjectWrapper2);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzddf
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, iObjectWrapper2);
        b(8, c);
    }
}
