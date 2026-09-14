package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaln extends zzgc implements zzall {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaln(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final String getBody() {
        Parcel a = a(4, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final String getCallToAction() {
        Parcel a = a(6, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final Bundle getExtras() {
        Parcel a = a(15, c());
        Bundle bundle = (Bundle) zzge.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final String getHeadline() {
        Parcel a = a(2, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final List getImages() {
        Parcel a = a(3, c());
        ArrayList zzb = zzge.zzb(a);
        a.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final boolean getOverrideClickHandling() {
        Parcel a = a(14, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final boolean getOverrideImpressionRecording() {
        Parcel a = a(13, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final String getPrice() {
        Parcel a = a(9, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final double getStarRating() {
        Parcel a = a(7, c());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final String getStore() {
        Parcel a = a(8, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final zzxb getVideoController() {
        Parcel a = a(17, c());
        zzxb zzj = zzxe.zzj(a.readStrongBinder());
        a.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final void recordImpression() {
        b(10, c());
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, iObjectWrapper2);
        zzge.zza(c, iObjectWrapper3);
        b(22, c);
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final zzaci zzrg() {
        Parcel a = a(5, c());
        zzaci zzm = zzach.zzm(a.readStrongBinder());
        a.recycle();
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final zzaca zzrh() {
        Parcel a = a(19, c());
        zzaca zzl = zzabz.zzl(a.readStrongBinder());
        a.recycle();
        return zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final IObjectWrapper zzri() {
        Parcel a = a(21, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final IObjectWrapper zzsu() {
        Parcel a = a(18, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final IObjectWrapper zzsv() {
        Parcel a = a(20, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final void zzu(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(11, c);
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final void zzv(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(12, c);
    }

    @Override // com.google.android.gms.internal.ads.zzall
    public final void zzw(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(16, c);
    }
}
