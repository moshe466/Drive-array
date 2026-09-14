package la;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final e f11860a = e.u("<no name provided>");

    /* renamed from: b, reason: collision with root package name */
    public static final e f11861b;

    /* renamed from: c, reason: collision with root package name */
    public static final e f11862c;

    static {
        e.u("<root package>");
        f11861b = e.r("Companion");
        f11862c = e.r("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        e.u("<anonymous>");
    }

    private static /* synthetic */ void a(int i10) {
        String str = i10 != 1 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i10 != 1 ? 2 : 3];
        if (i10 != 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        } else {
            objArr[0] = "name";
        }
        if (i10 != 1) {
            objArr[1] = "safeIdentifier";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        }
        if (i10 == 1) {
            objArr[2] = "isSafeIdentifier";
        }
        String format = String.format(str, objArr);
        if (i10 == 1) {
            throw new IllegalArgumentException(format);
        }
    }

    public static boolean b(e eVar) {
        if (eVar == null) {
            a(1);
        }
        return (eVar.k().isEmpty() || eVar.s()) ? false : true;
    }

    public static e c(e eVar) {
        if (eVar == null || eVar.s()) {
            eVar = f11862c;
        }
        if (eVar == null) {
            a(0);
        }
        return eVar;
    }
}
