package ca;

/* loaded from: classes.dex */
public final class p {
    private static final boolean a(r rVar) {
        la.b f10;
        a0 a0Var = (a0) m8.o.f0(rVar.l());
        x b10 = a0Var == null ? null : a0Var.b();
        j jVar = b10 instanceof j ? (j) b10 : null;
        if (jVar == null) {
            return false;
        }
        i a10 = jVar.a();
        return (a10 instanceof g) && (f10 = ((g) a10).f()) != null && y8.k.a(f10.b(), "java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0045, code lost:
    
        return r3.l().isEmpty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r0.equals("toString") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r0.equals("hashCode") == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean b(ca.r r3) {
        /*
            la.e r0 = r3.c()
            java.lang.String r0 = r0.k()
            int r1 = r0.hashCode()
            r2 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r1 == r2) goto L33
            r2 = -1295482945(0xffffffffb2c87fbf, float:-2.3341157E-8)
            if (r1 == r2) goto L25
            r2 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r1 == r2) goto L1c
            goto L3b
        L1c:
            java.lang.String r1 = "hashCode"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
            goto L3b
        L25:
            java.lang.String r1 = "equals"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2e
            goto L3b
        L2e:
            boolean r3 = a(r3)
            goto L45
        L33:
            java.lang.String r1 = "toString"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
        L3b:
            r3 = 0
            goto L45
        L3d:
            java.util.List r3 = r3.l()
            boolean r3 = r3.isEmpty()
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.p.b(ca.r):boolean");
    }

    public static final boolean c(q qVar) {
        y8.k.e(qVar, "<this>");
        return qVar.T().H() && (qVar instanceof r) && b((r) qVar);
    }
}
