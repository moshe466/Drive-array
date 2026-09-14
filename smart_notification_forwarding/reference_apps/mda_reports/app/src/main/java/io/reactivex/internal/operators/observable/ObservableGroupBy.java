package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    final Function<? super T, ? extends K> b;
    final Function<? super T, ? extends V> c;
    final int d;
    final boolean e;

    /* loaded from: classes3.dex */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        static final Object i = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final Observer<? super GroupedObservable<K, V>> a;
        final Function<? super T, ? extends K> b;
        final Function<? super T, ? extends V> c;
        final int d;
        final boolean e;
        Disposable g;
        final AtomicBoolean h = new AtomicBoolean();
        final Map<Object, GroupedUnicast<K, V>> f = new ConcurrentHashMap();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = function2;
            this.d = i2;
            this.e = z;
            lazySet(1);
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) i;
            }
            this.f.remove(k);
            if (decrementAndGet() == 0) {
                this.g.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.h.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.g.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.h.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.f.values());
            this.f.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((GroupedUnicast) it.next()).onComplete();
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.f.values());
            this.f.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((GroupedUnicast) it.next()).onError(th);
            }
            this.a.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.util.Map<java.lang.Object, io.reactivex.internal.operators.observable.ObservableGroupBy$GroupedUnicast<K, V>>, java.util.Map] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v3, types: [io.reactivex.internal.operators.observable.ObservableGroupBy$GroupedUnicast] */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            try {
                K apply = this.b.apply(t);
                Object obj = apply != null ? apply : i;
                GroupedUnicast<K, V> groupedUnicast = this.f.get(obj);
                ?? r2 = groupedUnicast;
                if (groupedUnicast == false) {
                    if (this.h.get()) {
                        return;
                    }
                    Object createWith = GroupedUnicast.createWith(apply, this.d, this, this.e);
                    this.f.put(obj, createWith);
                    getAndIncrement();
                    this.a.onNext(createWith);
                    r2 = createWith;
                }
                r2.onNext(ObjectHelper.requireNonNull(this.c.apply(t), "The value supplied is null"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.g.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> b;

        protected GroupedUnicast(K k, State<T, K> state) {
            super(k);
            this.b = state;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k, int i, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new GroupedUnicast<>(k, new State(i, groupByObserver, k, z));
        }

        public void onComplete() {
            this.b.onComplete();
        }

        public void onError(Throwable th) {
            this.b.onError(th);
        }

        public void onNext(T t) {
            this.b.onNext(t);
        }

        @Override // io.reactivex.Observable
        protected void subscribeActual(Observer<? super T> observer) {
            this.b.subscribe(observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final K a;
        final SpscLinkedArrayQueue<T> b;
        final GroupByObserver<?, K, T> c;
        final boolean d;
        volatile boolean e;
        Throwable f;
        final AtomicBoolean g = new AtomicBoolean();
        final AtomicBoolean h = new AtomicBoolean();
        final AtomicReference<Observer<? super T>> i = new AtomicReference<>();

        State(int i, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.b = new SpscLinkedArrayQueue<>(i);
            this.c = groupByObserver;
            this.a = k;
            this.d = z;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.b;
            boolean z = this.d;
            Observer<? super T> observer = this.i.get();
            int i = 1;
            while (true) {
                if (observer != null) {
                    while (true) {
                        boolean z2 = this.e;
                        T poll = spscLinkedArrayQueue.poll();
                        boolean z3 = poll == null;
                        if (a(z2, z3, observer, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        } else {
                            observer.onNext(poll);
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (observer == null) {
                    observer = this.i.get();
                }
            }
        }

        boolean a(boolean z, boolean z2, Observer<? super T> observer, boolean z3) {
            if (this.g.get()) {
                this.b.clear();
                this.c.cancel(this.a);
                this.i.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.f;
                this.i.lazySet(null);
                if (th != null) {
                    observer.onError(th);
                } else {
                    observer.onComplete();
                }
                return true;
            }
            Throwable th2 = this.f;
            if (th2 != null) {
                this.b.clear();
                this.i.lazySet(null);
                observer.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.i.lazySet(null);
            observer.onComplete();
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.g.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.i.lazySet(null);
                this.c.cancel(this.a);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g.get();
        }

        public void onComplete() {
            this.e = true;
            a();
        }

        public void onError(Throwable th) {
            this.f = th;
            this.e = true;
            a();
        }

        public void onNext(T t) {
            this.b.offer(t);
            a();
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            if (!this.h.compareAndSet(false, true)) {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), observer);
                return;
            }
            observer.onSubscribe(this);
            this.i.lazySet(observer);
            if (this.g.get()) {
                this.i.lazySet(null);
            } else {
                a();
            }
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
        super(observableSource);
        this.b = function;
        this.c = function2;
        this.d = i;
        this.e = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.a.subscribe(new GroupByObserver(observer, this.b, this.c, this.d, this.e));
    }
}
