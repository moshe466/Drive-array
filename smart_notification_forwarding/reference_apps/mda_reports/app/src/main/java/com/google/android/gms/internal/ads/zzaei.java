package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaei extends zzgc implements zzaeg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaei(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void cancelUnconfirmedClick() {
        b(22, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void destroy() {
        b(13, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getAdvertiser() {
        Parcel a = a(7, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getBody() {
        Parcel a = a(4, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getCallToAction() {
        Parcel a = a(6, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final Bundle getExtras() {
        Parcel a = a(20, c());
        Bundle bundle = (Bundle) zzge.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getHeadline() {
        Parcel a = a(2, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final List getImages() {
        Parcel a = a(3, c());
        ArrayList zzb = zzge.zzb(a);
        a.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getMediationAdapterClassName() {
        Parcel a = a(12, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final List getMuteThisAdReasons() {
        Parcel a = a(23, c());
        ArrayList zzb = zzge.zzb(a);
        a.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getPrice() {
        Parcel a = a(10, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final double getStarRating() {
        Parcel a = a(8, c());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final String getStore() {
        Parcel a = a(9, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final zzxb getVideoController() {
        Parcel a = a(11, c());
        zzxb zzj = zzxe.zzj(a.readStrongBinder());
        a.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final boolean isCustomClickGestureEnabled() {
        Parcel a = a(30, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final boolean isCustomMuteThisAdEnabled() {
        Parcel a = a(24, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void performClick(Bundle bundle) {
        Parcel c = c();
        zzge.zza(c, bundle);
        b(15, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void recordCustomClickGesture() {
        b(28, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final boolean recordImpression(Bundle bundle) {
        Parcel c = c();
        zzge.zza(c, bundle);
        Parcel a = a(16, c);
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void reportTouchEvent(Bundle bundle) {
        Parcel c = c();
        zzge.zza(c, bundle);
        b(17, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zza(zzaeb zzaebVar) {
        Parcel c = c();
        zzge.zza(c, zzaebVar);
        b(21, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zza(zzwn zzwnVar) {
        Parcel c = c();
        zzge.zza(c, zzwnVar);
        b(26, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zza(zzwr zzwrVar) {
        Parcel c = c();
        zzge.zza(c, zzwrVar);
        b(25, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final zzxa zzkb() {
        Parcel a = a(31, c());
        zzxa zzi = zzwz.zzi(a.readStrongBinder());
        a.recycle();
        return zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final IObjectWrapper zzrf() {
        Parcel a = a(18, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final zzaci zzrg() {
        zzaci zzackVar;
        Parcel a = a(5, c());
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

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final zzaca zzrh() {
        zzaca zzaccVar;
        Parcel a = a(14, c());
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

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final IObjectWrapper zzri() {
        Parcel a = a(19, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zzrp() {
        b(27, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final zzacd zzrq() {
        zzacd zzacfVar;
        Parcel a = a(29, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzacfVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzacfVar = queryLocalInterface instanceof zzacd ? (zzacd) queryLocalInterface : new zzacf(readStrongBinder);
        }
        a.recycle();
        return zzacfVar;
    }
}
