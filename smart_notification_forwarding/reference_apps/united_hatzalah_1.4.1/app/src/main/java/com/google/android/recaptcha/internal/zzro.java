package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzro extends zznd implements zzoj {
    private static final zzro zzb;
    private static volatile zzoq zzd;
    private int zze;
    private zzqt zzg;
    private zzqk zzh;
    private zzqw zzi;
    private String zzf = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzro zzroVar = new zzro();
        zzb = zzroVar;
        zznd.zzI(zzro.class, zzroVar);
    }

    private zzro() {
    }

    public static zzrm zzf() {
        return (zzrm) zzb.zzq();
    }

    public static /* synthetic */ void zzi(zzro zzroVar, zzqk zzqkVar) {
        zzqkVar.getClass();
        zzroVar.zzh = zzqkVar;
        zzroVar.zze |= 2;
    }

    public static /* synthetic */ void zzj(zzro zzroVar, String str) {
        str.getClass();
        zzroVar.zzk = str;
    }

    public static /* synthetic */ void zzk(zzro zzroVar, String str) {
        str.getClass();
        zzroVar.zzj = str;
    }

    public static /* synthetic */ void zzl(zzro zzroVar, String str) {
        str.getClass();
        zzroVar.zzf = str;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoqVar;
        int i3 = i - 1;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    zzrn zzrnVar = null;
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                return null;
                            }
                            zzoq zzoqVar2 = zzd;
                            if (zzoqVar2 == null) {
                                synchronized (zzro.class) {
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
                    return new zzrm(zzrnVar);
                }
                return new zzro();
            }
            return zznd.zzF(zzb, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005Ȉ\u0006Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        return (byte) 1;
    }
}
