package f7;

/* loaded from: classes.dex */
public enum a {
    ZPL("ZPL"),
    CPCL("CPCL"),
    LINE_PRINT("LINE_PRINT");

    private final String name;

    a(String str) {
        this.name = str;
    }

    public static a getLanguage(String str) {
        String str2 = "ZPL";
        if (str == null) {
            str = "<null>";
        }
        try {
            String upperCase = str.toUpperCase();
            if (!upperCase.contains("ZPL")) {
                str2 = upperCase;
            }
            return valueOf(str2);
        } catch (Exception unused) {
            throw new f(str + " is not a valid Zebra printer language");
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
