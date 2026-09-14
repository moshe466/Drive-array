package q2;

/* loaded from: classes.dex */
final class d1 extends b1 {

    /* renamed from: h, reason: collision with root package name */
    private final f1 f13481h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d1(f1 f1Var, int i10) {
        super(f1Var.size(), i10);
        this.f13481h = f1Var;
    }

    @Override // q2.b1
    protected final Object b(int i10) {
        return this.f13481h.get(i10);
    }
}
