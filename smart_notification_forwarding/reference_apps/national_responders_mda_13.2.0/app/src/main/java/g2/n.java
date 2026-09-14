package g2;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class n {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static boolean a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
