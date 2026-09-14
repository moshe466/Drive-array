package m;

import F0.C0092v0;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import h.C0435e;
import h.DialogInterfaceC0438h;

/* loaded from: classes.dex */
public final class K implements Q, DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public DialogInterfaceC0438h f5555a;

    /* renamed from: b, reason: collision with root package name */
    public L f5556b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f5557c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ S f5558d;

    public K(S s3) {
        this.f5558d = s3;
    }

    @Override // m.Q
    public final boolean a() {
        DialogInterfaceC0438h dialogInterfaceC0438h = this.f5555a;
        if (dialogInterfaceC0438h != null) {
            return dialogInterfaceC0438h.isShowing();
        }
        return false;
    }

    @Override // m.Q
    public final int b() {
        return 0;
    }

    @Override // m.Q
    public final void c(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // m.Q
    public final CharSequence d() {
        return this.f5557c;
    }

    @Override // m.Q
    public final void dismiss() {
        DialogInterfaceC0438h dialogInterfaceC0438h = this.f5555a;
        if (dialogInterfaceC0438h != null) {
            dialogInterfaceC0438h.dismiss();
            this.f5555a = null;
        }
    }

    @Override // m.Q
    public final Drawable f() {
        return null;
    }

    @Override // m.Q
    public final void h(CharSequence charSequence) {
        this.f5557c = charSequence;
    }

    @Override // m.Q
    public final void i(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // m.Q
    public final void j(int i) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // m.Q
    public final void k(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // m.Q
    public final void l(int i, int i3) {
        if (this.f5556b == null) {
            return;
        }
        S s3 = this.f5558d;
        C0092v0 c0092v0 = new C0092v0(s3.getPopupContext());
        C0435e c0435e = (C0435e) c0092v0.f693b;
        CharSequence charSequence = this.f5557c;
        if (charSequence != null) {
            c0435e.f4786d = charSequence;
        }
        L l3 = this.f5556b;
        int selectedItemPosition = s3.getSelectedItemPosition();
        c0435e.f4794m = l3;
        c0435e.f4795n = this;
        c0435e.f4797q = selectedItemPosition;
        c0435e.p = true;
        DialogInterfaceC0438h b4 = c0092v0.b();
        this.f5555a = b4;
        AlertController$RecycleListView alertController$RecycleListView = b4.f4829f.f4809f;
        AbstractC0530I.d(alertController$RecycleListView, i);
        AbstractC0530I.c(alertController$RecycleListView, i3);
        this.f5555a.show();
    }

    @Override // m.Q
    public final int n() {
        return 0;
    }

    @Override // m.Q
    public final void o(ListAdapter listAdapter) {
        this.f5556b = (L) listAdapter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        S s3 = this.f5558d;
        s3.setSelection(i);
        if (s3.getOnItemClickListener() != null) {
            s3.performItemClick(null, i, this.f5556b.getItemId(i));
        }
        dismiss();
    }
}
