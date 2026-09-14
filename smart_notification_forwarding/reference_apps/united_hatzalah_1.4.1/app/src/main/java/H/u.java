package h;

import F0.C0047j2;
import android.content.Context;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;
import k.AbstractC0458b;
import k.AbstractC0469m;
import t.C0694j;

/* loaded from: classes.dex */
public final class u implements Window.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final Window.Callback f4847a;

    /* renamed from: b, reason: collision with root package name */
    public C0047j2 f4848b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4849c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4850d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4851e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ y f4852f;

    public u(y yVar, Window.Callback callback) {
        this.f4852f = yVar;
        if (callback != null) {
            this.f4847a = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public final void a(Window.Callback callback) {
        try {
            this.f4849c = true;
            callback.onContentChanged();
        } finally {
            this.f4849c = false;
        }
    }

    public final boolean b(int i, Menu menu) {
        return this.f4847a.onMenuOpened(i, menu);
    }

    public final void c(int i, Menu menu) {
        this.f4847a.onPanelClosed(i, menu);
    }

    public final void d(List list, Menu menu, int i) {
        k.n.a(this.f4847a, list, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f4847a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z3 = this.f4850d;
        Window.Callback callback = this.f4847a;
        if (z3) {
            return callback.dispatchKeyEvent(keyEvent);
        }
        if (!this.f4852f.u(keyEvent) && !callback.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (!this.f4847a.dispatchKeyShortcutEvent(keyEvent)) {
            int keyCode = keyEvent.getKeyCode();
            y yVar = this.f4852f;
            yVar.A();
            AbstractC0431a abstractC0431a = yVar.f4915r;
            if (abstractC0431a == null || !abstractC0431a.k(keyCode, keyEvent)) {
                x xVar = yVar.f4890P;
                if (xVar != null && yVar.F(xVar, keyEvent.getKeyCode(), keyEvent)) {
                    x xVar2 = yVar.f4890P;
                    if (xVar2 != null) {
                        xVar2.f4867l = true;
                        return true;
                    }
                } else {
                    if (yVar.f4890P == null) {
                        x z3 = yVar.z(0);
                        yVar.G(z3, keyEvent);
                        boolean F3 = yVar.F(z3, keyEvent.getKeyCode(), keyEvent);
                        z3.f4866k = false;
                        if (F3) {
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f4847a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f4847a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f4847a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f4847a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f4847a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f4847a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f4849c) {
            this.f4847a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0 && !(menu instanceof l.m)) {
            return false;
        }
        return this.f4847a.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        View view;
        C0047j2 c0047j2 = this.f4848b;
        if (c0047j2 != null) {
            if (i == 0) {
                view = new View(((I) c0047j2.f546b).f4734a.f5772a.getContext());
            } else {
                view = null;
            }
            if (view != null) {
                return view;
            }
        }
        return this.f4847a.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f4847a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f4847a.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        b(i, menu);
        y yVar = this.f4852f;
        if (i == 108) {
            yVar.A();
            AbstractC0431a abstractC0431a = yVar.f4915r;
            if (abstractC0431a != null) {
                abstractC0431a.c(true);
            }
        } else {
            yVar.getClass();
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.f4851e) {
            this.f4847a.onPanelClosed(i, menu);
            return;
        }
        c(i, menu);
        y yVar = this.f4852f;
        if (i == 108) {
            yVar.A();
            AbstractC0431a abstractC0431a = yVar.f4915r;
            if (abstractC0431a != null) {
                abstractC0431a.c(false);
                return;
            }
            return;
        }
        if (i == 0) {
            x z3 = yVar.z(i);
            if (z3.f4868m) {
                yVar.s(z3, false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z3) {
        k.o.a(this.f4847a, z3);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        l.m mVar;
        if (menu instanceof l.m) {
            mVar = (l.m) menu;
        } else {
            mVar = null;
        }
        if (i == 0 && mVar == null) {
            return false;
        }
        if (mVar != null) {
            mVar.y = true;
        }
        C0047j2 c0047j2 = this.f4848b;
        if (c0047j2 != null && i == 0) {
            I i3 = (I) c0047j2.f546b;
            if (!i3.f4737d) {
                i3.f4734a.f5782l = true;
                i3.f4737d = true;
            }
        }
        boolean onPreparePanel = this.f4847a.onPreparePanel(i, view, menu);
        if (mVar != null) {
            mVar.y = false;
        }
        return onPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        l.m mVar = this.f4852f.z(0).f4864h;
        if (mVar != null) {
            d(list, mVar, i);
        } else {
            d(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return AbstractC0469m.a(this.f4847a, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f4847a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        this.f4847a.onWindowFocusChanged(z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [K1.m, java.lang.Object, k.a] */
    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        if (i != 0) {
            return AbstractC0469m.b(this.f4847a, callback, i);
        }
        y yVar = this.f4852f;
        Context context = yVar.f4912n;
        ?? obj = new Object();
        obj.f1103b = context;
        obj.f1102a = callback;
        obj.f1104c = new ArrayList();
        obj.f1105d = new C0694j(0);
        AbstractC0458b m4 = yVar.m(obj);
        if (m4 != null) {
            return obj.h(m4);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f4847a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
