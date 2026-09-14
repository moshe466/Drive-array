package l1;

import android.content.Context;

/* loaded from: classes.dex */
public final class d implements m1.b<c> {

    /* renamed from: a, reason: collision with root package name */
    private final k8.a<Context> f11771a;

    /* renamed from: b, reason: collision with root package name */
    private final k8.a<t1.a> f11772b;

    /* renamed from: c, reason: collision with root package name */
    private final k8.a<t1.a> f11773c;

    public d(k8.a<Context> aVar, k8.a<t1.a> aVar2, k8.a<t1.a> aVar3) {
        this.f11771a = aVar;
        this.f11772b = aVar2;
        this.f11773c = aVar3;
    }

    public static d a(k8.a<Context> aVar, k8.a<t1.a> aVar2, k8.a<t1.a> aVar3) {
        return new d(aVar, aVar2, aVar3);
    }

    public static c c(Context context, t1.a aVar, t1.a aVar2) {
        return new c(context, aVar, aVar2);
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c(this.f11771a.get(), this.f11772b.get(), this.f11773c.get());
    }
}
