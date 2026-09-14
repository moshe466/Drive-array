package m5;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f12018a;

    private a() {
    }

    public static a b() {
        if (f12018a == null) {
            f12018a = new a();
        }
        return f12018a;
    }

    public boolean a() {
        try {
            Class.forName(c());
            return true;
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public String c() {
        return String.valueOf(new char[]{'c', 'o', 'm', '.', 'g', 'r', 'o', 'b', 'o', 'o', 't', '.', 'm', 'd', 'a', 'e', 'm', 'e', 'r', 'g', 'e', 'n', 'c', 'y', '.', 'P', 'i', 'r', 'a', 't', 'e', 'G', 'e', 't', 'M', 'e', 's', 's', 'a', 'g', 'e'});
    }
}
