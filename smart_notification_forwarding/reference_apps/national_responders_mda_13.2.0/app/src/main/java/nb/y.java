package nb;

/* loaded from: classes.dex */
public final class y {
    public static final void a(p8.f fVar, Throwable th) {
        try {
            v vVar = (v) fVar.get(v.f12432c);
            if (vVar == null) {
                x.a(fVar, th);
            } else {
                vVar.handleException(fVar, th);
            }
        } catch (Throwable th2) {
            x.a(fVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        l8.b.a(runtimeException, th);
        return runtimeException;
    }
}
