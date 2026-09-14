package xa;

import java.util.List;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final j f15606a;

    /* renamed from: b, reason: collision with root package name */
    private final ia.c f15607b;

    /* renamed from: c, reason: collision with root package name */
    private final n9.m f15608c;

    /* renamed from: d, reason: collision with root package name */
    private final ia.g f15609d;

    /* renamed from: e, reason: collision with root package name */
    private final ia.i f15610e;

    /* renamed from: f, reason: collision with root package name */
    private final ia.a f15611f;

    /* renamed from: g, reason: collision with root package name */
    private final za.f f15612g;

    /* renamed from: h, reason: collision with root package name */
    private final b0 f15613h;

    /* renamed from: i, reason: collision with root package name */
    private final u f15614i;

    public l(j jVar, ia.c cVar, n9.m mVar, ia.g gVar, ia.i iVar, ia.a aVar, za.f fVar, b0 b0Var, List<ga.s> list) {
        String c10;
        y8.k.e(jVar, "components");
        y8.k.e(cVar, "nameResolver");
        y8.k.e(mVar, "containingDeclaration");
        y8.k.e(gVar, "typeTable");
        y8.k.e(iVar, "versionRequirementTable");
        y8.k.e(aVar, "metadataVersion");
        y8.k.e(list, "typeParameters");
        this.f15606a = jVar;
        this.f15607b = cVar;
        this.f15608c = mVar;
        this.f15609d = gVar;
        this.f15610e = iVar;
        this.f15611f = aVar;
        this.f15612g = fVar;
        this.f15613h = new b0(this, b0Var, list, "Deserializer for \"" + mVar.c() + '\"', (fVar == null || (c10 = fVar.c()) == null) ? "[container not found]" : c10, false, 32, null);
        this.f15614i = new u(this);
    }

    public static /* synthetic */ l b(l lVar, n9.m mVar, List list, ia.c cVar, ia.g gVar, ia.i iVar, ia.a aVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            cVar = lVar.f15607b;
        }
        ia.c cVar2 = cVar;
        if ((i10 & 8) != 0) {
            gVar = lVar.f15609d;
        }
        ia.g gVar2 = gVar;
        if ((i10 & 16) != 0) {
            iVar = lVar.f15610e;
        }
        ia.i iVar2 = iVar;
        if ((i10 & 32) != 0) {
            aVar = lVar.f15611f;
        }
        return lVar.a(mVar, list, cVar2, gVar2, iVar2, aVar);
    }

    public final l a(n9.m mVar, List<ga.s> list, ia.c cVar, ia.g gVar, ia.i iVar, ia.a aVar) {
        y8.k.e(mVar, "descriptor");
        y8.k.e(list, "typeParameterProtos");
        y8.k.e(cVar, "nameResolver");
        y8.k.e(gVar, "typeTable");
        ia.i iVar2 = iVar;
        y8.k.e(iVar2, "versionRequirementTable");
        y8.k.e(aVar, "metadataVersion");
        j jVar = this.f15606a;
        if (!ia.j.b(aVar)) {
            iVar2 = this.f15610e;
        }
        return new l(jVar, cVar, mVar, gVar, iVar2, aVar, this.f15612g, this.f15613h, list);
    }

    public final j c() {
        return this.f15606a;
    }

    public final za.f d() {
        return this.f15612g;
    }

    public final n9.m e() {
        return this.f15608c;
    }

    public final u f() {
        return this.f15614i;
    }

    public final ia.c g() {
        return this.f15607b;
    }

    public final ab.n h() {
        return this.f15606a.u();
    }

    public final b0 i() {
        return this.f15613h;
    }

    public final ia.g j() {
        return this.f15609d;
    }

    public final ia.i k() {
        return this.f15610e;
    }
}
