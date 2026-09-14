package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public final class zzagw extends zzgc implements zzagu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzagu
    public final void zzc(List<zzagn> list) {
        Parcel c = c();
        c.writeTypedList(list);
        b(1, c);
    }
}
