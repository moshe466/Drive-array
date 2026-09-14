package j9;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import la.b;
import m8.q;
import v9.y;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10971a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final Set<la.a> f10972b;

    static {
        List g10;
        g10 = q.g(y.f14813a, y.f14820h, y.f14821i, y.f14815c, y.f14816d, y.f14818f);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = g10.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(la.a.m((b) it.next()));
        }
        f10972b = linkedHashSet;
    }

    private a() {
    }

    public final Set<la.a> a() {
        return f10972b;
    }
}
