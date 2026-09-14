package m8;

import java.util.AbstractCollection;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class c<E> extends AbstractCollection<E> implements Collection<E> {
    public abstract int c();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return c();
    }
}
