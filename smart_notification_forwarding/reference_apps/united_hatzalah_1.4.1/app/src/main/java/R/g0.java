package R;

import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class g0 extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public Object f1881a;

    /* renamed from: b, reason: collision with root package name */
    public Y2.d f1882b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1883c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j0 f1884d;

    /* renamed from: e, reason: collision with root package name */
    public int f1885e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(j0 j0Var, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1884d = j0Var;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1883c = obj;
        this.f1885e |= Integer.MIN_VALUE;
        return this.f1884d.b(null, this);
    }
}
