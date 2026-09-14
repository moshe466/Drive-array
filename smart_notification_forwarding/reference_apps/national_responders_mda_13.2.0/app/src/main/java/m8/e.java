package m8;

import java.util.AbstractSet;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class e<E> extends AbstractSet<E> implements Set<E> {
    public abstract int c();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return c();
    }
}
