package R;

import y2.AbstractC0787c;

/* renamed from: R.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0196v extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public P f1946a;

    /* renamed from: b, reason: collision with root package name */
    public Y2.d f1947b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1948c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f1949d;

    /* renamed from: e, reason: collision with root package name */
    public int f1950e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0196v(P p, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1949d = p;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1948c = obj;
        this.f1950e |= Integer.MIN_VALUE;
        return P.b(this.f1949d, this);
    }
}
