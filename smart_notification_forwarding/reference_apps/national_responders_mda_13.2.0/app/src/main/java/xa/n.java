package xa;

import n9.d0;

/* loaded from: classes.dex */
public abstract class n extends p9.z {

    /* renamed from: k, reason: collision with root package name */
    private final ab.n f15616k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(la.b bVar, ab.n nVar, d0 d0Var) {
        super(d0Var, bVar);
        y8.k.e(bVar, "fqName");
        y8.k.e(nVar, "storageManager");
        y8.k.e(d0Var, "module");
        this.f15616k = nVar;
    }

    public abstract g U0();

    public boolean V0(la.e eVar) {
        y8.k.e(eVar, "name");
        ua.h A = A();
        return (A instanceof za.h) && ((za.h) A).r().contains(eVar);
    }

    public abstract void W0(j jVar);
}
