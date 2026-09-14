package p1;

/* loaded from: classes.dex */
public final class g implements m1.b<com.google.android.datatransport.runtime.scheduling.jobscheduling.e> {

    /* renamed from: a, reason: collision with root package name */
    private final k8.a<t1.a> f13033a;

    public g(k8.a<t1.a> aVar) {
        this.f13033a = aVar;
    }

    public static com.google.android.datatransport.runtime.scheduling.jobscheduling.e a(t1.a aVar) {
        return (com.google.android.datatransport.runtime.scheduling.jobscheduling.e) m1.d.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(k8.a<t1.a> aVar) {
        return new g(aVar);
    }

    @Override // k8.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.google.android.datatransport.runtime.scheduling.jobscheduling.e get() {
        return a(this.f13033a.get());
    }
}
