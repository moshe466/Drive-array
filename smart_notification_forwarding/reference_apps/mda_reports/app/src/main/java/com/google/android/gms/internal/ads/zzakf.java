package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzakf implements zzazn {
    private final /* synthetic */ zzazl zzcxt;
    private final /* synthetic */ zzajf zzdaz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakf(zzakd zzakdVar, zzazl zzazlVar, zzajf zzajfVar) {
        this.zzcxt = zzazlVar;
        this.zzdaz = zzajfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazn
    public final void run() {
        this.zzcxt.setException(new zzajr("Unable to obtain a JavascriptEngine."));
        this.zzdaz.release();
    }
}
