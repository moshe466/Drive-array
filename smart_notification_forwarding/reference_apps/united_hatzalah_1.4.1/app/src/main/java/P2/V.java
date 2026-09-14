package P2;

/* loaded from: classes.dex */
public final class V extends W {

    /* renamed from: c, reason: collision with root package name */
    public final G0 f1630c;

    public V(long j2, G0 g02) {
        super(j2);
        this.f1630c = g02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1630c.run();
    }

    @Override // P2.W
    public final String toString() {
        return super.toString() + this.f1630c;
    }
}
