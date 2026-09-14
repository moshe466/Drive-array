package bc;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class f implements Serializable, Comparable<f> {

    /* renamed from: i, reason: collision with root package name */
    static final char[] f4299i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: j, reason: collision with root package name */
    public static final f f4300j = w(new byte[0]);

    /* renamed from: f, reason: collision with root package name */
    final byte[] f4301f;

    /* renamed from: g, reason: collision with root package name */
    transient int f4302g;

    /* renamed from: h, reason: collision with root package name */
    transient String f4303h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(byte[] bArr) {
        this.f4301f = bArr;
    }

    static int k(String str, int i10) {
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            if (i12 == i10) {
                return i11;
            }
            int codePointAt = str.codePointAt(i11);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i12++;
            i11 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    public static f n(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a10 = b.a(str);
        if (a10 != null) {
            return new f(a10);
        }
        return null;
    }

    public static f o(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) ((r(str.charAt(i11)) << 4) + r(str.charAt(i11 + 1)));
        }
        return w(bArr);
    }

    private static int r(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (c10 < 'a' || c10 > 'f') {
            c11 = 'A';
            if (c10 < 'A' || c10 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c10);
            }
        }
        return (c10 - c11) + 10;
    }

    private f s(String str) {
        try {
            return w(MessageDigest.getInstance(str).digest(this.f4301f));
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }

    public static f t(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(u.f4343a));
        fVar.f4303h = str;
        return fVar;
    }

    public static f w(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public f A() {
        return s("SHA-256");
    }

    public int B() {
        return this.f4301f.length;
    }

    public final boolean C(f fVar) {
        return x(0, fVar, 0, fVar.B());
    }

    public f D(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f4301f;
        if (i11 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f4301f.length + ")");
        }
        int i12 = i11 - i10;
        if (i12 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i10 == 0 && i11 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i10, bArr2, 0, i12);
        return new f(bArr2);
    }

    public f E() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f4301f;
            if (i10 >= bArr.length) {
                return this;
            }
            byte b10 = bArr[i10];
            if (b10 >= 65 && b10 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < bArr2.length; i11++) {
                    byte b11 = bArr2[i11];
                    if (b11 >= 65 && b11 <= 90) {
                        bArr2[i11] = (byte) (b11 + 32);
                    }
                }
                return new f(bArr2);
            }
            i10++;
        }
    }

    public byte[] F() {
        return (byte[]) this.f4301f.clone();
    }

    public String G() {
        String str = this.f4303h;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f4301f, u.f4343a);
        this.f4303h = str2;
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(c cVar) {
        byte[] bArr = this.f4301f;
        cVar.b(bArr, 0, bArr.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int B = fVar.B();
            byte[] bArr = this.f4301f;
            if (B == bArr.length && fVar.y(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.f4302g;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = Arrays.hashCode(this.f4301f);
        this.f4302g = hashCode;
        return hashCode;
    }

    public String j() {
        return b.b(this.f4301f);
    }

    @Override // java.lang.Comparable
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int B = B();
        int B2 = fVar.B();
        int min = Math.min(B, B2);
        for (int i10 = 0; i10 < min; i10++) {
            int u10 = u(i10) & 255;
            int u11 = fVar.u(i10) & 255;
            if (u10 != u11) {
                return u10 < u11 ? -1 : 1;
            }
        }
        if (B == B2) {
            return 0;
        }
        return B < B2 ? -1 : 1;
    }

    public String toString() {
        StringBuilder sb2;
        StringBuilder sb3;
        if (this.f4301f.length == 0) {
            return "[size=0]";
        }
        String G = G();
        int k10 = k(G, 64);
        if (k10 == -1) {
            if (this.f4301f.length <= 64) {
                sb3 = new StringBuilder();
                sb3.append("[hex=");
                sb3.append(v());
                sb3.append("]");
            } else {
                sb3 = new StringBuilder();
                sb3.append("[size=");
                sb3.append(this.f4301f.length);
                sb3.append(" hex=");
                sb3.append(D(0, 64).v());
                sb3.append("…]");
            }
            return sb3.toString();
        }
        String replace = G.substring(0, k10).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (k10 < G.length()) {
            sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(this.f4301f.length);
            sb2.append(" text=");
            sb2.append(replace);
            sb2.append("…]");
        } else {
            sb2 = new StringBuilder();
            sb2.append("[text=");
            sb2.append(replace);
            sb2.append("]");
        }
        return sb2.toString();
    }

    public byte u(int i10) {
        return this.f4301f[i10];
    }

    public String v() {
        byte[] bArr = this.f4301f;
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = f4299i;
            cArr[i10] = cArr2[(b10 >> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public boolean x(int i10, f fVar, int i11, int i12) {
        return fVar.y(i11, this.f4301f, i10, i12);
    }

    public boolean y(int i10, byte[] bArr, int i11, int i12) {
        if (i10 >= 0) {
            byte[] bArr2 = this.f4301f;
            if (i10 <= bArr2.length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && u.a(bArr2, i10, bArr, i11, i12)) {
                return true;
            }
        }
        return false;
    }

    public f z() {
        return s("SHA-1");
    }
}
