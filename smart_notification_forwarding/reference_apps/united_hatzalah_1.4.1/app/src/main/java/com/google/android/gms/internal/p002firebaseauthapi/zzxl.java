package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;

/* loaded from: classes.dex */
public final class zzxl extends zzaky<zzxl, zza> implements zzame {
    private static final zzxl zzc;
    private static volatile zzamp<zzxl> zzd;
    private String zze = "";

    /* loaded from: classes.dex */
    public static final class zza extends zzaky.zza<zzxl, zza> implements zzame {
        public final zza zza(String str) {
            zzh();
            zzxl.zza((zzxl) this.zza, str);
            return this;
        }

        private zza() {
            super(zzxl.zzc);
        }
    }

    static {
        zzxl zzxlVar = new zzxl();
        zzc = zzxlVar;
        zzaky.zza((Class<zzxl>) zzxl.class, zzxlVar);
    }

    private zzxl() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzxl zzc() {
        return zzc;
    }

    public final String zzd() {
        return this.zze;
    }

    public static zzxl zza(zzajp zzajpVar, zzakk zzakkVar) {
        return (zzxl) zzaky.zza(zzc, zzajpVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzxk.zza[i - 1]) {
            case 1:
                return new zzxl();
            case 2:
                return new zza();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamp<zzxl> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzxl.class) {
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

    public static /* synthetic */ void zza(zzxl zzxlVar, String str) {
        str.getClass();
        zzxlVar.zze = str;
    }
}
