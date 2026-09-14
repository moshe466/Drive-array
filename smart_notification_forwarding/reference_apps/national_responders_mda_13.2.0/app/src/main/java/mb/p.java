package mb;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends o {
    public static Double c(String str) {
        y8.k.e(str, "<this>");
        try {
            if (h.f12132b.b(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float d(String str) {
        y8.k.e(str, "<this>");
        try {
            if (h.f12132b.b(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
