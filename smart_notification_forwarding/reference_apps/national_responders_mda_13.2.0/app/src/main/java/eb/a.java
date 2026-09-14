package eb;

import bb.b0;
import bb.c0;
import bb.c1;
import bb.e1;
import bb.g1;
import bb.h1;
import bb.i0;
import bb.n0;
import bb.v;
import bb.v0;
import bb.x0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import m8.r;
import n9.a1;
import n9.h;
import n9.z0;
import y8.k;
import y8.l;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: eb.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0156a extends l implements x8.l<g1, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final C0156a f9347f = new C0156a();

        C0156a() {
            super(1);
        }

        public final boolean a(g1 g1Var) {
            k.e(g1Var, "it");
            h o10 = g1Var.W0().o();
            if (o10 == null) {
                return false;
            }
            return a.h(o10);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(g1 g1Var) {
            return Boolean.valueOf(a(g1Var));
        }
    }

    /* loaded from: classes.dex */
    static final class b extends l implements x8.l<g1, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f9348f = new b();

        b() {
            super(1);
        }

        public final boolean a(g1 g1Var) {
            k.e(g1Var, "it");
            h o10 = g1Var.W0().o();
            if (o10 == null) {
                return false;
            }
            return (o10 instanceof z0) || (o10 instanceof a1);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(g1 g1Var) {
            return Boolean.valueOf(a(g1Var));
        }
    }

    public static final v0 a(b0 b0Var) {
        k.e(b0Var, "<this>");
        return new x0(b0Var);
    }

    public static final boolean b(b0 b0Var, x8.l<? super g1, Boolean> lVar) {
        k.e(b0Var, "<this>");
        k.e(lVar, "predicate");
        return c1.c(b0Var, lVar);
    }

    public static final boolean c(b0 b0Var) {
        k.e(b0Var, "<this>");
        return b(b0Var, C0156a.f9347f);
    }

    public static final v0 d(b0 b0Var, h1 h1Var, a1 a1Var) {
        k.e(b0Var, "type");
        k.e(h1Var, "projectionKind");
        if ((a1Var == null ? null : a1Var.v()) == h1Var) {
            h1Var = h1.INVARIANT;
        }
        return new x0(h1Var, b0Var);
    }

    public static final k9.h e(b0 b0Var) {
        k.e(b0Var, "<this>");
        k9.h w10 = b0Var.W0().w();
        k.d(w10, "constructor.builtIns");
        return w10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        r3 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final bb.b0 f(n9.a1 r7) {
        /*
            java.lang.String r0 = "<this>"
            y8.k.e(r7, r0)
            java.util.List r0 = r7.getUpperBounds()
            java.lang.String r1 = "upperBounds"
            y8.k.d(r0, r1)
            r0.isEmpty()
            java.util.List r0 = r7.getUpperBounds()
            y8.k.d(r0, r1)
            java.util.Iterator r0 = r0.iterator()
        L1c:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L51
            java.lang.Object r2 = r0.next()
            r4 = r2
            bb.b0 r4 = (bb.b0) r4
            bb.t0 r4 = r4.W0()
            n9.h r4 = r4.o()
            boolean r5 = r4 instanceof n9.e
            if (r5 == 0) goto L39
            r3 = r4
            n9.e r3 = (n9.e) r3
        L39:
            r4 = 0
            if (r3 != 0) goto L3d
            goto L4e
        L3d:
            n9.f r5 = r3.r()
            n9.f r6 = n9.f.INTERFACE
            if (r5 == r6) goto L4e
            n9.f r3 = r3.r()
            n9.f r5 = n9.f.ANNOTATION_CLASS
            if (r3 == r5) goto L4e
            r4 = 1
        L4e:
            if (r4 == 0) goto L1c
            r3 = r2
        L51:
            bb.b0 r3 = (bb.b0) r3
            if (r3 != 0) goto L68
            java.util.List r7 = r7.getUpperBounds()
            y8.k.d(r7, r1)
            java.lang.Object r7 = m8.o.H(r7)
            java.lang.String r0 = "upperBounds.first()"
            y8.k.d(r7, r0)
            r3 = r7
            bb.b0 r3 = (bb.b0) r3
        L68:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: eb.a.f(n9.a1):bb.b0");
    }

    public static final boolean g(b0 b0Var, b0 b0Var2) {
        k.e(b0Var, "<this>");
        k.e(b0Var2, "superType");
        return f.f11565a.b(b0Var, b0Var2);
    }

    public static final boolean h(h hVar) {
        k.e(hVar, "<this>");
        return (hVar instanceof a1) && (((a1) hVar).d() instanceof z0);
    }

    public static final boolean i(b0 b0Var) {
        k.e(b0Var, "<this>");
        return c1.m(b0Var);
    }

    public static final b0 j(b0 b0Var) {
        k.e(b0Var, "<this>");
        b0 n10 = c1.n(b0Var);
        k.d(n10, "makeNotNullable(this)");
        return n10;
    }

    public static final b0 k(b0 b0Var) {
        k.e(b0Var, "<this>");
        b0 o10 = c1.o(b0Var);
        k.d(o10, "makeNullable(this)");
        return o10;
    }

    public static final b0 l(b0 b0Var, g gVar) {
        k.e(b0Var, "<this>");
        k.e(gVar, "newAnnotations");
        return (b0Var.u().isEmpty() && gVar.isEmpty()) ? b0Var : b0Var.Z0().c1(gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [bb.g1] */
    public static final b0 m(b0 b0Var) {
        int n10;
        i0 i0Var;
        int n11;
        int n12;
        k.e(b0Var, "<this>");
        g1 Z0 = b0Var.Z0();
        if (Z0 instanceof v) {
            c0 c0Var = c0.f4165a;
            v vVar = (v) Z0;
            i0 e12 = vVar.e1();
            if (!e12.W0().B().isEmpty() && e12.W0().o() != null) {
                List<a1> B = e12.W0().B();
                k.d(B, "constructor.parameters");
                n12 = r.n(B, 10);
                ArrayList arrayList = new ArrayList(n12);
                Iterator it = B.iterator();
                while (it.hasNext()) {
                    arrayList.add(new n0((a1) it.next()));
                }
                e12 = bb.z0.f(e12, arrayList, null, 2, null);
            }
            i0 f12 = vVar.f1();
            if (!f12.W0().B().isEmpty() && f12.W0().o() != null) {
                List<a1> B2 = f12.W0().B();
                k.d(B2, "constructor.parameters");
                n11 = r.n(B2, 10);
                ArrayList arrayList2 = new ArrayList(n11);
                Iterator it2 = B2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new n0((a1) it2.next()));
                }
                f12 = bb.z0.f(f12, arrayList2, null, 2, null);
            }
            i0Var = c0.d(e12, f12);
        } else {
            if (!(Z0 instanceof i0)) {
                throw new l8.l();
            }
            i0 i0Var2 = (i0) Z0;
            boolean isEmpty = i0Var2.W0().B().isEmpty();
            i0Var = i0Var2;
            if (!isEmpty) {
                h o10 = i0Var2.W0().o();
                i0Var = i0Var2;
                if (o10 != null) {
                    List<a1> B3 = i0Var2.W0().B();
                    k.d(B3, "constructor.parameters");
                    n10 = r.n(B3, 10);
                    ArrayList arrayList3 = new ArrayList(n10);
                    Iterator it3 = B3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new n0((a1) it3.next()));
                    }
                    i0Var = bb.z0.f(i0Var2, arrayList3, null, 2, null);
                }
            }
        }
        return e1.b(i0Var, Z0);
    }

    public static final boolean n(b0 b0Var) {
        k.e(b0Var, "<this>");
        return b(b0Var, b.f9348f);
    }
}
