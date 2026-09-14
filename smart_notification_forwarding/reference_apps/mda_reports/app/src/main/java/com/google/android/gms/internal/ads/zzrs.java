package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzrs implements zzqj {
    private final /* synthetic */ zzrq zzbrh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrs(zzrq zzrqVar) {
        this.zzbrh = zzrqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void zzp(boolean z) {
        if (z) {
            this.zzbrh.connect();
        } else {
            this.zzbrh.disconnect();
        }
    }
}
