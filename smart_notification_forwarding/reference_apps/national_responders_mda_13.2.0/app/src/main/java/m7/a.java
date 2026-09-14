package m7;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f12022a = {0, 15};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f12023b = {16, 17};

    public static String a(byte[] bArr, int i10) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = bArr[i11];
            char f10 = f(i12 < 0 ? (i12 + 256) & 15 : i12 & 15);
            if (i12 < 0) {
                i12 += 256;
            }
            sb2.append(f(i12 >> 4));
            sb2.append(f10);
        }
        return sb2.toString();
    }

    public static byte[] b(byte[] bArr, int[] iArr) {
        byte[] bArr2 = new byte[(iArr[1] - iArr[0]) + 1];
        System.arraycopy(bArr, iArr[0], bArr2, 0, (iArr[1] - iArr[0]) + 1);
        return bArr2;
    }

    public static byte[] c(byte[] bArr, int[] iArr) {
        int i10 = 0;
        for (int i11 = iArr[0]; bArr[i11] != 0 && i11 <= iArr[1]; i11++) {
            i10++;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, iArr[0], bArr2, 0, i10);
        return bArr2;
    }

    public static int d(byte[] bArr, int[] iArr) {
        int i10 = iArr[1];
        int i11 = 0;
        int i12 = 0;
        while (i10 >= iArr[0]) {
            byte b10 = bArr[i10];
            for (int i13 = 0; i13 < i12; i13++) {
                b10 = (byte) (b10 << 8);
            }
            i11 |= b10;
            i10--;
            i12++;
        }
        return i11;
    }

    public static String e(byte[] bArr, int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = iArr[0]; i10 <= iArr[1] && ((char) bArr[i10]) != 0; i10++) {
            sb2.append((char) bArr[i10]);
        }
        return sb2.toString();
    }

    private static char f(int i10) {
        return (char) ((i10 < 0 || i10 > 9) ? (i10 - 10) + 97 : i10 + 48);
    }
}
