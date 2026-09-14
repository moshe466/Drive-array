package bb;

/* loaded from: classes.dex */
public final class k extends m implements j, db.d {

    /* renamed from: i, reason: collision with root package name */
    public static final a f4228i = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private final i0 f4229g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f4230h;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        private final boolean a(g1 g1Var) {
            g1Var.W0();
            return (g1Var.W0().o() instanceof n9.a1) || (g1Var instanceof kotlin.reflect.jvm.internal.impl.types.checker.i);
        }

        private final boolean c(g1 g1Var, boolean z10) {
            if (a(g1Var)) {
                return (z10 && (g1Var.W0().o() instanceof n9.a1)) ? c1.l(g1Var) : !kotlin.reflect.jvm.internal.impl.types.checker.n.f11589a.a(g1Var);
            }
            return false;
        }

        public final k b(g1 g1Var, boolean z10) {
            y8.k.e(g1Var, "type");
            y8.g gVar = null;
            if (g1Var instanceof k) {
                return (k) g1Var;
            }
            if (!c(g1Var, z10)) {
                return null;
            }
            if (g1Var instanceof v) {
                v vVar = (v) g1Var;
                y8.k.a(vVar.e1().W0(), vVar.f1().W0());
            }
            return new k(y.c(g1Var), z10, gVar);
        }
    }

    private k(i0 i0Var, boolean z10) {
        this.f4229g = i0Var;
        this.f4230h = z10;
    }

    public /* synthetic */ k(i0 i0Var, boolean z10, y8.g gVar) {
        this(i0Var, z10);
    }

    @Override // bb.m, bb.b0
    public boolean X0() {
        return false;
    }

    @Override // bb.j
    public boolean c() {
        f1().W0();
        return f1().W0().o() instanceof n9.a1;
    }

    @Override // bb.g1
    /* renamed from: d1 */
    public i0 a1(boolean z10) {
        return z10 ? f1().a1(z10) : this;
    }

    @Override // bb.m
    protected i0 f1() {
        return this.f4229g;
    }

    public final i0 i1() {
        return this.f4229g;
    }

    @Override // bb.i0
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public k c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        return new k(f1().c1(gVar), this.f4230h);
    }

    @Override // bb.m
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public k h1(i0 i0Var) {
        y8.k.e(i0Var, "delegate");
        return new k(i0Var, this.f4230h);
    }

    @Override // bb.i0
    public String toString() {
        return f1() + "!!";
    }

    @Override // bb.j
    public b0 v0(b0 b0Var) {
        y8.k.e(b0Var, "replacement");
        return l0.e(b0Var.Z0(), this.f4230h);
    }
}
