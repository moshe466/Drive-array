package S2;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class l extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2192a;

    /* renamed from: b, reason: collision with root package name */
    public int f2193b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f2194c;

    /* renamed from: d, reason: collision with root package name */
    public k f2195d;

    /* renamed from: e, reason: collision with root package name */
    public e f2196e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f2194c = kVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f2192a = obj;
        this.f2193b |= Integer.MIN_VALUE;
        return this.f2194c.collect(null, this);
    }
}
