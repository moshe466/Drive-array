package c7;

/* loaded from: classes.dex */
public class a {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        StringBuilder sb2 = new StringBuilder();
        if (trim.length() == 12) {
            sb2.append(trim.substring(0, 2));
            sb2.append(":");
            sb2.append(trim.substring(2, 4));
            sb2.append(":");
            sb2.append(trim.substring(4, 6));
            sb2.append(":");
            sb2.append(trim.substring(6, 8));
            sb2.append(":");
            sb2.append(trim.substring(8, 10));
            sb2.append(":");
            trim = trim.substring(10, 12);
        }
        sb2.append(trim);
        return sb2.toString().toUpperCase();
    }
}
