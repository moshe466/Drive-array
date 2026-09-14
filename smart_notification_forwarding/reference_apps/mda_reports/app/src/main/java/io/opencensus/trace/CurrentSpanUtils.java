package io.opencensus.trace;

import io.grpc.Context;
import io.opencensus.common.Scope;
import io.opencensus.trace.unsafe.ContextUtils;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
final class CurrentSpanUtils {

    /* loaded from: classes2.dex */
    private static final class CallableInSpan<V> implements Callable<V> {
        private final Callable<V> callable;
        private final boolean endSpan;
        private final Span span;

        private CallableInSpan(Span span, Callable<V> callable, boolean z) {
            this.span = span;
            this.callable = callable;
            this.endSpan = z;
        }

        @Override // java.util.concurrent.Callable
        public V call() {
            Context attach = ContextUtils.withValue(Context.current(), this.span).attach();
            try {
                try {
                    try {
                        V call = this.callable.call();
                        Context.current().detach(attach);
                        if (this.endSpan) {
                            this.span.end();
                        }
                        return call;
                    } catch (Throwable th) {
                        CurrentSpanUtils.setErrorStatus(this.span, th);
                        if (th instanceof Error) {
                            throw th;
                        }
                        throw new RuntimeException("unexpected", th);
                    }
                } catch (Exception e) {
                    CurrentSpanUtils.setErrorStatus(this.span, e);
                    throw e;
                }
            } catch (Throwable th2) {
                Context.current().detach(attach);
                if (this.endSpan) {
                    this.span.end();
                }
                throw th2;
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class RunnableInSpan implements Runnable {
        private final boolean endSpan;
        private final Runnable runnable;
        private final Span span;

        private RunnableInSpan(Span span, Runnable runnable, boolean z) {
            this.span = span;
            this.runnable = runnable;
            this.endSpan = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context attach = ContextUtils.withValue(Context.current(), this.span).attach();
            try {
                this.runnable.run();
            } catch (Throwable th) {
                try {
                    CurrentSpanUtils.setErrorStatus(this.span, th);
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    if (!(th instanceof Error)) {
                        throw new RuntimeException("unexpected", th);
                    }
                    throw ((Error) th);
                } finally {
                    Context.current().detach(attach);
                    if (this.endSpan) {
                        this.span.end();
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class ScopeInSpan implements Scope {
        private final boolean endSpan;
        private final Context origContext;
        private final Span span;

        private ScopeInSpan(Span span, boolean z) {
            this.span = span;
            this.endSpan = z;
            this.origContext = ContextUtils.withValue(Context.current(), span).attach();
        }

        @Override // io.opencensus.common.Scope, io.opencensus.common.NonThrowingCloseable, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Context.current().detach(this.origContext);
            if (this.endSpan) {
                this.span.end();
            }
        }
    }

    private CurrentSpanUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Scope a(Span span, boolean z) {
        return new ScopeInSpan(span, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Span a() {
        return ContextUtils.getValue(Context.current());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(Span span, boolean z, Runnable runnable) {
        return new RunnableInSpan(span, runnable, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C> Callable<C> a(Span span, boolean z, Callable<C> callable) {
        return new CallableInSpan(span, callable, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setErrorStatus(Span span, Throwable th) {
        span.setStatus(Status.UNKNOWN.withDescription(th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage()));
    }
}
