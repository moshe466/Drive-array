package nb;

import java.util.concurrent.CancellationException;
import p8.f;

/* loaded from: classes.dex */
public interface a1 extends f.b {

    /* renamed from: d, reason: collision with root package name */
    public static final b f12361d = b.f12362f;

    /* loaded from: classes.dex */
    public static final class a {
        public static <R> R a(a1 a1Var, R r10, x8.p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) f.b.a.a(a1Var, r10, pVar);
        }

        public static <E extends f.b> E b(a1 a1Var, f.c<E> cVar) {
            return (E) f.b.a.b(a1Var, cVar);
        }

        public static /* synthetic */ n0 c(a1 a1Var, boolean z10, boolean z11, x8.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            return a1Var.v(z10, z11, lVar);
        }

        public static p8.f d(a1 a1Var, f.c<?> cVar) {
            return f.b.a.c(a1Var, cVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements f.c<a1> {

        /* renamed from: f, reason: collision with root package name */
        static final /* synthetic */ b f12362f = new b();

        private b() {
        }
    }

    CancellationException H();

    void N(CancellationException cancellationException);

    boolean d();

    n0 v(boolean z10, boolean z11, x8.l<? super Throwable, l8.w> lVar);
}
