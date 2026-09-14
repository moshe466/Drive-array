package r9;

import java.util.List;
import xa.p;

/* loaded from: classes.dex */
public final class j implements p {

    /* renamed from: b, reason: collision with root package name */
    public static final j f13814b = new j();

    private j() {
    }

    @Override // xa.p
    public void a(n9.b bVar) {
        y8.k.e(bVar, "descriptor");
        throw new IllegalStateException(y8.k.j("Cannot infer visibility for ", bVar));
    }

    @Override // xa.p
    public void b(n9.e eVar, List<String> list) {
        y8.k.e(eVar, "descriptor");
        y8.k.e(list, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + eVar.c() + ", unresolved classes " + list);
    }
}
