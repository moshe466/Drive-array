package M;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f1354a;

    /* renamed from: b, reason: collision with root package name */
    public int f1355b;

    /* renamed from: c, reason: collision with root package name */
    public float f1356c;

    /* renamed from: d, reason: collision with root package name */
    public float f1357d;

    /* renamed from: e, reason: collision with root package name */
    public long f1358e;

    /* renamed from: f, reason: collision with root package name */
    public long f1359f;

    /* renamed from: g, reason: collision with root package name */
    public long f1360g;

    /* renamed from: h, reason: collision with root package name */
    public float f1361h;
    public int i;

    public final float a(long j2) {
        long j3 = this.f1358e;
        if (j2 < j3) {
            return 0.0f;
        }
        long j4 = this.f1360g;
        if (j4 >= 0 && j2 >= j4) {
            float f4 = this.f1361h;
            return (d.b(((float) (j2 - j4)) / this.i, 0.0f, 1.0f) * f4) + (1.0f - f4);
        }
        return d.b(((float) (j2 - j3)) / this.f1354a, 0.0f, 1.0f) * 0.5f;
    }
}
