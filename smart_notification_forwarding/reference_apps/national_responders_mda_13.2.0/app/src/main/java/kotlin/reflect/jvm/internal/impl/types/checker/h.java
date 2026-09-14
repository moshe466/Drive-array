package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n9.c0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static final c0<o<g>> f11567a = new c0<>("KotlinTypeRefiner");

    public static final c0<o<g>> a() {
        return f11567a;
    }

    public static final List<b0> b(g gVar, Iterable<? extends b0> iterable) {
        int n10;
        y8.k.e(gVar, "<this>");
        y8.k.e(iterable, "types");
        n10 = m8.r.n(iterable, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<? extends b0> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(gVar.g(it.next()));
        }
        return arrayList;
    }
}
