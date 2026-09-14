package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class b7 {

    /* renamed from: a, reason: collision with root package name */
    private static final a7<?> f5194a = new c7();

    /* renamed from: b, reason: collision with root package name */
    private static final a7<?> f5195b = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a7<?> a() {
        return f5194a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a7<?> b() {
        a7<?> a7Var = f5195b;
        if (a7Var != null) {
            return a7Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static a7<?> c() {
        try {
            return (a7) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
