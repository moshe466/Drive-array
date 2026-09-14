package bb;

import java.util.List;

/* loaded from: classes.dex */
public abstract class b0 implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.a, db.h {

    /* renamed from: f, reason: collision with root package name */
    private int f4163f;

    private b0() {
    }

    public /* synthetic */ b0(y8.g gVar) {
        this();
    }

    private final int U0() {
        return d0.a(this) ? super.hashCode() : (((W0().hashCode() * 31) + V0().hashCode()) * 31) + (X0() ? 1 : 0);
    }

    public abstract ua.h A();

    public abstract List<v0> V0();

    public abstract t0 W0();

    public abstract boolean X0();

    public abstract b0 Y0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    public abstract g1 Z0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return X0() == b0Var.X0() && kotlin.reflect.jvm.internal.impl.types.checker.q.f11592a.a(Z0(), b0Var.Z0());
    }

    public final int hashCode() {
        int i10 = this.f4163f;
        if (i10 != 0) {
            return i10;
        }
        int U0 = U0();
        this.f4163f = U0;
        return U0;
    }
}
