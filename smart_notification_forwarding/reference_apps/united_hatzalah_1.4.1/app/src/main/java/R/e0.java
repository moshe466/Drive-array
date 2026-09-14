package R;

import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class e0 extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public K1.m f1866a;

    /* renamed from: b, reason: collision with root package name */
    public Y2.a f1867b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1868c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ K1.m f1869d;

    /* renamed from: e, reason: collision with root package name */
    public int f1870e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(K1.m mVar, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1869d = mVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1868c = obj;
        this.f1870e |= Integer.MIN_VALUE;
        return this.f1869d.p(this);
    }
}
