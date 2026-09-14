package net.sourceforge.zbar;

import java.util.AbstractCollection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SymbolSet extends AbstractCollection<Symbol> {

    /* renamed from: f, reason: collision with root package name */
    private long f12444f;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SymbolSet(long j10) {
        this.f12444f = j10;
    }

    private native void destroy(long j10);

    private native long firstSymbol(long j10);

    private static native void init();

    public synchronized void c() {
        long j10 = this.f12444f;
        if (j10 != 0) {
            destroy(j10);
            this.f12444f = 0L;
        }
    }

    protected void finalize() {
        c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Symbol> iterator() {
        long firstSymbol = firstSymbol(this.f12444f);
        return firstSymbol == 0 ? new a(null) : new a(new Symbol(firstSymbol));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public native int size();
}
