package m;

/* loaded from: classes.dex */
public final class S0 {

    /* renamed from: a, reason: collision with root package name */
    public int f5593a;

    /* renamed from: b, reason: collision with root package name */
    public int f5594b;

    /* renamed from: c, reason: collision with root package name */
    public int f5595c;

    /* renamed from: d, reason: collision with root package name */
    public int f5596d;

    /* renamed from: e, reason: collision with root package name */
    public int f5597e;

    /* renamed from: f, reason: collision with root package name */
    public int f5598f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5599g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5600h;

    public final void a(int i, int i3) {
        this.f5595c = i;
        this.f5596d = i3;
        this.f5600h = true;
        if (this.f5599g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f5593a = i3;
            }
            if (i != Integer.MIN_VALUE) {
                this.f5594b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f5593a = i;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f5594b = i3;
        }
    }
}
