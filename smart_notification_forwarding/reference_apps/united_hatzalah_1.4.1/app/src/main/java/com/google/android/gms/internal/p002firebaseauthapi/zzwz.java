package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

@Deprecated
/* loaded from: classes.dex */
public final class zzwz extends zzaky<zzwz, zza> implements zzame {
    private static final zzwz zzc;
    private static volatile zzamp<zzwz> zzd;
    private int zzg;
    private boolean zzh;
    private String zze = "";
    private String zzf = "";
    private String zzi = "";

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzwz, zza> implements zzame {
        private zza() {
            super(zzwz.zzc);
        }
    }

    static {
        zzwz zzwzVar = new zzwz();
        zzc = zzwzVar;
        zzaky.zza((Class<zzwz>) zzwz.class, zzwzVar);
    }

    private zzwz() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzwy.zza[i - 1]) {
            case 1:
                return new zzwz();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzwz> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzwz.class) {
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
