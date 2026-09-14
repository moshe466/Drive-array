package k0;

import k0.a;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class d extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public d(a aVar) {
        k.e(aVar, "initialExtras");
        a().putAll(aVar.a());
    }

    public /* synthetic */ d(a aVar, int i10, g gVar) {
        this((i10 & 1) != 0 ? a.C0224a.f11122b : aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void b(a.b<T> bVar, T t10) {
        k.e(bVar, "key");
        a().put(bVar, t10);
    }
}
