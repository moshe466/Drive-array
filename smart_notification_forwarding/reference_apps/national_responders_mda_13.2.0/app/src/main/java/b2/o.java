package b2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class o {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List f4055a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f4056b;

        /* synthetic */ a(Object obj, w0 w0Var) {
            p.k(obj);
            this.f4056b = obj;
            this.f4055a = new ArrayList();
        }

        public a a(String str, Object obj) {
            List list = this.f4055a;
            p.k(str);
            list.add(str + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f4056b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f4055a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append((String) this.f4055a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, null);
    }
}
