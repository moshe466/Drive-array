package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Suppliers {

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> a;
        final long b;

        @NullableDecl
        volatile transient T c;
        volatile transient long d;

        ExpiringMemoizingSupplier(Supplier<T> supplier, long j, TimeUnit timeUnit) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
            this.b = timeUnit.toNanos(j);
            Preconditions.checkArgument(j > 0, "duration (%s %s) must be > 0", j, timeUnit);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            long j = this.d;
            long b = Platform.b();
            if (j == 0 || b - j >= 0) {
                synchronized (this) {
                    if (j == this.d) {
                        T t = this.a.get();
                        this.c = t;
                        long j2 = b + this.b;
                        if (j2 == 0) {
                            j2 = 1;
                        }
                        this.d = j2;
                        return t;
                    }
                }
            }
            return this.c;
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.a + ", " + this.b + ", NANOS)";
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> a;
        volatile transient boolean b;

        @NullableDecl
        transient T c;

        MemoizingSupplier(Supplier<T> supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            if (!this.b) {
                synchronized (this) {
                    if (!this.b) {
                        T t = this.a.get();
                        this.c = t;
                        this.b = true;
                        return t;
                    }
                }
            }
            return this.c;
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.b) {
                obj = "<supplier that returned " + this.c + ">";
            } else {
                obj = this.a;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {
        volatile Supplier<T> a;
        volatile boolean b;

        @NullableDecl
        T c;

        NonSerializableMemoizingSupplier(Supplier<T> supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            if (!this.b) {
                synchronized (this) {
                    if (!this.b) {
                        T t = this.a.get();
                        this.c = t;
                        this.b = true;
                        this.a = null;
                        return t;
                    }
                }
            }
            return this.c;
        }

        public String toString() {
            Object obj = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == null) {
                obj = "<supplier that returned " + this.c + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    private static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<? super F, T> a;
        final Supplier<F> b;

        SupplierComposition(Function<? super F, T> function, Supplier<F> supplier) {
            this.a = (Function) Preconditions.checkNotNull(function);
            this.b = (Supplier) Preconditions.checkNotNull(supplier);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof SupplierComposition)) {
                return false;
            }
            SupplierComposition supplierComposition = (SupplierComposition) obj;
            return this.a.equals(supplierComposition.a) && this.b.equals(supplierComposition.b);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.a.apply(this.b.get());
        }

        public int hashCode() {
            return Objects.hashCode(this.a, this.b);
        }

        public String toString() {
            return "Suppliers.compose(" + this.a + ", " + this.b + ")";
        }
    }

    /* loaded from: classes2.dex */
    private interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    /* loaded from: classes2.dex */
    private enum SupplierFunctionImpl implements SupplierFunction<Object> {
        INSTANCE;

        @Override // com.google.common.base.Function
        public Object apply(Supplier<Object> supplier) {
            return supplier.get();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    /* loaded from: classes2.dex */
    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;

        @NullableDecl
        final T a;

        SupplierOfInstance(@NullableDecl T t) {
            this.a = t;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return Objects.equal(this.a, ((SupplierOfInstance) obj).a);
            }
            return false;
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.a;
        }

        public int hashCode() {
            return Objects.hashCode(this.a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.a + ")";
        }
    }

    /* loaded from: classes2.dex */
    private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> a;

        ThreadSafeSupplier(Supplier<T> supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            T t;
            synchronized (this.a) {
                t = this.a.get();
            }
            return t;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.a + ")";
        }
    }

    private Suppliers() {
    }

    public static <F, T> Supplier<T> compose(Function<? super F, T> function, Supplier<F> supplier) {
        return new SupplierComposition(function, supplier);
    }

    public static <T> Supplier<T> memoize(Supplier<T> supplier) {
        return ((supplier instanceof NonSerializableMemoizingSupplier) || (supplier instanceof MemoizingSupplier)) ? supplier : supplier instanceof Serializable ? new MemoizingSupplier(supplier) : new NonSerializableMemoizingSupplier(supplier);
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> supplier, long j, TimeUnit timeUnit) {
        return new ExpiringMemoizingSupplier(supplier, j, timeUnit);
    }

    public static <T> Supplier<T> ofInstance(@NullableDecl T t) {
        return new SupplierOfInstance(t);
    }

    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return SupplierFunctionImpl.INSTANCE;
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> supplier) {
        return new ThreadSafeSupplier(supplier);
    }
}
