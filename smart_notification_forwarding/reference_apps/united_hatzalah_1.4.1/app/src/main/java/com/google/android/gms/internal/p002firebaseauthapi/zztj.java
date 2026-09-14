package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zztj extends zzaky<zztj, zza> implements zzame {
    private static final zztj zzc;
    private static volatile zzamp<zztj> zzd;
    private int zze;
    private zztm zzf;
    private int zzg;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zztj, zza> implements zzame {
        public final zza zza(int i) {
            zzh();
            ((zztj) this.zza).zzg = i;
            return this;
        }

        private zza() {
            super(zztj.zzc);
        }

        public final zza zza(zztm zztmVar) {
            zzh();
            zztj.zza((zztj) this.zza, zztmVar);
            return this;
        }
    }

    static {
        zztj zztjVar = new zztj();
        zzc = zztjVar;
        zzaky.zza((Class<zztj>) zztj.class, zztjVar);
    }

    private zztj() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zztj zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzg;
    }

    public final zztm zze() {
        zztm zztmVar = this.zzf;
        if (zztmVar == null) {
            return zztm.zzd();
        }
        return zztmVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzti.zza[i - 1]) {
            case 1:
                return new zztj();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamp<zztj> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zztj.class) {
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

    public static /* synthetic */ void zza(zztj zztjVar, zztm zztmVar) {
        zztmVar.getClass();
        zztjVar.zzf = zztmVar;
        zztjVar.zze |= 1;
    }
}
