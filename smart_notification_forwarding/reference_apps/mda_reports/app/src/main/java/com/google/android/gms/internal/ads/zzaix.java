package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaix implements zzafn<zzajq> {
    private final /* synthetic */ zzajj zzczs;
    private final /* synthetic */ zzaif zzczt;
    private final /* synthetic */ zzais zzczu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaix(zzais zzaisVar, zzajj zzajjVar, zzaif zzaifVar) {
        this.zzczu = zzaisVar;
        this.zzczs = zzajjVar;
        this.zzczt = zzaifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(zzajq zzajqVar, Map map) {
        Object obj;
        zzaxh zzaxhVar;
        obj = this.zzczu.lock;
        synchronized (obj) {
            if (this.zzczs.getStatus() != -1 && this.zzczs.getStatus() != 1) {
                this.zzczu.status = 0;
                zzaxhVar = this.zzczu.zzczm;
                zzaxhVar.zzh(this.zzczt);
                this.zzczs.zzm(this.zzczt);
                this.zzczu.zzczo = this.zzczs;
                zzavs.zzed("Successfully loaded JS Engine.");
            }
        }
    }
}
