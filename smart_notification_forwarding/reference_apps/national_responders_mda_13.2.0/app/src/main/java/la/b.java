package la;

import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f11846c = new b("");

    /* renamed from: a, reason: collision with root package name */
    private final c f11847a;

    /* renamed from: b, reason: collision with root package name */
    private transient b f11848b;

    public b(String str) {
        if (str == null) {
            a(1);
        }
        this.f11847a = new c(str, this);
    }

    public b(c cVar) {
        if (cVar == null) {
            a(2);
        }
        this.f11847a = cVar;
    }

    private b(c cVar, b bVar) {
        if (cVar == null) {
            a(3);
        }
        this.f11847a = cVar;
        this.f11848b = bVar;
    }

    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i11 = 2;
                break;
            case 8:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i10) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(format);
            case 8:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static b k(e eVar) {
        if (eVar == null) {
            a(13);
        }
        return new b(c.m(eVar));
    }

    public String b() {
        String b10 = this.f11847a.b();
        if (b10 == null) {
            a(4);
        }
        return b10;
    }

    public b c(e eVar) {
        if (eVar == null) {
            a(8);
        }
        return new b(this.f11847a.c(eVar), this);
    }

    public boolean d() {
        return this.f11847a.e();
    }

    public b e() {
        b bVar = this.f11848b;
        if (bVar != null) {
            if (bVar == null) {
                a(6);
            }
            return bVar;
        }
        if (d()) {
            throw new IllegalStateException("root");
        }
        b bVar2 = new b(this.f11847a.g());
        this.f11848b = bVar2;
        return bVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f11847a.equals(((b) obj).f11847a);
    }

    public List<e> f() {
        List<e> h10 = this.f11847a.h();
        if (h10 == null) {
            a(11);
        }
        return h10;
    }

    public e g() {
        e i10 = this.f11847a.i();
        if (i10 == null) {
            a(9);
        }
        return i10;
    }

    public e h() {
        e j10 = this.f11847a.j();
        if (j10 == null) {
            a(10);
        }
        return j10;
    }

    public int hashCode() {
        return this.f11847a.hashCode();
    }

    public boolean i(e eVar) {
        if (eVar == null) {
            a(12);
        }
        return this.f11847a.k(eVar);
    }

    public c j() {
        c cVar = this.f11847a;
        if (cVar == null) {
            a(5);
        }
        return cVar;
    }

    public String toString() {
        return this.f11847a.toString();
    }
}
