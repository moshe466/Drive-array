package fb;

import bb.b0;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import n9.a1;
import y8.k;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final a1 f9686a;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f9687b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f9688c;

    public c(a1 a1Var, b0 b0Var, b0 b0Var2) {
        k.e(a1Var, "typeParameter");
        k.e(b0Var, "inProjection");
        k.e(b0Var2, "outProjection");
        this.f9686a = a1Var;
        this.f9687b = b0Var;
        this.f9688c = b0Var2;
    }

    public final b0 a() {
        return this.f9687b;
    }

    public final b0 b() {
        return this.f9688c;
    }

    public final a1 c() {
        return this.f9686a;
    }

    public final boolean d() {
        return f.f11565a.b(this.f9687b, this.f9688c);
    }
}
