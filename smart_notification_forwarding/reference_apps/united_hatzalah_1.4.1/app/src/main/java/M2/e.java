package M2;

import a.AbstractC0228a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;
import s2.C0684i;
import w2.C0769j;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.EnumC0779a;
import y2.AbstractC0792h;

/* loaded from: classes.dex */
public final class e implements Iterator, InterfaceC0763d, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public int f1413a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1414b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0763d f1415c;

    public final RuntimeException a() {
        int i = this.f1413a;
        if (i != 4) {
            if (i != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.f1413a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    public final void b(Object obj, AbstractC0792h abstractC0792h) {
        this.f1414b = obj;
        this.f1413a = 3;
        this.f1415c = abstractC0792h;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
    }

    @Override // w2.InterfaceC0763d
    public final InterfaceC0768i getContext() {
        return C0769j.f6733a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        while (true) {
            i = this.f1413a;
            if (i != 0) {
                break;
            }
            this.f1413a = 5;
            InterfaceC0763d interfaceC0763d = this.f1415c;
            j.b(interfaceC0763d);
            this.f1415c = null;
            interfaceC0763d.resumeWith(C0684i.f6340a);
        }
        if (i != 1) {
            if (i == 2 || i == 3) {
                return true;
            }
            if (i == 4) {
                return false;
            }
            throw a();
        }
        j.b(null);
        throw null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f1413a;
        if (i != 0 && i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.f1413a = 0;
                    Object obj = this.f1414b;
                    this.f1414b = null;
                    return obj;
                }
                throw a();
            }
            this.f1413a = 1;
            j.b(null);
            throw null;
        }
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // w2.InterfaceC0763d
    public final void resumeWith(Object obj) {
        AbstractC0228a.C(obj);
        this.f1413a = 4;
    }
}
