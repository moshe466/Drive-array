package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.e;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements q0.a<Boolean> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends e.c {
        protected a(Context context) {
            super(new b(context));
            b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements e.g {

        /* renamed from: a, reason: collision with root package name */
        private final Context f2738a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends e.h {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ e.h f2739a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f2740b;

            a(b bVar, e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f2739a = hVar;
                this.f2740b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.e.h
            public void a(Throwable th) {
                try {
                    this.f2739a.a(th);
                } finally {
                    this.f2740b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.e.h
            public void b(m mVar) {
                try {
                    this.f2739a.b(mVar);
                } finally {
                    this.f2740b.shutdown();
                }
            }
        }

        b(Context context) {
            this.f2738a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.e.g
        public void a(final e.h hVar) {
            final ThreadPoolExecutor b10 = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            b10.execute(new Runnable() { // from class: androidx.emoji2.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    EmojiCompatInitializer.b.this.d(hVar, b10);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                j a10 = androidx.emoji2.text.c.a(this.f2738a);
                if (a10 == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                a10.c(threadPoolExecutor);
                a10.a().a(new a(this, hVar, threadPoolExecutor));
            } catch (Throwable th) {
                hVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.core.os.k.a("EmojiCompat.EmojiCompatInitializer.run");
                if (e.h()) {
                    e.b().k();
                }
            } finally {
                androidx.core.os.k.b();
            }
        }
    }

    @Override // q0.a
    public List<Class<? extends q0.a<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // q0.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return Boolean.FALSE;
        }
        e.g(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    void d(Context context) {
        final androidx.lifecycle.h b10 = ((androidx.lifecycle.l) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).b();
        b10.a(new androidx.lifecycle.c() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.e
            public void a(androidx.lifecycle.l lVar) {
                EmojiCompatInitializer.this.e();
                b10.c(this);
            }

            @Override // androidx.lifecycle.e
            public /* synthetic */ void b(androidx.lifecycle.l lVar) {
                androidx.lifecycle.b.b(this, lVar);
            }

            @Override // androidx.lifecycle.e
            public /* synthetic */ void c(androidx.lifecycle.l lVar) {
                androidx.lifecycle.b.a(this, lVar);
            }

            @Override // androidx.lifecycle.e
            public /* synthetic */ void e(androidx.lifecycle.l lVar) {
                androidx.lifecycle.b.c(this, lVar);
            }

            @Override // androidx.lifecycle.e
            public /* synthetic */ void f(androidx.lifecycle.l lVar) {
                androidx.lifecycle.b.d(this, lVar);
            }

            @Override // androidx.lifecycle.e
            public /* synthetic */ void g(androidx.lifecycle.l lVar) {
                androidx.lifecycle.b.e(this, lVar);
            }
        });
    }

    void e() {
        androidx.emoji2.text.b.d().postDelayed(new c(), 500L);
    }
}
