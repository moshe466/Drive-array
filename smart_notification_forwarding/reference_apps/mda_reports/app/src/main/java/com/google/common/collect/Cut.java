package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long serialVersionUID = 0;

    @NullableDecl
    final C a;

    /* renamed from: com.google.common.collect.Cut$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[BoundType.values().length];

        static {
            try {
                a[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class AboveAll extends Cut<Comparable<?>> {
        private static final AboveAll INSTANCE = new AboveAll();
        private static final long serialVersionUID = 0;

        private AboveAll() {
            super(null);
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> a(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> a() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        void a(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        boolean a(Comparable<?> comparable) {
            return false;
        }

        @Override // com.google.common.collect.Cut
        BoundType b() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> b(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> b(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.maxValue();
        }

        @Override // com.google.common.collect.Cut
        void b(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        BoundType c() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> c(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : 1;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        public String toString() {
            return "+∞";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        AboveValue(C c) {
            super((Comparable) Preconditions.checkNotNull(c));
        }

        @Override // com.google.common.collect.Cut
        Cut<C> a(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i = AnonymousClass1.a[boundType.ordinal()];
            if (i == 1) {
                C next = discreteDomain.next(this.a);
                return next == null ? Cut.e() : Cut.c(next);
            }
            if (i == 2) {
                return this;
            }
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Cut<C> a(DiscreteDomain<C> discreteDomain) {
            C c = c(discreteDomain);
            return c != null ? Cut.c(c) : Cut.d();
        }

        @Override // com.google.common.collect.Cut
        void a(StringBuilder sb) {
            sb.append('(');
            sb.append(this.a);
        }

        @Override // com.google.common.collect.Cut
        boolean a(C c) {
            return Range.a(this.a, c) < 0;
        }

        @Override // com.google.common.collect.Cut
        BoundType b() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> b(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i = AnonymousClass1.a[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i != 2) {
                throw new AssertionError();
            }
            C next = discreteDomain.next(this.a);
            return next == null ? Cut.d() : Cut.c(next);
        }

        @Override // com.google.common.collect.Cut
        C b(DiscreteDomain<C> discreteDomain) {
            return this.a;
        }

        @Override // com.google.common.collect.Cut
        void b(StringBuilder sb) {
            sb.append(this.a);
            sb.append(']');
        }

        @Override // com.google.common.collect.Cut
        BoundType c() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        C c(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.next(this.a);
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.a.hashCode() ^ (-1);
        }

        public String toString() {
            return "/" + this.a + "\\";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class BelowAll extends Cut<Comparable<?>> {
        private static final BelowAll INSTANCE = new BelowAll();
        private static final long serialVersionUID = 0;

        private BelowAll() {
            super(null);
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> a(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> a(DiscreteDomain<Comparable<?>> discreteDomain) {
            try {
                return Cut.c(discreteDomain.minValue());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> a() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        void a(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        boolean a(Comparable<?> comparable) {
            return true;
        }

        @Override // com.google.common.collect.Cut
        BoundType b() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> b(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> b(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        void b(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        BoundType c() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> c(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.minValue();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : -1;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        public String toString() {
            return "-∞";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        BelowValue(C c) {
            super((Comparable) Preconditions.checkNotNull(c));
        }

        @Override // com.google.common.collect.Cut
        Cut<C> a(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i = AnonymousClass1.a[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i != 2) {
                throw new AssertionError();
            }
            C previous = discreteDomain.previous(this.a);
            return previous == null ? Cut.e() : new AboveValue(previous);
        }

        @Override // com.google.common.collect.Cut
        void a(StringBuilder sb) {
            sb.append('[');
            sb.append(this.a);
        }

        @Override // com.google.common.collect.Cut
        boolean a(C c) {
            return Range.a(this.a, c) <= 0;
        }

        @Override // com.google.common.collect.Cut
        BoundType b() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> b(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i = AnonymousClass1.a[boundType.ordinal()];
            if (i == 1) {
                C previous = discreteDomain.previous(this.a);
                return previous == null ? Cut.d() : new AboveValue(previous);
            }
            if (i == 2) {
                return this;
            }
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        C b(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.previous(this.a);
        }

        @Override // com.google.common.collect.Cut
        void b(StringBuilder sb) {
            sb.append(this.a);
            sb.append(')');
        }

        @Override // com.google.common.collect.Cut
        BoundType c() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        C c(DiscreteDomain<C> discreteDomain) {
            return this.a;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "\\" + this.a + "/";
        }
    }

    Cut(@NullableDecl C c) {
        this.a = c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> b(C c) {
        return new AboveValue(c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> c(C c) {
        return new BelowValue(c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> d() {
        return AboveAll.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> e() {
        return BelowAll.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Cut<C> a(BoundType boundType, DiscreteDomain<C> discreteDomain);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cut<C> a(DiscreteDomain<C> discreteDomain) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(StringBuilder sb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(C c);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Cut<C> b(BoundType boundType, DiscreteDomain<C> discreteDomain);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract C b(DiscreteDomain<C> discreteDomain);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(StringBuilder sb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract C c(DiscreteDomain<C> discreteDomain);

    @Override // java.lang.Comparable
    public int compareTo(Cut<C> cut) {
        if (cut == e()) {
            return 1;
        }
        if (cut == d()) {
            return -1;
        }
        int a = Range.a(this.a, cut.a);
        return a != 0 ? a : Booleans.compare(this instanceof AboveValue, cut instanceof AboveValue);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            return compareTo((Cut) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public abstract int hashCode();
}
