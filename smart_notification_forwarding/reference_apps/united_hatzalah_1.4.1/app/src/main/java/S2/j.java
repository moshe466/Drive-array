package S2;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class j extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2183a;

    /* renamed from: b, reason: collision with root package name */
    public int f2184b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f2185c;

    /* renamed from: d, reason: collision with root package name */
    public k f2186d;

    /* renamed from: e, reason: collision with root package name */
    public e f2187e;

    /* renamed from: f, reason: collision with root package name */
    public T2.l f2188f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f2185c = kVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f2183a = obj;
        this.f2184b |= Integer.MIN_VALUE;
        return this.f2185c.collect(null, this);
    }
}
