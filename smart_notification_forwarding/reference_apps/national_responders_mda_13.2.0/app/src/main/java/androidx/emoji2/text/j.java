package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.g;
import androidx.emoji2.text.e;
import androidx.emoji2.text.j;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class j extends e.c {

    /* renamed from: j, reason: collision with root package name */
    private static final a f2800j = new a();

    /* loaded from: classes.dex */
    public static class a {
        public Typeface a(Context context, g.b bVar) {
            return androidx.core.provider.g.a(context, null, new g.b[]{bVar});
        }

        public g.a b(Context context, androidx.core.provider.e eVar) {
            return androidx.core.provider.g.b(context, null, eVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements e.g {

        /* renamed from: a, reason: collision with root package name */
        private final Context f2801a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.provider.e f2802b;

        /* renamed from: c, reason: collision with root package name */
        private final a f2803c;

        /* renamed from: d, reason: collision with root package name */
        private final Object f2804d = new Object();

        /* renamed from: e, reason: collision with root package name */
        private Handler f2805e;

        /* renamed from: f, reason: collision with root package name */
        private Executor f2806f;

        /* renamed from: g, reason: collision with root package name */
        private ThreadPoolExecutor f2807g;

        /* renamed from: h, reason: collision with root package name */
        e.h f2808h;

        /* renamed from: i, reason: collision with root package name */
        private ContentObserver f2809i;

        /* renamed from: j, reason: collision with root package name */
        private Runnable f2810j;

        b(Context context, androidx.core.provider.e eVar, a aVar) {
            androidx.core.util.h.g(context, "Context cannot be null");
            androidx.core.util.h.g(eVar, "FontRequest cannot be null");
            this.f2801a = context.getApplicationContext();
            this.f2802b = eVar;
            this.f2803c = aVar;
        }

        private void b() {
            synchronized (this.f2804d) {
                this.f2808h = null;
                ContentObserver contentObserver = this.f2809i;
                if (contentObserver != null) {
                    this.f2803c.c(this.f2801a, contentObserver);
                    this.f2809i = null;
                }
                Handler handler = this.f2805e;
                if (handler != null) {
                    handler.removeCallbacks(this.f2810j);
                }
                this.f2805e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f2807g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f2806f = null;
                this.f2807g = null;
            }
        }

        private g.b e() {
            try {
                g.a b10 = this.f2803c.b(this.f2801a, this.f2802b);
                if (b10.c() == 0) {
                    g.b[] b11 = b10.b();
                    if (b11 == null || b11.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return b11[0];
                }
                throw new RuntimeException("fetchFonts failed (" + b10.c() + ")");
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        @Override // androidx.emoji2.text.e.g
        public void a(e.h hVar) {
            androidx.core.util.h.g(hVar, "LoaderCallback cannot be null");
            synchronized (this.f2804d) {
                this.f2808h = hVar;
            }
            d();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            synchronized (this.f2804d) {
                if (this.f2808h == null) {
                    return;
                }
                try {
                    g.b e10 = e();
                    int b10 = e10.b();
                    if (b10 == 2) {
                        synchronized (this.f2804d) {
                        }
                    }
                    if (b10 != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + b10 + ")");
                    }
                    try {
                        androidx.core.os.k.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        Typeface a10 = this.f2803c.a(this.f2801a, e10);
                        ByteBuffer f10 = androidx.core.graphics.l.f(this.f2801a, null, e10.d());
                        if (f10 == null || a10 == null) {
                            throw new RuntimeException("Unable to open file.");
                        }
                        m b11 = m.b(a10, f10);
                        androidx.core.os.k.b();
                        synchronized (this.f2804d) {
                            e.h hVar = this.f2808h;
                            if (hVar != null) {
                                hVar.b(b11);
                            }
                        }
                        b();
                    } catch (Throwable th) {
                        androidx.core.os.k.b();
                        throw th;
                    }
                } catch (Throwable th2) {
                    synchronized (this.f2804d) {
                        e.h hVar2 = this.f2808h;
                        if (hVar2 != null) {
                            hVar2.a(th2);
                        }
                        b();
                    }
                }
            }
        }

        void d() {
            synchronized (this.f2804d) {
                if (this.f2808h == null) {
                    return;
                }
                if (this.f2806f == null) {
                    ThreadPoolExecutor b10 = androidx.emoji2.text.b.b("emojiCompat");
                    this.f2807g = b10;
                    this.f2806f = b10;
                }
                this.f2806f.execute(new Runnable() { // from class: androidx.emoji2.text.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.b.this.c();
                    }
                });
            }
        }

        public void f(Executor executor) {
            synchronized (this.f2804d) {
                this.f2806f = executor;
            }
        }
    }

    public j(Context context, androidx.core.provider.e eVar) {
        super(new b(context, eVar, f2800j));
    }

    public j c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
