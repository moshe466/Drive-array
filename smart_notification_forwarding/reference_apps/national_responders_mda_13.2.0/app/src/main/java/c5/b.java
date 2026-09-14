package c5;

import java.lang.reflect.AccessibleObject;
import z4.e;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f4390a;

    static {
        f4390a = e.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return f4390a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
