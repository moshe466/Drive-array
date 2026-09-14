package ka;

import ja.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import l8.w;
import m8.d0;
import m8.k0;
import m8.q;
import m8.r;
import m8.r0;
import m8.y;
import y8.k;

/* loaded from: classes.dex */
public final class g implements ia.c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f11313e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f11314f;

    /* renamed from: g, reason: collision with root package name */
    private static final List<String> f11315g;

    /* renamed from: a, reason: collision with root package name */
    private final a.e f11316a;

    /* renamed from: b, reason: collision with root package name */
    private final String[] f11317b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<Integer> f11318c;

    /* renamed from: d, reason: collision with root package name */
    private final List<a.e.c> f11319d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final List<String> a() {
            return g.f11315g;
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11320a;

        static {
            int[] iArr = new int[a.e.c.EnumC0220c.values().length];
            iArr[a.e.c.EnumC0220c.NONE.ordinal()] = 1;
            iArr[a.e.c.EnumC0220c.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[a.e.c.EnumC0220c.DESC_TO_CLASS_ID.ordinal()] = 3;
            f11320a = iArr;
        }
    }

    static {
        List g10;
        String Q;
        List<String> g11;
        Iterable<d0> t02;
        int n10;
        int d10;
        int a10;
        a aVar = new a(null);
        f11313e = aVar;
        g10 = q.g('k', 'o', 't', 'l', 'i', 'n');
        Q = y.Q(g10, "", null, null, 0, null, null, 62, null);
        f11314f = Q;
        g11 = q.g(k.j(Q, "/Any"), k.j(Q, "/Nothing"), k.j(Q, "/Unit"), k.j(Q, "/Throwable"), k.j(Q, "/Number"), k.j(Q, "/Byte"), k.j(Q, "/Double"), k.j(Q, "/Float"), k.j(Q, "/Int"), k.j(Q, "/Long"), k.j(Q, "/Short"), k.j(Q, "/Boolean"), k.j(Q, "/Char"), k.j(Q, "/CharSequence"), k.j(Q, "/String"), k.j(Q, "/Comparable"), k.j(Q, "/Enum"), k.j(Q, "/Array"), k.j(Q, "/ByteArray"), k.j(Q, "/DoubleArray"), k.j(Q, "/FloatArray"), k.j(Q, "/IntArray"), k.j(Q, "/LongArray"), k.j(Q, "/ShortArray"), k.j(Q, "/BooleanArray"), k.j(Q, "/CharArray"), k.j(Q, "/Cloneable"), k.j(Q, "/Annotation"), k.j(Q, "/collections/Iterable"), k.j(Q, "/collections/MutableIterable"), k.j(Q, "/collections/Collection"), k.j(Q, "/collections/MutableCollection"), k.j(Q, "/collections/List"), k.j(Q, "/collections/MutableList"), k.j(Q, "/collections/Set"), k.j(Q, "/collections/MutableSet"), k.j(Q, "/collections/Map"), k.j(Q, "/collections/MutableMap"), k.j(Q, "/collections/Map.Entry"), k.j(Q, "/collections/MutableMap.MutableEntry"), k.j(Q, "/collections/Iterator"), k.j(Q, "/collections/MutableIterator"), k.j(Q, "/collections/ListIterator"), k.j(Q, "/collections/MutableListIterator"));
        f11315g = g11;
        t02 = y.t0(aVar.a());
        n10 = r.n(t02, 10);
        d10 = k0.d(n10);
        a10 = d9.f.a(d10, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
        for (d0 d0Var : t02) {
            linkedHashMap.put((String) d0Var.d(), Integer.valueOf(d0Var.c()));
        }
    }

    public g(a.e eVar, String[] strArr) {
        Set<Integer> r02;
        k.e(eVar, "types");
        k.e(strArr, "strings");
        this.f11316a = eVar;
        this.f11317b = strArr;
        List<Integer> y10 = eVar.y();
        if (y10.isEmpty()) {
            r02 = r0.b();
        } else {
            k.d(y10, "");
            r02 = y.r0(y10);
        }
        this.f11318c = r02;
        ArrayList arrayList = new ArrayList();
        List<a.e.c> z10 = e().z();
        arrayList.ensureCapacity(z10.size());
        for (a.e.c cVar : z10) {
            int H = cVar.H();
            for (int i10 = 0; i10 < H; i10++) {
                arrayList.add(cVar);
            }
        }
        arrayList.trimToSize();
        w wVar = w.f11824a;
        this.f11319d = arrayList;
    }

    @Override // ia.c
    public String a(int i10) {
        String str;
        a.e.c cVar = this.f11319d.get(i10);
        if (cVar.R()) {
            str = cVar.K();
        } else {
            if (cVar.P()) {
                a aVar = f11313e;
                int size = aVar.a().size() - 1;
                int G = cVar.G();
                if (G >= 0 && G <= size) {
                    str = aVar.a().get(cVar.G());
                }
            }
            str = this.f11317b[i10];
        }
        if (cVar.M() >= 2) {
            List<Integer> N = cVar.N();
            k.d(N, "substringIndexList");
            Integer num = N.get(0);
            Integer num2 = N.get(1);
            k.d(num, "begin");
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                k.d(num2, "end");
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    k.d(str, "string");
                    str = str.substring(num.intValue(), num2.intValue());
                    k.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String str2 = str;
        if (cVar.I() >= 2) {
            List<Integer> J = cVar.J();
            k.d(J, "replaceCharList");
            Integer num3 = J.get(0);
            Integer num4 = J.get(1);
            k.d(str2, "string");
            str2 = mb.r.t(str2, (char) num3.intValue(), (char) num4.intValue(), false, 4, null);
        }
        String str3 = str2;
        a.e.c.EnumC0220c F = cVar.F();
        if (F == null) {
            F = a.e.c.EnumC0220c.NONE;
        }
        int i11 = b.f11320a[F.ordinal()];
        if (i11 == 2) {
            k.d(str3, "string");
            str3 = mb.r.t(str3, '$', '.', false, 4, null);
        } else if (i11 == 3) {
            if (str3.length() >= 2) {
                k.d(str3, "string");
                str3 = str3.substring(1, str3.length() - 1);
                k.d(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            String str4 = str3;
            k.d(str4, "string");
            str3 = mb.r.t(str4, '$', '.', false, 4, null);
        }
        k.d(str3, "string");
        return str3;
    }

    @Override // ia.c
    public boolean b(int i10) {
        return this.f11318c.contains(Integer.valueOf(i10));
    }

    @Override // ia.c
    public String c(int i10) {
        return a(i10);
    }

    public final a.e e() {
        return this.f11316a;
    }
}
