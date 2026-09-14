package ka;

import y8.k;

/* loaded from: classes.dex */
public final class i {
    public static final byte[] a(String[] strArr) {
        int i10;
        k.e(strArr, "strings");
        int i11 = 0;
        for (String str : strArr) {
            i11 += str.length();
        }
        byte[] bArr = new byte[i11];
        int length = strArr.length;
        int i12 = 0;
        int i13 = 0;
        while (i12 < length) {
            String str2 = strArr[i12];
            i12++;
            int length2 = str2.length() - 1;
            if (length2 >= 0) {
                int i14 = 0;
                while (true) {
                    int i15 = i14 + 1;
                    i10 = i13 + 1;
                    bArr[i13] = (byte) str2.charAt(i14);
                    if (i14 == length2) {
                        break;
                    }
                    i14 = i15;
                    i13 = i10;
                }
                i13 = i10;
            }
        }
        return bArr;
    }
}
