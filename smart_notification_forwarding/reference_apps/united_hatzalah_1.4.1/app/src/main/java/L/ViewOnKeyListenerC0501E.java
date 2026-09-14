package l;

import J.S;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.uh.sf.R;
import java.util.WeakHashMap;
import m.C0576w0;
import m.I0;
import m.O0;

/* renamed from: l.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0501E extends u implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: b, reason: collision with root package name */
    public final Context f5319b;

    /* renamed from: c, reason: collision with root package name */
    public final m f5320c;

    /* renamed from: d, reason: collision with root package name */
    public final j f5321d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f5322e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5323f;

    /* renamed from: j, reason: collision with root package name */
    public final int f5324j;

    /* renamed from: k, reason: collision with root package name */
    public final O0 f5325k;

    /* renamed from: l, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0506d f5326l;

    /* renamed from: m, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0507e f5327m;

    /* renamed from: n, reason: collision with root package name */
    public PopupWindow.OnDismissListener f5328n;

    /* renamed from: o, reason: collision with root package name */
    public View f5329o;
    public View p;

    /* renamed from: q, reason: collision with root package name */
    public y f5330q;

    /* renamed from: r, reason: collision with root package name */
    public ViewTreeObserver f5331r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5332s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5333t;

    /* renamed from: u, reason: collision with root package name */
    public int f5334u;

    /* renamed from: v, reason: collision with root package name */
    public int f5335v = 0;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5336w;

    /* JADX WARN: Type inference failed for: r6v1, types: [m.O0, m.I0] */
    public ViewOnKeyListenerC0501E(Context context, m mVar, View view, int i, boolean z3) {
        int i3 = 1;
        this.f5326l = new ViewTreeObserverOnGlobalLayoutListenerC0506d(this, i3);
        this.f5327m = new ViewOnAttachStateChangeListenerC0507e(this, i3);
        this.f5319b = context;
        this.f5320c = mVar;
        this.f5322e = z3;
        this.f5321d = new j(mVar, LayoutInflater.from(context), z3, R.layout.abc_popup_menu_item_layout);
        this.f5324j = i;
        Resources resources = context.getResources();
        this.f5323f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f5329o = view;
        this.f5325k = new I0(context, null, i);
        mVar.b(this, context);
    }

    @Override // l.InterfaceC0500D
    public final boolean a() {
        if (!this.f5332s && this.f5325k.f5533B.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // l.z
    public final void b(m mVar, boolean z3) {
        if (mVar == this.f5320c) {
            dismiss();
            y yVar = this.f5330q;
            if (yVar != null) {
                yVar.b(mVar, z3);
            }
        }
    }

    @Override // l.z
    public final boolean d() {
        return false;
    }

    @Override // l.InterfaceC0500D
    public final void dismiss() {
        if (a()) {
            this.f5325k.dismiss();
        }
    }

    @Override // l.z
    public final void e() {
        this.f5333t = false;
        j jVar = this.f5321d;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    @Override // l.z
    public final void f(y yVar) {
        this.f5330q = yVar;
    }

    @Override // l.InterfaceC0500D
    public final C0576w0 g() {
        return this.f5325k.f5536c;
    }

    @Override // l.z
    public final boolean i(SubMenuC0502F subMenuC0502F) {
        boolean z3;
        if (subMenuC0502F.hasVisibleItems()) {
            x xVar = new x(this.f5319b, subMenuC0502F, this.p, this.f5322e, this.f5324j, 0);
            y yVar = this.f5330q;
            xVar.f5469h = yVar;
            u uVar = xVar.i;
            if (uVar != null) {
                uVar.f(yVar);
            }
            int size = subMenuC0502F.f5405f.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    MenuItem item = subMenuC0502F.getItem(i);
                    if (item.isVisible() && item.getIcon() != null) {
                        z3 = true;
                        break;
                    }
                    i++;
                } else {
                    z3 = false;
                    break;
                }
            }
            xVar.f5468g = z3;
            u uVar2 = xVar.i;
            if (uVar2 != null) {
                uVar2.n(z3);
            }
            xVar.f5470j = this.f5328n;
            this.f5328n = null;
            this.f5320c.c(false);
            O0 o02 = this.f5325k;
            int i3 = o02.f5539f;
            int n4 = o02.n();
            int i4 = this.f5335v;
            View view = this.f5329o;
            WeakHashMap weakHashMap = S.f954a;
            if ((Gravity.getAbsoluteGravity(i4, view.getLayoutDirection()) & 7) == 5) {
                i3 += this.f5329o.getWidth();
            }
            if (!xVar.b()) {
                if (xVar.f5466e != null) {
                    xVar.d(i3, n4, true, true);
                }
            }
            y yVar2 = this.f5330q;
            if (yVar2 != null) {
                yVar2.d(subMenuC0502F);
            }
            return true;
        }
        return false;
    }

    @Override // l.u
    public final void m(View view) {
        this.f5329o = view;
    }

    @Override // l.u
    public final void n(boolean z3) {
        this.f5321d.f5395c = z3;
    }

    @Override // l.u
    public final void o(int i) {
        this.f5335v = i;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f5332s = true;
        this.f5320c.c(true);
        ViewTreeObserver viewTreeObserver = this.f5331r;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f5331r = this.p.getViewTreeObserver();
            }
            this.f5331r.removeGlobalOnLayoutListener(this.f5326l);
            this.f5331r = null;
        }
        this.p.removeOnAttachStateChangeListener(this.f5327m);
        PopupWindow.OnDismissListener onDismissListener = this.f5328n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // l.u
    public final void p(int i) {
        this.f5325k.f5539f = i;
    }

    @Override // l.u
    public final void q(PopupWindow.OnDismissListener onDismissListener) {
        this.f5328n = onDismissListener;
    }

    @Override // l.u
    public final void r(boolean z3) {
        this.f5336w = z3;
    }

    @Override // l.u
    public final void s(int i) {
        this.f5325k.j(i);
    }

    @Override // l.InterfaceC0500D
    public final void show() {
        View view;
        boolean z3;
        Rect rect;
        if (a()) {
            return;
        }
        if (!this.f5332s && (view = this.f5329o) != null) {
            this.p = view;
            O0 o02 = this.f5325k;
            o02.f5533B.setOnDismissListener(this);
            o02.f5548s = this;
            o02.f5532A = true;
            o02.f5533B.setFocusable(true);
            View view2 = this.p;
            if (this.f5331r == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
            this.f5331r = viewTreeObserver;
            if (z3) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f5326l);
            }
            view2.addOnAttachStateChangeListener(this.f5327m);
            o02.f5547r = view2;
            o02.f5545o = this.f5335v;
            boolean z4 = this.f5333t;
            Context context = this.f5319b;
            j jVar = this.f5321d;
            if (!z4) {
                this.f5334u = u.l(jVar, context, this.f5323f);
                this.f5333t = true;
            }
            o02.q(this.f5334u);
            o02.f5533B.setInputMethodMode(2);
            Rect rect2 = this.f5460a;
            if (rect2 != null) {
                rect = new Rect(rect2);
            } else {
                rect = null;
            }
            o02.f5554z = rect;
            o02.show();
            C0576w0 c0576w0 = o02.f5536c;
            c0576w0.setOnKeyListener(this);
            if (this.f5336w) {
                m mVar = this.f5320c;
                if (mVar.f5411m != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c0576w0, false);
                    TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                    if (textView != null) {
                        textView.setText(mVar.f5411m);
                    }
                    frameLayout.setEnabled(false);
                    c0576w0.addHeaderView(frameLayout, null, false);
                }
            }
            o02.o(jVar);
            o02.show();
            return;
        }
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // l.u
    public final void k(m mVar) {
    }
}
