package v9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m8.i0;
import m8.k0;
import m8.l0;
import m8.r0;
import m8.s0;

/* loaded from: classes.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14765a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final List<a.C0306a> f14766b;

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f14767c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<a.C0306a, c> f14768d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, c> f14769e;

    /* renamed from: f, reason: collision with root package name */
    private static final Set<la.e> f14770f;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<String> f14771g;

    /* renamed from: h, reason: collision with root package name */
    private static final a.C0306a f14772h;

    /* renamed from: i, reason: collision with root package name */
    private static final Map<a.C0306a, la.e> f14773i;

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, la.e> f14774j;

    /* renamed from: k, reason: collision with root package name */
    private static final List<la.e> f14775k;

    /* renamed from: l, reason: collision with root package name */
    private static final Map<la.e, List<la.e>> f14776l;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: v9.c0$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0306a {

            /* renamed from: a, reason: collision with root package name */
            private final la.e f14777a;

            /* renamed from: b, reason: collision with root package name */
            private final String f14778b;

            public C0306a(la.e eVar, String str) {
                y8.k.e(eVar, "name");
                y8.k.e(str, "signature");
                this.f14777a = eVar;
                this.f14778b = str;
            }

            public final la.e a() {
                return this.f14777a;
            }

            public final String b() {
                return this.f14778b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0306a)) {
                    return false;
                }
                C0306a c0306a = (C0306a) obj;
                return y8.k.a(this.f14777a, c0306a.f14777a) && y8.k.a(this.f14778b, c0306a.f14778b);
            }

            public int hashCode() {
                return (this.f14777a.hashCode() * 31) + this.f14778b.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.f14777a + ", signature=" + this.f14778b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C0306a k(String str, String str2, String str3, String str4) {
            la.e r10 = la.e.r(str2);
            y8.k.d(r10, "identifier(name)");
            return new C0306a(r10, ea.v.f9330a.k(str, str2 + '(' + str3 + ')' + str4));
        }

        public final List<String> b() {
            return c0.f14767c;
        }

        public final Set<la.e> c() {
            return c0.f14770f;
        }

        public final Set<String> d() {
            return c0.f14771g;
        }

        public final Map<la.e, List<la.e>> e() {
            return c0.f14776l;
        }

        public final List<la.e> f() {
            return c0.f14775k;
        }

        public final C0306a g() {
            return c0.f14772h;
        }

        public final Map<String, c> h() {
            return c0.f14769e;
        }

        public final Map<String, la.e> i() {
            return c0.f14774j;
        }

        public final b j(String str) {
            y8.k.e(str, "builtinSignature");
            return b().contains(str) ? b.ONE_COLLECTION_PARAMETER : ((c) i0.i(h(), str)) == c.NULL ? b.OBJECT_PARAMETER_GENERIC : b.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        b(String str, boolean z10) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z10;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] valuesCustom = values();
            b[] bVarArr = new b[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, bVarArr, 0, valuesCustom.length);
            return bVarArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class c {
        private static final /* synthetic */ c[] $VALUES;
        public static final c FALSE;
        public static final c INDEX;
        public static final c MAP_GET_OR_DEFAULT;
        public static final c NULL;
        private final Object defaultValue;

        /* loaded from: classes.dex */
        static final class a extends c {
            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            a(java.lang.String r2, int r3) {
                /*
                    r1 = this;
                    r0 = 0
                    r1.<init>(r2, r3, r0, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: v9.c0.c.a.<init>(java.lang.String, int):void");
            }
        }

        static {
            c cVar = new c("NULL", 0, null);
            NULL = cVar;
            c cVar2 = new c("INDEX", 1, -1);
            INDEX = cVar2;
            c cVar3 = new c("FALSE", 2, Boolean.FALSE);
            FALSE = cVar3;
            a aVar = new a("MAP_GET_OR_DEFAULT", 3);
            MAP_GET_OR_DEFAULT = aVar;
            $VALUES = new c[]{cVar, cVar2, cVar3, aVar};
        }

        private c(String str, int i10, Object obj) {
            this.defaultValue = obj;
        }

        public /* synthetic */ c(String str, int i10, Object obj, y8.g gVar) {
            this(str, i10, obj);
        }

        public static c valueOf(String str) {
            y8.k.e(str, "value");
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            c[] cVarArr = $VALUES;
            c[] cVarArr2 = new c[cVarArr.length];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, cVarArr.length);
            return cVarArr2;
        }
    }

    static {
        Set<String> e10;
        int n10;
        int n11;
        int n12;
        Map<a.C0306a, c> k10;
        int d10;
        Set g10;
        int n13;
        Set<la.e> r02;
        int n14;
        Set<String> r03;
        Map<a.C0306a, la.e> k11;
        int d11;
        int n15;
        int n16;
        e10 = r0.e("containsAll", "removeAll", "retainAll");
        n10 = m8.r.n(e10, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (String str : e10) {
            a aVar = f14765a;
            String desc = sa.d.BOOLEAN.getDesc();
            y8.k.d(desc, "BOOLEAN.desc");
            arrayList.add(aVar.k("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        f14766b = arrayList;
        n11 = m8.r.n(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(n11);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a.C0306a) it.next()).b());
        }
        f14767c = arrayList2;
        List<a.C0306a> list = f14766b;
        n12 = m8.r.n(list, 10);
        ArrayList arrayList3 = new ArrayList(n12);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((a.C0306a) it2.next()).a().k());
        }
        ea.v vVar = ea.v.f9330a;
        a aVar2 = f14765a;
        String i10 = vVar.i("Collection");
        sa.d dVar = sa.d.BOOLEAN;
        String desc2 = dVar.getDesc();
        y8.k.d(desc2, "BOOLEAN.desc");
        a.C0306a k12 = aVar2.k(i10, "contains", "Ljava/lang/Object;", desc2);
        c cVar = c.FALSE;
        String i11 = vVar.i("Collection");
        String desc3 = dVar.getDesc();
        y8.k.d(desc3, "BOOLEAN.desc");
        String i12 = vVar.i("Map");
        String desc4 = dVar.getDesc();
        y8.k.d(desc4, "BOOLEAN.desc");
        String i13 = vVar.i("Map");
        String desc5 = dVar.getDesc();
        y8.k.d(desc5, "BOOLEAN.desc");
        String i14 = vVar.i("Map");
        String desc6 = dVar.getDesc();
        y8.k.d(desc6, "BOOLEAN.desc");
        a.C0306a k13 = aVar2.k(vVar.i("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        c cVar2 = c.NULL;
        String i15 = vVar.i("List");
        sa.d dVar2 = sa.d.INT;
        String desc7 = dVar2.getDesc();
        y8.k.d(desc7, "INT.desc");
        a.C0306a k14 = aVar2.k(i15, "indexOf", "Ljava/lang/Object;", desc7);
        c cVar3 = c.INDEX;
        String i16 = vVar.i("List");
        String desc8 = dVar2.getDesc();
        y8.k.d(desc8, "INT.desc");
        k10 = l0.k(l8.t.a(k12, cVar), l8.t.a(aVar2.k(i11, "remove", "Ljava/lang/Object;", desc3), cVar), l8.t.a(aVar2.k(i12, "containsKey", "Ljava/lang/Object;", desc4), cVar), l8.t.a(aVar2.k(i13, "containsValue", "Ljava/lang/Object;", desc5), cVar), l8.t.a(aVar2.k(i14, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), cVar), l8.t.a(aVar2.k(vVar.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.MAP_GET_OR_DEFAULT), l8.t.a(k13, cVar2), l8.t.a(aVar2.k(vVar.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), cVar2), l8.t.a(k14, cVar3), l8.t.a(aVar2.k(i16, "lastIndexOf", "Ljava/lang/Object;", desc8), cVar3));
        f14768d = k10;
        d10 = k0.d(k10.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(d10);
        Iterator<T> it3 = k10.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(((a.C0306a) entry.getKey()).b(), entry.getValue());
        }
        f14769e = linkedHashMap;
        g10 = s0.g(f14768d.keySet(), f14766b);
        n13 = m8.r.n(g10, 10);
        ArrayList arrayList4 = new ArrayList(n13);
        Iterator it4 = g10.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((a.C0306a) it4.next()).a());
        }
        r02 = m8.y.r0(arrayList4);
        f14770f = r02;
        n14 = m8.r.n(g10, 10);
        ArrayList arrayList5 = new ArrayList(n14);
        Iterator it5 = g10.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((a.C0306a) it5.next()).b());
        }
        r03 = m8.y.r0(arrayList5);
        f14771g = r03;
        a aVar3 = f14765a;
        sa.d dVar3 = sa.d.INT;
        String desc9 = dVar3.getDesc();
        y8.k.d(desc9, "INT.desc");
        f14772h = aVar3.k("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        ea.v vVar2 = ea.v.f9330a;
        String h10 = vVar2.h("Number");
        String desc10 = sa.d.BYTE.getDesc();
        y8.k.d(desc10, "BYTE.desc");
        String h11 = vVar2.h("Number");
        String desc11 = sa.d.SHORT.getDesc();
        y8.k.d(desc11, "SHORT.desc");
        String h12 = vVar2.h("Number");
        String desc12 = dVar3.getDesc();
        y8.k.d(desc12, "INT.desc");
        String h13 = vVar2.h("Number");
        String desc13 = sa.d.LONG.getDesc();
        y8.k.d(desc13, "LONG.desc");
        String h14 = vVar2.h("Number");
        String desc14 = sa.d.FLOAT.getDesc();
        y8.k.d(desc14, "FLOAT.desc");
        String h15 = vVar2.h("Number");
        String desc15 = sa.d.DOUBLE.getDesc();
        y8.k.d(desc15, "DOUBLE.desc");
        String h16 = vVar2.h("CharSequence");
        String desc16 = dVar3.getDesc();
        y8.k.d(desc16, "INT.desc");
        String desc17 = sa.d.CHAR.getDesc();
        y8.k.d(desc17, "CHAR.desc");
        k11 = l0.k(l8.t.a(aVar3.k(h10, "toByte", "", desc10), la.e.r("byteValue")), l8.t.a(aVar3.k(h11, "toShort", "", desc11), la.e.r("shortValue")), l8.t.a(aVar3.k(h12, "toInt", "", desc12), la.e.r("intValue")), l8.t.a(aVar3.k(h13, "toLong", "", desc13), la.e.r("longValue")), l8.t.a(aVar3.k(h14, "toFloat", "", desc14), la.e.r("floatValue")), l8.t.a(aVar3.k(h15, "toDouble", "", desc15), la.e.r("doubleValue")), l8.t.a(aVar3.g(), la.e.r("remove")), l8.t.a(aVar3.k(h16, "get", desc16, desc17), la.e.r("charAt")));
        f14773i = k11;
        d11 = k0.d(k11.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(d11);
        Iterator<T> it6 = k11.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            linkedHashMap2.put(((a.C0306a) entry2.getKey()).b(), entry2.getValue());
        }
        f14774j = linkedHashMap2;
        Set<a.C0306a> keySet = f14773i.keySet();
        n15 = m8.r.n(keySet, 10);
        ArrayList arrayList6 = new ArrayList(n15);
        Iterator<T> it7 = keySet.iterator();
        while (it7.hasNext()) {
            arrayList6.add(((a.C0306a) it7.next()).a());
        }
        f14775k = arrayList6;
        Set<Map.Entry<a.C0306a, la.e>> entrySet = f14773i.entrySet();
        n16 = m8.r.n(entrySet, 10);
        ArrayList<l8.n> arrayList7 = new ArrayList(n16);
        Iterator<T> it8 = entrySet.iterator();
        while (it8.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it8.next();
            arrayList7.add(new l8.n(((a.C0306a) entry3.getKey()).a(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (l8.n nVar : arrayList7) {
            la.e eVar = (la.e) nVar.d();
            Object obj = linkedHashMap3.get(eVar);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap3.put(eVar, obj);
            }
            ((List) obj).add((la.e) nVar.c());
        }
        f14776l = linkedHashMap3;
    }
}
