package P2;

import s2.C0684i;

/* loaded from: classes.dex */
public final class U extends W {

    /* renamed from: c, reason: collision with root package name */
    public final C0163m f1628c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Y f1629d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(Y y, long j2, C0163m c0163m) {
        super(j2);
        this.f1629d = y;
        this.f1628c = c0163m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1628c.A(this.f1629d, C0684i.f6340a);
    }

    @Override // P2.W
    public final String toString() {
        return super.toString() + this.f1628c;
    }
}
