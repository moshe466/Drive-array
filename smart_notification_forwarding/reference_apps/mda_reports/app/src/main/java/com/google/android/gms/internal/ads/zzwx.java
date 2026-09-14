package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* loaded from: classes.dex */
public final class zzwx extends zzgc implements zzwv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzwv
    public final void onAdMetadataChanged() {
        b(1, c());
    }
}
