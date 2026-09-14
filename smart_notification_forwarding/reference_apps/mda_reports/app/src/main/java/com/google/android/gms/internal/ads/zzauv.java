package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzauv extends zzgc implements zzaut {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzauv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final zzauo zzf(IObjectWrapper iObjectWrapper, int i) {
        zzauo zzauqVar;
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeInt(12451009);
        Parcel a = a(1, c);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzauqVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            zzauqVar = queryLocalInterface instanceof zzauo ? (zzauo) queryLocalInterface : new zzauq(readStrongBinder);
        }
        a.recycle();
        return zzauqVar;
    }
}
