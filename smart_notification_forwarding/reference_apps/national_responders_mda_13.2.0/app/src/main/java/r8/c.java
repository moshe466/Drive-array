package r8;

import p8.f;
import y8.k;

/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: g, reason: collision with root package name */
    private final p8.f f13794g;

    /* renamed from: h, reason: collision with root package name */
    private transient p8.d<Object> f13795h;

    @Override // p8.d
    public p8.f c() {
        p8.f fVar = this.f13794g;
        k.b(fVar);
        return fVar;
    }

    @Override // r8.a
    protected void f() {
        p8.d<?> dVar = this.f13795h;
        if (dVar != null && dVar != this) {
            f.b bVar = c().get(p8.e.f13125e);
            k.b(bVar);
            ((p8.e) bVar).O(dVar);
        }
        this.f13795h = b.f13793f;
    }

    public final p8.d<Object> g() {
        p8.d<Object> dVar = this.f13795h;
        if (dVar == null) {
            p8.e eVar = (p8.e) c().get(p8.e.f13125e);
            if (eVar == null || (dVar = eVar.j(this)) == null) {
                dVar = this;
            }
            this.f13795h = dVar;
        }
        return dVar;
    }
}
