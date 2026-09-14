package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final ObservableSource<? extends TRight> b;
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> c;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> d;
    final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> e;

    /* loaded from: classes3.dex */
    static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, JoinSupport {
        static final Integer n = 1;
        static final Integer o = 2;
        static final Integer p = 3;
        static final Integer q = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        final Observer<? super R> a;
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> g;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> h;
        final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> i;
        int k;
        int l;
        volatile boolean m;
        final CompositeDisposable c = new CompositeDisposable();
        final SpscLinkedArrayQueue<Object> b = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        final Map<Integer, UnicastSubject<TRight>> d = new LinkedHashMap();
        final Map<Integer, TRight> e = new LinkedHashMap();
        final AtomicReference<Throwable> f = new AtomicReference<>();
        final AtomicInteger j = new AtomicInteger(2);

        GroupJoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
            this.a = observer;
            this.g = function;
            this.h = function2;
            this.i = biFunction;
        }

        void a() {
            this.c.dispose();
        }

        void a(Observer<?> observer) {
            Throwable terminate = ExceptionHelper.terminate(this.f);
            Iterator<UnicastSubject<TRight>> it = this.d.values().iterator();
            while (it.hasNext()) {
                it.next().onError(terminate);
            }
            this.d.clear();
            this.e.clear();
            observer.onError(terminate);
        }

        void a(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.throwIfFatal(th);
            ExceptionHelper.addThrowable(this.f, th);
            spscLinkedArrayQueue.clear();
            a();
            a(observer);
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.b;
            Observer<? super R> observer = this.a;
            int i = 1;
            while (!this.m) {
                if (this.f.get() != null) {
                    spscLinkedArrayQueue.clear();
                    a();
                    a(observer);
                    return;
                }
                boolean z = this.j.get() == 0;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<UnicastSubject<TRight>> it = this.d.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.d.clear();
                    this.e.clear();
                    this.c.dispose();
                    observer.onComplete();
                    return;
                }
                if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    Object poll = spscLinkedArrayQueue.poll();
                    if (num == n) {
                        UnicastSubject create = UnicastSubject.create();
                        int i2 = this.k;
                        this.k = i2 + 1;
                        this.d.put(Integer.valueOf(i2), create);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.g.apply(poll), "The leftEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i2);
                            this.c.add(leftRightEndObserver);
                            observableSource.subscribe(leftRightEndObserver);
                            if (this.f.get() != null) {
                                spscLinkedArrayQueue.clear();
                                a();
                                a(observer);
                                return;
                            } else {
                                try {
                                    observer.onNext((Object) ObjectHelper.requireNonNull(this.i.apply(poll, create), "The resultSelector returned a null value"));
                                    Iterator<TRight> it2 = this.e.values().iterator();
                                    while (it2.hasNext()) {
                                        create.onNext(it2.next());
                                    }
                                } catch (Throwable th) {
                                    a(th, observer, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            a(th2, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == o) {
                        int i3 = this.l;
                        this.l = i3 + 1;
                        this.e.put(Integer.valueOf(i3), poll);
                        try {
                            ObservableSource observableSource2 = (ObservableSource) ObjectHelper.requireNonNull(this.h.apply(poll), "The rightEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i3);
                            this.c.add(leftRightEndObserver2);
                            observableSource2.subscribe(leftRightEndObserver2);
                            if (this.f.get() != null) {
                                spscLinkedArrayQueue.clear();
                                a();
                                a(observer);
                                return;
                            } else {
                                Iterator<UnicastSubject<TRight>> it3 = this.d.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(poll);
                                }
                            }
                        } catch (Throwable th3) {
                            a(th3, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == p) {
                        LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) poll;
                        UnicastSubject<TRight> remove = this.d.remove(Integer.valueOf(leftRightEndObserver3.c));
                        this.c.remove(leftRightEndObserver3);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == q) {
                        LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) poll;
                        this.e.remove(Integer.valueOf(leftRightEndObserver4.c));
                        this.c.remove(leftRightEndObserver4);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.m) {
                return;
            }
            this.m = true;
            a();
            if (getAndIncrement() == 0) {
                this.b.clear();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.b.offer(z ? p : q, leftRightEndObserver);
            }
            b();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerCloseError(Throwable th) {
            if (ExceptionHelper.addThrowable(this.f, th)) {
                b();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerComplete(LeftRightObserver leftRightObserver) {
            this.c.delete(leftRightObserver);
            this.j.decrementAndGet();
            b();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerError(Throwable th) {
            if (!ExceptionHelper.addThrowable(this.f, th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.j.decrementAndGet();
                b();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.b.offer(z ? n : o, obj);
            }
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.m;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface JoinSupport {
        void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver);

        void innerCloseError(Throwable th);

        void innerComplete(LeftRightObserver leftRightObserver);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class LeftRightEndObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final JoinSupport a;
        final boolean b;
        final int c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LeftRightEndObserver(JoinSupport joinSupport, boolean z, int i) {
            this.a = joinSupport;
            this.b = z;
            this.c = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a.innerClose(this.b, this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.innerCloseError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.a.innerClose(this.b, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    /* loaded from: classes3.dex */
    static final class LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final JoinSupport a;
        final boolean b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LeftRightObserver(JoinSupport joinSupport, boolean z) {
            this.a = joinSupport;
            this.b = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a.innerComplete(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.innerError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            this.a.innerValue(this.b, obj);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableGroupJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
        super(observableSource);
        this.b = observableSource2;
        this.c = function;
        this.d = function2;
        this.e = biFunction;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(observer, this.c, this.d, this.e);
        observer.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.c.add(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.c.add(leftRightObserver2);
        this.a.subscribe(leftRightObserver);
        this.b.subscribe(leftRightObserver2);
    }
}
