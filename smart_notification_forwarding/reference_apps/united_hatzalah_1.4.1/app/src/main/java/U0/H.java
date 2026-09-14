package u0;

import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* loaded from: classes.dex */
public abstract class H {

    /* renamed from: a, reason: collision with root package name */
    public static final I f6549a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [u0.I] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    static {
        ?? r12;
        try {
            r12 = new J((WebViewProviderFactoryBoundaryInterface) m3.b.d(WebViewProviderFactoryBoundaryInterface.class, E1.b.n()), 6);
        } catch (ClassNotFoundException unused) {
            r12 = new Object();
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
        f6549a = r12;
    }
}
