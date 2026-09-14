package R;

import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class N extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.q f1792a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1793b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ P f1794c;

    /* renamed from: d, reason: collision with root package name */
    public int f1795d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(P p, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1794c = p;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1793b = obj;
        this.f1795d |= Integer.MIN_VALUE;
        return this.f1794c.j(null, false, this);
    }
}
