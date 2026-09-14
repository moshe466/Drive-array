package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zztg extends zzaky<zztg, zza> implements zzame {
    private static final zztg zzc;
    private static volatile zzamp<zztg> zzd;
    private int zze;
    private int zzf;
    private zztm zzg;
    private zzajp zzh = zzajp.zza;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zztg, zza> implements zzame {
        public final zza zza(zzajp zzajpVar) {
            zzh();
            zztg.zza((zztg) this.zza, zzajpVar);
            return this;
        }

        private zza() {
            super(zztg.zzc);
        }

        public final zza zza(zztm zztmVar) {
            zzh();
            zztg.zza((zztg) this.zza, zztmVar);
            return this;
        }
    }

    static {
        zztg zztgVar = new zztg();
        zzc = zztgVar;
        zzaky.zza((Class<zztg>) zztg.class, zztgVar);
    }

    private zztg() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zztg zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zztm zze() {
        zztm zztmVar = this.zzg;
        if (zztmVar == null) {
            return zztm.zzd();
        }
        return zztmVar;
    }

    public final zzajp zzf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zztf.zza[i - 1]) {
            case 1:
                return new zztg();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamp<zztg> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zztg.class) {
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

    public static /* synthetic */ void zza(zztg zztgVar, zzajp zzajpVar) {
        zzajpVar.getClass();
        zztgVar.zzh = zzajpVar;
    }

    public static /* synthetic */ void zza(zztg zztgVar, zztm zztmVar) {
        zztmVar.getClass();
        zztgVar.zzg = zztmVar;
        zztgVar.zze |= 1;
    }
}
