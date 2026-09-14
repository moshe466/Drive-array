package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

@Deprecated
/* loaded from: classes.dex */
public final class zzxt extends zzaky<zzxt, zza> implements zzame {
    private static final zzxt zzc;
    private static volatile zzamp<zzxt> zzd;
    private String zze = "";
    private zzalc<zzwz> zzf = zzaky.zzp();

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzxt, zza> implements zzame {
        private zza() {
            super(zzxt.zzc);
        }
    }

    static {
        zzxt zzxtVar = new zzxt();
        zzc = zzxtVar;
        zzaky.zza((Class<zzxt>) zzxt.class, zzxtVar);
    }

    private zzxt() {
    }

    public static zzxt zzb() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzxv.zza[i - 1]) {
            case 1:
                return new zzxt();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzwz.class});
            case 4:
                return zzc;
            case 5:
                zzamp<zzxt> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzxt.class) {
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
}
