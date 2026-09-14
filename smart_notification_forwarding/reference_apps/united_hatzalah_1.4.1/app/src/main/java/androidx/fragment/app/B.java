package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;
import androidx.lifecycle.InterfaceC0309t;
import java.util.Objects;

/* loaded from: classes.dex */
public final class B implements androidx.lifecycle.C {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3259a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3260b;

    public /* synthetic */ B(Object obj, int i) {
        this.f3259a = i;
        this.f3260b = obj;
    }

    @Override // androidx.lifecycle.C
    public void g(Object obj) {
        boolean z3;
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        InterfaceC0309t interfaceC0309t = (InterfaceC0309t) obj;
        DialogInterfaceOnCancelListenerC0285u dialogInterfaceOnCancelListenerC0285u = (DialogInterfaceOnCancelListenerC0285u) this.f3260b;
        if (interfaceC0309t != null) {
            z3 = dialogInterfaceOnCancelListenerC0285u.mShowsDialog;
            if (z3) {
                View requireView = dialogInterfaceOnCancelListenerC0285u.requireView();
                if (requireView.getParent() == null) {
                    dialog = dialogInterfaceOnCancelListenerC0285u.mDialog;
                    if (dialog != null) {
                        if (AbstractC0272g0.J(3)) {
                            dialog3 = dialogInterfaceOnCancelListenerC0285u.mDialog;
                            Objects.toString(dialog3);
                        }
                        dialog2 = dialogInterfaceOnCancelListenerC0285u.mDialog;
                        dialog2.setContentView(requireView);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
        }
    }
}
