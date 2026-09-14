package R;

import P2.C0169t;
import y2.AbstractC0787c;

/* renamed from: R.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0198x extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public Object f1953a;

    /* renamed from: b, reason: collision with root package name */
    public P f1954b;

    /* renamed from: c, reason: collision with root package name */
    public C0169t f1955c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f1956d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ P f1957e;

    /* renamed from: f, reason: collision with root package name */
    public int f1958f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0198x(P p, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1957e = p;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1956d = obj;
        this.f1958f |= Integer.MIN_VALUE;
        return P.c(this.f1957e, null, this);
    }
}
