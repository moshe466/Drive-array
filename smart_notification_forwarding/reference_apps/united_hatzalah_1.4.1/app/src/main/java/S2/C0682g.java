package s2;

import java.io.Serializable;
import kotlin.jvm.internal.j;

/* renamed from: s2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0682g implements InterfaceC0678c, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public F2.a f6336a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f6337b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6338c;

    public C0682g(F2.a initializer) {
        j.e(initializer, "initializer");
        this.f6336a = initializer;
        this.f6337b = C0683h.f6339a;
        this.f6338c = this;
    }

    public final Object a() {
        Object obj;
        Object obj2 = this.f6337b;
        C0683h c0683h = C0683h.f6339a;
        if (obj2 != c0683h) {
            return obj2;
        }
        synchronized (this.f6338c) {
            obj = this.f6337b;
            if (obj == c0683h) {
                F2.a aVar = this.f6336a;
                j.b(aVar);
                obj = aVar.invoke();
                this.f6337b = obj;
                this.f6336a = null;
            }
        }
        return obj;
    }

    public final String toString() {
        if (this.f6337b != C0683h.f6339a) {
            return String.valueOf(a());
        }
        return "Lazy value not initialized yet.";
    }
}
