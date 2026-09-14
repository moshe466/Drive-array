package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzth extends zznd implements zzoj {
    private static final zzth zzb;
    private static volatile zzoq zzd;
    private int zze = 0;
    private Object zzf;

    static {
        zzth zzthVar = new zzth();
        zzb = zzthVar;
        zznd.zzI(zzth.class, zzthVar);
    }

    private zzth() {
    }

    public static /* synthetic */ void zzM(zzth zzthVar, float f4) {
        zzthVar.zze = 9;
        zzthVar.zzf = Float.valueOf(f4);
    }

    public static /* synthetic */ void zzN(zzth zzthVar, int i) {
        zzthVar.zze = 4;
        zzthVar.zzf = Integer.valueOf(i);
    }

    public static /* synthetic */ void zzO(zzth zzthVar, int i) {
        zzthVar.zze = 5;
        zzthVar.zzf = Integer.valueOf(i);
    }

    public static /* synthetic */ void zzP(zzth zzthVar, long j2) {
        zzthVar.zze = 7;
        zzthVar.zzf = Long.valueOf(j2);
    }

    public static /* synthetic */ void zzQ(zzth zzthVar, String str) {
        str.getClass();
        zzthVar.zze = 11;
        zzthVar.zzf = str;
    }

    public static zztg zzf() {
        return (zztg) zzb.zzq();
    }

    public static /* synthetic */ void zzi(zzth zzthVar, boolean z3) {
        zzthVar.zze = 1;
        zzthVar.zzf = Boolean.valueOf(z3);
    }

    public static /* synthetic */ void zzj(zzth zzthVar, zzle zzleVar) {
        zzthVar.zze = 2;
        zzthVar.zzf = zzleVar;
    }

    public static /* synthetic */ void zzk(zzth zzthVar, String str) {
        str.getClass();
        zzthVar.zze = 3;
        zzthVar.zzf = str;
    }

    public static /* synthetic */ void zzl(zzth zzthVar, double d2) {
        zzthVar.zze = 10;
        zzthVar.zzf = Double.valueOf(d2);
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoqVar;
        int i3 = i - 1;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    zztj zztjVar = null;
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                return null;
                            }
                            zzoq zzoqVar2 = zzd;
                            if (zzoqVar2 == null) {
                                synchronized (zzth.class) {
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
                    return new zztg(zztjVar);
                }
                return new zzth();
            }
            return zznd.zzF(zzb, "\u0000\u000b\u0001\u0000\u0001\u000b\u000b\u0000\u0000\u0000\u0001:\u0000\u0002=\u0000\u0003Ȼ\u0000\u0004B\u0000\u0005B\u0000\u0006>\u0000\u0007C\u0000\b6\u0000\t4\u0000\n3\u0000\u000bȻ\u0000", new Object[]{"zzf", "zze"});
        }
        return (byte) 1;
    }
}
