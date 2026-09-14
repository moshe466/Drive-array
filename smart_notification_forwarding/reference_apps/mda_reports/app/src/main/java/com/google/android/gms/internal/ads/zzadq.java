package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzadq extends zzgc implements zzado {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final void zza(zzade zzadeVar, String str) {
        Parcel c = c();
        zzge.zza(c, zzadeVar);
        c.writeString(str);
        b(1, c);
    }
}
