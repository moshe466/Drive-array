package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class r implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0285u f3496a;

    public r(DialogInterfaceOnCancelListenerC0285u dialogInterfaceOnCancelListenerC0285u) {
        this.f3496a = dialogInterfaceOnCancelListenerC0285u;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Dialog dialog;
        Dialog dialog2;
        DialogInterfaceOnCancelListenerC0285u dialogInterfaceOnCancelListenerC0285u = this.f3496a;
        dialog = dialogInterfaceOnCancelListenerC0285u.mDialog;
        if (dialog != null) {
            dialog2 = dialogInterfaceOnCancelListenerC0285u.mDialog;
            dialogInterfaceOnCancelListenerC0285u.onCancel(dialog2);
        }
    }
}
