package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import bb.b0;
import bb.t;
import java.util.Map;
import n9.v0;

/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public static final class a {
        public static la.b a(c cVar) {
            y8.k.e(cVar, "this");
            n9.e f10 = ra.a.f(cVar);
            if (f10 == null) {
                return null;
            }
            if (t.r(f10)) {
                f10 = null;
            }
            if (f10 == null) {
                return null;
            }
            return ra.a.e(f10);
        }
    }

    Map<la.e, pa.g<?>> a();

    b0 b();

    la.b f();

    v0 k();
}
