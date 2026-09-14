package S2;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class n extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public o f2200a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2201b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f2202c;

    /* renamed from: d, reason: collision with root package name */
    public int f2203d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f2202c = oVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f2201b = obj;
        this.f2203d |= Integer.MIN_VALUE;
        return this.f2202c.emit(null, this);
    }
}
