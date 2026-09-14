package bb;

/* loaded from: classes.dex */
public interface r0 {

    /* loaded from: classes.dex */
    public static final class a implements r0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f4252a = new a();

        private a() {
        }

        @Override // bb.r0
        public void a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
            y8.k.e(cVar, "annotation");
        }

        @Override // bb.r0
        public void b(b0 b0Var, b0 b0Var2, b0 b0Var3, n9.a1 a1Var) {
            y8.k.e(b0Var, "bound");
            y8.k.e(b0Var2, "unsubstitutedArgument");
            y8.k.e(b0Var3, "argument");
            y8.k.e(a1Var, "typeParameter");
        }

        @Override // bb.r0
        public void c(n9.z0 z0Var, n9.a1 a1Var, b0 b0Var) {
            y8.k.e(z0Var, "typeAlias");
            y8.k.e(b0Var, "substitutedArgument");
        }

        @Override // bb.r0
        public void d(n9.z0 z0Var) {
            y8.k.e(z0Var, "typeAlias");
        }
    }

    void a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar);

    void b(b0 b0Var, b0 b0Var2, b0 b0Var3, n9.a1 a1Var);

    void c(n9.z0 z0Var, n9.a1 a1Var, b0 b0Var);

    void d(n9.z0 z0Var);
}
