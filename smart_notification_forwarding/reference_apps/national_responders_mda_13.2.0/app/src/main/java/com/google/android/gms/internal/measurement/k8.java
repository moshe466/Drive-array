package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k8 implements o9 {

    /* renamed from: b, reason: collision with root package name */
    private static final v8 f5428b = new n8();

    /* renamed from: a, reason: collision with root package name */
    private final v8 f5429a;

    public k8() {
        this(new m8(m7.c(), b()));
    }

    private k8(v8 v8Var) {
        this.f5429a = (v8) o7.f(v8Var, "messageInfoFactory");
    }

    private static v8 b() {
        try {
            return (v8) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f5428b;
        }
    }

    private static boolean c(w8 w8Var) {
        return w8Var.zza() == i9.f5388a;
    }

    @Override // com.google.android.gms.internal.measurement.o9
    public final <T> p9<T> a(Class<T> cls) {
        r9.p(cls);
        w8 b10 = this.f5429a.b(cls);
        if (b10.a()) {
            return l7.class.isAssignableFrom(cls) ? d9.i(r9.B(), b7.a(), b10.b()) : d9.i(r9.f(), b7.b(), b10.b());
        }
        if (!l7.class.isAssignableFrom(cls)) {
            boolean c10 = c(b10);
            f9 a10 = h9.a();
            h8 a11 = h8.a();
            return c10 ? b9.o(cls, b10, a10, a11, r9.f(), b7.b(), t8.a()) : b9.o(cls, b10, a10, a11, r9.v(), null, t8.a());
        }
        boolean c11 = c(b10);
        f9 b11 = h9.b();
        h8 c12 = h8.c();
        ha<?, ?> B = r9.B();
        return c11 ? b9.o(cls, b10, b11, c12, B, b7.a(), t8.b()) : b9.o(cls, b10, b11, c12, B, null, t8.b());
    }
}
