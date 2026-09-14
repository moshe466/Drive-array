package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzwm extends zzaky<zzwm, zza> implements zzame {
    private static final zzwm zzc;
    private static volatile zzamp<zzwm> zzd;
    private int zze;
    private int zzf;
    private zzwp zzg;
    private zzajp zzh = zzajp.zza;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzwm, zza> implements zzame {
        public final zza zza(zzajp zzajpVar) {
            zzh();
            zzwm.zza((zzwm) this.zza, zzajpVar);
            return this;
        }

        private zza() {
            super(zzwm.zzc);
        }

        public final zza zza(zzwp zzwpVar) {
            zzh();
            zzwm.zza((zzwm) this.zza, zzwpVar);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzwm) this.zza).zzf = 0;
            return this;
        }
    }

    static {
        zzwm zzwmVar = new zzwm();
        zzc = zzwmVar;
        zzaky.zza((Class<zzwm>) zzwm.class, zzwmVar);
    }

    private zzwm() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamp<zzwm> zzf() {
        return (zzamp) zzc.zza(zzaky.zzf.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzwp zzd() {
        zzwp zzwpVar = this.zzg;
        if (zzwpVar == null) {
            return zzwp.zze();
        }
        return zzwpVar;
    }

    public final zzajp zze() {
        return this.zzh;
    }

    public static zzwm zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzwm) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzwl.zza[i - 1]) {
            case 1:
                return new zzwm();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzwm> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzwm.class) {
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

    public static /* synthetic */ void zza(zzwm zzwmVar, zzajp zzajpVar) {
        zzajpVar.getClass();
        zzwmVar.zzh = zzajpVar;
    }

    public static /* synthetic */ void zza(zzwm zzwmVar, zzwp zzwpVar) {
        zzwpVar.getClass();
        zzwmVar.zzg = zzwpVar;
        zzwmVar.zze |= 1;
    }
}
