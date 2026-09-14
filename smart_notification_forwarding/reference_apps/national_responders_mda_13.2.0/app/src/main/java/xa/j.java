package xa;

import java.util.List;
import n9.d0;
import n9.f0;
import n9.g0;
import n9.h0;
import o9.a;
import o9.c;
import o9.e;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final ab.n f15585a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f15586b;

    /* renamed from: c, reason: collision with root package name */
    private final k f15587c;

    /* renamed from: d, reason: collision with root package name */
    private final g f15588d;

    /* renamed from: e, reason: collision with root package name */
    private final c<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, pa.g<?>> f15589e;

    /* renamed from: f, reason: collision with root package name */
    private final h0 f15590f;

    /* renamed from: g, reason: collision with root package name */
    private final t f15591g;

    /* renamed from: h, reason: collision with root package name */
    private final p f15592h;

    /* renamed from: i, reason: collision with root package name */
    private final u9.c f15593i;

    /* renamed from: j, reason: collision with root package name */
    private final q f15594j;

    /* renamed from: k, reason: collision with root package name */
    private final Iterable<o9.b> f15595k;

    /* renamed from: l, reason: collision with root package name */
    private final f0 f15596l;

    /* renamed from: m, reason: collision with root package name */
    private final i f15597m;

    /* renamed from: n, reason: collision with root package name */
    private final o9.a f15598n;

    /* renamed from: o, reason: collision with root package name */
    private final o9.c f15599o;

    /* renamed from: p, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.g f15600p;

    /* renamed from: q, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.l f15601q;

    /* renamed from: r, reason: collision with root package name */
    private final ta.a f15602r;

    /* renamed from: s, reason: collision with root package name */
    private final o9.e f15603s;

    /* renamed from: t, reason: collision with root package name */
    private final h f15604t;

    /* JADX WARN: Multi-variable type inference failed */
    public j(ab.n nVar, d0 d0Var, k kVar, g gVar, c<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, ? extends pa.g<?>> cVar, h0 h0Var, t tVar, p pVar, u9.c cVar2, q qVar, Iterable<? extends o9.b> iterable, f0 f0Var, i iVar, o9.a aVar, o9.c cVar3, kotlin.reflect.jvm.internal.impl.protobuf.g gVar2, kotlin.reflect.jvm.internal.impl.types.checker.l lVar, ta.a aVar2, o9.e eVar) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(d0Var, "moduleDescriptor");
        y8.k.e(kVar, "configuration");
        y8.k.e(gVar, "classDataFinder");
        y8.k.e(cVar, "annotationAndConstantLoader");
        y8.k.e(h0Var, "packageFragmentProvider");
        y8.k.e(tVar, "localClassifierTypeSettings");
        y8.k.e(pVar, "errorReporter");
        y8.k.e(cVar2, "lookupTracker");
        y8.k.e(qVar, "flexibleTypeDeserializer");
        y8.k.e(iterable, "fictitiousClassDescriptorFactories");
        y8.k.e(f0Var, "notFoundClasses");
        y8.k.e(iVar, "contractDeserializer");
        y8.k.e(aVar, "additionalClassPartsProvider");
        y8.k.e(cVar3, "platformDependentDeclarationFilter");
        y8.k.e(gVar2, "extensionRegistryLite");
        y8.k.e(lVar, "kotlinTypeChecker");
        y8.k.e(aVar2, "samConversionResolver");
        y8.k.e(eVar, "platformDependentTypeTransformer");
        this.f15585a = nVar;
        this.f15586b = d0Var;
        this.f15587c = kVar;
        this.f15588d = gVar;
        this.f15589e = cVar;
        this.f15590f = h0Var;
        this.f15591g = tVar;
        this.f15592h = pVar;
        this.f15593i = cVar2;
        this.f15594j = qVar;
        this.f15595k = iterable;
        this.f15596l = f0Var;
        this.f15597m = iVar;
        this.f15598n = aVar;
        this.f15599o = cVar3;
        this.f15600p = gVar2;
        this.f15601q = lVar;
        this.f15602r = aVar2;
        this.f15603s = eVar;
        this.f15604t = new h(this);
    }

    public /* synthetic */ j(ab.n nVar, d0 d0Var, k kVar, g gVar, c cVar, h0 h0Var, t tVar, p pVar, u9.c cVar2, q qVar, Iterable iterable, f0 f0Var, i iVar, o9.a aVar, o9.c cVar3, kotlin.reflect.jvm.internal.impl.protobuf.g gVar2, kotlin.reflect.jvm.internal.impl.types.checker.l lVar, ta.a aVar2, o9.e eVar, int i10, y8.g gVar3) {
        this(nVar, d0Var, kVar, gVar, cVar, h0Var, tVar, pVar, cVar2, qVar, iterable, f0Var, iVar, (i10 & 8192) != 0 ? a.C0266a.f12629a : aVar, (i10 & 16384) != 0 ? c.a.f12630a : cVar3, gVar2, (65536 & i10) != 0 ? kotlin.reflect.jvm.internal.impl.types.checker.l.f11584b.a() : lVar, aVar2, (i10 & 262144) != 0 ? e.a.f12633a : eVar);
    }

    public final l a(g0 g0Var, ia.c cVar, ia.g gVar, ia.i iVar, ia.a aVar, za.f fVar) {
        List d10;
        y8.k.e(g0Var, "descriptor");
        y8.k.e(cVar, "nameResolver");
        y8.k.e(gVar, "typeTable");
        y8.k.e(iVar, "versionRequirementTable");
        y8.k.e(aVar, "metadataVersion");
        d10 = m8.q.d();
        return new l(this, cVar, g0Var, gVar, iVar, aVar, fVar, null, d10);
    }

    public final n9.e b(la.a aVar) {
        y8.k.e(aVar, "classId");
        return h.e(this.f15604t, aVar, null, 2, null);
    }

    public final o9.a c() {
        return this.f15598n;
    }

    public final c<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, pa.g<?>> d() {
        return this.f15589e;
    }

    public final g e() {
        return this.f15588d;
    }

    public final h f() {
        return this.f15604t;
    }

    public final k g() {
        return this.f15587c;
    }

    public final i h() {
        return this.f15597m;
    }

    public final p i() {
        return this.f15592h;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.g j() {
        return this.f15600p;
    }

    public final Iterable<o9.b> k() {
        return this.f15595k;
    }

    public final q l() {
        return this.f15594j;
    }

    public final kotlin.reflect.jvm.internal.impl.types.checker.l m() {
        return this.f15601q;
    }

    public final t n() {
        return this.f15591g;
    }

    public final u9.c o() {
        return this.f15593i;
    }

    public final d0 p() {
        return this.f15586b;
    }

    public final f0 q() {
        return this.f15596l;
    }

    public final h0 r() {
        return this.f15590f;
    }

    public final o9.c s() {
        return this.f15599o;
    }

    public final o9.e t() {
        return this.f15603s;
    }

    public final ab.n u() {
        return this.f15585a;
    }
}
