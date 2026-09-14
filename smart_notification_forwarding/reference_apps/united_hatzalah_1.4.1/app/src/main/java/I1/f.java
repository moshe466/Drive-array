package I1;

/* loaded from: classes.dex */
public final class f implements i {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f920c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile i f921a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f922b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [I1.f, java.lang.Object] */
    public static f b(g gVar) {
        if (gVar instanceof f) {
            return (f) gVar;
        }
        ?? obj = new Object();
        obj.f922b = f920c;
        obj.f921a = gVar;
        return obj;
    }

    @Override // I1.i
    public final Object a() {
        Object obj;
        Object obj2 = this.f922b;
        Object obj3 = f920c;
        if (obj2 == obj3) {
            synchronized (this) {
                try {
                    obj = this.f922b;
                    if (obj == obj3) {
                        obj = this.f921a.a();
                        Object obj4 = this.f922b;
                        if (obj4 != obj3 && obj4 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.f922b = obj;
                        this.f921a = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return obj;
        }
        return obj2;
    }
}
