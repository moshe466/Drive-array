package fa;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ka.c;
import ka.f;
import m8.j;
import m8.k0;
import m8.q;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final EnumC0166a f9657a;

    /* renamed from: b, reason: collision with root package name */
    private final f f9658b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f9659c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f9660d;

    /* renamed from: e, reason: collision with root package name */
    private final String[] f9661e;

    /* renamed from: f, reason: collision with root package name */
    private final String f9662f;

    /* renamed from: g, reason: collision with root package name */
    private final int f9663g;

    /* renamed from: fa.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0166a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);

        public static final C0167a Companion = new C0167a(null);
        private static final Map<Integer, EnumC0166a> entryById;
        private final int id;

        /* renamed from: fa.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0167a {
            private C0167a() {
            }

            public /* synthetic */ C0167a(g gVar) {
                this();
            }

            public final EnumC0166a a(int i10) {
                EnumC0166a enumC0166a = (EnumC0166a) EnumC0166a.entryById.get(Integer.valueOf(i10));
                return enumC0166a == null ? EnumC0166a.UNKNOWN : enumC0166a;
            }
        }

        static {
            int d10;
            int a10;
            EnumC0166a[] valuesCustom = valuesCustom();
            d10 = k0.d(valuesCustom.length);
            a10 = d9.f.a(d10, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
            for (EnumC0166a enumC0166a : valuesCustom) {
                linkedHashMap.put(Integer.valueOf(enumC0166a.getId()), enumC0166a);
            }
            entryById = linkedHashMap;
        }

        EnumC0166a(int i10) {
            this.id = i10;
        }

        public static final EnumC0166a getById(int i10) {
            return Companion.a(i10);
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static EnumC0166a[] valuesCustom() {
            EnumC0166a[] valuesCustom = values();
            EnumC0166a[] enumC0166aArr = new EnumC0166a[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, enumC0166aArr, 0, valuesCustom.length);
            return enumC0166aArr;
        }

        public final int getId() {
            return this.id;
        }
    }

    public a(EnumC0166a enumC0166a, f fVar, c cVar, String[] strArr, String[] strArr2, String[] strArr3, String str, int i10, String str2) {
        k.e(enumC0166a, "kind");
        k.e(fVar, "metadataVersion");
        k.e(cVar, "bytecodeVersion");
        this.f9657a = enumC0166a;
        this.f9658b = fVar;
        this.f9659c = strArr;
        this.f9660d = strArr2;
        this.f9661e = strArr3;
        this.f9662f = str;
        this.f9663g = i10;
    }

    private final boolean h(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public final String[] a() {
        return this.f9659c;
    }

    public final String[] b() {
        return this.f9660d;
    }

    public final EnumC0166a c() {
        return this.f9657a;
    }

    public final f d() {
        return this.f9658b;
    }

    public final String e() {
        String str = this.f9662f;
        if (c() == EnumC0166a.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> f() {
        List<String> d10;
        String[] strArr = this.f9659c;
        if (!(c() == EnumC0166a.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> c10 = strArr != null ? j.c(strArr) : null;
        if (c10 != null) {
            return c10;
        }
        d10 = q.d();
        return d10;
    }

    public final String[] g() {
        return this.f9661e;
    }

    public final boolean i() {
        return h(this.f9663g, 2);
    }

    public final boolean j() {
        return h(this.f9663g, 64) && !h(this.f9663g, 32);
    }

    public final boolean k() {
        return h(this.f9663g, 16) && !h(this.f9663g, 32);
    }

    public String toString() {
        return this.f9657a + " version=" + this.f9658b;
    }
}
