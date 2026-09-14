package androidx.appcompat.widget;

import F0.I0;
import J.S;
import J.X;
import a.AbstractC0228a;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.uh.sf.R;
import g.AbstractC0424a;
import h.ViewOnClickListenerC0433c;
import java.util.WeakHashMap;
import k.AbstractC0458b;
import l.InterfaceC0498B;
import l.m;
import m.C0540e;
import m.C0548i;
import m.z1;

/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final I0 f2808a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2809b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f2810c;

    /* renamed from: d, reason: collision with root package name */
    public C0548i f2811d;

    /* renamed from: e, reason: collision with root package name */
    public int f2812e;

    /* renamed from: f, reason: collision with root package name */
    public X f2813f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2814j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2815k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2816l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f2817m;

    /* renamed from: n, reason: collision with root package name */
    public View f2818n;

    /* renamed from: o, reason: collision with root package name */
    public View f2819o;
    public View p;

    /* renamed from: q, reason: collision with root package name */
    public LinearLayout f2820q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f2821r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f2822s;

    /* renamed from: t, reason: collision with root package name */
    public final int f2823t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2824u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2825v;

    /* renamed from: w, reason: collision with root package name */
    public final int f2826w;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.actionModeStyle);
        Drawable drawable;
        int resourceId;
        this.f2808a = new I0(this);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f2809b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f2809b = context;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0424a.f4630d, R.attr.actionModeStyle, 0);
        if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
            drawable = AbstractC0228a.q(context, resourceId);
        } else {
            drawable = obtainStyledAttributes.getDrawable(0);
        }
        WeakHashMap weakHashMap = S.f954a;
        setBackground(drawable);
        this.f2823t = obtainStyledAttributes.getResourceId(5, 0);
        this.f2824u = obtainStyledAttributes.getResourceId(4, 0);
        this.f2812e = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.f2826w = obtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    public static int f(View view, int i, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i3);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int g(View view, int i, int i3, int i4, boolean z3) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = ((i4 - measuredHeight) / 2) + i3;
        if (z3) {
            view.layout(i - measuredWidth, i5, i, measuredHeight + i5);
        } else {
            view.layout(i, i5, i + measuredWidth, measuredHeight + i5);
        }
        if (z3) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public final void c(AbstractC0458b abstractC0458b) {
        View view = this.f2818n;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f2826w, (ViewGroup) this, false);
            this.f2818n = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f2818n);
        }
        View findViewById = this.f2818n.findViewById(R.id.action_mode_close_button);
        this.f2819o = findViewById;
        findViewById.setOnClickListener(new ViewOnClickListenerC0433c(abstractC0458b, 1));
        m c4 = abstractC0458b.c();
        C0548i c0548i = this.f2811d;
        if (c0548i != null) {
            c0548i.g();
            C0540e c0540e = c0548i.f5686w;
            if (c0540e != null && c0540e.b()) {
                c0540e.i.dismiss();
            }
        }
        C0548i c0548i2 = new C0548i(getContext());
        this.f2811d = c0548i2;
        c0548i2.f5679o = true;
        c0548i2.p = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        c4.b(this.f2811d, this.f2809b);
        C0548i c0548i3 = this.f2811d;
        InterfaceC0498B interfaceC0498B = c0548i3.f5675k;
        if (interfaceC0498B == null) {
            InterfaceC0498B interfaceC0498B2 = (InterfaceC0498B) c0548i3.f5671d.inflate(c0548i3.f5673f, (ViewGroup) this, false);
            c0548i3.f5675k = interfaceC0498B2;
            interfaceC0498B2.b(c0548i3.f5670c);
            c0548i3.e();
        }
        InterfaceC0498B interfaceC0498B3 = c0548i3.f5675k;
        if (interfaceC0498B != interfaceC0498B3) {
            ((ActionMenuView) interfaceC0498B3).setPresenter(c0548i3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) interfaceC0498B3;
        this.f2810c = actionMenuView;
        WeakHashMap weakHashMap = S.f954a;
        actionMenuView.setBackground(null);
        addView(this.f2810c, layoutParams);
    }

    public final void d() {
        int i;
        if (this.f2820q == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2820q = linearLayout;
            this.f2821r = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f2822s = (TextView) this.f2820q.findViewById(R.id.action_bar_subtitle);
            int i3 = this.f2823t;
            if (i3 != 0) {
                this.f2821r.setTextAppearance(getContext(), i3);
            }
            int i4 = this.f2824u;
            if (i4 != 0) {
                this.f2822s.setTextAppearance(getContext(), i4);
            }
        }
        this.f2821r.setText(this.f2816l);
        this.f2822s.setText(this.f2817m);
        boolean isEmpty = TextUtils.isEmpty(this.f2816l);
        boolean isEmpty2 = TextUtils.isEmpty(this.f2817m);
        TextView textView = this.f2822s;
        int i5 = 8;
        if (!isEmpty2) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout2 = this.f2820q;
        if (!isEmpty || !isEmpty2) {
            i5 = 0;
        }
        linearLayout2.setVisibility(i5);
        if (this.f2820q.getParent() == null) {
            addView(this.f2820q);
        }
    }

    public final void e() {
        removeAllViews();
        this.p = null;
        this.f2810c = null;
        this.f2811d = null;
        View view = this.f2819o;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        if (this.f2813f != null) {
            return this.f2808a.f227c;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f2812e;
    }

    public CharSequence getSubtitle() {
        return this.f2817m;
    }

    public CharSequence getTitle() {
        return this.f2816l;
    }

    @Override // android.view.View
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i) {
        if (i != getVisibility()) {
            X x3 = this.f2813f;
            if (x3 != null) {
                x3.b();
            }
            super.setVisibility(i);
        }
    }

    public final X i(int i, long j2) {
        X x3 = this.f2813f;
        if (x3 != null) {
            x3.b();
        }
        I0 i02 = this.f2808a;
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            X a2 = S.a(this);
            a2.a(1.0f);
            a2.c(j2);
            ((ActionBarContextView) i02.f228d).f2813f = a2;
            i02.f227c = i;
            a2.d(i02);
            return a2;
        }
        X a4 = S.a(this);
        a4.a(0.0f);
        a4.c(j2);
        ((ActionBarContextView) i02.f228d).f2813f = a4;
        i02.f227c = i;
        a4.d(i02);
        return a4;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        int i;
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, AbstractC0424a.f4627a, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        C0548i c0548i = this.f2811d;
        if (c0548i != null) {
            Configuration configuration2 = c0548i.f5669b.getResources().getConfiguration();
            int i3 = configuration2.screenWidthDp;
            int i4 = configuration2.screenHeightDp;
            if (configuration2.smallestScreenWidthDp <= 600 && i3 <= 600 && ((i3 <= 960 || i4 <= 720) && (i3 <= 720 || i4 <= 960))) {
                if (i3 < 500 && ((i3 <= 640 || i4 <= 480) && (i3 <= 480 || i4 <= 640))) {
                    if (i3 >= 360) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                } else {
                    i = 4;
                }
            } else {
                i = 5;
            }
            c0548i.f5682s = i;
            m mVar = c0548i.f5670c;
            if (mVar != null) {
                mVar.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0548i c0548i = this.f2811d;
        if (c0548i != null) {
            c0548i.g();
            C0540e c0540e = this.f2811d.f5686w;
            if (c0540e != null && c0540e.b()) {
                c0540e.i.dismiss();
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2815k = false;
        }
        if (!this.f2815k) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f2815k = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f2815k = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        int paddingLeft;
        int paddingRight;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean a2 = z1.a(this);
        if (a2) {
            paddingLeft = (i4 - i) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2818n;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2818n.getLayoutParams();
            if (a2) {
                i6 = marginLayoutParams.rightMargin;
            } else {
                i6 = marginLayoutParams.leftMargin;
            }
            if (a2) {
                i7 = marginLayoutParams.leftMargin;
            } else {
                i7 = marginLayoutParams.rightMargin;
            }
            if (a2) {
                i8 = paddingLeft - i6;
            } else {
                i8 = paddingLeft + i6;
            }
            int g3 = g(this.f2818n, i8, paddingTop, paddingTop2, a2) + i8;
            if (a2) {
                i9 = g3 - i7;
            } else {
                i9 = g3 + i7;
            }
            paddingLeft = i9;
        }
        LinearLayout linearLayout = this.f2820q;
        if (linearLayout != null && this.p == null && linearLayout.getVisibility() != 8) {
            paddingLeft += g(this.f2820q, paddingLeft, paddingTop, paddingTop2, a2);
        }
        View view2 = this.p;
        if (view2 != null) {
            g(view2, paddingLeft, paddingTop, paddingTop2, a2);
        }
        if (a2) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = (i4 - i) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f2810c;
        if (actionMenuView != null) {
            g(actionMenuView, paddingRight, paddingTop, paddingTop2, !a2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        int i4;
        boolean z3;
        int i5;
        int i6 = 1073741824;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            if (View.MeasureSpec.getMode(i3) != 0) {
                int size = View.MeasureSpec.getSize(i);
                int i7 = this.f2812e;
                if (i7 <= 0) {
                    i7 = View.MeasureSpec.getSize(i3);
                }
                int paddingBottom = getPaddingBottom() + getPaddingTop();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i8 = i7 - paddingBottom;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE);
                View view = this.f2818n;
                if (view != null) {
                    int f4 = f(view, paddingLeft, makeMeasureSpec);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2818n.getLayoutParams();
                    paddingLeft = f4 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.f2810c;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = f(this.f2810c, paddingLeft, makeMeasureSpec);
                }
                LinearLayout linearLayout = this.f2820q;
                if (linearLayout != null && this.p == null) {
                    if (this.f2825v) {
                        this.f2820q.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.f2820q.getMeasuredWidth();
                        if (measuredWidth <= paddingLeft) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            paddingLeft -= measuredWidth;
                        }
                        LinearLayout linearLayout2 = this.f2820q;
                        if (z3) {
                            i5 = 0;
                        } else {
                            i5 = 8;
                        }
                        linearLayout2.setVisibility(i5);
                    } else {
                        paddingLeft = f(linearLayout, paddingLeft, makeMeasureSpec);
                    }
                }
                View view2 = this.p;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i9 = layoutParams.width;
                    if (i9 != -2) {
                        i4 = 1073741824;
                    } else {
                        i4 = Integer.MIN_VALUE;
                    }
                    if (i9 >= 0) {
                        paddingLeft = Math.min(i9, paddingLeft);
                    }
                    int i10 = layoutParams.height;
                    if (i10 == -2) {
                        i6 = Integer.MIN_VALUE;
                    }
                    if (i10 >= 0) {
                        i8 = Math.min(i10, i8);
                    }
                    this.p.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(i8, i6));
                }
                if (this.f2812e <= 0) {
                    int childCount = getChildCount();
                    int i11 = 0;
                    for (int i12 = 0; i12 < childCount; i12++) {
                        int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingBottom;
                        if (measuredHeight > i11) {
                            i11 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i11);
                    return;
                }
                setMeasuredDimension(size, i7);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2814j = false;
        }
        if (!this.f2814j) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f2814j = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f2814j = false;
        return true;
    }

    public void setContentHeight(int i) {
        this.f2812e = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.p;
        if (view2 != null) {
            removeView(view2);
        }
        this.p = view;
        if (view != null && (linearLayout = this.f2820q) != null) {
            removeView(linearLayout);
            this.f2820q = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2817m = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2816l = charSequence;
        d();
        S.j(this, charSequence);
    }

    public void setTitleOptional(boolean z3) {
        if (z3 != this.f2825v) {
            requestLayout();
        }
        this.f2825v = z3;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
