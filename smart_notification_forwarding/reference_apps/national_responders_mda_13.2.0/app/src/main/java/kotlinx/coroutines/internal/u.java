package kotlinx.coroutines.internal;

import java.util.List;
import nb.i1;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f11661a = true;

    private static final v a(Throwable th, String str) {
        if (f11661a) {
            return new v(th, str);
        }
        if (th != null) {
            throw th;
        }
        d();
        throw new l8.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ v b(Throwable th, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(i1 i1Var) {
        return i1Var.c0() instanceof v;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final i1 e(r rVar, List<? extends r> list) {
        try {
            return rVar.createDispatcher(list);
        } catch (Throwable th) {
            return a(th, rVar.hintOnError());
        }
    }
}
