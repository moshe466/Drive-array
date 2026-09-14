package bb;

/* loaded from: classes.dex */
public abstract class y0 {

    /* renamed from: a, reason: collision with root package name */
    public static final y0 f4281a;

    /* loaded from: classes.dex */
    public static final class a extends y0 {
        a() {
        }

        @Override // bb.y0
        public /* bridge */ /* synthetic */ v0 e(b0 b0Var) {
            return (v0) h(b0Var);
        }

        @Override // bb.y0
        public boolean f() {
            return true;
        }

        public Void h(b0 b0Var) {
            y8.k.e(b0Var, "key");
            return null;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(y8.g gVar) {
            this();
        }
    }

    static {
        new b(null);
        f4281a = new a();
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public final a1 c() {
        a1 g10 = a1.g(this);
        y8.k.d(g10, "create(this)");
        return g10;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "annotations");
        return gVar;
    }

    public abstract v0 e(b0 b0Var);

    public boolean f() {
        return false;
    }

    public b0 g(b0 b0Var, h1 h1Var) {
        y8.k.e(b0Var, "topLevelType");
        y8.k.e(h1Var, "position");
        return b0Var;
    }
}
