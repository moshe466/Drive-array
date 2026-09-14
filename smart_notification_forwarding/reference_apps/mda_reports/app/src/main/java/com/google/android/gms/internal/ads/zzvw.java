package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzvw extends zzgc implements zzvu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void destroy() {
        b(2, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final Bundle getAdMetadata() {
        Parcel a = a(37, c());
        Bundle bundle = (Bundle) zzge.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final String getAdUnitId() {
        Parcel a = a(31, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final String getMediationAdapterClassName() {
        Parcel a = a(18, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzxb getVideoController() {
        zzxb zzxdVar;
        Parcel a = a(26, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxdVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzxdVar = queryLocalInterface instanceof zzxb ? (zzxb) queryLocalInterface : new zzxd(readStrongBinder);
        }
        a.recycle();
        return zzxdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final boolean isLoading() {
        Parcel a = a(23, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final boolean isReady() {
        Parcel a = a(3, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void pause() {
        b(5, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void resume() {
        b(6, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setImmersiveMode(boolean z) {
        Parcel c = c();
        zzge.writeBoolean(c, z);
        b(34, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setManualImpressionsEnabled(boolean z) {
        Parcel c = c();
        zzge.writeBoolean(c, z);
        b(22, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setUserId(String str) {
        Parcel c = c();
        c.writeString(str);
        b(25, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void showInterstitial() {
        b(9, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void stopLoading() {
        b(10, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaak zzaakVar) {
        Parcel c = c();
        zzge.zza(c, zzaakVar);
        b(19, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaoy zzaoyVar) {
        Parcel c = c();
        zzge.zza(c, zzaoyVar);
        b(14, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzape zzapeVar, String str) {
        Parcel c = c();
        zzge.zza(c, zzapeVar);
        c.writeString(str);
        b(15, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaro zzaroVar) {
        Parcel c = c();
        zzge.zza(c, zzaroVar);
        b(24, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzrg zzrgVar) {
        Parcel c = c();
        zzge.zza(c, zzrgVar);
        b(40, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzuj zzujVar) {
        Parcel c = c();
        zzge.zza(c, zzujVar);
        b(13, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzuo zzuoVar) {
        Parcel c = c();
        zzge.zza(c, zzuoVar);
        b(39, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvg zzvgVar) {
        Parcel c = c();
        zzge.zza(c, zzvgVar);
        b(20, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvh zzvhVar) {
        Parcel c = c();
        zzge.zza(c, zzvhVar);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvx zzvxVar) {
        Parcel c = c();
        zzge.zza(c, zzvxVar);
        b(36, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzwc zzwcVar) {
        Parcel c = c();
        zzge.zza(c, zzwcVar);
        b(8, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzwi zzwiVar) {
        Parcel c = c();
        zzge.zza(c, zzwiVar);
        b(21, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzxh zzxhVar) {
        Parcel c = c();
        zzge.zza(c, zzxhVar);
        b(30, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzyw zzywVar) {
        Parcel c = c();
        zzge.zza(c, zzywVar);
        b(29, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final boolean zza(zzug zzugVar) {
        Parcel c = c();
        zzge.zza(c, zzugVar);
        Parcel a = a(4, c);
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zzbr(String str) {
        Parcel c = c();
        c.writeString(str);
        b(38, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final IObjectWrapper zzjx() {
        Parcel a = a(1, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zzjy() {
        b(11, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzuj zzjz() {
        Parcel a = a(12, c());
        zzuj zzujVar = (zzuj) zzge.zza(a, zzuj.CREATOR);
        a.recycle();
        return zzujVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final String zzka() {
        Parcel a = a(35, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzxa zzkb() {
        zzxa zzxcVar;
        Parcel a = a(41, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxcVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzxcVar = queryLocalInterface instanceof zzxa ? (zzxa) queryLocalInterface : new zzxc(readStrongBinder);
        }
        a.recycle();
        return zzxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzwc zzkc() {
        zzwc zzweVar;
        Parcel a = a(32, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzweVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzweVar = queryLocalInterface instanceof zzwc ? (zzwc) queryLocalInterface : new zzwe(readStrongBinder);
        }
        a.recycle();
        return zzweVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzvh zzkd() {
        zzvh zzvjVar;
        Parcel a = a(33, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzvjVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzvjVar = queryLocalInterface instanceof zzvh ? (zzvh) queryLocalInterface : new zzvj(readStrongBinder);
        }
        a.recycle();
        return zzvjVar;
    }
}
