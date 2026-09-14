package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* loaded from: classes.dex */
public final class zzvi extends zzgc implements zzvg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzvg
    public final void onAdClicked() {
        b(1, c());
    }
}
