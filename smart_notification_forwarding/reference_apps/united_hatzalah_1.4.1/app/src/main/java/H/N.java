package h;

import F0.C0021d0;
import F0.G1;
import J.S;
import J.X;
import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import g.AbstractC0424a;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k.AbstractC0458b;
import k.C0467k;
import k.C0468l;
import k.InterfaceC0457a;
import m.InterfaceC0536c;
import m.InterfaceC0559n0;
import m.n1;
import m.s1;

/* loaded from: classes.dex */
public final class N extends AbstractC0431a implements InterfaceC0536c {

    /* renamed from: a, reason: collision with root package name */
    public Context f4757a;

    /* renamed from: b, reason: collision with root package name */
    public Context f4758b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f4759c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f4760d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0559n0 f4761e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f4762f;

    /* renamed from: g, reason: collision with root package name */
    public final View f4763g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4764h;
    public M i;

    /* renamed from: j, reason: collision with root package name */
    public M f4765j;

    /* renamed from: k, reason: collision with root package name */
    public C0021d0 f4766k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4767l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f4768m;

    /* renamed from: n, reason: collision with root package name */
    public int f4769n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4770o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4771q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4772r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4773s;

    /* renamed from: t, reason: collision with root package name */
    public C0468l f4774t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4775u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4776v;

    /* renamed from: w, reason: collision with root package name */
    public final L f4777w;

    /* renamed from: x, reason: collision with root package name */
    public final L f4778x;
    public final G1 y;

    /* renamed from: z, reason: collision with root package name */
    public static final AccelerateInterpolator f4756z = new AccelerateInterpolator();

    /* renamed from: A, reason: collision with root package name */
    public static final DecelerateInterpolator f4755A = new DecelerateInterpolator();

    public N(Activity activity, boolean z3) {
        new ArrayList();
        this.f4768m = new ArrayList();
        this.f4769n = 0;
        this.f4770o = true;
        this.f4773s = true;
        this.f4777w = new L(this, 0);
        this.f4778x = new L(this, 1);
        this.y = new G1(this, 18);
        View decorView = activity.getWindow().getDecorView();
        w(decorView);
        if (z3) {
            return;
        }
        this.f4763g = decorView.findViewById(R.id.content);
    }

