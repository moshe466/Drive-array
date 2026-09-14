package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzaed extends zzgc implements zzaeb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaed(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final void onUnconfirmedClickCancelled() {
        b(2, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final void onUnconfirmedClickReceived(String str) {
        Parcel c = c();
        c.writeString(str);
        b(1, c);
    }
}
