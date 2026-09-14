package ea;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f9330a = new v();

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l<String, CharSequence> {
        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(String str) {
            y8.k.e(str, "it");
            return v.this.c(str);
        }
    }

    private v() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    public final String[] b(String... strArr) {
        y8.k.e(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public final Set<String> d(String str, String... strArr) {
        y8.k.e(str, "internalName");
        y8.k.e(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public final Set<String> e(String str, String... strArr) {
        y8.k.e(str, "name");
        y8.k.e(strArr, "signatures");
        String h10 = h(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return d(h10, strArr2);
    }

    public final Set<String> f(String str, String... strArr) {
        y8.k.e(str, "name");
        y8.k.e(strArr, "signatures");
        String i10 = i(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return d(i10, strArr2);
    }

    public final String g(String str) {
        y8.k.e(str, "name");
        return y8.k.j("java/util/function/", str);
    }

    public final String h(String str) {
        y8.k.e(str, "name");
        return y8.k.j("java/lang/", str);
    }

    public final String i(String str) {
        y8.k.e(str, "name");
        return y8.k.j("java/util/", str);
    }

    public final String j(String str, List<String> list, String str2) {
        String Q;
        y8.k.e(str, "name");
        y8.k.e(list, "parameters");
        y8.k.e(str2, "ret");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append('(');
        Q = m8.y.Q(list, "", null, null, 0, null, new a(), 30, null);
        sb2.append(Q);
        sb2.append(')');
        sb2.append(c(str2));
        return sb2.toString();
    }

    public final String k(String str, String str2) {
        y8.k.e(str, "internalName");
        y8.k.e(str2, "jvmDescriptor");
        return str + '.' + str2;
    }
}
