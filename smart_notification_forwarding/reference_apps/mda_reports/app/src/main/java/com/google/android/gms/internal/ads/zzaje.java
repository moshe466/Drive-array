package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaje implements zzazn {
    private final /* synthetic */ zzais zzczu;
    private final /* synthetic */ zzajj zzczy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaje(zzais zzaisVar, zzajj zzajjVar) {
        this.zzczu = zzaisVar;
        this.zzczy = zzajjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazn
    public final void run() {
        Object obj;
        obj = this.zzczu.lock;
        synchronized (obj) {
            this.zzczu.status = 1;
            zzavs.zzed("Failed loading new engine. Marking new engine destroyable.");
            this.zzczy.zzse();
        }
    }
}
