package p2;

/* loaded from: classes.dex */
final class l extends i {

    /* renamed from: a, reason: collision with root package name */
    private final k f13046a = new k();

    @Override // p2.i
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        this.f13046a.a(th, true).add(th2);
    }
}
