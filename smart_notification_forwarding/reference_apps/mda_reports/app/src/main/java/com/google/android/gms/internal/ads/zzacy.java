package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzacy extends zzgc implements zzacw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final void destroy() {
        b(12, c());
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final String getBody() {
        Parcel a = a(5, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final String getCallToAction() {
        Parcel a = a(7, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final Bundle getExtras() {
        Parcel a = a(11, c());
        Bundle bundle = (Bundle) zzge.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final String getHeadline() {
        Parcel a = a(3, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final List getImages() {
        Parcel a = a(4, c());
        ArrayList zzb = zzge.zzb(a);
        a.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final String getMediationAdapterClassName() {
        Parcel a = a(19, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final String getPrice() {
        Parcel a = a(10, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final double getStarRating() {
        Parcel a = a(8, c());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final String getStore() {
        Parcel a = a(9, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final zzxb getVideoController() {
        Parcel a = a(13, c());
        zzxb zzj = zzxe.zzj(a.readStrongBinder());
        a.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final void performClick(Bundle bundle) {
        Parcel c = c();
        zzge.zza(c, bundle);
        b(14, c);
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final boolean recordImpression(Bundle bundle) {
        Parcel c = c();
        zzge.zza(c, bundle);
        Parcel a = a(15, c);
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final void reportTouchEvent(Bundle bundle) {
        Parcel c = c();
        zzge.zza(c, bundle);
        b(16, c);
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final IObjectWrapper zzrf() {
        Parcel a = a(2, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final zzaci zzrg() {
        zzaci zzackVar;
        Parcel a = a(6, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzackVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzackVar = queryLocalInterface instanceof zzaci ? (zzaci) queryLocalInterface : new zzack(readStrongBinder);
        }
        a.recycle();
        return zzackVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final zzaca zzrh() {
        zzaca zzaccVar;
        Parcel a = a(17, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaccVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzaccVar = queryLocalInterface instanceof zzaca ? (zzaca) queryLocalInterface : new zzacc(readStrongBinder);
        }
        a.recycle();
        return zzaccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final IObjectWrapper zzri() {
        Parcel a = a(18, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }
}
