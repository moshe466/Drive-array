package i7;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    static c f10744a;

    protected c() {
    }

    private static c a() {
        if (f10744a == null) {
            f10744a = new c();
        }
        return f10744a;
    }

    public static void c(long j10) {
        a().b(j10);
    }

    protected void b(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException unused) {
        }
    }
}
