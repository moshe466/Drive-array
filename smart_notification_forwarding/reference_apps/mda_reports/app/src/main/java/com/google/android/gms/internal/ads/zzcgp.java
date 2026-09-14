package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
final class zzcgp implements zzbqx {
    private final zzatv zzbng;
    private final Context zzup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcgp(Context context, zzatv zzatvVar) {
        this.zzup = context;
        this.zzbng = zzatvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzaqk zzaqkVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzczt zzcztVar) {
        if (TextUtils.isEmpty(zzcztVar.zzgmi.zzgmf.zzdlk)) {
            return;
        }
        this.zzbng.zza(this.zzup, zzcztVar.zzgmh.zzfgl.zzgml);
        this.zzbng.zzj(this.zzup, zzcztVar.zzgmi.zzgmf.zzdlk);
    }
}
