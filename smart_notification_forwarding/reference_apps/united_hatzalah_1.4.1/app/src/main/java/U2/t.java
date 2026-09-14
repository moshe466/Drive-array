package U2;

import a.AbstractC0228a;
import s2.C0681f;
import y2.AbstractC0785a;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2377a = 0;

    static {
        Object g3;
        Object g4;
        Exception exc = new Exception();
        String simpleName = AbstractC0228a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            g3 = AbstractC0785a.class.getCanonicalName();
        } catch (Throwable th) {
            g3 = AbstractC0228a.g(th);
        }
        if (C0681f.a(g3) != null) {
            g3 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            g4 = t.class.getCanonicalName();
        } catch (Throwable th2) {
            g4 = AbstractC0228a.g(th2);
        }
        if (C0681f.a(g4) != null) {
            g4 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
