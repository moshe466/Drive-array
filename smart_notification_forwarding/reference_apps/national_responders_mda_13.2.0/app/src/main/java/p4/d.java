package p4;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p4.f;
import r3.q;
import r3.w;

/* loaded from: classes.dex */
public class d implements f {

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadFactory f13056b = c.a();

    /* renamed from: a, reason: collision with root package name */
    private r4.b<g> f13057a;

    private d(Context context, Set<e> set) {
        this(new w(a.a(context)), set, new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f13056b));
    }

    d(r4.b<g> bVar, Set<e> set, Executor executor) {
        this.f13057a = bVar;
    }

    public static r3.d<f> b() {
        return r3.d.a(f.class).b(q.i(Context.class)).b(q.j(e.class)).f(b.b()).d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ f c(r3.e eVar) {
        return new d((Context) eVar.a(Context.class), eVar.b(e.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Thread e(Runnable runnable) {
        return new Thread(runnable, "heartbeat-information-executor");
    }

    @Override // p4.f
    public f.a a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean d10 = this.f13057a.get().d(str, currentTimeMillis);
        boolean c10 = this.f13057a.get().c(currentTimeMillis);
        return (d10 && c10) ? f.a.COMBINED : c10 ? f.a.GLOBAL : d10 ? f.a.SDK : f.a.NONE;
    }
}
