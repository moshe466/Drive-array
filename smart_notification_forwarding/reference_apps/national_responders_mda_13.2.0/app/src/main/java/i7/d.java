package i7;

/* loaded from: classes.dex */
public class d {
    public static boolean a(String[] strArr, String str) {
        if (str == null || strArr == null || str.length() == 0 || strArr.length == 0) {
            return false;
        }
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (strArr[i10] != null && strArr[i10].length() != 0 && str.toUpperCase().startsWith(strArr[i10].toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '\"') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }
}
