package kotlin.reflect.jvm.internal.impl.renderer;

import bb.b0;
import java.lang.reflect.Field;
import java.util.Set;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.renderer.c;
import kotlin.reflect.jvm.internal.impl.renderer.f;
import m8.r0;
import mb.r;
import n9.d1;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public final class g implements f {
    static final /* synthetic */ KProperty<Object>[] X = {w.e(new y8.n(w.b(g.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), w.e(new y8.n(w.b(g.class), "withDefinedIn", "getWithDefinedIn()Z")), w.e(new y8.n(w.b(g.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), w.e(new y8.n(w.b(g.class), "modifiers", "getModifiers()Ljava/util/Set;")), w.e(new y8.n(w.b(g.class), "startFromName", "getStartFromName()Z")), w.e(new y8.n(w.b(g.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), w.e(new y8.n(w.b(g.class), "debugMode", "getDebugMode()Z")), w.e(new y8.n(w.b(g.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), w.e(new y8.n(w.b(g.class), "verbose", "getVerbose()Z")), w.e(new y8.n(w.b(g.class), "unitReturnType", "getUnitReturnType()Z")), w.e(new y8.n(w.b(g.class), "withoutReturnType", "getWithoutReturnType()Z")), w.e(new y8.n(w.b(g.class), "enhancedTypes", "getEnhancedTypes()Z")), w.e(new y8.n(w.b(g.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), w.e(new y8.n(w.b(g.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), w.e(new y8.n(w.b(g.class), "renderDefaultModality", "getRenderDefaultModality()Z")), w.e(new y8.n(w.b(g.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), w.e(new y8.n(w.b(g.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), w.e(new y8.n(w.b(g.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), w.e(new y8.n(w.b(g.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), w.e(new y8.n(w.b(g.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), w.e(new y8.n(w.b(g.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), w.e(new y8.n(w.b(g.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), w.e(new y8.n(w.b(g.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), w.e(new y8.n(w.b(g.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), w.e(new y8.n(w.b(g.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), w.e(new y8.n(w.b(g.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), w.e(new y8.n(w.b(g.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), w.e(new y8.n(w.b(g.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), w.e(new y8.n(w.b(g.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), w.e(new y8.n(w.b(g.class), "receiverAfterName", "getReceiverAfterName()Z")), w.e(new y8.n(w.b(g.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), w.e(new y8.n(w.b(g.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), w.e(new y8.n(w.b(g.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), w.e(new y8.n(w.b(g.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), w.e(new y8.n(w.b(g.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), w.e(new y8.n(w.b(g.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), w.e(new y8.n(w.b(g.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), w.e(new y8.n(w.b(g.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), w.e(new y8.n(w.b(g.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), w.e(new y8.n(w.b(g.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), w.e(new y8.n(w.b(g.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), w.e(new y8.n(w.b(g.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), w.e(new y8.n(w.b(g.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), w.e(new y8.n(w.b(g.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), w.e(new y8.n(w.b(g.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), w.e(new y8.n(w.b(g.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), w.e(new y8.n(w.b(g.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), w.e(new y8.n(w.b(g.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    private final a9.c A;
    private final a9.c B;
    private final a9.c C;
    private final a9.c D;
    private final a9.c E;
    private final a9.c F;
    private final a9.c G;
    private final a9.c H;
    private final a9.c I;
    private final a9.c J;
    private final a9.c K;
    private final a9.c L;
    private final a9.c M;
    private final a9.c N;
    private final a9.c O;
    private final a9.c P;
    private final a9.c Q;
    private final a9.c R;
    private final a9.c S;
    private final a9.c T;
    private final a9.c U;
    private final a9.c V;
    private final a9.c W;

    /* renamed from: a, reason: collision with root package name */
    private boolean f11525a;

    /* renamed from: b, reason: collision with root package name */
    private final a9.c f11526b = n0(b.c.f11497a);

    /* renamed from: c, reason: collision with root package name */
    private final a9.c f11527c;

    /* renamed from: d, reason: collision with root package name */
    private final a9.c f11528d;

    /* renamed from: e, reason: collision with root package name */
    private final a9.c f11529e;

    /* renamed from: f, reason: collision with root package name */
    private final a9.c f11530f;

    /* renamed from: g, reason: collision with root package name */
    private final a9.c f11531g;

    /* renamed from: h, reason: collision with root package name */
    private final a9.c f11532h;

    /* renamed from: i, reason: collision with root package name */
    private final a9.c f11533i;

    /* renamed from: j, reason: collision with root package name */
    private final a9.c f11534j;

    /* renamed from: k, reason: collision with root package name */
    private final a9.c f11535k;

    /* renamed from: l, reason: collision with root package name */
    private final a9.c f11536l;

    /* renamed from: m, reason: collision with root package name */
    private final a9.c f11537m;

    /* renamed from: n, reason: collision with root package name */
    private final a9.c f11538n;

    /* renamed from: o, reason: collision with root package name */
    private final a9.c f11539o;

    /* renamed from: p, reason: collision with root package name */
    private final a9.c f11540p;

    /* renamed from: q, reason: collision with root package name */
    private final a9.c f11541q;

    /* renamed from: r, reason: collision with root package name */
    private final a9.c f11542r;

    /* renamed from: s, reason: collision with root package name */
    private final a9.c f11543s;

    /* renamed from: t, reason: collision with root package name */
    private final a9.c f11544t;

    /* renamed from: u, reason: collision with root package name */
    private final a9.c f11545u;

    /* renamed from: v, reason: collision with root package name */
    private final a9.c f11546v;

    /* renamed from: w, reason: collision with root package name */
    private final a9.c f11547w;

    /* renamed from: x, reason: collision with root package name */
    private final a9.c f11548x;

    /* renamed from: y, reason: collision with root package name */
    private final a9.c f11549y;

    /* renamed from: z, reason: collision with root package name */
    private final a9.c f11550z;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l<d1, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f11551f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String h(d1 d1Var) {
            y8.k.e(d1Var, "it");
            return "...";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class b<T> extends a9.b<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f11552b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f11553c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, Object obj2, g gVar) {
            super(obj2);
            this.f11552b = obj;
            this.f11553c = gVar;
        }

        @Override // a9.b
        protected boolean d(e9.j<?> jVar, T t10, T t11) {
            y8.k.e(jVar, "property");
            if (this.f11553c.l0()) {
                throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.l<b0, b0> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f11554f = new c();

        c() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 h(b0 b0Var) {
            y8.k.e(b0Var, "it");
            return b0Var;
        }
    }

    public g() {
        Set b10;
        Boolean bool = Boolean.TRUE;
        this.f11527c = n0(bool);
        this.f11528d = n0(bool);
        this.f11529e = n0(e.ALL_EXCEPT_ANNOTATIONS);
        Boolean bool2 = Boolean.FALSE;
        this.f11530f = n0(bool2);
        this.f11531g = n0(bool2);
        this.f11532h = n0(bool2);
        this.f11533i = n0(bool2);
        this.f11534j = n0(bool2);
        this.f11535k = n0(bool);
        this.f11536l = n0(bool2);
        this.f11537m = n0(bool2);
        this.f11538n = n0(bool2);
        this.f11539o = n0(bool);
        this.f11540p = n0(bool);
        this.f11541q = n0(bool2);
        this.f11542r = n0(bool2);
        this.f11543s = n0(bool2);
        this.f11544t = n0(bool2);
        this.f11545u = n0(bool2);
        this.f11546v = n0(bool2);
        this.f11547w = n0(bool2);
        this.f11548x = n0(c.f11554f);
        this.f11549y = n0(a.f11551f);
        this.f11550z = n0(bool);
        this.A = n0(j.RENDER_OPEN);
        this.B = n0(c.l.a.f11512a);
        this.C = n0(m.PLAIN);
        this.D = n0(k.ALL);
        this.E = n0(bool2);
        this.F = n0(bool2);
        this.G = n0(l.DEBUG);
        this.H = n0(bool2);
        this.I = n0(bool2);
        b10 = r0.b();
        this.J = n0(b10);
        this.K = n0(h.f11555a.a());
        this.L = n0(null);
        this.M = n0(kotlin.reflect.jvm.internal.impl.renderer.a.NO_ARGUMENTS);
        this.N = n0(bool2);
        this.O = n0(bool);
        this.P = n0(bool);
        this.Q = n0(bool2);
        this.R = n0(bool);
        this.S = n0(bool);
        this.T = n0(bool2);
        this.U = n0(bool2);
        this.V = n0(bool2);
        this.W = n0(bool);
    }

    private final <T> a9.c<g, T> n0(T t10) {
        a9.a aVar = a9.a.f331a;
        return new b(t10, t10, this);
    }

    public Set<la.b> A() {
        return (Set) this.J.a(this, X[34]);
    }

    public boolean B() {
        return ((Boolean) this.R.a(this, X[42])).booleanValue();
    }

    public boolean C() {
        return f.a.a(this);
    }

    public boolean D() {
        return f.a.b(this);
    }

    public boolean E() {
        return ((Boolean) this.f11545u.a(this, X[19])).booleanValue();
    }

    public boolean F() {
        return ((Boolean) this.W.a(this, X[47])).booleanValue();
    }

    public Set<e> G() {
        return (Set) this.f11529e.a(this, X[3]);
    }

    public boolean H() {
        return ((Boolean) this.f11538n.a(this, X[12])).booleanValue();
    }

    public j I() {
        return (j) this.A.a(this, X[25]);
    }

    public k J() {
        return (k) this.D.a(this, X[28]);
    }

    public boolean K() {
        return ((Boolean) this.S.a(this, X[43])).booleanValue();
    }

    public boolean L() {
        return ((Boolean) this.U.a(this, X[45])).booleanValue();
    }

    public l M() {
        return (l) this.G.a(this, X[31]);
    }

    public boolean N() {
        return ((Boolean) this.E.a(this, X[29])).booleanValue();
    }

    public boolean O() {
        return ((Boolean) this.F.a(this, X[30])).booleanValue();
    }

    public boolean P() {
        return ((Boolean) this.f11541q.a(this, X[15])).booleanValue();
    }

    public boolean Q() {
        return ((Boolean) this.O.a(this, X[39])).booleanValue();
    }

    public boolean R() {
        return ((Boolean) this.H.a(this, X[32])).booleanValue();
    }

    public boolean S() {
        return ((Boolean) this.f11540p.a(this, X[14])).booleanValue();
    }

    public boolean T() {
        return ((Boolean) this.f11539o.a(this, X[13])).booleanValue();
    }

    public boolean U() {
        return ((Boolean) this.f11542r.a(this, X[16])).booleanValue();
    }

    public boolean V() {
        return ((Boolean) this.Q.a(this, X[41])).booleanValue();
    }

    public boolean W() {
        return ((Boolean) this.P.a(this, X[40])).booleanValue();
    }

    public boolean X() {
        return ((Boolean) this.f11550z.a(this, X[24])).booleanValue();
    }

    public boolean Y() {
        return ((Boolean) this.f11531g.a(this, X[5])).booleanValue();
    }

    public boolean Z() {
        return ((Boolean) this.f11530f.a(this, X[4])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void a(boolean z10) {
        this.f11532h.b(this, X[6], Boolean.valueOf(z10));
    }

    public m a0() {
        return (m) this.C.a(this, X[27]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void b(boolean z10) {
        this.F.b(this, X[30], Boolean.valueOf(z10));
    }

    public x8.l<b0, b0> b0() {
        return (x8.l) this.f11548x.a(this, X[22]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void c(boolean z10) {
        this.E.b(this, X[29], Boolean.valueOf(z10));
    }

    public boolean c0() {
        return ((Boolean) this.f11544t.a(this, X[18])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void d(m mVar) {
        y8.k.e(mVar, "<set-?>");
        this.C.b(this, X[27], mVar);
    }

    public boolean d0() {
        return ((Boolean) this.f11535k.a(this, X[9])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void e(Set<la.b> set) {
        y8.k.e(set, "<set-?>");
        this.K.b(this, X[35], set);
    }

    public c.l e0() {
        return (c.l) this.B.a(this, X[26]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void f(boolean z10) {
        this.f11530f.b(this, X[4], Boolean.valueOf(z10));
    }

    public boolean f0() {
        return ((Boolean) this.f11534j.a(this, X[8])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void g(Set<? extends e> set) {
        y8.k.e(set, "<set-?>");
        this.f11529e.b(this, X[3], set);
    }

    public boolean g0() {
        return ((Boolean) this.f11527c.a(this, X[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void h(k kVar) {
        y8.k.e(kVar, "<set-?>");
        this.D.b(this, X[28], kVar);
    }

    public boolean h0() {
        return ((Boolean) this.f11528d.a(this, X[2])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void i(kotlin.reflect.jvm.internal.impl.renderer.a aVar) {
        y8.k.e(aVar, "<set-?>");
        this.M.b(this, X[37], aVar);
    }

    public boolean i0() {
        return ((Boolean) this.f11536l.a(this, X[10])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void j(boolean z10) {
        this.f11527c.b(this, X[1], Boolean.valueOf(z10));
    }

    public boolean j0() {
        return ((Boolean) this.f11547w.a(this, X[21])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public boolean k() {
        return ((Boolean) this.f11537m.a(this, X[11])).booleanValue();
    }

    public boolean k0() {
        return ((Boolean) this.f11546v.a(this, X[20])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public Set<la.b> l() {
        return (Set) this.K.a(this, X[35]);
    }

    public final boolean l0() {
        return this.f11525a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public boolean m() {
        return ((Boolean) this.f11532h.a(this, X[6])).booleanValue();
    }

    public final void m0() {
        this.f11525a = true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public kotlin.reflect.jvm.internal.impl.renderer.a n() {
        return (kotlin.reflect.jvm.internal.impl.renderer.a) this.M.a(this, X[37]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void o(kotlin.reflect.jvm.internal.impl.renderer.b bVar) {
        y8.k.e(bVar, "<set-?>");
        this.f11526b.b(this, X[0], bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void p(boolean z10) {
        this.f11546v.b(this, X[20], Boolean.valueOf(z10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void q(boolean z10) {
        this.f11547w.b(this, X[21], Boolean.valueOf(z10));
    }

    public final g r() {
        String k10;
        g gVar = new g();
        Field[] declaredFields = g.class.getDeclaredFields();
        y8.k.d(declaredFields, "this::class.java.declaredFields");
        int length = declaredFields.length;
        int i10 = 0;
        while (i10 < length) {
            Field field = declaredFields[i10];
            i10++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                a9.b bVar = obj instanceof a9.b ? (a9.b) obj : null;
                if (bVar != null) {
                    String name = field.getName();
                    y8.k.d(name, "field.name");
                    r.w(name, "is", false, 2, null);
                    e9.b b10 = w.b(g.class);
                    String name2 = field.getName();
                    String name3 = field.getName();
                    y8.k.d(name3, "field.name");
                    k10 = r.k(name3);
                    field.set(gVar, gVar.n0(bVar.a(this, new t(b10, name2, y8.k.j("get", k10)))));
                }
            }
        }
        return gVar;
    }

    public boolean s() {
        return ((Boolean) this.f11543s.a(this, X[17])).booleanValue();
    }

    public boolean t() {
        return ((Boolean) this.N.a(this, X[38])).booleanValue();
    }

    public x8.l<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> u() {
        return (x8.l) this.L.a(this, X[36]);
    }

    public boolean v() {
        return ((Boolean) this.V.a(this, X[46])).booleanValue();
    }

    public boolean w() {
        return ((Boolean) this.f11533i.a(this, X[7])).booleanValue();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.b x() {
        return (kotlin.reflect.jvm.internal.impl.renderer.b) this.f11526b.a(this, X[0]);
    }

    public x8.l<d1, String> y() {
        return (x8.l) this.f11549y.a(this, X[23]);
    }

    public boolean z() {
        return ((Boolean) this.I.a(this, X[33])).booleanValue();
    }
}
