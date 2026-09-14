package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdti<T> implements zzdua<T> {
    private final int[] zzhox;
    private final Object[] zzhoy;
    private final int zzhoz;
    private final int zzhpa;
    private final zzdte zzhpb;
    private final boolean zzhpc;
    private final boolean zzhpd;
    private final boolean zzhpe;
    private final boolean zzhpf;
    private final int[] zzhpg;
    private final int zzhph;
    private final int zzhpi;
    private final zzdtm zzhpj;
    private final zzdso zzhpk;
    private final zzdus<?, ?> zzhpl;
    private final zzdri<?> zzhpm;
    private final zzdsx zzhpn;
    private static final int[] zzhow = new int[0];
    private static final Unsafe zzgvq = zzduy.c();

    private zzdti(int[] iArr, Object[] objArr, int i, int i2, zzdte zzdteVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzdtm zzdtmVar, zzdso zzdsoVar, zzdus<?, ?> zzdusVar, zzdri<?> zzdriVar, zzdsx zzdsxVar) {
        this.zzhox = iArr;
        this.zzhoy = objArr;
        this.zzhoz = i;
        this.zzhpa = i2;
        this.zzhpd = zzdteVar instanceof zzdrt;
        this.zzhpe = z;
        this.zzhpc = zzdriVar != null && zzdriVar.a(zzdteVar);
        this.zzhpf = false;
        this.zzhpg = iArr2;
        this.zzhph = i3;
        this.zzhpi = i4;
        this.zzhpj = zzdtmVar;
        this.zzhpk = zzdsoVar;
        this.zzhpl = zzdusVar;
        this.zzhpm = zzdriVar;
        this.zzhpb = zzdteVar;
        this.zzhpn = zzdsxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> zzdti<T> a(Class<T> cls, zzdtc zzdtcVar, zzdtm zzdtmVar, zzdso zzdsoVar, zzdus<?, ?> zzdusVar, zzdri<?> zzdriVar, zzdsx zzdsxVar) {
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
        Field zza;
        int i20;
        char charAt12;
        int i21;
        int i22;
        Field zza2;
        Field zza3;
        int i23;
        char charAt13;
        int i24;
        char charAt14;
        int i25;
        char charAt15;
        char charAt16;
        char charAt17;
        if (!(zzdtcVar instanceof zzdtr)) {
            ((zzdul) zzdtcVar).zzbbg();
            int i26 = zzdrt.zze.zzhnb;
            throw new NoSuchMethodError();
        }
        zzdtr zzdtrVar = (zzdtr) zzdtcVar;
        int i27 = 0;
        boolean z = zzdtrVar.zzbbg() == zzdrt.zze.zzhnb;
        String a = zzdtrVar.a();
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
            iArr = zzhow;
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
        Unsafe unsafe = zzgvq;
        Object[] b = zzdtrVar.b();
        Class<?> cls3 = zzdtrVar.zzbbi().getClass();
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
                    zza2 = (Field) obj;
                } else {
                    zza2 = zza(cls3, (String) obj);
                    b[i84] = zza2;
                }
                char c8 = c2;
                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zza2);
                int i85 = i84 + 1;
                Object obj2 = b[i85];
                if (obj2 instanceof Field) {
                    zza3 = (Field) obj2;
                } else {
                    zza3 = zza(cls3, (String) obj2);
                    b[i85] = zza3;
                }
                str = a;
                i19 = (int) unsafe.objectFieldOffset(zza3);
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
                Field zza4 = zza(cls3, (String) b[i61]);
                c3 = charAt;
                if (i77 == 9 || i77 == 17) {
                    c4 = c9;
                    objArr[((i66 / 3) << 1) + 1] = zza4.getType();
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
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zza4);
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
                            zza = (Field) obj3;
                        } else {
                            zza = zza(cls3, (String) obj3);
                            b[i92] = zza;
                        }
                        cls2 = cls3;
                        i16 = i86;
                        i19 = (int) unsafe.objectFieldOffset(zza);
                        i18 = charAt27 % 32;
                    }
                    if (i77 >= 18 && i77 <= 49) {
                        iArr[i64] = objectFieldOffset;
                        i64++;
                    }
                    i2 = i17;
                }
                i15 = charAt24;
                objectFieldOffset = (int) unsafe.objectFieldOffset(zza4);
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
        return new zzdti<>(iArr2, objArr, c2, charAt, zzdtrVar.zzbbi(), z, false, iArr, i27, i62, zzdtmVar, zzdsoVar, zzdusVar, zzdriVar, zzdsxVar);
    }

    private static <UT, UB> int zza(zzdus<UT, UB> zzdusVar, T t) {
        return zzdusVar.c(zzdusVar.d(t));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzdqf zzdqfVar) {
        Object valueOf;
        Object valueOf2;
        int b;
        long j2;
        int i9;
        Object valueOf3;
        Unsafe unsafe = zzgvq;
        long j3 = this.zzhox[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    valueOf = Double.valueOf(zzdqg.c(bArr, i));
                    unsafe.putObject(t, j, valueOf);
                    b = i + 8;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    valueOf2 = Float.valueOf(zzdqg.d(bArr, i));
                    unsafe.putObject(t, j, valueOf2);
                    b = i + 4;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    b = zzdqg.b(bArr, i, zzdqfVar);
                    j2 = zzdqfVar.zzhhr;
                    valueOf3 = Long.valueOf(j2);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    b = zzdqg.a(bArr, i, zzdqfVar);
                    i9 = zzdqfVar.zzhhq;
                    valueOf3 = Integer.valueOf(i9);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    valueOf = Long.valueOf(zzdqg.b(bArr, i));
                    unsafe.putObject(t, j, valueOf);
                    b = i + 8;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    valueOf2 = Integer.valueOf(zzdqg.a(bArr, i));
                    unsafe.putObject(t, j, valueOf2);
                    b = i + 4;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    b = zzdqg.b(bArr, i, zzdqfVar);
                    valueOf3 = Boolean.valueOf(zzdqfVar.zzhhr != 0);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    b = zzdqg.a(bArr, i, zzdqfVar);
                    int i10 = zzdqfVar.zzhhq;
                    if (i10 == 0) {
                        valueOf3 = "";
                        unsafe.putObject(t, j, valueOf3);
                        unsafe.putInt(t, j3, i4);
                        return b;
                    }
                    if ((i6 & 536870912) != 0 && !zzdva.zzm(bArr, b, b + i10)) {
                        throw zzdse.i();
                    }
                    unsafe.putObject(t, j, new String(bArr, b, i10, zzdrv.a));
                    b += i10;
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    b = zzdqg.a(zzgn(i8), bArr, i, i2, zzdqfVar);
                    Object object = unsafe.getInt(t, j3) == i4 ? unsafe.getObject(t, j) : null;
                    valueOf3 = zzdqfVar.zzhhs;
                    if (object != null) {
                        valueOf3 = zzdrv.a(object, valueOf3);
                    }
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    b = zzdqg.e(bArr, i, zzdqfVar);
                    valueOf3 = zzdqfVar.zzhhs;
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int a = zzdqg.a(bArr, i, zzdqfVar);
                    int i11 = zzdqfVar.zzhhq;
                    zzdsa zzgp = zzgp(i8);
                    if (zzgp != null && !zzgp.zzf(i11)) {
                        zzay(t).a(i3, Long.valueOf(i11));
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
                    b = zzdqg.a(bArr, i, zzdqfVar);
                    i9 = zzdqw.zzfl(zzdqfVar.zzhhq);
                    valueOf3 = Integer.valueOf(i9);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    b = zzdqg.b(bArr, i, zzdqfVar);
                    j2 = zzdqw.zzff(zzdqfVar.zzhhr);
                    valueOf3 = Long.valueOf(j2);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    b = zzdqg.a(zzgn(i8), bArr, i, i2, (i3 & (-8)) | 4, zzdqfVar);
                    Object object2 = unsafe.getInt(t, j3) == i4 ? unsafe.getObject(t, j) : null;
                    valueOf3 = zzdqfVar.zzhhs;
                    if (object2 != null) {
                        valueOf3 = zzdrv.a(object2, valueOf3);
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
    
        r11.add(com.google.android.gms.internal.ads.zzdqk.zzi(r18, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x026e, code lost:
    
        if (r30.zzhhr != 0) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0270, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0273, code lost:
    
        r11.addBoolean(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0276, code lost:
    
        if (r4 >= r20) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0278, code lost:
    
        r6 = com.google.android.gms.internal.ads.zzdqg.a(r18, r4, r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x027e, code lost:
    
        if (r21 != r30.zzhhq) goto L277;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0280, code lost:
    
        r4 = com.google.android.gms.internal.ads.zzdqg.b(r18, r6, r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0288, code lost:
    
        if (r30.zzhhr == 0) goto L152;
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
    
        r11.add(com.google.android.gms.internal.ads.zzdqk.zzhhx);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0150, code lost:
    
        if (r1 >= r20) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0152, code lost:
    
        r4 = com.google.android.gms.internal.ads.zzdqg.a(r18, r1, r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0158, code lost:
    
        if (r21 != r30.zzhhq) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x015a, code lost:
    
        r1 = com.google.android.gms.internal.ads.zzdqg.a(r18, r4, r30);
        r4 = r30.zzhhq;
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
    
        r11.add(com.google.android.gms.internal.ads.zzdqk.zzi(r18, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x016d, code lost:
    
        throw com.google.android.gms.internal.ads.zzdse.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0172, code lost:
    
        throw com.google.android.gms.internal.ads.zzdse.b();
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
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.ads.zzdqf r30) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdti.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzdqf):int");
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzdqf zzdqfVar) {
        Unsafe unsafe = zzgvq;
        Object zzgo = zzgo(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzhpn.zzas(object)) {
            Object zzau = this.zzhpn.zzau(zzgo);
            this.zzhpn.zze(zzau, object);
            unsafe.putObject(t, j, zzau);
            object = zzau;
        }
        zzdsv<?, ?> zzav = this.zzhpn.zzav(zzgo);
        Map<?, ?> zzaq = this.zzhpn.zzaq(object);
        int a = zzdqg.a(bArr, i, zzdqfVar);
        int i4 = zzdqfVar.zzhhq;
        if (i4 < 0 || i4 > i2 - a) {
            throw zzdse.a();
        }
        int i5 = i4 + a;
        K k = zzav.zzhor;
        V v = zzav.zzcfu;
        while (a < i5) {
            int i6 = a + 1;
            int i7 = bArr[a];
            if (i7 < 0) {
                i6 = zzdqg.a(i7, bArr, i6, zzdqfVar);
                i7 = zzdqfVar.zzhhq;
            }
            int i8 = i6;
            int i9 = i7 >>> 3;
            int i10 = i7 & 7;
            if (i9 != 1) {
                if (i9 == 2 && i10 == zzav.zzhos.zzbcq()) {
                    a = zza(bArr, i8, i2, zzav.zzhos, zzav.zzcfu.getClass(), zzdqfVar);
                    v = zzdqfVar.zzhhs;
                }
                a = zzdqg.a(i7, bArr, i8, i2, zzdqfVar);
            } else if (i10 == zzav.zzhoq.zzbcq()) {
                a = zza(bArr, i8, i2, zzav.zzhoq, (Class<?>) null, zzdqfVar);
                k = (K) zzdqfVar.zzhhs;
            } else {
                a = zzdqg.a(i7, bArr, i8, i2, zzdqfVar);
            }
        }
        if (a != i5) {
            throw zzdse.h();
        }
        zzaq.put(k, v);
        return i5;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    private static int zza(byte[] bArr, int i, int i2, zzdvf zzdvfVar, Class<?> cls, zzdqf zzdqfVar) {
        int b;
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        int i3;
        long j;
        switch (zzdth.a[zzdvfVar.ordinal()]) {
            case 1:
                b = zzdqg.b(bArr, i, zzdqfVar);
                valueOf = Boolean.valueOf(zzdqfVar.zzhhr != 0);
                zzdqfVar.zzhhs = valueOf;
                return b;
            case 2:
                return zzdqg.e(bArr, i, zzdqfVar);
            case 3:
                valueOf2 = Double.valueOf(zzdqg.c(bArr, i));
                zzdqfVar.zzhhs = valueOf2;
                return i + 8;
            case 4:
            case 5:
                valueOf3 = Integer.valueOf(zzdqg.a(bArr, i));
                zzdqfVar.zzhhs = valueOf3;
                return i + 4;
            case 6:
            case 7:
                valueOf2 = Long.valueOf(zzdqg.b(bArr, i));
                zzdqfVar.zzhhs = valueOf2;
                return i + 8;
            case 8:
                valueOf3 = Float.valueOf(zzdqg.d(bArr, i));
                zzdqfVar.zzhhs = valueOf3;
                return i + 4;
            case 9:
            case 10:
            case 11:
                b = zzdqg.a(bArr, i, zzdqfVar);
                i3 = zzdqfVar.zzhhq;
                valueOf = Integer.valueOf(i3);
                zzdqfVar.zzhhs = valueOf;
                return b;
            case 12:
            case 13:
                b = zzdqg.b(bArr, i, zzdqfVar);
                j = zzdqfVar.zzhhr;
                valueOf = Long.valueOf(j);
                zzdqfVar.zzhhs = valueOf;
                return b;
            case 14:
                return zzdqg.a(zzdtp.zzbbm().zzh(cls), bArr, i, i2, zzdqfVar);
            case 15:
                b = zzdqg.a(bArr, i, zzdqfVar);
                i3 = zzdqw.zzfl(zzdqfVar.zzhhq);
                valueOf = Integer.valueOf(i3);
                zzdqfVar.zzhhs = valueOf;
                return b;
            case 16:
                b = zzdqg.b(bArr, i, zzdqfVar);
                j = zzdqw.zzff(zzdqfVar.zzhhr);
                valueOf = Long.valueOf(j);
                zzdqfVar.zzhhs = valueOf;
                return b;
            case 17:
                return zzdqg.d(bArr, i, zzdqfVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzdsa zzdsaVar, UB ub, zzdus<UT, UB> zzdusVar) {
        zzdsv<?, ?> zzav = this.zzhpn.zzav(zzgo(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzdsaVar.zzf(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzdusVar.a();
                }
                zzdqs b = zzdqk.b(zzdsw.a(zzav, next.getKey(), next.getValue()));
                try {
                    zzdsw.a(b.zzayb(), zzav, next.getKey(), next.getValue());
                    zzdusVar.a((zzdus<UT, UB>) ub, i2, b.zzaya());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzdus<UT, UB> zzdusVar) {
        zzdsa zzgp;
        int i2 = this.zzhox[i];
        Object f = zzduy.f(obj, zzgq(i) & 1048575);
        return (f == null || (zzgp = zzgp(i)) == null) ? ub : (UB) zza(i, i2, this.zzhpn.zzaq(f), zzgp, (zzdsa) ub, (zzdus<UT, zzdsa>) zzdusVar);
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

    private static void zza(int i, Object obj, zzdvl zzdvlVar) {
        if (obj instanceof String) {
            zzdvlVar.zzf(i, (String) obj);
        } else {
            zzdvlVar.zza(i, (zzdqk) obj);
        }
    }

    private static <UT, UB> void zza(zzdus<UT, UB> zzdusVar, T t, zzdvl zzdvlVar) {
        zzdusVar.a((zzdus<UT, UB>) zzdusVar.d(t), zzdvlVar);
    }

    private final <K, V> void zza(zzdvl zzdvlVar, int i, Object obj, int i2) {
        if (obj != null) {
            zzdvlVar.zza(i, this.zzhpn.zzav(zzgo(i2)), this.zzhpn.zzar(obj));
        }
    }

    private final void zza(Object obj, int i, zzdtu zzdtuVar) {
        long j;
        Object zzayk;
        if (zzgs(i)) {
            j = i & 1048575;
            zzayk = zzdtuVar.zzayj();
        } else {
            int i2 = i & 1048575;
            if (this.zzhpd) {
                j = i2;
                zzayk = zzdtuVar.readString();
            } else {
                j = i2;
                zzayk = zzdtuVar.zzayk();
            }
        }
        zzduy.a(obj, j, zzayk);
    }

    private final void zza(T t, T t2, int i) {
        long zzgq = zzgq(i) & 1048575;
        if (zze((zzdti<T>) t2, i)) {
            Object f = zzduy.f(t, zzgq);
            Object f2 = zzduy.f(t2, zzgq);
            if (f != null && f2 != null) {
                zzduy.a(t, zzgq, zzdrv.a(f, f2));
                zzf((zzdti<T>) t, i);
            } else if (f2 != null) {
                zzduy.a(t, zzgq, f2);
                zzf((zzdti<T>) t, i);
            }
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzduy.a(t, (long) (zzgr(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zzhpe ? zze((zzdti<T>) t, i) : (i2 & i3) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzdua zzduaVar) {
        return zzduaVar.zzaz(zzduy.f(obj, i & 1048575));
    }

    private final int zzan(int i, int i2) {
        if (i < this.zzhoz || i > this.zzhpa) {
            return -1;
        }
        return zzao(i, i2);
    }

    private final int zzao(int i, int i2) {
        int length = (this.zzhox.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzhox[i4];
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

    private static zzdur zzay(Object obj) {
        zzdrt zzdrtVar = (zzdrt) obj;
        zzdur zzdurVar = zzdrtVar.zzhmk;
        if (zzdurVar != zzdur.zzbcf()) {
            return zzdurVar;
        }
        zzdur a = zzdur.a();
        zzdrtVar.zzhmk = a;
        return a;
    }

    private final void zzb(T t, int i, int i2) {
        zzduy.a((Object) t, zzgr(i2) & 1048575, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0089. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzb(T r19, com.google.android.gms.internal.ads.zzdvl r20) {
        /*
            Method dump skipped, instructions count: 1324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdti.zzb(java.lang.Object, com.google.android.gms.internal.ads.zzdvl):void");
    }

    private final void zzb(T t, T t2, int i) {
        int zzgq = zzgq(i);
        int i2 = this.zzhox[i];
        long j = zzgq & 1048575;
        if (zza((zzdti<T>) t2, i2, i)) {
            Object f = zzduy.f(t, j);
            Object f2 = zzduy.f(t2, j);
            if (f != null && f2 != null) {
                zzduy.a(t, j, zzdrv.a(f, f2));
                zzb((zzdti<T>) t, i2, i);
            } else if (f2 != null) {
                zzduy.a(t, j, f2);
                zzb((zzdti<T>) t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zze((zzdti<T>) t, i) == zze((zzdti<T>) t2, i);
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzduy.f(obj, j);
    }

    private final boolean zze(T t, int i) {
        if (!this.zzhpe) {
            int zzgr = zzgr(i);
            return (zzduy.a(t, (long) (zzgr & 1048575)) & (1 << (zzgr >>> 20))) != 0;
        }
        int zzgq = zzgq(i);
        long j = zzgq & 1048575;
        switch ((zzgq & 267386880) >>> 20) {
            case 0:
                return zzduy.e(t, j) != 0.0d;
            case 1:
                return zzduy.d(t, j) != 0.0f;
            case 2:
                return zzduy.b(t, j) != 0;
            case 3:
                return zzduy.b(t, j) != 0;
            case 4:
                return zzduy.a(t, j) != 0;
            case 5:
                return zzduy.b(t, j) != 0;
            case 6:
                return zzduy.a(t, j) != 0;
            case 7:
                return zzduy.c(t, j);
            case 8:
                Object f = zzduy.f(t, j);
                if (f instanceof String) {
                    return !((String) f).isEmpty();
                }
                if (f instanceof zzdqk) {
                    return !zzdqk.zzhhx.equals(f);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzduy.f(t, j) != null;
            case 10:
                return !zzdqk.zzhhx.equals(zzduy.f(t, j));
            case 11:
                return zzduy.a(t, j) != 0;
            case 12:
                return zzduy.a(t, j) != 0;
            case 13:
                return zzduy.a(t, j) != 0;
            case 14:
                return zzduy.b(t, j) != 0;
            case 15:
                return zzduy.a(t, j) != 0;
            case 16:
                return zzduy.b(t, j) != 0;
            case 17:
                return zzduy.f(t, j) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzduy.f(t, j)).doubleValue();
    }

    private final void zzf(T t, int i) {
        if (this.zzhpe) {
            return;
        }
        int zzgr = zzgr(i);
        long j = zzgr & 1048575;
        zzduy.a((Object) t, j, zzduy.a(t, j) | (1 << (zzgr >>> 20)));
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzduy.f(t, j)).floatValue();
    }

    private final zzdua zzgn(int i) {
        int i2 = (i / 3) << 1;
        zzdua zzduaVar = (zzdua) this.zzhoy[i2];
        if (zzduaVar != null) {
            return zzduaVar;
        }
        zzdua<T> zzh = zzdtp.zzbbm().zzh((Class) this.zzhoy[i2 + 1]);
        this.zzhoy[i2] = zzh;
        return zzh;
    }

    private final Object zzgo(int i) {
        return this.zzhoy[(i / 3) << 1];
    }

    private final zzdsa zzgp(int i) {
        return (zzdsa) this.zzhoy[((i / 3) << 1) + 1];
    }

    private final int zzgq(int i) {
        return this.zzhox[i + 1];
    }

    private final int zzgr(int i) {
        return this.zzhox[i + 2];
    }

    private static boolean zzgs(int i) {
        return (i & 536870912) != 0;
    }

    private final int zzgt(int i) {
        if (i < this.zzhoz || i > this.zzhpa) {
            return -1;
        }
        return zzao(i, 0);
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzduy.f(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzduy.f(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzduy.f(t, j)).booleanValue();
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
        r1 = r8.zzhph;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0485, code lost:
    
        if (r1 >= r8.zzhpi) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0487, code lost:
    
        r0 = (com.google.android.gms.internal.ads.zzdur) r8.zza(r11, r8.zzhpg[r1], (int) r0, (com.google.android.gms.internal.ads.zzdus<UT, int>) r8.zzhpl);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0496, code lost:
    
        if (r0 == null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0498, code lost:
    
        r8.zzhpl.b(r11, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x049f, code lost:
    
        if (r6 != 0) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x04a1, code lost:
    
        if (r2 != r33) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x04a8, code lost:
    
        throw com.google.android.gms.internal.ads.zzdse.h();
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
    
        throw com.google.android.gms.internal.ads.zzdse.h();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:103:0x0083. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.ads.zzdqf r35) {
        /*
            Method dump skipped, instructions count: 1246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdti.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzdqf):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
    
        if (com.google.android.gms.internal.ads.zzduc.a(com.google.android.gms.internal.ads.zzduy.f(r10, r6), com.google.android.gms.internal.ads.zzduy.f(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.b(r10, r6) == com.google.android.gms.internal.ads.zzduy.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.a(r10, r6) == com.google.android.gms.internal.ads.zzduy.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.b(r10, r6) == com.google.android.gms.internal.ads.zzduy.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.a(r10, r6) == com.google.android.gms.internal.ads.zzduy.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ba, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.a(r10, r6) == com.google.android.gms.internal.ads.zzduy.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cc, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.a(r10, r6) == com.google.android.gms.internal.ads.zzduy.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:
    
        if (com.google.android.gms.internal.ads.zzduc.a(com.google.android.gms.internal.ads.zzduy.f(r10, r6), com.google.android.gms.internal.ads.zzduy.f(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f8, code lost:
    
        if (com.google.android.gms.internal.ads.zzduc.a(com.google.android.gms.internal.ads.zzduy.f(r10, r6), com.google.android.gms.internal.ads.zzduy.f(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010e, code lost:
    
        if (com.google.android.gms.internal.ads.zzduc.a(com.google.android.gms.internal.ads.zzduy.f(r10, r6), com.google.android.gms.internal.ads.zzduy.f(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0120, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.c(r10, r6) == com.google.android.gms.internal.ads.zzduy.c(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0132, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.a(r10, r6) == com.google.android.gms.internal.ads.zzduy.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.b(r10, r6) == com.google.android.gms.internal.ads.zzduy.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0156, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.a(r10, r6) == com.google.android.gms.internal.ads.zzduy.a(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0169, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.b(r10, r6) == com.google.android.gms.internal.ads.zzduy.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017c, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.b(r10, r6) == com.google.android.gms.internal.ads.zzduy.b(r11, r6)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0195, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzduy.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzduy.d(r11, r6))) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b0, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzduy.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzduy.e(r11, r6))) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.ads.zzduc.a(com.google.android.gms.internal.ads.zzduy.f(r10, r6), com.google.android.gms.internal.ads.zzduy.f(r11, r6)) != false) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b6 A[LOOP:0: B:2:0x0005->B:85:0x01b6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b5 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzdua
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdti.equals(java.lang.Object, java.lang.Object):boolean");
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
    @Override // com.google.android.gms.internal.ads.zzdua
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int hashCode(T r9) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdti.hashCode(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final T newInstance() {
        return (T) this.zzhpj.newInstance(this.zzhpb);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0083. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzdua
    public final void zza(T t, zzdtu zzdtuVar, zzdrg zzdrgVar) {
        long j;
        Object a;
        int zzaym;
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
        zzdsa zzgp;
        List<Integer> a12;
        List<Long> a13;
        List<Integer> a14;
        List<Long> a15;
        if (zzdrgVar == null) {
            throw new NullPointerException();
        }
        zzdus zzdusVar = this.zzhpl;
        zzdri<?> zzdriVar = this.zzhpm;
        zzdrm<?> zzdrmVar = null;
        Object obj = null;
        while (true) {
            try {
                int zzaza = zzdtuVar.zzaza();
                int zzgt = zzgt(zzaza);
                if (zzgt >= 0) {
                    int zzgq = zzgq(zzgt);
                    switch ((267386880 & zzgq) >>> 20) {
                        case 0:
                            zzduy.a(t, zzgq & 1048575, zzdtuVar.readDouble());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 1:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.readFloat());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 2:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.zzaye());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 3:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.zzayd());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 4:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.zzayf());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 5:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.zzayg());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 6:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.zzayh());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 7:
                            zzduy.a(t, zzgq & 1048575, zzdtuVar.zzayi());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 8:
                            zza(t, zzgq, zzdtuVar);
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 9:
                            if (zze((zzdti<T>) t, zzgt)) {
                                j = zzgq & 1048575;
                                a = zzdrv.a(zzduy.f(t, j), zzdtuVar.zza(zzgn(zzgt), zzdrgVar));
                                zzduy.a(t, j, a);
                                break;
                            } else {
                                zzduy.a(t, zzgq & 1048575, zzdtuVar.zza(zzgn(zzgt), zzdrgVar));
                                zzf((zzdti<T>) t, zzgt);
                                break;
                            }
                        case 10:
                            zzduy.a(t, zzgq & 1048575, zzdtuVar.zzayk());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 11:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.zzayl());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 12:
                            zzaym = zzdtuVar.zzaym();
                            zzdsa zzgp2 = zzgp(zzgt);
                            if (zzgp2 != null && !zzgp2.zzf(zzaym)) {
                                obj = zzduc.a(zzaza, zzaym, obj, (zzdus<UT, Object>) zzdusVar);
                                break;
                            } else {
                                zzduy.a((Object) t, zzgq & 1048575, zzaym);
                                zzf((zzdti<T>) t, zzgt);
                                break;
                            }
                            break;
                        case 13:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.zzayn());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 14:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.zzayo());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 15:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.zzayp());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 16:
                            zzduy.a((Object) t, zzgq & 1048575, zzdtuVar.zzayq());
                            zzf((zzdti<T>) t, zzgt);
                            break;
                        case 17:
                            if (zze((zzdti<T>) t, zzgt)) {
                                j = zzgq & 1048575;
                                a = zzdrv.a(zzduy.f(t, j), zzdtuVar.zzb(zzgn(zzgt), zzdrgVar));
                                zzduy.a(t, j, a);
                                break;
                            } else {
                                zzduy.a(t, zzgq & 1048575, zzdtuVar.zzb(zzgn(zzgt), zzdrgVar));
                                zzf((zzdti<T>) t, zzgt);
                                break;
                            }
                        case 18:
                            a2 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzi(a2);
                            break;
                        case 19:
                            a3 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzj(a3);
                            break;
                        case 20:
                            a4 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzl(a4);
                            break;
                        case 21:
                            a5 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzk(a5);
                            break;
                        case 22:
                            a6 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzm(a6);
                            break;
                        case 23:
                            a7 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzn(a7);
                            break;
                        case 24:
                            a8 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzo(a8);
                            break;
                        case 25:
                            a9 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzp(a9);
                            break;
                        case 26:
                            if (zzgs(zzgq)) {
                                zzdtuVar.zzq(this.zzhpk.a(t, zzgq & 1048575));
                                break;
                            } else {
                                zzdtuVar.readStringList(this.zzhpk.a(t, zzgq & 1048575));
                                break;
                            }
                        case 27:
                            zzdtuVar.zza(this.zzhpk.a(t, zzgq & 1048575), zzgn(zzgt), zzdrgVar);
                            break;
                        case 28:
                            zzdtuVar.zzr(this.zzhpk.a(t, zzgq & 1048575));
                            break;
                        case 29:
                            a10 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzs(a10);
                            break;
                        case 30:
                            a11 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzt(a11);
                            zzgp = zzgp(zzgt);
                            obj = zzduc.a(zzaza, a11, zzgp, obj, zzdusVar);
                            break;
                        case 31:
                            a12 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzu(a12);
                            break;
                        case 32:
                            a13 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzv(a13);
                            break;
                        case 33:
                            a14 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzw(a14);
                            break;
                        case 34:
                            a15 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzx(a15);
                            break;
                        case 35:
                            a2 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzi(a2);
                            break;
                        case 36:
                            a3 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzj(a3);
                            break;
                        case 37:
                            a4 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzl(a4);
                            break;
                        case 38:
                            a5 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzk(a5);
                            break;
                        case 39:
                            a6 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzm(a6);
                            break;
                        case 40:
                            a7 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzn(a7);
                            break;
                        case 41:
                            a8 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzo(a8);
                            break;
                        case 42:
                            a9 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzp(a9);
                            break;
                        case 43:
                            a10 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzs(a10);
                            break;
                        case 44:
                            a11 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzt(a11);
                            zzgp = zzgp(zzgt);
                            obj = zzduc.a(zzaza, a11, zzgp, obj, zzdusVar);
                            break;
                        case 45:
                            a12 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzu(a12);
                            break;
                        case 46:
                            a13 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzv(a13);
                            break;
                        case 47:
                            a14 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzw(a14);
                            break;
                        case 48:
                            a15 = this.zzhpk.a(t, zzgq & 1048575);
                            zzdtuVar.zzx(a15);
                            break;
                        case 49:
                            zzdtuVar.zzb(this.zzhpk.a(t, zzgq & 1048575), zzgn(zzgt), zzdrgVar);
                            break;
                        case 50:
                            Object zzgo = zzgo(zzgt);
                            long zzgq2 = zzgq(zzgt) & 1048575;
                            Object f = zzduy.f(t, zzgq2);
                            if (f == null) {
                                f = this.zzhpn.zzau(zzgo);
                                zzduy.a(t, zzgq2, f);
                            } else if (this.zzhpn.zzas(f)) {
                                Object zzau = this.zzhpn.zzau(zzgo);
                                this.zzhpn.zze(zzau, f);
                                zzduy.a(t, zzgq2, zzau);
                                f = zzau;
                            }
                            zzdtuVar.zza(this.zzhpn.zzaq(f), this.zzhpn.zzav(zzgo), zzdrgVar);
                            break;
                        case 51:
                            zzduy.a(t, zzgq & 1048575, Double.valueOf(zzdtuVar.readDouble()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 52:
                            zzduy.a(t, zzgq & 1048575, Float.valueOf(zzdtuVar.readFloat()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 53:
                            zzduy.a(t, zzgq & 1048575, Long.valueOf(zzdtuVar.zzaye()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 54:
                            zzduy.a(t, zzgq & 1048575, Long.valueOf(zzdtuVar.zzayd()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 55:
                            zzduy.a(t, zzgq & 1048575, Integer.valueOf(zzdtuVar.zzayf()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 56:
                            zzduy.a(t, zzgq & 1048575, Long.valueOf(zzdtuVar.zzayg()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 57:
                            zzduy.a(t, zzgq & 1048575, Integer.valueOf(zzdtuVar.zzayh()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 58:
                            zzduy.a(t, zzgq & 1048575, Boolean.valueOf(zzdtuVar.zzayi()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 59:
                            zza(t, zzgq, zzdtuVar);
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 60:
                            int i = zzgq & 1048575;
                            if (zza((zzdti<T>) t, zzaza, zzgt)) {
                                long j2 = i;
                                zzduy.a(t, j2, zzdrv.a(zzduy.f(t, j2), zzdtuVar.zza(zzgn(zzgt), zzdrgVar)));
                            } else {
                                zzduy.a(t, i, zzdtuVar.zza(zzgn(zzgt), zzdrgVar));
                                zzf((zzdti<T>) t, zzgt);
                            }
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 61:
                            zzduy.a(t, zzgq & 1048575, zzdtuVar.zzayk());
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 62:
                            zzduy.a(t, zzgq & 1048575, Integer.valueOf(zzdtuVar.zzayl()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 63:
                            zzaym = zzdtuVar.zzaym();
                            zzdsa zzgp3 = zzgp(zzgt);
                            if (zzgp3 != null && !zzgp3.zzf(zzaym)) {
                                obj = zzduc.a(zzaza, zzaym, obj, (zzdus<UT, Object>) zzdusVar);
                                break;
                            }
                            zzduy.a(t, zzgq & 1048575, Integer.valueOf(zzaym));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 64:
                            zzduy.a(t, zzgq & 1048575, Integer.valueOf(zzdtuVar.zzayn()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 65:
                            zzduy.a(t, zzgq & 1048575, Long.valueOf(zzdtuVar.zzayo()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 66:
                            zzduy.a(t, zzgq & 1048575, Integer.valueOf(zzdtuVar.zzayp()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 67:
                            zzduy.a(t, zzgq & 1048575, Long.valueOf(zzdtuVar.zzayq()));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        case 68:
                            zzduy.a(t, zzgq & 1048575, zzdtuVar.zzb(zzgn(zzgt), zzdrgVar));
                            zzb((zzdti<T>) t, zzaza, zzgt);
                            break;
                        default:
                            if (obj == null) {
                                try {
                                    obj = zzdusVar.a();
                                } catch (zzdsd unused) {
                                    zzdusVar.a(zzdtuVar);
                                    if (obj == null) {
                                        obj = zzdusVar.e(t);
                                    }
                                    if (!zzdusVar.a((zzdus) obj, zzdtuVar)) {
                                        for (int i2 = this.zzhph; i2 < this.zzhpi; i2++) {
                                            obj = zza((Object) t, this.zzhpg[i2], (int) obj, (zzdus<UT, int>) zzdusVar);
                                        }
                                        if (obj != null) {
                                            zzdusVar.b((Object) t, (T) obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!zzdusVar.a((zzdus) obj, zzdtuVar)) {
                                for (int i3 = this.zzhph; i3 < this.zzhpi; i3++) {
                                    obj = zza((Object) t, this.zzhpg[i3], (int) obj, (zzdus<UT, int>) zzdusVar);
                                }
                                if (obj != null) {
                                    zzdusVar.b((Object) t, (T) obj);
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                } else {
                    if (zzaza == Integer.MAX_VALUE) {
                        for (int i4 = this.zzhph; i4 < this.zzhpi; i4++) {
                            obj = zza((Object) t, this.zzhpg[i4], (int) obj, (zzdus<UT, int>) zzdusVar);
                        }
                        if (obj != null) {
                            zzdusVar.b((Object) t, (T) obj);
                            return;
                        }
                        return;
                    }
                    Object a16 = !this.zzhpc ? null : zzdriVar.a(zzdrgVar, this.zzhpb, zzaza);
                    if (a16 != null) {
                        if (zzdrmVar == null) {
                            zzdrmVar = zzdriVar.b(t);
                        }
                        zzdrm<?> zzdrmVar2 = zzdrmVar;
                        obj = zzdriVar.a(zzdtuVar, a16, zzdrgVar, zzdrmVar2, obj, zzdusVar);
                        zzdrmVar = zzdrmVar2;
                    } else {
                        zzdusVar.a(zzdtuVar);
                        if (obj == null) {
                            obj = zzdusVar.e(t);
                        }
                        if (!zzdusVar.a((zzdus) obj, zzdtuVar)) {
                            for (int i5 = this.zzhph; i5 < this.zzhpi; i5++) {
                                obj = zza((Object) t, this.zzhpg[i5], (int) obj, (zzdus<UT, int>) zzdusVar);
                            }
                            if (obj != null) {
                                zzdusVar.b((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i6 = this.zzhph; i6 < this.zzhpi; i6++) {
                    obj = zza((Object) t, this.zzhpg[i6], (int) obj, (zzdus<UT, int>) zzdusVar);
                }
                if (obj != null) {
                    zzdusVar.b((Object) t, (T) obj);
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
    @Override // com.google.android.gms.internal.ads.zzdua
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r14, com.google.android.gms.internal.ads.zzdvl r15) {
        /*
            Method dump skipped, instructions count: 2742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdti.zza(java.lang.Object, com.google.android.gms.internal.ads.zzdvl):void");
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
    
        r0 = com.google.android.gms.internal.ads.zzdqg.a(r12, r8, r11);
        r1 = r11.zzhhq;
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
    @Override // com.google.android.gms.internal.ads.zzdua
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.ads.zzdqf r32) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdti.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzdqf):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final void zzan(T t) {
        int i;
        int i2 = this.zzhph;
        while (true) {
            i = this.zzhpi;
            if (i2 >= i) {
                break;
            }
            long zzgq = zzgq(this.zzhpg[i2]) & 1048575;
            Object f = zzduy.f(t, zzgq);
            if (f != null) {
                zzduy.a(t, zzgq, this.zzhpn.zzat(f));
            }
            i2++;
        }
        int length = this.zzhpg.length;
        while (i < length) {
            this.zzhpk.b(t, this.zzhpg[i]);
            i++;
        }
        this.zzhpl.a(t);
        if (this.zzhpc) {
            this.zzhpm.c(t);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0127, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0211, code lost:
    
        r3 = (com.google.android.gms.internal.ads.zzdrb.zzfz(r3) + com.google.android.gms.internal.ads.zzdrb.zzgb(r5)) + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x020d, code lost:
    
        r2.putInt(r20, r14, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0139, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x014b, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x015d, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x016f, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0181, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0193, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01a5, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01b6, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01c7, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01d8, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01e9, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01fa, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x020b, code lost:
    
        if (r19.zzhpf != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0331, code lost:
    
        if ((r5 instanceof com.google.android.gms.internal.ads.zzdqk) != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0417, code lost:
    
        if (zza((com.google.android.gms.internal.ads.zzdti<T>) r20, r15, r3) != false) goto L399;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x06d0, code lost:
    
        r4 = com.google.android.gms.internal.ads.zzdrb.c(r15, (com.google.android.gms.internal.ads.zzdte) r2.getObject(r20, r8), zzgn(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0437, code lost:
    
        if (zza((com.google.android.gms.internal.ads.zzdti<T>) r20, r15, r3) != false) goto L410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x06fd, code lost:
    
        r4 = com.google.android.gms.internal.ads.zzdrb.zzn(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x043f, code lost:
    
        if (zza((com.google.android.gms.internal.ads.zzdti<T>) r20, r15, r3) != false) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0708, code lost:
    
        r8 = com.google.android.gms.internal.ads.zzdrb.zzaj(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x045f, code lost:
    
        if (zza((com.google.android.gms.internal.ads.zzdti<T>) r20, r15, r3) != false) goto L425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x072d, code lost:
    
        r4 = r2.getObject(r20, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0731, code lost:
    
        r4 = com.google.android.gms.internal.ads.zzdrb.zzc(r15, (com.google.android.gms.internal.ads.zzdqk) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0467, code lost:
    
        if (zza((com.google.android.gms.internal.ads.zzdti<T>) r20, r15, r3) != false) goto L429;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x073c, code lost:
    
        r4 = com.google.android.gms.internal.ads.zzduc.a(r15, r2.getObject(r20, r8), zzgn(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0477, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.ads.zzdqk) != false) goto L426;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0757, code lost:
    
        r4 = com.google.android.gms.internal.ads.zzdrb.zzg(r15, (java.lang.String) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x051c, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0606, code lost:
    
        r8 = (com.google.android.gms.internal.ads.zzdrb.zzfz(r15) + com.google.android.gms.internal.ads.zzdrb.zzgb(r4)) + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0602, code lost:
    
        r2.putInt(r20, r11, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x052e, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0540, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x0552, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0564, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0576, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0588, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x059a, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x05ab, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x05bc, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x05cd, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x05de, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x05ef, code lost:
    
        if (r19.zzhpf != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0600, code lost:
    
        if (r19.zzhpf != false) goto L375;
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
    
        if ((r4 instanceof com.google.android.gms.internal.ads.zzdqk) != false) goto L426;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ab, code lost:
    
        if ((r5 instanceof com.google.android.gms.internal.ads.zzdqk) != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0334, code lost:
    
        r3 = com.google.android.gms.internal.ads.zzdrb.zzg(r3, (java.lang.String) r5);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:263:0x040e. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzdua
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzax(T r20) {
        /*
            Method dump skipped, instructions count: 2396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdti.zzax(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.ads.zzdua] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.ads.zzdua] */
    @Override // com.google.android.gms.internal.ads.zzdua
    public final boolean zzaz(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.zzhph) {
                return !this.zzhpc || this.zzhpm.a(t).isInitialized();
            }
            int i5 = this.zzhpg[i2];
            int i6 = this.zzhox[i5];
            int zzgq = zzgq(i5);
            if (this.zzhpe) {
                i = 0;
            } else {
                int i7 = this.zzhox[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = zzgvq.getInt(t, i8);
                    i3 = i8;
                }
            }
            if (((268435456 & zzgq) != 0) && !zza((zzdti<T>) t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzgq) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza((zzdti<T>) t, i6, i5) && !zza(t, zzgq, zzgn(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzar = this.zzhpn.zzar(zzduy.f(t, zzgq & 1048575));
                            if (!zzar.isEmpty()) {
                                if (this.zzhpn.zzav(zzgo(i5)).zzhos.zzbcp() == zzdvm.MESSAGE) {
                                    ?? r4 = 0;
                                    Iterator<?> it = zzar.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        r4 = r4;
                                        if (r4 == 0) {
                                            r4 = zzdtp.zzbbm().zzh(next.getClass());
                                        }
                                        if (!r4.zzaz(next)) {
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
                List list = (List) zzduy.f(t, zzgq & 1048575);
                if (!list.isEmpty()) {
                    ?? zzgn = zzgn(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        }
                        if (!zzgn.zzaz(list.get(i10))) {
                            z = false;
                            break;
                        }
                        i10++;
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza((zzdti<T>) t, i5, i4, i) && !zza(t, zzgq, zzgn(i5))) {
                return false;
            }
            i2++;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001a. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzdua
    public final void zzf(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.zzhox.length; i += 3) {
            int zzgq = zzgq(i);
            long j = 1048575 & zzgq;
            int i2 = this.zzhox[i];
            switch ((zzgq & 267386880) >>> 20) {
                case 0:
                    if (zze((zzdti<T>) t2, i)) {
                        zzduy.a(t, j, zzduy.e(t2, j));
                        zzf((zzdti<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zze((zzdti<T>) t2, i)) {
                        zzduy.a((Object) t, j, zzduy.d(t2, j));
                        zzf((zzdti<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.b(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 3:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.b(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 4:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.a(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 5:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.b(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 6:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.a(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 7:
                    if (zze((zzdti<T>) t2, i)) {
                        zzduy.a(t, j, zzduy.c(t2, j));
                        zzf((zzdti<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a(t, j, zzduy.f(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 9:
                case 17:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a(t, j, zzduy.f(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 11:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.a(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 12:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.a(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 13:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.a(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 14:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.b(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 15:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.a(t2, j));
                    zzf((zzdti<T>) t, i);
                    break;
                case 16:
                    if (!zze((zzdti<T>) t2, i)) {
                        break;
                    }
                    zzduy.a((Object) t, j, zzduy.b(t2, j));
                    zzf((zzdti<T>) t, i);
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
                    this.zzhpk.a(t, t2, j);
                    break;
                case 50:
                    zzduc.a(this.zzhpn, t, t2, j);
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
                    if (!zza((zzdti<T>) t2, i2, i)) {
                        break;
                    }
                    zzduy.a(t, j, zzduy.f(t2, j));
                    zzb((zzdti<T>) t, i2, i);
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
                    if (!zza((zzdti<T>) t2, i2, i)) {
                        break;
                    }
                    zzduy.a(t, j, zzduy.f(t2, j));
                    zzb((zzdti<T>) t, i2, i);
                    break;
            }
        }
        if (this.zzhpe) {
            return;
        }
        zzduc.a(this.zzhpl, t, t2);
        if (this.zzhpc) {
            zzduc.a(this.zzhpm, t, t2);
        }
    }
}
