package S2;

import R.C0194t;
import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* renamed from: S2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0201a extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public T2.l f2157a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2158b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0194t f2159c;

    /* renamed from: d, reason: collision with root package name */
    public int f2160d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0201a(C0194t c0194t, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f2159c = c0194t;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f2158b = obj;
        this.f2160d |= Integer.MIN_VALUE;
        return this.f2159c.collect(null, this);
    }
}
