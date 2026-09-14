package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzta extends zzaky<zzta, zza> implements zzame {
    private static final zzta zzc;
    private static volatile zzamp<zzta> zzd;
    private int zze;
    private int zzf;
    private zztg zzg;
    private zzvs zzh;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzta, zza> implements zzame {
        public final zza zza(zztg zztgVar) {
            zzh();
            zzta.zza((zzta) this.zza, zztgVar);
            return this;
        }

        private zza() {
            super(zzta.zzc);
        }

        public final zza zza(zzvs zzvsVar) {
            zzh();
            zzta.zza((zzta) this.zza, zzvsVar);
            return this;
        }
    }

    static {
        zzta zztaVar = new zzta();
        zzc = zztaVar;
        zzaky.zza((Class<zzta>) zzta.class, zztaVar);
    }

    private zzta() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamp<zzta> zzf() {
        return (zzamp) zzc.zza(zzaky.zzf.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zztg zzd() {
        zztg zztgVar = this.zzg;
        if (zztgVar == null) {
            return zztg.zzd();
        }
        return zztgVar;
    }

    public final zzvs zze() {
        zzvs zzvsVar = this.zzh;
        if (zzvsVar == null) {
            return zzvs.zzd();
        }
        return zzvsVar;
    }

    public static zzta zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzta) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzsz.zza[i - 1]) {
            case 1:
                return new zzta();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzta> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzta.class) {
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

    public static /* synthetic */ void zza(zzta zztaVar, zztg zztgVar) {
        zztgVar.getClass();
        zztaVar.zzg = zztgVar;
        zztaVar.zze |= 1;
    }

    public static /* synthetic */ void zza(zzta zztaVar, zzvs zzvsVar) {
        zzvsVar.getClass();
        zztaVar.zzh = zzvsVar;
        zztaVar.zze |= 2;
    }
}
