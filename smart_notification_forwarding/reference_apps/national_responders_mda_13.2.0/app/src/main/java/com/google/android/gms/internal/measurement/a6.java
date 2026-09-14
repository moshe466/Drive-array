package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class a6 {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f5176a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f5177b;

    static {
        f5177b = a("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return (f5176a == null || f5177b) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> c() {
        return f5176a;
    }
}
