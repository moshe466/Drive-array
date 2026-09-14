package r1;

import android.content.Context;

/* loaded from: classes.dex */
public final class i0 implements m1.b<h0> {

    /* renamed from: a, reason: collision with root package name */
    private final k8.a<Context> f13686a;

    /* renamed from: b, reason: collision with root package name */
    private final k8.a<String> f13687b;

    /* renamed from: c, reason: collision with root package name */
    private final k8.a<Integer> f13688c;

    public i0(k8.a<Context> aVar, k8.a<String> aVar2, k8.a<Integer> aVar3) {
        this.f13686a = aVar;
        this.f13687b = aVar2;
        this.f13688c = aVar3;
    }

    public static i0 a(k8.a<Context> aVar, k8.a<String> aVar2, k8.a<Integer> aVar3) {
        return new i0(aVar, aVar2, aVar3);
    }

    public static h0 c(Context context, String str, int i10) {
        return new h0(context, str, i10);
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h0 get() {
        return c(this.f13686a.get(), this.f13687b.get(), this.f13688c.get().intValue());
    }
}
