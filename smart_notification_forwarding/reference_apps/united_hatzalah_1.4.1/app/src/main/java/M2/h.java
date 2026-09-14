package M2;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class h implements Iterable, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N2.c f1416a;

    public h(N2.c cVar) {
        this.f1416a = cVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new N2.b(this.f1416a);
    }
}
