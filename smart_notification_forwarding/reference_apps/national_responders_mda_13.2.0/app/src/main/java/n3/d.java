package n3;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import n3.d;

/* loaded from: classes.dex */
final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class a<T> implements Spliterator<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Spliterator.OfInt f12184a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IntFunction f12185b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f12186c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f12187d;

        a(Spliterator.OfInt ofInt, IntFunction intFunction, int i10, Comparator comparator) {
            this.f12185b = intFunction;
            this.f12186c = i10;
            this.f12187d = comparator;
            this.f12184a = ofInt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(Consumer consumer, IntFunction intFunction, int i10) {
            consumer.accept(intFunction.apply(i10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(Consumer consumer, IntFunction intFunction, int i10) {
            consumer.accept(intFunction.apply(i10));
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f12186c | 16464;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f12184a.estimateSize();
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator.OfInt ofInt = this.f12184a;
            final IntFunction intFunction = this.f12185b;
            ofInt.forEachRemaining(new IntConsumer() { // from class: n3.c
                @Override // java.util.function.IntConsumer
                public final void accept(int i10) {
                    d.a.c(consumer, intFunction, i10);
                }
            });
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return this.f12187d;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            Spliterator.OfInt ofInt = this.f12184a;
            final IntFunction intFunction = this.f12185b;
            return ofInt.tryAdvance(new IntConsumer() { // from class: n3.b
                @Override // java.util.function.IntConsumer
                public final void accept(int i10) {
                    d.a.d(consumer, intFunction, i10);
                }
            });
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator.OfInt trySplit = this.f12184a.trySplit();
            if (trySplit == null) {
                return null;
            }
            return new a(trySplit, this.f12185b, this.f12186c, this.f12187d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Spliterator<T> a(int i10, int i11, IntFunction<T> intFunction) {
        return b(i10, i11, intFunction, null);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Spliterator$OfInt] */
    static <T> Spliterator<T> b(int i10, int i11, IntFunction<T> intFunction, Comparator<? super T> comparator) {
        if (comparator != null) {
            m3.d.d((i11 & 4) != 0);
        }
        return new a(IntStream.range(0, i10).spliterator(), intFunction, i11, comparator);
    }
}
