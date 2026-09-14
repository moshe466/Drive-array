package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzvv extends zzaky<zzvv, zza> implements zzame {
    private static final zzvv zzc;
    private static volatile zzamp<zzvv> zzd;
    private int zze;
    private zzvy zzf;
    private int zzg;
    private int zzh;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzvv, zza> implements zzame {
        public final zza zza(int i) {
            zzh();
            ((zzvv) this.zza).zzg = i;
            return this;
        }

        private zza() {
            super(zzvv.zzc);
        }

        public final zza zza(zzvy zzvyVar) {
            zzh();
            zzvv.zza((zzvv) this.zza, zzvyVar);
            return this;
        }
    }

    static {
        zzvv zzvvVar = new zzvv();
        zzc = zzvvVar;
        zzaky.zza((Class<zzvv>) zzvv.class, zzvvVar);
    }

    private zzvv() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzvv zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzg;
    }

    public final int zzb() {
        return this.zzh;
    }

    public final zzvy zzf() {
        zzvy zzvyVar = this.zzf;
        if (zzvyVar == null) {
            return zzvy.zze();
        }
        return zzvyVar;
    }

    public static zzvv zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzvv) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzvx.zza[i - 1]) {
            case 1:
                return new zzvv();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzvv> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzvv.class) {
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

    public static /* synthetic */ void zza(zzvv zzvvVar, zzvy zzvyVar) {
        zzvyVar.getClass();
        zzvvVar.zzf = zzvyVar;
        zzvvVar.zze |= 1;
    }
}
