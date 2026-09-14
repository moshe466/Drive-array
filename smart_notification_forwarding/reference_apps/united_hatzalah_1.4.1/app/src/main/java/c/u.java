package c;

import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.InterfaceC0309t;

/* loaded from: classes.dex */
public final class u implements androidx.lifecycle.r, InterfaceC0326b {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0305o f3849a;

    /* renamed from: b, reason: collision with root package name */
    public final p f3850b;

    /* renamed from: c, reason: collision with root package name */
    public v f3851c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x f3852d;

    public u(x xVar, AbstractC0305o abstractC0305o, p onBackPressedCallback) {
        kotlin.jvm.internal.j.e(onBackPressedCallback, "onBackPressedCallback");
        this.f3852d = xVar;
        this.f3849a = abstractC0305o;
        this.f3850b = onBackPressedCallback;
        abstractC0305o.a(this);
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        if (enumC0303m == EnumC0303m.ON_START) {
            x xVar = this.f3852d;
            xVar.getClass();
            p onBackPressedCallback = this.f3850b;
            kotlin.jvm.internal.j.e(onBackPressedCallback, "onBackPressedCallback");
            xVar.f3857b.addLast(onBackPressedCallback);
            v vVar = new v(xVar, onBackPressedCallback);
            onBackPressedCallback.addCancellable(vVar);
            xVar.e();
            onBackPressedCallback.setEnabledChangedCallback$activity_release(new w(0, xVar, x.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 1));
            this.f3851c = vVar;
            return;
        }
        if (enumC0303m == EnumC0303m.ON_STOP) {
            v vVar2 = this.f3851c;
            if (vVar2 != null) {
                vVar2.cancel();
                return;
            }
            return;
        }
        if (enumC0303m == EnumC0303m.ON_DESTROY) {
            cancel();
        }
    }

    @Override // c.InterfaceC0326b
    public final void cancel() {
        this.f3849a.b(this);
        this.f3850b.removeCancellable(this);
        v vVar = this.f3851c;
        if (vVar != null) {
            vVar.cancel();
        }
        this.f3851c = null;
    }
}
