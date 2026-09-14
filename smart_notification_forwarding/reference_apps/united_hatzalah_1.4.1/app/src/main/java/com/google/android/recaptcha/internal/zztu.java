package com.google.android.recaptcha.internal;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class zztu extends zznd implements zzoj {
    private static final zztu zzb;
    private static volatile zzoq zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zztu zztuVar = new zztu();
        zzb = zztuVar;
        zznd.zzI(zztu.class, zztuVar);
    }

    private zztu() {
    }

    public static zztu zzg(InputStream inputStream) {
        return (zztu) zznd.zzw(zzb, inputStream);
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
                                synchronized (zztu.class) {
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
                    return new zztt(null);
                }
                return new zztu();
            }
            return zznd.zzF(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }

    public final zztv zzi() {
        zztv zzb2 = zztv.zzb(this.zzg);
        return zzb2 == null ? zztv.UNRECOGNIZED : zzb2;
    }
}
