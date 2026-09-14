package va;

import bb.b0;

/* loaded from: classes.dex */
public class g extends a {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(b0 b0Var) {
        this(b0Var, null);
        if (b0Var == null) {
            c(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private g(b0 b0Var, d dVar) {
        super(b0Var, dVar);
        if (b0Var == null) {
            c(1);
        }
    }

    private static /* synthetic */ void c(int i10) {
        Object[] objArr = new Object[3];
        if (i10 != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i10 != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + b();
    }
}
