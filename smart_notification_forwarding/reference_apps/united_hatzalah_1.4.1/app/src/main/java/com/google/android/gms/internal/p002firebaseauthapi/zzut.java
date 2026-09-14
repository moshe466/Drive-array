package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzut extends zzaky<zzut, zza> implements zzame {
    private static final zzut zzc;
    private static volatile zzamp<zzut> zzd;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzut, zza> implements zzame {
        private zza() {
            super(zzut.zzc);
        }
    }

    static {
        zzut zzutVar = new zzut();
        zzc = zzutVar;
        zzaky.zza((Class<zzut>) zzut.class, zzutVar);
    }

    private zzut() {
    }

    public static zzut zzb() {
        return zzc;
    }

    public static zzut zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzut) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzus.zza[i - 1]) {
            case 1:
                return new zzut();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzc;
            case 5:
                zzamp<zzut> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzut.class) {
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
