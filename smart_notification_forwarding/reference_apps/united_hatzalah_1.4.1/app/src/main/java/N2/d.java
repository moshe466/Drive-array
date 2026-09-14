package N2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class d implements Iterator, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1519a;

    /* renamed from: b, reason: collision with root package name */
    public int f1520b;

    /* renamed from: c, reason: collision with root package name */
    public int f1521c;

    /* renamed from: d, reason: collision with root package name */
    public int f1522d;

    /* renamed from: e, reason: collision with root package name */
    public int f1523e;

    public d(String str) {
        this.f1519a = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i3 = this.f1520b;
        if (i3 != 0) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        int i4 = 2;
        if (this.f1523e < 0) {
            this.f1520b = 2;
            return false;
        }
        String str = this.f1519a;
        int length = str.length();
        int length2 = str.length();
        for (int i5 = this.f1521c; i5 < length2; i5++) {
            char charAt = str.charAt(i5);
            if (charAt == '\n' || charAt == '\r') {
                if (charAt != '\r' || (i = i5 + 1) >= str.length() || str.charAt(i) != '\n') {
                    i4 = 1;
                }
                length = i5;
                this.f1520b = 1;
                this.f1523e = i4;
                this.f1522d = length;
                return true;
            }
        }
        i4 = -1;
        this.f1520b = 1;
        this.f1523e = i4;
        this.f1522d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f1520b = 0;
            int i = this.f1522d;
            int i3 = this.f1521c;
            this.f1521c = this.f1523e + i;
            return this.f1519a.subSequence(i3, i).toString();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
