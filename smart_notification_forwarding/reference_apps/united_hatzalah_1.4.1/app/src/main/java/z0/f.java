package z0;

import F0.C0035g2;
import androidx.window.extensions.layout.WindowLayoutComponent;
import w0.AbstractC0749e;

/* loaded from: classes.dex */
public final class f extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public static final f f6825a = new kotlin.jvm.internal.k(0);

    @Override // F2.a
    public final Object invoke() {
        e eVar;
        WindowLayoutComponent a2;
        try {
            ClassLoader loader = h.class.getClassLoader();
            int i = 21;
            if (loader != null) {
                eVar = new e(loader, new C0035g2(loader, i));
            } else {
                eVar = null;
            }
            if (eVar == null || (a2 = eVar.a()) == null) {
                return null;
            }
            kotlin.jvm.internal.j.d(loader, "loader");
            C0035g2 c0035g2 = new C0035g2(loader, i);
            int a4 = AbstractC0749e.a();
            if (a4 >= 2) {
                return new B0.d(a2);
            }
            if (a4 == 1) {
                return new B0.c(a2, c0035g2);
            }
            return new Object();
        } catch (Throwable unused) {
            g gVar = g.f6826a;
            return null;
        }
    }
}
