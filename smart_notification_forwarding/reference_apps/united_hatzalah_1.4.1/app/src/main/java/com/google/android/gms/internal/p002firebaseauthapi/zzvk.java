package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzvk extends zzaky<zzvk, zza> implements zzame {
    private static final zzvk zzc;
    private static volatile zzamp<zzvk> zzd;
    private int zze;
    private int zzf;
    private zzajp zzg = zzajp.zza;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzvk, zza> implements zzame {
        public final zza zza(zzvn zzvnVar) {
            zzh();
            zzvk.zza((zzvk) this.zza, zzvnVar);
            return this;
        }

        private zza() {
            super(zzvk.zzc);
        }

        public final zza zza(zzvt zzvtVar) {
            zzh();
            zzvk.zza((zzvk) this.zza, zzvtVar);
            return this;
        }

        public final zza zza(zzajp zzajpVar) {
            zzh();
            zzvk.zza((zzvk) this.zza, zzajpVar);
            return this;
        }
    }

    static {
        zzvk zzvkVar = new zzvk();
        zzc = zzvkVar;
        zzaky.zza((Class<zzvk>) zzvk.class, zzvkVar);
    }

    private zzvk() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvk zzc() {
        return zzc;
    }

    public final zzvn zzd() {
        zzvn zza2 = zzvn.zza(this.zze);
        if (zza2 == null) {
            return zzvn.UNRECOGNIZED;
        }
        return zza2;
    }

    public final zzvt zze() {
        zzvt zza2 = zzvt.zza(this.zzf);
        if (zza2 == null) {
            return zzvt.UNRECOGNIZED;
        }
        return zza2;
    }

    public final zzajp zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzvm.zza[i - 1]) {
            case 1:
                return new zzvk();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzvk> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzvk.class) {
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

    public static /* synthetic */ void zza(zzvk zzvkVar, zzvn zzvnVar) {
        zzvkVar.zze = zzvnVar.zza();
    }

    public static /* synthetic */ void zza(zzvk zzvkVar, zzvt zzvtVar) {
        zzvkVar.zzf = zzvtVar.zza();
    }

    public static /* synthetic */ void zza(zzvk zzvkVar, zzajp zzajpVar) {
        zzajpVar.getClass();
        zzvkVar.zzg = zzajpVar;
    }
}
