package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzvs extends zzaky<zzvs, zza> implements zzame {
    private static final zzvs zzc;
    private static volatile zzamp<zzvs> zzd;
    private int zze;
    private int zzf;
    private zzvy zzg;
    private zzajp zzh = zzajp.zza;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzvs, zza> implements zzame {
        public final zza zza(zzajp zzajpVar) {
            zzh();
            zzvs.zza((zzvs) this.zza, zzajpVar);
            return this;
        }

        private zza() {
            super(zzvs.zzc);
        }

        public final zza zza(zzvy zzvyVar) {
            zzh();
            zzvs.zza((zzvs) this.zza, zzvyVar);
            return this;
        }
    }

    static {
        zzvs zzvsVar = new zzvs();
        zzc = zzvsVar;
        zzaky.zza((Class<zzvs>) zzvs.class, zzvsVar);
    }

    private zzvs() {
    }

    public static zzamp<zzvs> c_() {
        return (zzamp) zzc.zza(zzaky.zzf.zzg, (Object) null, (Object) null);
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzvs zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzvy zze() {
        zzvy zzvyVar = this.zzg;
        if (zzvyVar == null) {
            return zzvy.zze();
        }
        return zzvyVar;
    }

    public final zzajp zzf() {
        return this.zzh;
    }

    public static zzvs zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzvs) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzvu.zza[i - 1]) {
            case 1:
                return new zzvs();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzvs> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzvs.class) {
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

    public static /* synthetic */ void zza(zzvs zzvsVar, zzajp zzajpVar) {
        zzajpVar.getClass();
        zzvsVar.zzh = zzajpVar;
    }

    public static /* synthetic */ void zza(zzvs zzvsVar, zzvy zzvyVar) {
        zzvyVar.getClass();
        zzvsVar.zzg = zzvyVar;
        zzvsVar.zze |= 1;
    }
}
