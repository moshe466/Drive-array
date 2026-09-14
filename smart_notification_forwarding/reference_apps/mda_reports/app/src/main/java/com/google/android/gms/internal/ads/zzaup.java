package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzaup extends zzgc implements zzaun {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaup(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    public final void onError(String str) {
        Parcel c = c();
        c.writeString(str);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    public final void zzk(String str, String str2) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        b(1, c);
    }
}
