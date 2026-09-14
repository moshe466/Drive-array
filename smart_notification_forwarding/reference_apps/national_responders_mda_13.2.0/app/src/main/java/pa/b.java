package pa;

import bb.b0;
import java.util.List;
import n9.d0;

/* loaded from: classes.dex */
public final class b extends g<List<? extends g<?>>> {

    /* renamed from: b, reason: collision with root package name */
    private final x8.l<d0, b0> f13325b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends g<?>> list, x8.l<? super d0, ? extends b0> lVar) {
        super(list);
        y8.k.e(list, "value");
        y8.k.e(lVar, "computeType");
        this.f13325b = lVar;
    }

    @Override // pa.g
    public b0 a(d0 d0Var) {
        y8.k.e(d0Var, "module");
        b0 h10 = this.f13325b.h(d0Var);
        if (!k9.h.b0(h10) && !k9.h.w0(h10)) {
            k9.h.K0(h10);
        }
        return h10;
    }
}
