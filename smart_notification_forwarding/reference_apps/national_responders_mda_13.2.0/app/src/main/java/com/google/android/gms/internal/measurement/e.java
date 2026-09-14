package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class e extends a implements c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.c
    public final void C(String str, String str2, Bundle bundle, long j10) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeString(str2);
        v.c(i10, bundle);
        i10.writeLong(j10);
        p(1, i10);
    }

    @Override // com.google.android.gms.internal.measurement.c
    public final int zza() {
        Parcel n10 = n(2, i());
        int readInt = n10.readInt();
        n10.recycle();
        return readInt;
    }
}
