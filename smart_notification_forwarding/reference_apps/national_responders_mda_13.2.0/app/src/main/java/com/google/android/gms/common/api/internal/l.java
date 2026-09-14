package com.google.android.gms.common.api.internal;

import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class l<L> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f4893a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f4894b;

    /* renamed from: c, reason: collision with root package name */
    private volatile a f4895c;

    /* loaded from: classes.dex */
    public static final class a<L> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f4896a;

        /* renamed from: b, reason: collision with root package name */
        private final String f4897b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(L l10, String str) {
            this.f4896a = l10;
            this.f4897b = str;
        }

        public String a() {
            return this.f4897b + "@" + System.identityHashCode(this.f4896a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4896a == aVar.f4896a && this.f4897b.equals(aVar.f4897b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f4896a) * 31) + this.f4897b.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public interface b<L> {
        void a(L l10);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Looper looper, L l10, String str) {
        this.f4893a = new h2.a(looper);
        this.f4894b = b2.p.l(l10, "Listener must not be null");
        this.f4895c = new a(l10, b2.p.g(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Executor executor, L l10, String str) {
        this.f4893a = (Executor) b2.p.l(executor, "Executor must not be null");
        this.f4894b = b2.p.l(l10, "Listener must not be null");
        this.f4895c = new a(l10, b2.p.g(str));
    }

    public void a() {
        this.f4894b = null;
        this.f4895c = null;
    }

    public a<L> b() {
        return this.f4895c;
    }

    public void c(final b<? super L> bVar) {
        b2.p.l(bVar, "Notifier must not be null");
        this.f4893a.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.w1
            @Override // java.lang.Runnable
            public final void run() {
                l.this.d(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void d(b bVar) {
        Object obj = this.f4894b;
        if (obj == null) {
            bVar.b();
            return;
        }
        try {
            bVar.a(obj);
        } catch (RuntimeException e10) {
            bVar.b();
            throw e10;
        }
    }
}
