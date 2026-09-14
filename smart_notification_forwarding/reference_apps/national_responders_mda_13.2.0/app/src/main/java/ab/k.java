package ab;

import l8.w;

/* loaded from: classes.dex */
public interface k {

    /* renamed from: a, reason: collision with root package name */
    public static final a f378a = a.f379a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f379a = new a();

        private a() {
        }

        public final d a(Runnable runnable, x8.l<? super InterruptedException, w> lVar) {
            return (runnable == null || lVar == null) ? new d(null, 1, null) : new c(runnable, lVar);
        }
    }

    void a();

    void b();
}
