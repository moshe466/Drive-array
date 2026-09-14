package N2;

/* loaded from: classes.dex */
public abstract class n extends m {
    public static String G(byte[] bArr) {
        return new String(bArr, a.f1508a);
    }

    public static byte[] H(String str) {
        kotlin.jvm.internal.j.e(str, "<this>");
        byte[] bytes = str.getBytes(a.f1508a);
        kotlin.jvm.internal.j.d(bytes, "getBytes(...)");
        return bytes;
    }

    public static boolean I(String str, String suffix) {
        kotlin.jvm.internal.j.e(str, "<this>");
        kotlin.jvm.internal.j.e(suffix, "suffix");
        return str.endsWith(suffix);
    }

    public static boolean J(String str, String str2) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static final boolean K(int i, int i3, int i4, String str, String other, boolean z3) {
        kotlin.jvm.internal.j.e(str, "<this>");
        kotlin.jvm.internal.j.e(other, "other");
        if (!z3) {
            return str.regionMatches(i, other, i3, i4);
        }
        return str.regionMatches(z3, i, other, i3, i4);
    }

    public static String L(String str, String str2, String newValue) {
        kotlin.jvm.internal.j.e(str, "<this>");
        kotlin.jvm.internal.j.e(newValue, "newValue");
        int R3 = f.R(str, str2, 0, false);
        if (R3 < 0) {
            return str;
        }
        int length = str2.length();
        int i = 1;
        if (length >= 1) {
            i = length;
        }
        int length2 = newValue.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            int i3 = 0;
            do {
                sb.append((CharSequence) str, i3, R3);
                sb.append(newValue);
                i3 = R3 + length;
                if (R3 >= str.length()) {
                    break;
                }
                R3 = f.R(str, str2, R3 + i, false);
            } while (R3 > 0);
            sb.append((CharSequence) str, i3, str.length());
            String sb2 = sb.toString();
            kotlin.jvm.internal.j.d(sb2, "toString(...)");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static boolean M(String str, String prefix) {
        kotlin.jvm.internal.j.e(str, "<this>");
        kotlin.jvm.internal.j.e(prefix, "prefix");
        return str.startsWith(prefix);
    }
}
