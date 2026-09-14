package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zztx extends zznd implements zzoj {
    private static final zztx zzb;
    private static volatile zzoq zzd;
    private int zze = 0;
    private Object zzf;

    static {
        zztx zztxVar = new zztx();
        zzb = zztxVar;
        zznd.zzI(zztx.class, zztxVar);
    }

    private zztx() {
    }

    public static /* synthetic */ void zzM(zztx zztxVar, zzrr zzrrVar) {
        zzrrVar.getClass();
        zztxVar.zzf = zzrrVar;
        zztxVar.zze = 2;
    }

    public static zztw zzi() {
        return (zztw) zzb.zzq();
    }

    public static zztx zzk(byte[] bArr) {
        return (zztx) zznd.zzx(zzb, bArr);
    }

    public static /* synthetic */ void zzl(zztx zztxVar, zzrc zzrcVar) {
        zzrcVar.getClass();
        zztxVar.zzf = zzrcVar;
        zztxVar.zze = 1;
    }

    public final int zzN() {
        int i = this.zze;
        if (i == 0) {
            return 3;
        }
        int i3 = 1;
        if (i != 1) {
            i3 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i3;
    }

    public final zzrc zzf() {
        if (this.zze == 1) {
            return (zzrc) this.zzf;
        }
        return zzrc.zzk();
    }

    public final zzrr zzg() {
        if (this.zze == 2) {
            return (zzrr) this.zzf;
        }
        return zzrr.zzg();
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
                                synchronized (zztx.class) {
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
                    return new zztw(zzugVar);
                }
                return new zztx();
            }
            return zznd.zzF(zzb, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zzf", "zze", zzrc.class, zzrr.class});
        }
        return (byte) 1;
    }
}
