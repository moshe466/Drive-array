package U2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final List f2348a;

    static {
        try {
            Iterator it = Arrays.asList(new Q2.b()).iterator();
            kotlin.jvm.internal.j.e(it, "<this>");
            f2348a = M2.f.B(new M2.a(new D2.c(it, 2)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
