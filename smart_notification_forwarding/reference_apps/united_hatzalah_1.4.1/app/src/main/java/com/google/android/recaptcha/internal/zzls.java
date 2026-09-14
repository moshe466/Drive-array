package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzls extends zzna implements zzoj {
    private static final zzls zzd;
    private static volatile zzoq zze;
    private int zzf;
    private boolean zzg;
    private zzma zzh;
    private boolean zzi;
    private zzmc zzj;
    private byte zzl = 2;
    private zznk zzk = zzot.zze();

    static {
        zzls zzlsVar = new zzls();
        zzd = zzlsVar;
        zznd.zzI(zzls.class, zzlsVar);
    }

    private zzls() {
    }

    public static zzls zzg() {
        return zzd;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoqVar;
        byte b4;
        int i3 = i - 1;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (obj == null) {
                                    b4 = 0;
                                } else {
                                    b4 = 1;
                                }
                                this.zzl = b4;
                                return null;
                            }
                            zzoq zzoqVar2 = zze;
                            if (zzoqVar2 == null) {
                                synchronized (zzls.class) {
                                    try {
                                        zzoqVar = zze;
                                        if (zzoqVar == null) {
                                            zzoqVar = new zzmy(zzd);
                                            zze = zzoqVar;
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                return zzoqVar;
                            }
                            return zzoqVar2;
                        }
                        return zzd;
                    }
                    return new zzlr(null);
                }
                return new zzls();
            }
            return new zzou(zzd, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002\u0004ဉ\u0003ϧЛ", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzmg.class});
        }
        return Byte.valueOf(this.zzl);
    }
}
