package k9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k9.k;
import m8.r;
import m8.y;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f11209a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final Set<la.a> f11210b;

    static {
        int n10;
        List b02;
        List b03;
        List b04;
        Set<i> set = i.NUMBER_TYPES;
        k kVar = k.f11235a;
        n10 = r.n(set, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(k.c((i) it.next()));
        }
        la.b l10 = k.a.f11263g.l();
        y8.k.d(l10, "string.toSafe()");
        b02 = y.b0(arrayList, l10);
        la.b l11 = k.a.f11267i.l();
        y8.k.d(l11, "_boolean.toSafe()");
        b03 = y.b0(b02, l11);
        la.b l12 = k.a.f11284r.l();
        y8.k.d(l12, "_enum.toSafe()");
        b04 = y.b0(b03, l12);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = b04.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(la.a.m((la.b) it2.next()));
        }
        f11210b = linkedHashSet;
    }

    private c() {
    }

    public final Set<la.a> a() {
        return f11210b;
    }

    public final Set<la.a> b() {
        return f11210b;
    }
}
