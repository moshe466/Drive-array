package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends AbstractFuture.TrustedFuture<V> implements Runnable {

    @NullableDecl
    ListenableFuture<? extends V> a;

    @NullableDecl
    Class<X> b;

    @NullableDecl
    F c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        /* JADX WARN: Multi-variable type inference failed */
        ListenableFuture<? extends V> a(AsyncFunction<? super X, ? extends V> asyncFunction, X x) {
            ListenableFuture<? extends V> apply = asyncFunction.apply(x);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
            return apply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* bridge */ /* synthetic */ Object a(Object obj, Throwable th) {
            return a((AsyncFunction<? super AsyncFunction<? super X, ? extends V>, ? extends V>) obj, (AsyncFunction<? super X, ? extends V>) th);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        V a(Function<? super X, ? extends V> function, X x) {
            return function.apply(x);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        @NullableDecl
        /* bridge */ /* synthetic */ Object a(Object obj, Throwable th) {
            return a((Function<? super Function<? super X, ? extends V>, ? extends V>) obj, (Function<? super X, ? extends V>) th);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        void a(@NullableDecl V v) {
            set(v);
        }
    }

    AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f) {
        this.a = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.b = (Class) Preconditions.checkNotNull(cls);
        this.c = (F) Preconditions.checkNotNull(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V, X extends Throwable> ListenableFuture<V> a(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        listenableFuture.addListener(catchingFuture, MoreExecutors.a(executor, catchingFuture));
        return catchingFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <X extends Throwable, V> ListenableFuture<V> a(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.a(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    @NullableDecl
    @ForOverride
    abstract T a(F f, X x);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void a() {
        a((Future<?>) this.a);
        this.a = null;
        this.b = null;
        this.c = null;
    }

    @ForOverride
    abstract void a(@NullableDecl T t);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String c() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.a;
        Class<X> cls = this.b;
        F f = this.c;
        String c = super.c();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls == null || f == null) {
            if (c == null) {
                return null;
            }
            return str + c;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + f + "]";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class<X extends java.lang.Throwable>, F] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r7 = this;
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r7.a
            java.lang.Class<X extends java.lang.Throwable> r1 = r7.b
            F r2 = r7.c
            r3 = 1
            r4 = 0
            if (r0 != 0) goto Lc
            r5 = 1
            goto Ld
        Lc:
            r5 = 0
        Ld:
            if (r1 != 0) goto L11
            r6 = 1
            goto L12
        L11:
            r6 = 0
        L12:
            r5 = r5 | r6
            if (r2 != 0) goto L16
            goto L17
        L16:
            r3 = 0
        L17:
            r3 = r3 | r5
            boolean r4 = r7.isCancelled()
            r3 = r3 | r4
            if (r3 == 0) goto L20
            return
        L20:
            r3 = 0
            r7.a = r3
            java.lang.Object r0 = com.google.common.util.concurrent.Futures.getDone(r0)     // Catch: java.lang.Throwable -> L2a java.util.concurrent.ExecutionException -> L2c
            r4 = r0
            r0 = r3
            goto L38
        L2a:
            r0 = move-exception
            goto L37
        L2c:
            r0 = move-exception
            java.lang.Throwable r0 = r0.getCause()
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
        L37:
            r4 = r3
        L38:
            if (r0 != 0) goto L3e
            r7.set(r4)
            return
        L3e:
            boolean r1 = com.google.common.util.concurrent.Platform.a(r0, r1)
            if (r1 != 0) goto L48
            r7.setException(r0)
            return
        L48:
            java.lang.Object r0 = r7.a(r2, r0)     // Catch: java.lang.Throwable -> L54
            r7.b = r3
            r7.c = r3
            r7.a(r0)
            return
        L54:
            r0 = move-exception
            r7.setException(r0)     // Catch: java.lang.Throwable -> L5d
            r7.b = r3
            r7.c = r3
            return
        L5d:
            r0 = move-exception
            r7.b = r3
            r7.c = r3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractCatchingFuture.run():void");
    }
}
