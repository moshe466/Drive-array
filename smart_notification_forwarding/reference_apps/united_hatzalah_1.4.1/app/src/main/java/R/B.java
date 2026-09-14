package R;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class B extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public P f1740a;

    /* renamed from: b, reason: collision with root package name */
    public k0 f1741b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1742c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f1743d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ P f1744e;

    /* renamed from: f, reason: collision with root package name */
    public int f1745f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(P p, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f1744e = p;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1743d = obj;
        this.f1745f |= Integer.MIN_VALUE;
        return P.e(this.f1744e, false, this);
    }
}
