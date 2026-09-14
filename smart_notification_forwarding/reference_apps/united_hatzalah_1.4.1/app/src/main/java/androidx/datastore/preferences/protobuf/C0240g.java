package androidx.datastore.preferences.protobuf;

import F0.AbstractC0008a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: androidx.datastore.preferences.protobuf.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0240g implements Iterable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final C0240g f3173c = new C0240g(AbstractC0255w.f3237b);

    /* renamed from: d, reason: collision with root package name */
    public static final C0238e f3174d;

    /* renamed from: a, reason: collision with root package name */
    public int f3175a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3176b;

    static {
        C0238e c0238e;
        if (AbstractC0236c.a()) {
            c0238e = new C0238e(1);
        } else {
            c0238e = new C0238e(0);
        }
        f3174d = c0238e;
    }

    public C0240g(byte[] bArr) {
        bArr.getClass();
        this.f3176b = bArr;
    }

    public static int h(int i, int i3, int i4) {
        int i5 = i3 - i;
        if ((i | i3 | i5 | (i4 - i3)) < 0) {
            if (i >= 0) {
                if (i3 < i) {
                    throw new IndexOutOfBoundsException(AbstractC0008a.k("Beginning index larger than ending index: ", i, i3, ", "));
                }
                throw new IndexOutOfBoundsException(AbstractC0008a.k("End index: ", i3, i4, " >= "));
            }
            throw new IndexOutOfBoundsException(AbstractC0008a.j(i, "Beginning index: ", " < 0"));
        }
        return i5;
    }

    public static C0240g i(byte[] bArr, int i, int i3) {
        byte[] copyOfRange;
        h(i, i + i3, bArr.length);
        switch (f3174d.f3162a) {
            case 0:
                copyOfRange = Arrays.copyOfRange(bArr, i, i3 + i);
                break;
            default:
                copyOfRange = new byte[i3];
                System.arraycopy(bArr, i, copyOfRange, 0, i3);
                break;
        }
        return new C0240g(copyOfRange);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if ((obj instanceof C0240g) && size() == ((C0240g) obj).size()) {
                if (size() != 0) {
                    if (obj instanceof C0240g) {
                        C0240g c0240g = (C0240g) obj;
                        int i = this.f3175a;
                        int i3 = c0240g.f3175a;
                        if (i == 0 || i3 == 0 || i == i3) {
                            int size = size();
                            if (size <= c0240g.size()) {
                                if (size <= c0240g.size()) {
                                    byte[] bArr = c0240g.f3176b;
                                    int k4 = k() + size;
                                    int k5 = k();
                                    int k6 = c0240g.k();
                                    while (k5 < k4) {
                                        if (this.f3176b[k5] != bArr[k6]) {
                                            return false;
                                        }
                                        k5++;
                                        k6++;
                                    }
                                    return true;
                                }
                                StringBuilder w3 = AbstractC0008a.w(size, "Ran off end of other: 0, ", ", ");
                                w3.append(c0240g.size());
                                throw new IllegalArgumentException(w3.toString());
                            }
                            throw new IllegalArgumentException("Length too large: " + size + size());
                        }
                        return false;
                    }
                    return obj.equals(this);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public byte g(int i) {
        return this.f3176b[i];
    }

    public final int hashCode() {
        int i = this.f3175a;
        if (i == 0) {
            int size = size();
            int k4 = k();
            int i3 = size;
            for (int i4 = k4; i4 < k4 + size; i4++) {
                i3 = (i3 * 31) + this.f3176b[i4];
            }
            if (i3 == 0) {
                i3 = 1;
            }
            this.f3175a = i3;
            return i3;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0237d(this);
    }

    public void j(byte[] bArr, int i) {
        System.arraycopy(this.f3176b, 0, bArr, 0, i);
    }

    public int k() {
        return 0;
    }

    public byte l(int i) {
        return this.f3176b[i];
    }

    public int size() {
        return this.f3176b.length;
    }

    public final String toString() {
        C0240g c0239f;
        String sb;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            sb = m3.b.l(this);
        } else {
            StringBuilder sb2 = new StringBuilder();
            int h2 = h(0, 47, size());
            if (h2 == 0) {
                c0239f = f3173c;
            } else {
                c0239f = new C0239f(this.f3176b, k(), h2);
            }
            sb2.append(m3.b.l(c0239f));
            sb2.append("...");
            sb = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder("<ByteString@");
        sb3.append(hexString);
        sb3.append(" size=");
        sb3.append(size);
        sb3.append(" contents=\"");
        return AbstractC0008a.u(sb3, sb, "\">");
    }
}
