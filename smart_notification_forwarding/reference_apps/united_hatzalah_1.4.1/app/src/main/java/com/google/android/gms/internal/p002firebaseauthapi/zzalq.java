package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzalq implements zzamu {
    private static final zzamd zza = new zzalt();
    private final zzamd zzb;

    public zzalq() {
        this(new zzalv(zzakw.zza(), zza));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamu
    public final <T> zzamv<T> zza(Class<T> cls) {
        zzakm<?> zzakmVar;
        zzamx.zza((Class<?>) cls);
        zzama zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            return zzami.zza(zzamx.zza(), zzako.zza(), zza2.zza());
        }
        zzamk zza3 = zzamm.zza();
        zzalm zza4 = zzalo.zza();
        zzano<?, ?> zza5 = zzamx.zza();
        if (zzals.zza[zza2.zzb().ordinal()] != 1) {
            zzakmVar = zzako.zza();
        } else {
            zzakmVar = null;
        }
        return zzamg.zza(cls, zza2, zza3, zza4, zza5, zzakmVar, zzamb.zza());
    }

    private zzalq(zzamd zzamdVar) {
        this.zzb = (zzamd) zzalb.zza(zzamdVar, "messageInfoFactory");
    }
}
