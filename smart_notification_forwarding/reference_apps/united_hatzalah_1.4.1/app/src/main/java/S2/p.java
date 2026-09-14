package S2;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class p extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public q f2207a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2208b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2209c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f2210d;

    /* renamed from: e, reason: collision with root package name */
    public int f2211e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f2210d = qVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f2209c = obj;
        this.f2211e |= Integer.MIN_VALUE;
        return this.f2210d.emit(null, this);
    }
}
