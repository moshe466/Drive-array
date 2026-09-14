package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzajh implements zzazp<zzajq> {
    private final /* synthetic */ zzajf zzdad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajh(zzajf zzajfVar) {
        this.zzdad = zzajfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final /* synthetic */ void zzh(zzajq zzajqVar) {
        zzajj zzajjVar;
        zzavs.zzed("Releasing engine reference.");
        zzajjVar = this.zzdad.zzdab;
        zzajjVar.a();
    }
}
