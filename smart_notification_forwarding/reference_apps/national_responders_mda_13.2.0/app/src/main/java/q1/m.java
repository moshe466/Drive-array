package q1;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class m implements m1.b<l> {

    /* renamed from: a, reason: collision with root package name */
    private final k8.a<Executor> f13462a;

    /* renamed from: b, reason: collision with root package name */
    private final k8.a<r1.c> f13463b;

    /* renamed from: c, reason: collision with root package name */
    private final k8.a<n> f13464c;

    /* renamed from: d, reason: collision with root package name */
    private final k8.a<s1.b> f13465d;

    public m(k8.a<Executor> aVar, k8.a<r1.c> aVar2, k8.a<n> aVar3, k8.a<s1.b> aVar4) {
        this.f13462a = aVar;
        this.f13463b = aVar2;
        this.f13464c = aVar3;
        this.f13465d = aVar4;
    }

    public static m a(k8.a<Executor> aVar, k8.a<r1.c> aVar2, k8.a<n> aVar3, k8.a<s1.b> aVar4) {
        return new m(aVar, aVar2, aVar3, aVar4);
    }

    public static l c(Executor executor, r1.c cVar, n nVar, s1.b bVar) {
        return new l(executor, cVar, nVar, bVar);
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l get() {
        return c(this.f13462a.get(), this.f13463b.get(), this.f13464c.get(), this.f13465d.get());
    }
}
