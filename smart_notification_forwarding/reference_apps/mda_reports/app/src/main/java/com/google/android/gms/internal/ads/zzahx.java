package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzahx extends zzbfk {
    private final /* synthetic */ zzahr zzcys;

    private zzahx(zzahr zzahrVar) {
        this.zzcys = zzahrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zza(zzbfn zzbfnVar) {
        if (zzahr.a(this.zzcys) != null) {
            zzahr.a(this.zzcys).zzsa();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zzb(zzbfn zzbfnVar) {
        this.zzcys.zzg(zzbfnVar.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final boolean zzc(zzbfn zzbfnVar) {
        return this.zzcys.zzg(zzbfnVar.uri);
    }
}
