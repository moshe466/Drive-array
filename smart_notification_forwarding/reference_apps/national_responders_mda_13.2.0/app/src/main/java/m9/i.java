package m9;

import ea.v;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k9.k;
import m8.q;
import m8.s0;
import y8.k;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f12115a;

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f12116b;

    /* renamed from: c, reason: collision with root package name */
    private static final Set<String> f12117c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set<String> f12118d;

    /* renamed from: e, reason: collision with root package name */
    private static final Set<String> f12119e;

    /* renamed from: f, reason: collision with root package name */
    private static final Set<String> f12120f;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<String> f12121g;

    static {
        Set<String> h10;
        Set g10;
        Set g11;
        Set g12;
        Set g13;
        Set g14;
        Set<String> g15;
        Set g16;
        Set g17;
        Set g18;
        Set g19;
        Set g20;
        Set<String> g21;
        Set g22;
        Set<String> g23;
        Set g24;
        Set<String> g25;
        i iVar = new i();
        f12115a = iVar;
        v vVar = v.f9330a;
        h10 = s0.h(vVar.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f12116b = h10;
        g10 = s0.g(iVar.b(), vVar.f("List", "sort(Ljava/util/Comparator;)V"));
        g11 = s0.g(g10, vVar.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"));
        g12 = s0.g(g11, vVar.e("Double", "isInfinite()Z", "isNaN()Z"));
        g13 = s0.g(g12, vVar.e("Float", "isInfinite()Z", "isNaN()Z"));
        g14 = s0.g(g13, vVar.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
        g15 = s0.g(g14, vVar.e("CharSequence", "isEmpty()Z"));
        f12117c = g15;
        g16 = s0.g(vVar.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), vVar.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V"));
        g17 = s0.g(g16, vVar.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"));
        g18 = s0.g(g17, vVar.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"));
        g19 = s0.g(g18, vVar.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"));
        g20 = s0.g(g19, vVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V"));
        g21 = s0.g(g20, vVar.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f12118d = g21;
        g22 = s0.g(vVar.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), vVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"));
        g23 = s0.g(g22, vVar.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        f12119e = g23;
        Set<String> a10 = iVar.a();
        String[] b10 = vVar.b("D");
        String[] strArr = new String[b10.length];
        System.arraycopy(b10, 0, strArr, 0, b10.length);
        g24 = s0.g(a10, vVar.e("Float", strArr));
        String[] b11 = vVar.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        String[] strArr2 = new String[b11.length];
        System.arraycopy(b11, 0, strArr2, 0, b11.length);
        g25 = s0.g(g24, vVar.e("String", strArr2));
        f12120f = g25;
        String[] b12 = vVar.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        String[] strArr3 = new String[b12.length];
        System.arraycopy(b12, 0, strArr3, 0, b12.length);
        f12121g = vVar.e("Throwable", strArr3);
    }

    private i() {
    }

    private final Set<String> a() {
        List g10;
        v vVar = v.f9330a;
        sa.d dVar = sa.d.BYTE;
        g10 = q.g(sa.d.BOOLEAN, dVar, sa.d.DOUBLE, sa.d.FLOAT, dVar, sa.d.INT, sa.d.LONG, sa.d.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = g10.iterator();
        while (it.hasNext()) {
            String k10 = ((sa.d) it.next()).getWrapperFqName().g().k();
            k.d(k10, "it.wrapperFqName.shortName().asString()");
            String[] b10 = vVar.b("Ljava/lang/String;");
            String[] strArr = new String[b10.length];
            System.arraycopy(b10, 0, strArr, 0, b10.length);
            m8.v.r(linkedHashSet, vVar.e(k10, strArr));
        }
        return linkedHashSet;
    }

    private final Set<String> b() {
        List<sa.d> g10;
        v vVar = v.f9330a;
        g10 = q.g(sa.d.BOOLEAN, sa.d.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (sa.d dVar : g10) {
            String k10 = dVar.getWrapperFqName().g().k();
            k.d(k10, "it.wrapperFqName.shortName().asString()");
            m8.v.r(linkedHashSet, vVar.e(k10, dVar.getJavaKeywordName() + "Value()" + dVar.getDesc()));
        }
        return linkedHashSet;
    }

    public final Set<String> c() {
        return f12116b;
    }

    public final Set<String> d() {
        return f12120f;
    }

    public final Set<String> e() {
        return f12117c;
    }

    public final Set<String> f() {
        return f12119e;
    }

    public final Set<String> g() {
        return f12121g;
    }

    public final Set<String> h() {
        return f12118d;
    }

    public final boolean i(la.c cVar) {
        k.e(cVar, "fqName");
        if (!k.a(cVar, k.a.f11265h)) {
            k9.k kVar = k9.k.f11235a;
            if (!k9.k.e(cVar)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(la.c cVar) {
        y8.k.e(cVar, "fqName");
        if (i(cVar)) {
            return true;
        }
        la.a o10 = c.f12055a.o(cVar);
        if (o10 == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(o10.b().b()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
