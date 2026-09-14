package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
public final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> a;

    ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.a = immutableMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExplicitOrdering(List<T> list) {
        this(Maps.a(list));
    }

    private int rank(T t) {
        Integer num = this.a.get(t);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.IncomparableValueException(t);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        return rank(t) - rank(t2);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.a.equals(((ExplicitOrdering) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.a.keySet() + ")";
    }
}
