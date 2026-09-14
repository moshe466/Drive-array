package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzajb implements zzazp<zzaif> {
    private final /* synthetic */ zzais zzczu;
    private final /* synthetic */ zzajj zzczy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajb(zzais zzaisVar, zzajj zzajjVar) {
        this.zzczu = zzaisVar;
        this.zzczy = zzajjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final /* synthetic */ void zzh(zzaif zzaifVar) {
        Object obj;
        zzajj zzajjVar;
        zzajj zzajjVar2;
        zzajj zzajjVar3;
        obj = this.zzczu.lock;
        synchronized (obj) {
            this.zzczu.status = 0;
            zzajjVar = this.zzczu.zzczo;
            if (zzajjVar != null) {
                zzajj zzajjVar4 = this.zzczy;
                zzajjVar2 = this.zzczu.zzczo;
                if (zzajjVar4 != zzajjVar2) {
                    zzavs.zzed("New JS engine is loaded, marking previous one as destroyable.");
                    zzajjVar3 = this.zzczu.zzczo;
                    zzajjVar3.zzse();
                }
            }
            this.zzczu.zzczo = this.zzczy;
        }
    }
}
