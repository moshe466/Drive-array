package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzyc extends zzaky<zzyc, zza> implements zzame {
    private static final zzyc zzc;
    private static volatile zzamp<zzyc> zzd;
    private int zze;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzyc, zza> implements zzame {
        public final zza zza(int i) {
            zzh();
            ((zzyc) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzyc.zzc);
        }
    }

    static {
        zzyc zzycVar = new zzyc();
        zzc = zzycVar;
        zzaky.zza((Class<zzyc>) zzyc.class, zzycVar);
    }

    private zzyc() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzyc zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzye.zza[i - 1]) {
            case 1:
                return new zzyc();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzyc> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzyc.class) {
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
