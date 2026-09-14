package r8;

import java.lang.reflect.Field;
import y8.k;

/* loaded from: classes.dex */
public final class f {
    private static final void a(int i10, int i11) {
        if (i11 <= i10) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i10 + ", got " + i11 + ". Please update the Kotlin standard library.").toString());
    }

    private static final e b(a aVar) {
        return (e) aVar.getClass().getAnnotation(e.class);
    }

    private static final int c(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(a aVar) {
        String str;
        k.e(aVar, "<this>");
        e b10 = b(aVar);
        if (b10 == null) {
            return null;
        }
        a(1, b10.v());
        int c10 = c(aVar);
        int i10 = c10 < 0 ? -1 : b10.l()[c10];
        String b11 = h.f13796a.b(aVar);
        if (b11 == null) {
            str = b10.c();
        } else {
            str = b11 + '/' + b10.c();
        }
        return new StackTraceElement(str, b10.m(), b10.f(), i10);
    }
}
