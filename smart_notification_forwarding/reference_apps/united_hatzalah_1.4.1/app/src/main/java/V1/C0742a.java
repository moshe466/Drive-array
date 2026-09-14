package v1;

import r2.InterfaceC0645a;

/* renamed from: v1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0742a implements InterfaceC0645a {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f6619c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile b f6620a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f6621b;

    /* JADX WARN: Type inference failed for: r0v1, types: [r2.a, v1.a, java.lang.Object] */
    public static InterfaceC0645a a(b bVar) {
        if (bVar instanceof C0742a) {
            return bVar;
        }
        ?? obj = new Object();
        obj.f6621b = f6619c;
        obj.f6620a = bVar;
        return obj;
    }

    @Override // r2.InterfaceC0645a
    public final Object get() {
        Object obj;
        Object obj2 = this.f6621b;
        Object obj3 = f6619c;
        if (obj2 == obj3) {
            synchronized (this) {
                try {
                    obj = this.f6621b;
                    if (obj == obj3) {
                        obj = this.f6620a.get();
                        Object obj4 = this.f6621b;
                        if (obj4 != obj3 && obj4 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.f6621b = obj;
                        this.f6620a = null;
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
