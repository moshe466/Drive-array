package R;

import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class A extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public P f1735a;

    /* renamed from: b, reason: collision with root package name */
    public int f1736b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1737c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f1738d;

    /* renamed from: e, reason: collision with root package name */
    public int f1739e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(P p, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1738d = p;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1737c = obj;
        this.f1739e |= Integer.MIN_VALUE;
        return this.f1738d.h(this);
    }
}
