package q9;

import n9.g1;
import n9.h1;
import y8.k;

/* loaded from: classes.dex */
public final class a extends h1 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f13578c = new a();

    private a() {
        super("package", false);
    }

    @Override // n9.h1
    public Integer a(h1 h1Var) {
        k.e(h1Var, "visibility");
        return Integer.valueOf(this == h1Var ? 0 : g1.f12279a.b(h1Var) ? 1 : -1);
    }

    @Override // n9.h1
    public String b() {
        return "public/*package*/";
    }

    @Override // n9.h1
    public h1 d() {
        return g1.g.f12287c;
    }
}
