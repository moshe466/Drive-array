package G0;

import F0.B0;
import F0.D;
import F0.D1;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f798a;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x004d. Please report as an issue. */
    public a(String str) {
        char c4;
        char c5;
        byte[] bArr = new byte[8];
        int i = 0;
        bArr[0] = -3;
        int i3 = 1;
        bArr[1] = -44;
        char c6 = 2;
        bArr[2] = 76;
        int i4 = 3;
        bArr[3] = -107;
        bArr[4] = -81;
        bArr[5] = 109;
        bArr[6] = -83;
        bArr[7] = 44;
        byte[] bArr2 = {105, -64, -54, 105, -88, 35, 18, 2};
        short[] sArr = null;
        char c7 = 50438;
        short s3 = 0;
        int i5 = 0;
        int i6 = 0;
        short s4 = 0;
        short s5 = 0;
        while (true) {
            switch (c7) {
                case 60804:
                    int i7 = i3;
                    c4 = c6;
                    if (i5 < i6) {
                        c7 = 3065;
                    } else {
                        c7 = 11261;
                    }
                    i3 = i7;
                    c6 = c4;
                    i4 = 3;
                case 22124:
                    int i8 = i3;
                    c4 = c6;
                    int i9 = ((short) ((s5 << 4) + sArr[c4])) ^ (s5 + s4);
                    short s6 = sArr[i4];
                    int i10 = -(s5 >>> 5);
                    int i11 = i10 | s6;
                    int i12 = (i11 - (i10 * 2)) + ((i10 ^ s6) ^ i11);
                    int i13 = -B0.a(i12 | (~i9), i12 - i9);
                    s3 = (short) D.a(s3, i4, -(D1.a(s3, i13) | (i13 & 2)), i8);
                    s5 = (short) (s5 - ((((short) ((s3 << 4) + sArr[0])) ^ (((s4 | s3) - (((~s3) & 51) & s4)) + ((s3 | 51) & s4))) ^ ((s3 >>> 5) + sArr[1])));
                    s4 = (short) (s4 - 40503);
                    i++;
                    i3 = 1;
                    c7 = 17109;
                    c6 = c4;
                    i4 = 3;
                case 3065:
                    c5 = c6;
                    byte b4 = bArr[i5];
                    s5 = (short) (((bArr[((i5 & 1) * 2) + (i5 ^ 1)] & ForkServer.ERROR) << 8) | ((255 - (b4 | ForkServer.ERROR)) + b4));
                    int i14 = -i5;
                    int i15 = i14 | 2;
                    s3 = (short) ((bArr[(i15 - (i14 * 2)) + ((i14 ^ 2) ^ i15)] & ForkServer.ERROR) | ((bArr[i5 + 3] & ForkServer.ERROR) << 8));
                    s4 = -14624;
                    i = 0;
                    i3 = i3;
                    c7 = 17109;
                    c6 = c5;
                case 50438:
                    c5 = c6;
                    sArr = new short[4];
                    i5 = 0;
                    c7 = 5848;
                    c6 = c5;
                case 49265:
                    c5 = c6;
                    sArr[i5] = (short) ((bArr2[(((~i5) & 2) * (i5 & (-3))) + ((i5 & 2) * (i5 | 2))] & ForkServer.ERROR) ^ ((bArr2[(i5 * 2) + 1] & ForkServer.ERROR) << 8));
                    i5++;
                    c7 = 5848;
                    i3 = i3;
                    c6 = c5;
                case 5255:
                    c5 = c6;
                    int i16 = -i5;
                    int i17 = (-8) | i16;
                    bArr[i17 + 16 + (((-8) ^ i16) ^ i17)] = (byte) (bArr[8 - i5] ^ bArr2[i5 % 8]);
                    i5--;
                    c7 = 33742;
                    c6 = c5;
                case 5848:
                    c5 = c6;
                    if (i5 < 4) {
                        c7 = 49265;
                    } else {
                        c7 = 18639;
                    }
                    c6 = c5;
                case 11261:
                    c5 = c6;
                    i5 = 0;
                    c7 = 33742;
                    c6 = c5;
                case 18639:
                    c5 = c6;
                    i6 = 8;
                    i5 = 0;
                    c7 = 60804;
                    c6 = c5;
                case 15026:
                    break;
                case 33742:
                    c5 = c6;
                    if (i5 > 0) {
                        c7 = 5255;
                    } else {
                        c7 = 15026;
                    }
                    c6 = c5;
                case 42144:
                    bArr[i5] = (byte) (s5 & 255);
                    c5 = c6;
                    bArr[i5 + 1] = (byte) ((s5 >> 8) & 255);
                    bArr[i5 + 2] = (byte) (s3 & 255);
                    bArr[i5 + 3] = (byte) ((s3 >> 8) & 255);
                    i5 += 4;
                    c7 = 60804;
                    c6 = c5;
                case 17109:
                    if (i < 32) {
                        c7 = 22124;
                    } else {
                        c7 = 42144;
                    }
                default:
                    c7 = 17109;
            }
            kotlin.jvm.internal.j.e(str, new String(bArr, StandardCharsets.UTF_8).intern());
            this.f798a = str;
            return;
        }
    }
}
