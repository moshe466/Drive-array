package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzals extends zzgc implements zzalq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzals(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final String getAdvertiser() {
        Parcel a = a(7, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final String getBody() {
        Parcel a = a(4, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final String getCallToAction() {
        Parcel a = a(6, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final Bundle getExtras() {
        Parcel a = a(13, c());
        Bundle bundle = (Bundle) zzge.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final String getHeadline() {
        Parcel a = a(2, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final List getImages() {
        Parcel a = a(3, c());
        ArrayList zzb = zzge.zzb(a);
        a.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final boolean getOverrideClickHandling() {
        Parcel a = a(12, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final boolean getOverrideImpressionRecording() {
        Parcel a = a(11, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final zzxb getVideoController() {
        Parcel a = a(16, c());
        zzxb zzj = zzxe.zzj(a.readStrongBinder());
        a.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final void recordImpression() {
        b(8, c());
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, iObjectWrapper2);
        zzge.zza(c, iObjectWrapper3);
        b(22, c);
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final zzaca zzrh() {
        Parcel a = a(19, c());
        zzaca zzl = zzabz.zzl(a.readStrongBinder());
        a.recycle();
        return zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final IObjectWrapper zzri() {
        Parcel a = a(21, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final zzaci zzrj() {
        Parcel a = a(5, c());
        zzaci zzm = zzach.zzm(a.readStrongBinder());
        a.recycle();
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final IObjectWrapper zzsu() {
        Parcel a = a(15, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final IObjectWrapper zzsv() {
        Parcel a = a(20, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final void zzu(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(9, c);
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final void zzv(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(10, c);
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final void zzw(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(14, c);
    }
}
