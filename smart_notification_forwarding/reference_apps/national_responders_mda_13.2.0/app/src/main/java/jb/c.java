package jb;

/* loaded from: classes.dex */
public final class c {
    public static final boolean a(Throwable th) {
        y8.k.e(th, "<this>");
        Class<?> cls = th.getClass();
        while (!y8.k.a(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException b(Throwable th) {
        y8.k.e(th, "e");
        throw th;
    }
}
