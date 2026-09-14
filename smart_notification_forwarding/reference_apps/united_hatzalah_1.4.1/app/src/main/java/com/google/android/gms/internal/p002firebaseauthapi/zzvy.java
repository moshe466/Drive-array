package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzvy extends zzaky<zzvy, zza> implements zzame {
    private static final zzvy zzc;
    private static volatile zzamp<zzvy> zzd;
    private int zze;
    private int zzf;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzvy, zza> implements zzame {
        public final zza zza(zzvt zzvtVar) {
            zzh();
            zzvy.zza((zzvy) this.zza, zzvtVar);
            return this;
        }

        private zza() {
            super(zzvy.zzc);
        }

        public final zza zza(int i) {
            zzh();
            ((zzvy) this.zza).zzf = i;
            return this;
        }
    }

    static {
        zzvy zzvyVar = new zzvy();
        zzc = zzvyVar;
        zzaky.zza((Class<zzvy>) zzvy.class, zzvyVar);
    }

    private zzvy() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzvy zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzvt zzb() {
        zzvt zza2 = zzvt.zza(this.zze);
        if (zza2 == null) {
            return zzvt.UNRECOGNIZED;
        }
        return zza2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzwa.zza[i - 1]) {
            case 1:
                return new zzvy();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzvy> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzvy.class) {
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

    public static /* synthetic */ void zza(zzvy zzvyVar, zzvt zzvtVar) {
        zzvyVar.zze = zzvtVar.zza();
    }
}
