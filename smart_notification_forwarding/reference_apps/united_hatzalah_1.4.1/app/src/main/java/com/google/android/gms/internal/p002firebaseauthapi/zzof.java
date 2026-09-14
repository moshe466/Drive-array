package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzof<P> extends zzoc<P> implements zzcg<P> {
    public zzof(String str, Class<P> cls, zzamp<? extends zzamc> zzampVar) {
        super(str, cls, zzws.zza.ASYMMETRIC_PRIVATE, zzampVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcg
    public final zzws zzc(zzajp zzajpVar) {
        Object zza = zzpc.zza().zza((zzpc) zzqe.zza(this.zza, zzajpVar, this.zzb, zzxu.RAW, null), zzbj.zza());
        if (zza instanceof zzcd) {
            zzqe zzqeVar = (zzqe) zzpc.zza().zza(((zzcd) zza).zzc(), zzqe.class, zzbj.zza());
            return (zzws) ((zzaky) zzws.zza().zza(zzqeVar.zzf()).zza(zzqeVar.zzd()).zza(zzqeVar.zza()).zze());
        }
        throw new GeneralSecurityException("Key not private key");
    }
}
