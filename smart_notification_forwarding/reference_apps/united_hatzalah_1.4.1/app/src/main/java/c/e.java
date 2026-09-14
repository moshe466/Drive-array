package c;

import android.view.View;
import android.view.Window;
import androidx.fragment.app.L;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.InterfaceC0309t;
import l0.C0514d;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements androidx.lifecycle.r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3818a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3819b;

    public /* synthetic */ e(Object obj, int i) {
        this.f3818a = i;
        this.f3819b = obj;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        Window window;
        View peekDecorView;
        switch (this.f3818a) {
            case 0:
                L l3 = (L) this.f3819b;
                if (enumC0303m == EnumC0303m.ON_STOP && (window = l3.getWindow()) != null && (peekDecorView = window.peekDecorView()) != null) {
                    peekDecorView.cancelPendingInputEvents();
                    return;
                }
                return;
            case 1:
                m.c((L) this.f3819b, interfaceC0309t, enumC0303m);
                return;
            default:
                C0514d this$0 = (C0514d) this.f3819b;
                kotlin.jvm.internal.j.e(this$0, "this$0");
                if (enumC0303m == EnumC0303m.ON_START) {
                    this$0.f5479f = true;
                    return;
                } else {
                    if (enumC0303m == EnumC0303m.ON_STOP) {
                        this$0.f5479f = false;
                        return;
                    }
                    return;
                }
        }
    }
}
