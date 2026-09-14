package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import bb.b0;
import bb.h1;
import bb.i0;
import java.util.List;
import java.util.Map;
import k9.k;
import l8.t;
import m8.l0;
import m8.q;
import n9.d0;
import pa.v;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    private static final la.e f11356a;

    /* renamed from: b */
    private static final la.e f11357b;

    /* renamed from: c */
    private static final la.e f11358c;

    /* renamed from: d */
    private static final la.e f11359d;

    /* renamed from: e */
    private static final la.e f11360e;

    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<d0, b0> {

        /* renamed from: f */
        final /* synthetic */ k9.h f11361f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k9.h hVar) {
            super(1);
            this.f11361f = hVar;
        }

        @Override // x8.l
        /* renamed from: a */
        public final b0 h(d0 d0Var) {
            y8.k.e(d0Var, "module");
            i0 l10 = d0Var.w().l(h1.INVARIANT, this.f11361f.V());
            y8.k.d(l10, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
            return l10;
        }
    }

    static {
        la.e r10 = la.e.r("message");
        y8.k.d(r10, "identifier(\"message\")");
        f11356a = r10;
        la.e r11 = la.e.r("replaceWith");
        y8.k.d(r11, "identifier(\"replaceWith\")");
        f11357b = r11;
        la.e r12 = la.e.r("level");
        y8.k.d(r12, "identifier(\"level\")");
        f11358c = r12;
        la.e r13 = la.e.r("expression");
        y8.k.d(r13, "identifier(\"expression\")");
        f11359d = r13;
        la.e r14 = la.e.r("imports");
        y8.k.d(r14, "identifier(\"imports\")");
        f11360e = r14;
    }

    public static final c a(k9.h hVar, String str, String str2, String str3) {
        List d10;
        Map k10;
        Map k11;
        y8.k.e(hVar, "<this>");
        y8.k.e(str, "message");
        y8.k.e(str2, "replaceWith");
        y8.k.e(str3, "level");
        la.b bVar = k.a.f11289w;
        la.e eVar = f11360e;
        d10 = q.d();
        k10 = l0.k(t.a(f11359d, new v(str2)), t.a(eVar, new pa.b(d10, new a(hVar))));
        j jVar = new j(hVar, bVar, k10);
        la.b bVar2 = k.a.f11287u;
        la.e eVar2 = f11358c;
        la.a m10 = la.a.m(k.a.f11288v);
        y8.k.d(m10, "topLevel(StandardNames.FqNames.deprecationLevel)");
        la.e r10 = la.e.r(str3);
        y8.k.d(r10, "identifier(level)");
        k11 = l0.k(t.a(f11356a, new v(str)), t.a(f11357b, new pa.a(jVar)), t.a(eVar2, new pa.j(m10, r10)));
        return new j(hVar, bVar2, k11);
    }

    public static /* synthetic */ c b(k9.h hVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = "WARNING";
        }
        return a(hVar, str, str2, str3);
    }
}
