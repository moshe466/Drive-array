package dc;

import java.util.Comparator;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f8853a = 0;

    private void t(Object obj, Object obj2, Comparator<?> comparator) {
        if (obj instanceof long[]) {
            p((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            o((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            r((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            l((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            k((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            m((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            n((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            s((boolean[]) obj, (boolean[]) obj2);
        } else {
            q((Object[]) obj, (Object[]) obj2, comparator);
        }
    }

    public a a(byte b10, byte b11) {
        if (this.f8853a != 0) {
            return this;
        }
        this.f8853a = Byte.compare(b10, b11);
        return this;
    }

    public a b(char c10, char c11) {
        if (this.f8853a != 0) {
            return this;
        }
        this.f8853a = Character.compare(c10, c11);
        return this;
    }

    public a c(double d10, double d11) {
        if (this.f8853a != 0) {
            return this;
        }
        this.f8853a = Double.compare(d10, d11);
        return this;
    }

    public a d(float f10, float f11) {
        if (this.f8853a != 0) {
            return this;
        }
        this.f8853a = Float.compare(f10, f11);
        return this;
    }

    public a e(int i10, int i11) {
        if (this.f8853a != 0) {
            return this;
        }
        this.f8853a = Integer.compare(i10, i11);
        return this;
    }

    public a f(long j10, long j11) {
        if (this.f8853a != 0) {
            return this;
        }
        this.f8853a = Long.compare(j10, j11);
        return this;
    }

    public a g(Object obj, Object obj2) {
        return h(obj, obj2, null);
    }

    public a h(Object obj, Object obj2, Comparator<?> comparator) {
        int i10;
        if (this.f8853a != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            i10 = -1;
        } else {
            if (obj2 != null) {
                if (obj.getClass().isArray()) {
                    t(obj, obj2, comparator);
                } else {
                    this.f8853a = comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
                }
                return this;
            }
            i10 = 1;
        }
        this.f8853a = i10;
        return this;
    }

    public a i(short s10, short s11) {
        if (this.f8853a != 0) {
            return this;
        }
        this.f8853a = Short.compare(s10, s11);
        return this;
    }

    public a j(boolean z10, boolean z11) {
        if (this.f8853a != 0 || z10 == z11) {
            return this;
        }
        this.f8853a = z10 ? 1 : -1;
        return this;
    }

    public a k(byte[] bArr, byte[] bArr2) {
        if (this.f8853a != 0 || bArr == bArr2) {
            return this;
        }
        if (bArr == null) {
            this.f8853a = -1;
            return this;
        }
        if (bArr2 == null) {
            this.f8853a = 1;
            return this;
        }
        if (bArr.length != bArr2.length) {
            this.f8853a = bArr.length >= bArr2.length ? 1 : -1;
            return this;
        }
        for (int i10 = 0; i10 < bArr.length && this.f8853a == 0; i10++) {
            a(bArr[i10], bArr2[i10]);
        }
        return this;
    }

    public a l(char[] cArr, char[] cArr2) {
        if (this.f8853a != 0 || cArr == cArr2) {
            return this;
        }
        if (cArr == null) {
            this.f8853a = -1;
            return this;
        }
        if (cArr2 == null) {
            this.f8853a = 1;
            return this;
        }
        if (cArr.length != cArr2.length) {
            this.f8853a = cArr.length >= cArr2.length ? 1 : -1;
            return this;
        }
        for (int i10 = 0; i10 < cArr.length && this.f8853a == 0; i10++) {
            b(cArr[i10], cArr2[i10]);
        }
        return this;
    }

    public a m(double[] dArr, double[] dArr2) {
        if (this.f8853a != 0 || dArr == dArr2) {
            return this;
        }
        if (dArr == null) {
            this.f8853a = -1;
            return this;
        }
        if (dArr2 == null) {
            this.f8853a = 1;
            return this;
        }
        if (dArr.length != dArr2.length) {
            this.f8853a = dArr.length >= dArr2.length ? 1 : -1;
            return this;
        }
        for (int i10 = 0; i10 < dArr.length && this.f8853a == 0; i10++) {
            c(dArr[i10], dArr2[i10]);
        }
        return this;
    }

    public a n(float[] fArr, float[] fArr2) {
        if (this.f8853a != 0 || fArr == fArr2) {
            return this;
        }
        if (fArr == null) {
            this.f8853a = -1;
            return this;
        }
        if (fArr2 == null) {
            this.f8853a = 1;
            return this;
        }
        if (fArr.length != fArr2.length) {
            this.f8853a = fArr.length >= fArr2.length ? 1 : -1;
            return this;
        }
        for (int i10 = 0; i10 < fArr.length && this.f8853a == 0; i10++) {
            d(fArr[i10], fArr2[i10]);
        }
        return this;
    }

    public a o(int[] iArr, int[] iArr2) {
        if (this.f8853a != 0 || iArr == iArr2) {
            return this;
        }
        if (iArr == null) {
            this.f8853a = -1;
            return this;
        }
        if (iArr2 == null) {
            this.f8853a = 1;
            return this;
        }
        if (iArr.length != iArr2.length) {
            this.f8853a = iArr.length >= iArr2.length ? 1 : -1;
            return this;
        }
        for (int i10 = 0; i10 < iArr.length && this.f8853a == 0; i10++) {
            e(iArr[i10], iArr2[i10]);
        }
        return this;
    }

    public a p(long[] jArr, long[] jArr2) {
        if (this.f8853a != 0 || jArr == jArr2) {
            return this;
        }
        if (jArr == null) {
            this.f8853a = -1;
            return this;
        }
        if (jArr2 == null) {
            this.f8853a = 1;
            return this;
        }
        if (jArr.length != jArr2.length) {
            this.f8853a = jArr.length >= jArr2.length ? 1 : -1;
            return this;
        }
        for (int i10 = 0; i10 < jArr.length && this.f8853a == 0; i10++) {
            f(jArr[i10], jArr2[i10]);
        }
        return this;
    }

    public a q(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.f8853a != 0 || objArr == objArr2) {
            return this;
        }
        if (objArr == null) {
            this.f8853a = -1;
            return this;
        }
        if (objArr2 == null) {
            this.f8853a = 1;
            return this;
        }
        if (objArr.length != objArr2.length) {
            this.f8853a = objArr.length >= objArr2.length ? 1 : -1;
            return this;
        }
        for (int i10 = 0; i10 < objArr.length && this.f8853a == 0; i10++) {
            h(objArr[i10], objArr2[i10], comparator);
        }
        return this;
    }

    public a r(short[] sArr, short[] sArr2) {
        if (this.f8853a != 0 || sArr == sArr2) {
            return this;
        }
        if (sArr == null) {
            this.f8853a = -1;
            return this;
        }
        if (sArr2 == null) {
            this.f8853a = 1;
            return this;
        }
        if (sArr.length != sArr2.length) {
            this.f8853a = sArr.length >= sArr2.length ? 1 : -1;
            return this;
        }
        for (int i10 = 0; i10 < sArr.length && this.f8853a == 0; i10++) {
            i(sArr[i10], sArr2[i10]);
        }
        return this;
    }

    public a s(boolean[] zArr, boolean[] zArr2) {
        if (this.f8853a != 0 || zArr == zArr2) {
            return this;
        }
        if (zArr == null) {
            this.f8853a = -1;
            return this;
        }
        if (zArr2 == null) {
            this.f8853a = 1;
            return this;
        }
        if (zArr.length != zArr2.length) {
            this.f8853a = zArr.length >= zArr2.length ? 1 : -1;
            return this;
        }
        for (int i10 = 0; i10 < zArr.length && this.f8853a == 0; i10++) {
            j(zArr[i10], zArr2[i10]);
        }
        return this;
    }

    public int u() {
        return this.f8853a;
    }
}
