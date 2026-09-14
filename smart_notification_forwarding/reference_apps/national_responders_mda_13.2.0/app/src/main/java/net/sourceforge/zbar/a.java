package net.sourceforge.zbar;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class a implements Iterator<Symbol> {

    /* renamed from: f, reason: collision with root package name */
    private Symbol f12445f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Symbol symbol) {
        this.f12445f = symbol;
    }

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Symbol next() {
        Symbol symbol = this.f12445f;
        if (symbol == null) {
            throw new NoSuchElementException("access past end of SymbolIterator");
        }
        long next = symbol.next();
        if (next != 0) {
            this.f12445f = new Symbol(next);
        } else {
            this.f12445f = null;
        }
        return symbol;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12445f != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("SymbolIterator is immutable");
    }
}
