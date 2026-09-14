package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* renamed from: androidx.fragment.app.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0282q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3486a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3487b;

    public /* synthetic */ RunnableC0282q(Object obj, int i) {
        this.f3486a = i;
        this.f3487b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DialogInterface.OnDismissListener onDismissListener;
        Dialog dialog;
        switch (this.f3486a) {
            case 0:
                DialogInterfaceOnCancelListenerC0285u dialogInterfaceOnCancelListenerC0285u = (DialogInterfaceOnCancelListenerC0285u) this.f3487b;
                onDismissListener = dialogInterfaceOnCancelListenerC0285u.mOnDismissListener;
                dialog = dialogInterfaceOnCancelListenerC0285u.mDialog;
                onDismissListener.onDismiss(dialog);
                return;
            case 1:
                C0281p c0281p = (C0281p) this.f3487b;
                if (!c0281p.f3477b.isEmpty()) {
                    c0281p.e();
                    return;
                }
                return;
            default:
                ((AbstractC0272g0) this.f3487b).z(true);
                return;
        }
    }
}
