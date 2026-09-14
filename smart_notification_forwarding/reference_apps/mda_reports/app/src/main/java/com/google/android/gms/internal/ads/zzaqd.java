package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzaqd extends zzgc implements zzaqb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final zzapx zza(zzapv zzapvVar) {
        Parcel c = c();
        zzge.zza(c, zzapvVar);
        Parcel a = a(1, c);
        zzapx zzapxVar = (zzapx) zzge.zza(a, zzapx.CREATOR);
        a.recycle();
        return zzapxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final void zza(zzapv zzapvVar, zzaqc zzaqcVar) {
        Parcel c = c();
        zzge.zza(c, zzapvVar);
        zzge.zza(c, zzaqcVar);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final void zza(zzaqk zzaqkVar, zzaqe zzaqeVar) {
        Parcel c = c();
        zzge.zza(c, zzaqkVar);
        zzge.zza(c, zzaqeVar);
        b(4, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final void zza(String str, zzaqe zzaqeVar) {
        Parcel c = c();
        c.writeString(str);
        zzge.zza(c, zzaqeVar);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final void zzb(zzaqk zzaqkVar, zzaqe zzaqeVar) {
        Parcel c = c();
        zzge.zza(c, zzaqkVar);
        zzge.zza(c, zzaqeVar);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaqb
    public final void zzc(zzaqk zzaqkVar, zzaqe zzaqeVar) {
        Parcel c = c();
        zzge.zza(c, zzaqkVar);
        zzge.zza(c, zzaqeVar);
        b(6, c);
    }
}
