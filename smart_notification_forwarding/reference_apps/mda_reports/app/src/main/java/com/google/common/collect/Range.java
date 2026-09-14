package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {
    private static final Range<Comparable> ALL = new Range<>(Cut.e(), Cut.d());
    private static final long serialVersionUID = 0;
    final Cut<C> a;
    final Cut<C> b;

    /* renamed from: com.google.common.collect.Range$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[BoundType.values().length];

        static {
            try {
                a[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    static class LowerBoundFn implements Function<Range, Cut> {
        static final LowerBoundFn a = new LowerBoundFn();

        LowerBoundFn() {
        }

        @Override // com.google.common.base.Function
        public Cut apply(Range range) {
            return range.a;
        }
    }

    /* loaded from: classes2.dex */
    private static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        static final Ordering<Range<?>> a = new RangeLexOrdering();
        private static final long serialVersionUID = 0;

        private RangeLexOrdering() {
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Range<?> range, Range<?> range2) {
            return ComparisonChain.start().compare(range.a, range2.a).compare(range.b, range2.b).result();
        }
    }

    /* loaded from: classes2.dex */
    static class UpperBoundFn implements Function<Range, Cut> {
        static final UpperBoundFn a = new UpperBoundFn();

        UpperBoundFn() {
        }

        @Override // com.google.common.base.Function
        public Cut apply(Range range) {
            return range.b;
        }
    }

    private Range(Cut<C> cut, Cut<C> cut2) {
        this.a = (Cut) Preconditions.checkNotNull(cut);
        this.b = (Cut) Preconditions.checkNotNull(cut2);
        if (cut.compareTo((Cut) cut2) > 0 || cut == Cut.d() || cut2 == Cut.e()) {
            throw new IllegalArgumentException("Invalid range: " + toString(cut, cut2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Function<Range<C>, Cut<C>> a() {
        return LowerBoundFn.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Range<C> a(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c) {
        return a(Cut.c(c), Cut.d());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c) {
        return a(Cut.e(), Cut.b(c));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Ordering<Range<C>> b() {
        return (Ordering<Range<C>>) RangeLexOrdering.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Function<Range<C>, Cut<C>> c() {
        return UpperBoundFn.a;
    }

    private static <T> SortedSet<T> cast(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    public static <C extends Comparable<?>> Range<C> closed(C c, C c2) {
        return a(Cut.c(c), Cut.b(c2));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c, C c2) {
        return a(Cut.c(c), Cut.c(c2));
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c, BoundType boundType) {
        int i = AnonymousClass1.a[boundType.ordinal()];
        if (i == 1) {
            return greaterThan(c);
        }
        if (i == 2) {
            return atLeast(c);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet cast = cast(iterable);
            Comparator comparator = cast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) cast.first(), (Comparable) cast.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) Preconditions.checkNotNull(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) Preconditions.checkNotNull(it.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c) {
        return a(Cut.b(c), Cut.d());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c) {
        return a(Cut.e(), Cut.c(c));
    }

    public static <C extends Comparable<?>> Range<C> open(C c, C c2) {
        return a(Cut.b(c), Cut.c(c2));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c, C c2) {
        return a(Cut.b(c), Cut.b(c2));
    }

    public static <C extends Comparable<?>> Range<C> range(C c, BoundType boundType, C c2, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return a(boundType == BoundType.OPEN ? Cut.b(c) : Cut.c(c), boundType2 == BoundType.OPEN ? Cut.c(c2) : Cut.b(c2));
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c) {
        return closed(c, c);
    }

    private static String toString(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.a(sb);
        sb.append("..");
        cut2.b(sb);
        return sb.toString();
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c, BoundType boundType) {
        int i = AnonymousClass1.a[boundType.ordinal()];
        if (i == 1) {
            return lessThan(c);
        }
        if (i == 2) {
            return atMost(c);
        }
        throw new AssertionError();
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(C c) {
        return contains(c);
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        Cut<C> a = this.a.a(discreteDomain);
        Cut<C> a2 = this.b.a(discreteDomain);
        return (a == this.a && a2 == this.b) ? this : a((Cut) a, (Cut) a2);
    }

    public boolean contains(C c) {
        Preconditions.checkNotNull(c);
        return this.a.a((Cut<C>) c) && !this.b.a((Cut<C>) c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (Iterables.isEmpty(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet cast = cast(iterable);
            Comparator comparator = cast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return contains((Comparable) cast.first()) && contains((Comparable) cast.last());
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.a.compareTo((Cut) range.a) <= 0 && this.b.compareTo((Cut) range.b) >= 0;
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.a.equals(range.a) && this.b.equals(range.b);
    }

    public boolean hasLowerBound() {
        return this.a != Cut.e();
    }

    public boolean hasUpperBound() {
        return this.b != Cut.d();
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        int compareTo = this.a.compareTo((Cut) range.a);
        int compareTo2 = this.b.compareTo((Cut) range.b);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo > 0 || compareTo2 < 0) {
            return a((Cut) (compareTo >= 0 ? this.a : range.a), (Cut) (compareTo2 <= 0 ? this.b : range.b));
        }
        return range;
    }

    public boolean isConnected(Range<C> range) {
        return this.a.compareTo((Cut) range.b) <= 0 && range.a.compareTo((Cut) this.b) <= 0;
    }

    public boolean isEmpty() {
        return this.a.equals(this.b);
    }

    public BoundType lowerBoundType() {
        return this.a.b();
    }

    public C lowerEndpoint() {
        return this.a.a();
    }

    public Range<C> span(Range<C> range) {
        int compareTo = this.a.compareTo((Cut) range.a);
        int compareTo2 = this.b.compareTo((Cut) range.b);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo < 0 || compareTo2 > 0) {
            return a((Cut) (compareTo <= 0 ? this.a : range.a), (Cut) (compareTo2 >= 0 ? this.b : range.b));
        }
        return range;
    }

    public String toString() {
        return toString(this.a, this.b);
    }

    public BoundType upperBoundType() {
        return this.b.c();
    }

    public C upperEndpoint() {
        return this.b.a();
    }
}
