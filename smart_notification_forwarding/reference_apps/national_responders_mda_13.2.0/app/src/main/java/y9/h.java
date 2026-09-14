package y9;

import ca.y;
import ca.z;
import java.util.Map;
import n9.a1;
import n9.m;
import y8.l;

/* loaded from: classes.dex */
public final class h implements k {

    /* renamed from: a, reason: collision with root package name */
    private final g f15995a;

    /* renamed from: b, reason: collision with root package name */
    private final m f15996b;

    /* renamed from: c, reason: collision with root package name */
    private final int f15997c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<y, Integer> f15998d;

    /* renamed from: e, reason: collision with root package name */
    private final ab.h<y, z9.m> f15999e;

    /* loaded from: classes.dex */
    static final class a extends l implements x8.l<y, z9.m> {
        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z9.m h(y yVar) {
            y8.k.e(yVar, "typeParameter");
            Integer num = (Integer) h.this.f15998d.get(yVar);
            if (num == null) {
                return null;
            }
            h hVar = h.this;
            return new z9.m(y9.a.h(y9.a.b(hVar.f15995a, hVar), hVar.f15996b.u()), yVar, hVar.f15997c + num.intValue(), hVar.f15996b);
        }
    }

    public h(g gVar, m mVar, z zVar, int i10) {
        y8.k.e(gVar, "c");
        y8.k.e(mVar, "containingDeclaration");
        y8.k.e(zVar, "typeParameterOwner");
        this.f15995a = gVar;
        this.f15996b = mVar;
        this.f15997c = i10;
        this.f15998d = jb.a.d(zVar.m());
        this.f15999e = gVar.e().c(new a());
    }

    @Override // y9.k
    public a1 a(y yVar) {
        y8.k.e(yVar, "javaTypeParameter");
        z9.m h10 = this.f15999e.h(yVar);
        return h10 == null ? this.f15995a.f().a(yVar) : h10;
    }
}
