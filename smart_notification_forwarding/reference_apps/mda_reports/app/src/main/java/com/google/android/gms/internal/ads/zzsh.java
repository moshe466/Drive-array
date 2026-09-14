package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzsh extends zzazl<InputStream> {
    private final /* synthetic */ zzse zzbrt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsh(zzse zzseVar) {
        this.zzbrt = zzseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazl, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.zzbrt.disconnect();
        return super.cancel(z);
    }
}
