package t2;

import java.util.AbstractList;
import java.util.List;

/* renamed from: t2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0702d extends AbstractList implements List, G2.a {
    public abstract int g();

    public abstract Object h(int i);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i) {
        return h(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return g();
    }
}
