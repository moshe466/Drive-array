package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.f;
import androidx.core.provider.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final g.c f2428a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f2429b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.core.provider.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0033a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ g.c f2430f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Typeface f2431g;

        RunnableC0033a(a aVar, g.c cVar, Typeface typeface) {
            this.f2430f = cVar;
            this.f2431g = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2430f.b(this.f2431g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ g.c f2432f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f2433g;

        b(a aVar, g.c cVar, int i10) {
            this.f2432f = cVar;
            this.f2433g = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2432f.a(this.f2433g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(g.c cVar, Handler handler) {
        this.f2428a = cVar;
        this.f2429b = handler;
    }

    private void a(int i10) {
        this.f2429b.post(new b(this, this.f2428a, i10));
    }

    private void c(Typeface typeface) {
        this.f2429b.post(new RunnableC0033a(this, this.f2428a, typeface));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f2456a);
        } else {
            a(eVar.f2457b);
        }
    }
}
