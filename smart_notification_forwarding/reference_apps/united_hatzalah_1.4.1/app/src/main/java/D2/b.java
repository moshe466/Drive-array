package D2;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class b implements Iterator, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public String f111a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f112b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f113c;

    public b(c cVar) {
        this.f113c = cVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f111a == null && !this.f112b) {
            String readLine = ((BufferedReader) this.f113c.f115b).readLine();
            this.f111a = readLine;
            if (readLine == null) {
                this.f112b = true;
            }
        }
        if (this.f111a != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            String str = this.f111a;
            this.f111a = null;
            j.b(str);
            return str;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
