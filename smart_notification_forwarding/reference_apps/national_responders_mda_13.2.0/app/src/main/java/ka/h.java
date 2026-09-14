package ka;

import ga.l;
import ga.n;
import ga.q;
import ga.u;
import ia.b;
import ja.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ka.e;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import m8.r;
import m8.y;
import y8.k;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a */
    public static final h f11321a = new h();

    /* renamed from: b */
    private static final kotlin.reflect.jvm.internal.impl.protobuf.g f11322b;

    static {
        kotlin.reflect.jvm.internal.impl.protobuf.g d10 = kotlin.reflect.jvm.internal.impl.protobuf.g.d();
        ja.a.a(d10);
        k.d(d10, "newInstance().apply(JvmProtoBuf::registerAllExtensions)");
        f11322b = d10;
    }

    private h() {
    }

    public static /* synthetic */ e.a d(h hVar, n nVar, ia.c cVar, ia.g gVar, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return hVar.c(nVar, cVar, gVar, z10);
    }

    public static final boolean f(n nVar) {
        k.e(nVar, "proto");
        b.C0207b a10 = d.f11304a.a();
        Object v10 = nVar.v(ja.a.f10977e);
        k.d(v10, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean d10 = a10.d(((Number) v10).intValue());
        k.d(d10, "JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION.get(proto.getExtension(JvmProtoBuf.flags))");
        return d10.booleanValue();
    }

    private final String g(q qVar, ia.c cVar) {
        if (!qVar.n0()) {
            return null;
        }
        b bVar = b.f11300a;
        return b.b(cVar.c(qVar.Y()));
    }

    public static final l8.n<g, ga.c> h(byte[] bArr, String[] strArr) {
        k.e(bArr, "bytes");
        k.e(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new l8.n<>(f11321a.k(byteArrayInputStream, strArr), ga.c.U0(byteArrayInputStream, f11322b));
    }

    public static final l8.n<g, ga.c> i(String[] strArr, String[] strArr2) {
        k.e(strArr, "data");
        k.e(strArr2, "strings");
        byte[] e10 = a.e(strArr);
        k.d(e10, "decodeBytes(data)");
        return h(e10, strArr2);
    }

    public static final l8.n<g, ga.i> j(String[] strArr, String[] strArr2) {
        k.e(strArr, "data");
        k.e(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.e(strArr));
        return new l8.n<>(f11321a.k(byteArrayInputStream, strArr2), ga.i.y0(byteArrayInputStream, f11322b));
    }

    private final g k(InputStream inputStream, String[] strArr) {
        a.e F = a.e.F(inputStream, f11322b);
        k.d(F, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new g(F, strArr);
    }

    public static final l8.n<g, l> l(byte[] bArr, String[] strArr) {
        k.e(bArr, "bytes");
        k.e(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new l8.n<>(f11321a.k(byteArrayInputStream, strArr), l.f0(byteArrayInputStream, f11322b));
    }

    public static final l8.n<g, l> m(String[] strArr, String[] strArr2) {
        k.e(strArr, "data");
        k.e(strArr2, "strings");
        byte[] e10 = a.e(strArr);
        k.d(e10, "decodeBytes(data)");
        return l(e10, strArr2);
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.g a() {
        return f11322b;
    }

    public final e.b b(ga.d dVar, ia.c cVar, ia.g gVar) {
        int n10;
        String Q;
        k.e(dVar, "proto");
        k.e(cVar, "nameResolver");
        k.e(gVar, "typeTable");
        i.f<ga.d, a.c> fVar = ja.a.f10973a;
        k.d(fVar, "constructorSignature");
        a.c cVar2 = (a.c) ia.e.a(dVar, fVar);
        String a10 = (cVar2 == null || !cVar2.A()) ? "<init>" : cVar.a(cVar2.y());
        if (cVar2 == null || !cVar2.z()) {
            List<u> O = dVar.O();
            k.d(O, "proto.valueParameterList");
            n10 = r.n(O, 10);
            ArrayList arrayList = new ArrayList(n10);
            for (u uVar : O) {
                k.d(uVar, "it");
                String g10 = g(ia.f.m(uVar, gVar), cVar);
                if (g10 == null) {
                    return null;
                }
                arrayList.add(g10);
            }
            Q = y.Q(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            Q = cVar.a(cVar2.x());
        }
        return new e.b(a10, Q);
    }

    public final e.a c(n nVar, ia.c cVar, ia.g gVar, boolean z10) {
        String g10;
        k.e(nVar, "proto");
        k.e(cVar, "nameResolver");
        k.e(gVar, "typeTable");
        i.f<n, a.d> fVar = ja.a.f10976d;
        k.d(fVar, "propertySignature");
        a.d dVar = (a.d) ia.e.a(nVar, fVar);
        if (dVar == null) {
            return null;
        }
        a.b z11 = dVar.E() ? dVar.z() : null;
        if (z11 == null && z10) {
            return null;
        }
        int W = (z11 == null || !z11.A()) ? nVar.W() : z11.y();
        if (z11 == null || !z11.z()) {
            g10 = g(ia.f.j(nVar, gVar), cVar);
            if (g10 == null) {
                return null;
            }
        } else {
            g10 = cVar.a(z11.x());
        }
        return new e.a(cVar.a(W), g10);
    }

    public final e.b e(ga.i iVar, ia.c cVar, ia.g gVar) {
        List h10;
        int n10;
        List a02;
        int n11;
        String Q;
        String j10;
        k.e(iVar, "proto");
        k.e(cVar, "nameResolver");
        k.e(gVar, "typeTable");
        i.f<ga.i, a.c> fVar = ja.a.f10974b;
        k.d(fVar, "methodSignature");
        a.c cVar2 = (a.c) ia.e.a(iVar, fVar);
        int X = (cVar2 == null || !cVar2.A()) ? iVar.X() : cVar2.y();
        if (cVar2 == null || !cVar2.z()) {
            h10 = m8.q.h(ia.f.g(iVar, gVar));
            List<u> j02 = iVar.j0();
            k.d(j02, "proto.valueParameterList");
            n10 = r.n(j02, 10);
            ArrayList arrayList = new ArrayList(n10);
            for (u uVar : j02) {
                k.d(uVar, "it");
                arrayList.add(ia.f.m(uVar, gVar));
            }
            a02 = y.a0(h10, arrayList);
            n11 = r.n(a02, 10);
            ArrayList arrayList2 = new ArrayList(n11);
            Iterator it = a02.iterator();
            while (it.hasNext()) {
                String g10 = g((q) it.next(), cVar);
                if (g10 == null) {
                    return null;
                }
                arrayList2.add(g10);
            }
            String g11 = g(ia.f.i(iVar, gVar), cVar);
            if (g11 == null) {
                return null;
            }
            Q = y.Q(arrayList2, "", "(", ")", 0, null, null, 56, null);
            j10 = k.j(Q, g11);
        } else {
            j10 = cVar.a(cVar2.x());
        }
        return new e.b(cVar.a(X), j10);
    }
}
