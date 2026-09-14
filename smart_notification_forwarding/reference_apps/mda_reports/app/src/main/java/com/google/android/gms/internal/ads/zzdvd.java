package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class zzdvd extends zzdvc {
    private static int zza(byte[] bArr, int i, long j, int i2) {
        int zzgy;
        int zzap;
        int zzj;
        if (i2 == 0) {
            zzgy = zzdva.zzgy(i);
            return zzgy;
        }
        if (i2 == 1) {
            zzap = zzdva.zzap(i, zzduy.a(bArr, j));
            return zzap;
        }
        if (i2 != 2) {
            throw new AssertionError();
        }
        zzj = zzdva.zzj(i, zzduy.a(bArr, j), zzduy.a(bArr, j + 1));
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0061, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.a(r25, r8) > (-65)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (com.google.android.gms.internal.ads.zzduy.a(r25, r8) > (-65)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0103, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.ads.zzdvc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(int r24, byte[] r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvd.a(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdvc
    public final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        int i3;
        char charAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzduy.a(bArr, j4, (byte) charAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 >= c || j4 >= j5) {
                if (charAt3 < 2048 && j4 <= j5 - 2) {
                    long j6 = j4 + j;
                    zzduy.a(bArr, j4, (byte) ((charAt3 >>> 6) | 960));
                    zzduy.a(bArr, j6, (byte) ((charAt3 & '?') | 128));
                    j2 = j6 + j;
                    j3 = j;
                } else {
                    if ((charAt3 >= 55296 && 57343 >= charAt3) || j4 > j5 - 3) {
                        if (j4 > j5 - 4) {
                            if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                                throw new zzdve(i4, length);
                            }
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append("Failed writing ");
                            sb2.append(charAt3);
                            sb2.append(" at index ");
                            sb2.append(j4);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        }
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char charAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j7 = j4 + 1;
                                zzduy.a(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                long j8 = j7 + 1;
                                zzduy.a(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j9 = j8 + 1;
                                zzduy.a(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 = 1;
                                j2 = j9 + 1;
                                zzduy.a(bArr, j9, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zzdve(i4 - 1, length);
                    }
                    long j10 = j4 + j;
                    zzduy.a(bArr, j4, (byte) ((charAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    zzduy.a(bArr, j10, (byte) (((charAt3 >>> 6) & 63) | 128));
                    zzduy.a(bArr, j11, (byte) ((charAt3 & '?') | 128));
                    j2 = j11 + 1;
                    j3 = 1;
                }
                i4++;
                c = 128;
                long j12 = j3;
                j4 = j2;
                j = j12;
            } else {
                long j13 = j4 + j;
                zzduy.a(bArr, j4, (byte) charAt3);
                j3 = j;
                j2 = j13;
            }
            i4++;
            c = 128;
            long j122 = j3;
            j4 = j2;
            j = j122;
        }
        return (int) j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdvc
    public final void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        char c;
        int i;
        long j;
        int i2;
        char charAt;
        ByteBuffer byteBuffer2 = byteBuffer;
        long a = zzduy.a(byteBuffer);
        long position = byteBuffer.position() + a;
        long limit = byteBuffer.limit() + a;
        int length = charSequence.length();
        if (length > limit - position) {
            char charAt2 = charSequence.charAt(length - 1);
            int limit2 = byteBuffer.limit();
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(limit2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i3 = 0;
        while (true) {
            c = 128;
            if (i3 >= length || (charAt = charSequence.charAt(i3)) >= 128) {
                break;
            }
            zzduy.a(position, (byte) charAt);
            i3++;
            position = 1 + position;
        }
        if (i3 == length) {
            i = (int) (position - a);
        } else {
            while (i3 < length) {
                char charAt3 = charSequence.charAt(i3);
                if (charAt3 < c && position < limit) {
                    zzduy.a(position, (byte) charAt3);
                    position++;
                    j = a;
                } else if (charAt3 >= 2048 || position > limit - 2) {
                    j = a;
                    if ((charAt3 >= 55296 && 57343 >= charAt3) || position > limit - 3) {
                        if (position > limit - 4) {
                            if (55296 <= charAt3 && charAt3 <= 57343 && ((i2 = i3 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i2)))) {
                                throw new zzdve(i3, length);
                            }
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append("Failed writing ");
                            sb2.append(charAt3);
                            sb2.append(" at index ");
                            sb2.append(position);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        }
                        int i4 = i3 + 1;
                        if (i4 != length) {
                            char charAt4 = charSequence.charAt(i4);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j2 = position + 1;
                                zzduy.a(position, (byte) ((codePoint >>> 18) | 240));
                                long j3 = j2 + 1;
                                zzduy.a(j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j4 = j3 + 1;
                                zzduy.a(j3, (byte) (((codePoint >>> 6) & 63) | 128));
                                long j5 = j4 + 1;
                                zzduy.a(j4, (byte) ((codePoint & 63) | 128));
                                i3 = i4;
                                position = j5;
                            }
                        } else {
                            i4 = i3;
                        }
                        throw new zzdve(i4 - 1, length);
                    }
                    long j6 = position + 1;
                    zzduy.a(position, (byte) ((charAt3 >>> '\f') | 480));
                    long j7 = j6 + 1;
                    zzduy.a(j6, (byte) (((charAt3 >>> 6) & 63) | 128));
                    zzduy.a(j7, (byte) ((charAt3 & '?') | 128));
                    position = j7 + 1;
                } else {
                    j = a;
                    long j8 = position + 1;
                    zzduy.a(position, (byte) ((charAt3 >>> 6) | 960));
                    zzduy.a(j8, (byte) ((charAt3 & '?') | 128));
                    position = j8 + 1;
                }
                i3++;
                a = j;
                c = 128;
            }
            i = (int) (position - a);
            byteBuffer2 = byteBuffer;
        }
        byteBuffer2.position(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdvc
    public final String b(byte[] bArr, int i, int i2) {
        boolean zze;
        boolean zze2;
        boolean zzf;
        boolean zzg;
        boolean zze3;
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte a = zzduy.a(bArr, i);
            zze3 = zzduz.zze(a);
            if (!zze3) {
                break;
            }
            i++;
            zzduz.zza(a, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte a2 = zzduy.a(bArr, i);
            zze = zzduz.zze(a2);
            if (zze) {
                int i7 = i5 + 1;
                zzduz.zza(a2, cArr, i5);
                while (i6 < i3) {
                    byte a3 = zzduy.a(bArr, i6);
                    zze2 = zzduz.zze(a3);
                    if (!zze2) {
                        break;
                    }
                    i6++;
                    zzduz.zza(a3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                zzf = zzduz.zzf(a2);
                if (!zzf) {
                    zzg = zzduz.zzg(a2);
                    if (zzg) {
                        if (i6 >= i3 - 1) {
                            throw zzdse.i();
                        }
                        int i8 = i6 + 1;
                        zzduz.zza(a2, zzduy.a(bArr, i6), zzduy.a(bArr, i8), cArr, i5);
                        i = i8 + 1;
                        i5++;
                    } else {
                        if (i6 >= i3 - 2) {
                            throw zzdse.i();
                        }
                        int i9 = i6 + 1;
                        byte a4 = zzduy.a(bArr, i6);
                        int i10 = i9 + 1;
                        zzduz.zza(a2, a4, zzduy.a(bArr, i9), zzduy.a(bArr, i10), cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    }
                } else {
                    if (i6 >= i3) {
                        throw zzdse.i();
                    }
                    zzduz.zza(a2, zzduy.a(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                }
            }
        }
        return new String(cArr, 0, i5);
    }
}
