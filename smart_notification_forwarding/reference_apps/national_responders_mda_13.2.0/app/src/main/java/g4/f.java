package g4;

/* loaded from: classes.dex */
public class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final b f9787a;

    /* renamed from: b, reason: collision with root package name */
    public final d f9788b;

    /* renamed from: c, reason: collision with root package name */
    public final c f9789c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9790d;

    public f(long j10, b bVar, d dVar, c cVar, int i10, int i11) {
        this.f9790d = j10;
        this.f9787a = bVar;
        this.f9788b = dVar;
        this.f9789c = cVar;
    }

    @Override // g4.e
    public d a() {
        return this.f9788b;
    }

    @Override // g4.e
    public c b() {
        return this.f9789c;
    }

    public b c() {
        return this.f9787a;
    }

    public long d() {
        return this.f9790d;
    }

    public boolean e(long j10) {
        return this.f9790d < j10;
    }
}
