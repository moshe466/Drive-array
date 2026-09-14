package la;

import y8.k;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final mb.f f11859a;

    static {
        new f();
        f11859a = new mb.f("[^\\p{L}\\p{Digit}]");
    }

    private f() {
    }

    public static final String a(String str) {
        k.e(str, "name");
        return f11859a.c(str, "_");
    }
}
