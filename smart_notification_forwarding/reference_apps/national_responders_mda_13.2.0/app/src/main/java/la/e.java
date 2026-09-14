package la;

/* loaded from: classes.dex */
public final class e implements Comparable<e> {

    /* renamed from: f, reason: collision with root package name */
    private final String f11857f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f11858g;

    private e(String str, boolean z10) {
        if (str == null) {
            j(0);
        }
        this.f11857f = str;
        this.f11858g = z10;
    }

    private static /* synthetic */ void j(int i10) {
        String str = (i10 == 1 || i10 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 2) ? 2 : 3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i10 == 1) {
            objArr[1] = "asString";
        } else if (i10 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[1] = "getIdentifier";
        }
        switch (i10) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "identifier";
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static e o(String str) {
        if (str == null) {
            j(6);
        }
        return str.startsWith("<") ? u(str) : r(str);
    }

    public static e r(String str) {
        if (str == null) {
            j(3);
        }
        return new e(str, false);
    }

    public static boolean t(String str) {
        if (str == null) {
            j(4);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static e u(String str) {
        if (str == null) {
            j(5);
        }
        if (str.startsWith("<")) {
            return new e(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f11858g == eVar.f11858g && this.f11857f.equals(eVar.f11857f);
    }

    public int hashCode() {
        return (this.f11857f.hashCode() * 31) + (this.f11858g ? 1 : 0);
    }

    public String k() {
        String str = this.f11857f;
        if (str == null) {
            j(1);
        }
        return str;
    }

    @Override // java.lang.Comparable
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        return this.f11857f.compareTo(eVar.f11857f);
    }

    public String n() {
        if (this.f11858g) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String k10 = k();
        if (k10 == null) {
            j(2);
        }
        return k10;
    }

    public boolean s() {
        return this.f11858g;
    }

    public String toString() {
        return this.f11857f;
    }
}
