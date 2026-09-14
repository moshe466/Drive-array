package R;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class r extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1935a;

    /* renamed from: b, reason: collision with root package name */
    public int f1936b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0193s f1937c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(C0193s c0193s, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f1937c = c0193s;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1935a = obj;
        this.f1936b |= Integer.MIN_VALUE;
        return this.f1937c.emit(null, this);
    }
}
