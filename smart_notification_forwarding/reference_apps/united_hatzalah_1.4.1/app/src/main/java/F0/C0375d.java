package f0;

import androidx.lifecycle.C;

/* renamed from: f0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0375d implements C {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.loader.content.e f4482a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0372a f4483b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4484c = false;

    public C0375d(androidx.loader.content.e eVar, InterfaceC0372a interfaceC0372a) {
        this.f4482a = eVar;
        this.f4483b = interfaceC0372a;
    }

    @Override // androidx.lifecycle.C
    public final void g(Object obj) {
        this.f4483b.onLoadFinished(this.f4482a, obj);
        this.f4484c = true;
    }

    public final String toString() {
        return this.f4483b.toString();
    }
}
