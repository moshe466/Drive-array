package bb;

/* loaded from: classes.dex */
public class x0 extends w0 {

    /* renamed from: a, reason: collision with root package name */
    private final h1 f4279a;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f4280b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x0(b0 b0Var) {
        this(h1.INVARIANT, b0Var);
        if (b0Var == null) {
            a(2);
        }
    }

    public x0(h1 h1Var, b0 b0Var) {
        if (h1Var == null) {
            a(0);
        }
        if (b0Var == null) {
            a(1);
        }
        this.f4279a = h1Var;
        this.f4280b = b0Var;
    }

    private static /* synthetic */ void a(int i10) {
        String str = (i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5) ? 2 : 3];
        switch (i10) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i10 == 3) {
            objArr[2] = "replaceType";
        } else if (i10 != 4 && i10 != 5) {
            if (i10 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String format = String.format(str, objArr);
        if (i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // bb.v0
    public b0 b() {
        b0 b0Var = this.f4280b;
        if (b0Var == null) {
            a(5);
        }
        return b0Var;
    }

    @Override // bb.v0
    public h1 c() {
        h1 h1Var = this.f4279a;
        if (h1Var == null) {
            a(4);
        }
        return h1Var;
    }

    @Override // bb.v0
    public boolean d() {
        return false;
    }

    @Override // bb.v0
    public v0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            a(6);
        }
        return new x0(this.f4279a, gVar.g(this.f4280b));
    }
}
