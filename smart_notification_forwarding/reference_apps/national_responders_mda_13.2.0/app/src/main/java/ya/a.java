package ya;

import mb.r;
import y8.k;

/* loaded from: classes.dex */
public final class a extends wa.a {

    /* renamed from: m, reason: collision with root package name */
    public static final a f16003m = new a();

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private a() {
        /*
            r14 = this;
            kotlin.reflect.jvm.internal.impl.protobuf.g r1 = kotlin.reflect.jvm.internal.impl.protobuf.g.d()
            ha.b.a(r1)
            l8.w r0 = l8.w.f11824a
            java.lang.String r0 = "newInstance().apply(BuiltInsProtoBuf::registerAllExtensions)"
            y8.k.d(r1, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.l, java.lang.Integer> r2 = ha.b.f10699a
            java.lang.String r0 = "packageFqName"
            y8.k.d(r2, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.d, java.util.List<ga.b>> r3 = ha.b.f10701c
            java.lang.String r0 = "constructorAnnotation"
            y8.k.d(r3, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.c, java.util.List<ga.b>> r4 = ha.b.f10700b
            java.lang.String r0 = "classAnnotation"
            y8.k.d(r4, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.i, java.util.List<ga.b>> r5 = ha.b.f10702d
            java.lang.String r0 = "functionAnnotation"
            y8.k.d(r5, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.n, java.util.List<ga.b>> r6 = ha.b.f10703e
            java.lang.String r0 = "propertyAnnotation"
            y8.k.d(r6, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.n, java.util.List<ga.b>> r7 = ha.b.f10704f
            java.lang.String r0 = "propertyGetterAnnotation"
            y8.k.d(r7, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.n, java.util.List<ga.b>> r8 = ha.b.f10705g
            java.lang.String r0 = "propertySetterAnnotation"
            y8.k.d(r8, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.g, java.util.List<ga.b>> r9 = ha.b.f10707i
            java.lang.String r0 = "enumEntryAnnotation"
            y8.k.d(r9, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.n, ga.b$b$c> r10 = ha.b.f10706h
            java.lang.String r0 = "compileTimeValue"
            y8.k.d(r10, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.u, java.util.List<ga.b>> r11 = ha.b.f10708j
            java.lang.String r0 = "parameterAnnotation"
            y8.k.d(r11, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.q, java.util.List<ga.b>> r12 = ha.b.f10709k
            java.lang.String r0 = "typeAnnotation"
            y8.k.d(r12, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.i$f<ga.s, java.util.List<ga.b>> r13 = ha.b.f10710l
            java.lang.String r0 = "typeParameterAnnotation"
            y8.k.d(r13, r0)
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.a.<init>():void");
    }

    private final String o(la.b bVar) {
        if (bVar.d()) {
            return "default-package";
        }
        String k10 = bVar.g().k();
        k.d(k10, "fqName.shortName().asString()");
        return k10;
    }

    public final String m(la.b bVar) {
        k.e(bVar, "fqName");
        return k.j(o(bVar), ".kotlin_builtins");
    }

    public final String n(la.b bVar) {
        String t10;
        k.e(bVar, "fqName");
        StringBuilder sb2 = new StringBuilder();
        String b10 = bVar.b();
        k.d(b10, "fqName.asString()");
        t10 = r.t(b10, '.', '/', false, 4, null);
        sb2.append(t10);
        sb2.append('/');
        sb2.append(m(bVar));
        return sb2.toString();
    }
}
