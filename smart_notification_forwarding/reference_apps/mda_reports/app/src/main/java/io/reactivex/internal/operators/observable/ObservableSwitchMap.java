package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> b;
    final int c;
    final boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final SwitchMapObserver<T, R> a;
        final long b;
        final int c;
        volatile SimpleQueue<R> d;
        volatile boolean e;

        SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j, int i) {
            this.a = switchMapObserver;
            this.b = j;
            this.c = i;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.b == this.a.j) {
                this.e = true;
                this.a.b();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.a(this, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r) {
            if (this.b == this.a.j) {
                if (r != null) {
                    this.d.offer(r);
                }
                this.a.b();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.d = queueDisposable;
                        this.e = true;
                        this.a.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.d = queueDisposable;
                        return;
                    }
                }
                this.d = new SpscLinkedArrayQueue(this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final SwitchMapInnerObserver<Object, Object> k = new SwitchMapInnerObserver<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final Observer<? super R> a;
        final Function<? super T, ? extends ObservableSource<? extends R>> b;
        final int c;
        final boolean d;
        volatile boolean f;
        volatile boolean g;
        Disposable h;
        volatile long j;
        final AtomicReference<SwitchMapInnerObserver<T, R>> i = new AtomicReference<>();
        final AtomicThrowable e = new AtomicThrowable();

        static {
            k.cancel();
        }

        SwitchMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = i;
            this.d = z;
        }

        void a() {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.i.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver3 = k;
            if (switchMapInnerObserver2 == switchMapInnerObserver3 || (switchMapInnerObserver = (SwitchMapInnerObserver) this.i.getAndSet(switchMapInnerObserver3)) == k || switchMapInnerObserver == null) {
                return;
            }
            switchMapInnerObserver.cancel();
        }

        void a(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.b != this.j || !this.e.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.d) {
                this.h.dispose();
            }
            switchMapInnerObserver.e = true;
            b();
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x00d4 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x000f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void b() {
            /*
                Method dump skipped, instructions count: 220
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.b():void");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.h.dispose();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f || !this.e.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.d) {
                a();
            }
            this.f = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j = this.j + 1;
            this.j = j;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.i.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.cancel();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The ObservableSource returned is null");
                SwitchMapInnerObserver<T, R> switchMapInnerObserver3 = new SwitchMapInnerObserver<>(this, j, this.c);
                do {
                    switchMapInnerObserver = this.i.get();
                    if (switchMapInnerObserver == k) {
                        return;
                    }
                } while (!this.i.compareAndSet(switchMapInnerObserver, switchMapInnerObserver3));
                observableSource.subscribe(switchMapInnerObserver3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
        super(observableSource);
        this.b = function;
        this.c = i;
        this.d = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.a, observer, this.b)) {
            return;
        }
        this.a.subscribe(new SwitchMapObserver(observer, this.b, this.c, this.d));
    }
}
