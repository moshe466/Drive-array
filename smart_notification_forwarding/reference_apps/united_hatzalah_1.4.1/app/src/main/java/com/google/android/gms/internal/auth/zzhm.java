package com.google.android.gms.internal.auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhm {
    private static final zzhk zza;

    static {
        if (zzhi.zzu() && zzhi.zzv()) {
            int i = zzdr.zza;
        }
        zza = new zzhl();
    }

    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i3) {
        byte b4 = bArr[i - 1];
        int i4 = i3 - i;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    byte b5 = bArr[i];
                    byte b6 = bArr[i + 1];
                    if (b4 > -12 || b5 > -65 || b6 > -65) {
                        return -1;
                    }
                    return (b6 << 16) ^ ((b5 << 8) ^ b4);
                }
                throw new AssertionError();
            }
            byte b7 = bArr[i];
            if (b4 > -12 || b7 > -65) {
                return -1;
            }
            return (b7 << 8) ^ b4;
        }
        if (b4 > -12) {
            return -1;
        }
        return b4;
    }

    public static String zzb(byte[] bArr, int i, int i3) {
        int length = bArr.length;
        if ((i | i3 | ((length - i) - i3)) >= 0) {
            int i4 = i + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i < i4) {
                byte b4 = bArr[i];
                if (!zzhj.zzd(b4)) {
                    break;
                }
                i++;
                cArr[i5] = (char) b4;
                i5++;
            }
            int i6 = i5;
            while (i < i4) {
                int i7 = i + 1;
                byte b5 = bArr[i];
                if (zzhj.zzd(b5)) {
                    cArr[i6] = (char) b5;
                    i6++;
                    i = i7;
                    while (i < i4) {
                        byte b6 = bArr[i];
                        if (!zzhj.zzd(b6)) {
                            break;
                        }
                        i++;
                        cArr[i6] = (char) b6;
                        i6++;
                    }
                } else if (b5 < -32) {
                    if (i7 < i4) {
                        i += 2;
                        zzhj.zzc(b5, bArr[i7], cArr, i6);
                        i6++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (b5 < -16) {
                    if (i7 < i4 - 1) {
                        int i8 = i + 2;
                        i += 3;
                        zzhj.zzb(b5, bArr[i7], bArr[i8], cArr, i6);
                        i6++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (i7 < i4 - 2) {
                    int i9 = i + 2;
                    int i10 = i + 3;
                    i += 4;
                    zzhj.zza(b5, bArr[i7], bArr[i9], bArr[i10], cArr, i6);
                    i6 += 2;
                } else {
                    throw zzfa.zzb();
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i3)));
    }

    public static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    public static boolean zzd(byte[] bArr, int i, int i3) {
        return zza.zzb(bArr, i, i3);
    }
}
