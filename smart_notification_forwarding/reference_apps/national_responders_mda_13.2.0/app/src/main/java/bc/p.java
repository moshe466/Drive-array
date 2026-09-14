package bc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    static o f4335a;

    /* renamed from: b, reason: collision with root package name */
    static long f4336b;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(o oVar) {
        if (oVar.f4333f != null || oVar.f4334g != null) {
            throw new IllegalArgumentException();
        }
        if (oVar.f4331d) {
            return;
        }
        synchronized (p.class) {
            long j10 = f4336b;
            if (j10 + 8192 > 65536) {
                return;
            }
            f4336b = j10 + 8192;
            oVar.f4333f = f4335a;
            oVar.f4330c = 0;
            oVar.f4329b = 0;
            f4335a = oVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o b() {
        synchronized (p.class) {
            o oVar = f4335a;
            if (oVar == null) {
                return new o();
            }
            f4335a = oVar.f4333f;
            oVar.f4333f = null;
            f4336b -= 8192;
            return oVar;
        }
    }
}
