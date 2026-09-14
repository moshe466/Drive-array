package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
final class zzatj implements zzdgt<Void> {
    private final /* synthetic */ zzdhe zzdor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatj(zzatf zzatfVar, zzdhe zzdheVar) {
        this.zzdor = zzdheVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(Void r2) {
        List list;
        list = zzatf.zzdod;
        list.remove(this.zzdor);
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        List list;
        list = zzatf.zzdod;
        list.remove(this.zzdor);
    }
}
