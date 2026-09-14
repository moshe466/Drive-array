package R;

import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class W extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public Y f1828a;

    /* renamed from: b, reason: collision with root package name */
    public S f1829b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1830c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f1831d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Y f1832e;

    /* renamed from: f, reason: collision with root package name */
    public int f1833f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(Y y, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1832e = y;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1831d = obj;
        this.f1833f |= Integer.MIN_VALUE;
        return this.f1832e.a(null, this);
    }
}
