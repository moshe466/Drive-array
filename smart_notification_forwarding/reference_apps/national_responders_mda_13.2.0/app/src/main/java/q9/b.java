package q9;

import n9.g1;
import n9.h1;
import y8.k;

/* loaded from: classes.dex */
public final class b extends h1 {

    /* renamed from: c, reason: collision with root package name */
    public static final b f13579c = new b();

    private b() {
        super("protected_and_package", true);
    }

    @Override // n9.h1
    public Integer a(h1 h1Var) {
        k.e(h1Var, "visibility");
        if (k.a(this, h1Var)) {
            return 0;
        }
        if (h1Var == g1.b.f12282c) {
            return null;
        }
        return Integer.valueOf(g1.f12279a.b(h1Var) ? 1 : -1);
    }

    @Override // n9.h1
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // n9.h1
    public h1 d() {
        return g1.g.f12287c;
    }
}
