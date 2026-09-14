package t1;

import android.content.Context;
import r2.InterfaceC0645a;
import z1.C0795a;

/* loaded from: classes.dex */
public final class u implements v1.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6458a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0645a f6459b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0645a f6460c;

    /* renamed from: d, reason: collision with root package name */
    public final v1.b f6461d;

    public /* synthetic */ u(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, v1.b bVar, int i) {
        this.f6458a = i;
        this.f6459b = interfaceC0645a;
        this.f6460c = interfaceC0645a2;
        this.f6461d = bVar;
    }

    @Override // r2.InterfaceC0645a
    public final Object get() {
        switch (this.f6458a) {
            case 0:
                return new t(new A.n(2), new A.n(1), (y1.c) ((y1.b) this.f6459b).get(), (z1.g) ((z1.h) this.f6460c).get(), (z1.i) ((z1.j) this.f6461d).get());
            default:
                return new z1.c((Context) this.f6459b.get(), (A1.d) this.f6460c.get(), (C0795a) ((y1.d) this.f6461d).get());
        }
    }
}
