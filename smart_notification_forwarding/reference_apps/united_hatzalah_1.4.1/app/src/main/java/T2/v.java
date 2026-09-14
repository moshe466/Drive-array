package t2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class v implements Iterator, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public int f6479a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6480b;

    /* renamed from: c, reason: collision with root package name */
    public int f6481c;

    /* renamed from: d, reason: collision with root package name */
    public int f6482d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ w f6483e;

    public v(w wVar) {
        this.f6483e = wVar;
        this.f6481c = wVar.f6487d;
        this.f6482d = wVar.f6486c;
    }

    public final boolean a() {
        this.f6479a = 3;
        int i = this.f6481c;
        if (i == 0) {
            this.f6479a = 2;
        } else {
            w wVar = this.f6483e;
            Object[] objArr = wVar.f6484a;
            int i3 = this.f6482d;
            this.f6480b = objArr[i3];
            this.f6479a = 1;
            this.f6482d = (i3 + 1) % wVar.f6485b;
            this.f6481c = i - 1;
        }
        if (this.f6479a == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f6479a;
        if (i != 0) {
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
        }
        return a();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f6479a;
        if (i == 1) {
            this.f6479a = 0;
            return this.f6480b;
        }
        if (i != 2 && a()) {
            this.f6479a = 0;
            return this.f6480b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
