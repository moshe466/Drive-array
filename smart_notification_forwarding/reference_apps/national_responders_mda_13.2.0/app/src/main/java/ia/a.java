package ia;

import java.util.ArrayList;
import java.util.List;
import m8.q;
import m8.y;
import y8.k;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f10790a;

    /* renamed from: b, reason: collision with root package name */
    private final int f10791b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10792c;

    /* renamed from: d, reason: collision with root package name */
    private final int f10793d;

    /* renamed from: e, reason: collision with root package name */
    private final List<Integer> f10794e;

    /* renamed from: ia.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0206a {
        private C0206a() {
        }

        public /* synthetic */ C0206a(y8.g gVar) {
            this();
        }
    }

    static {
        new C0206a(null);
    }

    public a(int... iArr) {
        Integer t10;
        Integer t11;
        Integer t12;
        List<Integer> d10;
        List<Integer> b10;
        k.e(iArr, "numbers");
        this.f10790a = iArr;
        t10 = m8.k.t(iArr, 0);
        this.f10791b = t10 == null ? -1 : t10.intValue();
        t11 = m8.k.t(iArr, 1);
        this.f10792c = t11 == null ? -1 : t11.intValue();
        t12 = m8.k.t(iArr, 2);
        this.f10793d = t12 != null ? t12.intValue() : -1;
        if (iArr.length > 3) {
            b10 = m8.j.b(iArr);
            d10 = y.n0(b10.subList(3, iArr.length));
        } else {
            d10 = q.d();
        }
        this.f10794e = d10;
    }

    public final int a() {
        return this.f10791b;
    }

    public final int b() {
        return this.f10792c;
    }

    public final boolean c(int i10, int i11, int i12) {
        int i13 = this.f10791b;
        if (i13 > i10) {
            return true;
        }
        if (i13 < i10) {
            return false;
        }
        int i14 = this.f10792c;
        if (i14 > i11) {
            return true;
        }
        return i14 >= i11 && this.f10793d >= i12;
    }

    public final boolean d(a aVar) {
        k.e(aVar, "version");
        return c(aVar.f10791b, aVar.f10792c, aVar.f10793d);
    }

    public final boolean e(int i10, int i11, int i12) {
        int i13 = this.f10791b;
        if (i13 < i10) {
            return true;
        }
        if (i13 > i10) {
            return false;
        }
        int i14 = this.f10792c;
        if (i14 < i11) {
            return true;
        }
        return i14 <= i11 && this.f10793d <= i12;
    }

    public boolean equals(Object obj) {
        if (obj != null && k.a(getClass(), obj.getClass())) {
            a aVar = (a) obj;
            if (this.f10791b == aVar.f10791b && this.f10792c == aVar.f10792c && this.f10793d == aVar.f10793d && k.a(this.f10794e, aVar.f10794e)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean f(a aVar) {
        k.e(aVar, "ourVersion");
        int i10 = this.f10791b;
        if (i10 == 0) {
            if (aVar.f10791b == 0 && this.f10792c == aVar.f10792c) {
                return true;
            }
        } else if (i10 == aVar.f10791b && this.f10792c <= aVar.f10792c) {
            return true;
        }
        return false;
    }

    public final int[] g() {
        return this.f10790a;
    }

    public int hashCode() {
        int i10 = this.f10791b;
        int i11 = i10 + (i10 * 31) + this.f10792c;
        int i12 = i11 + (i11 * 31) + this.f10793d;
        return i12 + (i12 * 31) + this.f10794e.hashCode();
    }

    public String toString() {
        String Q;
        int[] g10 = g();
        ArrayList arrayList = new ArrayList();
        int length = g10.length;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = g10[i10];
            if (!(i11 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i11));
        }
        if (arrayList.isEmpty()) {
            return "unknown";
        }
        Q = y.Q(arrayList, ".", null, null, 0, null, null, 62, null);
        return Q;
    }
}
