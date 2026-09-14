package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
final class zzanu extends zzanv {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzanu.zza(java.lang.String, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanv
    public final int zza(int i, byte[] bArr, int i3, int i4) {
        while (i3 < i4 && bArr[i3] >= 0) {
            i3++;
        }
        if (i3 >= i4) {
            return 0;
        }
        while (i3 < i4) {
            int i5 = i3 + 1;
            byte b4 = bArr[i3];
            if (b4 < 0) {
                if (b4 < -32) {
                    if (i5 >= i4) {
                        return b4;
                    }
                    if (b4 >= -62) {
                        i3 += 2;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                }
                if (b4 < -16) {
                    if (i5 >= i4 - 1) {
                        return zzant.zza(bArr, i5, i4);
                    }
                    int i6 = i3 + 2;
                    byte b5 = bArr[i5];
                    if (b5 <= -65 && ((b4 != -32 || b5 >= -96) && (b4 != -19 || b5 < -96))) {
                        i3 += 3;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return -1;
                }
                if (i5 >= i4 - 2) {
                    return zzant.zza(bArr, i5, i4);
                }
                int i7 = i3 + 2;
                byte b6 = bArr[i5];
                if (b6 <= -65) {
                    if ((((b6 + 112) + (b4 << 28)) >> 30) == 0) {
                        int i8 = i3 + 3;
                        if (bArr[i7] <= -65) {
                            i3 += 4;
                            if (bArr[i8] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            i3 = i5;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanv
    public final String zza(byte[] bArr, int i, int i3) {
        if ((i | i3 | ((bArr.length - i) - i3)) >= 0) {
            int i4 = i + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i < i4) {
                byte b4 = bArr[i];
                if (b4 < 0) {
                    break;
                }
                i++;
                zzans.zza(b4, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i < i4) {
                int i7 = i + 1;
                byte b5 = bArr[i];
                if (b5 >= 0) {
                    int i8 = i6 + 1;
                    zzans.zza(b5, cArr, i6);
                    int i9 = i7;
                    while (i9 < i4) {
                        byte b6 = bArr[i9];
                        if (b6 < 0) {
                            break;
                        }
                        i9++;
                        zzans.zza(b6, cArr, i8);
                        i8++;
                    }
                    i6 = i8;
                    i = i9;
                } else if (b5 < -32) {
                    if (i7 < i4) {
                        i += 2;
                        zzans.zza(b5, bArr[i7], cArr, i6);
                        i6++;
                    } else {
                        throw zzalf.zzd();
                    }
                } else if (b5 < -16) {
                    if (i7 < i4 - 1) {
                        int i10 = i + 2;
                        i += 3;
                        zzans.zza(b5, bArr[i7], bArr[i10], cArr, i6);
                        i6++;
                    } else {
                        throw zzalf.zzd();
                    }
                } else if (i7 < i4 - 2) {
                    byte b7 = bArr[i7];
                    int i11 = i + 3;
                    byte b8 = bArr[i + 2];
                    i += 4;
                    zzans.zza(b5, b7, b8, bArr[i11], cArr, i6);
                    i6 += 2;
                } else {
                    throw zzalf.zzd();
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i3)));
    }
}
