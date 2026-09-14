package nb;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o0 implements w0 {

    /* renamed from: f, reason: collision with root package name */
    private final boolean f12411f;

    public o0(boolean z10) {
        this.f12411f = z10;
    }

    @Override // nb.w0
    public boolean d() {
        return this.f12411f;
    }

    @Override // nb.w0
    public j1 i() {
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(d() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
