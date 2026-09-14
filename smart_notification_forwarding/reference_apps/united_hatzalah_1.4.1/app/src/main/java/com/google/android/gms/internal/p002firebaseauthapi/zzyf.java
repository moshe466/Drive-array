package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzyf extends zzaky<zzyf, zza> implements zzame {
    private static final zzyf zzc;
    private static volatile zzamp<zzyf> zzd;
    private int zze;
    private zzajp zzf = zzajp.zza;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzyf, zza> implements zzame {
        public final zza zza(zzajp zzajpVar) {
            zzh();
            zzyf.zza((zzyf) this.zza, zzajpVar);
            return this;
        }

        private zza() {
            super(zzyf.zzc);
        }
    }

    static {
        zzyf zzyfVar = new zzyf();
        zzc = zzyfVar;
        zzaky.zza((Class<zzyf>) zzyf.class, zzyfVar);
    }

    private zzyf() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamp<zzyf> zze() {
        return (zzamp) zzc.zza(zzaky.zzf.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzajp zzd() {
        return this.zzf;
    }

    public static zzyf zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzyf) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzyh.zza[i - 1]) {
            case 1:
                return new zzyf();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzyf> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzyf.class) {
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

    public static /* synthetic */ void zza(zzyf zzyfVar, zzajp zzajpVar) {
        zzajpVar.getClass();
        zzyfVar.zzf = zzajpVar;
    }
}
