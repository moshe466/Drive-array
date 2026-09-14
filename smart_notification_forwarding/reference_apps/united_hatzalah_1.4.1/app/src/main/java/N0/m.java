package N0;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class m extends e {

    /* renamed from: l, reason: collision with root package name */
    public int f1474l;

    /* renamed from: m, reason: collision with root package name */
    public int f1475m;

    /* renamed from: n, reason: collision with root package name */
    public L0.n f1476n;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f1470g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f1471h = new HashMap();
    public final ArrayList i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f1472j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1473k = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f1477o = new ArrayList();
    public final ArrayList p = new ArrayList();

    @Override // N0.e
    public final boolean b() {
        return !this.p.isEmpty();
    }

    @Override // N0.e
    public final boolean c() {
        return !this.f1477o.isEmpty();
    }

    @Override // N0.e
    public final ArrayList d() {
        return this.p;
    }

    @Override // N0.e
    public final ArrayList e() {
        return this.f1477o;
    }

    public final void f(L0.e eVar, Object... objArr) {
        this.p.add(new L0.f(eVar, objArr));
    }

    public final void g(L0.e eVar, Object... objArr) {
        this.f1477o.add(new L0.f(eVar, objArr));
    }
}
