package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzti extends zznd implements zzoj {
    private static final zzti zzb;
    private static volatile zzoq zzd;
    private zznk zze = zznd.zzB();
    private int zzf;

    static {
        zzti zztiVar = new zzti();
        zzb = zztiVar;
        zznd.zzI(zzti.class, zztiVar);
    }

    private zzti() {
    }

    public static zztf zzf() {
        return (zztf) zzb.zzq();
    }

    public static /* synthetic */ void zzi(zzti zztiVar, Iterable iterable) {
        zztiVar.zzl();
        zzko.zzc(iterable, zztiVar.zze);
    }

    public static /* synthetic */ void zzj(zzti zztiVar, zzth zzthVar) {
        zzthVar.getClass();
        zztiVar.zzl();
        zztiVar.zze.add(zzthVar);
    }

    private final void zzl() {
        zznk zznkVar = this.zze;
        if (!zznkVar.zzc()) {
            this.zze = zznd.zzC(zznkVar);
        }
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
                                synchronized (zzti.class) {
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
                    return new zztf(zztjVar);
                }
                return new zzti();
            }
            return zznd.zzF(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u000b", new Object[]{"zze", zzth.class, "zzf"});
        }
        return (byte) 1;
    }
}
