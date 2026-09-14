package io.flutter.util;

import a.AbstractC0228a;
import android.os.Build;
import android.os.Trace;
import p0.AbstractC0599a;

/* loaded from: classes.dex */
public final class TraceSection implements AutoCloseable {
    private TraceSection(String str) {
        begin(str);
    }

    public static void begin(String str) {
        Trace.beginSection(AbstractC0228a.D(cropSectionName(str)));
    }

    public static void beginAsyncSection(String str, int i) {
        String cropSectionName = cropSectionName(str);
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0599a.a(AbstractC0228a.D(cropSectionName), i);
            return;
        }
        String D3 = AbstractC0228a.D(cropSectionName);
        try {
            if (AbstractC0228a.f2738g == null) {
                AbstractC0228a.f2738g = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            AbstractC0228a.f2738g.invoke(null, Long.valueOf(AbstractC0228a.f2736e), D3, Integer.valueOf(i));
        } catch (Exception e4) {
            AbstractC0228a.w(e4);
        }
    }

    private static String cropSectionName(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void end() {
        Trace.endSection();
    }

    public static void endAsyncSection(String str, int i) {
        String cropSectionName = cropSectionName(str);
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0599a.b(AbstractC0228a.D(cropSectionName), i);
            return;
        }
        String D3 = AbstractC0228a.D(cropSectionName);
        try {
            if (AbstractC0228a.f2739h == null) {
                AbstractC0228a.f2739h = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            AbstractC0228a.f2739h.invoke(null, Long.valueOf(AbstractC0228a.f2736e), D3, Integer.valueOf(i));
        } catch (Exception e4) {
            AbstractC0228a.w(e4);
        }
    }

    public static TraceSection scoped(String str) {
        return new TraceSection(str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end();
    }
}
