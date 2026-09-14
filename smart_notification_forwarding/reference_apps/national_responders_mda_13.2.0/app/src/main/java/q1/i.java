package q1;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class i implements m1.b<h> {

    /* renamed from: a, reason: collision with root package name */
    private final k8.a<Context> f13449a;

    /* renamed from: b, reason: collision with root package name */
    private final k8.a<l1.b> f13450b;

    /* renamed from: c, reason: collision with root package name */
    private final k8.a<r1.c> f13451c;

    /* renamed from: d, reason: collision with root package name */
    private final k8.a<n> f13452d;

    /* renamed from: e, reason: collision with root package name */
    private final k8.a<Executor> f13453e;

    /* renamed from: f, reason: collision with root package name */
    private final k8.a<s1.b> f13454f;

    /* renamed from: g, reason: collision with root package name */
    private final k8.a<t1.a> f13455g;

    public i(k8.a<Context> aVar, k8.a<l1.b> aVar2, k8.a<r1.c> aVar3, k8.a<n> aVar4, k8.a<Executor> aVar5, k8.a<s1.b> aVar6, k8.a<t1.a> aVar7) {
        this.f13449a = aVar;
        this.f13450b = aVar2;
        this.f13451c = aVar3;
        this.f13452d = aVar4;
        this.f13453e = aVar5;
        this.f13454f = aVar6;
        this.f13455g = aVar7;
    }

    public static i a(k8.a<Context> aVar, k8.a<l1.b> aVar2, k8.a<r1.c> aVar3, k8.a<n> aVar4, k8.a<Executor> aVar5, k8.a<s1.b> aVar6, k8.a<t1.a> aVar7) {
        return new i(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static h c(Context context, l1.b bVar, r1.c cVar, n nVar, Executor executor, s1.b bVar2, t1.a aVar) {
        return new h(context, bVar, cVar, nVar, executor, bVar2, aVar);
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h get() {
        return c(this.f13449a.get(), this.f13450b.get(), this.f13451c.get(), this.f13452d.get(), this.f13453e.get(), this.f13454f.get(), this.f13455g.get());
    }
}
