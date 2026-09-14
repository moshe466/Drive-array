package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzank extends zzgc implements zzani {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzank(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final zzxb getVideoController() {
        Parcel a = a(5, c());
        zzxb zzj = zzxe.zzj(a.readStrongBinder());
        a.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzuj zzujVar, zzanj zzanjVar) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeString(str);
        zzge.zza(c, bundle);
        zzge.zza(c, bundle2);
        zzge.zza(c, zzujVar);
        zzge.zza(c, zzanjVar);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(String str, String str2, zzug zzugVar, IObjectWrapper iObjectWrapper, zzamw zzamwVar, zzali zzaliVar, zzuj zzujVar) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzge.zza(c, zzugVar);
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzamwVar);
        zzge.zza(c, zzaliVar);
        zzge.zza(c, zzujVar);
        b(13, c);
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(String str, String str2, zzug zzugVar, IObjectWrapper iObjectWrapper, zzamx zzamxVar, zzali zzaliVar) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzge.zza(c, zzugVar);
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzamxVar);
        zzge.zza(c, zzaliVar);
        b(14, c);
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(String str, String str2, zzug zzugVar, IObjectWrapper iObjectWrapper, zzanc zzancVar, zzali zzaliVar) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzge.zza(c, zzugVar);
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzancVar);
        zzge.zza(c, zzaliVar);
        b(18, c);
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(String str, String str2, zzug zzugVar, IObjectWrapper iObjectWrapper, zzand zzandVar, zzali zzaliVar) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzge.zza(c, zzugVar);
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzandVar);
        zzge.zza(c, zzaliVar);
        b(16, c);
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zza(String[] strArr, Bundle[] bundleArr) {
        Parcel c = c();
        c.writeStringArray(strArr);
        c.writeTypedArray(bundleArr, 0);
        b(11, c);
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final boolean zzaa(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        Parcel a = a(17, c);
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zzdm(String str) {
        Parcel c = c();
        c.writeString(str);
        b(19, c);
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final zzanw zztc() {
        Parcel a = a(2, c());
        zzanw zzanwVar = (zzanw) zzge.zza(a, zzanw.CREATOR);
        a.recycle();
        return zzanwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final zzanw zztd() {
        Parcel a = a(3, c());
        zzanw zzanwVar = (zzanw) zzge.zza(a, zzanw.CREATOR);
        a.recycle();
        return zzanwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final void zzy(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(10, c);
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final boolean zzz(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        Parcel a = a(15, c);
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }
}
