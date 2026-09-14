package K2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class e implements Iterator, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f1121a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1122b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1123c;

    /* renamed from: d, reason: collision with root package name */
    public int f1124d;

    public e(int i, int i3, int i4) {
        this.f1121a = i4;
        this.f1122b = i3;
        boolean z3 = false;
        if (i4 <= 0 ? i >= i3 : i <= i3) {
            z3 = true;
        }
        this.f1123c = z3;
        this.f1124d = z3 ? i : i3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1123c;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public final int nextInt() {
        int i = this.f1124d;
        if (i == this.f1122b) {
            if (this.f1123c) {
                this.f1123c = false;
                return i;
            }
            throw new NoSuchElementException();
        }
        this.f1124d = this.f1121a + i;
        return i;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
