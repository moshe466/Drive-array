package l;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import h.DialogInterfaceC0438h;

/* loaded from: classes.dex */
public final class n implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, y {

    /* renamed from: a, reason: collision with root package name */
    public SubMenuC0502F f5422a;

    /* renamed from: b, reason: collision with root package name */
    public DialogInterfaceC0438h f5423b;

    /* renamed from: c, reason: collision with root package name */
    public i f5424c;

    @Override // l.y
    public final void b(m mVar, boolean z3) {
        DialogInterfaceC0438h dialogInterfaceC0438h;
        if ((z3 || mVar == this.f5422a) && (dialogInterfaceC0438h = this.f5423b) != null) {
            dialogInterfaceC0438h.dismiss();
        }
    }

    @Override // l.y
    public final boolean d(m mVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SubMenuC0502F subMenuC0502F = this.f5422a;
        i iVar = this.f5424c;
        if (iVar.f5392f == null) {
            iVar.f5392f = new C0510h(iVar);
        }
        subMenuC0502F.q(iVar.f5392f.getItem(i), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f5424c.b(this.f5422a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        SubMenuC0502F subMenuC0502F = this.f5422a;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f5423b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f5423b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                subMenuC0502F.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return subMenuC0502F.performShortcut(i, keyEvent, 0);
    }
}
