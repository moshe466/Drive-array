package va;

import bb.b0;

/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: c, reason: collision with root package name */
    private final n9.a f14847c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n9.a aVar, b0 b0Var, d dVar) {
        super(b0Var, dVar);
        if (aVar == null) {
            c(0);
        }
        if (b0Var == null) {
            c(1);
        }
        this.f14847c = aVar;
    }

    private static /* synthetic */ void c(int i10) {
        String str = i10 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 2 ? 3 : 2];
        if (i10 == 1) {
            objArr[0] = "receiverType";
        } else if (i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i10 != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i10 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i10 != 2) {
            if (i10 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String format = String.format(str, objArr);
        if (i10 == 2) {
            throw new IllegalStateException(format);
        }
    }

    public String toString() {
        return b() + ": Ext {" + this.f14847c + "}";
    }
}
