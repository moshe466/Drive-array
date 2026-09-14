package xa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import n9.d0;
import n9.v0;

/* loaded from: classes.dex */
public abstract class o extends n {

    /* renamed from: l, reason: collision with root package name */
    private final ia.a f15617l;

    /* renamed from: m, reason: collision with root package name */
    private final za.f f15618m;

    /* renamed from: n, reason: collision with root package name */
    private final ia.d f15619n;

    /* renamed from: o, reason: collision with root package name */
    private final w f15620o;

    /* renamed from: p, reason: collision with root package name */
    private ga.m f15621p;

    /* renamed from: q, reason: collision with root package name */
    private ua.h f15622q;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l<la.a, v0> {
        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v0 h(la.a aVar) {
            y8.k.e(aVar, "it");
            za.f fVar = o.this.f15618m;
            if (fVar != null) {
                return fVar;
            }
            v0 v0Var = v0.f12324a;
            y8.k.d(v0Var, "NO_SOURCE");
            return v0Var;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<Collection<? extends la.e>> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<la.e> b() {
            int n10;
            Collection<la.a> b10 = o.this.U0().b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : b10) {
                la.a aVar = (la.a) obj;
                if ((aVar.l() || h.f15575c.a().contains(aVar)) ? false : true) {
                    arrayList.add(obj);
                }
            }
            n10 = m8.r.n(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(n10);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((la.a) it.next()).j());
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(la.b bVar, ab.n nVar, d0 d0Var, ga.m mVar, ia.a aVar, za.f fVar) {
        super(bVar, nVar, d0Var);
        y8.k.e(bVar, "fqName");
        y8.k.e(nVar, "storageManager");
        y8.k.e(d0Var, "module");
        y8.k.e(mVar, "proto");
        y8.k.e(aVar, "metadataVersion");
        this.f15617l = aVar;
        this.f15618m = fVar;
        ga.p Q = mVar.Q();
        y8.k.d(Q, "proto.strings");
        ga.o P = mVar.P();
        y8.k.d(P, "proto.qualifiedNames");
        ia.d dVar = new ia.d(Q, P);
        this.f15619n = dVar;
        this.f15620o = new w(mVar, dVar, aVar, new a());
        this.f15621p = mVar;
    }

    @Override // n9.g0
    public ua.h A() {
        ua.h hVar = this.f15622q;
        if (hVar != null) {
            return hVar;
        }
        y8.k.o("_memberScope");
        throw null;
    }

    @Override // xa.n
    public void W0(j jVar) {
        y8.k.e(jVar, "components");
        ga.m mVar = this.f15621p;
        if (mVar == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this.f15621p = null;
        ga.l O = mVar.O();
        y8.k.d(O, "proto.`package`");
        this.f15622q = new za.i(this, O, this.f15619n, this.f15617l, this.f15618m, jVar, new b());
    }

    @Override // xa.n
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public w U0() {
        return this.f15620o;
    }
}
