package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzwj extends zzaky<zzwj, zza> implements zzame {
    private static final zzwj zzc;
    private static volatile zzamp<zzwj> zzd;
    private int zze;
    private int zzf;
    private int zzg;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzwj, zza> implements zzame {
        public final zza zza(zzwb zzwbVar) {
            zzh();
            zzwj.zza((zzwj) this.zza, zzwbVar);
            return this;
        }

        private zza() {
            super(zzwj.zzc);
        }

        public final zza zza(zzwe zzweVar) {
            zzh();
            zzwj.zza((zzwj) this.zza, zzweVar);
            return this;
        }

        public final zza zza(zzwd zzwdVar) {
            zzh();
            zzwj.zza((zzwj) this.zza, zzwdVar);
            return this;
        }
    }

    static {
        zzwj zzwjVar = new zzwj();
        zzc = zzwjVar;
        zzaky.zza((Class<zzwj>) zzwj.class, zzwjVar);
    }

    private zzwj() {
    }

    public static zza zzd() {
        return (zza) zzc.zzm();
    }

    public static zzwj zzf() {
        return zzc;
    }

    public final zzwb zza() {
        zzwb zza2 = zzwb.zza(this.zzg);
        return zza2 == null ? zzwb.UNRECOGNIZED : zza2;
    }

    public final zzwe zzb() {
        zzwe zza2 = zzwe.zza(this.zzf);
        if (zza2 == null) {
            return zzwe.UNRECOGNIZED;
        }
        return zza2;
    }

    public final zzwd zzc() {
        zzwd zza2 = zzwd.zza(this.zze);
        if (zza2 == null) {
            return zzwd.UNRECOGNIZED;
        }
        return zza2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzwi.zza[i - 1]) {
            case 1:
                return new zzwj();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzwj> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzwj.class) {
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

    public static /* synthetic */ void zza(zzwj zzwjVar, zzwb zzwbVar) {
        zzwjVar.zzg = zzwbVar.zza();
    }

    public static /* synthetic */ void zza(zzwj zzwjVar, zzwe zzweVar) {
        zzwjVar.zzf = zzweVar.zza();
    }

    public static /* synthetic */ void zza(zzwj zzwjVar, zzwd zzwdVar) {
        zzwjVar.zze = zzwdVar.zza();
    }
}