    @Override // h.AbstractC0431a
    public final boolean b() {
        n1 n1Var;
        l.o oVar;
        InterfaceC0559n0 interfaceC0559n0 = this.f4761e;
        if (interfaceC0559n0 != null && (n1Var = ((s1) interfaceC0559n0).f5772a.f2978P) != null && n1Var.f5731b != null) {
            n1 n1Var2 = ((s1) interfaceC0559n0).f5772a.f2978P;
            if (n1Var2 == null) {
                oVar = null;
            } else {
                oVar = n1Var2.f5731b;
            }
            if (oVar != null) {
                oVar.collapseActionView();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // h.AbstractC0431a
    public final void c(boolean z3) {
        if (z3 != this.f4767l) {
            this.f4767l = z3;
            ArrayList arrayList = this.f4768m;
            if (arrayList.size() <= 0) {
            } else {
                throw e0.a.b(0, arrayList);
            }
        }
    }

    @Override // h.AbstractC0431a
    public final int d() {
        return ((s1) this.f4761e).f5773b;
    }

    @Override // h.AbstractC0431a
    public final Context e() {
        if (this.f4758b == null) {
            TypedValue typedValue = new TypedValue();
            this.f4757a.getTheme().resolveAttribute(com.uh.sf.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f4758b = new ContextThemeWrapper(this.f4757a, i);
            } else {
                this.f4758b = this.f4757a;
            }
        }
        return this.f4758b;
    }

    @Override // h.AbstractC0431a
    public final void f() {
        if (!this.p) {
            this.p = true;
            y(false);
        }
    }

    @Override // h.AbstractC0431a
    public final boolean h() {
        int height = this.f4760d.getHeight();
        if (this.f4773s) {
            if (height == 0 || this.f4759c.getActionBarHideOffset() < height) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // h.AbstractC0431a
    public final void i() {
        x(this.f4757a.getResources().getBoolean(com.uh.sf.R.bool.abc_action_bar_embed_tabs));
    }

    @Override // h.AbstractC0431a
    public final boolean k(int i, KeyEvent keyEvent) {
        l.m mVar;
        M m4 = this.i;
        if (m4 == null || (mVar = m4.f4751d) == null) {
            return false;
        }
        boolean z3 = true;
        if (KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() == 1) {
            z3 = false;
        }
        mVar.setQwertyMode(z3);
        return mVar.performShortcut(i, keyEvent, 0);
    }

    @Override // h.AbstractC0431a
    public final void n(ColorDrawable colorDrawable) {
        this.f4760d.setPrimaryBackground(colorDrawable);
    }

    @Override // h.AbstractC0431a
    public final void o(boolean z3) {
        int i;
        if (!this.f4764h) {
            if (z3) {
                i = 4;
            } else {
                i = 0;
            }
            s1 s1Var = (s1) this.f4761e;
            int i3 = s1Var.f5773b;
            this.f4764h = true;
            s1Var.a((i & 4) | (i3 & (-5)));
        }
    }

    @Override // h.AbstractC0431a
    public final void p(boolean z3) {
        int i;
        if (z3) {
            i = 8;
        } else {
            i = 0;
        }
        s1 s1Var = (s1) this.f4761e;
        s1Var.a((i & 8) | (s1Var.f5773b & (-9)));
    }

    @Override // h.AbstractC0431a
    public final void q(boolean z3) {
        C0468l c0468l;
        this.f4775u = z3;
        if (!z3 && (c0468l = this.f4774t) != null) {
            c0468l.a();
        }
    }

    @Override // h.AbstractC0431a
    public final void r(CharSequence charSequence) {
        s1 s1Var = (s1) this.f4761e;
        s1Var.f5778g = true;
        Toolbar toolbar = s1Var.f5772a;
        s1Var.f5779h = charSequence;
        if ((s1Var.f5773b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (s1Var.f5778g) {
                S.j(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // h.AbstractC0431a
    public final void s(CharSequence charSequence) {
        s1 s1Var = (s1) this.f4761e;
        if (!s1Var.f5778g) {
            Toolbar toolbar = s1Var.f5772a;
            s1Var.f5779h = charSequence;
            if ((s1Var.f5773b & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (s1Var.f5778g) {
                    S.j(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    @Override // h.AbstractC0431a
    public final void t() {
        if (this.p) {
            this.p = false;
            y(false);
        }
    }

    @Override // h.AbstractC0431a
    public final AbstractC0458b u(C0021d0 c0021d0) {
        M m4 = this.i;
        if (m4 != null) {
            m4.a();
        }
        this.f4759c.setHideOnContentScrollEnabled(false);
        this.f4762f.e();
        M m5 = new M(this, this.f4762f.getContext(), c0021d0);
        l.m mVar = m5.f4751d;
        mVar.w();
        try {
            if (((InterfaceC0457a) m5.f4752e.f479a).b(m5, mVar)) {
                this.i = m5;
                m5.h();
                this.f4762f.c(m5);
                v(true);
                return m5;
            }
            return null;
        } finally {
            mVar.v();
        }
    }

    public final void v(boolean z3) {
        X i;
        X x3;
        long j2;
        if (z3) {
            if (!this.f4772r) {
                this.f4772r = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4759c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                y(false);
            }
        } else if (this.f4772r) {
            this.f4772r = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4759c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            y(false);
        }
        ActionBarContainer actionBarContainer = this.f4760d;
        WeakHashMap weakHashMap = S.f954a;
        if (actionBarContainer.isLaidOut()) {
            if (z3) {
                s1 s1Var = (s1) this.f4761e;
                i = S.a(s1Var.f5772a);
                i.a(0.0f);
                i.c(100L);
                i.d(new C0467k(s1Var, 4));
                x3 = this.f4762f.i(0, 200L);
            } else {
                s1 s1Var2 = (s1) this.f4761e;
                X a2 = S.a(s1Var2.f5772a);
                a2.a(1.0f);
                a2.c(200L);
                a2.d(new C0467k(s1Var2, 0));
                i = this.f4762f.i(8, 100L);
                x3 = a2;
            }
            C0468l c0468l = new C0468l();
            ArrayList arrayList = c0468l.f5157a;
            arrayList.add(i);
            View view = (View) i.f964a.get();
            if (view != null) {
                j2 = view.animate().getDuration();
            } else {
                j2 = 0;
            }
            View view2 = (View) x3.f964a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(j2);
            }
            arrayList.add(x3);
            c0468l.b();
            return;
        }
        if (z3) {
            ((s1) this.f4761e).f5772a.setVisibility(4);
            this.f4762f.setVisibility(0);
        } else {
            ((s1) this.f4761e).f5772a.setVisibility(0);
            this.f4762f.setVisibility(8);
        }
    }

    public final void w(View view) {
        String str;
        InterfaceC0559n0 wrapper;
        boolean z3;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.uh.sf.R.id.decor_content_parent);
        this.f4759c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback findViewById = view.findViewById(com.uh.sf.R.id.action_bar);
        if (findViewById instanceof InterfaceC0559n0) {
            wrapper = (InterfaceC0559n0) findViewById;
        } else if (findViewById instanceof Toolbar) {
            wrapper = ((Toolbar) findViewById).getWrapper();
        } else {
            if (findViewById != null) {
                str = findViewById.getClass().getSimpleName();
            } else {
                str = "null";
            }
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(str));
        }
        this.f4761e = wrapper;
        this.f4762f = (ActionBarContextView) view.findViewById(com.uh.sf.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.uh.sf.R.id.action_bar_container);
        this.f4760d = actionBarContainer;
        InterfaceC0559n0 interfaceC0559n0 = this.f4761e;
        if (interfaceC0559n0 != null && this.f4762f != null && actionBarContainer != null) {
            Context context = ((s1) interfaceC0559n0).f5772a.getContext();
            this.f4757a = context;
            if ((((s1) this.f4761e).f5773b & 4) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                this.f4764h = true;
            }
            int i = context.getApplicationInfo().targetSdkVersion;
            this.f4761e.getClass();
            x(context.getResources().getBoolean(com.uh.sf.R.bool.abc_action_bar_embed_tabs));
            TypedArray obtainStyledAttributes = this.f4757a.obtainStyledAttributes(null, AbstractC0424a.f4627a, com.uh.sf.R.attr.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(14, false)) {
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4759c;
                if (actionBarOverlayLayout2.f2839k) {
                    this.f4776v = true;
                    actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
                } else {
                    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                }
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
            if (dimensionPixelSize != 0) {
                ActionBarContainer actionBarContainer2 = this.f4760d;
                WeakHashMap weakHashMap = S.f954a;
                J.J.i(actionBarContainer2, dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(N.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
    }

    public final void x(boolean z3) {
        if (!z3) {
            ((s1) this.f4761e).getClass();
            this.f4760d.setTabContainer(null);
        } else {
            this.f4760d.setTabContainer(null);
            ((s1) this.f4761e).getClass();
        }
        this.f4761e.getClass();
        ((s1) this.f4761e).f5772a.setCollapsible(false);
        this.f4759c.setHasNonEmbeddedTabs(false);
    }

    public final void y(boolean z3) {
        boolean z4 = this.p;
        boolean z5 = this.f4771q;
        boolean z6 = this.f4772r;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        final G1 g12 = this.y;
        View view = this.f4763g;
        if (z6 || (!z4 && !z5)) {
            if (!this.f4773s) {
                this.f4773s = true;
                C0468l c0468l = this.f4774t;
                if (c0468l != null) {
                    c0468l.a();
                }
                this.f4760d.setVisibility(0);
                int i = this.f4769n;
                L l3 = this.f4778x;
                if (i == 0 && (this.f4775u || z3)) {
                    this.f4760d.setTranslationY(0.0f);
                    float f4 = -this.f4760d.getHeight();
                    if (z3) {
                        this.f4760d.getLocationInWindow(new int[]{0, 0});
                        f4 -= r12[1];
                    }
                    this.f4760d.setTranslationY(f4);
                    C0468l c0468l2 = new C0468l();
                    X a2 = S.a(this.f4760d);
                    a2.e(0.0f);
                    final View view2 = (View) a2.f964a.get();
                    if (view2 != null) {
                        if (g12 != null) {
                            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(view2) { // from class: J.V
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    ((View) ((h.N) G1.this.f218b).f4760d.getParent()).invalidate();
                                }
                            };
                        }
                        view2.animate().setUpdateListener(animatorUpdateListener);
                    }
                    boolean z7 = c0468l2.f5161e;
                    ArrayList arrayList = c0468l2.f5157a;
                    if (!z7) {
                        arrayList.add(a2);
                    }
                    if (this.f4770o && view != null) {
                        view.setTranslationY(f4);
                        X a4 = S.a(view);
                        a4.e(0.0f);
                        if (!c0468l2.f5161e) {
                            arrayList.add(a4);
                        }
                    }
                    boolean z8 = c0468l2.f5161e;
                    if (!z8) {
                        c0468l2.f5159c = f4755A;
                    }
                    if (!z8) {
                        c0468l2.f5158b = 250L;
                    }
                    if (!z8) {
                        c0468l2.f5160d = l3;
                    }
                    this.f4774t = c0468l2;
                    c0468l2.b();
                } else {
                    this.f4760d.setAlpha(1.0f);
                    this.f4760d.setTranslationY(0.0f);
                    if (this.f4770o && view != null) {
                        view.setTranslationY(0.0f);
                    }
                    l3.c();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4759c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = S.f954a;
                    J.H.c(actionBarOverlayLayout);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f4773s) {
            this.f4773s = false;
            C0468l c0468l3 = this.f4774t;
            if (c0468l3 != null) {
                c0468l3.a();
            }
            int i3 = this.f4769n;
            L l4 = this.f4777w;
            if (i3 == 0 && (this.f4775u || z3)) {
                this.f4760d.setAlpha(1.0f);
                this.f4760d.setTransitioning(true);
                C0468l c0468l4 = new C0468l();
                float f5 = -this.f4760d.getHeight();
                if (z3) {
                    this.f4760d.getLocationInWindow(new int[]{0, 0});
                    f5 -= r12[1];
                }
                X a5 = S.a(this.f4760d);
                a5.e(f5);
                final View view3 = (View) a5.f964a.get();
                if (view3 != null) {
                    if (g12 != null) {
                        animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(view3) { // from class: J.V
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                ((View) ((h.N) G1.this.f218b).f4760d.getParent()).invalidate();
                            }
                        };
                    }
                    view3.animate().setUpdateListener(animatorUpdateListener);
                }
                boolean z9 = c0468l4.f5161e;
                ArrayList arrayList2 = c0468l4.f5157a;
                if (!z9) {
                    arrayList2.add(a5);
                }
                if (this.f4770o && view != null) {
                    X a6 = S.a(view);
                    a6.e(f5);
                    if (!c0468l4.f5161e) {
                        arrayList2.add(a6);
                    }
                }
                boolean z10 = c0468l4.f5161e;
                if (!z10) {
                    c0468l4.f5159c = f4756z;
                }
                if (!z10) {
                    c0468l4.f5158b = 250L;
                }
                if (!z10) {
                    c0468l4.f5160d = l4;
                }
                this.f4774t = c0468l4;
                c0468l4.b();
                return;
            }
            l4.c();
        }
    }

    public N(Dialog dialog) {
        new ArrayList();
        this.f4768m = new ArrayList();
        this.f4769n = 0;
        this.f4770o = true;
        this.f4773s = true;
        this.f4777w = new L(this, 0);
        this.f4778x = new L(this, 1);
        this.y = new G1(this, 18);
        w(dialog.getWindow().getDecorView());
    }
}
