package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.Code;
import io.flutter.Build;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.tika.pipes.PipesConfigBase;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class zzamg<T> implements zzamv<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzanp.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzamc zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzamk zzn;
    private final zzalm zzo;
    private final zzano<?, ?> zzp;
    private final zzakm<?> zzq;
    private final zzalz zzr;

    private zzamg(int[] iArr, Object[] objArr, int i, int i3, zzamc zzamcVar, boolean z3, int[] iArr2, int i4, int i5, zzamk zzamkVar, zzalm zzalmVar, zzano<?, ?> zzanoVar, zzakm<?> zzakmVar, zzalz zzalzVar) {
        boolean z4;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i3;
        this.zzi = zzamcVar instanceof zzaky;
        if (zzakmVar != null && zzakmVar.zza(zzamcVar)) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.zzh = z4;
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i4;
        this.zzm = i5;
        this.zzn = zzamkVar;
        this.zzo = zzalmVar;
        this.zzp = zzanoVar;
        this.zzq = zzakmVar;
        this.zzg = zzamcVar;
        this.zzr = zzalzVar;
    }

    private static <T> double zza(T t3, long j2) {
        return ((Double) zzanp.zze(t3, j2)).doubleValue();
    }

    private static <T> float zzb(T t3, long j2) {
        return ((Float) zzanp.zze(t3, j2)).floatValue();
    }

    private static <T> int zzc(T t3, long j2) {
        return ((Integer) zzanp.zze(t3, j2)).intValue();
    }

    private static <T> long zzd(T t3, long j2) {
        return ((Long) zzanp.zze(t3, j2)).longValue();
    }

    private final zzamv zze(int i) {
        int i3 = (i / 3) << 1;
        zzamv zzamvVar = (zzamv) this.zzd[i3];
        if (zzamvVar != null) {
            return zzamvVar;
        }
        zzamv<T> zza2 = zzamr.zza().zza((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zza2;
        return zza2;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static int zza(byte[] bArr, int i, int i3, zzanw zzanwVar, Class<?> cls, zzajk zzajkVar) {
        switch (zzamj.zza[zzanwVar.ordinal()]) {
            case 1:
                int zzd = zzajl.zzd(bArr, i, zzajkVar);
                zzajkVar.zzc = Boolean.valueOf(zzajkVar.zzb != 0);
                return zzd;
            case 2:
                return zzajl.zza(bArr, i, zzajkVar);
            case 3:
                zzajkVar.zzc = Double.valueOf(zzajl.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzajkVar.zzc = Integer.valueOf(zzajl.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzajkVar.zzc = Long.valueOf(zzajl.zzd(bArr, i));
                return i + 8;
            case 8:
                zzajkVar.zzc = Float.valueOf(zzajl.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zzc = zzajl.zzc(bArr, i, zzajkVar);
                zzajkVar.zzc = Integer.valueOf(zzajkVar.zza);
                return zzc;
            case Code.UNIMPLEMENTED /* 12 */:
            case 13:
                int zzd2 = zzajl.zzd(bArr, i, zzajkVar);
                zzajkVar.zzc = Long.valueOf(zzajkVar.zzb);
                return zzd2;
            case 14:
                return zzajl.zza(zzamr.zza().zza((Class) cls), bArr, i, i3, zzajkVar);
            case 15:
                int zzc2 = zzajl.zzc(bArr, i, zzajkVar);
                zzajkVar.zzc = Integer.valueOf(zzakb.zze(zzajkVar.zza));
                return zzc2;
            case 16:
                int zzd3 = zzajl.zzd(bArr, i, zzajkVar);
                zzajkVar.zzc = Long.valueOf(zzakb.zza(zzajkVar.zzb));
                return zzd3;
            case 17:
                return zzajl.zzb(bArr, i, zzajkVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private final zzald zzd(int i) {
        return (zzald) this.zzd[((i / 3) << 1) + 1];
    }

    private static void zzf(Object obj) {
        if (!zzg(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzaky) {
            return ((zzaky) obj).zzu();
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final int zzb(T t3) {
        int i;
        int zza2;
        int i3;
        int zzc;
        int length = this.zzc.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int zzc2 = zzc(i5);
            int i6 = this.zzc[i5];
            long j2 = 1048575 & zzc2;
            int i7 = 37;
            switch ((zzc2 & 267386880) >>> 20) {
                case 0:
                    i = i4 * 53;
                    zza2 = zzalb.zza(Double.doubleToLongBits(zzanp.zza(t3, j2)));
                    i4 = zza2 + i;
                    break;
                case 1:
                    i = i4 * 53;
                    zza2 = Float.floatToIntBits(zzanp.zzb(t3, j2));
                    i4 = zza2 + i;
                    break;
                case 2:
                    i = i4 * 53;
                    zza2 = zzalb.zza(zzanp.zzd(t3, j2));
                    i4 = zza2 + i;
                    break;
                case 3:
                    i = i4 * 53;
                    zza2 = zzalb.zza(zzanp.zzd(t3, j2));
                    i4 = zza2 + i;
                    break;
                case 4:
                    i3 = i4 * 53;
                    zzc = zzanp.zzc(t3, j2);
                    i4 = i3 + zzc;
                    break;
                case 5:
                    i = i4 * 53;
                    zza2 = zzalb.zza(zzanp.zzd(t3, j2));
                    i4 = zza2 + i;
                    break;
                case 6:
                    i3 = i4 * 53;
                    zzc = zzanp.zzc(t3, j2);
                    i4 = i3 + zzc;
                    break;
                case 7:
                    i = i4 * 53;
                    zza2 = zzalb.zza(zzanp.zzh(t3, j2));
                    i4 = zza2 + i;
                    break;
                case 8:
                    i = i4 * 53;
                    zza2 = ((String) zzanp.zze(t3, j2)).hashCode();
                    i4 = zza2 + i;
                    break;
                case 9:
                    Object zze = zzanp.zze(t3, j2);
                    if (zze != null) {
                        i7 = zze.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case 10:
                    i = i4 * 53;
                    zza2 = zzanp.zze(t3, j2).hashCode();
                    i4 = zza2 + i;
                    break;
                case 11:
                    i3 = i4 * 53;
                    zzc = zzanp.zzc(t3, j2);
                    i4 = i3 + zzc;
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    i3 = i4 * 53;
                    zzc = zzanp.zzc(t3, j2);
                    i4 = i3 + zzc;
                    break;
                case 13:
                    i3 = i4 * 53;
                    zzc = zzanp.zzc(t3, j2);
                    i4 = i3 + zzc;
                    break;
                case 14:
                    i = i4 * 53;
                    zza2 = zzalb.zza(zzanp.zzd(t3, j2));
                    i4 = zza2 + i;
                    break;
                case 15:
                    i3 = i4 * 53;
                    zzc = zzanp.zzc(t3, j2);
                    i4 = i3 + zzc;
                    break;
                case 16:
                    i = i4 * 53;
                    zza2 = zzalb.zza(zzanp.zzd(t3, j2));
                    i4 = zza2 + i;
                    break;
                case 17:
                    Object zze2 = zzanp.zze(t3, j2);
                    if (zze2 != null) {
                        i7 = zze2.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case Build.API_LEVELS.API_25 /* 25 */:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i4 * 53;
                    zza2 = zzanp.zze(t3, j2).hashCode();
                    i4 = zza2 + i;
                    break;
                case 50:
                    i = i4 * 53;
                    zza2 = zzanp.zze(t3, j2).hashCode();
                    i4 = zza2 + i;
                    break;
                case 51:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = zzalb.zza(Double.doubleToLongBits(zza(t3, j2)));
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = Float.floatToIntBits(zzb(t3, j2));
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = zzalb.zza(zzd(t3, j2));
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = zzalb.zza(zzd(t3, j2));
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i3 = i4 * 53;
                        zzc = zzc(t3, j2);
                        i4 = i3 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = zzalb.zza(zzd(t3, j2));
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i3 = i4 * 53;
                        zzc = zzc(t3, j2);
                        i4 = i3 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = zzalb.zza(zze(t3, j2));
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = ((String) zzanp.zze(t3, j2)).hashCode();
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = zzanp.zze(t3, j2).hashCode();
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = zzanp.zze(t3, j2).hashCode();
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i3 = i4 * 53;
                        zzc = zzc(t3, j2);
                        i4 = i3 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i3 = i4 * 53;
                        zzc = zzc(t3, j2);
                        i4 = i3 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i3 = i4 * 53;
                        zzc = zzc(t3, j2);
                        i4 = i3 + zzc;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = zzalb.zza(zzd(t3, j2));
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i3 = i4 * 53;
                        zzc = zzc(t3, j2);
                        i4 = i3 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = zzalb.zza(zzd(t3, j2));
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzc((zzamg<T>) t3, i6, i5)) {
                        i = i4 * 53;
                        zza2 = zzanp.zze(t3, j2).hashCode();
                        i4 = zza2 + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.zzp.zzd(t3).hashCode() + (i4 * 53);
        return this.zzh ? (hashCode * 53) + this.zzq.zza(t3).hashCode() : hashCode;
    }

    public static zzann zzc(Object obj) {
        zzaky zzakyVar = (zzaky) obj;
        zzann zzannVar = zzakyVar.zzb;
        if (zzannVar != zzann.zzc()) {
            return zzannVar;
        }
        zzann zzd = zzann.zzd();
        zzakyVar.zzb = zzd;
        return zzd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final void zzd(T t3) {
        if (zzg(t3)) {
            if (t3 instanceof zzaky) {
                zzaky zzakyVar = (zzaky) t3;
                zzakyVar.zzb(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                zzakyVar.zza = 0;
                zzakyVar.zzt();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzc = zzc(i);
                long j2 = 1048575 & zzc;
                int i3 = (zzc & 267386880) >>> 20;
                if (i3 != 9) {
                    if (i3 != 60 && i3 != 68) {
                        switch (i3) {
                            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case Build.API_LEVELS.API_25 /* 25 */:
                            case Build.API_LEVELS.API_26 /* 26 */:
                            case Build.API_LEVELS.API_27 /* 27 */:
                            case Build.API_LEVELS.API_28 /* 28 */:
                            case Build.API_LEVELS.API_29 /* 29 */:
                            case Build.API_LEVELS.API_30 /* 30 */:
                            case Build.API_LEVELS.API_31 /* 31 */:
                            case 32:
                            case Build.API_LEVELS.API_33 /* 33 */:
                            case Build.API_LEVELS.API_34 /* 34 */:
                            case Build.API_LEVELS.API_35 /* 35 */:
                            case Build.API_LEVELS.API_36 /* 36 */:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzo.zzb(t3, j2);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t3, j2);
                                if (object != null) {
                                    unsafe.putObject(t3, j2, this.zzr.zzc(object));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzc((zzamg<T>) t3, this.zzc[i], i)) {
                        zze(i).zzd(zzb.getObject(t3, j2));
                    }
                }
                if (zzc((zzamg<T>) t3, i)) {
                    zze(i).zzd(zzb.getObject(t3, j2));
                }
            }
            this.zzp.zzf(t3);
            if (this.zzh) {
                this.zzq.zzc(t3);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.google.android.gms.internal.firebase-auth-api.zzamv] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [com.google.android.gms.internal.firebase-auth-api.zzamv] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final boolean zze(T t3) {
        int i;
        int i3;
        zzamg<T> zzamgVar;
        T t4;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.zzl) {
            int i7 = this.zzk[i5];
            int i8 = this.zzc[i7];
            int zzc = zzc(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i6 = zzb.getInt(t3, i10);
                }
                i3 = i6;
                i = i10;
            } else {
                i = i4;
                i3 = i6;
            }
            if ((268435456 & zzc) != 0) {
                zzamgVar = this;
                t4 = t3;
                if (!zzamgVar.zza((zzamg<T>) t4, i7, i, i3, i11)) {
                    return false;
                }
            } else {
                zzamgVar = this;
                t4 = t3;
            }
            int i12 = (267386880 & zzc) >>> 20;
            if (i12 != 9 && i12 != 17) {
                if (i12 != 27) {
                    if (i12 == 60 || i12 == 68) {
                        if (zzc((zzamg<T>) t4, i8, i7) && !zza((Object) t4, zzc, zze(i7))) {
                            return false;
                        }
                    } else if (i12 != 49) {
                        if (i12 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzd = zzamgVar.zzr.zzd(zzanp.zze(t4, zzc & 1048575));
                            if (zzd.isEmpty()) {
                                continue;
                            } else if (zzamgVar.zzr.zza(zzf(i7)).zzc.zzb() == zzaod.MESSAGE) {
                                ?? r3 = 0;
                                for (Object obj : zzd.values()) {
                                    r3 = r3;
                                    if (r3 == 0) {
                                        r3 = zzamr.zza().zza((Class) obj.getClass());
                                    }
                                    if (!r3.zze(obj)) {
                                        return false;
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                List list = (List) zzanp.zze(t4, zzc & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    ?? zze = zze(i7);
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        if (!zze.zze(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (zzamgVar.zza((zzamg<T>) t4, i7, i, i3, i11) && !zza((Object) t4, zzc, zze(i7))) {
                return false;
            }
            i5++;
            t3 = t4;
            i4 = i;
            i6 = i3;
        }
        return !this.zzh || this.zzq.zza(t3).zzg();
    }

    private final boolean zzc(T t3, T t4, int i) {
        return zzc((zzamg<T>) t3, i) == zzc((zzamg<T>) t4, i);
    }

    private final boolean zzc(T t3, int i) {
        int zzb2 = zzb(i);
        long j2 = zzb2 & 1048575;
        if (j2 != 1048575) {
            return (zzanp.zzc(t3, j2) & (1 << (zzb2 >>> 20))) != 0;
        }
        int zzc = zzc(i);
        long j3 = zzc & 1048575;
        switch ((zzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzanp.zza(t3, j3)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzanp.zzb(t3, j3)) != 0;
            case 2:
                return zzanp.zzd(t3, j3) != 0;
            case 3:
                return zzanp.zzd(t3, j3) != 0;
            case 4:
                return zzanp.zzc(t3, j3) != 0;
            case 5:
                return zzanp.zzd(t3, j3) != 0;
            case 6:
                return zzanp.zzc(t3, j3) != 0;
            case 7:
                return zzanp.zzh(t3, j3);
            case 8:
                Object zze = zzanp.zze(t3, j3);
                if (zze instanceof String) {
                    return !((String) zze).isEmpty();
                }
                if (zze instanceof zzajp) {
                    return !zzajp.zza.equals(zze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzanp.zze(t3, j3) != null;
            case 10:
                return !zzajp.zza.equals(zzanp.zze(t3, j3));
            case 11:
                return zzanp.zzc(t3, j3) != 0;
            case Code.UNIMPLEMENTED /* 12 */:
                return zzanp.zzc(t3, j3) != 0;
            case 13:
                return zzanp.zzc(t3, j3) != 0;
            case 14:
                return zzanp.zzd(t3, j3) != 0;
            case 15:
                return zzanp.zzc(t3, j3) != 0;
            case 16:
                return zzanp.zzd(t3, j3) != 0;
            case 17:
                return zzanp.zze(t3, j3) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0053. Please report as an issue. */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final int zza(T t3) {
        int i;
        int zza2;
        int zza3;
        int zzb2;
        int zza4;
        int zzd;
        int zzi;
        int zzj;
        zzamg<T> zzamgVar = this;
        T t4 = t3;
        Unsafe unsafe = zzb;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (i4 < zzamgVar.zzc.length) {
            int zzc = zzamgVar.zzc(i4);
            int i8 = (267386880 & zzc) >>> 20;
            int[] iArr = zzamgVar.zzc;
            int i9 = iArr[i4];
            int i10 = iArr[i4 + 2];
            int i11 = i10 & i3;
            if (i8 <= 17) {
                if (i11 != i7) {
                    i5 = i11 == i3 ? 0 : unsafe.getInt(t4, i11);
                    i7 = i11;
                }
                i = 1 << (i10 >>> 20);
            } else {
                i = 0;
            }
            long j2 = zzc & i3;
            if (i8 >= zzaks.zza.zza()) {
                zzaks.zzb.zza();
            }
            int i12 = i6;
            switch (i8) {
                case 0:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zza2 = zzakg.zza(i9, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 1:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zza3 = zzakg.zza(i9, 0.0f);
                        i6 = zza3 + i12;
                        zzamgVar = this;
                        t4 = t3;
                        break;
                    }
                    zzamgVar = this;
                    t4 = t3;
                    i6 = i12;
                    break;
                case 2:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zzb2 = zzakg.zzb(i9, unsafe.getLong(t4, j2));
                        i6 = zzb2 + i12;
                        zzamgVar = this;
                        break;
                    }
                    zzamgVar = this;
                    i6 = i12;
                    break;
                case 3:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zzb2 = zzakg.zze(i9, unsafe.getLong(t4, j2));
                        i6 = zzb2 + i12;
                        zzamgVar = this;
                        break;
                    }
                    zzamgVar = this;
                    i6 = i12;
                    break;
                case 4:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zzb2 = zzakg.zzd(i9, unsafe.getInt(t4, j2));
                        i6 = zzb2 + i12;
                        zzamgVar = this;
                        break;
                    }
                    zzamgVar = this;
                    i6 = i12;
                    break;
                case 5:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zza3 = zzakg.zza(i9, 0L);
                        i6 = zza3 + i12;
                        zzamgVar = this;
                        t4 = t3;
                        break;
                    }
                    zzamgVar = this;
                    t4 = t3;
                    i6 = i12;
                    break;
                case 6:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zza3 = zzakg.zzc(i9, 0);
                        i6 = zza3 + i12;
                        zzamgVar = this;
                        t4 = t3;
                        break;
                    }
                    zzamgVar = this;
                    t4 = t3;
                    i6 = i12;
                    break;
                case 7:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zza3 = zzakg.zza(i9, true);
                        i6 = zza3 + i12;
                        zzamgVar = this;
                        t4 = t3;
                        break;
                    }
                    zzamgVar = this;
                    t4 = t3;
                    i6 = i12;
                    break;
                case 8:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        Object object = unsafe.getObject(t4, j2);
                        if (object instanceof zzajp) {
                            zzb2 = zzakg.zza(i9, (zzajp) object);
                        } else {
                            zzb2 = zzakg.zza(i9, (String) object);
                        }
                        i6 = zzb2 + i12;
                        zzamgVar = this;
                        break;
                    }
                    zzamgVar = this;
                    i6 = i12;
                    break;
                case 9:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zza4 = zzamx.zza(i9, unsafe.getObject(t4, j2), (zzamv<?>) zzamgVar.zze(i4));
                        i6 = i12 + zza4;
                        break;
                    }
                    i6 = i12;
                    break;
                case 10:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zzb2 = zzakg.zza(i9, (zzajp) unsafe.getObject(t4, j2));
                        i6 = zzb2 + i12;
                        zzamgVar = this;
                        break;
                    }
                    zzamgVar = this;
                    i6 = i12;
                    break;
                case 11:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zzb2 = zzakg.zzg(i9, unsafe.getInt(t4, j2));
                        i6 = zzb2 + i12;
                        zzamgVar = this;
                        break;
                    }
                    zzamgVar = this;
                    i6 = i12;
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zzb2 = zzakg.zzb(i9, unsafe.getInt(t4, j2));
                        i6 = zzb2 + i12;
                        zzamgVar = this;
                        break;
                    }
                    zzamgVar = this;
                    i6 = i12;
                    break;
                case 13:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zza3 = zzakg.zze(i9, 0);
                        i6 = zza3 + i12;
                        zzamgVar = this;
                        t4 = t3;
                        break;
                    }
                    zzamgVar = this;
                    t4 = t3;
                    i6 = i12;
                    break;
                case 14:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zza3 = zzakg.zzc(i9, 0L);
                        i6 = zza3 + i12;
                        zzamgVar = this;
                        t4 = t3;
                        break;
                    }
                    zzamgVar = this;
                    t4 = t3;
                    i6 = i12;
                    break;
                case 15:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zzb2 = zzakg.zzf(i9, unsafe.getInt(t4, j2));
                        i6 = zzb2 + i12;
                        zzamgVar = this;
                        break;
                    }
                    zzamgVar = this;
                    i6 = i12;
                    break;
                case 16:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zzb2 = zzakg.zzd(i9, unsafe.getLong(t4, j2));
                        i6 = zzb2 + i12;
                        zzamgVar = this;
                        break;
                    }
                    zzamgVar = this;
                    i6 = i12;
                    break;
                case 17:
                    if (zzamgVar.zza((zzamg<T>) t4, i4, i7, i5, i)) {
                        zza2 = zzakg.zza(i9, (zzamc) unsafe.getObject(t4, j2), zzamgVar.zze(i4));
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    zza4 = zzamx.zzd(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case 19:
                    zza4 = zzamx.zzc(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case 20:
                    zza4 = zzamx.zzf(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case 21:
                    zza4 = zzamx.zzj(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case 22:
                    zza4 = zzamx.zze(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case 23:
                    zza4 = zzamx.zzd(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case 24:
                    zza4 = zzamx.zzc(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    zza4 = zzamx.zza(i9, (List<?>) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    zza4 = zzamx.zzb(i9, (List) unsafe.getObject(t4, j2));
                    i6 = i12 + zza4;
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    zza4 = zzamx.zzb(i9, (List<?>) unsafe.getObject(t4, j2), (zzamv<?>) zzamgVar.zze(i4));
                    i6 = i12 + zza4;
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    zza4 = zzamx.zza(i9, (List<zzajp>) unsafe.getObject(t4, j2));
                    i6 = i12 + zza4;
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    zza4 = zzamx.zzi(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case Build.API_LEVELS.API_30 /* 30 */:
                    zza4 = zzamx.zzb(i9, (List<Integer>) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    zza4 = zzamx.zzc(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case 32:
                    zza4 = zzamx.zzd(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case Build.API_LEVELS.API_33 /* 33 */:
                    zza4 = zzamx.zzg(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    zza4 = zzamx.zzh(i9, (List) unsafe.getObject(t4, j2), false);
                    i6 = i12 + zza4;
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    zzd = zzamx.zzd((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    zzd = zzamx.zzc((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 37:
                    zzd = zzamx.zzf((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 38:
                    zzd = zzamx.zzj((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 39:
                    zzd = zzamx.zze((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 40:
                    zzd = zzamx.zzd((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 41:
                    zzd = zzamx.zzc((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 42:
                    zzd = zzamx.zza((List<?>) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 43:
                    zzd = zzamx.zzi((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 44:
                    zzd = zzamx.zzb((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 45:
                    zzd = zzamx.zzc((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 46:
                    zzd = zzamx.zzd((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 47:
                    zzd = zzamx.zzg((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 48:
                    zzd = zzamx.zzh((List) unsafe.getObject(t4, j2));
                    if (zzd > 0) {
                        zzi = zzakg.zzi(i9);
                        zzj = zzakg.zzj(zzd);
                        i6 = zzj + zzi + zzd + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 49:
                    zza4 = zzamx.zza(i9, (List<zzamc>) unsafe.getObject(t4, j2), (zzamv<?>) zzamgVar.zze(i4));
                    i6 = i12 + zza4;
                    break;
                case 50:
                    zza4 = zzamgVar.zzr.zza(i9, unsafe.getObject(t4, j2), zzamgVar.zzf(i4));
                    i6 = i12 + zza4;
                    break;
                case 51:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zza(i9, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 52:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zza(i9, 0.0f);
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 53:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zzb(i9, zzd(t4, j2));
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 54:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zze(i9, zzd(t4, j2));
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 55:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zzd(i9, zzc(t4, j2));
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 56:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zza(i9, 0L);
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 57:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zzc(i9, 0);
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 58:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zza(i9, true);
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 59:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        Object object2 = unsafe.getObject(t4, j2);
                        if (object2 instanceof zzajp) {
                            zza2 = zzakg.zza(i9, (zzajp) object2);
                        } else {
                            zza2 = zzakg.zza(i9, (String) object2);
                        }
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza4 = zzamx.zza(i9, unsafe.getObject(t4, j2), (zzamv<?>) zzamgVar.zze(i4));
                        i6 = i12 + zza4;
                        break;
                    }
                    i6 = i12;
                    break;
                case 61:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zza(i9, (zzajp) unsafe.getObject(t4, j2));
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 62:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zzg(i9, zzc(t4, j2));
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 63:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zzb(i9, zzc(t4, j2));
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 64:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zze(i9, 0);
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zzc(i9, 0L);
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 66:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zzf(i9, zzc(t4, j2));
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 67:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zzd(i9, zzd(t4, j2));
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                case 68:
                    if (zzamgVar.zzc((zzamg<T>) t4, i9, i4)) {
                        zza2 = zzakg.zza(i9, (zzamc) unsafe.getObject(t4, j2), zzamgVar.zze(i4));
                        i6 = zza2 + i12;
                        break;
                    }
                    i6 = i12;
                    break;
                default:
                    i6 = i12;
                    break;
            }
            i4 += 3;
            i3 = 1048575;
        }
        zzano<?, ?> zzanoVar = zzamgVar.zzp;
        int zza5 = i6 + zzanoVar.zza((zzano<?, ?>) zzanoVar.zzd(t4));
        if (!zzamgVar.zzh) {
            return zza5;
        }
        zzakr<?> zza6 = zzamgVar.zzq.zza(t4);
        int zza7 = zza6.zza.zza();
        int i13 = 0;
        for (int i14 = 0; i14 < zza7; i14++) {
            Map.Entry<?, Object> zza8 = zza6.zza.zza(i14);
            i13 += zzakr.zza((zzakt<?>) zza8.getKey(), zza8.getValue());
        }
        for (Map.Entry<?, Object> entry : zza6.zza.zzb()) {
            i13 += zzakr.zza((zzakt<?>) entry.getKey(), entry.getValue());
        }
        return zza5 + i13;
    }

    private static <T> boolean zze(T t3, long j2) {
        return ((Boolean) zzanp.zze(t3, j2)).booleanValue();
    }

    private final boolean zzc(T t3, int i, int i3) {
        return zzanp.zzc(t3, (long) (zzb(i3) & 1048575)) == i;
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t3, T t4, int i) {
        int i3 = this.zzc[i];
        if (zzc((zzamg<T>) t4, i3, i)) {
            long zzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t4, zzc);
            if (object != null) {
                zzamv zze = zze(i);
                if (!zzc((zzamg<T>) t3, i3, i)) {
                    if (!zzg(object)) {
                        unsafe.putObject(t3, zzc, object);
                    } else {
                        Object zza2 = zze.zza();
                        zze.zza(zza2, object);
                        unsafe.putObject(t3, zzc, zza2);
                    }
                    zzb((zzamg<T>) t3, i3, i);
                    return;
                }
                Object object2 = unsafe.getObject(t3, zzc);
                if (!zzg(object2)) {
                    Object zza3 = zze.zza();
                    zze.zza(zza3, object2);
                    unsafe.putObject(t3, zzc, zza3);
                    object2 = zza3;
                }
                zze.zza(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t4));
        }
    }

    private final void zzb(T t3, int i) {
        int zzb2 = zzb(i);
        long j2 = 1048575 & zzb2;
        if (j2 == 1048575) {
            return;
        }
        zzanp.zza((Object) t3, j2, (1 << (zzb2 >>> 20)) | zzanp.zzc(t3, j2));
    }

    private final void zzb(T t3, int i, int i3) {
        zzanp.zza((Object) t3, zzb(i3) & 1048575, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamx.zza(com.google.android.gms.internal.p002firebaseauthapi.zzanp.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzanp.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b3, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c4, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d6, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ec, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamx.zza(com.google.android.gms.internal.p002firebaseauthapi.zzanp.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzanp.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0102, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamx.zza(com.google.android.gms.internal.p002firebaseauthapi.zzanp.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzanp.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0118, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamx.zza(com.google.android.gms.internal.p002firebaseauthapi.zzanp.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzanp.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012a, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzh(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzh(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x013c, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0150, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0162, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0176, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018a, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzb(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.p002firebaseauthapi.zzanp.zzb(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01c0, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p002firebaseauthapi.zzanp.zza(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p002firebaseauthapi.zzanp.zza(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamx.zza(com.google.android.gms.internal.p002firebaseauthapi.zzanp.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzanp.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0017. Please report as an issue. */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzb(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamg.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final int zza(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.p002firebaseauthapi.zzajk r35) {
        /*
            Method dump skipped, instructions count: 3628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamg.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzajk):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zza(int i, int i3) {
        int length = (this.zzc.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.zzc[i5];
            if (i == i6) {
                return i5;
            }
            if (i < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0271  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> com.google.android.gms.internal.p002firebaseauthapi.zzamg<T> zza(java.lang.Class<T> r31, com.google.android.gms.internal.p002firebaseauthapi.zzama r32, com.google.android.gms.internal.p002firebaseauthapi.zzamk r33, com.google.android.gms.internal.p002firebaseauthapi.zzalm r34, com.google.android.gms.internal.p002firebaseauthapi.zzano<?, ?> r35, com.google.android.gms.internal.p002firebaseauthapi.zzakm<?> r36, com.google.android.gms.internal.p002firebaseauthapi.zzalz r37) {
        /*
            Method dump skipped, instructions count: 1015
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamg.zza(java.lang.Class, com.google.android.gms.internal.firebase-auth-api.zzama, com.google.android.gms.internal.firebase-auth-api.zzamk, com.google.android.gms.internal.firebase-auth-api.zzalm, com.google.android.gms.internal.firebase-auth-api.zzano, com.google.android.gms.internal.firebase-auth-api.zzakm, com.google.android.gms.internal.firebase-auth-api.zzalz):com.google.android.gms.internal.firebase-auth-api.zzamg");
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzano<UT, UB> zzanoVar, Object obj2) {
        zzald zzd;
        int i3 = this.zzc[i];
        Object zze = zzanp.zze(obj, zzc(i) & 1048575);
        return (zze == null || (zzd = zzd(i)) == null) ? ub : (UB) zza(i, i3, this.zzr.zze(zze), zzd, (zzald) ub, (zzano<UT, zzald>) zzanoVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i3, Map<K, V> map, zzald zzaldVar, UB ub, zzano<UT, UB> zzanoVar, Object obj) {
        zzalx<?, ?> zza2 = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzaldVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzanoVar.zzc(obj);
                }
                zzaju zzc = zzajp.zzc(zzalu.zza(zza2, next.getKey(), next.getValue()));
                try {
                    zzalu.zza(zzc.zzb(), zza2, next.getKey(), next.getValue());
                    zzanoVar.zza((zzano<UT, UB>) ub, i3, zzc.zza());
                    it.remove();
                } catch (IOException e4) {
                    throw new RuntimeException(e4);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t3, int i) {
        zzamv zze = zze(i);
        long zzc = zzc(i) & 1048575;
        if (!zzc((zzamg<T>) t3, i)) {
            return zze.zza();
        }
        Object object = zzb.getObject(t3, zzc);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze.zza();
        if (object != null) {
            zze.zza(zza2, object);
        }
        return zza2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t3, int i, int i3) {
        zzamv zze = zze(i3);
        if (!zzc((zzamg<T>) t3, i, i3)) {
            return zze.zza();
        }
        Object object = zzb.getObject(t3, zzc(i3) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze.zza();
        if (object != null) {
            zze.zza(zza2, object);
        }
        return zza2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e4) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder y = AbstractC0008a.y("Field ", str, " for ", name, " not found. Known fields are ");
            y.append(arrays);
            throw new RuntimeException(y.toString(), e4);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final void zza(T t3, T t4) {
        zzf(t3);
        t4.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzc = zzc(i);
            long j2 = 1048575 & zzc;
            int i3 = this.zzc[i];
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza(t3, j2, zzanp.zza(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzb(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzd(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzd(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzc(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzd(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzc(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zzc(t3, j2, zzanp.zzh(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza(t3, j2, zzanp.zze(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t3, t4, i);
                    break;
                case 10:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza(t3, j2, zzanp.zze(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzc(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case Code.UNIMPLEMENTED /* 12 */:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzc(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzc(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzd(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzc(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzc((zzamg<T>) t4, i)) {
                        zzanp.zza((Object) t3, j2, zzanp.zzd(t4, j2));
                        zzb((zzamg<T>) t3, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t3, t4, i);
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case Build.API_LEVELS.API_25 /* 25 */:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzo.zza(t3, t4, j2);
                    break;
                case 50:
                    zzamx.zza(this.zzr, t3, t4, j2);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzc((zzamg<T>) t4, i3, i)) {
                        zzanp.zza(t3, j2, zzanp.zze(t4, j2));
                        zzb((zzamg<T>) t3, i3, i);
                        break;
                    } else {
                        break;
                    }
                case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                    zzb(t3, t4, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzc((zzamg<T>) t4, i3, i)) {
                        zzanp.zza(t3, j2, zzanp.zze(t4, j2));
                        zzb((zzamg<T>) t3, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t3, t4, i);
                    break;
            }
        }
        zzamx.zza(this.zzp, t3, t4);
        if (this.zzh) {
            zzamx.zza(this.zzq, t3, t4);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:90:0x00dd. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0775 A[Catch: all -> 0x0062, TryCatch #3 {all -> 0x0062, blocks: (B:37:0x0058, B:115:0x0770, B:117:0x0775, B:118:0x077a, B:134:0x013a, B:137:0x014c, B:138:0x0164, B:139:0x017c, B:140:0x0194, B:141:0x01ac, B:143:0x01bc, B:146:0x01c3, B:147:0x01c9, B:148:0x01d7, B:149:0x01ef, B:150:0x0203, B:151:0x021b, B:152:0x0229, B:153:0x0241, B:154:0x0259, B:155:0x0271, B:156:0x0289, B:157:0x02a1, B:158:0x02b9, B:159:0x02d1, B:160:0x02e9, B:162:0x02ff, B:163:0x0320, B:164:0x0309, B:166:0x0311, B:167:0x0331, B:168:0x0349, B:169:0x035d, B:170:0x0371, B:171:0x0385, B:172:0x0399, B:183:0x03cc, B:184:0x03da, B:185:0x03ee, B:186:0x0402, B:187:0x0416, B:188:0x042a, B:189:0x043e, B:190:0x0452, B:191:0x0466, B:192:0x047a, B:193:0x048e, B:194:0x04a2, B:195:0x04b6, B:196:0x04ca, B:201:0x04f1, B:202:0x04ff, B:203:0x0513, B:204:0x052b, B:206:0x0537, B:207:0x0545, B:208:0x0553, B:209:0x0567, B:210:0x057b, B:211:0x058f, B:212:0x05a3, B:213:0x05b7, B:214:0x05cb, B:215:0x05df, B:216:0x05f3, B:217:0x060b, B:218:0x0620, B:219:0x0634, B:220:0x0648, B:221:0x065c, B:223:0x066b, B:226:0x0672, B:227:0x0678, B:228:0x0682, B:229:0x0696, B:230:0x06aa, B:231:0x06c2, B:232:0x06d0, B:233:0x06e4, B:234:0x06f8, B:235:0x070c, B:236:0x0720, B:237:0x0734, B:238:0x0748, B:239:0x075c), top: B:36:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0781 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x07ae A[LOOP:1: B:27:0x07aa->B:29:0x07ae, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x07c1  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r19, com.google.android.gms.internal.p002firebaseauthapi.zzams r20, com.google.android.gms.internal.p002firebaseauthapi.zzakk r21) {
        /*
            Method dump skipped, instructions count: 2132
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamg.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzams, com.google.android.gms.internal.firebase-auth-api.zzakk):void");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final void zza(T t3, byte[] bArr, int i, int i3, zzajk zzajkVar) {
        zza((zzamg<T>) t3, bArr, i, i3, 0, zzajkVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t3, T t4, int i) {
        if (zzc((zzamg<T>) t4, i)) {
            long zzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t4, zzc);
            if (object != null) {
                zzamv zze = zze(i);
                if (!zzc((zzamg<T>) t3, i)) {
                    if (!zzg(object)) {
                        unsafe.putObject(t3, zzc, object);
                    } else {
                        Object zza2 = zze.zza();
                        zze.zza(zza2, object);
                        unsafe.putObject(t3, zzc, zza2);
                    }
                    zzb((zzamg<T>) t3, i);
                    return;
                }
                Object object2 = unsafe.getObject(t3, zzc);
                if (!zzg(object2)) {
                    Object zza3 = zze.zza();
                    zze.zza(zza3, object2);
                    unsafe.putObject(t3, zzc, zza3);
                    object2 = zza3;
                }
                zze.zza(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t4));
        }
    }

    private final void zza(Object obj, int i, zzams zzamsVar) {
        if (zzg(i)) {
            zzanp.zza(obj, i & 1048575, zzamsVar.zzr());
        } else if (this.zzi) {
            zzanp.zza(obj, i & 1048575, zzamsVar.zzq());
        } else {
            zzanp.zza(obj, i & 1048575, zzamsVar.zzp());
        }
    }

    private final void zza(T t3, int i, Object obj) {
        zzb.putObject(t3, zzc(i) & 1048575, obj);
        zzb((zzamg<T>) t3, i);
    }

    private final void zza(T t3, int i, int i3, Object obj) {
        zzb.putObject(t3, zzc(i3) & 1048575, obj);
        zzb((zzamg<T>) t3, i, i3);
    }

    private final <K, V> void zza(zzaof zzaofVar, int i, Object obj, int i3) {
        if (obj != null) {
            zzaofVar.zza(i, this.zzr.zza(zzf(i3)), this.zzr.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zzaof zzaofVar) {
        if (obj instanceof String) {
            zzaofVar.zza(i, (String) obj);
        } else {
            zzaofVar.zza(i, (zzajp) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:321:0x05b1. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0a60  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r21, com.google.android.gms.internal.p002firebaseauthapi.zzaof r22) {
        /*
            Method dump skipped, instructions count: 2968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamg.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzaof):void");
    }

    private static <UT, UB> void zza(zzano<UT, UB> zzanoVar, T t3, zzaof zzaofVar) {
        zzanoVar.zzb((zzano<UT, UB>) zzanoVar.zzd(t3), zzaofVar);
    }

    private final boolean zza(T t3, int i, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return zzc((zzamg<T>) t3, i);
        }
        return (i4 & i5) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzamv zzamvVar) {
        return zzamvVar.zze(zzanp.zze(obj, i & 1048575));
    }
}
