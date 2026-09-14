package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzwg extends zzaky<zzwg, zza> implements zzame {
    private static final zzwg zzc;
    private static volatile zzamp<zzwg> zzd;
    private int zze;
    private zzwj zzf;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzwg, zza> implements zzame {
        public final zza zza(zzwj zzwjVar) {
            zzh();
            zzwg.zza((zzwg) this.zza, zzwjVar);
            return this;
        }

        private zza() {
            super(zzwg.zzc);
        }
    }

    static {
        zzwg zzwgVar = new zzwg();
        zzc = zzwgVar;
        zzaky.zza((Class<zzwg>) zzwg.class, zzwgVar);
    }

    private zzwg() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public final zzwj zzc() {
        zzwj zzwjVar = this.zzf;
        if (zzwjVar == null) {
            return zzwj.zzf();
        }
        return zzwjVar;
    }

    public static zzwg zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzwg) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzwf.zza[i - 1]) {
            case 1:
                return new zzwg();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzwg> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzwg.class) {
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

    public static /* synthetic */ void zza(zzwg zzwgVar, zzwj zzwjVar) {
        zzwjVar.getClass();
        zzwgVar.zzf = zzwjVar;
        zzwgVar.zze |= 1;
    }
}
