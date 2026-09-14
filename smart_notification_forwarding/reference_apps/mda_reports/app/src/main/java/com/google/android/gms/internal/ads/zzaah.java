package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzaah extends zzgc implements zzaaf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaaf
    public final String getContent() {
        Parcel a = a(2, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaaf
    public final void recordClick() {
        b(4, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaaf
    public final void recordImpression() {
        b(5, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaaf
    public final void zzn(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaaf
    public final String zzqs() {
        Parcel a = a(1, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
