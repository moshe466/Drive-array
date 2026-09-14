package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;

    @LazyInit
    @MonotonicNonNullDecl
    private transient Converter<B, A> reverse;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> a;
        final Converter<B, C> b;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.a = converter;
            this.b = converter2;
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        A a(@NullableDecl C c) {
            return (A) this.a.a((Converter<A, B>) this.b.a((Converter<B, C>) c));
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        C b(@NullableDecl A a) {
            return (C) this.b.b(this.a.b(a));
        }

        @Override // com.google.common.base.Converter
        protected A c(C c) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected C d(A a) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            return this.a.equals(converterComposition.a) && this.b.equals(converterComposition.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return this.a + ".andThen(" + this.b + ")";
        }
    }

    /* loaded from: classes2.dex */
    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(function);
            this.backwardFunction = (Function) Preconditions.checkNotNull(function2);
        }

        @Override // com.google.common.base.Converter
        protected A c(B b) {
            return this.backwardFunction.apply(b);
        }

        @Override // com.google.common.base.Converter
        protected B d(A a) {
            return this.forwardFunction.apply(a);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }
    }

    /* loaded from: classes2.dex */
    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter a = new IdentityConverter();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return a;
        }

        @Override // com.google.common.base.Converter
        <S> Converter<T, S> a(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        @Override // com.google.common.base.Converter
        protected T c(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        protected T d(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    /* loaded from: classes2.dex */
    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> a;

        ReverseConverter(Converter<A, B> converter) {
            this.a = converter;
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        B a(@NullableDecl A a) {
            return this.a.b(a);
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        A b(@NullableDecl B b) {
            return this.a.a((Converter<A, B>) b);
        }

        @Override // com.google.common.base.Converter
        protected B c(A a) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected A d(B b) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.a.equals(((ReverseConverter) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() ^ (-1);
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.a;
        }

        public String toString() {
            return this.a + ".reverse()";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Converter() {
        this(true);
    }

    Converter(boolean z) {
        this.handleNullAutomatically = z;
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.a;
    }

    <C> Converter<A, C> a(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    @NullableDecl
    A a(@NullableDecl B b) {
        if (!this.handleNullAutomatically) {
            return c(b);
        }
        if (b == null) {
            return null;
        }
        return (A) Preconditions.checkNotNull(c(b));
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return a((Converter) converter);
    }

    @Override // com.google.common.base.Function
    @CanIgnoreReturnValue
    @NullableDecl
    @Deprecated
    public final B apply(@NullableDecl A a) {
        return convert(a);
    }

    @NullableDecl
    B b(@NullableDecl A a) {
        if (!this.handleNullAutomatically) {
            return d(a);
        }
        if (a == null) {
            return null;
        }
        return (B) Preconditions.checkNotNull(d(a));
    }

    @ForOverride
    protected abstract A c(B b);

    @CanIgnoreReturnValue
    @NullableDecl
    public final B convert(@NullableDecl A a) {
        return b(a);
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() { // from class: com.google.common.base.Converter.1
            @Override // java.lang.Iterable
            public Iterator<B> iterator() {
                return new Iterator<B>() { // from class: com.google.common.base.Converter.1.1
                    private final Iterator<? extends A> fromIterator;

                    {
                        this.fromIterator = iterable.iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.fromIterator.hasNext();
                    }

                    @Override // java.util.Iterator
                    public B next() {
                        return (B) Converter.this.convert(this.fromIterator.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.fromIterator.remove();
                    }
                };
            }
        };
    }

    @ForOverride
    protected abstract B d(A a);

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }
}
