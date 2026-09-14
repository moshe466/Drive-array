package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzasi extends zzgc implements zzasg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final Bundle getAdMetadata() {
        Parcel a = a(9, c());
        Bundle bundle = (Bundle) zzge.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final String getMediationAdapterClassName() {
        Parcel a = a(4, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final boolean isLoaded() {
        Parcel a = a(3, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.writeBoolean(c, z);
        b(10, c);
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zza(zzasl zzaslVar) {
        Parcel c = c();
        zzge.zza(c, zzaslVar);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zza(zzast zzastVar) {
        Parcel c = c();
        zzge.zza(c, zzastVar);
        b(6, c);
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zza(zzatb zzatbVar) {
        Parcel c = c();
        zzge.zza(c, zzatbVar);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zza(zzug zzugVar, zzaso zzasoVar) {
        Parcel c = c();
        zzge.zza(c, zzugVar);
        zzge.zza(c, zzasoVar);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zza(zzwv zzwvVar) {
        Parcel c = c();
        zzge.zza(c, zzwvVar);
        b(8, c);
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zzh(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final zzxa zzkb() {
        Parcel a = a(12, c());
        zzxa zzi = zzwz.zzi(a.readStrongBinder());
        a.recycle();
        return zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final zzasf zzpz() {
        zzasf zzashVar;
        Parcel a = a(11, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzashVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzashVar = queryLocalInterface instanceof zzasf ? (zzasf) queryLocalInterface : new zzash(readStrongBinder);
        }
        a.recycle();
        return zzashVar;
    }
}
