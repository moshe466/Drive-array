package p2;

import java.io.PrintStream;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    static final i f13047a;

    static {
        i mVar;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e10) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e10.printStackTrace(System.err);
            }
            mVar = (num == null || num.intValue() < 19) ? !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new l() : new m() : new n();
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = m.class.getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 133);
            sb2.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb2.append(name);
            sb2.append("will be used. The error is: ");
            printStream.println(sb2.toString());
            th.printStackTrace(System.err);
            mVar = new m();
        }
        f13047a = mVar;
        if (num == null) {
            return;
        }
        num.intValue();
    }

    public static void a(Throwable th, Throwable th2) {
        f13047a.a(th, th2);
    }
}
