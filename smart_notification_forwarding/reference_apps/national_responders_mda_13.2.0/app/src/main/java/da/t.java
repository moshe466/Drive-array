package da;

import bb.b0;
import java.util.List;
import v9.y;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final b f8848a;

    /* renamed from: b, reason: collision with root package name */
    private static final b f8849b;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8850a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f8851b;

        static {
            int[] iArr = new int[f.valuesCustom().length];
            iArr[f.READ_ONLY.ordinal()] = 1;
            iArr[f.MUTABLE.ordinal()] = 2;
            f8850a = iArr;
            int[] iArr2 = new int[h.valuesCustom().length];
            iArr2[h.NULLABLE.ordinal()] = 1;
            iArr2[h.NOT_NULL.ordinal()] = 2;
            f8851b = iArr2;
        }
    }

    static {
        la.b bVar = y.f14827o;
        y8.k.d(bVar, "ENHANCED_NULLABILITY_ANNOTATION");
        f8848a = new b(bVar);
        la.b bVar2 = y.f14828p;
        y8.k.d(bVar2, "ENHANCED_MUTABILITY_ANNOTATION");
        f8849b = new b(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.g> list) {
        List n02;
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("At least one Annotations object expected".toString());
        }
        if (size == 1) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) m8.o.d0(list);
        }
        n02 = m8.y.n0(list);
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.k((List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.g>) n02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c<n9.h> e(n9.h hVar, e eVar, p pVar) {
        n9.e a10;
        if (q.a(pVar) && (hVar instanceof n9.e)) {
            m9.d dVar = m9.d.f12071a;
            f b10 = eVar.b();
            int i10 = b10 == null ? -1 : a.f8850a[b10.ordinal()];
            if (i10 == 1) {
                if (pVar == p.FLEXIBLE_LOWER) {
                    n9.e eVar2 = (n9.e) hVar;
                    if (dVar.d(eVar2)) {
                        a10 = dVar.a(eVar2);
                        return f(a10);
                    }
                }
                return j(hVar);
            }
            if (i10 == 2 && pVar == p.FLEXIBLE_UPPER) {
                n9.e eVar3 = (n9.e) hVar;
                if (dVar.f(eVar3)) {
                    a10 = dVar.b(eVar3);
                    return f(a10);
                }
            }
            return j(hVar);
        }
        return j(hVar);
    }

    private static final <T> c<T> f(T t10) {
        return new c<>(t10, f8849b);
    }

    private static final <T> c<T> g(T t10) {
        return new c<>(t10, f8848a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c<Boolean> h(b0 b0Var, e eVar, p pVar) {
        Boolean bool;
        if (!q.a(pVar)) {
            return j(Boolean.valueOf(b0Var.X0()));
        }
        h c10 = eVar.c();
        int i10 = c10 == null ? -1 : a.f8851b[c10.ordinal()];
        if (i10 == 1) {
            bool = Boolean.TRUE;
        } else {
            if (i10 != 2) {
                return j(Boolean.valueOf(b0Var.X0()));
            }
            bool = Boolean.FALSE;
        }
        return g(bool);
    }

    public static final boolean i(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        return r.b(kotlin.reflect.jvm.internal.impl.types.checker.p.f11591a, b0Var);
    }

    private static final <T> c<T> j(T t10) {
        return new c<>(t10, null);
    }
}
