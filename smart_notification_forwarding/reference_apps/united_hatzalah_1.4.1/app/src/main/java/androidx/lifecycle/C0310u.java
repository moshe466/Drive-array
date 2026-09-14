package androidx.lifecycle;

/* renamed from: androidx.lifecycle.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0310u {

    /* renamed from: a, reason: collision with root package name */
    public EnumC0304n f3614a;

    /* renamed from: b, reason: collision with root package name */
    public r f3615b;

    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        EnumC0304n a2 = enumC0303m.a();
        EnumC0304n state1 = this.f3614a;
        kotlin.jvm.internal.j.e(state1, "state1");
        if (a2.compareTo(state1) < 0) {
            state1 = a2;
        }
        this.f3614a = state1;
        this.f3615b.a(interfaceC0309t, enumC0303m);
        this.f3614a = a2;
    }
}
