package s9;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.util.List;
import n9.h1;
import s9.f;
import s9.t;

/* loaded from: classes.dex */
public abstract class r extends n implements f, t, ca.q {
    @Override // ca.s
    public boolean B() {
        return t.a.c(this);
    }

    @Override // ca.s
    public boolean I() {
        return t.a.b(this);
    }

    @Override // s9.f
    public AnnotatedElement V() {
        return (AnnotatedElement) c0();
    }

    @Override // ca.s
    public boolean Y() {
        return t.a.d(this);
    }

    @Override // ca.d
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public c e(la.b bVar) {
        return f.a.a(this, bVar);
    }

    @Override // ca.d
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public List<c> u() {
        return f.a.b(this);
    }

    @Override // ca.q
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public j T() {
        Class<?> declaringClass = c0().getDeclaringClass();
        y8.k.d(declaringClass, "member.declaringClass");
        return new j(declaringClass);
    }

    @Override // ca.t
    public la.e c() {
        String name = c0().getName();
        la.e r10 = name == null ? null : la.e.r(name);
        if (r10 != null) {
            return r10;
        }
        la.e eVar = la.g.f11860a;
        y8.k.d(eVar, "NO_NAME_PROVIDED");
        return eVar;
    }

    public abstract Member c0();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[LOOP:0: B:10:0x0038->B:19:0x0068, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae A[EDGE_INSN: B:20:0x00ae->B:28:0x00ae BREAK  A[LOOP:0: B:10:0x0038->B:19:0x0068], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<ca.a0> d0(java.lang.reflect.Type[] r13, java.lang.annotation.Annotation[][] r14, boolean r15) {
        /*
            r12 = this;
            java.lang.String r0 = "parameterTypes"
            y8.k.e(r13, r0)
            java.lang.String r0 = "parameterAnnotations"
            y8.k.e(r14, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r13.length
            r0.<init>(r1)
            s9.a r1 = s9.a.f14142a
            java.lang.reflect.Member r2 = r12.c0()
            java.util.List r1 = r1.b(r2)
            r2 = 0
            if (r1 != 0) goto L1f
            r3 = r2
            goto L27
        L1f:
            int r3 = r1.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L27:
            r4 = 0
            if (r3 != 0) goto L2c
            r3 = 0
            goto L32
        L2c:
            int r3 = r3.intValue()
            int r5 = r13.length
            int r3 = r3 - r5
        L32:
            int r5 = r13.length
            int r5 = r5 + (-1)
            if (r5 < 0) goto Lae
            r6 = 0
        L38:
            int r7 = r6 + 1
            s9.w$a r8 = s9.w.f14182a
            r9 = r13[r6]
            s9.w r8 = r8.a(r9)
            if (r1 != 0) goto L46
            r9 = r2
            goto L50
        L46:
            int r9 = r6 + r3
            java.lang.Object r9 = m8.o.K(r1, r9)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L6a
        L50:
            if (r15 == 0) goto L5a
            int r10 = m8.g.s(r13)
            if (r6 != r10) goto L5a
            r10 = 1
            goto L5b
        L5a:
            r10 = 0
        L5b:
            s9.y r11 = new s9.y
            r6 = r14[r6]
            r11.<init>(r8, r6, r9, r10)
            r0.add(r11)
            if (r7 <= r5) goto L68
            goto Lae
        L68:
            r6 = r7
            goto L38
        L6a:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "No parameter with index "
            r13.append(r14)
            r13.append(r6)
            r14 = 43
            r13.append(r14)
            r13.append(r3)
            java.lang.String r14 = " (name="
            r13.append(r14)
            la.e r14 = r12.c()
            r13.append(r14)
            java.lang.String r14 = " type="
            r13.append(r14)
            r13.append(r8)
            java.lang.String r14 = ") in "
            r13.append(r14)
            r13.append(r1)
            java.lang.String r14 = "@ReflectJavaMember"
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r13 = r13.toString()
            r14.<init>(r13)
            throw r14
        Lae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.r.d0(java.lang.reflect.Type[], java.lang.annotation.Annotation[][], boolean):java.util.List");
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && y8.k.a(c0(), ((r) obj).c0());
    }

    @Override // ca.s
    public h1 h() {
        return t.a.a(this);
    }

    public int hashCode() {
        return c0().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + c0();
    }

    @Override // ca.d
    public boolean v() {
        return f.a.c(this);
    }

    @Override // s9.t
    public int y() {
        return c0().getModifiers();
    }
}
