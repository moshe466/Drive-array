package bb;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class i0 extends g1 implements db.i, db.j {
    public i0() {
        super(null);
    }

    /* renamed from: d1 */
    public abstract i0 a1(boolean z10);

    /* renamed from: e1 */
    public abstract i0 c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar);

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = u().iterator();
        while (it.hasNext()) {
            mb.o.b(sb2, "[", kotlin.reflect.jvm.internal.impl.renderer.c.t(kotlin.reflect.jvm.internal.impl.renderer.c.f11500c, it.next(), null, 2, null), "] ");
        }
        sb2.append(W0());
        if (!V0().isEmpty()) {
            m8.y.O(V0(), sb2, ", ", "<", ">", 0, null, null, 112, null);
        }
        if (X0()) {
            sb2.append("?");
        }
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
