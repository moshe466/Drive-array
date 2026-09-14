package g9;

import e9.c;
import e9.l;
import h9.b0;
import h9.x;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import m8.o;
import n9.e;
import n9.f;
import y8.k;
import y8.w;

/* loaded from: classes.dex */
public final class a {
    public static final e9.b<?> a(c cVar) {
        Object obj;
        e9.b<?> b10;
        k.e(cVar, "$this$jvmErasure");
        if (cVar instanceof e9.b) {
            return (e9.b) cVar;
        }
        if (!(cVar instanceof l)) {
            throw new b0("Cannot calculate JVM erasure for type: " + cVar);
        }
        List<e9.k> upperBounds = ((l) cVar).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            e9.k kVar = (e9.k) next;
            Objects.requireNonNull(kVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            Object o10 = ((x) kVar).e().W0().o();
            e eVar = (e) (o10 instanceof e ? o10 : null);
            if ((eVar == null || eVar.r() == f.INTERFACE || eVar.r() == f.ANNOTATION_CLASS) ? false : true) {
                obj = next;
                break;
            }
        }
        e9.k kVar2 = (e9.k) obj;
        if (kVar2 == null) {
            kVar2 = (e9.k) o.J(upperBounds);
        }
        return (kVar2 == null || (b10 = b(kVar2)) == null) ? w.b(Object.class) : b10;
    }

    public static final e9.b<?> b(e9.k kVar) {
        e9.b<?> a10;
        k.e(kVar, "$this$jvmErasure");
        c a11 = kVar.a();
        if (a11 != null && (a10 = a(a11)) != null) {
            return a10;
        }
        throw new b0("Cannot calculate JVM erasure for type: " + kVar);
    }
}
