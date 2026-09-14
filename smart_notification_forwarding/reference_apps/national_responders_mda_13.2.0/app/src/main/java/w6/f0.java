package w6;

import java.util.concurrent.TimeUnit;
import w6.f0;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15143a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(long j10, x8.a aVar) {
            y8.k.e(aVar, "$handler");
            d0.a(j10);
            aVar.b();
        }

        public final void b(final long j10, final x8.a<l8.w> aVar) {
            y8.k.e(aVar, "handler");
            new Thread(new Runnable() { // from class: w6.e0
                @Override // java.lang.Runnable
                public final void run() {
                    f0.a.c(j10, aVar);
                }
            }).start();
        }

        public final void d(long j10, x8.a<l8.w> aVar) {
            y8.k.e(aVar, "handler");
            b(TimeUnit.MINUTES.toMillis(j10), aVar);
        }
    }

    public static final void a(long j10, x8.a<l8.w> aVar) {
        f15143a.d(j10, aVar);
    }
}
