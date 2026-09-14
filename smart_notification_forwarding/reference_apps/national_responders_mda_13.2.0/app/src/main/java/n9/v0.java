package n9;

/* loaded from: classes.dex */
public interface v0 {

    /* renamed from: a, reason: collision with root package name */
    public static final v0 f12324a = new a();

    /* loaded from: classes.dex */
    static class a implements v0 {
        a() {
        }

        private static /* synthetic */ void d(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // n9.v0
        public w0 a() {
            w0 w0Var = w0.f12327a;
            if (w0Var == null) {
                d(0);
            }
            return w0Var;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    w0 a();
}
