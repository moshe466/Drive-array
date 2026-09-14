package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzue extends zzaky<zzue, zza> implements zzame {
    private static final zzue zzc;
    private static volatile zzamp<zzue> zzd;
    private int zze;
    private zzajp zzf = zzajp.zza;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzue, zza> implements zzame {
        public final zza zza(zzajp zzajpVar) {
            zzh();
            zzue.zza((zzue) this.zza, zzajpVar);
            return this;
        }

        private zza() {
            super(zzue.zzc);
        }
    }

    static {
        zzue zzueVar = new zzue();
        zzc = zzueVar;
        zzaky.zza((Class<zzue>) zzue.class, zzueVar);
    }

    private zzue() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamp<zzue> zze() {
        return (zzamp) zzc.zza(zzaky.zzf.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzajp zzd() {
        return this.zzf;
    }

    public static zzue zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzue) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzud.zza[i - 1]) {
            case 1:
                return new zzue();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzue> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzue.class) {
                    try {
                        zzampVar = zzd;
                        if (zzampVar == null) {
                            zzampVar = new zzaky.zzc(zzc);
                            zzd = zzampVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zzampVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    public static /* synthetic */ void zza(zzue zzueVar, zzajp zzajpVar) {
        zzajpVar.getClass();
        zzueVar.zzf = zzajpVar;
    }
}
