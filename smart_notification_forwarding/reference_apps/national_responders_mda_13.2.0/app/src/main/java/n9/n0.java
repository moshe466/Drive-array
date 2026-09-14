package n9;

import java.util.List;

/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    private final i f12295a;

    /* renamed from: b, reason: collision with root package name */
    private final List<bb.v0> f12296b;

    /* renamed from: c, reason: collision with root package name */
    private final n0 f12297c;

    /* JADX WARN: Multi-variable type inference failed */
    public n0(i iVar, List<? extends bb.v0> list, n0 n0Var) {
        y8.k.e(iVar, "classifierDescriptor");
        y8.k.e(list, "arguments");
        this.f12295a = iVar;
        this.f12296b = list;
        this.f12297c = n0Var;
    }

    public final List<bb.v0> a() {
        return this.f12296b;
    }

    public final i b() {
        return this.f12295a;
    }

    public final n0 c() {
        return this.f12297c;
    }
}
