package gb;

import bb.b0;
import gb.f;
import gb.k;
import gb.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.util.Check;
import m8.o;
import m8.q;
import n9.d1;
import n9.m;
import n9.s0;
import n9.x;

/* loaded from: classes.dex */
public final class i extends gb.a {

    /* renamed from: a, reason: collision with root package name */
    public static final i f10360a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final List<d> f10361b;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l<x, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f10362f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String h(x xVar) {
            Boolean valueOf;
            y8.k.e(xVar, "<this>");
            List<d1> l10 = xVar.l();
            y8.k.d(l10, "valueParameters");
            d1 d1Var = (d1) o.U(l10);
            if (d1Var == null) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(!ra.a.a(d1Var) && d1Var.R() == null);
            }
            boolean a10 = y8.k.a(valueOf, Boolean.TRUE);
            i iVar = i.f10360a;
            if (a10) {
                return null;
            }
            return "last parameter should not have a default value or be a vararg";
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.l<x, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f10363f = new b();

        b() {
            super(1);
        }

        private static final boolean c(m mVar) {
            return (mVar instanceof n9.e) && k9.h.Z((n9.e) mVar);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String h(x xVar) {
            boolean z10;
            y8.k.e(xVar, "<this>");
            i iVar = i.f10360a;
            m d10 = xVar.d();
            y8.k.d(d10, "containingDeclaration");
            boolean z11 = true;
            if (!c(d10)) {
                Collection<? extends x> g10 = xVar.g();
                y8.k.d(g10, "overriddenDescriptors");
                if (!g10.isEmpty()) {
                    Iterator<T> it = g10.iterator();
                    while (it.hasNext()) {
                        m d11 = ((x) it.next()).d();
                        y8.k.d(d11, "it.containingDeclaration");
                        if (c(d11)) {
                            z10 = true;
                            break;
                        }
                    }
                }
                z10 = false;
                if (!z10) {
                    z11 = false;
                }
            }
            if (z11) {
                return null;
            }
            return "must override ''equals()'' in Any";
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.l<x, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f10364f = new c();

        c() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String h(x xVar) {
            boolean g10;
            y8.k.e(xVar, "<this>");
            s0 K = xVar.K();
            if (K == null) {
                K = xVar.U();
            }
            i iVar = i.f10360a;
            boolean z10 = false;
            if (K != null) {
                b0 i10 = xVar.i();
                if (i10 == null) {
                    g10 = false;
                } else {
                    b0 b10 = K.b();
                    y8.k.d(b10, "receiver.type");
                    g10 = eb.a.g(i10, b10);
                }
                if (g10) {
                    z10 = true;
                }
            }
            if (z10) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }

    static {
        List g10;
        List<d> g11;
        la.e eVar = j.f10373i;
        f.b bVar = f.b.f10356b;
        gb.b[] bVarArr = {bVar, new l.a(1)};
        la.e eVar2 = j.f10374j;
        gb.b[] bVarArr2 = {bVar, new l.a(2)};
        la.e eVar3 = j.f10365a;
        h hVar = h.f10358a;
        e eVar4 = e.f10352a;
        la.e eVar5 = j.f10370f;
        l.d dVar = l.d.f10404b;
        k.a aVar = k.a.f10394d;
        la.e eVar6 = j.f10372h;
        l.c cVar = l.c.f10403b;
        g10 = q.g(j.f10378n, j.f10379o);
        g11 = q.g(new d(eVar, bVarArr, (x8.l) null, 4, (y8.g) null), new d(eVar2, (Check[]) bVarArr2, (x8.l<? super x, String>) a.f10362f), new d(eVar3, new gb.b[]{bVar, hVar, new l.a(2), eVar4}, (x8.l) null, 4, (y8.g) null), new d(j.f10366b, new gb.b[]{bVar, hVar, new l.a(3), eVar4}, (x8.l) null, 4, (y8.g) null), new d(j.f10367c, new gb.b[]{bVar, hVar, new l.b(2), eVar4}, (x8.l) null, 4, (y8.g) null), new d(j.f10371g, new gb.b[]{bVar}, (x8.l) null, 4, (y8.g) null), new d(eVar5, new gb.b[]{bVar, dVar, hVar, aVar}, (x8.l) null, 4, (y8.g) null), new d(eVar6, new gb.b[]{bVar, cVar}, (x8.l) null, 4, (y8.g) null), new d(j.f10375k, new gb.b[]{bVar, cVar}, (x8.l) null, 4, (y8.g) null), new d(j.f10376l, new gb.b[]{bVar, cVar, aVar}, (x8.l) null, 4, (y8.g) null), new d(j.f10389y, new gb.b[]{bVar, dVar, hVar}, (x8.l) null, 4, (y8.g) null), new d(j.f10368d, (Check[]) new gb.b[]{f.a.f10355b}, (x8.l<? super x, String>) b.f10363f), new d(j.f10369e, new gb.b[]{bVar, k.b.f10396d, dVar, hVar}, (x8.l) null, 4, (y8.g) null), new d(j.G, new gb.b[]{bVar, dVar, hVar}, (x8.l) null, 4, (y8.g) null), new d(j.F, new gb.b[]{bVar, cVar}, (x8.l) null, 4, (y8.g) null), new d((Collection<la.e>) g10, (Check[]) new gb.b[]{bVar}, (x8.l<? super x, String>) c.f10364f), new d(j.H, new gb.b[]{bVar, k.c.f10398d, dVar, hVar}, (x8.l) null, 4, (y8.g) null), new d(j.f10377m, new gb.b[]{bVar, cVar}, (x8.l) null, 4, (y8.g) null));
        f10361b = g11;
    }

    private i() {
    }

    @Override // gb.a
    public List<d> b() {
        return f10361b;
    }
}
