package V;

import F0.AbstractC0008a;
import F0.C0092v0;
import F0.Q2;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class r implements j {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2419a;

    /* renamed from: b, reason: collision with root package name */
    public final G.d f2420b;

    /* renamed from: c, reason: collision with root package name */
    public final A.n f2421c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2422d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public Handler f2423e;

    /* renamed from: f, reason: collision with root package name */
    public ThreadPoolExecutor f2424f;

    /* renamed from: g, reason: collision with root package name */
    public ThreadPoolExecutor f2425g;

    /* renamed from: h, reason: collision with root package name */
    public p3.h f2426h;

    public r(Context context, G.d dVar) {
        I.d.c(context, "Context cannot be null");
        this.f2419a = context.getApplicationContext();
        this.f2420b = dVar;
        this.f2421c = s.f2427d;
    }

    @Override // V.j
    public final void a(p3.h hVar) {
        synchronized (this.f2422d) {
            this.f2426h = hVar;
        }
        synchronized (this.f2422d) {
            try {
                if (this.f2426h == null) {
                    return;
                }
                if (this.f2424f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f2425g = threadPoolExecutor;
                    this.f2424f = threadPoolExecutor;
                }
                this.f2424f.execute(new Q2(this, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f2422d) {
            try {
                this.f2426h = null;
                Handler handler = this.f2423e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f2423e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f2425g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f2424f = null;
                this.f2425g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final G.i c() {
        try {
            A.n nVar = this.f2421c;
            Context context = this.f2419a;
            G.d dVar = this.f2420b;
            nVar.getClass();
            Object[] objArr = {dVar};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            C0092v0 a2 = G.c.a(context, Collections.unmodifiableList(arrayList));
            int i = a2.f692a;
            if (i == 0) {
                G.i[] iVarArr = (G.i[]) ((List) a2.f693b).get(0);
                if (iVarArr != null && iVarArr.length != 0) {
                    return iVarArr[0];
                }
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            throw new RuntimeException(AbstractC0008a.j(i, "fetchFonts failed (", ")"));
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException("provider not found", e4);
        }
    }
}
