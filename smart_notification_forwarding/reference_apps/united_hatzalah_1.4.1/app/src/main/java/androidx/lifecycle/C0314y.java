package androidx.lifecycle;

/* renamed from: androidx.lifecycle.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0314y extends AbstractC0315z implements r {

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0309t f3626e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ A f3627f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0314y(A a2, InterfaceC0309t interfaceC0309t, C c4) {
        super(a2, c4);
        this.f3627f = a2;
        this.f3626e = interfaceC0309t;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        InterfaceC0309t interfaceC0309t2 = this.f3626e;
        EnumC0304n enumC0304n = ((C0311v) interfaceC0309t2.getLifecycle()).f3618c;
        if (enumC0304n == EnumC0304n.f3607a) {
            this.f3627f.g(this.f3628a);
            return;
        }
        EnumC0304n enumC0304n2 = null;
        while (enumC0304n2 != enumC0304n) {
            b(e());
            enumC0304n2 = enumC0304n;
            enumC0304n = ((C0311v) interfaceC0309t2.getLifecycle()).f3618c;
        }
    }

    @Override // androidx.lifecycle.AbstractC0315z
    public final void c() {
        this.f3626e.getLifecycle().b(this);
    }

    @Override // androidx.lifecycle.AbstractC0315z
    public final boolean d(InterfaceC0309t interfaceC0309t) {
        if (this.f3626e == interfaceC0309t) {
            return true;
        }
        return false;
    }

    @Override // androidx.lifecycle.AbstractC0315z
    public final boolean e() {
        if (((C0311v) this.f3626e.getLifecycle()).f3618c.compareTo(EnumC0304n.f3610d) >= 0) {
            return true;
        }
        return false;
    }
}
