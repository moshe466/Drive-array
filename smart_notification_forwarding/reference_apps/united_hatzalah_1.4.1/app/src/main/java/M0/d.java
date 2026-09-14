package M0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1394a;

    /* renamed from: b, reason: collision with root package name */
    public long f1395b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1396c;

    public d(long j2, Y0.b bVar) {
        this.f1394a = 0;
        this.f1395b = j2;
        this.f1396c = bVar;
    }

    public int a(int i) {
        d dVar = (d) this.f1396c;
        if (dVar == null) {
            if (i >= 64) {
                return Long.bitCount(this.f1395b);
            }
            return Long.bitCount(this.f1395b & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.f1395b & ((1 << i) - 1));
        }
        return Long.bitCount(this.f1395b) + dVar.a(i - 64);
    }

    public boolean b(int i) {
        if (i >= 64) {
            if (((d) this.f1396c) == null) {
                this.f1396c = new d();
            }
            return ((d) this.f1396c).b(i - 64);
        }
        if ((this.f1395b & (1 << i)) != 0) {
            return true;
        }
        return false;
    }

    public void c() {
        this.f1395b = 0L;
        d dVar = (d) this.f1396c;
        if (dVar != null) {
            dVar.c();
        }
    }

    public String toString() {
        switch (this.f1394a) {
            case 1:
                if (((d) this.f1396c) == null) {
                    return Long.toBinaryString(this.f1395b);
                }
                return ((d) this.f1396c).toString() + "xx" + Long.toBinaryString(this.f1395b);
            default:
                return super.toString();
        }
    }

    public d() {
        this.f1394a = 1;
        this.f1395b = 0L;
    }
}
