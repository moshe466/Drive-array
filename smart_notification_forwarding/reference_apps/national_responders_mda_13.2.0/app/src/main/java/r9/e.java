package r9;

/* loaded from: classes.dex */
public final class e {
    public static final Class<?> a(ClassLoader classLoader, String str) {
        y8.k.e(classLoader, "<this>");
        y8.k.e(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
