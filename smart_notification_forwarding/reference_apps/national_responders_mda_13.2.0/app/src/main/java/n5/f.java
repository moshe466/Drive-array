package n5;

import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f12234a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final f f12235b = new f();

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final f a() {
            return f.f12235b;
        }
    }

    public final String b(String... strArr) {
        k.e(strArr, "strings");
        int length = strArr.length;
        String str = "";
        int i10 = 0;
        while (i10 < length) {
            String str2 = strArr[i10];
            i10++;
            if (str2 == null || str2.length() == 0) {
                str2 = "";
            }
            str = k.j(str, str2);
        }
        return str;
    }
}
