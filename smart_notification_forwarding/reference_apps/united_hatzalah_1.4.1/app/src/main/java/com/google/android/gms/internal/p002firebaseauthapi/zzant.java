package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzant {
    private static final zzanv zza;

    static {
        if (zzanp.zzc()) {
            zzanp.zzd();
        }
        zza = new zzanu();
    }

    public static /* synthetic */ int zza(byte[] bArr, int i, int i3) {
        byte b4 = bArr[i - 1];
        int i4 = i3 - i;
        if (i4 == 0) {
            if (b4 > -12) {
                return -1;
            }
            return b4;
        }
        if (i4 == 1) {
            byte b5 = bArr[i];
            if (b4 > -12 || b5 > -65) {
                return -1;
            }
            return (b5 << 8) ^ b4;
        }
        if (i4 == 2) {
            byte b6 = bArr[i];
            byte b7 = bArr[i + 1];
            if (b4 > -12 || b6 > -65 || b7 > -65) {
                return -1;
            }
            return (b7 << 16) ^ ((b6 << 8) ^ b4);
        }
        throw new AssertionError();
    }

    public static String zzb(byte[] bArr, int i, int i3) {
        return zza.zza(bArr, i, i3);
    }

    public static boolean zzc(byte[] bArr, int i, int i3) {
        if (zza.zza(0, bArr, i, i3) != 0) {
            return false;
        }
        return true;
    }

    public static int zza(String str, byte[] bArr, int i, int i3) {
        return zza.zza(str, bArr, i, i3);
    }

    public static int zza(String str) {
        int length = str.length();
        int i = 0;
        int i3 = 0;
        while (i3 < length && str.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = str.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = str.length();
                while (i3 < length2) {
                    char charAt2 = str.charAt(i3);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i3) < 65536) {
                                throw new zzanx(i3, length2);
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i4 += i;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        throw new IllegalArgumentException(AbstractC0008a.l("UTF-8 length does not fit in int: ", i4 + 4294967296L));
    }
}
