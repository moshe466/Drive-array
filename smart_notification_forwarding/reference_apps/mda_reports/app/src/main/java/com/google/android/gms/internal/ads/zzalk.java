package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzalk extends zzgc implements zzali {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdClicked() {
        b(1, c());
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdClosed() {
        b(2, c());
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdFailedToLoad(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdImpression() {
        b(8, c());
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdLeftApplication() {
        b(4, c());
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdLoaded() {
        b(6, c());
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAdOpened() {
        b(5, c());
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onAppEvent(String str, String str2) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        b(9, c);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onVideoEnd() {
        b(11, c());
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onVideoPause() {
        b(15, c());
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void onVideoPlay() {
        b(20, c());
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zza(zzade zzadeVar, String str) {
        Parcel c = c();
        zzge.zza(c, zzadeVar);
        c.writeString(str);
        b(10, c);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zza(zzalj zzaljVar) {
        Parcel c = c();
        zzge.zza(c, zzaljVar);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zza(zzasf zzasfVar) {
        Parcel c = c();
        zzge.zza(c, zzasfVar);
        b(16, c);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zzb(Bundle bundle) {
        Parcel c = c();
        zzge.zza(c, bundle);
        b(19, c);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zzb(zzasd zzasdVar) {
        Parcel c = c();
        zzge.zza(c, zzasdVar);
        b(14, c);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zzco(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(17, c);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zzdj(String str) {
        Parcel c = c();
        c.writeString(str);
        b(12, c);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zzss() {
        b(13, c());
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zzst() {
        b(18, c());
    }
}
