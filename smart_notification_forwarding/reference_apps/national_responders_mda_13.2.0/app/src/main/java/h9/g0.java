package h9;

import java.util.List;
import n9.d1;
import n9.p0;
import n9.s0;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: b, reason: collision with root package name */
    public static final g0 f10543b = new g0();

    /* renamed from: a, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.renderer.c f10542a = kotlin.reflect.jvm.internal.impl.renderer.c.f11499b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<d1, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f10544f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(d1 d1Var) {
            g0 g0Var = g0.f10543b;
            y8.k.d(d1Var, "it");
            bb.b0 b10 = d1Var.b();
            y8.k.d(b10, "it.type");
            return g0Var.h(b10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.l<d1, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f10545f = new b();

        b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(d1 d1Var) {
            g0 g0Var = g0.f10543b;
            y8.k.d(d1Var, "it");
            bb.b0 b10 = d1Var.b();
            y8.k.d(b10, "it.type");
            return g0Var.h(b10);
        }
    }

    private g0() {
    }

    private final void a(StringBuilder sb2, s0 s0Var) {
        if (s0Var != null) {
            bb.b0 b10 = s0Var.b();
            y8.k.d(b10, "receiver.type");
            sb2.append(h(b10));
            sb2.append(".");
        }
    }

    private final void b(StringBuilder sb2, n9.a aVar) {
        s0 f10 = k0.f(aVar);
        s0 U = aVar.U();
        a(sb2, f10);
        boolean z10 = (f10 == null || U == null) ? false : true;
        if (z10) {
            sb2.append("(");
        }
        a(sb2, U);
        if (z10) {
            sb2.append(")");
        }
    }

    private final String c(n9.a aVar) {
        if (aVar instanceof p0) {
            return g((p0) aVar);
        }
        if (aVar instanceof n9.x) {
            return d((n9.x) aVar);
        }
        throw new IllegalStateException(("Illegal callable: " + aVar).toString());
    }

    public final String d(n9.x xVar) {
        y8.k.e(xVar, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fun ");
        g0 g0Var = f10543b;
        g0Var.b(sb2, xVar);
        kotlin.reflect.jvm.internal.impl.renderer.c cVar = f10542a;
        la.e c10 = xVar.c();
        y8.k.d(c10, "descriptor.name");
        sb2.append(cVar.w(c10, true));
        List<d1> l10 = xVar.l();
        y8.k.d(l10, "descriptor.valueParameters");
        m8.y.O(l10, sb2, ", ", "(", ")", 0, null, a.f10544f, 48, null);
        sb2.append(": ");
        bb.b0 i10 = xVar.i();
        y8.k.b(i10);
        y8.k.d(i10, "descriptor.returnType!!");
        sb2.append(g0Var.h(i10));
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final String e(n9.x xVar) {
        y8.k.e(xVar, "invoke");
        StringBuilder sb2 = new StringBuilder();
        g0 g0Var = f10543b;
        g0Var.b(sb2, xVar);
        List<d1> l10 = xVar.l();
        y8.k.d(l10, "invoke.valueParameters");
        m8.y.O(l10, sb2, ", ", "(", ")", 0, null, b.f10545f, 48, null);
        sb2.append(" -> ");
        bb.b0 i10 = xVar.i();
        y8.k.b(i10);
        y8.k.d(i10, "invoke.returnType!!");
        sb2.append(g0Var.h(i10));
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final String f(q qVar) {
        String str;
        y8.k.e(qVar, "parameter");
        StringBuilder sb2 = new StringBuilder();
        int i10 = f0.f10540a[qVar.f().ordinal()];
        if (i10 == 1) {
            str = "extension receiver parameter";
        } else {
            if (i10 != 2) {
                if (i10 == 3) {
                    str = "parameter #" + qVar.e() + ' ' + qVar.c();
                }
                sb2.append(" of ");
                sb2.append(f10543b.c(qVar.b().p()));
                String sb3 = sb2.toString();
                y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
                return sb3;
            }
            str = "instance parameter";
        }
        sb2.append(str);
        sb2.append(" of ");
        sb2.append(f10543b.c(qVar.b().p()));
        String sb32 = sb2.toString();
        y8.k.d(sb32, "StringBuilder().apply(builderAction).toString()");
        return sb32;
    }

    public final String g(p0 p0Var) {
        y8.k.e(p0Var, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(p0Var.P() ? "var " : "val ");
        g0 g0Var = f10543b;
        g0Var.b(sb2, p0Var);
        kotlin.reflect.jvm.internal.impl.renderer.c cVar = f10542a;
        la.e c10 = p0Var.c();
        y8.k.d(c10, "descriptor.name");
        sb2.append(cVar.w(c10, true));
        sb2.append(": ");
        bb.b0 b10 = p0Var.b();
        y8.k.d(b10, "descriptor.type");
        sb2.append(g0Var.h(b10));
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final String h(bb.b0 b0Var) {
        y8.k.e(b0Var, "type");
        return f10542a.x(b0Var);
    }
}
