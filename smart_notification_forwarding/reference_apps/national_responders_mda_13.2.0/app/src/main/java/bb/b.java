package bb;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b extends g {

    /* renamed from: c, reason: collision with root package name */
    private int f4162c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ab.n nVar) {
        super(nVar);
        if (nVar == null) {
            m(0);
        }
        this.f4162c = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void m(int r9) {
        /*
            r0 = 4
            r1 = 3
            r2 = 1
            if (r9 == r2) goto Lc
            if (r9 == r1) goto Lc
            if (r9 == r0) goto Lc
            java.lang.String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Le
        Lc:
            java.lang.String r3 = "@NotNull method %s.%s must not return null"
        Le:
            r4 = 2
            if (r9 == r2) goto L17
            if (r9 == r1) goto L17
            if (r9 == r0) goto L17
            r5 = 3
            goto L18
        L17:
            r5 = 2
        L18:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor"
            r7 = 0
            if (r9 == r2) goto L2f
            if (r9 == r4) goto L2a
            if (r9 == r1) goto L2f
            if (r9 == r0) goto L2f
            java.lang.String r8 = "storageManager"
            r5[r7] = r8
            goto L31
        L2a:
            java.lang.String r8 = "descriptor"
            r5[r7] = r8
            goto L31
        L2f:
            r5[r7] = r6
        L31:
            if (r9 == r2) goto L3f
            if (r9 == r1) goto L3a
            if (r9 == r0) goto L3a
            r5[r2] = r6
            goto L43
        L3a:
            java.lang.String r6 = "getAdditionalNeighboursInSupertypeGraph"
            r5[r2] = r6
            goto L43
        L3f:
            java.lang.String r6 = "getBuiltIns"
            r5[r2] = r6
        L43:
            if (r9 == r2) goto L54
            if (r9 == r4) goto L50
            if (r9 == r1) goto L54
            if (r9 == r0) goto L54
            java.lang.String r6 = "<init>"
            r5[r4] = r6
            goto L54
        L50:
            java.lang.String r6 = "hasMeaningfulFqName"
            r5[r4] = r6
        L54:
            java.lang.String r3 = java.lang.String.format(r3, r5)
            if (r9 == r2) goto L64
            if (r9 == r1) goto L64
            if (r9 == r0) goto L64
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r3)
            goto L69
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.b.m(int):void");
    }

    private static boolean n(n9.e eVar, n9.e eVar2) {
        if (!eVar.c().equals(eVar2.c())) {
            return false;
        }
        n9.m d10 = eVar.d();
        for (n9.m d11 = eVar2.d(); d10 != null && d11 != null; d11 = d11.d()) {
            if (d10 instanceof n9.d0) {
                return d11 instanceof n9.d0;
            }
            if (d11 instanceof n9.d0) {
                return false;
            }
            if (d10 instanceof n9.g0) {
                return (d11 instanceof n9.g0) && ((n9.g0) d10).f().equals(((n9.g0) d11).f());
            }
            if ((d11 instanceof n9.g0) || !d10.c().equals(d11.c())) {
                return false;
            }
            d10 = d10.d();
        }
        return true;
    }

    private static boolean p(n9.h hVar) {
        if (hVar == null) {
            m(2);
        }
        return (t.r(hVar) || na.d.E(hVar)) ? false : true;
    }

    @Override // bb.g
    protected b0 e() {
        if (k9.h.B0(o())) {
            return null;
        }
        return w().i();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0) || obj.hashCode() != hashCode()) {
            return false;
        }
        t0 t0Var = (t0) obj;
        if (t0Var.B().size() != B().size()) {
            return false;
        }
        n9.e o10 = o();
        n9.h o11 = t0Var.o();
        if (p(o10) && ((o11 == null || p(o11)) && (o11 instanceof n9.e))) {
            return n(o10, (n9.e) o11);
        }
        return false;
    }

    @Override // bb.g
    protected Collection<b0> f(boolean z10) {
        n9.m d10 = o().d();
        if (!(d10 instanceof n9.e)) {
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                m(3);
            }
            return emptyList;
        }
        jb.i iVar = new jb.i();
        n9.e eVar = (n9.e) d10;
        iVar.add(eVar.s());
        n9.e A0 = eVar.A0();
        if (z10 && A0 != null) {
            iVar.add(A0.s());
        }
        return iVar;
    }

    public final int hashCode() {
        int i10 = this.f4162c;
        if (i10 != 0) {
            return i10;
        }
        n9.e o10 = o();
        int hashCode = p(o10) ? na.d.m(o10).hashCode() : System.identityHashCode(this);
        this.f4162c = hashCode;
        return hashCode;
    }

    public abstract n9.e o();

    @Override // bb.t0
    public k9.h w() {
        k9.h g10 = ra.a.g(o());
        if (g10 == null) {
            m(1);
        }
        return g10;
    }
}
