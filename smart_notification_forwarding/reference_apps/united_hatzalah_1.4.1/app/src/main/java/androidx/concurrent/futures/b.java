package androidx.concurrent.futures;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f3016c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f3017d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3018a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f3019b;

    static {
        if (j.GENERATE_CANCELLATION_CAUSES) {
            f3017d = null;
            f3016c = null;
        } else {
            f3017d = new b(null, false);
            f3016c = new b(null, true);
        }
    }

    public b(Throwable th, boolean z3) {
        this.f3018a = z3;
        this.f3019b = th;
    }
}
