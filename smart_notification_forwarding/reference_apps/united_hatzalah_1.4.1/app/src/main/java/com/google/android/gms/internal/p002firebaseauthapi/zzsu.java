package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzsu extends zzaky<zzsu, zza> implements zzame {
    private static final zzsu zzc;
    private static volatile zzamp<zzsu> zzd;
    private int zze;
    private int zzf;
    private zzsx zzg;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzsu, zza> implements zzame {
        public final zza zza(int i) {
            zzh();
            ((zzsu) this.zza).zzf = i;
            return this;
        }

        private zza() {
            super(zzsu.zzc);
        }

        public final zza zza(zzsx zzsxVar) {
            zzh();
            zzsu.zza((zzsu) this.zza, zzsxVar);
            return this;
        }
    }

    static {
        zzsu zzsuVar = new zzsu();
        zzc = zzsuVar;
        zzaky.zza((Class<zzsu>) zzsu.class, zzsuVar);
    }

    private zzsu() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzsx zzd() {
        zzsx zzsxVar = this.zzg;
        if (zzsxVar == null) {
            return zzsx.zzd();
        }
        return zzsxVar;
    }

    public static zzsu zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzsu) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzst.zza[i - 1]) {
            case 1:
                return new zzsu();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzsu> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzsu.class) {
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

    public static /* synthetic */ void zza(zzsu zzsuVar, zzsx zzsxVar) {
        zzsxVar.getClass();
        zzsuVar.zzg = zzsxVar;
        zzsuVar.zze |= 1;
    }
}
