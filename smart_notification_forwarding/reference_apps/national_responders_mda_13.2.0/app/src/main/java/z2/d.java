package z2;

/* loaded from: classes.dex */
public final class d extends IllegalStateException {
    private d(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(l<?> lVar) {
        if (!lVar.o()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception k10 = lVar.k();
        return new d("Complete with: ".concat(k10 != null ? "failure" : lVar.p() ? "result ".concat(String.valueOf(lVar.l())) : lVar.n() ? "cancellation" : "unknown issue"), k10);
    }
}
