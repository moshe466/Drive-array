package z1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import b2.p;

/* loaded from: classes.dex */
public class b extends DialogFragment {

    /* renamed from: f, reason: collision with root package name */
    private Dialog f16065f;

    /* renamed from: g, reason: collision with root package name */
    private DialogInterface.OnCancelListener f16066g;

    /* renamed from: h, reason: collision with root package name */
    private Dialog f16067h;

    public static b a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        b bVar = new b();
        Dialog dialog2 = (Dialog) p.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        bVar.f16065f = dialog2;
        if (onCancelListener != null) {
            bVar.f16066g = onCancelListener;
        }
        return bVar;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f16066g;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f16065f;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f16067h == null) {
            this.f16067h = new AlertDialog.Builder((Context) p.k(getActivity())).create();
        }
        return this.f16067h;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
