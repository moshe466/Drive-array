package v9;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k9.k;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f14796a;

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<la.b, la.b> f14797b;

    static {
        o oVar = new o();
        f14796a = oVar;
        f14797b = new HashMap<>();
        oVar.c(k.a.S, oVar.a("java.util.ArrayList", "java.util.LinkedList"));
        oVar.c(k.a.U, oVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        oVar.c(k.a.V, oVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        oVar.c(new la.b("java.util.function.Function"), oVar.a("java.util.function.UnaryOperator"));
        oVar.c(new la.b("java.util.function.BiFunction"), oVar.a("java.util.function.BinaryOperator"));
    }

    private o() {
    }

    private final List<la.b> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new la.b(str));
        }
        return arrayList;
    }

    private final void c(la.b bVar, List<la.b> list) {
        AbstractMap abstractMap = f14797b;
        for (Object obj : list) {
            abstractMap.put(obj, bVar);
        }
    }

    public final la.b b(la.b bVar) {
        y8.k.e(bVar, "classFqName");
        return f14797b.get(bVar);
    }
}
