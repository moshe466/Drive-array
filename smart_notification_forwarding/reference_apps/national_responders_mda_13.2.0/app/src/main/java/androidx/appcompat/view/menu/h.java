package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.m;

/* loaded from: classes.dex */
class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* renamed from: f, reason: collision with root package name */
    private g f950f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.appcompat.app.b f951g;

    /* renamed from: h, reason: collision with root package name */
    e f952h;

    /* renamed from: i, reason: collision with root package name */
    private m.a f953i;

    public h(g gVar) {
        this.f950f = gVar;
    }

    public void a() {
        androidx.appcompat.app.b bVar = this.f951g;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void b(g gVar, boolean z10) {
        if (z10 || gVar == this.f950f) {
            a();
        }
        m.a aVar = this.f953i;
        if (aVar != null) {
            aVar.b(gVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean c(g gVar) {
        m.a aVar = this.f953i;
        if (aVar != null) {
            return aVar.c(gVar);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        g gVar = this.f950f;
        b.a aVar = new b.a(gVar.u());
        e eVar = new e(aVar.b(), e.g.f8965j);
        this.f952h = eVar;
        eVar.k(this);
        this.f950f.b(this.f952h);
        aVar.c(this.f952h.a(), this);
        View y10 = gVar.y();
        if (y10 != null) {
            aVar.e(y10);
        } else {
            aVar.f(gVar.w()).l(gVar.x());
        }
        aVar.i(this);
        androidx.appcompat.app.b a10 = aVar.a();
        this.f951g = a10;
        a10.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f951g.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f951g.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f950f.L((i) this.f952h.a().getItem(i10), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f952h.b(this.f950f, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f951g.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f951g.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f950f.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f950f.performShortcut(i10, keyEvent, 0);
    }
}
