package com.squareup.okhttp;

import androidx.core.app.NotificationCompat;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.util.logging.Level;

/* loaded from: classes2.dex */
public class Call {
    volatile boolean a;
    Request b;
    HttpEngine c;
    private final OkHttpClient client;
    private boolean executed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        ApplicationInterceptorChain(int i, Request request, boolean z) {
            this.index = i;
            this.request = request;
            this.forWebSocket = z;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return null;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request) {
            if (this.index >= Call.this.client.interceptors().size()) {
                return Call.this.a(request, this.forWebSocket);
            }
            ApplicationInterceptorChain applicationInterceptorChain = new ApplicationInterceptorChain(this.index + 1, request, this.forWebSocket);
            Interceptor interceptor = Call.this.client.interceptors().get(this.index);
            Response intercept = interceptor.intercept(applicationInterceptorChain);
            if (intercept != null) {
                return intercept;
            }
            throw new NullPointerException("application interceptor " + interceptor + " returned null");
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.request;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        private AsyncCall(Callback callback, boolean z) {
            super("OkHttp %s", Call.this.b.urlString());
            this.responseCallback = callback;
            this.forWebSocket = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            Call.this.cancel();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Call b() {
            return Call.this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String c() {
            return Call.this.b.httpUrl().host();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Object d() {
            return Call.this.b.tag();
        }

        @Override // com.squareup.okhttp.internal.NamedRunnable
        protected void execute() {
            IOException e;
            Response responseWithInterceptorChain;
            boolean z = true;
            try {
                try {
                    responseWithInterceptorChain = Call.this.getResponseWithInterceptorChain(this.forWebSocket);
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (Call.this.a) {
                        this.responseCallback.onFailure(Call.this.b, new IOException("Canceled"));
                    } else {
                        this.responseCallback.onResponse(responseWithInterceptorChain);
                    }
                } catch (IOException e3) {
                    e = e3;
                    if (z) {
                        Internal.logger.log(Level.INFO, "Callback failure for " + Call.this.toLoggableString(), (Throwable) e);
                    } else {
                        this.responseCallback.onFailure(Call.this.c == null ? Call.this.b : Call.this.c.getRequest(), e);
                    }
                }
            } finally {
                Call.this.client.getDispatcher().b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Call(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient.a();
        this.b = request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response getResponseWithInterceptorChain(boolean z) {
        return new ApplicationInterceptorChain(0, this.b, z).proceed(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toLoggableString() {
        return (this.a ? "canceled call" : NotificationCompat.CATEGORY_CALL) + " to " + this.b.httpUrl().resolve("/...");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    com.squareup.okhttp.Response a(com.squareup.okhttp.Request r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.Call.a(com.squareup.okhttp.Request, boolean):com.squareup.okhttp.Response");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a() {
        return this.b.tag();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Callback callback, boolean z) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.getDispatcher().a(new AsyncCall(callback, z));
    }

    public void cancel() {
        this.a = true;
        HttpEngine httpEngine = this.c;
        if (httpEngine != null) {
            httpEngine.cancel();
        }
    }

    public void enqueue(Callback callback) {
        a(callback, false);
    }

    public Response execute() {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.getDispatcher().a(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain(false);
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.getDispatcher().b(this);
        }
    }

    public boolean isCanceled() {
        return this.a;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }
}
