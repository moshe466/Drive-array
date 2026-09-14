package t2;

import java.util.Enumeration;
import java.util.Iterator;

/* renamed from: t2.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0710l implements Iterator, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Enumeration f6474a;

    public C0710l(Enumeration enumeration) {
        this.f6474a = enumeration;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6474a.hasMoreElements();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f6474a.nextElement();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
