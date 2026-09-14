package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzarn extends zzgc implements zzarl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void destroy() {
        b(8, c());
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final Bundle getAdMetadata() {
        Parcel a = a(15, c());
        Bundle bundle = (Bundle) zzge.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final String getMediationAdapterClassName() {
        Parcel a = a(12, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final boolean isLoaded() {
        Parcel a = a(5, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void pause() {
        b(6, c());
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void resume() {
        b(7, c());
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void setAppPackageName(String str) {
        Parcel c = c();
        c.writeString(str);
        b(17, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void setCustomData(String str) {
        Parcel c = c();
        c.writeString(str);
        b(19, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void setImmersiveMode(boolean z) {
        Parcel c = c();
        zzge.writeBoolean(c, z);
        b(34, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void setUserId(String str) {
        Parcel c = c();
        c.writeString(str);
        b(13, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void show() {
        b(2, c());
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zza(zzarj zzarjVar) {
        Parcel c = c();
        zzge.zza(c, zzarjVar);
        b(16, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zza(zzaro zzaroVar) {
        Parcel c = c();
        zzge.zza(c, zzaroVar);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zza(zzaru zzaruVar) {
        Parcel c = c();
        zzge.zza(c, zzaruVar);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zza(zzvx zzvxVar) {
        Parcel c = c();
        zzge.zza(c, zzvxVar);
        b(14, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zzi(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(18, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zzj(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(9, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zzk(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(10, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final zzxa zzkb() {
        Parcel a = a(21, c());
        zzxa zzi = zzwz.zzi(a.readStrongBinder());
        a.recycle();
        return zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zzl(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(11, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final boolean zzqa() {
        Parcel a = a(20, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }
}
