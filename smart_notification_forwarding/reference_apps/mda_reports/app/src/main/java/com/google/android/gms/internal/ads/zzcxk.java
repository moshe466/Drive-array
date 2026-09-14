package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [AdT] */
/* loaded from: classes.dex */
public final class zzcxk<AdT> implements zzdgt<zzdbi<AdT>> {
    private final /* synthetic */ zzcxg zzgkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcxk(zzcxg zzcxgVar) {
        this.zzgkc = zzcxgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(Object obj) {
        zzcxt zzcxtVar;
        int i;
        int i2;
        zzcxn zzcxnVar;
        zzdbb zzdbbVar;
        zzdbb zzdbbVar2;
        zzcxn zzcxnVar2;
        zzcxn zzcxnVar3;
        zzcxn zzcxnVar4;
        zzdbi<?> zzdbiVar = (zzdbi) obj;
        synchronized (this.zzgkc) {
            zzcxtVar = this.zzgkc.zzgjs;
            zzdbiVar.zzgpc = ((zzbob) zzcxtVar.zzaog()).zzadc();
            i = this.zzgkc.zzgjw;
            if (i != zzcxm.zzgke) {
                zzdbbVar = this.zzgkc.zzgjq;
                zzdbbVar2 = this.zzgkc.zzgjq;
                zzcxnVar2 = this.zzgkc.zzgju;
                zzug zzugVar = zzcxnVar2.zzdio;
                zzcxnVar3 = this.zzgkc.zzgju;
                String str = zzcxnVar3.zzbqz;
                zzcxnVar4 = this.zzgkc.zzgju;
                zzdbbVar.zza(zzdbbVar2.zza(zzugVar, str, zzcxnVar4.zzgey), zzdbiVar);
            }
            i2 = this.zzgkc.zzgjw;
            if (i2 == zzcxm.zzgkd) {
                zzcxg zzcxgVar = this.zzgkc;
                zzcxnVar = this.zzgkc.zzgju;
                zzcxgVar.zza(zzcxnVar);
            }
            this.zzgkc.zzgjw = zzcxm.zzgkd;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
    }
}
