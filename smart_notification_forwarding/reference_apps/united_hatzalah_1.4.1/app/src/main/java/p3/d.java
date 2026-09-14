package p3;

import T.k;
import java.io.PrintStream;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5976a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f5977b;

    static {
        int i;
        String[] strArr = {"System.out", "stdout", "sysout"};
        String property = System.getProperty("slf4j.internal.report.stream");
        int i3 = 2;
        if (property != null && !property.isEmpty()) {
            for (int i4 = 0; i4 < 3; i4++) {
                if (strArr[i4].equalsIgnoreCase(property)) {
                    i = 2;
                    break;
                }
            }
        }
        i = 1;
        f5976a = i;
        String property2 = System.getProperty("slf4j.internal.verbosity");
        if (property2 != null && !property2.isEmpty()) {
            if (property2.equalsIgnoreCase("DEBUG")) {
                i3 = 1;
            } else if (property2.equalsIgnoreCase("ERROR")) {
                i3 = 4;
            } else if (property2.equalsIgnoreCase("WARN")) {
                i3 = 3;
            }
        }
        f5977b = i3;
    }

    public static final void a(String str, Throwable th) {
        b().println("SLF4J(E): " + str);
        b().println("SLF4J(E): Reported exception:");
        th.printStackTrace(b());
    }

    public static PrintStream b() {
        if (k.b(f5976a) != 1) {
            return System.err;
        }
        return System.out;
    }

    public static final void c(String str) {
        if (k.b(3) >= k.b(f5977b)) {
            b().println("SLF4J(W): " + str);
        }
    }
}
