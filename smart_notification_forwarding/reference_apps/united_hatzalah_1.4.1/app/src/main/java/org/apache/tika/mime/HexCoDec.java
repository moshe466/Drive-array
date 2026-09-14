package org.apache.tika.mime;

import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public class HexCoDec {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] decode(String str) {
        return decode(str.toCharArray());
    }

    public static char[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    private static int hexCharToNibble(char c4) {
        if (c4 >= '0' && c4 <= '9') {
            return c4 - '0';
        }
        if (c4 >= 'a' && c4 <= 'f') {
            return c4 - 'W';
        }
        if (c4 >= 'A' && c4 <= 'F') {
            return c4 - '7';
        }
        throw new IllegalArgumentException("Not a hex char - '" + c4 + "'");
    }

    public static byte[] decode(char[] cArr) {
        return decode(cArr, 0, cArr.length);
    }

    public static char[] encode(byte[] bArr, int i, int i3) {
        char[] cArr = new char[i3 * 2];
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i + 1;
            byte b4 = bArr[i];
            int i7 = b4 & ForkServer.ERROR;
            int i8 = i5 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i5] = cArr2[i7 >> 4];
            i5 += 2;
            cArr[i8] = cArr2[b4 & 15];
            i4++;
            i = i6;
        }
        return cArr;
    }

    public static byte[] decode(char[] cArr, int i, int i3) {
        if ((i3 & 1) == 0) {
            int i4 = i3 / 2;
            byte[] bArr = new byte[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i + 1;
                int hexCharToNibble = hexCharToNibble(cArr[i]) * 16;
                i += 2;
                bArr[i5] = (byte) (hexCharToNibble + hexCharToNibble(cArr[i6]));
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length must be even");
    }
}
