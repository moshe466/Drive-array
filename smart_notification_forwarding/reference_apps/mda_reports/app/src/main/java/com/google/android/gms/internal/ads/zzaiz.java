package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaiz implements Runnable {
    private final /* synthetic */ zzajj zzczs;
    private final /* synthetic */ zzaif zzczt;
    private final /* synthetic */ zzais zzczu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaiz(zzais zzaisVar, zzajj zzajjVar, zzaif zzaifVar) {
        this.zzczu = zzaisVar;
        this.zzczs = zzajjVar;
        this.zzczt = zzaifVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzczu.lock;
        synchronized (obj) {
            if (this.zzczs.getStatus() != -1 && this.zzczs.getStatus() != 1) {
                this.zzczs.reject();
                zzdhd zzdhdVar = zzazd.zzdwi;
                zzaif zzaifVar = this.zzczt;
                zzaifVar.getClass();
                zzdhdVar.execute(zzajc.a(zzaifVar));
                zzavs.zzed("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
