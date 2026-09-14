package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzauq extends zzgc implements zzauo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzauq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzauo
    public final void zza(IObjectWrapper iObjectWrapper, zzauu zzauuVar, zzaun zzaunVar) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzauuVar);
        zzge.zza(c, zzaunVar);
        b(1, c);
    }
}
