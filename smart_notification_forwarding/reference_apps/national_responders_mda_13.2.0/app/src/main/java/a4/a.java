package a4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f179a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f180b = 0;

    static {
        new a(new byte[0]);
    }

    private a(byte[] bArr) {
        this.f179a = bArr;
    }

    public static a a(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static a b(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new a(bArr2);
    }

    public static a c(String str) {
        try {
            return new a(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported.", e10);
        }
    }

    public void d(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f179a, i10, bArr, i11, i12);
    }

    public InputStream e() {
        return new ByteArrayInputStream(this.f179a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f179a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f179a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public int f() {
        return this.f179a.length;
    }

    public int hashCode() {
        int i10 = this.f180b;
        if (i10 == 0) {
            byte[] bArr = this.f179a;
            int length = bArr.length;
            for (byte b10 : bArr) {
                length = (length * 31) + b10;
            }
            i10 = length == 0 ? 1 : length;
            this.f180b = i10;
        }
        return i10;
    }
}
