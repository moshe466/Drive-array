package io.reactivex.observers;

import io.reactivex.Notification;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    protected long d;
    protected Thread e;
    protected boolean f;
    protected int g;
    protected int h;
    protected CharSequence i;
    protected boolean j;
    protected final List<T> b = new VolatileSizeArrayList();
    protected final List<Throwable> c = new VolatileSizeArrayList();
    protected final CountDownLatch a = new CountDownLatch(1);

    /* loaded from: classes3.dex */
    public enum TestWaitStrategy implements Runnable {
        SPIN { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.1
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
            }
        },
        YIELD { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.2
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.3
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(1);
            }
        },
        SLEEP_10MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.4
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(10);
            }
        },
        SLEEP_100MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.5
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(100);
            }
        },
        SLEEP_1000MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.6
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(1000);
            }
        };

        static void a(int i) {
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }

    public static String valueAndClass(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AssertionError a(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.a.getCount());
        sb.append(", ");
        sb.append("values = ");
        sb.append(this.b.size());
        sb.append(", ");
        sb.append("errors = ");
        sb.append(this.c.size());
        sb.append(", ");
        sb.append("completions = ");
        sb.append(this.d);
        if (this.j) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.i;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.c.isEmpty()) {
            assertionError.initCause(this.c.size() == 1 ? this.c.get(0) : new CompositeException(this.c));
        }
        return assertionError;
    }

    public final U assertComplete() {
        long j = this.d;
        if (j == 0) {
            throw a("Not completed");
        }
        if (j <= 1) {
            return this;
        }
        throw a("Multiple completions: " + j);
    }

    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U assertError(Predicate<Throwable> predicate) {
        int size = this.c.size();
        if (size == 0) {
            throw a("No errors");
        }
        boolean z = false;
        Iterator<Throwable> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            try {
                if (predicate.test(it.next())) {
                    z = true;
                    break;
                }
            } catch (Exception e) {
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        if (!z) {
            throw a("Error not present");
        }
        if (size == 1) {
            return this;
        }
        throw a("Error present but other errors as well");
    }

    public final U assertError(Class<? extends Throwable> cls) {
        return assertError(Functions.isInstanceOf(cls));
    }

    public final U assertError(Throwable th) {
        return assertError(Functions.equalsWith(th));
    }

    public final U assertErrorMessage(String str) {
        int size = this.c.size();
        if (size == 0) {
            throw a("No errors");
        }
        if (size != 1) {
            throw a("Multiple errors");
        }
        String message = this.c.get(0).getMessage();
        if (ObjectHelper.equals(str, message)) {
            return this;
        }
        throw a("Error message differs; Expected: " + str + ", Actual: " + message);
    }

    public final U assertFailure(Predicate<Throwable> predicate, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(predicate).assertNotComplete();
    }

    public final U assertFailure(Class<? extends Throwable> cls, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertErrorMessage(str).assertNotComplete();
    }

    public final U assertNever(Predicate<? super T> predicate) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            try {
                if (predicate.test(this.b.get(i))) {
                    throw a("Value at position " + i + " matches predicate " + predicate.toString() + ", which was not expected.");
                }
            } catch (Exception e) {
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        return this;
    }

    public final U assertNever(T t) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (ObjectHelper.equals(this.b.get(i), t)) {
                throw a("Value at position " + i + " is equal to " + valueAndClass(t) + "; Expected them to be different");
            }
        }
        return this;
    }

    public final U assertNoErrors() {
        if (this.c.size() == 0) {
            return this;
        }
        throw a("Error(s) present: " + this.c);
    }

    public final U assertNoTimeout() {
        if (this.j) {
            throw a("Timeout?!");
        }
        return this;
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    public final U assertNotComplete() {
        long j = this.d;
        if (j == 1) {
            throw a("Completed!");
        }
        if (j <= 1) {
            return this;
        }
        throw a("Multiple completions: " + j);
    }

    public abstract U assertNotSubscribed();

    public final U assertNotTerminated() {
        if (this.a.getCount() != 0) {
            return this;
        }
        throw a("Subscriber terminated!");
    }

    public final U assertResult(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    public abstract U assertSubscribed();

    public final U assertTerminated() {
        if (this.a.getCount() != 0) {
            throw a("Subscriber still running!");
        }
        long j = this.d;
        if (j > 1) {
            throw a("Terminated with multiple completions: " + j);
        }
        int size = this.c.size();
        if (size > 1) {
            throw a("Terminated with multiple errors: " + size);
        }
        if (j == 0 || size == 0) {
            return this;
        }
        throw a("Terminated with multiple completions and errors: " + j);
    }

    public final U assertTimeout() {
        if (this.j) {
            return this;
        }
        throw a("No timeout?!");
    }

    public final U assertValue(Predicate<T> predicate) {
        assertValueAt(0, (Predicate) predicate);
        if (this.b.size() <= 1) {
            return this;
        }
        throw a("Value present but other values as well");
    }

    public final U assertValue(T t) {
        if (this.b.size() != 1) {
            throw a("Expected: " + valueAndClass(t) + ", Actual: " + this.b);
        }
        T t2 = this.b.get(0);
        if (ObjectHelper.equals(t, t2)) {
            return this;
        }
        throw a("Expected: " + valueAndClass(t) + ", Actual: " + valueAndClass(t2));
    }

    public final U assertValueAt(int i, Predicate<T> predicate) {
        if (this.b.size() == 0) {
            throw a("No values");
        }
        if (i >= this.b.size()) {
            throw a("Invalid index: " + i);
        }
        try {
            if (predicate.test(this.b.get(i))) {
                return this;
            }
            throw a("Value not present");
        } catch (Exception e) {
            throw ExceptionHelper.wrapOrThrow(e);
        }
    }

    @Experimental
    public final U assertValueAt(int i, T t) {
        int size = this.b.size();
        if (size == 0) {
            throw a("No values");
        }
        if (i >= size) {
            throw a("Invalid index: " + i);
        }
        T t2 = this.b.get(i);
        if (ObjectHelper.equals(t, t2)) {
            return this;
        }
        throw a("Expected: " + valueAndClass(t) + ", Actual: " + valueAndClass(t2));
    }

    public final U assertValueCount(int i) {
        int size = this.b.size();
        if (size == i) {
            return this;
        }
        throw a("Value counts differ; Expected: " + i + ", Actual: " + size);
    }

    public final U assertValueSequence(Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it = this.b.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        int i = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (!hasNext2 || !hasNext) {
                break;
            }
            T next = it2.next();
            T next2 = it.next();
            if (!ObjectHelper.equals(next, next2)) {
                throw a("Values at position " + i + " differ; Expected: " + valueAndClass(next) + ", Actual: " + valueAndClass(next2));
            }
            i++;
        }
        if (hasNext2) {
            throw a("More values received than expected (" + i + ")");
        }
        if (!hasNext) {
            return this;
        }
        throw a("Fewer values received than expected (" + i + ")");
    }

    @Experimental
    public final U assertValueSequenceOnly(Iterable<? extends T> iterable) {
        return (U) assertSubscribed().assertValueSequence(iterable).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSet(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            assertNoValues();
            return this;
        }
        for (T t : this.b) {
            if (!collection.contains(t)) {
                throw a("Value not in the expected collection: " + valueAndClass(t));
            }
        }
        return this;
    }

    @Experimental
    public final U assertValueSetOnly(Collection<? extends T> collection) {
        return (U) assertSubscribed().assertValueSet(collection).assertNoErrors().assertNotComplete();
    }

    public final U assertValues(T... tArr) {
        int size = this.b.size();
        if (size != tArr.length) {
            throw a("Value count differs; Expected: " + tArr.length + " " + Arrays.toString(tArr) + ", Actual: " + size + " " + this.b);
        }
        for (int i = 0; i < size; i++) {
            T t = this.b.get(i);
            T t2 = tArr[i];
            if (!ObjectHelper.equals(t2, t)) {
                throw a("Values at position " + i + " differ; Expected: " + valueAndClass(t2) + ", Actual: " + valueAndClass(t));
            }
        }
        return this;
    }

    @Experimental
    public final U assertValuesOnly(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    public final U await() {
        if (this.a.getCount() == 0) {
            return this;
        }
        this.a.await();
        return this;
    }

    public final boolean await(long j, TimeUnit timeUnit) {
        boolean z = this.a.getCount() == 0 || this.a.await(j, timeUnit);
        this.j = !z;
        return z;
    }

    public final U awaitCount(int i) {
        return awaitCount(i, TestWaitStrategy.SLEEP_10MS, 5000L);
    }

    public final U awaitCount(int i, Runnable runnable) {
        return awaitCount(i, runnable, 5000L);
    }

    public final U awaitCount(int i, Runnable runnable, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (j > 0 && System.currentTimeMillis() - currentTimeMillis >= j) {
                this.j = true;
                break;
            }
            if (this.a.getCount() == 0 || this.b.size() >= i) {
                break;
            }
            runnable.run();
        }
        return this;
    }

    public final U awaitDone(long j, TimeUnit timeUnit) {
        try {
            if (!this.a.await(j, timeUnit)) {
                this.j = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e);
        }
    }

    public final boolean awaitTerminalEvent() {
        try {
            await();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final boolean awaitTerminalEvent(long j, TimeUnit timeUnit) {
        try {
            return await(j, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U clearTimeout() {
        this.j = false;
        return this;
    }

    public final long completions() {
        return this.d;
    }

    public final int errorCount() {
        return this.c.size();
    }

    public final List<Throwable> errors() {
        return this.c;
    }

    public final List<List<Object>> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(values());
        arrayList.add(errors());
        ArrayList arrayList2 = new ArrayList();
        for (long j = 0; j < this.d; j++) {
            arrayList2.add(Notification.createOnComplete());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean isTerminated() {
        return this.a.getCount() == 0;
    }

    public final boolean isTimeout() {
        return this.j;
    }

    public final Thread lastThread() {
        return this.e;
    }

    public final int valueCount() {
        return this.b.size();
    }

    public final List<T> values() {
        return this.b;
    }

    public final U withTag(CharSequence charSequence) {
        this.i = charSequence;
        return this;
    }
}
