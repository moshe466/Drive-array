package xb;

import java.io.IOException;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    static final bc.f f15701a = bc.f.t("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f15702b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c, reason: collision with root package name */
    static final String[] f15703c = new String[64];

    /* renamed from: d, reason: collision with root package name */
    static final String[] f15704d = new String[256];

    static {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr = f15704d;
            if (i11 >= strArr.length) {
                break;
            }
            strArr[i11] = sb.c.r("%8s", Integer.toBinaryString(i11)).replace(' ', '0');
            i11++;
        }
        String[] strArr2 = f15703c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i12 = 0; i12 < 1; i12++) {
            int i13 = iArr[i12];
            String[] strArr3 = f15703c;
            strArr3[i13 | 8] = strArr3[i13] + "|PADDED";
        }
        String[] strArr4 = f15703c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i14 = 0; i14 < 3; i14++) {
            int i15 = iArr2[i14];
            for (int i16 = 0; i16 < 1; i16++) {
                int i17 = iArr[i16];
                String[] strArr5 = f15703c;
                int i18 = i17 | i15;
                strArr5[i18] = strArr5[i17] + '|' + strArr5[i15];
                strArr5[i18 | 8] = strArr5[i17] + '|' + strArr5[i15] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = f15703c;
            if (i10 >= strArr6.length) {
                return;
            }
            if (strArr6[i10] == null) {
                strArr6[i10] = f15704d[i10];
            }
            i10++;
        }
    }

    private e() {
    }

    static String a(byte b10, byte b11) {
        if (b11 == 0) {
            return "";
        }
        if (b10 != 2 && b10 != 3) {
            if (b10 == 4 || b10 == 6) {
                return b11 == 1 ? "ACK" : f15704d[b11];
            }
            if (b10 != 7 && b10 != 8) {
                String[] strArr = f15703c;
                String str = b11 < strArr.length ? strArr[b11] : f15704d[b11];
                return (b10 != 5 || (b11 & 4) == 0) ? (b10 != 0 || (b11 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f15704d[b11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(boolean z10, int i10, int i11, byte b10, byte b11) {
        String[] strArr = f15702b;
        String r10 = b10 < strArr.length ? strArr[b10] : sb.c.r("0x%02x", Byte.valueOf(b10));
        String a10 = a(b10, b11);
        Object[] objArr = new Object[5];
        objArr[0] = z10 ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i10);
        objArr[2] = Integer.valueOf(i11);
        objArr[3] = r10;
        objArr[4] = a10;
        return sb.c.r("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(sb.c.r(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOException d(String str, Object... objArr) {
        throw new IOException(sb.c.r(str, objArr));
    }
}
