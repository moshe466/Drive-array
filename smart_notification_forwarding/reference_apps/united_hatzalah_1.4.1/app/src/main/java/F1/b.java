package F1;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f733c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile c f734a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f735b;

    /* JADX WARN: Type inference failed for: r0v1, types: [F1.c, java.lang.Object, F1.b] */
    public static c a(c cVar) {
        if (cVar instanceof b) {
            return cVar;
        }
        ?? obj = new Object();
        obj.f735b = f733c;
        obj.f734a = cVar;
        return obj;
    }

    @Override // F1.c
    public final Object zza() {
        Object obj;
        Object obj2 = this.f735b;
        Object obj3 = f733c;
        if (obj2 == obj3) {
            synchronized (this) {
                try {
                    obj = this.f735b;
                    if (obj == obj3) {
                        obj = this.f734a.zza();
                        Object obj4 = this.f735b;
                        if (obj4 != obj3 && obj4 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.f735b = obj;
                        this.f734a = null;
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
