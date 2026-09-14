package bb;

import java.util.List;

/* loaded from: classes.dex */
public abstract class v extends g1 implements db.f {

    /* renamed from: g, reason: collision with root package name */
    private final i0 f4273g;

    /* renamed from: h, reason: collision with root package name */
    private final i0 f4274h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(i0 i0Var, i0 i0Var2) {
        super(null);
        y8.k.e(i0Var, "lowerBound");
        y8.k.e(i0Var2, "upperBound");
        this.f4273g = i0Var;
        this.f4274h = i0Var2;
    }

    @Override // bb.b0
    public ua.h A() {
        return d1().A();
    }

    @Override // bb.b0
    public List<v0> V0() {
        return d1().V0();
    }

    @Override // bb.b0
    public t0 W0() {
        return d1().W0();
    }

    @Override // bb.b0
    public boolean X0() {
        return d1().X0();
    }

    public abstract i0 d1();

    public final i0 e1() {
        return this.f4273g;
    }

    public final i0 f1() {
        return this.f4274h;
    }

    public abstract String g1(kotlin.reflect.jvm.internal.impl.renderer.c cVar, kotlin.reflect.jvm.internal.impl.renderer.f fVar);

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.c.f11500c.x(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return d1().u();
    }
}
