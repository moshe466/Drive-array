package K1;

import a.AbstractC0228a;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class l implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1101a;

    public l(byte[] bArr) {
        this.f1101a = Arrays.copyOf(bArr, bArr.length);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        l lVar = (l) obj;
        byte[] bArr = this.f1101a;
        int length = bArr.length;
        byte[] bArr2 = lVar.f1101a;
        if (length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b4 = bArr[i];
            byte b5 = lVar.f1101a[i];
            if (b4 != b5) {
                return b4 - b5;
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        return Arrays.equals(this.f1101a, ((l) obj).f1101a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1101a);
    }

    public final String toString() {
        return AbstractC0228a.n(this.f1101a);
    }
}
