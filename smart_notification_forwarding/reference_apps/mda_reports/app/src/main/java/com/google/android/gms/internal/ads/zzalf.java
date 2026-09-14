package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public final class zzalf extends zzgc implements zzald {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void destroy() {
        b(5, c());
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final Bundle getInterstitialAdapterInfo() {
        Parcel a = a(18, c());
        Bundle bundle = (Bundle) zzge.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final zzxb getVideoController() {
        Parcel a = a(26, c());
        zzxb zzj = zzxe.zzj(a.readStrongBinder());
        a.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final boolean isInitialized() {
        Parcel a = a(13, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void pause() {
        b(8, c());
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void resume() {
        b(9, c());
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void setImmersiveMode(boolean z) {
        Parcel c = c();
        zzge.writeBoolean(c, z);
        b(25, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void showInterstitial() {
        b(4, c());
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void showVideo() {
        b(12, c());
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzagp zzagpVar, List<zzagx> list) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzagpVar);
        c.writeTypedList(list);
        b(31, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzarz zzarzVar, List<String> list) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzarzVar);
        c.writeStringList(list);
        b(23, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzug zzugVar, String str, zzali zzaliVar) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzugVar);
        c.writeString(str);
        zzge.zza(c, zzaliVar);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzug zzugVar, String str, zzarz zzarzVar, String str2) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzugVar);
        c.writeString(str);
        zzge.zza(c, zzarzVar);
        c.writeString(str2);
        b(10, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzug zzugVar, String str, String str2, zzali zzaliVar) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzugVar);
        c.writeString(str);
        c.writeString(str2);
        zzge.zza(c, zzaliVar);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzug zzugVar, String str, String str2, zzali zzaliVar, zzaby zzabyVar, List<String> list) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzugVar);
        c.writeString(str);
        c.writeString(str2);
        zzge.zza(c, zzaliVar);
        zzge.zza(c, zzabyVar);
        c.writeStringList(list);
        b(14, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzujVar, zzug zzugVar, String str, zzali zzaliVar) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzujVar);
        zzge.zza(c, zzugVar);
        c.writeString(str);
        zzge.zza(c, zzaliVar);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzujVar, zzug zzugVar, String str, String str2, zzali zzaliVar) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzujVar);
        zzge.zza(c, zzugVar);
        c.writeString(str);
        c.writeString(str2);
        zzge.zza(c, zzaliVar);
        b(6, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(zzug zzugVar, String str) {
        Parcel c = c();
        zzge.zza(c, zzugVar);
        c.writeString(str);
        b(11, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zza(zzug zzugVar, String str, String str2) {
        Parcel c = c();
        zzge.zza(c, zzugVar);
        c.writeString(str);
        c.writeString(str2);
        b(20, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zzb(IObjectWrapper iObjectWrapper, zzug zzugVar, String str, zzali zzaliVar) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzugVar);
        c.writeString(str);
        zzge.zza(c, zzaliVar);
        b(28, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zzs(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(21, c);
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final IObjectWrapper zzsk() {
        Parcel a = a(2, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final zzall zzsl() {
        zzall zzalnVar;
        Parcel a = a(15, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzalnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzalnVar = queryLocalInterface instanceof zzall ? (zzall) queryLocalInterface : new zzaln(readStrongBinder);
        }
        a.recycle();
        return zzalnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final zzalq zzsm() {
        zzalq zzalsVar;
        Parcel a = a(16, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzalsVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzalsVar = queryLocalInterface instanceof zzalq ? (zzalq) queryLocalInterface : new zzals(readStrongBinder);
        }
        a.recycle();
        return zzalsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final Bundle zzsn() {
        Parcel a = a(17, c());
        Bundle bundle = (Bundle) zzge.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final Bundle zzso() {
        Parcel a = a(19, c());
        Bundle bundle = (Bundle) zzge.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final boolean zzsp() {
        Parcel a = a(22, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final zzade zzsq() {
        Parcel a = a(24, c());
        zzade zzp = zzadd.zzp(a.readStrongBinder());
        a.recycle();
        return zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final zzalr zzsr() {
        zzalr zzaltVar;
        Parcel a = a(27, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaltVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzaltVar = queryLocalInterface instanceof zzalr ? (zzalr) queryLocalInterface : new zzalt(readStrongBinder);
        }
        a.recycle();
        return zzaltVar;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final void zzt(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(30, c);
    }
}
