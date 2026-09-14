package ka;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import m8.q;
import m8.y;
import mb.r;
import y8.k;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f11300a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final String f11301b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f11302c;

    static {
        List g10;
        String Q;
        List g11;
        List<String> g12;
        List<String> g13;
        List<String> g14;
        int i10 = 0;
        g10 = q.g('k', 'o', 't', 'l', 'i', 'n');
        Q = y.Q(g10, "", null, null, 0, null, null, 62, null);
        f11301b = Q;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        g11 = q.g("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int b10 = s8.c.b(0, g11.size() - 1, 2);
        if (b10 >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 2;
                StringBuilder sb2 = new StringBuilder();
                String str = f11301b;
                sb2.append(str);
                sb2.append('/');
                sb2.append((String) g11.get(i11));
                int i13 = i11 + 1;
                linkedHashMap.put(sb2.toString(), g11.get(i13));
                linkedHashMap.put(str + '/' + ((String) g11.get(i11)) + "Array", k.j("[", g11.get(i13)));
                if (i11 == b10) {
                    break;
                } else {
                    i11 = i12;
                }
            }
        }
        linkedHashMap.put(k.j(f11301b, "/Unit"), "V");
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        g12 = q.g("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum");
        for (String str2 : g12) {
            a(linkedHashMap, str2, k.j("java/lang/", str2));
        }
        g13 = q.g("Iterator", "Collection", "List", "Set", "Map", "ListIterator");
        for (String str3 : g13) {
            a(linkedHashMap, k.j("collections/", str3), k.j("java/util/", str3));
            a(linkedHashMap, k.j("collections/Mutable", str3), k.j("java/util/", str3));
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i14 = i10 + 1;
            String j10 = k.j("Function", Integer.valueOf(i10));
            StringBuilder sb3 = new StringBuilder();
            String str4 = f11301b;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i10);
            a(linkedHashMap, j10, sb3.toString());
            a(linkedHashMap, k.j("reflect/KFunction", Integer.valueOf(i10)), k.j(str4, "/reflect/KFunction"));
            if (i14 > 22) {
                break;
            } else {
                i10 = i14;
            }
        }
        g14 = q.g("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum");
        for (String str5 : g14) {
            a(linkedHashMap, k.j(str5, ".Companion"), f11301b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f11302c = linkedHashMap;
    }

    private b() {
    }

    private static final void a(Map<String, String> map, String str, String str2) {
        map.put(f11301b + '/' + str, 'L' + str2 + ';');
    }

    public static final String b(String str) {
        String t10;
        k.e(str, "classId");
        String str2 = f11302c.get(str);
        if (str2 != null) {
            return str2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('L');
        t10 = r.t(str, '.', '$', false, 4, null);
        sb2.append(t10);
        sb2.append(';');
        return sb2.toString();
    }
}
