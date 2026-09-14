package q1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13442a;

    /* renamed from: b, reason: collision with root package name */
    private final l1.b f13443b;

    /* renamed from: c, reason: collision with root package name */
    private final r1.c f13444c;

    /* renamed from: d, reason: collision with root package name */
    private final n f13445d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f13446e;

    /* renamed from: f, reason: collision with root package name */
    private final s1.b f13447f;

    /* renamed from: g, reason: collision with root package name */
    private final t1.a f13448g;

    public h(Context context, l1.b bVar, r1.c cVar, n nVar, Executor executor, s1.b bVar2, t1.a aVar) {
        this.f13442a = context;
        this.f13443b = bVar;
        this.f13444c = cVar;
        this.f13445d = nVar;
        this.f13446e = executor;
        this.f13447f = bVar2;
        this.f13448g = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object c(h hVar, com.google.android.datatransport.runtime.backends.e eVar, Iterable iterable, k1.m mVar, int i10) {
        if (eVar.c() == e.a.TRANSIENT_ERROR) {
            hVar.f13444c.P(iterable);
            hVar.f13445d.a(mVar, i10 + 1);
            return null;
        }
        hVar.f13444c.m(iterable);
        if (eVar.c() == e.a.OK) {
            hVar.f13444c.Y(mVar, hVar.f13448g.a() + eVar.b());
        }
        if (!hVar.f13444c.I(mVar)) {
            return null;
        }
        hVar.f13445d.a(mVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object d(h hVar, k1.m mVar, int i10) {
        hVar.f13445d.a(mVar, i10 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(h hVar, k1.m mVar, int i10, Runnable runnable) {
        try {
            try {
                s1.b bVar = hVar.f13447f;
                r1.c cVar = hVar.f13444c;
                cVar.getClass();
                bVar.c(f.a(cVar));
                if (hVar.a()) {
                    hVar.f(mVar, i10);
                } else {
                    hVar.f13447f.c(g.a(hVar, mVar, i10));
                }
            } catch (s1.a unused) {
                hVar.f13445d.a(mVar, i10 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f13442a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    void f(k1.m mVar, int i10) {
        com.google.android.datatransport.runtime.backends.e b10;
        l1.g a10 = this.f13443b.a(mVar.b());
        Iterable iterable = (Iterable) this.f13447f.c(d.a(this, mVar));
        if (iterable.iterator().hasNext()) {
            if (a10 == null) {
                n1.a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", mVar);
                b10 = com.google.android.datatransport.runtime.backends.e.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((r1.i) it.next()).b());
                }
                b10 = a10.b(com.google.android.datatransport.runtime.backends.d.a().b(arrayList).c(mVar.c()).a());
            }
            this.f13447f.c(e.a(this, b10, iterable, mVar, i10));
        }
    }

    public void g(k1.m mVar, int i10, Runnable runnable) {
        this.f13446e.execute(c.a(this, mVar, i10, runnable));
    }
}
