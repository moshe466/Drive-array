package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzsm extends zznd implements zzoj {
    private static final zzsm zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";

    static {
        zzsm zzsmVar = new zzsm();
        zzb = zzsmVar;
        zznd.zzI(zzsm.class, zzsmVar);
    }

    private zzsm() {
    }

    public static zzsl zzf() {
        return (zzsl) zzb.zzq();
    }

    public static /* synthetic */ void zzi(zzsm zzsmVar, String str) {
        str.getClass();
        zzsmVar.zze |= 1;
        zzsmVar.zzf = str;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoqVar;
        int i3 = i - 1;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                return null;
                            }
                            zzoq zzoqVar2 = zzd;
                            if (zzoqVar2 == null) {
                                synchronized (zzsm.class) {
                                    try {
                                        zzoqVar = zzd;
                                        if (zzoqVar == null) {
                                            zzoqVar = new zzmy(zzb);
                                            zzd = zzoqVar;
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                return zzoqVar;
                            }
                            return zzoqVar2;
                        }
                        return zzb;
                    }
                    return new zzsl(null);
                }
                return new zzsm();
            }
            return zznd.zzF(zzb, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ለ\u0000", new Object[]{"zze", "zzf"});
        }
        return (byte) 1;
    }
}
