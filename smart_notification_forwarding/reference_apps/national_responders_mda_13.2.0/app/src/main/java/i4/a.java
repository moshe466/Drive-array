package i4;

/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private final int f10728a;

    /* renamed from: b, reason: collision with root package name */
    private final d[] f10729b;

    /* renamed from: c, reason: collision with root package name */
    private final b f10730c;

    public a(int i10, d... dVarArr) {
        this.f10728a = i10;
        this.f10729b = dVarArr;
        this.f10730c = new b(i10);
    }

    @Override // i4.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f10728a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (d dVar : this.f10729b) {
            if (stackTraceElementArr2.length <= this.f10728a) {
                break;
            }
            stackTraceElementArr2 = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.f10728a ? this.f10730c.a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
