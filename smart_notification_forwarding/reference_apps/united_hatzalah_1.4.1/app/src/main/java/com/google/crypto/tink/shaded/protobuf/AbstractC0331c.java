package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0331c {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f4086a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f4087b;

    static {
        Class<?> cls;
        boolean z3;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f4086a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        if (cls2 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        f4087b = z3;
    }

    public static boolean a() {
        if (f4086a != null && !f4087b) {
            return true;
        }
        return false;
    }
}
