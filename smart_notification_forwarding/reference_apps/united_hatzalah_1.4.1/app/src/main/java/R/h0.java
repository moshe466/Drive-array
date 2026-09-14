package R;

import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class h0 extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public Y2.d f1886a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1887b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1888c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j0 f1889d;

    /* renamed from: e, reason: collision with root package name */
    public int f1890e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(j0 j0Var, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1889d = j0Var;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1888c = obj;
        this.f1890e |= Integer.MIN_VALUE;
        return this.f1889d.c(null, this);
    }
}
