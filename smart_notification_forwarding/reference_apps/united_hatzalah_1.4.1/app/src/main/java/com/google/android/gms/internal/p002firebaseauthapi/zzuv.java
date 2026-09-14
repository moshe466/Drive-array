package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzuv extends zzaky<zzuv, zza> implements zzame {
    private static final zzuv zzc;
    private static volatile zzamp<zzuv> zzd;
    private int zze;
    private zzww zzf;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzuv, zza> implements zzame {
        public final zza zza(zzww zzwwVar) {
            zzh();
            zzuv.zza((zzuv) this.zza, zzwwVar);
            return this;
        }

        private zza() {
            super(zzuv.zzc);
        }
    }

    static {
        zzuv zzuvVar = new zzuv();
        zzc = zzuvVar;
        zzaky.zza((Class<zzuv>) zzuv.class, zzuvVar);
    }

    private zzuv() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzuv zzc() {
        return zzc;
    }

    public final zzww zzd() {
        zzww zzwwVar = this.zzf;
        if (zzwwVar == null) {
            return zzww.zzc();
        }
        return zzwwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzux.zza[i - 1]) {
            case 1:
                return new zzuv();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzuv> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzuv.class) {
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

    public static /* synthetic */ void zza(zzuv zzuvVar, zzww zzwwVar) {
        zzwwVar.getClass();
        zzuvVar.zzf = zzwwVar;
        zzuvVar.zze |= 1;
    }
}
