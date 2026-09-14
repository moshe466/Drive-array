package y8;

/* loaded from: classes.dex */
public class i extends c implements h, e9.e {

    /* renamed from: m, reason: collision with root package name */
    private final int f15947m;

    /* renamed from: n, reason: collision with root package name */
    private final int f15948n;

    public i(int i10) {
        this(i10, c.f15932l, null, null, null, 0);
    }

    public i(int i10, Object obj) {
        this(i10, obj, null, null, null, 0);
    }

    public i(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.f15947m = i10;
        this.f15948n = i11 >> 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return c().equals(iVar.c()) && m().equals(iVar.m()) && this.f15948n == iVar.f15948n && this.f15947m == iVar.f15947m && k.a(j(), iVar.j()) && k.a(k(), iVar.k());
        }
        if (obj instanceof e9.e) {
            return obj.equals(d());
        }
        return false;
    }

    public int hashCode() {
        return (((k() == null ? 0 : k().hashCode() * 31) + c().hashCode()) * 31) + m().hashCode();
    }

    @Override // y8.c
    protected e9.a i() {
        return w.a(this);
    }

    public String toString() {
        e9.a d10 = d();
        if (d10 != this) {
            return d10.toString();
        }
        if ("<init>".equals(c())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + c() + " (Kotlin reflection is not available)";
    }
}
