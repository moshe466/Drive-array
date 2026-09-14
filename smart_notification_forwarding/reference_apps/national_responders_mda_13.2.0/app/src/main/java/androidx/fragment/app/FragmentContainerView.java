package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private final List<View> f2880f;

    /* renamed from: g, reason: collision with root package name */
    private final List<View> f2881g;

    /* renamed from: h, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f2882h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2883i;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2884a = new a();

        private a() {
        }

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
            y8.k.e(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            y8.k.e(view, "v");
            y8.k.e(windowInsets, "insets");
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            y8.k.d(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return onApplyWindowInsets;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        y8.k.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        String str;
        y8.k.e(context, "context");
        this.f2880f = new ArrayList();
        this.f2881g = new ArrayList();
        this.f2883i = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] iArr = d0.c.f8635e;
            y8.k.d(iArr, "FragmentContainerView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(d0.c.f8636f);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i10, int i11, y8.g gVar) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, w wVar) {
        super(context, attributeSet);
        String str;
        y8.k.e(context, "context");
        y8.k.e(attributeSet, "attrs");
        y8.k.e(wVar, "fm");
        this.f2880f = new ArrayList();
        this.f2881g = new ArrayList();
        this.f2883i = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = d0.c.f8635e;
        y8.k.d(iArr, "FragmentContainerView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(d0.c.f8636f) : classAttribute;
        String string = obtainStyledAttributes.getString(d0.c.f8637g);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment h02 = wVar.h0(id);
        if (classAttribute != null && h02 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a10 = wVar.s0().a(context.getClassLoader(), classAttribute);
            y8.k.d(a10, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            a10.N0(context, attributeSet, null);
            wVar.o().s(true).d(this, a10, string).k();
        }
        wVar.X0(this);
    }

    private final void a(View view) {
        if (this.f2881g.contains(view)) {
            this.f2880f.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        y8.k.e(view, "child");
        if (w.B0(view) != null) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        androidx.core.view.k0 a02;
        y8.k.e(windowInsets, "insets");
        androidx.core.view.k0 u10 = androidx.core.view.k0.u(windowInsets);
        y8.k.d(u10, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f2882h;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f2884a;
            y8.k.b(onApplyWindowInsetsListener);
            a02 = androidx.core.view.k0.u(aVar.a(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            a02 = androidx.core.view.a0.a0(this, u10);
        }
        y8.k.d(a02, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!a02.n()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                androidx.core.view.a0.g(getChildAt(i10), a02);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        y8.k.e(canvas, "canvas");
        if (this.f2883i) {
            Iterator<T> it = this.f2880f.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j10) {
        y8.k.e(canvas, "canvas");
        y8.k.e(view, "child");
        if (this.f2883i && (!this.f2880f.isEmpty()) && this.f2880f.contains(view)) {
            return false;
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        y8.k.e(view, "view");
        this.f2881g.remove(view);
        if (this.f2880f.remove(view)) {
            this.f2883i = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) w.k0(this).h0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        y8.k.e(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                y8.k.d(childAt, "view");
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        y8.k.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        View childAt = getChildAt(i10);
        y8.k.d(childAt, "view");
        a(childAt);
        super.removeViewAt(i10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        y8.k.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View childAt = getChildAt(i13);
            y8.k.d(childAt, "view");
            a(childAt);
        }
        super.removeViews(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View childAt = getChildAt(i13);
            y8.k.d(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i10, i11);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f2883i = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT >= 18) {
            throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
        }
        super.setLayoutTransition(layoutTransition);
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        y8.k.e(onApplyWindowInsetsListener, "listener");
        this.f2882h = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        y8.k.e(view, "view");
        if (view.getParent() == this) {
            this.f2881g.add(view);
        }
        super.startViewTransition(view);
    }
}
