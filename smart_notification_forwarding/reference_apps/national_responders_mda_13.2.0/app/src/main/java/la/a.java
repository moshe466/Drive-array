package la;

import mb.s;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f11843a;

    /* renamed from: b, reason: collision with root package name */
    private final b f11844b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f11845c;

    public a(b bVar, b bVar2, boolean z10) {
        if (bVar == null) {
            a(1);
        }
        if (bVar2 == null) {
            a(2);
        }
        this.f11843a = bVar;
        this.f11844b = bVar2;
        this.f11845c = z10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(b bVar, e eVar) {
        this(bVar, b.k(eVar), false);
        if (bVar == null) {
            a(3);
        }
        if (eVar == null) {
            a(4);
        }
    }

    private static /* synthetic */ void a(int i10) {
        String str = (i10 == 5 || i10 == 6 || i10 == 7 || i10 == 9 || i10 == 13 || i10 == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 5 || i10 == 6 || i10 == 7 || i10 == 9 || i10 == 13 || i10 == 14) ? 2 : 3];
        switch (i10) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i10 == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i10 == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i10 == 7) {
            objArr[1] = "getShortClassName";
        } else if (i10 == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i10 == 13 || i10 == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 != 5 && i10 != 6 && i10 != 7 && i10 != 9 && i10 != 13 && i10 != 14) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static a e(String str) {
        if (str == null) {
            a(11);
        }
        return f(str, false);
    }

    public static a f(String str, boolean z10) {
        String h02;
        String b02;
        if (str == null) {
            a(12);
        }
        h02 = s.h0(str, '/', "");
        String replace = h02.replace('/', '.');
        b02 = s.b0(str, '/', str);
        return new a(new b(replace), new b(b02), z10);
    }

    public static a m(b bVar) {
        if (bVar == null) {
            a(0);
        }
        return new a(bVar.e(), bVar.g());
    }

    public b b() {
        if (this.f11843a.d()) {
            b bVar = this.f11844b;
            if (bVar == null) {
                a(9);
            }
            return bVar;
        }
        return new b(this.f11843a.b() + "." + this.f11844b.b());
    }

    public String c() {
        if (this.f11843a.d()) {
            String b10 = this.f11844b.b();
            if (b10 == null) {
                a(13);
            }
            return b10;
        }
        String str = this.f11843a.b().replace('.', '/') + "/" + this.f11844b.b();
        if (str == null) {
            a(14);
        }
        return str;
    }

    public a d(e eVar) {
        if (eVar == null) {
            a(8);
        }
        return new a(h(), this.f11844b.c(eVar), this.f11845c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11843a.equals(aVar.f11843a) && this.f11844b.equals(aVar.f11844b) && this.f11845c == aVar.f11845c;
    }

    public a g() {
        b e10 = this.f11844b.e();
        if (e10.d()) {
            return null;
        }
        return new a(h(), e10, this.f11845c);
    }

    public b h() {
        b bVar = this.f11843a;
        if (bVar == null) {
            a(5);
        }
        return bVar;
    }

    public int hashCode() {
        return (((this.f11843a.hashCode() * 31) + this.f11844b.hashCode()) * 31) + Boolean.valueOf(this.f11845c).hashCode();
    }

    public b i() {
        b bVar = this.f11844b;
        if (bVar == null) {
            a(6);
        }
        return bVar;
    }

    public e j() {
        e g10 = this.f11844b.g();
        if (g10 == null) {
            a(7);
        }
        return g10;
    }

    public boolean k() {
        return this.f11845c;
    }

    public boolean l() {
        return !this.f11844b.e().d();
    }

    public String toString() {
        if (!this.f11843a.d()) {
            return c();
        }
        return "/" + c();
    }
}
