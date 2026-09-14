package S2;

import P2.InterfaceC0157i0;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class x extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public y f2235a;

    /* renamed from: b, reason: collision with root package name */
    public e f2236b;

    /* renamed from: c, reason: collision with root package name */
    public A f2237c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC0157i0 f2238d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2239e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f2240f;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ y f2241j;

    /* renamed from: k, reason: collision with root package name */
    public int f2242k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(y yVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f2241j = yVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f2240f = obj;
        this.f2242k |= Integer.MIN_VALUE;
        this.f2241j.collect(null, this);
        return EnumC0779a.f6740a;
    }
}
