package z0;

import F0.C0035g2;
import F0.G1;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import v0.C0741a;
import w0.AbstractC0749e;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f6822a;

    /* renamed from: b, reason: collision with root package name */
    public final C0035g2 f6823b;

    /* renamed from: c, reason: collision with root package name */
    public final G1 f6824c;

    public e(ClassLoader classLoader, C0035g2 c0035g2) {
        this.f6822a = classLoader;
        this.f6823b = c0035g2;
        this.f6824c = new G1(classLoader, 25);
    }

    public final WindowLayoutComponent a() {
        G1 g12 = this.f6824c;
        g12.getClass();
        boolean z3 = false;
        try {
            new C0741a(g12, 0).invoke();
            if (T.b.R("WindowExtensionsProvider#getWindowExtensions is not valid", new C0741a(g12, 1)) && T.b.R("WindowExtensions#getWindowLayoutComponent is not valid", new d(this, 3)) && T.b.R("FoldingFeature class is not valid", new d(this, 0))) {
                int a2 = AbstractC0749e.a();
                if (a2 == 1) {
                    z3 = b();
                } else if (2 <= a2 && a2 <= Integer.MAX_VALUE && b()) {
                    if (T.b.R("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new d(this, 2))) {
                        z3 = true;
                    }
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        if (!z3) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused2) {
            return null;
        }
    }

    public final boolean b() {
        return T.b.R("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new d(this, 1));
    }
}
