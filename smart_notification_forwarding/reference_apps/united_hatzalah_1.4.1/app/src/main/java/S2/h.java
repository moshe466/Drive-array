package S2;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class h extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2176a;

    /* renamed from: b, reason: collision with root package name */
    public int f2177b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f2178c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2179d;

    /* renamed from: e, reason: collision with root package name */
    public e f2180e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f2178c = iVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f2176a = obj;
        this.f2177b |= Integer.MIN_VALUE;
        return this.f2178c.collect(null, this);
    }
}
