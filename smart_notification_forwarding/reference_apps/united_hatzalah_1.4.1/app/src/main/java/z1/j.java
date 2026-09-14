package z1;

import java.util.concurrent.Executor;
import r2.InterfaceC0645a;
import t1.u;

/* loaded from: classes.dex */
public final class j implements v1.b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0645a f6876a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0645a f6877b;

    /* renamed from: c, reason: collision with root package name */
    public final u f6878c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0645a f6879d;

    public j(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, u uVar, InterfaceC0645a interfaceC0645a3) {
        this.f6876a = interfaceC0645a;
        this.f6877b = interfaceC0645a2;
        this.f6878c = uVar;
        this.f6879d = interfaceC0645a3;
    }

    @Override // r2.InterfaceC0645a
    public final Object get() {
        return new i((Executor) this.f6876a.get(), (A1.d) this.f6877b.get(), (c) this.f6878c.get(), (B1.b) this.f6879d.get());
    }
}
