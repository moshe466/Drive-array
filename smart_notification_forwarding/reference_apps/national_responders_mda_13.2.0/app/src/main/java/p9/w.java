package p9;

import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class w implements v {

    /* renamed from: a, reason: collision with root package name */
    private final List<x> f13303a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<x> f13304b;

    /* renamed from: c, reason: collision with root package name */
    private final List<x> f13305c;

    public w(List<x> list, Set<x> set, List<x> list2, Set<x> set2) {
        y8.k.e(list, "allDependencies");
        y8.k.e(set, "modulesWhoseInternalsAreVisible");
        y8.k.e(list2, "directExpectedByDependencies");
        y8.k.e(set2, "allExpectedByDependencies");
        this.f13303a = list;
        this.f13304b = set;
        this.f13305c = list2;
    }

    @Override // p9.v
    public Set<x> a() {
        return this.f13304b;
    }

    @Override // p9.v
    public List<x> b() {
        return this.f13303a;
    }

    @Override // p9.v
    public List<x> c() {
        return this.f13305c;
    }
}
