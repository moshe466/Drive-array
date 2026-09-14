package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* renamed from: androidx.fragment.app.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnDismissListenerC0283s implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0285u f3511a;

    public DialogInterfaceOnDismissListenerC0283s(DialogInterfaceOnCancelListenerC0285u dialogInterfaceOnCancelListenerC0285u) {
        this.f3511a = dialogInterfaceOnCancelListenerC0285u;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Dialog dialog;
        Dialog dialog2;
        DialogInterfaceOnCancelListenerC0285u dialogInterfaceOnCancelListenerC0285u = this.f3511a;
        dialog = dialogInterfaceOnCancelListenerC0285u.mDialog;
        if (dialog != null) {
            dialog2 = dialogInterfaceOnCancelListenerC0285u.mDialog;
            dialogInterfaceOnCancelListenerC0285u.onDismiss(dialog2);
        }
    }
}
