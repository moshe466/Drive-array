package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzu extends zza implements zzs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final int zza() {
        Parcel a = a(2, c());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final void zza(String str, String str2, Bundle bundle, long j) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzb.zza(c, bundle);
        c.writeLong(j);
        b(1, c);
    }
}
