package R;

import y2.AbstractC0787c;

/* renamed from: R.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0185j extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public Object f1895a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1896b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1897c;

    /* renamed from: d, reason: collision with root package name */
    public kotlin.jvm.internal.r f1898d;

    /* renamed from: e, reason: collision with root package name */
    public P f1899e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1900f;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ C0186k f1901j;

    /* renamed from: k, reason: collision with root package name */
    public int f1902k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0185j(C0186k c0186k, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1901j = c0186k;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1900f = obj;
        this.f1902k |= Integer.MIN_VALUE;
        return this.f1901j.a(null, this);
    }
}
