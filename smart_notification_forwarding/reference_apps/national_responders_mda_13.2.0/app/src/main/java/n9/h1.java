package n9;

/* loaded from: classes.dex */
public abstract class h1 {

    /* renamed from: a, reason: collision with root package name */
    private final String f12290a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f12291b;

    /* JADX INFO: Access modifiers changed from: protected */
    public h1(String str, boolean z10) {
        y8.k.e(str, "name");
        this.f12290a = str;
        this.f12291b = z10;
    }

    public Integer a(h1 h1Var) {
        y8.k.e(h1Var, "visibility");
        return g1.f12279a.a(this, h1Var);
    }

    public String b() {
        return this.f12290a;
    }

    public final boolean c() {
        return this.f12291b;
    }

    public h1 d() {
        return this;
    }

    public final String toString() {
        return b();
    }
}
