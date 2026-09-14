package h9;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import n9.s0;
import n9.v0;
import pa.q;
import r9.m;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    private static final la.b f10605a = new la.b("kotlin.jvm.JvmStatic");

    public static final k a(Object obj) {
        k kVar = (k) (!(obj instanceof k) ? null : obj);
        if (kVar != null) {
            return kVar;
        }
        if (!(obj instanceof y8.i)) {
            obj = null;
        }
        y8.i iVar = (y8.i) obj;
        e9.a d10 = iVar != null ? iVar.d() : null;
        return (k) (d10 instanceof k ? d10 : null);
    }

    public static final u<?> b(Object obj) {
        u<?> uVar = (u) (!(obj instanceof u) ? null : obj);
        if (uVar != null) {
            return uVar;
        }
        if (!(obj instanceof y8.u)) {
            obj = null;
        }
        y8.u uVar2 = (y8.u) obj;
        e9.a d10 = uVar2 != null ? uVar2.d() : null;
        return (u) (d10 instanceof u ? d10 : null);
    }

    public static final List<Annotation> c(kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar) {
        y8.k.e(aVar, "$this$computeAnnotations");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = aVar.u();
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : u10) {
            v0 k10 = cVar.k();
            Annotation annotation = null;
            if (k10 instanceof r9.b) {
                annotation = ((r9.b) k10).d();
            } else if (k10 instanceof m.a) {
                s9.n b10 = ((m.a) k10).b();
                if (!(b10 instanceof s9.c)) {
                    b10 = null;
                }
                s9.c cVar2 = (s9.c) b10;
                if (cVar2 != null) {
                    annotation = cVar2.Z();
                }
            } else {
                annotation = k(cVar);
            }
            if (annotation != null) {
                arrayList.add(annotation);
            }
        }
        return arrayList;
    }

    public static final Object d(Type type) {
        y8.k.e(type, "type");
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (y8.k.a(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (y8.k.a(type, Character.TYPE)) {
            return Character.valueOf((char) 0);
        }
        if (y8.k.a(type, Byte.TYPE)) {
            return Byte.valueOf((byte) 0);
        }
        if (y8.k.a(type, Short.TYPE)) {
            return Short.valueOf((short) 0);
        }
        if (y8.k.a(type, Integer.TYPE)) {
            return 0;
        }
        if (y8.k.a(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (y8.k.a(type, Long.TYPE)) {
            return 0L;
        }
        if (y8.k.a(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (y8.k.a(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.q, D extends n9.a> D e(Class<?> cls, M m10, ia.c cVar, ia.g gVar, ia.a aVar, x8.p<? super xa.u, ? super M, ? extends D> pVar) {
        List<ga.s> g02;
        y8.k.e(cls, "moduleAnchor");
        y8.k.e(m10, "proto");
        y8.k.e(cVar, "nameResolver");
        y8.k.e(gVar, "typeTable");
        y8.k.e(aVar, "metadataVersion");
        y8.k.e(pVar, "createDescriptor");
        r9.k a10 = c0.a(cls);
        if (m10 instanceof ga.i) {
            g02 = ((ga.i) m10).f0();
        } else {
            if (!(m10 instanceof ga.n)) {
                throw new IllegalStateException(("Unsupported message: " + m10).toString());
            }
            g02 = ((ga.n) m10).g0();
        }
        List<ga.s> list = g02;
        xa.j a11 = a10.a();
        n9.d0 b10 = a10.b();
        ia.i b11 = ia.i.f10840b.b();
        y8.k.d(list, "typeParameters");
        return pVar.g(new xa.u(new xa.l(a11, cVar, b10, gVar, b11, aVar, null, null, list)), m10);
    }

    public static final s0 f(n9.a aVar) {
        y8.k.e(aVar, "$this$instanceReceiverParameter");
        if (aVar.K() == null) {
            return null;
        }
        n9.m d10 = aVar.d();
        Objects.requireNonNull(d10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((n9.e) d10).T0();
    }

    public static final la.b g() {
        return f10605a;
    }

    private static final Class<?> h(ClassLoader classLoader, String str, String str2, int i10) {
        String t10;
        String q10;
        if (y8.k.a(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append('.');
        t10 = mb.r.t(str2, '.', '$', false, 4, null);
        sb2.append(t10);
        String sb3 = sb2.toString();
        if (i10 > 0) {
            StringBuilder sb4 = new StringBuilder();
            q10 = mb.r.q("[", i10);
            sb4.append(q10);
            sb4.append('L');
            sb4.append(sb3);
            sb4.append(';');
            sb3 = sb4.toString();
        }
        return r9.e.a(classLoader, sb3);
    }

    private static final Class<?> i(ClassLoader classLoader, la.a aVar, int i10) {
        m9.c cVar = m9.c.f12055a;
        la.c j10 = aVar.b().j();
        y8.k.d(j10, "kotlinClassId.asSingleFqName().toUnsafe()");
        la.a o10 = cVar.o(j10);
        if (o10 != null) {
            aVar = o10;
        }
        String b10 = aVar.h().b();
        y8.k.d(b10, "javaClassId.packageFqName.asString()");
        String b11 = aVar.i().b();
        y8.k.d(b11, "javaClassId.relativeClassName.asString()");
        return h(classLoader, b10, b11, i10);
    }

    static /* synthetic */ Class j(ClassLoader classLoader, la.a aVar, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return i(classLoader, aVar, i10);
    }

    private static final Annotation k(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        Map p10;
        n9.e f10 = ra.a.f(cVar);
        Class<?> l10 = f10 != null ? l(f10) : null;
        if (!(l10 instanceof Class)) {
            l10 = null;
        }
        if (l10 == null) {
            return null;
        }
        Set<Map.Entry<la.e, pa.g<?>>> entrySet = cVar.a().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            la.e eVar = (la.e) entry.getKey();
            pa.g gVar = (pa.g) entry.getValue();
            ClassLoader classLoader = l10.getClassLoader();
            y8.k.d(classLoader, "annotationClass.classLoader");
            Object m10 = m(gVar, classLoader);
            l8.n a10 = m10 != null ? l8.t.a(eVar.k(), m10) : null;
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        p10 = m8.l0.p(arrayList);
        return (Annotation) i9.b.d(l10, p10, null, 4, null);
    }

    public static final Class<?> l(n9.e eVar) {
        y8.k.e(eVar, "$this$toJavaClass");
        v0 k10 = eVar.k();
        y8.k.d(k10, "source");
        if (k10 instanceof ea.q) {
            ea.o d10 = ((ea.q) k10).d();
            Objects.requireNonNull(d10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((r9.f) d10).e();
        }
        if (k10 instanceof m.a) {
            s9.n b10 = ((m.a) k10).b();
            Objects.requireNonNull(b10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((s9.j) b10).V();
        }
        la.a h10 = ra.a.h(eVar);
        if (h10 != null) {
            return i(s9.b.f(eVar.getClass()), h10, 0);
        }
        return null;
    }

    private static final Object m(pa.g<?> gVar, ClassLoader classLoader) {
        int n10;
        if (gVar instanceof pa.a) {
            return k(((pa.a) gVar).b());
        }
        if (gVar instanceof pa.b) {
            List<? extends pa.g<?>> b10 = ((pa.b) gVar).b();
            n10 = m8.r.n(b10, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = b10.iterator();
            while (it.hasNext()) {
                arrayList.add(m((pa.g) it.next(), classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return array;
        }
        if (gVar instanceof pa.j) {
            l8.n<? extends la.a, ? extends la.e> b11 = ((pa.j) gVar).b();
            la.a a10 = b11.a();
            la.e b12 = b11.b();
            Class j10 = j(classLoader, a10, 0, 4, null);
            if (j10 != null) {
                return j0.a(j10, b12.k());
            }
            return null;
        }
        if (!(gVar instanceof pa.q)) {
            if ((gVar instanceof pa.k) || (gVar instanceof pa.s)) {
                return null;
            }
            return gVar.b();
        }
        q.b b13 = ((pa.q) gVar).b();
        if (b13 instanceof q.b.C0277b) {
            q.b.C0277b c0277b = (q.b.C0277b) b13;
            return i(classLoader, c0277b.b(), c0277b.a());
        }
        if (!(b13 instanceof q.b.a)) {
            throw new l8.l();
        }
        n9.h o10 = ((q.b.a) b13).a().W0().o();
        if (!(o10 instanceof n9.e)) {
            o10 = null;
        }
        n9.e eVar = (n9.e) o10;
        if (eVar != null) {
            return l(eVar);
        }
        return null;
    }
}
