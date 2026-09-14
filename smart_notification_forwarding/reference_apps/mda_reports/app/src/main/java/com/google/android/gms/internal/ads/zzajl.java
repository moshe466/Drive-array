package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzajl implements zzazn {
    private final /* synthetic */ zzajf zzdag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajl(zzajj zzajjVar, zzajf zzajfVar) {
        this.zzdag = zzajfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazn
    public final void run() {
        zzavs.zzed("Rejecting reference for JS Engine.");
        this.zzdag.reject();
    }
}
