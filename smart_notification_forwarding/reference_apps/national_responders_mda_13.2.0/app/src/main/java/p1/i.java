package p1;

import android.content.Context;
import q1.n;

/* loaded from: classes.dex */
public final class i implements m1.b<n> {

    /* renamed from: a, reason: collision with root package name */
    private final k8.a<Context> f13034a;

    /* renamed from: b, reason: collision with root package name */
    private final k8.a<r1.c> f13035b;

    /* renamed from: c, reason: collision with root package name */
    private final k8.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.e> f13036c;

    /* renamed from: d, reason: collision with root package name */
    private final k8.a<t1.a> f13037d;

    public i(k8.a<Context> aVar, k8.a<r1.c> aVar2, k8.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.e> aVar3, k8.a<t1.a> aVar4) {
        this.f13034a = aVar;
        this.f13035b = aVar2;
        this.f13036c = aVar3;
        this.f13037d = aVar4;
    }

    public static i a(k8.a<Context> aVar, k8.a<r1.c> aVar2, k8.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.e> aVar3, k8.a<t1.a> aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static n c(Context context, r1.c cVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.e eVar, t1.a aVar) {
        return (n) m1.d.c(h.a(context, cVar, eVar, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n get() {
        return c(this.f13034a.get(), this.f13035b.get(), this.f13036c.get(), this.f13037d.get());
    }
}
