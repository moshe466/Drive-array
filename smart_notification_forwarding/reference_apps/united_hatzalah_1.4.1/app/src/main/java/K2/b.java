package K2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class b implements Iterator, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f1114a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1115b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1116c;

    /* renamed from: d, reason: collision with root package name */
    public int f1117d;

    public b(char c4, char c5, int i) {
        this.f1114a = i;
        this.f1115b = c5;
        boolean z3 = false;
        if (i <= 0 ? j.f(c4, c5) >= 0 : j.f(c4, c5) <= 0) {
            z3 = true;
        }
        this.f1116c = z3;
        this.f1117d = z3 ? c4 : c5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1116c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f1117d;
        if (i == this.f1115b) {
            if (this.f1116c) {
                this.f1116c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f1117d = this.f1114a + i;
        }
        return Character.valueOf((char) i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
