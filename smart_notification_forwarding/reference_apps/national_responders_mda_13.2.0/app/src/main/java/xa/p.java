package xa;

import java.util.List;

/* loaded from: classes.dex */
public interface p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f15625a = new a();

    /* loaded from: classes.dex */
    static class a implements p {
        a() {
        }

        private static /* synthetic */ void c(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i10 != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // xa.p
        public void a(n9.b bVar) {
            if (bVar == null) {
                c(2);
            }
        }

        @Override // xa.p
        public void b(n9.e eVar, List<String> list) {
            if (eVar == null) {
                c(0);
            }
            if (list == null) {
                c(1);
            }
        }
    }

    void a(n9.b bVar);

    void b(n9.e eVar, List<String> list);
}
