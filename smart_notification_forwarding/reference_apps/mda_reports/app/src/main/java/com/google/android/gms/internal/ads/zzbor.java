package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbor implements zzdxg<zzato> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzczl> zzfda;
    private final zzboo zzfhm;
    private final zzdxp<zzazb> zzfhn;
    private final zzdxp<zzatq> zzfho;

    private zzbor(zzboo zzbooVar, zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<zzczl> zzdxpVar3, zzdxp<zzatq> zzdxpVar4) {
        this.zzfhm = zzbooVar;
        this.zzejv = zzdxpVar;
        this.zzfhn = zzdxpVar2;
        this.zzfda = zzdxpVar3;
        this.zzfho = zzdxpVar4;
    }

    public static zzbor zza(zzboo zzbooVar, zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<zzczl> zzdxpVar3, zzdxp<zzatq> zzdxpVar4) {
        return new zzbor(zzbooVar, zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        Context context = this.zzejv.get();
        zzazb zzazbVar = this.zzfhn.get();
        zzczl zzczlVar = this.zzfda.get();
        zzatq zzatqVar = this.zzfho.get();
        zzatn zzatnVar = zzczlVar.zzgls;
        if (zzatnVar != null) {
            return new zzatf(context, zzazbVar, zzatnVar, zzczlVar.zzglo.zzdhr, zzatqVar);
        }
        return null;
    }
}
