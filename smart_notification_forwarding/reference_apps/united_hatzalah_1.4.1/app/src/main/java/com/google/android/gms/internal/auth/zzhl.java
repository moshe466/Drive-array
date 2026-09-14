package com.google.android.gms.internal.auth;

/* loaded from: classes.dex */
final class zzhl extends zzhk {
    @Override // com.google.android.gms.internal.auth.zzhk
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
                    if (i5 < i4) {
                        if (b4 >= -62) {
                            i3 += 2;
                            if (bArr[i5] > -65) {
                            }
                        }
                        return -1;
                    }
                    return b4;
                }
                if (b4 < -16) {
                    if (i5 >= i4 - 1) {
                        return zzhm.zza(bArr, i5, i4);
                    }
                    int i6 = i3 + 2;
                    byte b5 = bArr[i5];
                    if (b5 > -65 || (b4 == -32 && b5 < -96)) {
                        return -1;
                    }
                    if (b4 == -19 && b5 >= -96) {
                        return -1;
                    }
                    i3 += 3;
                    if (bArr[i6] > -65) {
                        return -1;
                    }
                } else {
                    if (i5 >= i4 - 2) {
                        return zzhm.zza(bArr, i5, i4);
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
            } else {
                i3 = i5;
            }
        }
        return 0;
    }
}
