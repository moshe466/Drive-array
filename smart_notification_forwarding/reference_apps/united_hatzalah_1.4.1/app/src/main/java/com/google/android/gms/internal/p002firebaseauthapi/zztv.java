package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zztv extends zzaky<zztv, zza> implements zzame {
    private static final zztv zzc;
    private static volatile zzamp<zztv> zzd;
    private int zze;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zztv, zza> implements zzame {
        public final zza zza(int i) {
            zzh();
            ((zztv) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zztv.zzc);
        }
    }

    static {
        zztv zztvVar = new zztv();
        zzc = zztvVar;
        zzaky.zza((Class<zztv>) zztv.class, zztvVar);
    }

    private zztv() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zztv zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zztu.zza[i - 1]) {
            case 1:
                return new zztv();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamp<zztv> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zztv.class) {
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
}
