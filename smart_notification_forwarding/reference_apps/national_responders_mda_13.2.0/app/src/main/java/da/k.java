package da;

import java.util.List;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final s f8811a;

    /* renamed from: b, reason: collision with root package name */
    private final List<s> f8812b;

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public k(s sVar, List<s> list) {
        y8.k.e(list, "parametersInfo");
        this.f8811a = sVar;
        this.f8812b = list;
    }

    public /* synthetic */ k(s sVar, List list, int i10, y8.g gVar) {
        this((i10 & 1) != 0 ? null : sVar, (i10 & 2) != 0 ? m8.q.d() : list);
    }

    public final List<s> a() {
        return this.f8812b;
    }

    public final s b() {
        return this.f8811a;
    }
}
