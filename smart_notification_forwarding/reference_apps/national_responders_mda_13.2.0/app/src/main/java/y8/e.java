package y8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import m8.k0;
import m8.l0;

/* loaded from: classes.dex */
public final class e implements e9.b<Object>, d {

    /* renamed from: g, reason: collision with root package name */
    public static final a f15940g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Map<Class<? extends l8.c<?>>, Integer> f15941h;

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap<String, String> f15942i;

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<String, String> f15943j;

    /* renamed from: k, reason: collision with root package name */
    private static final HashMap<String, String> f15944k;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f15945f;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a(Class<?> cls) {
            String str;
            k.e(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) e.f15944k.get(cls.getName());
                return str3 == null ? cls.getCanonicalName() : str3;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) e.f15944k.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List g10;
        int n10;
        Map<Class<? extends l8.c<?>>, Integer> p10;
        int d10;
        String c02;
        String c03;
        int i10 = 0;
        g10 = m8.q.g(x8.a.class, x8.l.class, x8.p.class, x8.q.class, x8.r.class, x8.s.class, x8.t.class, x8.u.class, x8.v.class, x8.w.class, x8.b.class, x8.c.class, x8.d.class, x8.e.class, x8.f.class, x8.g.class, x8.h.class, x8.i.class, x8.j.class, x8.k.class, x8.m.class, x8.n.class, x8.o.class);
        n10 = m8.r.n(g10, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (Object obj : g10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                m8.q.m();
            }
            arrayList.add(l8.t.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        p10 = l0.p(arrayList);
        f15941h = p10;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f15942i = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f15943j = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        k.d(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("kotlin.jvm.internal.");
            k.d(str, "kotlinName");
            c03 = mb.s.c0(str, '.', null, 2, null);
            sb2.append(c03);
            sb2.append("CompanionObject");
            l8.n a10 = l8.t.a(sb2.toString(), str + ".Companion");
            hashMap3.put(a10.c(), a10.d());
        }
        for (Map.Entry<Class<? extends l8.c<?>>, Integer> entry : f15941h.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f15944k = hashMap3;
        d10 = k0.d(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(d10);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            c02 = mb.s.c0((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, c02);
        }
    }

    public e(Class<?> cls) {
        k.e(cls, "jClass");
        this.f15945f = cls;
    }

    @Override // e9.b
    public String a() {
        return f15940g.a(b());
    }

    @Override // y8.d
    public Class<?> b() {
        return this.f15945f;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && k.a(w8.a.c(this), w8.a.c((e9.b) obj));
    }

    public int hashCode() {
        return w8.a.c(this).hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
