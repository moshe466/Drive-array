package kb;

/* loaded from: classes.dex */
public final class b<K, V> {

    /* renamed from: c, reason: collision with root package name */
    private static final b<Object, Object> f11328c = new b<>(d.a(), 0);

    /* renamed from: a, reason: collision with root package name */
    private final d<a<e<K, V>>> f11329a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11330b;

    private b(d<a<e<K, V>>> dVar, int i10) {
        this.f11329a = dVar;
        this.f11330b = i10;
    }

    private static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i10 != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    public static <K, V> b<K, V> b() {
        b<K, V> bVar = (b<K, V>) f11328c;
        if (bVar == null) {
            a(0);
        }
        return bVar;
    }

    private a<e<K, V>> d(int i10) {
        a<e<K, V>> b10 = this.f11329a.b(i10);
        return b10 == null ? a.f() : b10;
    }

    private static <K, V> int e(a<e<K, V>> aVar, Object obj) {
        int i10 = 0;
        while (aVar != null && aVar.size() > 0) {
            if (aVar.f11324f.f11339f.equals(obj)) {
                return i10;
            }
            aVar = aVar.f11325g;
            i10++;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V c(Object obj) {
        for (a d10 = d(obj.hashCode()); d10 != null && d10.size() > 0; d10 = d10.f11325g) {
            e eVar = (e) d10.f11324f;
            if (eVar.f11339f.equals(obj)) {
                return eVar.f11340g;
            }
        }
        return null;
    }

    public b<K, V> f(K k10, V v10) {
        a<e<K, V>> d10 = d(k10.hashCode());
        int size = d10.size();
        int e10 = e(d10, k10);
        if (e10 != -1) {
            d10 = d10.j(e10);
        }
        a<e<K, V>> s10 = d10.s(new e<>(k10, v10));
        return new b<>(this.f11329a.c(k10.hashCode(), s10), (this.f11330b - size) + s10.size());
    }
}
