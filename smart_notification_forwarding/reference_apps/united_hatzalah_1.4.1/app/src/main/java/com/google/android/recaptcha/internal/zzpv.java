package com.google.android.recaptcha.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpv {
    static {
        if (zzps.zzx() && zzps.zzy()) {
            int i = zzks.zza;
        }
    }

    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i3) {
        int i4 = i3 - i;
        byte b4 = bArr[i - 1];
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    byte b5 = bArr[i];
                    byte b6 = bArr[i + 1];
                    if (b4 <= -12 && b5 <= -65 && b6 <= -65) {
                        return (b6 << 16) ^ ((b5 << 8) ^ b4);
                    }
                    return -1;
                }
                throw new AssertionError();
            }
            byte b7 = bArr[i];
            if (b4 <= -12 && b7 <= -65) {
                return (b7 << 8) ^ b4;
            }
            return -1;
        }
        if (b4 <= -12) {
            return b4;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        return r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zzb(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzpv.zzb(java.lang.String, byte[], int, int):int");
    }

    public static int zzc(String str) {
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
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i3) >= 65536) {
                                i3++;
                            } else {
                                throw new zzpu(i3, length2);
                            }
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
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i4 + 4294967296L));
    }

    public static String zzd(byte[] bArr, int i, int i3) {
        int i4;
        int length = bArr.length;
        if ((((length - i) - i3) | i | i3) >= 0) {
            int i5 = i + i3;
            char[] cArr = new char[i3];
            int i6 = 0;
            while (i < i5) {
                byte b4 = bArr[i];
                if (!zzpt.zzd(b4)) {
                    break;
                }
                i++;
                cArr[i6] = (char) b4;
                i6++;
            }
            int i7 = i6;
            while (i < i5) {
                int i8 = i + 1;
                byte b5 = bArr[i];
                if (zzpt.zzd(b5)) {
                    cArr[i7] = (char) b5;
                    i7++;
                    i = i8;
                    while (i < i5) {
                        byte b6 = bArr[i];
                        if (zzpt.zzd(b6)) {
                            i++;
                            cArr[i7] = (char) b6;
                            i7++;
                        }
                    }
                } else {
                    if (b5 < -32) {
                        if (i8 < i5) {
                            i4 = i7 + 1;
                            i += 2;
                            zzpt.zzc(b5, bArr[i8], cArr, i7);
                        } else {
                            throw new zznn("Protocol message had invalid UTF-8.");
                        }
                    } else if (b5 < -16) {
                        if (i8 < i5 - 1) {
                            i4 = i7 + 1;
                            int i9 = i + 2;
                            i += 3;
                            zzpt.zzb(b5, bArr[i8], bArr[i9], cArr, i7);
                        } else {
                            throw new zznn("Protocol message had invalid UTF-8.");
                        }
                    } else if (i8 < i5 - 2) {
                        byte b7 = bArr[i8];
                        int i10 = i + 3;
                        byte b8 = bArr[i + 2];
                        i += 4;
                        zzpt.zza(b5, b7, b8, bArr[i10], cArr, i7);
                        i7 += 2;
                    } else {
                        throw new zznn("Protocol message had invalid UTF-8.");
                    }
                    i7 = i4;
                }
            }
            return new String(cArr, 0, i7);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i3)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0076 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zze(byte[] r6, int r7, int r8) {
        /*
        L0:
            if (r7 >= r8) goto L9
            r0 = r6[r7]
            if (r0 < 0) goto L9
            int r7 = r7 + 1
            goto L0
        L9:
            if (r7 < r8) goto Ld
            goto L7a
        Ld:
            if (r7 >= r8) goto L7a
            int r0 = r7 + 1
            r1 = r6[r7]
            if (r1 >= 0) goto L78
            r2 = -32
            r3 = -65
            if (r1 >= r2) goto L29
            if (r0 < r8) goto L1e
            goto L57
        L1e:
            r2 = -62
            if (r1 < r2) goto L76
            int r7 = r7 + 2
            r0 = r6[r0]
            if (r0 <= r3) goto Ld
            goto L76
        L29:
            r4 = -16
            if (r1 >= r4) goto L4f
            int r4 = r8 + (-1)
            if (r0 < r4) goto L36
            int r1 = zza(r6, r0, r8)
            goto L57
        L36:
            int r4 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L76
            r5 = -96
            if (r1 != r2) goto L42
            if (r0 < r5) goto L76
        L42:
            r2 = -19
            if (r1 != r2) goto L48
            if (r0 >= r5) goto L76
        L48:
            int r7 = r7 + 3
            r0 = r6[r4]
            if (r0 <= r3) goto Ld
            goto L76
        L4f:
            int r2 = r8 + (-2)
            if (r0 < r2) goto L5a
            int r1 = zza(r6, r0, r8)
        L57:
            if (r1 == 0) goto L7a
            goto L76
        L5a:
            int r2 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L76
            int r1 = r1 << 28
            int r0 = r0 + 112
            int r0 = r0 + r1
            int r0 = r0 >> 30
            if (r0 != 0) goto L76
            int r0 = r7 + 3
            r1 = r6[r2]
            if (r1 > r3) goto L76
            int r7 = r7 + 4
            r0 = r6[r0]
            if (r0 > r3) goto L76
            goto Ld
        L76:
            r6 = 0
            return r6
        L78:
            r7 = r0
            goto Ld
        L7a:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzpv.zze(byte[], int, int):boolean");
    }
}
