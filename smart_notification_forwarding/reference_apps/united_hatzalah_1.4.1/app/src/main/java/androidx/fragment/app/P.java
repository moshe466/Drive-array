package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.uh.sf.R;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class P extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3315a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3316b;

    /* renamed from: c, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f3317c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3318d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(Context context, AttributeSet attrs, AbstractC0272g0 abstractC0272g0) {
        super(context, attrs);
        View view;
        String str;
        kotlin.jvm.internal.j.e(context, "context");
        kotlin.jvm.internal.j.e(attrs, "attrs");
        this.f3315a = new ArrayList();
        this.f3316b = new ArrayList();
        this.f3318d = true;
        String classAttribute = attrs.getClassAttribute();
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, Z.a.f2729b, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        G C3 = abstractC0272g0.C(id);
        if (classAttribute != null && C3 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag ".concat(string);
                } else {
                    str = "";
                }
                throw new IllegalStateException(e0.a.e("FragmentContainerView must have an android:id to add Fragment ", classAttribute, str));
            }
            Z H3 = abstractC0272g0.H();
            context.getClassLoader();
            G instantiate = G.instantiate(H3.f3334a.f3409w.f3321b, classAttribute, null);
            kotlin.jvm.internal.j.d(instantiate, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            instantiate.mFragmentId = id;
            instantiate.mContainerId = id;
            instantiate.mTag = string;
            instantiate.mFragmentManager = abstractC0272g0;
            instantiate.mHost = abstractC0272g0.f3409w;
            instantiate.onInflate(context, attrs, (Bundle) null);
            C0259a c0259a = new C0259a(abstractC0272g0);
            c0259a.f3510o = true;
            instantiate.mContainer = this;
            instantiate.mInDynamicContainer = true;
            c0259a.c(getId(), instantiate, string);
            if (!c0259a.f3503g) {
                c0259a.f3335q.A(c0259a, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        ArrayList d2 = abstractC0272g0.f3391c.d();
        int size = d2.size();
        while (i < size) {
            Object obj = d2.get(i);
            i++;
            o0 o0Var = (o0) obj;
            G g3 = o0Var.f3473c;
            if (g3.mContainerId == getId() && (view = g3.mView) != null && view.getParent() == null) {
                g3.mContainer = this;
                o0Var.a();
                o0Var.i();
            }
        }
    }

    public final void a(View view) {
        if (this.f3316b.contains(view)) {
            this.f3315a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View child, int i, ViewGroup.LayoutParams layoutParams) {
        G g3;
        kotlin.jvm.internal.j.e(child, "child");
        Object tag = child.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof G) {
            g3 = (G) tag;
        } else {
            g3 = null;
        }
        if (g3 != null) {
            super.addView(child, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        J.p0 p0Var;
        kotlin.jvm.internal.j.e(insets, "insets");
        J.p0 c4 = J.p0.c(insets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f3317c;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, insets);
            kotlin.jvm.internal.j.d(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            p0Var = J.p0.c(onApplyWindowInsets, null);
        } else {
            WeakHashMap weakHashMap = J.S.f954a;
            WindowInsets b4 = c4.b();
            if (b4 != null) {
                WindowInsets b5 = J.H.b(this, b4);
                if (!b5.equals(b4)) {
                    c4 = J.p0.c(b5, this);
                }
            }
            p0Var = c4;
        }
        if (!p0Var.f1022a.l()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                J.S.b(getChildAt(i), p0Var);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.j.e(canvas, "canvas");
        if (this.f3318d) {
            ArrayList arrayList = this.f3315a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                super.drawChild(canvas, (View) obj, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View child, long j2) {
        kotlin.jvm.internal.j.e(canvas, "canvas");
        kotlin.jvm.internal.j.e(child, "child");
        if (this.f3318d) {
            ArrayList arrayList = this.f3315a;
            if (!arrayList.isEmpty() && arrayList.contains(child)) {
                return false;
            }
        }
        return super.drawChild(canvas, child, j2);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        kotlin.jvm.internal.j.e(view, "view");
        this.f3316b.remove(view);
        if (this.f3315a.remove(view)) {
            this.f3318d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends G> F getFragment() {
        L l3;
        G g3;
        AbstractC0272g0 supportFragmentManager;
        View view = this;
        while (true) {
            l3 = null;
            if (view != null) {
                Object tag = view.getTag(R.id.fragment_container_view_tag);
                if (tag instanceof G) {
                    g3 = (G) tag;
                } else {
                    g3 = null;
                }
                if (g3 != null) {
                    break;
                }
                Object parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                } else {
                    view = null;
                }
            } else {
                g3 = null;
                break;
            }
        }
        if (g3 != null) {
            if (g3.isAdded()) {
                supportFragmentManager = g3.getChildFragmentManager();
            } else {
                throw new IllegalStateException("The Fragment " + g3 + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
        } else {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof L) {
                    l3 = (L) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (l3 != null) {
                supportFragmentManager = l3.getSupportFragmentManager();
            } else {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
        }
        return (F) supportFragmentManager.C(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets insets) {
        kotlin.jvm.internal.j.e(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View view = getChildAt(childCount);
                kotlin.jvm.internal.j.d(view, "view");
                a(view);
            } else {
                super.removeAllViewsInLayout();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        kotlin.jvm.internal.j.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View view = getChildAt(i);
        kotlin.jvm.internal.j.d(view, "view");
        a(view);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        kotlin.jvm.internal.j.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i3) {
        int i4 = i + i3;
        for (int i5 = i; i5 < i4; i5++) {
            View view = getChildAt(i5);
            kotlin.jvm.internal.j.d(view, "view");
            a(view);
        }
        super.removeViews(i, i3);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i3) {
        int i4 = i + i3;
        for (int i5 = i; i5 < i4; i5++) {
            View view = getChildAt(i5);
            kotlin.jvm.internal.j.d(view, "view");
            a(view);
        }
        super.removeViewsInLayout(i, i3);
    }

    public final void setDrawDisappearingViewsLast(boolean z3) {
        this.f3318d = z3;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f3317c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        kotlin.jvm.internal.j.e(view, "view");
        if (view.getParent() == this) {
            this.f3316b.add(view);
        }
        super.startViewTransition(view);
    }
}
