package w0;

import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.jvm.internal.s;

/* renamed from: w0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0749e {
    static {
        s.a(AbstractC0749e.class).c();
    }

    public static int a() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
            return 0;
        }
    }
}
