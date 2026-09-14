package ea;

import kotlin.reflect.jvm.internal.impl.protobuf.i;
import n9.w0;

/* loaded from: classes.dex */
public final class i implements za.f {

    /* renamed from: b, reason: collision with root package name */
    private final sa.c f9306b;

    /* renamed from: c, reason: collision with root package name */
    private final sa.c f9307c;

    /* renamed from: d, reason: collision with root package name */
    private final o f9308d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i(ea.o r11, ga.l r12, ia.c r13, xa.r<ka.f> r14, boolean r15, za.e r16) {
        /*
            r10 = this;
            java.lang.String r0 = "kotlinClass"
            r9 = r11
            y8.k.e(r11, r0)
            java.lang.String r0 = "packageProto"
            r4 = r12
            y8.k.e(r12, r0)
            java.lang.String r0 = "nameResolver"
            r5 = r13
            y8.k.e(r13, r0)
            java.lang.String r0 = "abiStability"
            r8 = r16
            y8.k.e(r8, r0)
            la.a r0 = r11.d()
            sa.c r2 = sa.c.b(r0)
            java.lang.String r0 = "byClassId(kotlinClass.classId)"
            y8.k.d(r2, r0)
            fa.a r0 = r11.a()
            java.lang.String r0 = r0.e()
            r1 = 0
            if (r0 != 0) goto L33
        L31:
            r3 = r1
            goto L43
        L33:
            int r3 = r0.length()
            if (r3 <= 0) goto L3b
            r3 = 1
            goto L3c
        L3b:
            r3 = 0
        L3c:
            if (r3 == 0) goto L31
            sa.c r1 = sa.c.d(r0)
            goto L31
        L43:
            r1 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.i.<init>(ea.o, ga.l, ia.c, xa.r, boolean, za.e):void");
    }

    public i(sa.c cVar, sa.c cVar2, ga.l lVar, ia.c cVar3, xa.r<ka.f> rVar, boolean z10, za.e eVar, o oVar) {
        y8.k.e(cVar, "className");
        y8.k.e(lVar, "packageProto");
        y8.k.e(cVar3, "nameResolver");
        y8.k.e(eVar, "abiStability");
        this.f9306b = cVar;
        this.f9307c = cVar2;
        this.f9308d = oVar;
        i.f<ga.l, Integer> fVar = ja.a.f10985m;
        y8.k.d(fVar, "packageModuleName");
        Integer num = (Integer) ia.e.a(lVar, fVar);
        if (num == null) {
            return;
        }
        cVar3.a(num.intValue());
    }

    @Override // n9.v0
    public w0 a() {
        w0 w0Var = w0.f12327a;
        y8.k.d(w0Var, "NO_SOURCE_FILE");
        return w0Var;
    }

    @Override // za.f
    public String c() {
        return "Class '" + d().b().b() + '\'';
    }

    public final la.a d() {
        return new la.a(this.f9306b.g(), g());
    }

    public final sa.c e() {
        return this.f9307c;
    }

    public final o f() {
        return this.f9308d;
    }

    public final la.e g() {
        String c02;
        String f10 = this.f9306b.f();
        y8.k.d(f10, "className.internalName");
        c02 = mb.s.c0(f10, '/', null, 2, null);
        la.e r10 = la.e.r(c02);
        y8.k.d(r10, "identifier(className.internalName.substringAfterLast('/'))");
        return r10;
    }

    public String toString() {
        return ((Object) i.class.getSimpleName()) + ": " + this.f9306b;
    }
}
