package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzrv extends zznd implements zzoj {
    private static final zzrv zzb;
    private static volatile zzoq zzd;
    private int zze;
    private zzrt zzf;
    private zzrt zzg;

    static {
        zzrv zzrvVar = new zzrv();
        zzb = zzrvVar;
        zznd.zzI(zzrv.class, zzrvVar);
    }

    private zzrv() {
    }

    public static zzrv zzj(byte[] bArr) {
        return (zzrv) zznd.zzx(zzb, bArr);
    }

    public final zzrt zzf() {
        zzrt zzrtVar = this.zzf;
        if (zzrtVar == null) {
            return zzrt.zzg();
        }
        return zzrtVar;
    }

    public final zzrt zzg() {
        zzrt zzrtVar = this.zzg;
        if (zzrtVar == null) {
            return zzrt.zzg();
        }
        return zzrtVar;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoqVar;
        int i3 = i - 1;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    zzrw zzrwVar = null;
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                return null;
                            }
                            zzoq zzoqVar2 = zzd;
                            if (zzoqVar2 == null) {
                                synchronized (zzrv.class) {
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
                    return new zzru(zzrwVar);
                }
                return new zzrv();
            }
            return zznd.zzF(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
