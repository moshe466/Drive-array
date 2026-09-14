package R;

import y2.AbstractC0787c;

/* renamed from: R.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0184i extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public K1.m f1891a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1892b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ K1.m f1893c;

    /* renamed from: d, reason: collision with root package name */
    public int f1894d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0184i(K1.m mVar, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1893c = mVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1892b = obj;
        this.f1894d |= Integer.MIN_VALUE;
        return this.f1893c.g(this);
    }
}
