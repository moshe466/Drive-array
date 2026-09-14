package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f12795a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final List<String> f12796a = new ArrayList(20);

        public a a(String str, String str2) {
            q.a(str);
            q.b(str2, str);
            return c(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a b(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? c(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? c("", str.substring(1)) : c("", str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a c(String str, String str2) {
            this.f12796a.add(str);
            this.f12796a.add(str2.trim());
            return this;
        }

        public q d() {
            return new q(this);
        }

        public a e(String str) {
            int i10 = 0;
            while (i10 < this.f12796a.size()) {
                if (str.equalsIgnoreCase(this.f12796a.get(i10))) {
                    this.f12796a.remove(i10);
                    this.f12796a.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public a f(String str, String str2) {
            q.a(str);
            q.b(str2, str);
            e(str);
            c(str, str2);
            return this;
        }
    }

    q(a aVar) {
        List<String> list = aVar.f12796a;
        this.f12795a = (String[]) list.toArray(new String[list.size()]);
    }

    private q(String[] strArr) {
        this.f12795a = strArr;
    }

    static void a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt <= ' ' || charAt >= 127) {
                throw new IllegalArgumentException(sb.c.r("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str));
            }
        }
    }

    static void b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                throw new IllegalArgumentException(sb.c.r("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str2, str));
            }
        }
    }

    private static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static q g(String... strArr) {
        Objects.requireNonNull(strArr, "namesAndValues == null");
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i10 = 0; i10 < strArr2.length; i10++) {
            if (strArr2[i10] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i10] = strArr2[i10].trim();
        }
        for (int i11 = 0; i11 < strArr2.length; i11 += 2) {
            String str = strArr2[i11];
            String str2 = strArr2[i11 + 1];
            a(str);
            b(str2, str);
        }
        return new q(strArr2);
    }

    public String c(String str) {
        return d(this.f12795a, str);
    }

    public String e(int i10) {
        return this.f12795a[i10 * 2];
    }

    public boolean equals(Object obj) {
        return (obj instanceof q) && Arrays.equals(((q) obj).f12795a, this.f12795a);
    }

    public a f() {
        a aVar = new a();
        Collections.addAll(aVar.f12796a, this.f12795a);
        return aVar;
    }

    public int h() {
        return this.f12795a.length / 2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f12795a);
    }

    public String i(int i10) {
        return this.f12795a[(i10 * 2) + 1];
    }

    public List<String> j(String str) {
        int h10 = h();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < h10; i10++) {
            if (str.equalsIgnoreCase(e(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(i(i10));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int h10 = h();
        for (int i10 = 0; i10 < h10; i10++) {
            sb2.append(e(i10));
            sb2.append(": ");
            sb2.append(i(i10));
            sb2.append("\n");
        }
        return sb2.toString();
    }
}
