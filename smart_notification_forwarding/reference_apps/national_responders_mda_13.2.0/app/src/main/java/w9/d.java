package w9;

import bb.b0;
import bb.i0;
import bb.t;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k9.k;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.n;
import m8.l0;
import m8.r;
import m8.r0;
import m8.v;
import n9.d0;
import n9.d1;
import y8.l;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f15316a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, EnumSet<n>> f15317b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, m> f15318c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends l implements x8.l<d0, b0> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f15319f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 h(d0 d0Var) {
            y8.k.e(d0Var, "module");
            d1 b10 = w9.a.b(c.f15310a.d(), d0Var.w().o(k.a.A));
            b0 b11 = b10 == null ? null : b10.b();
            if (b11 != null) {
                return b11;
            }
            i0 j10 = t.j("Error: AnnotationTarget[]");
            y8.k.d(j10, "createErrorType(\"Error: AnnotationTarget[]\")");
            return j10;
        }
    }

    static {
        Map<String, EnumSet<n>> k10;
        Map<String, m> k11;
        k10 = l0.k(l8.t.a("PACKAGE", EnumSet.noneOf(n.class)), l8.t.a("TYPE", EnumSet.of(n.CLASS, n.FILE)), l8.t.a("ANNOTATION_TYPE", EnumSet.of(n.ANNOTATION_CLASS)), l8.t.a("TYPE_PARAMETER", EnumSet.of(n.TYPE_PARAMETER)), l8.t.a("FIELD", EnumSet.of(n.FIELD)), l8.t.a("LOCAL_VARIABLE", EnumSet.of(n.LOCAL_VARIABLE)), l8.t.a("PARAMETER", EnumSet.of(n.VALUE_PARAMETER)), l8.t.a("CONSTRUCTOR", EnumSet.of(n.CONSTRUCTOR)), l8.t.a("METHOD", EnumSet.of(n.FUNCTION, n.PROPERTY_GETTER, n.PROPERTY_SETTER)), l8.t.a("TYPE_USE", EnumSet.of(n.TYPE)));
        f15317b = k10;
        k11 = l0.k(l8.t.a("RUNTIME", m.RUNTIME), l8.t.a("CLASS", m.BINARY), l8.t.a("SOURCE", m.SOURCE));
        f15318c = k11;
    }

    private d() {
    }

    public final pa.g<?> a(ca.b bVar) {
        ca.m mVar = bVar instanceof ca.m ? (ca.m) bVar : null;
        if (mVar == null) {
            return null;
        }
        Map<String, m> map = f15318c;
        la.e a10 = mVar.a();
        m mVar2 = map.get(a10 == null ? null : a10.k());
        if (mVar2 == null) {
            return null;
        }
        la.a m10 = la.a.m(k.a.C);
        y8.k.d(m10, "topLevel(StandardNames.FqNames.annotationRetention)");
        la.e r10 = la.e.r(mVar2.name());
        y8.k.d(r10, "identifier(retention.name)");
        return new pa.j(m10, r10);
    }

    public final Set<n> b(String str) {
        Set<n> b10;
        EnumSet<n> enumSet = f15317b.get(str);
        if (enumSet != null) {
            return enumSet;
        }
        b10 = r0.b();
        return b10;
    }

    public final pa.g<?> c(List<? extends ca.b> list) {
        int n10;
        y8.k.e(list, "arguments");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof ca.m) {
                arrayList.add(obj);
            }
        }
        ArrayList<n> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            la.e a10 = ((ca.m) it.next()).a();
            v.r(arrayList2, b(a10 == null ? null : a10.k()));
        }
        n10 = r.n(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(n10);
        for (n nVar : arrayList2) {
            la.a m10 = la.a.m(k.a.B);
            y8.k.d(m10, "topLevel(StandardNames.FqNames.annotationTarget)");
            la.e r10 = la.e.r(nVar.name());
            y8.k.d(r10, "identifier(kotlinTarget.name)");
            arrayList3.add(new pa.j(m10, r10));
        }
        return new pa.b(arrayList3, a.f15319f);
    }
}
