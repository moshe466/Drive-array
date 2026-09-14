package q0;

import a.AbstractC0228a;
import android.view.ViewGroup;

/* renamed from: q0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0618d extends r {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6070a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f6071b;

    public C0618d(ViewGroup viewGroup) {
        this.f6071b = viewGroup;
    }

    @Override // q0.r, q0.p
    public final void b() {
        AbstractC0228a.B(this.f6071b, false);
    }

    @Override // q0.r, q0.p
    public final void c() {
        AbstractC0228a.B(this.f6071b, false);
        this.f6070a = true;
    }

    @Override // q0.r, q0.p
    public final void d() {
        AbstractC0228a.B(this.f6071b, true);
    }

    @Override // q0.p
    public final void e(q qVar) {
        if (!this.f6070a) {
            AbstractC0228a.B(this.f6071b, false);
        }
        qVar.w(this);
    }
}
