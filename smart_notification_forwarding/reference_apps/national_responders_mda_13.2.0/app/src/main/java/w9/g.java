package w9;

import ca.l;
import ca.n;
import ca.q;
import n9.p0;
import n9.u0;

/* loaded from: classes.dex */
public interface g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f15324a = new a();

    /* loaded from: classes.dex */
    static class a implements g {
        a() {
        }

        private static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            switch (i10) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i10) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // w9.g
        public void a(n nVar, p0 p0Var) {
            if (nVar == null) {
                f(5);
            }
            if (p0Var == null) {
                f(6);
            }
        }

        @Override // w9.g
        public void b(q qVar, u0 u0Var) {
            if (qVar == null) {
                f(1);
            }
            if (u0Var == null) {
                f(2);
            }
        }

        @Override // w9.g
        public void c(l lVar, n9.l lVar2) {
            if (lVar == null) {
                f(3);
            }
            if (lVar2 == null) {
                f(4);
            }
        }

        @Override // w9.g
        public n9.e d(la.b bVar) {
            if (bVar != null) {
                return null;
            }
            f(0);
            return null;
        }

        @Override // w9.g
        public void e(ca.g gVar, n9.e eVar) {
            if (gVar == null) {
                f(7);
            }
            if (eVar == null) {
                f(8);
            }
        }
    }

    void a(n nVar, p0 p0Var);

    void b(q qVar, u0 u0Var);

    void c(l lVar, n9.l lVar2);

    n9.e d(la.b bVar);

    void e(ca.g gVar, n9.e eVar);
}
