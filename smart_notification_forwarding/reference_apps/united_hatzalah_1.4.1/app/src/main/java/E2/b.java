package e2;

import F0.Q;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class b extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4454a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Q f4455b;

    /* renamed from: c, reason: collision with root package name */
    public int f4456c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Q q3, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f4455b = q3;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f4454a = obj;
        this.f4456c |= Integer.MIN_VALUE;
        return Q.c(this.f4455b, null, this);
    }
}
