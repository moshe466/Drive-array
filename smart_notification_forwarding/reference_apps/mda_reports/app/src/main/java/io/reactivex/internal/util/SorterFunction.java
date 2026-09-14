package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public final class SorterFunction<T> implements Function<List<T>, List<T>> {
    final Comparator<? super T> a;

    public SorterFunction(Comparator<? super T> comparator) {
        this.a = comparator;
    }

    @Override // io.reactivex.functions.Function
    public List<T> apply(List<T> list) {
        Collections.sort(list, this.a);
        return list;
    }
}
