package R;

import y2.AbstractC0787c;

/* renamed from: R.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0199y extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public P f1959a;

    /* renamed from: b, reason: collision with root package name */
    public Y2.d f1960b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1961c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f1962d;

    /* renamed from: e, reason: collision with root package name */
    public int f1963e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0199y(P p, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1962d = p;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1961c = obj;
        this.f1963e |= Integer.MIN_VALUE;
        return P.d(this.f1962d, this);
    }
}
