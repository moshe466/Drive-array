package t0;

import u0.AbstractC0733k;
import u0.C0724b;
import u0.F;
import u0.H;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final u0.y f6377a;

    /* JADX WARN: Type inference failed for: r0v0, types: [u0.y, java.lang.Object] */
    static {
        ?? obj = new Object();
        C0724b c0724b = F.f6547z;
        if (c0724b.a()) {
            obj.f6581a = AbstractC0733k.a();
            obj.f6582b = null;
        } else if (c0724b.b()) {
            obj.f6581a = null;
            obj.f6582b = H.f6549a.getTracingController();
        } else {
            throw F.a();
        }
        f6377a = obj;
    }
}
