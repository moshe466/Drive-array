package kc;

/* loaded from: classes.dex */
public final class h {
    public static final void a(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static final void b(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static boolean c(String str) {
        String d10 = d(str);
        if (d10 == null) {
            return false;
        }
        return d10.equalsIgnoreCase("true");
    }

    public static String d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
