package nb;

import p8.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r1 implements f.b, f.c<r1> {

    /* renamed from: f, reason: collision with root package name */
    public static final r1 f12425f = new r1();

    private r1() {
    }

    @Override // p8.f
    public <R> R fold(R r10, x8.p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) f.b.a.a(this, r10, pVar);
    }

    @Override // p8.f.b, p8.f
    public <E extends f.b> E get(f.c<E> cVar) {
        return (E) f.b.a.b(this, cVar);
    }

    @Override // p8.f.b
    public f.c<?> getKey() {
        return this;
    }

    @Override // p8.f
    public p8.f minusKey(f.c<?> cVar) {
        return f.b.a.c(this, cVar);
    }
}
