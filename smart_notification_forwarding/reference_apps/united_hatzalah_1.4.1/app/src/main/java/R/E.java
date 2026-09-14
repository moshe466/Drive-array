package R;

import java.io.Serializable;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class E extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public Object f1754a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1755b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f1756c;

    /* renamed from: d, reason: collision with root package name */
    public kotlin.jvm.internal.r f1757d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1758e;

    /* renamed from: f, reason: collision with root package name */
    public int f1759f;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f1760j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ P f1761k;

    /* renamed from: l, reason: collision with root package name */
    public int f1762l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(P p, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1761k = p;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1760j = obj;
        this.f1762l |= Integer.MIN_VALUE;
        return P.f(this.f1761k, false, this);
    }
}
