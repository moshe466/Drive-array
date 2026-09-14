package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzasb extends zzgc implements zzarz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zza(IObjectWrapper iObjectWrapper, zzasd zzasdVar) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzasdVar);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzaf(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzag(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzah(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(4, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzai(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzaj(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(6, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzak(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(8, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzal(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(10, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzam(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(11, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzb(Bundle bundle) {
        Parcel c = c();
        zzge.zza(c, bundle);
        b(12, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeInt(i);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zze(IObjectWrapper iObjectWrapper, int i) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeInt(i);
        b(9, c);
    }
}
