package p9;

import bb.h1;
import bb.t0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import n9.a1;
import n9.v0;
import n9.y0;

/* loaded from: classes.dex */
public abstract class e extends k implements a1 {

    /* renamed from: j, reason: collision with root package name */
    private final h1 f13183j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f13184k;

    /* renamed from: l, reason: collision with root package name */
    private final int f13185l;

    /* renamed from: m, reason: collision with root package name */
    private final ab.i<t0> f13186m;

    /* renamed from: n, reason: collision with root package name */
    private final ab.i<bb.i0> f13187n;

    /* renamed from: o, reason: collision with root package name */
    private final ab.n f13188o;

    /* loaded from: classes.dex */
    class a implements x8.a<t0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ab.n f13189f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ y0 f13190g;

        a(ab.n nVar, y0 y0Var) {
            this.f13189f = nVar;
            this.f13190g = y0Var;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public t0 b() {
            return new c(e.this, this.f13189f, this.f13190g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements x8.a<bb.i0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ la.e f13192f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements x8.a<ua.h> {
            a() {
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ua.h b() {
                return ua.n.j("Scope for type parameter " + b.this.f13192f.k(), e.this.getUpperBounds());
            }
        }

        b(la.e eVar) {
            this.f13192f = eVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public bb.i0 b() {
            return bb.c0.j(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), e.this.o(), Collections.emptyList(), false, new ua.g(new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends bb.g {

        /* renamed from: c, reason: collision with root package name */
        private final y0 f13195c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f13196d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, ab.n nVar, y0 y0Var) {
            super(nVar);
            if (nVar == null) {
                m(0);
            }
            this.f13196d = eVar;
            this.f13195c = y0Var;
        }

        private static /* synthetic */ void m(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i10 == 2) {
                objArr[1] = "getParameters";
            } else if (i10 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i10 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i10 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i10 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5 && i10 != 8) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // bb.g, bb.t0
        public n9.h A() {
            e eVar = this.f13196d;
            if (eVar == null) {
                m(3);
            }
            return eVar;
        }

        @Override // bb.t0
        public List<a1> B() {
            List<a1> emptyList = Collections.emptyList();
            if (emptyList == null) {
                m(2);
            }
            return emptyList;
        }

        @Override // bb.g
        protected Collection<bb.b0> d() {
            List<bb.b0> W0 = this.f13196d.W0();
            if (W0 == null) {
                m(1);
            }
            return W0;
        }

        @Override // bb.g
        protected bb.b0 e() {
            return bb.t.j("Cyclic upper bounds");
        }

        @Override // bb.g
        protected y0 h() {
            y0 y0Var = this.f13195c;
            if (y0Var == null) {
                m(5);
            }
            return y0Var;
        }

        @Override // bb.g
        protected List<bb.b0> j(List<bb.b0> list) {
            if (list == null) {
                m(7);
            }
            List<bb.b0> U0 = this.f13196d.U0(list);
            if (U0 == null) {
                m(8);
            }
            return U0;
        }

        @Override // bb.g
        protected void l(bb.b0 b0Var) {
            if (b0Var == null) {
                m(6);
            }
            this.f13196d.V0(b0Var);
        }

        public String toString() {
            return this.f13196d.c().toString();
        }

        @Override // bb.t0
        public k9.h w() {
            k9.h g10 = ra.a.g(this.f13196d);
            if (g10 == null) {
                m(4);
            }
            return g10;
        }

        @Override // bb.t0
        public boolean z() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ab.n nVar, n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, h1 h1Var, boolean z10, int i10, v0 v0Var, y0 y0Var) {
        super(mVar, gVar, eVar, v0Var);
        if (nVar == null) {
            e0(0);
        }
        if (mVar == null) {
            e0(1);
        }
        if (gVar == null) {
            e0(2);
        }
        if (eVar == null) {
            e0(3);
        }
        if (h1Var == null) {
            e0(4);
        }
        if (v0Var == null) {
            e0(5);
        }
        if (y0Var == null) {
            e0(6);
        }
        this.f13183j = h1Var;
        this.f13184k = z10;
        this.f13185l = i10;
        this.f13186m = nVar.a(new a(nVar, y0Var));
        this.f13187n = nVar.a(new b(eVar));
        this.f13188o = nVar;
    }

    private static /* synthetic */ void e0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i11 = 2;
                break;
            case 12:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i10) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        return oVar.c(this, d10);
    }

    @Override // n9.a1
    public ab.n M() {
        ab.n nVar = this.f13188o;
        if (nVar == null) {
            e0(14);
        }
        return nVar;
    }

    protected List<bb.b0> U0(List<bb.b0> list) {
        if (list == null) {
            e0(12);
        }
        if (list == null) {
            e0(13);
        }
        return list;
    }

    protected abstract void V0(bb.b0 b0Var);

    protected abstract List<bb.b0> W0();

    @Override // n9.a1
    public boolean Z() {
        return false;
    }

    @Override // p9.k, p9.j, n9.m
    public a1 a() {
        a1 a1Var = (a1) super.a();
        if (a1Var == null) {
            e0(11);
        }
        return a1Var;
    }

    @Override // n9.a1
    public boolean a0() {
        return this.f13184k;
    }

    @Override // n9.a1
    public List<bb.b0> getUpperBounds() {
        List<bb.b0> x10 = ((c) o()).x();
        if (x10 == null) {
            e0(8);
        }
        return x10;
    }

    @Override // n9.a1
    public int j() {
        return this.f13185l;
    }

    @Override // n9.a1, n9.h
    public final t0 o() {
        t0 b10 = this.f13186m.b();
        if (b10 == null) {
            e0(9);
        }
        return b10;
    }

    @Override // n9.h
    public bb.i0 s() {
        bb.i0 b10 = this.f13187n.b();
        if (b10 == null) {
            e0(10);
        }
        return b10;
    }

    @Override // n9.a1
    public h1 v() {
        h1 h1Var = this.f13183j;
        if (h1Var == null) {
            e0(7);
        }
        return h1Var;
    }
}
