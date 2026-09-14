package b2;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class d1 extends p0 {

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ c f3957g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(c cVar, int i10, Bundle bundle) {
        super(cVar, i10, null);
        this.f3957g = cVar;
    }

    @Override // b2.p0
    protected final void f(com.google.android.gms.common.a aVar) {
        if (this.f3957g.y() && c.m0(this.f3957g)) {
            c.i0(this.f3957g, 16);
        } else {
            this.f3957g.f3935o.a(aVar);
            this.f3957g.Q(aVar);
        }
    }

    @Override // b2.p0
    protected final boolean g() {
        this.f3957g.f3935o.a(com.google.android.gms.common.a.f4739j);
        return true;
    }
}
