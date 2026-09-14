package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class RealCall implements Call {
    final OkHttpClient a;
    final RetryAndFollowUpInterceptor b;
    final AsyncTimeout c = new AsyncTimeout() { // from class: okhttp3.RealCall.1
        @Override // okio.AsyncTimeout
        protected void a() {
            RealCall.this.cancel();
        }
    };
    final Request d;
    final boolean e;

    @Nullable
    private EventListener eventListener;
    private boolean executed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class AsyncCall extends NamedRunnable {
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.b());
            this.responseCallback = callback;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RealCall a() {
            return RealCall.this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    RealCall.this.eventListener.callFailed(RealCall.this, interruptedIOException);
                    this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.a.dispatcher().b(this);
                }
            } catch (Throwable th) {
                RealCall.this.a.dispatcher().b(this);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String b() {
            return RealCall.this.d.url().host();
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            IOException e;
            Response a;
            RealCall.this.c.enter();
            boolean z = true;
            try {
                try {
                    a = RealCall.this.a();
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (RealCall.this.b.isCanceled()) {
                        this.responseCallback.onFailure(RealCall.this, new IOException("Canceled"));
                    } else {
                        this.responseCallback.onResponse(RealCall.this, a);
                    }
                } catch (IOException e3) {
                    e = e3;
                    IOException a2 = RealCall.this.a(e);
                    if (z) {
                        Platform.get().log(4, "Callback failure for " + RealCall.this.d(), a2);
                    } else {
                        RealCall.this.eventListener.callFailed(RealCall.this, a2);
                        this.responseCallback.onFailure(RealCall.this, a2);
                    }
                }
            } finally {
                RealCall.this.a.dispatcher().b(this);
            }
        }
    }

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.a = okHttpClient;
        this.d = request;
        this.e = z;
        this.b = new RetryAndFollowUpInterceptor(okHttpClient, z);
        this.c.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RealCall a(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    private void captureCallStackTrace() {
        this.b.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public IOException a(@Nullable IOException iOException) {
        if (!this.c.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    Response a() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a.interceptors());
        arrayList.add(this.b);
        arrayList.add(new BridgeInterceptor(this.a.cookieJar()));
        arrayList.add(new CacheInterceptor(this.a.a()));
        arrayList.add(new ConnectInterceptor(this.a));
        if (!this.e) {
            arrayList.addAll(this.a.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.e));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.d, this, this.eventListener, this.a.connectTimeoutMillis(), this.a.readTimeoutMillis(), this.a.writeTimeoutMillis()).proceed(this.d);
    }

    String b() {
        return this.d.url().redact();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamAllocation c() {
        return this.b.streamAllocation();
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.b.cancel();
    }

    @Override // okhttp3.Call
    public RealCall clone() {
        return a(this.a, this.d, this.e);
    }

    String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.e ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(b());
        return sb.toString();
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.a.dispatcher().a(new AsyncCall(callback));
    }

    @Override // okhttp3.Call
    public Response execute() {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.c.enter();
        this.eventListener.callStart(this);
        try {
            try {
                this.a.dispatcher().a(this);
                Response a = a();
                if (a != null) {
                    return a;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                IOException a2 = a(e);
                this.eventListener.callFailed(this, a2);
                throw a2;
            }
        } finally {
            this.a.dispatcher().b(this);
        }
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.b.isCanceled();
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.d;
    }

    @Override // okhttp3.Call
    public Timeout timeout() {
        return this.c;
    }
}
