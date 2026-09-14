package S2;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class r extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2216a;

    /* renamed from: b, reason: collision with root package name */
    public int f2217b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f2218c;

    /* renamed from: d, reason: collision with root package name */
    public o f2219d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(k kVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f2218c = kVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f2216a = obj;
        this.f2217b |= Integer.MIN_VALUE;
        return this.f2218c.collect(null, this);
    }
}
