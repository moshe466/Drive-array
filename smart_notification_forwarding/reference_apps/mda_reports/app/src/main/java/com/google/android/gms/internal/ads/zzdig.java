package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdte;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class zzdig<PrimitiveT, KeyProtoT extends zzdte> implements zzdid<PrimitiveT> {
    private final zzdii<KeyProtoT> zzgxt;
    private final Class<PrimitiveT> zzgxu;

    public zzdig(zzdii<KeyProtoT> zzdiiVar, Class<PrimitiveT> cls) {
        if (!zzdiiVar.zzase().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzdiiVar.toString(), cls.getName()));
        }
        this.zzgxt = zzdiiVar;
        this.zzgxu = cls;
    }

    private final zzdif<?, KeyProtoT> zzasa() {
        return new zzdif<>(this.zzgxt.zzasg());
    }

    private final PrimitiveT zzb(KeyProtoT keyprotot) {
        if (Void.class.equals(this.zzgxu)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.zzgxt.zze(keyprotot);
        return (PrimitiveT) this.zzgxt.zza(keyprotot, this.zzgxu);
    }

    @Override // com.google.android.gms.internal.ads.zzdid
    public final String getKeyType() {
        return this.zzgxt.getKeyType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdid
    public final PrimitiveT zza(zzdte zzdteVar) {
        String valueOf = String.valueOf(this.zzgxt.zzasc().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (this.zzgxt.zzasc().isInstance(zzdteVar)) {
            return zzb(zzdteVar);
        }
        throw new GeneralSecurityException(concat);
    }

    @Override // com.google.android.gms.internal.ads.zzdid
    public final Class<PrimitiveT> zzarz() {
        return this.zzgxu;
    }

    @Override // com.google.android.gms.internal.ads.zzdid
    public final PrimitiveT zzm(zzdqk zzdqkVar) {
        try {
            return zzb(this.zzgxt.zzr(zzdqkVar));
        } catch (zzdse e) {
            String valueOf = String.valueOf(this.zzgxt.zzasc().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdid
    public final zzdte zzn(zzdqk zzdqkVar) {
        try {
            return zzasa().a(zzdqkVar);
        } catch (zzdse e) {
            String valueOf = String.valueOf(this.zzgxt.zzasg().zzasb().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdid
    public final zzdna zzo(zzdqk zzdqkVar) {
        try {
            return (zzdna) ((zzdrt) zzdna.zzavl().zzhb(this.zzgxt.getKeyType()).zzaw(zzasa().a(zzdqkVar).zzaxk()).zzb(this.zzgxt.zzasd()).zzbaf());
        } catch (zzdse e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
