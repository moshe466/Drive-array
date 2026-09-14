package com.google.crypto.tink.shaded.protobuf;

import F0.AbstractC0008a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.google.crypto.tink.shaded.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0337i implements Iterable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final C0336h f4107b = new C0336h(B.f4030b);

    /* renamed from: c, reason: collision with root package name */
    public static final C0334f f4108c;

    /* renamed from: a, reason: collision with root package name */
    public int f4109a;

    static {
        C0334f c0334f;
        if (AbstractC0331c.a()) {
            c0334f = new C0334f(1);
        } else {
            c0334f = new C0334f(0);
        }
        f4108c = c0334f;
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

    public static C0336h i(byte[] bArr, int i, int i3) {
        byte[] copyOfRange;
        h(i, i + i3, bArr.length);
        switch (f4108c.f4101a) {
            case 0:
                copyOfRange = Arrays.copyOfRange(bArr, i, i3 + i);
                break;
            default:
                copyOfRange = new byte[i3];
                System.arraycopy(bArr, i, copyOfRange, 0, i3);
                break;
        }
        return new C0336h(copyOfRange);
    }

    public abstract byte g(int i);

    public final int hashCode() {
        int i = this.f4109a;
        if (i == 0) {
            int size = size();
            C0336h c0336h = (C0336h) this;
            int l3 = c0336h.l();
            int i3 = size;
            for (int i4 = l3; i4 < l3 + size; i4++) {
                i3 = (i3 * 31) + c0336h.f4105d[i4];
            }
            if (i3 == 0) {
                i3 = 1;
            }
            this.f4109a = i3;
            return i3;
        }
        return i;
    }

    public abstract void j(byte[] bArr, int i);

    public final byte[] k() {
        int size = size();
        if (size == 0) {
            return B.f4030b;
        }
        byte[] bArr = new byte[size];
        j(bArr, size);
        return bArr;
    }

    public abstract int size();

    public final String toString() {
        C0336h c0335g;
        String sb;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            sb = m3.b.m(this);
        } else {
            StringBuilder sb2 = new StringBuilder();
            C0336h c0336h = (C0336h) this;
            int h2 = h(0, 47, c0336h.size());
            if (h2 == 0) {
                c0335g = f4107b;
            } else {
                c0335g = new C0335g(c0336h.f4105d, c0336h.l(), h2);
            }
            sb2.append(m3.b.m(c0335g));
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
