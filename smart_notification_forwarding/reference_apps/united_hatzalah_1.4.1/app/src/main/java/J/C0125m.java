package J;

import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.InterfaceC0309t;

/* renamed from: J.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0125m implements androidx.lifecycle.r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1011a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1012b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1013c;

    public /* synthetic */ C0125m(int i, Object obj, Object obj2) {
        this.f1011a = i;
        this.f1012b = obj;
        this.f1013c = obj2;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        switch (this.f1011a) {
            case 0:
                C0127o c0127o = (C0127o) this.f1012b;
                InterfaceC0128p interfaceC0128p = (InterfaceC0128p) this.f1013c;
                if (enumC0303m == EnumC0303m.ON_DESTROY) {
                    c0127o.b(interfaceC0128p);
                    return;
                } else {
                    c0127o.getClass();
                    return;
                }
            default:
                c.x xVar = (c.x) this.f1012b;
                c.m mVar = (c.m) this.f1013c;
                if (enumC0303m == EnumC0303m.ON_CREATE) {
                    xVar.f3860e = F.b.a(mVar);
                    xVar.d(xVar.f3862g);
                    return;
                }
                return;
        }
    }
}
