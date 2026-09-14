package v4;

/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private static b f14660a;

    private b() {
    }

    public static b b() {
        if (f14660a == null) {
            f14660a = new b();
        }
        return f14660a;
    }

    @Override // v4.a
    public long a() {
        return System.currentTimeMillis();
    }
}
