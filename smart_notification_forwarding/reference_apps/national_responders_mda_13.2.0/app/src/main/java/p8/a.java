package p8;

import p8.f;
import x8.p;
import y8.k;

/* loaded from: classes.dex */
public abstract class a implements f.b {
    private final f.c<?> key;

    public a(f.c<?> cVar) {
        k.e(cVar, "key");
        this.key = cVar;
    }

    @Override // p8.f
    public <R> R fold(R r10, p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) f.b.a.a(this, r10, pVar);
    }

    @Override // p8.f.b, p8.f
    public <E extends f.b> E get(f.c<E> cVar) {
        return (E) f.b.a.b(this, cVar);
    }

    @Override // p8.f.b
    public f.c<?> getKey() {
        return this.key;
    }

    @Override // p8.f
    public f minusKey(f.c<?> cVar) {
        return f.b.a.c(this, cVar);
    }

    public f plus(f fVar) {
        return f.b.a.d(this, fVar);
    }
}
