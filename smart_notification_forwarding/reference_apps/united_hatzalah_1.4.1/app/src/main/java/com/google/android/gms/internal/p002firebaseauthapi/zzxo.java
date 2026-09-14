package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzxo extends zzaky<zzxo, zza> implements zzame {
    private static final zzxo zzc;
    private static volatile zzamp<zzxo> zzd;
    private int zze;
    private int zzf;
    private zzxr zzg;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzxo, zza> implements zzame {
        public final zza zza(zzxr zzxrVar) {
            zzh();
            zzxo.zza((zzxo) this.zza, zzxrVar);
            return this;
        }

        private zza() {
            super(zzxo.zzc);
        }
    }

    static {
        zzxo zzxoVar = new zzxo();
        zzc = zzxoVar;
        zzaky.zza((Class<zzxo>) zzxo.class, zzxoVar);
    }

    private zzxo() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamp<zzxo> zze() {
        return (zzamp) zzc.zza(zzaky.zzf.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzxr zzd() {
        zzxr zzxrVar = this.zzg;
        if (zzxrVar == null) {
            return zzxr.zzd();
        }
        return zzxrVar;
    }

    public static zzxo zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzxo) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzxn.zza[i - 1]) {
            case 1:
                return new zzxo();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzxo> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzxo.class) {
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

    public static /* synthetic */ void zza(zzxo zzxoVar, zzxr zzxrVar) {
        zzxrVar.getClass();
        zzxoVar.zzg = zzxrVar;
        zzxoVar.zze |= 1;
    }
}
