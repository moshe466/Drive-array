package w9;

import ab.m;
import bb.i0;
import java.util.Collection;
import java.util.Map;
import kotlin.reflect.KProperty;
import m8.l0;
import m8.o;
import n9.v0;
import y8.l;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public class b implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, x9.i {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f15302f = {w.g(new t(w.b(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};

    /* renamed from: a, reason: collision with root package name */
    private final la.b f15303a;

    /* renamed from: b, reason: collision with root package name */
    private final v0 f15304b;

    /* renamed from: c, reason: collision with root package name */
    private final ab.i f15305c;

    /* renamed from: d, reason: collision with root package name */
    private final ca.b f15306d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f15307e;

    /* loaded from: classes.dex */
    static final class a extends l implements x8.a<i0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ y9.g f15308f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f15309g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(y9.g gVar, b bVar) {
            super(0);
            this.f15308f = gVar;
            this.f15309g = bVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 b() {
            i0 s10 = this.f15308f.d().w().o(this.f15309g.f()).s();
            y8.k.d(s10, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
            return s10;
        }
    }

    public b(y9.g gVar, ca.a aVar, la.b bVar) {
        Collection<ca.b> G;
        y8.k.e(gVar, "c");
        y8.k.e(bVar, "fqName");
        this.f15303a = bVar;
        v0 a10 = aVar == null ? null : gVar.a().s().a(aVar);
        if (a10 == null) {
            a10 = v0.f12324a;
            y8.k.d(a10, "NO_SOURCE");
        }
        this.f15304b = a10;
        this.f15305c = gVar.e().a(new a(gVar, this));
        this.f15306d = (aVar == null || (G = aVar.G()) == null) ? null : (ca.b) o.I(G);
        this.f15307e = y8.k.a(aVar != null ? Boolean.valueOf(aVar.j()) : null, Boolean.TRUE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<la.e, pa.g<?>> a() {
        Map<la.e, pa.g<?>> h10;
        h10 = l0.h();
        return h10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ca.b c() {
        return this.f15306d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public i0 b() {
        return (i0) m.a(this.f15305c, this, f15302f[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public la.b f() {
        return this.f15303a;
    }

    @Override // x9.i
    public boolean j() {
        return this.f15307e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public v0 k() {
        return this.f15304b;
    }
}
