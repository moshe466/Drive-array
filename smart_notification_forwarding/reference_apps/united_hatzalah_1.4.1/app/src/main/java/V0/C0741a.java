package v0;

import F0.G1;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;

/* renamed from: v0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0741a extends k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6617a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ G1 f6618b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0741a(G1 g12, int i) {
        super(0);
        this.f6617a = i;
        this.f6618b = g12;
    }

    @Override // F2.a
    public final Object invoke() {
        boolean z3;
        switch (this.f6617a) {
            case 0:
                Class<?> loadClass = ((ClassLoader) this.f6618b.f218b).loadClass("androidx.window.extensions.WindowExtensionsProvider");
                j.d(loadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
                return loadClass;
            default:
                G1 g12 = this.f6618b;
                Class<?> loadClass2 = ((ClassLoader) g12.f218b).loadClass("androidx.window.extensions.WindowExtensionsProvider");
                j.d(loadClass2, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
                Method getWindowExtensionsMethod = loadClass2.getDeclaredMethod("getWindowExtensions", null);
                Class<?> loadClass3 = ((ClassLoader) g12.f218b).loadClass("androidx.window.extensions.WindowExtensions");
                j.d(loadClass3, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
                j.d(getWindowExtensionsMethod, "getWindowExtensionsMethod");
                if (getWindowExtensionsMethod.getReturnType().equals(loadClass3) && Modifier.isPublic(getWindowExtensionsMethod.getModifiers())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                return Boolean.valueOf(z3);
        }
    }
}
