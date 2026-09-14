package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class t8 {

    /* renamed from: a, reason: collision with root package name */
    private static final r8 f5616a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final r8 f5617b = new u8();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r8 a() {
        return f5616a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r8 b() {
        return f5617b;
    }

    private static r8 c() {
        try {
            return (r8) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
