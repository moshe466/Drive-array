package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public final class o0 extends E1.b {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4144b;

    public /* synthetic */ o0(int i) {
        this.f4144b = i;
    }

    public static int B(long j2, byte[] bArr, int i, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return q0.d(i, n0.g(bArr, j2), n0.g(bArr, j2 + 1));
                }
                throw new AssertionError();
            }
            return q0.c(i, n0.g(bArr, j2));
        }
        E1.b bVar = q0.f4147a;
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    @Override // E1.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k(byte[] r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.k(byte[], int, int):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
    
        return r27 + r3;
     */
    @Override // E1.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m(java.lang.String r25, byte[] r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.m(java.lang.String, byte[], int, int):int");
    }

    @Override // E1.b
    public final int u(byte[] bArr, int i, int i3) {
        int i4;
        long j2;
        int i5 = i;
        switch (this.f4144b) {
            case 0:
                break;
            default:
                if ((i5 | i3 | (bArr.length - i3)) >= 0) {
                    long j3 = i5;
                    int i6 = (int) (i3 - j3);
                    long j4 = 1;
                    if (i6 < 16) {
                        i4 = 0;
                    } else {
                        int i7 = 8 - (((int) j3) & 7);
                        long j5 = j3;
                        i4 = 0;
                        while (true) {
                            if (i4 < i7) {
                                long j6 = j5 + 1;
                                if (n0.g(bArr, j5) >= 0) {
                                    i4++;
                                    j5 = j6;
                                }
                            } else {
                                while (true) {
                                    int i8 = i4 + 8;
                                    if (i8 <= i6) {
                                        if ((n0.f4138c.h(n0.f4141f + j5, bArr) & (-9187201950435737472L)) == 0) {
                                            j5 += 8;
                                            i4 = i8;
                                        }
                                    }
                                }
                                while (true) {
                                    if (i4 < i6) {
                                        long j7 = j5 + 1;
                                        if (n0.g(bArr, j5) >= 0) {
                                            i4++;
                                            j5 = j7;
                                        }
                                    } else {
                                        i4 = i6;
                                    }
                                }
                            }
                        }
                    }
                    int i9 = i6 - i4;
                    long j8 = j3 + i4;
                    while (true) {
                        byte b4 = 0;
                        while (true) {
                            if (i9 > 0) {
                                long j9 = j8 + j4;
                                b4 = n0.g(bArr, j8);
                                if (b4 >= 0) {
                                    i9--;
                                    j8 = j9;
                                } else {
                                    j8 = j9;
                                }
                            }
                        }
                        if (i9 == 0) {
                            return 0;
                        }
                        int i10 = i9 - 1;
                        if (b4 < -32) {
                            if (i10 == 0) {
                                return b4;
                            }
                            i9 -= 2;
                            if (b4 >= -62) {
                                long j10 = j8 + j4;
                                if (n0.g(bArr, j8) <= -65) {
                                    j2 = j4;
                                    j8 = j10;
                                    j4 = j2;
                                }
                            }
                        } else if (b4 < -16) {
                            if (i10 < 2) {
                                return B(j8, bArr, b4, i10);
                            }
                            i9 -= 3;
                            j2 = j4;
                            long j11 = j8 + j2;
                            byte g3 = n0.g(bArr, j8);
                            if (g3 <= -65 && ((b4 != -32 || g3 >= -96) && (b4 != -19 || g3 < -96))) {
                                j8 += 2;
                                if (n0.g(bArr, j11) <= -65) {
                                    j4 = j2;
                                }
                            }
                        } else {
                            j2 = j4;
                            if (i10 < 3) {
                                return B(j8, bArr, b4, i10);
                            }
                            i9 -= 4;
                            long j12 = j8 + j2;
                            byte g4 = n0.g(bArr, j8);
                            if (g4 <= -65) {
                                if ((((g4 + 112) + (b4 << 28)) >> 30) == 0) {
                                    long j13 = 2 + j8;
                                    if (n0.g(bArr, j12) <= -65) {
                                        j8 += 3;
                                        if (n0.g(bArr, j13) <= -65) {
                                            j4 = j2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return -1;
                }
                throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i3)));
        }
        while (i5 < i3 && bArr[i5] >= 0) {
            i5++;
        }
        if (i5 < i3) {
            while (i5 < i3) {
                int i11 = i5 + 1;
                byte b5 = bArr[i5];
                if (b5 < 0) {
                    if (b5 < -32) {
                        if (i11 >= i3) {
                            return b5;
                        }
                        if (b5 >= -62) {
                            i5 += 2;
                            if (bArr[i11] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b5 < -16) {
                        if (i11 >= i3 - 1) {
                            return q0.a(bArr, i11, i3);
                        }
                        int i12 = i5 + 2;
                        byte b6 = bArr[i11];
                        if (b6 <= -65 && ((b5 != -32 || b6 >= -96) && (b5 != -19 || b6 < -96))) {
                            i5 += 3;
                            if (bArr[i12] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i11 >= i3 - 2) {
                        return q0.a(bArr, i11, i3);
                    }
                    int i13 = i5 + 2;
                    byte b7 = bArr[i11];
                    if (b7 <= -65) {
                        if ((((b7 + 112) + (b5 << 28)) >> 30) == 0) {
                            int i14 = i5 + 3;
                            if (bArr[i13] <= -65) {
                                i5 += 4;
                                if (bArr[i14] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i5 = i11;
            }
        }
        return 0;
    }
}
