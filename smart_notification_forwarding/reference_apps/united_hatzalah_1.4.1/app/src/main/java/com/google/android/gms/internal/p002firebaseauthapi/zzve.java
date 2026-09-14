package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzve extends zzaky<zzve, zza> implements zzame {
    private static final zzve zzc;
    private static volatile zzamp<zzve> zzd;
    private int zze;
    private int zzf;
    private zzvh zzg;
    private zzajp zzh = zzajp.zza;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzve, zza> implements zzame {
        public final zza zza(zzajp zzajpVar) {
            zzh();
            zzve.zza((zzve) this.zza, zzajpVar);
            return this;
        }

        private zza() {
            super(zzve.zzc);
        }

        public final zza zza(zzvh zzvhVar) {
            zzh();
            zzve.zza((zzve) this.zza, zzvhVar);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzve) this.zza).zzf = 0;
            return this;
        }
    }

    static {
        zzve zzveVar = new zzve();
        zzc = zzveVar;
        zzaky.zza((Class<zzve>) zzve.class, zzveVar);
    }

    private zzve() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamp<zzve> zzf() {
        return (zzamp) zzc.zza(zzaky.zzf.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzvh zzd() {
        zzvh zzvhVar = this.zzg;
        if (zzvhVar == null) {
            return zzvh.zze();
        }
        return zzvhVar;
    }

    public final zzajp zze() {
        return this.zzh;
    }

    public static zzve zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzve) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzvg.zza[i - 1]) {
            case 1:
                return new zzve();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzve> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzve.class) {
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

    public static /* synthetic */ void zza(zzve zzveVar, zzajp zzajpVar) {
        zzajpVar.getClass();
        zzveVar.zzh = zzajpVar;
    }

    public static /* synthetic */ void zza(zzve zzveVar, zzvh zzvhVar) {
        zzvhVar.getClass();
        zzveVar.zzg = zzvhVar;
        zzveVar.zze |= 1;
    }
}
