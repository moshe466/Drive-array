package p8;

import p8.f;
import p8.f.b;
import x8.l;
import y8.k;

/* loaded from: classes.dex */
public abstract class b<B extends f.b, E extends B> implements f.c<E> {

    /* renamed from: f, reason: collision with root package name */
    private final l<f.b, E> f13120f;

    /* renamed from: g, reason: collision with root package name */
    private final f.c<?> f13121g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [p8.f$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [x8.l<p8.f$b, E extends B>, x8.l<? super p8.f$b, ? extends E extends B>, java.lang.Object] */
    public b(f.c<B> cVar, l<? super f.b, ? extends E> lVar) {
        k.e(cVar, "baseKey");
        k.e(lVar, "safeCast");
        this.f13120f = lVar;
        this.f13121g = cVar instanceof b ? (f.c<B>) ((b) cVar).f13121g : cVar;
    }

    public final boolean a(f.c<?> cVar) {
        k.e(cVar, "key");
        return cVar == this || this.f13121g == cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lp8/f$b;)TE; */
    public final f.b b(f.b bVar) {
        k.e(bVar, "element");
        return (f.b) this.f13120f.h(bVar);
    }
}
