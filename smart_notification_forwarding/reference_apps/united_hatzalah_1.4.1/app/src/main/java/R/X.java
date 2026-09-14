package R;

import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class X extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public Y f1834a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1835b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1836c;

    /* renamed from: d, reason: collision with root package name */
    public a0 f1837d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f1838e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Y f1839f;

    /* renamed from: j, reason: collision with root package name */
    public int f1840j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(Y y, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1839f = y;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1838e = obj;
        this.f1840j |= Integer.MIN_VALUE;
        return this.f1839f.b(null, this);
    }
}
