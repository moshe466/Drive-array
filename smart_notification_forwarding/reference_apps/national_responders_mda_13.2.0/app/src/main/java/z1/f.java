package z1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.w;
import b2.p;

/* loaded from: classes.dex */
public class f extends androidx.fragment.app.e {

    /* renamed from: u0, reason: collision with root package name */
    private Dialog f16072u0;

    /* renamed from: v0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f16073v0;

    /* renamed from: w0, reason: collision with root package name */
    private Dialog f16074w0;

    public static f j2(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        f fVar = new f();
        Dialog dialog2 = (Dialog) p.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        fVar.f16072u0 = dialog2;
        if (onCancelListener != null) {
            fVar.f16073v0 = onCancelListener;
        }
        return fVar;
    }

    @Override // androidx.fragment.app.e
    public Dialog b2(Bundle bundle) {
        Dialog dialog = this.f16072u0;
        if (dialog != null) {
            return dialog;
        }
        g2(false);
        if (this.f16074w0 == null) {
            this.f16074w0 = new AlertDialog.Builder((Context) p.k(A())).create();
        }
        return this.f16074w0;
    }

    @Override // androidx.fragment.app.e
    public void i2(w wVar, String str) {
        super.i2(wVar, str);
    }

    @Override // androidx.fragment.app.e, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f16073v0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
