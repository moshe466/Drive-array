package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcez extends zzags {
    private final /* synthetic */ zzceq zzftz;
    private final /* synthetic */ Object zzfua;
    private final /* synthetic */ String zzfub;
    private final /* synthetic */ long zzfuc;
    private final /* synthetic */ zzazl zzfud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcez(zzceq zzceqVar, Object obj, String str, long j, zzazl zzazlVar) {
        this.zzftz = zzceqVar;
        this.zzfua = obj;
        this.zzfub = str;
        this.zzfuc = j;
        this.zzfud = zzazlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagp
    public final void onInitializationFailed(String str) {
        zzcea zzceaVar;
        synchronized (this.zzfua) {
            this.zzftz.zza(this.zzfub, false, str, (int) (com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - this.zzfuc));
            zzceaVar = this.zzftz.zzftr;
            zzceaVar.zzq(this.zzfub, "error");
            this.zzfud.set(false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagp
    public final void onInitializationSucceeded() {
        zzcea zzceaVar;
        synchronized (this.zzfua) {
            this.zzftz.zza(this.zzfub, true, "", (int) (com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - this.zzfuc));
            zzceaVar = this.zzftz.zzftr;
            zzceaVar.zzge(this.zzfub);
            this.zzfud.set(true);
        }
    }
}
