package S2;

import y2.AbstractC0787c;

/* renamed from: S2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0202b extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public R2.p f2161a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2162b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f2163c;

    /* renamed from: d, reason: collision with root package name */
    public int f2164d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0202b(c cVar, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f2163c = cVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f2162b = obj;
        this.f2164d |= Integer.MIN_VALUE;
        return this.f2163c.b(null, this);
    }
}
