package r1;

/* loaded from: classes.dex */
public final class c0 implements m1.b<b0> {

    /* renamed from: a, reason: collision with root package name */
    private final k8.a<t1.a> f13666a;

    /* renamed from: b, reason: collision with root package name */
    private final k8.a<t1.a> f13667b;

    /* renamed from: c, reason: collision with root package name */
    private final k8.a<d> f13668c;

    /* renamed from: d, reason: collision with root package name */
    private final k8.a<h0> f13669d;

    public c0(k8.a<t1.a> aVar, k8.a<t1.a> aVar2, k8.a<d> aVar3, k8.a<h0> aVar4) {
        this.f13666a = aVar;
        this.f13667b = aVar2;
        this.f13668c = aVar3;
        this.f13669d = aVar4;
    }

    public static c0 a(k8.a<t1.a> aVar, k8.a<t1.a> aVar2, k8.a<d> aVar3, k8.a<h0> aVar4) {
        return new c0(aVar, aVar2, aVar3, aVar4);
    }

    public static b0 c(t1.a aVar, t1.a aVar2, Object obj, Object obj2) {
        return new b0(aVar, aVar2, (d) obj, (h0) obj2);
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b0 get() {
        return c(this.f13666a.get(), this.f13667b.get(), this.f13668c.get(), this.f13669d.get());
    }
}
