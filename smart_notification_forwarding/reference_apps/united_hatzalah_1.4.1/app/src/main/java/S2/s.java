package S2;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class s extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public o f2220a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2221b;

    /* renamed from: c, reason: collision with root package name */
    public int f2222c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o f2223d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2224e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(o oVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f2223d = oVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f2221b = obj;
        this.f2222c |= Integer.MIN_VALUE;
        return this.f2223d.emit(null, this);
    }
}
