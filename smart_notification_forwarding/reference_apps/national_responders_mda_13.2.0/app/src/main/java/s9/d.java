package s9;

import java.lang.annotation.Annotation;

/* loaded from: classes.dex */
public abstract class d implements ca.b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f14153b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final la.e f14154a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final d a(Object obj, la.e eVar) {
            y8.k.e(obj, "value");
            return b.h(obj.getClass()) ? new o(eVar, (Enum) obj) : obj instanceof Annotation ? new e(eVar, (Annotation) obj) : obj instanceof Object[] ? new h(eVar, (Object[]) obj) : obj instanceof Class ? new k(eVar, (Class) obj) : new q(eVar, obj);
        }
    }

    public d(la.e eVar) {
        this.f14154a = eVar;
    }

    @Override // ca.b
    public la.e c() {
        return this.f14154a;
    }
}
