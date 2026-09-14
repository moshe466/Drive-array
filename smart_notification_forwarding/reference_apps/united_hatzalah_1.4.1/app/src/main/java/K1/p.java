package K1;

import W1.Z;
import W1.f0;
import W1.g0;
import W1.h0;
import W1.i0;
import W1.j0;
import W1.k0;
import W1.r0;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1110a = 0;

    static {
        Charset.forName("UTF-8");
    }

    public static k0 a(g0 g0Var) {
        h0 z3 = k0.z();
        int B3 = g0Var.B();
        z3.e();
        k0.w((k0) z3.f4158b, B3);
        for (f0 f0Var : g0Var.A()) {
            i0 B4 = j0.B();
            String B5 = f0Var.A().B();
            B4.e();
            j0.w((j0) B4.f4158b, B5);
            Z D3 = f0Var.D();
            B4.e();
            j0.y((j0) B4.f4158b, D3);
            r0 C3 = f0Var.C();
            B4.e();
            j0.x((j0) B4.f4158b, C3);
            int B6 = f0Var.B();
            B4.e();
            j0.z((j0) B4.f4158b, B6);
            j0 j0Var = (j0) B4.b();
            z3.e();
            k0.x((k0) z3.f4158b, j0Var);
        }
        return (k0) z3.b();
    }
}
