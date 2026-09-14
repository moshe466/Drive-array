package com.google.android.recaptcha.internal;

import java.util.List;

/* loaded from: classes.dex */
public final class zztz extends zznd implements zzoj {
    private static final zztz zzb;
    private static volatile zzoq zzd;
    private zznk zze = zznd.zzB();

    static {
        zztz zztzVar = new zztz();
        zzb = zztzVar;
        zznd.zzI(zztz.class, zztzVar);
    }

    private zztz() {
    }

    public static zztz zzg(byte[] bArr) {
        return (zztz) zznd.zzx(zzb, bArr);
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoqVar;
        int i3 = i - 1;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    zzug zzugVar = null;
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                return null;
                            }
                            zzoq zzoqVar2 = zzd;
                            if (zzoqVar2 == null) {
                                synchronized (zztz.class) {
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
                    return new zzty(zzugVar);
                }
                return new zztz();
            }
            return zznd.zzF(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzuf.class});
        }
        return (byte) 1;
    }

    public final List zzi() {
        return this.zze;
    }
}
