package n;

/* renamed from: n.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0590a extends E1.b {

    /* renamed from: c, reason: collision with root package name */
    public static volatile C0590a f5874c;

    /* renamed from: b, reason: collision with root package name */
    public final C0591b f5875b = new C0591b();

    public static C0590a B() {
        if (f5874c != null) {
            return f5874c;
        }
        synchronized (C0590a.class) {
            try {
                if (f5874c == null) {
                    f5874c = new C0590a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f5874c;
    }
}
