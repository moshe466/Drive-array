package y1;

import java.util.concurrent.Executor;
import r2.InterfaceC0645a;
import t1.u;
import u1.f;

/* loaded from: classes.dex */
public final class b implements v1.b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0645a f6756a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0645a f6757b;

    /* renamed from: c, reason: collision with root package name */
    public final u f6758c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0645a f6759d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0645a f6760e;

    public b(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, u uVar, InterfaceC0645a interfaceC0645a3, InterfaceC0645a interfaceC0645a4) {
        this.f6756a = interfaceC0645a;
        this.f6757b = interfaceC0645a2;
        this.f6758c = uVar;
        this.f6759d = interfaceC0645a3;
        this.f6760e = interfaceC0645a4;
    }

    @Override // r2.InterfaceC0645a
    public final Object get() {
        return new C0784a((Executor) this.f6756a.get(), (f) this.f6757b.get(), (z1.c) this.f6758c.get(), (A1.d) this.f6759d.get(), (B1.b) this.f6760e.get());
    }
}
