package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class h9 {

    /* renamed from: a, reason: collision with root package name */
    private static final f9 f5374a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final f9 f5375b = new e9();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f9 a() {
        return f5374a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f9 b() {
        return f5375b;
    }

    private static f9 c() {
        try {
            return (f9) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
