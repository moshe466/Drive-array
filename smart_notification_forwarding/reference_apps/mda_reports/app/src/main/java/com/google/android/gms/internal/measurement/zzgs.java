package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzgs<T> implements zzhd<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzib.c();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgo zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzgw zzo;
    private final zzfy zzp;
    private final zzhv<?, ?> zzq;
    private final zzes<?> zzr;
    private final zzgh zzs;

    private zzgs(int[] iArr, Object[] objArr, int i, int i2, zzgo zzgoVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgw zzgwVar, zzfy zzfyVar, zzhv<?, ?> zzhvVar, zzes<?> zzesVar, zzgh zzghVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgoVar instanceof zzfd;
        this.zzj = z;
        this.zzh = zzesVar != null && zzesVar.a(zzgoVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzgwVar;
        this.zzp = zzfyVar;
        this.zzq = zzhvVar;
        this.zzr = zzesVar;
        this.zzg = zzgoVar;
        this.zzs = zzghVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> zzgs<T> a(Class<T> cls, zzgm zzgmVar, zzgw zzgwVar, zzfy zzfyVar, zzhv<?, ?> zzhvVar, zzes<?> zzesVar, zzgh zzghVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char charAt;
        int i6;
        int charAt2;
        int charAt3;
        int i7;
        int[] iArr;
        int i8;
        char c;
        char c2;
        int i9;
        char charAt4;
        int i10;
        char charAt5;
        int i11;
        char charAt6;
        int i12;
        char charAt7;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        int i13;
        int i14;
        char c3;
        char c4;
        int i15;
        int objectFieldOffset;
        String str;
        Class<?> cls2;
        int i16;
        int i17;
        int i18;
        int i19;
        Field zza2;
        int i20;
        char charAt12;
        int i21;
        int i22;
        Field zza3;
        Field zza4;
        int i23;
        char charAt13;
        int i24;
        char charAt14;
        int i25;
        char charAt15;
        char charAt16;
        char charAt17;
        if (!(zzgmVar instanceof zzhb)) {
            ((zzhs) zzgmVar).zza();
            int i26 = zzfd.zze.zzi;
            throw new NoSuchMethodError();
        }
        zzhb zzhbVar = (zzhb) zzgmVar;
        int i27 = 0;
        boolean z = zzhbVar.zza() == zzfd.zze.zzi;
        String a = zzhbVar.a();
        int length = a.length();
        int charAt18 = a.charAt(0);
        if (charAt18 >= 55296) {
            int i28 = charAt18 & 8191;
            int i29 = 1;
            int i30 = 13;
            while (true) {
                i = i29 + 1;
                charAt17 = a.charAt(i29);
                if (charAt17 < 55296) {
                    break;
                }
                i28 |= (charAt17 & 8191) << i30;
                i30 += 13;
                i29 = i;
            }
            charAt18 = (charAt17 << i30) | i28;
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int charAt19 = a.charAt(i);
        if (charAt19 >= 55296) {
            int i32 = charAt19 & 8191;
            int i33 = 13;
            while (true) {
                i2 = i31 + 1;
                charAt16 = a.charAt(i31);
                if (charAt16 < 55296) {
                    break;
                }
                i32 |= (charAt16 & 8191) << i33;
                i33 += 13;
                i31 = i2;
            }
            charAt19 = i32 | (charAt16 << i33);
        } else {
            i2 = i31;
        }
        if (charAt19 == 0) {
            iArr = zza;
            charAt3 = 0;
            c2 = 0;
            i8 = 0;
            charAt = 0;
            charAt2 = 0;
            c = 0;
        } else {
            int i34 = i2 + 1;
            char charAt20 = a.charAt(i2);
            if (charAt20 >= 55296) {
                int i35 = charAt20 & 8191;
                int i36 = 13;
                while (true) {
                    i3 = i34 + 1;
                    charAt11 = a.charAt(i34);
                    if (charAt11 < 55296) {
                        break;
                    }
                    i35 |= (charAt11 & 8191) << i36;
                    i36 += 13;
                    i34 = i3;
                }
                charAt20 = ((charAt11 << i36) | i35) == true ? 1 : 0;
            } else {
                i3 = i34;
            }
            int i37 = i3 + 1;
            int charAt21 = a.charAt(i3);
            if (charAt21 >= 55296) {
                int i38 = charAt21 & 8191;
                int i39 = 13;
                while (true) {
                    i4 = i37 + 1;
                    charAt10 = a.charAt(i37);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i38 |= (charAt10 & 8191) << i39;
                    i39 += 13;
                    i37 = i4;
                }
                charAt21 = i38 | (charAt10 << i39);
            } else {
                i4 = i37;
            }
            int i40 = i4 + 1;
            char charAt22 = a.charAt(i4);
            if (charAt22 >= 55296) {
                int i41 = charAt22 & 8191;
                int i42 = 13;
                while (true) {
                    i5 = i40 + 1;
                    charAt9 = a.charAt(i40);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i41 |= (charAt9 & 8191) << i42;
                    i42 += 13;
                    i40 = i5;
                }
                charAt22 = ((charAt9 << i42) | i41) == true ? 1 : 0;
            } else {
                i5 = i40;
            }
            int i43 = i5 + 1;
            charAt = a.charAt(i5);
            if (charAt >= 55296) {
                int i44 = charAt & 8191;
                int i45 = 13;
                while (true) {
                    i6 = i43 + 1;
                    charAt8 = a.charAt(i43);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i44 |= (charAt8 & 8191) << i45;
                    i45 += 13;
                    i43 = i6;
                }
                charAt = ((charAt8 << i45) | i44) == true ? 1 : 0;
            } else {
                i6 = i43;
            }
            int i46 = i6 + 1;
            charAt2 = a.charAt(i6);
            if (charAt2 >= 55296) {
                int i47 = charAt2 & 8191;
                int i48 = 13;
                while (true) {
                    i12 = i46 + 1;
                    charAt7 = a.charAt(i46);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i47 |= (charAt7 & 8191) << i48;
                    i48 += 13;
                    i46 = i12;
                }
                charAt2 = (charAt7 << i48) | i47;
                i46 = i12;
            }
            int i49 = i46 + 1;
            charAt3 = a.charAt(i46);
            if (charAt3 >= 55296) {
                int i50 = charAt3 & 8191;
                int i51 = 13;
                while (true) {
                    i11 = i49 + 1;
                    charAt6 = a.charAt(i49);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i50 |= (charAt6 & 8191) << i51;
                    i51 += 13;
                    i49 = i11;
                }
                charAt3 = i50 | (charAt6 << i51);
                i49 = i11;
            }
            int i52 = i49 + 1;
            int charAt23 = a.charAt(i49);
            if (charAt23 >= 55296) {
                int i53 = 13;
                int i54 = charAt23 & 8191;
                int i55 = i52;
                while (true) {
                    i10 = i55 + 1;
                    charAt5 = a.charAt(i55);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i54 |= (charAt5 & 8191) << i53;
                    i53 += 13;
                    i55 = i10;
                }
                charAt23 = i54 | (charAt5 << i53);
                i7 = i10;
            } else {
                i7 = i52;
            }
            int i56 = i7 + 1;
            i27 = a.charAt(i7);
            if (i27 >= 55296) {
                int i57 = 13;
                int i58 = i27 & 8191;
                int i59 = i56;
                while (true) {
                    i9 = i59 + 1;
                    charAt4 = a.charAt(i59);
                    if (charAt4 < 55296) {
                        break;
                    }
                    i58 |= (charAt4 & 8191) << i57;
                    i57 += 13;
                    i59 = i9;
                }
                i27 = i58 | (charAt4 << i57);
                i56 = i9;
            }
            iArr = new int[i27 + charAt3 + charAt23];
            i8 = (charAt20 << 1) + charAt21;
            int i60 = i56;
            c = charAt20;
            c2 = charAt22;
            i2 = i60;
        }
        Unsafe unsafe = zzb;
        Object[] b = zzhbVar.b();
        Class<?> cls3 = zzhbVar.zzc().getClass();
        int i61 = i8;
        int[] iArr2 = new int[charAt2 * 3];
        Object[] objArr = new Object[charAt2 << 1];
        int i62 = i27 + charAt3;
        int i63 = i27;
        int i64 = i62;
        int i65 = 0;
        int i66 = 0;
        while (i2 < length) {
            int i67 = i2 + 1;
            int charAt24 = a.charAt(i2);
            char c5 = 55296;
            if (charAt24 >= 55296) {
                int i68 = 13;
                int i69 = charAt24 & 8191;
                int i70 = i67;
                while (true) {
                    i25 = i70 + 1;
                    charAt15 = a.charAt(i70);
                    if (charAt15 < c5) {
                        break;
                    }
                    i69 |= (charAt15 & 8191) << i68;
                    i68 += 13;
                    i70 = i25;
                    c5 = 55296;
                }
                charAt24 = i69 | (charAt15 << i68);
                i13 = i25;
            } else {
                i13 = i67;
            }
            int i71 = i13 + 1;
            int charAt25 = a.charAt(i13);
            int i72 = length;
            char c6 = 55296;
            if (charAt25 >= 55296) {
                int i73 = 13;
                int i74 = charAt25 & 8191;
                int i75 = i71;
                while (true) {
                    i24 = i75 + 1;
                    charAt14 = a.charAt(i75);
                    if (charAt14 < c6) {
                        break;
                    }
                    i74 |= (charAt14 & 8191) << i73;
                    i73 += 13;
                    i75 = i24;
                    c6 = 55296;
                }
                charAt25 = i74 | (charAt14 << i73);
                i14 = i24;
            } else {
                i14 = i71;
            }
            int i76 = i27;
            int i77 = charAt25 & 255;
            boolean z2 = z;
            if ((charAt25 & 1024) != 0) {
                iArr[i65] = i66;
                i65++;
            }
            int i78 = i65;
            if (i77 >= 51) {
                int i79 = i14 + 1;
                int charAt26 = a.charAt(i14);
                char c7 = 55296;
                if (charAt26 >= 55296) {
                    int i80 = charAt26 & 8191;
                    int i81 = 13;
                    while (true) {
                        i23 = i79 + 1;
                        charAt13 = a.charAt(i79);
                        if (charAt13 < c7) {
                            break;
                        }
                        i80 |= (charAt13 & 8191) << i81;
                        i81 += 13;
                        i79 = i23;
                        c7 = 55296;
                    }
                    charAt26 = i80 | (charAt13 << i81);
                    i79 = i23;
                }
                int i82 = i77 - 51;
                int i83 = i79;
                if (i82 == 9 || i82 == 17) {
                    i22 = 1;
                    objArr[((i66 / 3) << 1) + 1] = b[i61];
                    i61++;
                } else {
                    if (i82 == 12 && (charAt18 & 1) == 1) {
                        objArr[((i66 / 3) << 1) + 1] = b[i61];
                        i61++;
                    }
                    i22 = 1;
                }
                int i84 = charAt26 << i22;
                Object obj = b[i84];
                if (obj instanceof Field) {
                    zza3 = (Field) obj;
                } else {
                    zza3 = zza(cls3, (String) obj);
                    b[i84] = zza3;
                }
                char c8 = c2;
                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zza3);
                int i85 = i84 + 1;
                Object obj2 = b[i85];
                if (obj2 instanceof Field) {
                    zza4 = (Field) obj2;
                } else {
                    zza4 = zza(cls3, (String) obj2);
                    b[i85] = zza4;
                }
                str = a;
                i19 = (int) unsafe.objectFieldOffset(zza4);
                cls2 = cls3;
                i16 = i61;
                objectFieldOffset = objectFieldOffset2;
                i18 = 0;
                c4 = c8;
                c3 = charAt;
                i15 = charAt24;
                i2 = i83;
            } else {
                char c9 = c2;
                int i86 = i61 + 1;
                Field zza5 = zza(cls3, (String) b[i61]);
                c3 = charAt;
                if (i77 == 9 || i77 == 17) {
                    c4 = c9;
                    objArr[((i66 / 3) << 1) + 1] = zza5.getType();
                } else {
                    if (i77 == 27 || i77 == 49) {
                        c4 = c9;
                        i21 = i86 + 1;
                        objArr[((i66 / 3) << 1) + 1] = b[i86];
                    } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                        c4 = c9;
                        if ((charAt18 & 1) == 1) {
                            i21 = i86 + 1;
                            objArr[((i66 / 3) << 1) + 1] = b[i86];
                        }
                    } else if (i77 == 50) {
                        int i87 = i63 + 1;
                        iArr[i63] = i66;
                        int i88 = (i66 / 3) << 1;
                        int i89 = i86 + 1;
                        objArr[i88] = b[i86];
                        if ((charAt25 & 2048) != 0) {
                            i86 = i89 + 1;
                            objArr[i88 + 1] = b[i89];
                            c4 = c9;
                            i63 = i87;
                        } else {
                            i63 = i87;
                            i86 = i89;
                            c4 = c9;
                        }
                    } else {
                        c4 = c9;
                    }
                    i15 = charAt24;
                    i86 = i21;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zza5);
                    if ((charAt18 & 1) == 1 || i77 > 17) {
                        str = a;
                        cls2 = cls3;
                        i16 = i86;
                        i17 = i14;
                        i18 = 0;
                        i19 = 0;
                    } else {
                        i17 = i14 + 1;
                        int charAt27 = a.charAt(i14);
                        if (charAt27 >= 55296) {
                            int i90 = charAt27 & 8191;
                            int i91 = 13;
                            while (true) {
                                i20 = i17 + 1;
                                charAt12 = a.charAt(i17);
                                if (charAt12 < 55296) {
                                    break;
                                }
                                i90 |= (charAt12 & 8191) << i91;
                                i91 += 13;
                                i17 = i20;
                            }
                            charAt27 = i90 | (charAt12 << i91);
                            i17 = i20;
                        }
                        int i92 = (c << 1) + (charAt27 / 32);
                        Object obj3 = b[i92];
                        str = a;
                        if (obj3 instanceof Field) {
                            zza2 = (Field) obj3;
                        } else {
                            zza2 = zza(cls3, (String) obj3);
                            b[i92] = zza2;
                        }
                        cls2 = cls3;
                        i16 = i86;
                        i19 = (int) unsafe.objectFieldOffset(zza2);
                        i18 = charAt27 % 32;
                    }
                    if (i77 >= 18 && i77 <= 49) {
                        iArr[i64] = objectFieldOffset;
                        i64++;
                    }
                    i2 = i17;
                }
                i15 = charAt24;
                objectFieldOffset = (int) unsafe.objectFieldOffset(zza5);
                if ((charAt18 & 1) == 1) {
                }
                str = a;
                cls2 = cls3;
                i16 = i86;
                i17 = i14;
                i18 = 0;
                i19 = 0;
                if (i77 >= 18) {
                    iArr[i64] = objectFieldOffset;
                    i64++;
                }
                i2 = i17;
            }
            int i93 = i66 + 1;
            iArr2[i66] = i15;
            int i94 = i93 + 1;
            iArr2[i93] = (i77 << 20) | ((charAt25 & 256) != 0 ? 268435456 : 0) | ((charAt25 & 512) != 0 ? 536870912 : 0) | objectFieldOffset;
            i66 = i94 + 1;
            iArr2[i94] = (i18 << 20) | i19;
            cls3 = cls2;
            charAt = c3;
            i27 = i76;
            i61 = i16;
            length = i72;
            z = z2;
            c2 = c4;
            i65 = i78;
            a = str;
        }
        return new zzgs<>(iArr2, objArr, c2, charAt, zzhbVar.zzc(), z, false, iArr, i27, i62, zzgwVar, zzfyVar, zzhvVar, zzesVar, zzghVar);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private static <UT, UB> int zza(zzhv<UT, UB> zzhvVar, T t) {
        return zzhvVar.f(zzhvVar.b(t));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzdt zzdtVar) {
        Object valueOf;
        Object valueOf2;
        int b;
        long j2;
        int i9;
        Object valueOf3;
        Unsafe unsafe = zzb;
        long j3 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    valueOf = Double.valueOf(zzdq.c(bArr, i));
                    unsafe.putObject(t, j, valueOf);
                    b = i + 8;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    valueOf2 = Float.valueOf(zzdq.d(bArr, i));
                    unsafe.putObject(t, j, valueOf2);
                    b = i + 4;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    b = zzdq.b(bArr, i, zzdtVar);
                    j2 = zzdtVar.zzb;
                    valueOf3 = Long.valueOf(j2);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    b = zzdq.a(bArr, i, zzdtVar);
                    i9 = zzdtVar.zza;
                    valueOf3 = Integer.valueOf(i9);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    valueOf = Long.valueOf(zzdq.b(bArr, i));
                    unsafe.putObject(t, j, valueOf);
                    b = i + 8;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    valueOf2 = Integer.valueOf(zzdq.a(bArr, i));
                    unsafe.putObject(t, j, valueOf2);
                    b = i + 4;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    b = zzdq.b(bArr, i, zzdtVar);
                    valueOf3 = Boolean.valueOf(zzdtVar.zzb != 0);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    b = zzdq.a(bArr, i, zzdtVar);
                    int i10 = zzdtVar.zza;
                    if (i10 == 0) {
                        valueOf3 = "";
                        unsafe.putObject(t, j, valueOf3);
                        unsafe.putInt(t, j3, i4);
                        return b;
                    }
                    if ((i6 & 536870912) != 0 && !zzie.zza(bArr, b, b + i10)) {
                        throw zzfo.h();
                    }
                    unsafe.putObject(t, j, new String(bArr, b, i10, zzff.a));
                    b += i10;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    b = zzdq.a(zza(i8), bArr, i, i2, zzdtVar);
                    Object object = unsafe.getInt(t, j3) == i4 ? unsafe.getObject(t, j) : null;
                    valueOf3 = zzdtVar.zzc;
                    if (object != null) {
                        valueOf3 = zzff.a(object, valueOf3);
                    }
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    b = zzdq.e(bArr, i, zzdtVar);
                    valueOf3 = zzdtVar.zzc;
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int a = zzdq.a(bArr, i, zzdtVar);
                    int i11 = zzdtVar.zza;
                    zzfk zzc = zzc(i8);
                    if (zzc != null && !zzc.zza(i11)) {
                        zze(t).a(i3, Long.valueOf(i11));
                        return a;
                    }
                    unsafe.putObject(t, j, Integer.valueOf(i11));
                    b = a;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    b = zzdq.a(bArr, i, zzdtVar);
                    i9 = zzeg.zze(zzdtVar.zza);
                    valueOf3 = Integer.valueOf(i9);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    b = zzdq.b(bArr, i, zzdtVar);
                    j2 = zzeg.zza(zzdtVar.zzb);
                    valueOf3 = Long.valueOf(j2);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    b = zzdq.a(zza(i8), bArr, i, i2, (i3 & (-8)) | 4, zzdtVar);
                    Object object2 = unsafe.getInt(t, j3) == i4 ? unsafe.getObject(t, j) : null;
                    valueOf3 = zzdtVar.zzc;
                    if (object2 != null) {
                        valueOf3 = zzff.a(object2, valueOf3);
                    }
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0150, code lost:
    
        r11.add(com.google.android.gms.internal.measurement.zzdu.zza(r18, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x026e, code lost:
    
        if (r30.zzb != 0) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0270, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0273, code lost:
    
        r11.zza(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0276, code lost:
    
        if (r4 >= r20) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0278, code lost:
    
        r6 = com.google.android.gms.internal.measurement.zzdq.a(r18, r4, r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x027e, code lost:
    
        if (r21 != r30.zza) goto L277;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0280, code lost:
    
        r4 = com.google.android.gms.internal.measurement.zzdq.b(r18, r6, r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0288, code lost:
    
        if (r30.zzb == 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0272, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0273, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0140, code lost:
    
        if (r4 == 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0142, code lost:
    
        r11.add(com.google.android.gms.internal.measurement.zzdu.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0150, code lost:
    
        if (r1 >= r20) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0152, code lost:
    
        r4 = com.google.android.gms.internal.measurement.zzdq.a(r18, r1, r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0158, code lost:
    
        if (r21 != r30.zza) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x015a, code lost:
    
        r1 = com.google.android.gms.internal.measurement.zzdq.a(r18, r4, r30);
        r4 = r30.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0160, code lost:
    
        if (r4 < 0) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0164, code lost:
    
        if (r4 > (r18.length - r1)) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0166, code lost:
    
        if (r4 != 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0148, code lost:
    
        r11.add(com.google.android.gms.internal.measurement.zzdu.zza(r18, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x016d, code lost:
    
        throw com.google.android.gms.internal.measurement.zzfo.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0172, code lost:
    
        throw com.google.android.gms.internal.measurement.zzfo.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0203  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0213 -> B:106:0x01ea). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:149:0x0288 -> B:143:0x0270). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0166 -> B:63:0x0142). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01cf -> B:89:0x01ae). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzdt r30) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzdt):int");
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzdt zzdtVar) {
        Unsafe unsafe = zzb;
        Object zzb2 = zzb(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzs.zzc(object)) {
            Object zze = this.zzs.zze(zzb2);
            this.zzs.zza(zze, object);
            unsafe.putObject(t, j, zze);
            object = zze;
        }
        zzgf<?, ?> zzf = this.zzs.zzf(zzb2);
        Map<?, ?> zza2 = this.zzs.zza(object);
        int a = zzdq.a(bArr, i, zzdtVar);
        int i4 = zzdtVar.zza;
        if (i4 < 0 || i4 > i2 - a) {
            throw zzfo.a();
        }
        int i5 = i4 + a;
        K k = zzf.zzb;
        V v = zzf.zzd;
        while (a < i5) {
            int i6 = a + 1;
            int i7 = bArr[a];
            if (i7 < 0) {
                i6 = zzdq.a(i7, bArr, i6, zzdtVar);
                i7 = zzdtVar.zza;
            }
            int i8 = i6;
            int i9 = i7 >>> 3;
            int i10 = i7 & 7;
            if (i9 != 1) {
                if (i9 == 2 && i10 == zzf.zzc.zzb()) {
                    a = zza(bArr, i8, i2, zzf.zzc, zzf.zzd.getClass(), zzdtVar);
                    v = zzdtVar.zzc;
                }
                a = zzdq.a(i7, bArr, i8, i2, zzdtVar);
            } else if (i10 == zzf.zza.zzb()) {
                a = zza(bArr, i8, i2, zzf.zza, (Class<?>) null, zzdtVar);
                k = (K) zzdtVar.zzc;
            } else {
                a = zzdq.a(i7, bArr, i8, i2, zzdtVar);
            }
        }
        if (a != i5) {
            throw zzfo.g();
        }
        zza2.put(k, v);
        return i5;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    private static int zza(byte[] bArr, int i, int i2, zzim zzimVar, Class<?> cls, zzdt zzdtVar) {
        int b;
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        int i3;
        long j;
        switch (zzgr.a[zzimVar.ordinal()]) {
            case 1:
                b = zzdq.b(bArr, i, zzdtVar);
                valueOf = Boolean.valueOf(zzdtVar.zzb != 0);
                zzdtVar.zzc = valueOf;
                return b;
            case 2:
                return zzdq.e(bArr, i, zzdtVar);
            case 3:
                valueOf2 = Double.valueOf(zzdq.c(bArr, i));
                zzdtVar.zzc = valueOf2;
                return i + 8;
            case 4:
            case 5:
                valueOf3 = Integer.valueOf(zzdq.a(bArr, i));
                zzdtVar.zzc = valueOf3;
                return i + 4;
            case 6:
            case 7:
                valueOf2 = Long.valueOf(zzdq.b(bArr, i));
                zzdtVar.zzc = valueOf2;
                return i + 8;
            case 8:
                valueOf3 = Float.valueOf(zzdq.d(bArr, i));
                zzdtVar.zzc = valueOf3;
                return i + 4;
            case 9:
            case 10:
            case 11:
                b = zzdq.a(bArr, i, zzdtVar);
                i3 = zzdtVar.zza;
                valueOf = Integer.valueOf(i3);
                zzdtVar.zzc = valueOf;
                return b;
            case 12:
            case 13:
                b = zzdq.b(bArr, i, zzdtVar);
                j = zzdtVar.zzb;
                valueOf = Long.valueOf(j);
                zzdtVar.zzc = valueOf;
                return b;
            case 14:
                return zzdq.a(zzgz.zza().zza((Class) cls), bArr, i, i2, zzdtVar);
            case 15:
                b = zzdq.a(bArr, i, zzdtVar);
                i3 = zzeg.zze(zzdtVar.zza);
                valueOf = Integer.valueOf(i3);
                zzdtVar.zzc = valueOf;
                return b;
            case 16:
                b = zzdq.b(bArr, i, zzdtVar);
                j = zzeg.zza(zzdtVar.zzb);
                valueOf = Long.valueOf(j);
                zzdtVar.zzc = valueOf;
                return b;
            case 17:
                return zzdq.d(bArr, i, zzdtVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final zzhd zza(int i) {
        int i2 = (i / 3) << 1;
        zzhd zzhdVar = (zzhd) this.zzd[i2];
        if (zzhdVar != null) {
            return zzhdVar;
        }
        zzhd<T> zza2 = zzgz.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfk zzfkVar, UB ub, zzhv<UT, UB> zzhvVar) {
        zzgf<?, ?> zzf = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzfkVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzhvVar.a();
                }
                zzec zzc = zzdu.zzc(zzgg.a(zzf, next.getKey(), next.getValue()));
                try {
                    zzgg.a(zzc.zzb(), zzf, next.getKey(), next.getValue());
                    zzhvVar.a((zzhv<UT, UB>) ub, i2, zzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzhv<UT, UB> zzhvVar) {
        zzfk zzc;
        int i2 = this.zzc[i];
        Object f = zzib.f(obj, zzd(i) & 1048575);
        return (f == null || (zzc = zzc(i)) == null) ? ub : (UB) zza(i, i2, this.zzs.zza(f), zzc, (zzfk) ub, (zzhv<UT, zzfk>) zzhvVar);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzib.f(obj, j);
    }

    private static void zza(int i, Object obj, zzis zzisVar) {
        if (obj instanceof String) {
            zzisVar.zza(i, (String) obj);
        } else {
            zzisVar.zza(i, (zzdu) obj);
        }
    }

    private static <UT, UB> void zza(zzhv<UT, UB> zzhvVar, T t, zzis zzisVar) {
        zzhvVar.a((zzhv<UT, UB>) zzhvVar.b(t), zzisVar);
    }

    private final <K, V> void zza(zzis zzisVar, int i, Object obj, int i2) {
        if (obj != null) {
            zzisVar.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private final void zza(Object obj, int i, zzhe zzheVar) {
        long j;
        Object zzn;
        if (zzf(i)) {
            j = i & 1048575;
            zzn = zzheVar.zzm();
        } else {
            int i2 = i & 1048575;
            if (this.zzi) {
                j = i2;
                zzn = zzheVar.zzl();
            } else {
                j = i2;
                zzn = zzheVar.zzn();
            }
        }
        zzib.a(obj, j, zzn);
    }

    private final void zza(T t, T t2, int i) {
        long zzd = zzd(i) & 1048575;
        if (zza((zzgs<T>) t2, i)) {
            Object f = zzib.f(t, zzd);
            Object f2 = zzib.f(t2, zzd);
            if (f != null && f2 != null) {
                zzib.a(t, zzd, zzff.a(f, f2));
                zzb((zzgs<T>) t, i);
            } else if (f2 != null) {
                zzib.a(t, zzd, f2);
                zzb((zzgs<T>) t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        if (!this.zzj) {
            int zze = zze(i);
            return (zzib.a(t, (long) (zze & 1048575)) & (1 << (zze >>> 20))) != 0;
        }
        int zzd = zzd(i);
        long j = zzd & 1048575;
        switch ((zzd & 267386880) >>> 20) {
            case 0:
                return zzib.e(t, j) != 0.0d;
            case 1:
                return zzib.d(t, j) != 0.0f;
            case 2:
                return zzib.b(t, j) != 0;
            case 3:
                return zzib.b(t, j) != 0;
            case 4:
                return zzib.a(t, j) != 0;
            case 5:
                return zzib.b(t, j) != 0;
            case 6:
                return zzib.a(t, j) != 0;
            case 7:
                return zzib.c(t, j);
            case 8:
                Object f = zzib.f(t, j);
                if (f instanceof String) {
                    return !((String) f).isEmpty();
                }
                if (f instanceof zzdu) {
                    return !zzdu.zza.equals(f);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzib.f(t, j) != null;
            case 10:
                return !zzdu.zza.equals(zzib.f(t, j));
            case 11:
                return zzib.a(t, j) != 0;
            case 12:
                return zzib.a(t, j) != 0;
            case 13:
                return zzib.a(t, j) != 0;
            case 14:
                return zzib.b(t, j) != 0;
            case 15:
                return zzib.a(t, j) != 0;
            case 16:
                return zzib.b(t, j) != 0;
            case 17:
                return zzib.f(t, j) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzib.a(t, (long) (zze(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zzj ? zza((zzgs<T>) t, i) : (i2 & i3) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzhd zzhdVar) {
        return zzhdVar.zzd(zzib.f(obj, i & 1048575));
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzib.f(t, j)).doubleValue();
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final void zzb(T t, int i) {
        if (this.zzj) {
            return;
        }
        int zze = zze(i);
        long j = zze & 1048575;
        zzib.a((Object) t, j, zzib.a(t, j) | (1 << (zze >>> 20)));
    }

    private final void zzb(T t, int i, int i2) {
        zzib.a((Object) t, zze(i2) & 1048575, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0089. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzb(T r19, com.google.android.gms.internal.measurement.zzis r20) {
        /*
            Method dump skipped, instructions count: 1324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void");
    }

    private final void zzb(T t, T t2, int i) {
        int zzd = zzd(i);
        int i2 = this.zzc[i];
        long j = zzd & 1048575;
        if (zza((zzgs<T>) t2, i2, i)) {
            Object f = zzib.f(t, j);
            Object f2 = zzib.f(t2, j);
            if (f != null && f2 != null) {
                zzib.a(t, j, zzff.a(f, f2));
                zzb((zzgs<T>) t, i2, i);
            } else if (f2 != null) {
                zzib.a(t, j, f2);
                zzb((zzgs<T>) t, i2, i);
            }
        }
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzib.f(t, j)).floatValue();
    }

    private final zzfk zzc(int i) {
        return (zzfk) this.zzd[((i / 3) << 1) + 1];
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((zzgs<T>) t, i) == zza((zzgs<T>) t2, i);
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzib.f(t, j)).intValue();
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzib.f(t, j)).longValue();
    }

    private static zzhy zze(Object obj) {
        zzfd zzfdVar = (zzfd) obj;
        zzhy zzhyVar = zzfdVar.zzb;
        if (zzhyVar != zzhy.zza()) {
            return zzhyVar;
        }
        zzhy a = zzhy.a();
        zzfdVar.zzb = a;
        return a;
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzib.f(t, j)).booleanValue();
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0478, code lost:
    
        if (r0 == r4) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x047a, code lost:
    
        r26.putInt(r11, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0480, code lost:
    
        r0 = null;
        r1 = r8.zzm;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0485, code lost:
    
        if (r1 >= r8.zzn) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0487, code lost:
    
        r0 = (com.google.android.gms.internal.measurement.zzhy) r8.zza(r11, r8.zzl[r1], (int) r0, (com.google.android.gms.internal.measurement.zzhv<UT, int>) r8.zzq);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0496, code lost:
    
        if (r0 == null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0498, code lost:
    
        r8.zzq.b(r11, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x049f, code lost:
    
        if (r6 != 0) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x04a1, code lost:
    
        if (r2 != r33) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x04a8, code lost:
    
        throw com.google.android.gms.internal.measurement.zzfo.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x04ad, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x04a9, code lost:
    
        if (r2 > r33) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x04ab, code lost:
    
        if (r3 != r6) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x04b3, code lost:
    
        throw com.google.android.gms.internal.measurement.zzfo.g();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:103:0x0083. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.zzdt r35) {
        /*
            Method dump skipped, instructions count: 1246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzdt):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ce, code lost:
    
        if (r3 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e6, code lost:
    
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e2, code lost:
    
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e0, code lost:
    
        if (r3 != null) goto L68;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzhd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(T r9) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0083. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zza(T t, zzhe zzheVar, zzeq zzeqVar) {
        long j;
        Object a;
        int zzp;
        List<Double> a2;
        List<Float> a3;
        List<Long> a4;
        List<Long> a5;
        List<Integer> a6;
        List<Long> a7;
        List<Integer> a8;
        List<Boolean> a9;
        List<Integer> a10;
        List<Integer> a11;
        zzfk zzc;
        List<Integer> a12;
        List<Long> a13;
        List<Integer> a14;
        List<Long> a15;
        if (zzeqVar == null) {
            throw new NullPointerException();
        }
        zzhv zzhvVar = this.zzq;
        zzes<?> zzesVar = this.zzr;
        zzew<?> zzewVar = null;
        Object obj = null;
        while (true) {
            try {
                int zza2 = zzheVar.zza();
                int zzg = zzg(zza2);
                if (zzg >= 0) {
                    int zzd = zzd(zzg);
                    switch ((267386880 & zzd) >>> 20) {
                        case 0:
                            zzib.a(t, zzd & 1048575, zzheVar.zzd());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 1:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zze());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 2:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zzg());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 3:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zzf());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 4:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zzh());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 5:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zzi());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 6:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zzj());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 7:
                            zzib.a(t, zzd & 1048575, zzheVar.zzk());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 8:
                            zza(t, zzd, zzheVar);
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 9:
                            if (zza((zzgs<T>) t, zzg)) {
                                j = zzd & 1048575;
                                a = zzff.a(zzib.f(t, j), zzheVar.zza(zza(zzg), zzeqVar));
                                zzib.a(t, j, a);
                                break;
                            } else {
                                zzib.a(t, zzd & 1048575, zzheVar.zza(zza(zzg), zzeqVar));
                                zzb((zzgs<T>) t, zzg);
                                break;
                            }
                        case 10:
                            zzib.a(t, zzd & 1048575, zzheVar.zzn());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 11:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zzo());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 12:
                            zzp = zzheVar.zzp();
                            zzfk zzc2 = zzc(zzg);
                            if (zzc2 != null && !zzc2.zza(zzp)) {
                                obj = zzhf.a(zza2, zzp, obj, (zzhv<UT, Object>) zzhvVar);
                                break;
                            } else {
                                zzib.a((Object) t, zzd & 1048575, zzp);
                                zzb((zzgs<T>) t, zzg);
                                break;
                            }
                            break;
                        case 13:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zzq());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 14:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zzr());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 15:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zzs());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 16:
                            zzib.a((Object) t, zzd & 1048575, zzheVar.zzt());
                            zzb((zzgs<T>) t, zzg);
                            break;
                        case 17:
                            if (zza((zzgs<T>) t, zzg)) {
                                j = zzd & 1048575;
                                a = zzff.a(zzib.f(t, j), zzheVar.zzb(zza(zzg), zzeqVar));
                                zzib.a(t, j, a);
                                break;
                            } else {
                                zzib.a(t, zzd & 1048575, zzheVar.zzb(zza(zzg), zzeqVar));
                                zzb((zzgs<T>) t, zzg);
                                break;
                            }
                        case 18:
                            a2 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zza(a2);
                            break;
                        case 19:
                            a3 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzb(a3);
                            break;
                        case 20:
                            a4 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzd(a4);
                            break;
                        case 21:
                            a5 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzc(a5);
                            break;
                        case 22:
                            a6 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zze(a6);
                            break;
                        case 23:
                            a7 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzf(a7);
                            break;
                        case 24:
                            a8 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzg(a8);
                            break;
                        case 25:
                            a9 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzh(a9);
                            break;
                        case 26:
                            if (zzf(zzd)) {
                                zzheVar.zzj(this.zzp.a(t, zzd & 1048575));
                                break;
                            } else {
                                zzheVar.zzi(this.zzp.a(t, zzd & 1048575));
                                break;
                            }
                        case 27:
                            zzheVar.zza(this.zzp.a(t, zzd & 1048575), zza(zzg), zzeqVar);
                            break;
                        case 28:
                            zzheVar.zzk(this.zzp.a(t, zzd & 1048575));
                            break;
                        case 29:
                            a10 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzl(a10);
                            break;
                        case 30:
                            a11 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzm(a11);
                            zzc = zzc(zzg);
                            obj = zzhf.a(zza2, a11, zzc, obj, zzhvVar);
                            break;
                        case 31:
                            a12 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzn(a12);
                            break;
                        case 32:
                            a13 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzo(a13);
                            break;
                        case 33:
                            a14 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzp(a14);
                            break;
                        case 34:
                            a15 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzq(a15);
                            break;
                        case 35:
                            a2 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zza(a2);
                            break;
                        case 36:
                            a3 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzb(a3);
                            break;
                        case 37:
                            a4 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzd(a4);
                            break;
                        case 38:
                            a5 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzc(a5);
                            break;
                        case 39:
                            a6 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zze(a6);
                            break;
                        case 40:
                            a7 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzf(a7);
                            break;
                        case 41:
                            a8 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzg(a8);
                            break;
                        case 42:
                            a9 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzh(a9);
                            break;
                        case 43:
                            a10 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzl(a10);
                            break;
                        case 44:
                            a11 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzm(a11);
                            zzc = zzc(zzg);
                            obj = zzhf.a(zza2, a11, zzc, obj, zzhvVar);
                            break;
                        case 45:
                            a12 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzn(a12);
                            break;
                        case 46:
                            a13 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzo(a13);
                            break;
                        case 47:
                            a14 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzp(a14);
                            break;
                        case 48:
                            a15 = this.zzp.a(t, zzd & 1048575);
                            zzheVar.zzq(a15);
                            break;
                        case 49:
                            zzheVar.zzb(this.zzp.a(t, zzd & 1048575), zza(zzg), zzeqVar);
                            break;
                        case 50:
                            Object zzb2 = zzb(zzg);
                            long zzd2 = zzd(zzg) & 1048575;
                            Object f = zzib.f(t, zzd2);
                            if (f == null) {
                                f = this.zzs.zze(zzb2);
                                zzib.a(t, zzd2, f);
                            } else if (this.zzs.zzc(f)) {
                                Object zze = this.zzs.zze(zzb2);
                                this.zzs.zza(zze, f);
                                zzib.a(t, zzd2, zze);
                                f = zze;
                            }
                            zzheVar.zza(this.zzs.zza(f), this.zzs.zzf(zzb2), zzeqVar);
                            break;
                        case 51:
                            zzib.a(t, zzd & 1048575, Double.valueOf(zzheVar.zzd()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 52:
                            zzib.a(t, zzd & 1048575, Float.valueOf(zzheVar.zze()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 53:
                            zzib.a(t, zzd & 1048575, Long.valueOf(zzheVar.zzg()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 54:
                            zzib.a(t, zzd & 1048575, Long.valueOf(zzheVar.zzf()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 55:
                            zzib.a(t, zzd & 1048575, Integer.valueOf(zzheVar.zzh()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 56:
                            zzib.a(t, zzd & 1048575, Long.valueOf(zzheVar.zzi()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 57:
                            zzib.a(t, zzd & 1048575, Integer.valueOf(zzheVar.zzj()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 58:
                            zzib.a(t, zzd & 1048575, Boolean.valueOf(zzheVar.zzk()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 59:
                            zza(t, zzd, zzheVar);
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 60:
                            int i = zzd & 1048575;
                            if (zza((zzgs<T>) t, zza2, zzg)) {
                                long j2 = i;
                                zzib.a(t, j2, zzff.a(zzib.f(t, j2), zzheVar.zza(zza(zzg), zzeqVar)));
                            } else {
                                zzib.a(t, i, zzheVar.zza(zza(zzg), zzeqVar));
                                zzb((zzgs<T>) t, zzg);
                            }
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 61:
                            zzib.a(t, zzd & 1048575, zzheVar.zzn());
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 62:
                            zzib.a(t, zzd & 1048575, Integer.valueOf(zzheVar.zzo()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 63:
                            zzp = zzheVar.zzp();
                            zzfk zzc3 = zzc(zzg);
                            if (zzc3 != null && !zzc3.zza(zzp)) {
                                obj = zzhf.a(zza2, zzp, obj, (zzhv<UT, Object>) zzhvVar);
                                break;
                            }
                            zzib.a(t, zzd & 1048575, Integer.valueOf(zzp));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 64:
                            zzib.a(t, zzd & 1048575, Integer.valueOf(zzheVar.zzq()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 65:
                            zzib.a(t, zzd & 1048575, Long.valueOf(zzheVar.zzr()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 66:
                            zzib.a(t, zzd & 1048575, Integer.valueOf(zzheVar.zzs()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 67:
                            zzib.a(t, zzd & 1048575, Long.valueOf(zzheVar.zzt()));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        case 68:
                            zzib.a(t, zzd & 1048575, zzheVar.zzb(zza(zzg), zzeqVar));
                            zzb((zzgs<T>) t, zza2, zzg);
                            break;
                        default:
                            if (obj == null) {
                                try {
                                    obj = zzhvVar.a();
                                } catch (zzfn unused) {
                                    zzhvVar.a(zzheVar);
                                    if (obj == null) {
                                        obj = zzhvVar.c(t);
                                    }
                                    if (!zzhvVar.a((zzhv) obj, zzheVar)) {
                                        for (int i2 = this.zzm; i2 < this.zzn; i2++) {
                                            obj = zza((Object) t, this.zzl[i2], (int) obj, (zzhv<UT, int>) zzhvVar);
                                        }
                                        if (obj != null) {
                                            zzhvVar.b((Object) t, (T) obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!zzhvVar.a((zzhv) obj, zzheVar)) {
                                for (int i3 = this.zzm; i3 < this.zzn; i3++) {
                                    obj = zza((Object) t, this.zzl[i3], (int) obj, (zzhv<UT, int>) zzhvVar);
                                }
                                if (obj != null) {
                                    zzhvVar.b((Object) t, (T) obj);
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                } else {
                    if (zza2 == Integer.MAX_VALUE) {
                        for (int i4 = this.zzm; i4 < this.zzn; i4++) {
                            obj = zza((Object) t, this.zzl[i4], (int) obj, (zzhv<UT, int>) zzhvVar);
                        }
                        if (obj != null) {
                            zzhvVar.b((Object) t, (T) obj);
                            return;
                        }
                        return;
                    }
                    Object a16 = !this.zzh ? null : zzesVar.a(zzeqVar, this.zzg, zza2);
                    if (a16 != null) {
                        if (zzewVar == null) {
                            zzewVar = zzesVar.b(t);
                        }
                        zzew<?> zzewVar2 = zzewVar;
                        obj = zzesVar.a(zzheVar, a16, zzeqVar, zzewVar2, obj, zzhvVar);
                        zzewVar = zzewVar2;
                    } else {
                        zzhvVar.a(zzheVar);
                        if (obj == null) {
                            obj = zzhvVar.c(t);
                        }
                        if (!zzhvVar.a((zzhv) obj, zzheVar)) {
                            for (int i5 = this.zzm; i5 < this.zzn; i5++) {
                                obj = zza((Object) t, this.zzl[i5], (int) obj, (zzhv<UT, int>) zzhvVar);
                            }
                            if (obj != null) {
                                zzhvVar.b((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i6 = this.zzm; i6 < this.zzn; i6++) {
                    obj = zza((Object) t, this.zzl[i6], (int) obj, (zzhv<UT, int>) zzhvVar);
                }
                if (obj != null) {
                    zzhvVar.b((Object) t, (T) obj);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0065. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:306:0x0525. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x097b  */
    @Override // com.google.android.gms.internal.measurement.zzhd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzis r15) {
        /*
            Method dump skipped, instructions count: 2742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01f5, code lost:
    
        if (r0 == r15) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0212, code lost:
    
        if (r0 == r15) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        if (r6 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0109, code lost:
    
        r0 = com.google.android.gms.internal.measurement.zzdq.a(r12, r8, r11);
        r1 = r11.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0107, code lost:
    
        if (r6 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c8, code lost:
    
        if (r0 == r15) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0214, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0061. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    @Override // com.google.android.gms.internal.measurement.zzhd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.measurement.zzdt r32) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzdt):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
    
        if (com.google.android.gms.internal.measurement.zzhf.a(com.google.android.gms.internal.measurement.zzib.f(r10, r6), com.google.android.gms.internal.measurement.zzib.f(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.b(r10, r6) == com.google.android.gms.internal.measurement.zzib.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.a(r10, r6) == com.google.android.gms.internal.measurement.zzib.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.b(r10, r6) == com.google.android.gms.internal.measurement.zzib.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.a(r10, r6) == com.google.android.gms.internal.measurement.zzib.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ba, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.a(r10, r6) == com.google.android.gms.internal.measurement.zzib.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cc, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.a(r10, r6) == com.google.android.gms.internal.measurement.zzib.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:
    
        if (com.google.android.gms.internal.measurement.zzhf.a(com.google.android.gms.internal.measurement.zzib.f(r10, r6), com.google.android.gms.internal.measurement.zzib.f(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f8, code lost:
    
        if (com.google.android.gms.internal.measurement.zzhf.a(com.google.android.gms.internal.measurement.zzib.f(r10, r6), com.google.android.gms.internal.measurement.zzib.f(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010e, code lost:
    
        if (com.google.android.gms.internal.measurement.zzhf.a(com.google.android.gms.internal.measurement.zzib.f(r10, r6), com.google.android.gms.internal.measurement.zzib.f(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0120, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.c(r10, r6) == com.google.android.gms.internal.measurement.zzib.c(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0132, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.a(r10, r6) == com.google.android.gms.internal.measurement.zzib.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.b(r10, r6) == com.google.android.gms.internal.measurement.zzib.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0156, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.a(r10, r6) == com.google.android.gms.internal.measurement.zzib.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0169, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.b(r10, r6) == com.google.android.gms.internal.measurement.zzib.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017c, code lost:
    
        if (com.google.android.gms.internal.measurement.zzib.b(r10, r6) == com.google.android.gms.internal.measurement.zzib.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0195, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzib.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzib.d(r11, r6))) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b0, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzib.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzib.e(r11, r6))) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.measurement.zzhf.a(com.google.android.gms.internal.measurement.zzib.f(r10, r6), com.google.android.gms.internal.measurement.zzib.f(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b6 A[LOOP:0: B:2:0x0005->B:85:0x01b6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b5 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzhd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0127, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0211, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zzen.zze(r3) + com.google.android.gms.internal.measurement.zzen.zzg(r5)) + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x020d, code lost:
    
        r2.putInt(r20, r14, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0139, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x014b, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x015d, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x016f, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0181, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0193, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01a5, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01b6, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01c7, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01d8, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01e9, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01fa, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x020b, code lost:
    
        if (r19.zzk != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0331, code lost:
    
        if ((r5 instanceof com.google.android.gms.internal.measurement.zzdu) != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0417, code lost:
    
        if (zza((com.google.android.gms.internal.measurement.zzgs<T>) r20, r15, r3) != false) goto L399;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x06d0, code lost:
    
        r4 = com.google.android.gms.internal.measurement.zzen.c(r15, (com.google.android.gms.internal.measurement.zzgo) r2.getObject(r20, r8), zza(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0437, code lost:
    
        if (zza((com.google.android.gms.internal.measurement.zzgs<T>) r20, r15, r3) != false) goto L410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x06fd, code lost:
    
        r4 = com.google.android.gms.internal.measurement.zzen.zzh(r15, 0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x043f, code lost:
    
        if (zza((com.google.android.gms.internal.measurement.zzgs<T>) r20, r15, r3) != false) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0708, code lost:
    
        r8 = com.google.android.gms.internal.measurement.zzen.zzj(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x045f, code lost:
    
        if (zza((com.google.android.gms.internal.measurement.zzgs<T>) r20, r15, r3) != false) goto L425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x072d, code lost:
    
        r4 = r2.getObject(r20, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0731, code lost:
    
        r4 = com.google.android.gms.internal.measurement.zzen.zzc(r15, (com.google.android.gms.internal.measurement.zzdu) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0467, code lost:
    
        if (zza((com.google.android.gms.internal.measurement.zzgs<T>) r20, r15, r3) != false) goto L429;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x073c, code lost:
    
        r4 = com.google.android.gms.internal.measurement.zzhf.a(r15, r2.getObject(r20, r8), zza(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0477, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.measurement.zzdu) != false) goto L426;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0757, code lost:
    
        r4 = com.google.android.gms.internal.measurement.zzen.zzb(r15, (java.lang.String) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x051c, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0606, code lost:
    
        r8 = (com.google.android.gms.internal.measurement.zzen.zze(r15) + com.google.android.gms.internal.measurement.zzen.zzg(r4)) + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0602, code lost:
    
        r2.putInt(r20, r11, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x052e, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0540, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x0552, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0564, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0576, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0588, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x059a, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x05ab, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x05bc, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x05cd, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x05de, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x05ef, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0600, code lost:
    
        if (r19.zzk != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x06ce, code lost:
    
        if ((r12 & r18) != 0) goto L399;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x06fb, code lost:
    
        if ((r12 & r18) != 0) goto L410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x0706, code lost:
    
        if ((r12 & r18) != 0) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x072b, code lost:
    
        if ((r12 & r18) != 0) goto L425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x073a, code lost:
    
        if ((r12 & r18) != 0) goto L429;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x0754, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.measurement.zzdu) != false) goto L426;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ab, code lost:
    
        if ((r5 instanceof com.google.android.gms.internal.measurement.zzdu) != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0334, code lost:
    
        r3 = com.google.android.gms.internal.measurement.zzen.zzb(r3, (java.lang.String) r5);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:263:0x040e. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzhd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(T r20) {
        /*
            Method dump skipped, instructions count: 2396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001a. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zzb(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzd = zzd(i);
            long j = 1048575 & zzd;
            int i2 = this.zzc[i];
            switch ((zzd & 267386880) >>> 20) {
                case 0:
                    if (zza((zzgs<T>) t2, i)) {
                        zzib.a(t, j, zzib.e(t2, j));
                        zzb((zzgs<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzgs<T>) t2, i)) {
                        zzib.a((Object) t, j, zzib.d(t2, j));
                        zzb((zzgs<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.b(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 3:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.b(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 4:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.a(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 5:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.b(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 6:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.a(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 7:
                    if (zza((zzgs<T>) t2, i)) {
                        zzib.a(t, j, zzib.c(t2, j));
                        zzb((zzgs<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a(t, j, zzib.f(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 9:
                case 17:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a(t, j, zzib.f(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 11:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.a(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 12:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.a(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 13:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.a(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 14:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.b(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 15:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.a(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 16:
                    if (!zza((zzgs<T>) t2, i)) {
                        break;
                    }
                    zzib.a((Object) t, j, zzib.b(t2, j));
                    zzb((zzgs<T>) t, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
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
                    this.zzp.a(t, t2, j);
                    break;
                case 50:
                    zzhf.a(this.zzs, t, t2, j);
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
                    if (!zza((zzgs<T>) t2, i2, i)) {
                        break;
                    }
                    zzib.a(t, j, zzib.f(t2, j));
                    zzb((zzgs<T>) t, i2, i);
                    break;
                case 60:
                case 68:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zza((zzgs<T>) t2, i2, i)) {
                        break;
                    }
                    zzib.a(t, j, zzib.f(t2, j));
                    zzb((zzgs<T>) t, i2, i);
                    break;
            }
        }
        if (this.zzj) {
            return;
        }
        zzhf.a(this.zzq, t, t2);
        if (this.zzh) {
            zzhf.a(this.zzr, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd = zzd(this.zzl[i2]) & 1048575;
            Object f = zzib.f(t, zzd);
            if (f != null) {
                zzib.a(t, zzd, this.zzs.zzd(f));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.b(t, this.zzl[i]);
            i++;
        }
        this.zzq.d(t);
        if (this.zzh) {
            this.zzr.c(t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.measurement.zzhd] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.measurement.zzhd] */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final boolean zzd(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.zzm) {
                return !this.zzh || this.zzr.a(t).zzf();
            }
            int i5 = this.zzl[i2];
            int i6 = this.zzc[i5];
            int zzd = zzd(i5);
            if (this.zzj) {
                i = 0;
            } else {
                int i7 = this.zzc[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = zzb.getInt(t, i8);
                    i3 = i8;
                }
            }
            if (((268435456 & zzd) != 0) && !zza((zzgs<T>) t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzd) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza((zzgs<T>) t, i6, i5) && !zza(t, zzd, zza(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzb2 = this.zzs.zzb(zzib.f(t, zzd & 1048575));
                            if (!zzb2.isEmpty()) {
                                if (this.zzs.zzf(zzb(i5)).zzc.zza() == zzip.MESSAGE) {
                                    ?? r4 = 0;
                                    Iterator<?> it = zzb2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        r4 = r4;
                                        if (r4 == 0) {
                                            r4 = zzgz.zza().zza((Class) next.getClass());
                                        }
                                        if (!r4.zzd(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzib.f(t, zzd & 1048575);
                if (!list.isEmpty()) {
                    ?? zza2 = zza(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        }
                        if (!zza2.zzd(list.get(i10))) {
                            z = false;
                            break;
                        }
                        i10++;
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza((zzgs<T>) t, i5, i4, i) && !zza(t, zzd, zza(i5))) {
                return false;
            }
            i2++;
        }
    }
}
