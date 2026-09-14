package Y1;

import a.AbstractC0228a;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2706a;

    public a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        this.f2706a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i);
    }

    public static a a(byte[] bArr) {
        if (bArr != null) {
            return new a(bArr, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return Arrays.equals(((a) obj).f2706a, this.f2706a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2706a);
    }

    public final String toString() {
        return "Bytes(" + AbstractC0228a.n(this.f2706a) + ")";
    }
}
