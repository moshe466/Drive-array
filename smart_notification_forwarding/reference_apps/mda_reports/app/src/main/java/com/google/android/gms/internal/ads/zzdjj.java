package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class zzdjj extends zzdih<zzdlr, zzdlo> {
    private final /* synthetic */ zzdjh zzgze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdjj(zzdjh zzdjhVar, Class cls) {
        super(cls);
        this.zzgze = zzdjhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ void zzc(zzdlr zzdlrVar) {
        zzdlr zzdlrVar2 = zzdlrVar;
        zzdpo.zzez(zzdlrVar2.getKeySize());
        if (zzdlrVar2.zzatq().zzatn() != 12 && zzdlrVar2.zzatq().zzatn() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdlo zzd(zzdlr zzdlrVar) {
        zzdlr zzdlrVar2 = zzdlrVar;
        return (zzdlo) zzdlo.zzatr().zzac(zzdqk.zzu(zzdpn.zzey(zzdlrVar2.getKeySize()))).zzb(zzdlrVar2.zzatq()).zzef(0).zzbaf();
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdlr zzq(zzdqk zzdqkVar) {
        return zzdlr.zzad(zzdqkVar);
    }
}
