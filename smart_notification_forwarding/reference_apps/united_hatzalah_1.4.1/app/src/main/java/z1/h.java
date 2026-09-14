package z1;

import A.n;
import android.content.Context;
import java.util.concurrent.Executor;
import r2.InterfaceC0645a;
import t1.u;

/* loaded from: classes.dex */
public final class h implements v1.b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0645a f6865a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0645a f6866b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0645a f6867c;

    /* renamed from: d, reason: collision with root package name */
    public final u f6868d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0645a f6869e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC0645a f6870f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC0645a f6871g;

    public h(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, InterfaceC0645a interfaceC0645a3, u uVar, InterfaceC0645a interfaceC0645a4, InterfaceC0645a interfaceC0645a5, InterfaceC0645a interfaceC0645a6) {
        this.f6865a = interfaceC0645a;
        this.f6866b = interfaceC0645a2;
        this.f6867c = interfaceC0645a3;
        this.f6868d = uVar;
        this.f6869e = interfaceC0645a4;
        this.f6870f = interfaceC0645a5;
        this.f6871g = interfaceC0645a6;
    }

    @Override // r2.InterfaceC0645a
    public final Object get() {
        return new g((Context) this.f6865a.get(), (u1.f) this.f6866b.get(), (A1.d) this.f6867c.get(), (c) this.f6868d.get(), (Executor) this.f6869e.get(), (B1.b) this.f6870f.get(), new n(2), new n(1), (A1.c) this.f6871g.get());
    }
}
