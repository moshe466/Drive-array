package M2;

import F0.A0;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class b implements Iterator, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public Object f1408a;

    /* renamed from: b, reason: collision with root package name */
    public int f1409b = -2;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f1410c;

    public b(c cVar) {
        this.f1410c = cVar;
    }

    public final void a() {
        Object invoke;
        int i;
        int i3 = this.f1409b;
        c cVar = this.f1410c;
        if (i3 == -2) {
            invoke = cVar.f1411a.invoke();
        } else {
            A0 a02 = cVar.f1412b;
            Object obj = this.f1408a;
            j.b(obj);
            invoke = a02.invoke(obj);
        }
        this.f1408a = invoke;
        if (invoke == null) {
            i = 0;
        } else {
            i = 1;
        }
        this.f1409b = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1409b < 0) {
            a();
        }
        if (this.f1409b == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f1409b < 0) {
            a();
        }
        if (this.f1409b != 0) {
            Object obj = this.f1408a;
            j.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f1409b = -1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
