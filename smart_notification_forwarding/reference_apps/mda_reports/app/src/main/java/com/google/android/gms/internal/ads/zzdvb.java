package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class zzdvb extends zzdvc {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r13[r14] > (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x007e, code lost:
    
        if (r13[r14] > (-65)) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0043, code lost:
    
        if (r13[r14] > (-65)) goto L27;
     */
    @Override // com.google.android.gms.internal.ads.zzdvc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(int r12, byte[] r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvb.a(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.ads.zzdvc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvb.a(java.lang.CharSequence, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdvc
    public final void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        zzdvc.b(charSequence, byteBuffer);
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
            byte b = bArr[i];
            zze3 = zzduz.zze(b);
            if (!zze3) {
                break;
            }
            i++;
            zzduz.zza(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            zze = zzduz.zze(b2);
            if (zze) {
                int i7 = i5 + 1;
                zzduz.zza(b2, cArr, i5);
                while (i6 < i3) {
                    byte b3 = bArr[i6];
                    zze2 = zzduz.zze(b3);
                    if (!zze2) {
                        break;
                    }
                    i6++;
                    zzduz.zza(b3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                zzf = zzduz.zzf(b2);
                if (!zzf) {
                    zzg = zzduz.zzg(b2);
                    if (zzg) {
                        if (i6 >= i3 - 1) {
                            throw zzdse.i();
                        }
                        int i8 = i6 + 1;
                        zzduz.zza(b2, bArr[i6], bArr[i8], cArr, i5);
                        i = i8 + 1;
                        i5++;
                    } else {
                        if (i6 >= i3 - 2) {
                            throw zzdse.i();
                        }
                        int i9 = i6 + 1;
                        byte b4 = bArr[i6];
                        int i10 = i9 + 1;
                        zzduz.zza(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    }
                } else {
                    if (i6 >= i3) {
                        throw zzdse.i();
                    }
                    zzduz.zza(b2, bArr[i6], cArr, i5);
                    i = i6 + 1;
                    i5++;
                }
            }
        }
        return new String(cArr, 0, i5);
    }
}
