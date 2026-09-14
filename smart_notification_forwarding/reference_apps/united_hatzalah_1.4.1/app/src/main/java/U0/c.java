package U0;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f2326e = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2327a;

    /* renamed from: b, reason: collision with root package name */
    public int f2328b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2329c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f2330d;

    public c(byte[] bArr) {
        int length = bArr.length;
        this.f2327a = bArr;
        this.f2328b = 0;
        this.f2329c = length;
    }

    public static a a(String str) {
        int indexOf = str.indexOf(": ");
        if (indexOf == -1) {
            return new a(str, "");
        }
        return new a(str.substring(0, indexOf), str.substring(indexOf + 2));
    }

    public final String b() {
        byte[] bArr = this.f2330d;
        byte[] bArr2 = f2326e;
        if (bArr != null && bArr.length == 0) {
            this.f2330d = null;
        } else {
            byte[] c4 = c();
            if (c4 == null) {
                bArr2 = this.f2330d;
                if (bArr2 != null) {
                    this.f2330d = null;
                } else {
                    bArr2 = null;
                }
            } else if (c4.length == 0) {
                c4 = this.f2330d;
                if (c4 != null) {
                    this.f2330d = bArr2;
                    bArr2 = c4;
                }
            } else {
                byte[] bArr3 = this.f2330d;
                if (bArr3 != null) {
                    if (c4.length != 0 && c4[0] == 32) {
                        this.f2330d = null;
                        int length = c4.length - 1;
                        byte[] bArr4 = new byte[bArr3.length + length];
                        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                        System.arraycopy(c4, 1, bArr4, bArr3.length, length);
                        c4 = bArr4;
                    } else {
                        this.f2330d = c4;
                        bArr2 = bArr3;
                    }
                }
                while (true) {
                    byte[] c5 = c();
                    if (c5 == null) {
                        break;
                    }
                    if (c5.length == 0) {
                        this.f2330d = bArr2;
                        break;
                    }
                    if (c5[0] == 32) {
                        int length2 = c5.length - 1;
                        byte[] bArr5 = new byte[c4.length + length2];
                        System.arraycopy(c4, 0, bArr5, 0, c4.length);
                        System.arraycopy(c5, 1, bArr5, c4.length, length2);
                        c4 = bArr5;
                    } else {
                        this.f2330d = c5;
                        break;
                    }
                }
                bArr2 = c4;
            }
        }
        if (bArr2 == null) {
            return null;
        }
        if (bArr2.length == 0) {
            return "";
        }
        return new String(bArr2, StandardCharsets.UTF_8);
    }

    public final byte[] c() {
        byte[] bArr;
        int i;
        int i3 = this.f2328b;
        int i4 = this.f2329c;
        if (i3 >= i4) {
            return null;
        }
        int i5 = i3;
        while (true) {
            bArr = this.f2327a;
            if (i5 < i4) {
                byte b4 = bArr[i5];
                if (b4 == 13) {
                    i = i5 + 1;
                    if (i < i4 && bArr[i] == 10) {
                        i = i5 + 2;
                    }
                } else {
                    if (b4 == 10) {
                        i = i5 + 1;
                        break;
                    }
                    i5++;
                }
            } else {
                i5 = -1;
                i = -1;
                break;
            }
        }
        if (i5 == -1) {
            i5 = i4;
        } else {
            i4 = i;
        }
        this.f2328b = i4;
        if (i5 == i3) {
            return f2326e;
        }
        return Arrays.copyOfRange(bArr, i3, i5);
    }

    public final b d() {
        int i;
        String b4;
        do {
            i = this.f2328b;
            b4 = b();
            if (b4 == null) {
                return null;
            }
        } while (b4.length() == 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(b4));
        while (true) {
            String b5 = b();
            if (b5 == null || b5.length() == 0) {
                break;
            }
            arrayList.add(a(b5));
        }
        return new b(arrayList, i, this.f2328b - i);
    }
}
