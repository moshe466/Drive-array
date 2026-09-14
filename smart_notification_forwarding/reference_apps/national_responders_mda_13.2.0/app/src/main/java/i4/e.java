package i4;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f10733a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10734b;

    /* renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f10735c;

    /* renamed from: d, reason: collision with root package name */
    public final e f10736d;

    public e(Throwable th, d dVar) {
        this.f10733a = th.getLocalizedMessage();
        this.f10734b = th.getClass().getName();
        this.f10735c = dVar.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f10736d = cause != null ? new e(cause, dVar) : null;
    }
}
