package F0;

import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class W2 {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f408a;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0081. Please report as an issue. */
    public W2(String[] strArr) {
        int i;
        int i3;
        int i4 = 1;
        int i5 = 2;
        byte[] bArr = {-125, -90, -10, -105, 30, 66};
        int i6 = 8;
        byte[] bArr2 = {-11, -57, -102, -30, 123, 49, 88, 42};
        byte[] bArr3 = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = -1850458006;
        byte[] bArr4 = null;
        while (true) {
            int i10 = ((16777216 & i9) * (i9 | 16777216)) + (((-16777217) & i9) * ((~i9) & 16777216));
            int i11 = i9 >>> i6;
            int i12 = (i11 - i4) - ((~i10) | i11);
            int i13 = (-1700147435) - ((i12 & i5) | (2028104049 - i12));
            switch ((-1363443157) ^ ((~i13) + ((i13 | 1) * i5))) {
                case -1940167324:
                    i = i7;
                    byte b4 = bArr3[i];
                    int i14 = ((byte) 0) - b4;
                    bArr3[i] = (byte) (((byte) (b4 & (~i14))) - ((byte) ((~b4) & i14)));
                    i4 = i4;
                    i9 = 614229416;
                    i7 = i;
                    i6 = 8;
                    i5 = 2;
                case -360299937:
                    int i15 = i4;
                    if ((bArr3[i8] > Double.NaN ? 1 : (bArr3[i8] == Double.NaN ? 0 : -1)) <= -1) {
                        i3 = 0;
                    } else {
                        i3 = i15;
                    }
                    int i16 = i3 == 0 ? 427928065 : -1396193641;
                    if (i3 != 0) {
                        i9 = 614229416;
                    } else {
                        i9 = i16;
                    }
                    i4 = i15;
                    i7 = i8;
                    i6 = 8;
                    i5 = 2;
                case 399486784:
                    break;
                case 585276366:
                    bArr4 = bArr;
                    i8 = 0;
                    bArr3 = bArr2;
                    i9 = 1985663266;
                case 1733787683:
                    byte b5 = bArr4[i7];
                    byte b6 = bArr3[i7];
                    bArr4[i7] = (byte) (((byte) (b6 + b5)) - ((byte) (((byte) i5) * ((byte) (b6 & b5)))));
                    i8 = (i7 ^ 1) + ((i7 & 1) * i5);
                    int i17 = i4;
                    i = i7;
                    if ((((i8 > bArr4.length ? 1 : (i8 == bArr4.length ? 0 : -1)) >>> 31) & i17) != 0) {
                        i4 = i17;
                        i9 = 1985663266;
                    } else {
                        i4 = i17;
                        i9 = -1396193641;
                    }
                    i7 = i;
                    i6 = 8;
                    i5 = 2;
                default:
                    i9 = -1396193641;
            }
            kotlin.jvm.internal.j.e(strArr, new String(bArr, StandardCharsets.UTF_8).intern());
            this.f408a = strArr;
            return;
        }
    }
}
