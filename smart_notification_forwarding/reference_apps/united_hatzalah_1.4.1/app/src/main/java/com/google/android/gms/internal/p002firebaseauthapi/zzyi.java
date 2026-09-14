package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzyi extends zzaky<zzyi, zza> implements zzame {
    private static final zzyi zzc;
    private static volatile zzamp<zzyi> zzd;
    private int zze;

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzyi, zza> implements zzame {
        private zza() {
            super(zzyi.zzc);
        }
    }

    static {
        zzyi zzyiVar = new zzyi();
        zzc = zzyiVar;
        zzaky.zza((Class<zzyi>) zzyi.class, zzyiVar);
    }

    private zzyi() {
    }

    public static zzyi zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public static zzyi zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzyi) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzyk.zza[i - 1]) {
            case 1:
                return new zzyi();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzyi> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzyi.class) {
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
