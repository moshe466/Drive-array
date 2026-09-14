package la;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import x8.l;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    private static final e f11849e = e.u("<root>");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f11850f = Pattern.compile("\\.");

    /* renamed from: g, reason: collision with root package name */
    private static final l<String, e> f11851g = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f11852a;

    /* renamed from: b, reason: collision with root package name */
    private transient b f11853b;

    /* renamed from: c, reason: collision with root package name */
    private transient c f11854c;

    /* renamed from: d, reason: collision with root package name */
    private transient e f11855d;

    /* loaded from: classes.dex */
    static class a implements l<String, e> {
        a() {
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e h(String str) {
            return e.o(str);
        }
    }

    public c(String str) {
        if (str == null) {
            a(2);
        }
        this.f11852a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, b bVar) {
        if (str == null) {
            a(0);
        }
        if (bVar == null) {
            a(1);
        }
        this.f11852a = str;
        this.f11853b = bVar;
    }

    private c(String str, c cVar, e eVar) {
        if (str == null) {
            a(3);
        }
        this.f11852a = str;
        this.f11854c = cVar;
        this.f11855d = eVar;
    }

    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i11 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        if (i10 != 1) {
            switch (i10) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i10) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(format);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    private void d() {
        int lastIndexOf = this.f11852a.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.f11855d = e.o(this.f11852a.substring(lastIndexOf + 1));
            this.f11854c = new c(this.f11852a.substring(0, lastIndexOf));
        } else {
            this.f11855d = e.o(this.f11852a);
            this.f11854c = b.f11846c.j();
        }
    }

    public static c m(e eVar) {
        if (eVar == null) {
            a(16);
        }
        return new c(eVar.k(), b.f11846c.j(), eVar);
    }

    public String b() {
        String str = this.f11852a;
        if (str == null) {
            a(4);
        }
        return str;
    }

    public c c(e eVar) {
        String str;
        if (eVar == null) {
            a(9);
        }
        if (e()) {
            str = eVar.k();
        } else {
            str = this.f11852a + "." + eVar.k();
        }
        return new c(str, this, eVar);
    }

    public boolean e() {
        return this.f11852a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f11852a.equals(((c) obj).f11852a);
    }

    public boolean f() {
        return this.f11853b != null || b().indexOf(60) < 0;
    }

    public c g() {
        c cVar = this.f11854c;
        if (cVar != null) {
            if (cVar == null) {
                a(7);
            }
            return cVar;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        d();
        c cVar2 = this.f11854c;
        if (cVar2 == null) {
            a(8);
        }
        return cVar2;
    }

    public List<e> h() {
        List<e> emptyList = e() ? Collections.emptyList() : m8.g.B(f11850f.split(this.f11852a), f11851g);
        if (emptyList == null) {
            a(14);
        }
        return emptyList;
    }

    public int hashCode() {
        return this.f11852a.hashCode();
    }

    public e i() {
        e eVar = this.f11855d;
        if (eVar != null) {
            if (eVar == null) {
                a(10);
            }
            return eVar;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        d();
        e eVar2 = this.f11855d;
        if (eVar2 == null) {
            a(11);
        }
        return eVar2;
    }

    public e j() {
        if (e()) {
            e eVar = f11849e;
            if (eVar == null) {
                a(12);
            }
            return eVar;
        }
        e i10 = i();
        if (i10 == null) {
            a(13);
        }
        return i10;
    }

    public boolean k(e eVar) {
        if (eVar == null) {
            a(15);
        }
        if (e()) {
            return false;
        }
        int indexOf = this.f11852a.indexOf(46);
        String str = this.f11852a;
        String k10 = eVar.k();
        if (indexOf == -1) {
            indexOf = this.f11852a.length();
        }
        return str.regionMatches(0, k10, 0, indexOf);
    }

    public b l() {
        b bVar = this.f11853b;
        if (bVar != null) {
            if (bVar == null) {
                a(5);
            }
            return bVar;
        }
        b bVar2 = new b(this);
        this.f11853b = bVar2;
        return bVar2;
    }

    public String toString() {
        String k10 = e() ? f11849e.k() : this.f11852a;
        if (k10 == null) {
            a(17);
        }
        return k10;
    }
}
