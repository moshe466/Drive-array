package p1;

import java.util.concurrent.Executor;
import q1.n;

/* loaded from: classes.dex */
public final class d implements m1.b<c> {

    /* renamed from: a, reason: collision with root package name */
    private final k8.a<Executor> f13028a;

    /* renamed from: b, reason: collision with root package name */
    private final k8.a<l1.b> f13029b;

    /* renamed from: c, reason: collision with root package name */
    private final k8.a<n> f13030c;

    /* renamed from: d, reason: collision with root package name */
    private final k8.a<r1.c> f13031d;

    /* renamed from: e, reason: collision with root package name */
    private final k8.a<s1.b> f13032e;

    public d(k8.a<Executor> aVar, k8.a<l1.b> aVar2, k8.a<n> aVar3, k8.a<r1.c> aVar4, k8.a<s1.b> aVar5) {
        this.f13028a = aVar;
        this.f13029b = aVar2;
        this.f13030c = aVar3;
        this.f13031d = aVar4;
        this.f13032e = aVar5;
    }

    public static d a(k8.a<Executor> aVar, k8.a<l1.b> aVar2, k8.a<n> aVar3, k8.a<r1.c> aVar4, k8.a<s1.b> aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, l1.b bVar, n nVar, r1.c cVar, s1.b bVar2) {
        return new c(executor, bVar, nVar, cVar, bVar2);
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c(this.f13028a.get(), this.f13029b.get(), this.f13030c.get(), this.f13031d.get(), this.f13032e.get());
    }
}
