package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.n0;
import androidx.core.view.a0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends k implements PopupWindow.OnDismissListener, View.OnKeyListener {
    private static final int A = e.g.f8968m;

    /* renamed from: g, reason: collision with root package name */
    private final Context f1006g;

    /* renamed from: h, reason: collision with root package name */
    private final g f1007h;

    /* renamed from: i, reason: collision with root package name */
    private final f f1008i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f1009j;

    /* renamed from: k, reason: collision with root package name */
    private final int f1010k;

    /* renamed from: l, reason: collision with root package name */
    private final int f1011l;

    /* renamed from: m, reason: collision with root package name */
    private final int f1012m;

    /* renamed from: n, reason: collision with root package name */
    final n0 f1013n;

    /* renamed from: q, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1016q;

    /* renamed from: r, reason: collision with root package name */
    private View f1017r;

    /* renamed from: s, reason: collision with root package name */
    View f1018s;

    /* renamed from: t, reason: collision with root package name */
    private m.a f1019t;

    /* renamed from: u, reason: collision with root package name */
    ViewTreeObserver f1020u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f1021v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f1022w;

    /* renamed from: x, reason: collision with root package name */
    private int f1023x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f1025z;

    /* renamed from: o, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1014o = new a();

    /* renamed from: p, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1015p = new b();

    /* renamed from: y, reason: collision with root package name */
    private int f1024y = 0;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.c() || q.this.f1013n.x()) {
                return;
            }
            View view = q.this.f1018s;
            if (view == null || !view.isShown()) {
                q.this.dismiss();
            } else {
                q.this.f1013n.a();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = q.this.f1020u;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.f1020u = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.f1020u.removeGlobalOnLayoutListener(qVar.f1014o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i10, int i11, boolean z10) {
        this.f1006g = context;
        this.f1007h = gVar;
        this.f1009j = z10;
        this.f1008i = new f(gVar, LayoutInflater.from(context), z10, A);
        this.f1011l = i10;
        this.f1012m = i11;
        Resources resources = context.getResources();
        this.f1010k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.d.f8892d));
        this.f1017r = view;
        this.f1013n = new n0(context, null, i10, i11);
        gVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (c()) {
            return true;
        }
        if (this.f1021v || (view = this.f1017r) == null) {
            return false;
        }
        this.f1018s = view;
        this.f1013n.G(this);
        this.f1013n.H(this);
        this.f1013n.F(true);
        View view2 = this.f1018s;
        boolean z10 = this.f1020u == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1020u = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1014o);
        }
        view2.addOnAttachStateChangeListener(this.f1015p);
        this.f1013n.z(view2);
        this.f1013n.C(this.f1024y);
        if (!this.f1022w) {
            this.f1023x = k.o(this.f1008i, null, this.f1006g, this.f1010k);
            this.f1022w = true;
        }
        this.f1013n.B(this.f1023x);
        this.f1013n.E(2);
        this.f1013n.D(n());
        this.f1013n.a();
        ListView h10 = this.f1013n.h();
        h10.setOnKeyListener(this);
        if (this.f1025z && this.f1007h.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1006g).inflate(e.g.f8967l, (ViewGroup) h10, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f1007h.x());
            }
            frameLayout.setEnabled(false);
            h10.addHeaderView(frameLayout, null, false);
        }
        this.f1013n.p(this.f1008i);
        this.f1013n.a();
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z10) {
        if (gVar != this.f1007h) {
            return;
        }
        dismiss();
        m.a aVar = this.f1019t;
        if (aVar != null) {
            aVar.b(gVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return !this.f1021v && this.f1013n.c();
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        if (c()) {
            this.f1013n.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f1006g, rVar, this.f1018s, this.f1009j, this.f1011l, this.f1012m);
            lVar.j(this.f1019t);
            lVar.g(k.x(rVar));
            lVar.i(this.f1016q);
            this.f1016q = null;
            this.f1007h.e(false);
            int d10 = this.f1013n.d();
            int n10 = this.f1013n.n();
            if ((Gravity.getAbsoluteGravity(this.f1024y, a0.z(this.f1017r)) & 7) == 5) {
                d10 += this.f1017r.getWidth();
            }
            if (lVar.n(d10, n10)) {
                m.a aVar = this.f1019t;
                if (aVar == null) {
                    return true;
                }
                aVar.c(rVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z10) {
        this.f1022w = false;
        f fVar = this.f1008i;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView h() {
        return this.f1013n.h();
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.f1019t = aVar;
    }

    @Override // androidx.appcompat.view.menu.k
    public void l(g gVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1021v = true;
        this.f1007h.close();
        ViewTreeObserver viewTreeObserver = this.f1020u;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1020u = this.f1018s.getViewTreeObserver();
            }
            this.f1020u.removeGlobalOnLayoutListener(this.f1014o);
            this.f1020u = null;
        }
        this.f1018s.removeOnAttachStateChangeListener(this.f1015p);
        PopupWindow.OnDismissListener onDismissListener = this.f1016q;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void p(View view) {
        this.f1017r = view;
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(boolean z10) {
        this.f1008i.d(z10);
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(int i10) {
        this.f1024y = i10;
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i10) {
        this.f1013n.l(i10);
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f1016q = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(boolean z10) {
        this.f1025z = z10;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i10) {
        this.f1013n.j(i10);
    }
}
