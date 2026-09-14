package androidx.core.os;

import android.os.Build;
import android.os.Trace;

@Deprecated
/* loaded from: classes.dex */
public final class k {

    /* loaded from: classes.dex */
    static class a {
        static void a(String str) {
            Trace.beginSection(str);
        }

        static void b() {
            Trace.endSection();
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 18 || i10 >= 29) {
            return;
        }
        try {
            Trace.class.getField("TRACE_TAG_APP").getLong(null);
            Class cls = Long.TYPE;
            Trace.class.getMethod("isTagEnabled", cls);
            Class cls2 = Integer.TYPE;
            Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
            Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
            Trace.class.getMethod("traceCounter", cls, String.class, cls2);
        } catch (Exception unused) {
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            a.a(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            a.b();
        }
    }
}
