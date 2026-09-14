package n9;

import java.util.List;

/* loaded from: classes.dex */
public final class w {

    /* loaded from: classes.dex */
    /* synthetic */ class a extends y8.i implements x8.l<la.a, la.a> {

        /* renamed from: o, reason: collision with root package name */
        public static final a f12325o = new a();

        a() {
            super(1);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "getOuterClassId";
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(la.a.class);
        }

        @Override // y8.c
        public final String m() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final la.a h(la.a aVar) {
            y8.k.e(aVar, "p0");
            return aVar.g();
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.l<la.a, Integer> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f12326f = new b();

        b() {
            super(1);
        }

        public final int a(la.a aVar) {
            y8.k.e(aVar, "it");
            return 0;
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Integer h(la.a aVar) {
            return Integer.valueOf(a(aVar));
        }
    }

    public static final e a(d0 d0Var, la.a aVar) {
        y8.k.e(d0Var, "<this>");
        y8.k.e(aVar, "classId");
        h b10 = b(d0Var, aVar);
        if (b10 instanceof e) {
            return (e) b10;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final n9.h b(n9.d0 r10, la.a r11) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n9.w.b(n9.d0, la.a):n9.h");
    }

    public static final e c(d0 d0Var, la.a aVar, f0 f0Var) {
        lb.h f10;
        lb.h q10;
        List<Integer> w10;
        y8.k.e(d0Var, "<this>");
        y8.k.e(aVar, "classId");
        y8.k.e(f0Var, "notFoundClasses");
        e a10 = a(d0Var, aVar);
        if (a10 != null) {
            return a10;
        }
        f10 = lb.l.f(aVar, a.f12325o);
        q10 = lb.n.q(f10, b.f12326f);
        w10 = lb.n.w(q10);
        return f0Var.d(aVar, w10);
    }

    public static final z0 d(d0 d0Var, la.a aVar) {
        y8.k.e(d0Var, "<this>");
        y8.k.e(aVar, "classId");
        h b10 = b(d0Var, aVar);
        if (b10 instanceof z0) {
            return (z0) b10;
        }
        return null;
    }
}
