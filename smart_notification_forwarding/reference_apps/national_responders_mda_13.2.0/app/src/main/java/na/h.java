package na;

/* loaded from: classes.dex */
public abstract class h extends i {
    @Override // na.i
    public void b(n9.b bVar, n9.b bVar2) {
        y8.k.e(bVar, "first");
        y8.k.e(bVar2, "second");
        e(bVar, bVar2);
    }

    @Override // na.i
    public void c(n9.b bVar, n9.b bVar2) {
        y8.k.e(bVar, "fromSuper");
        y8.k.e(bVar2, "fromCurrent");
        e(bVar, bVar2);
    }

    protected abstract void e(n9.b bVar, n9.b bVar2);
}
