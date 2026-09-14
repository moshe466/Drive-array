package com.google.android.recaptcha.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.remoteconfig.internal.Code;
import io.flutter.Build;

/* loaded from: classes.dex */
public final class zzte extends zznd implements zzoj {
    private static final zzte zzb;
    private static volatile zzoq zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private zztc zzj;
    private int zzk;
    private zztl zzl;

    static {
        zzte zzteVar = new zzte();
        zzb = zzteVar;
        zznd.zzI(zzte.class, zzteVar);
    }

    private zzte() {
    }

    public static /* synthetic */ void zzM(zzte zzteVar, int i) {
        if (i != 1) {
            zzteVar.zzh = i - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static /* synthetic */ void zzN(zzte zzteVar, int i) {
        if (i != 1) {
            zzteVar.zzf = i - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zztd zzf() {
        return (zztd) zzb.zzq();
    }

    public static /* bridge */ /* synthetic */ zzte zzg() {
        return zzb;
    }

    public static /* synthetic */ void zzi(zzte zzteVar, int i) {
        zzteVar.zzg = i;
    }

    public static /* synthetic */ void zzj(zzte zzteVar, int i) {
        zzteVar.zzk = i;
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
                                synchronized (zzte.class) {
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
                    return new zztd(zztjVar);
                }
                return new zzte();
            }
            return zznd.zzF(zzb, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\f\u0002\u000b\u0003\f\u0004\f\u0005ဉ\u0000\u0006\u000b\u0007ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        return (byte) 1;
    }

    public final int zzk() {
        int i;
        switch (this.zzh) {
            case 0:
                i = 2;
                break;
            case 1:
                i = 3;
                break;
            case 2:
                i = 4;
                break;
            case 3:
                i = 5;
                break;
            case 4:
                i = 6;
                break;
            case 5:
                i = 7;
                break;
            case 6:
                i = 8;
                break;
            case 7:
                i = 9;
                break;
            case 8:
                i = 10;
                break;
            case 9:
                i = 11;
                break;
            case 10:
                i = 12;
                break;
            case 11:
                i = 13;
                break;
            case Code.UNIMPLEMENTED /* 12 */:
                i = 14;
                break;
            case 13:
                i = 15;
                break;
            case 14:
                i = 16;
                break;
            case 15:
                i = 17;
                break;
            case 16:
                i = 18;
                break;
            case 17:
                i = 19;
                break;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                i = 20;
                break;
            case 19:
                i = 21;
                break;
            case 20:
                i = 22;
                break;
            case 21:
                i = 23;
                break;
            case 22:
                i = 24;
                break;
            case 23:
                i = 25;
                break;
            case 24:
                i = 26;
                break;
            case Build.API_LEVELS.API_25 /* 25 */:
                i = 27;
                break;
            case Build.API_LEVELS.API_26 /* 26 */:
                i = 28;
                break;
            case Build.API_LEVELS.API_27 /* 27 */:
                i = 29;
                break;
            case Build.API_LEVELS.API_28 /* 28 */:
                i = 30;
                break;
            case Build.API_LEVELS.API_29 /* 29 */:
                i = 31;
                break;
            case Build.API_LEVELS.API_30 /* 30 */:
                i = 32;
                break;
            case Build.API_LEVELS.API_31 /* 31 */:
                i = 33;
                break;
            case 32:
                i = 34;
                break;
            case Build.API_LEVELS.API_33 /* 33 */:
                i = 35;
                break;
            case Build.API_LEVELS.API_34 /* 34 */:
                i = 36;
                break;
            case Build.API_LEVELS.API_35 /* 35 */:
                i = 37;
                break;
            case Build.API_LEVELS.API_36 /* 36 */:
                i = 38;
                break;
            case 37:
                i = 39;
                break;
            case 38:
                i = 40;
                break;
            case 39:
                i = 41;
                break;
            case 40:
                i = 42;
                break;
            case 41:
                i = 43;
                break;
            case 42:
                i = 44;
                break;
            case 43:
                i = 45;
                break;
            case 44:
                i = 46;
                break;
            case 45:
                i = 47;
                break;
            case 46:
                i = 48;
                break;
            case 47:
                i = 49;
                break;
            case 48:
                i = 50;
                break;
            case 49:
                i = 51;
                break;
            case 50:
                i = 52;
                break;
            case 51:
                i = 53;
                break;
            case 52:
                i = 54;
                break;
            case 53:
                i = 55;
                break;
            case 54:
                i = 56;
                break;
            case 55:
                i = 57;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public final int zzl() {
        int i;
        switch (this.zzf) {
            case 0:
                i = 2;
                break;
            case 1:
                i = 3;
                break;
            case 2:
                i = 4;
                break;
            case 3:
                i = 5;
                break;
            case 4:
                i = 6;
                break;
            case 5:
                i = 7;
                break;
            case 6:
                i = 8;
                break;
            case 7:
                i = 9;
                break;
            case 8:
                i = 10;
                break;
            case 9:
                i = 11;
                break;
            case 10:
                i = 12;
                break;
            case 11:
                i = 13;
                break;
            case Code.UNIMPLEMENTED /* 12 */:
                i = 14;
                break;
            case 13:
                i = 15;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
