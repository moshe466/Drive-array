package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzajo implements zzazp<zzaif> {
    final /* synthetic */ zzajj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajo(zzajj zzajjVar) {
        this.a = zzajjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final /* synthetic */ void zzh(zzaif zzaifVar) {
        final zzaif zzaifVar2 = zzaifVar;
        zzazd.zzdwi.execute(new Runnable(this, zzaifVar2) { // from class: com.google.android.gms.internal.ads.zzajn
            private final zzajo zzdah;
            private final zzaif zzdai;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdah = this;
                this.zzdai = zzaifVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzaxh zzaxhVar;
                zzajo zzajoVar = this.zzdah;
                zzaif zzaifVar3 = this.zzdai;
                zzaxhVar = zzajoVar.a.zzczn;
                zzaxhVar.zzh(zzaifVar3);
                zzaifVar3.destroy();
            }
        });
    }
}
