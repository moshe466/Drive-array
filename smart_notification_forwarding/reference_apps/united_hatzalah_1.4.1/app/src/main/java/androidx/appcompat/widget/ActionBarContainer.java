package androidx.appcompat.widget;

import J.S;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.uh.sf.R;
import g.AbstractC0424a;
import java.util.WeakHashMap;
import m.C0532a;
import m.T0;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2799a;

    /* renamed from: b, reason: collision with root package name */
    public View f2800b;

    /* renamed from: c, reason: collision with root package name */
    public View f2801c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f2802d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f2803e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2804f;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2805j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2806k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2807l;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0532a c0532a = new C0532a(this);
        WeakHashMap weakHashMap = S.f954a;
        setBackground(c0532a);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0424a.f4627a);
        boolean z3 = false;
        this.f2802d = obtainStyledAttributes.getDrawable(0);
        this.f2803e = obtainStyledAttributes.getDrawable(2);
        this.f2807l = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f2805j = true;
            this.f2804f = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.f2805j ? !(this.f2802d != null || this.f2803e != null) : this.f2804f == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2802d;
        if (drawable != null && drawable.isStateful()) {
            this.f2802d.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2803e;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2803e.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2804f;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f2804f.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2802d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2803e;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2804f;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f2800b = findViewById(R.id.action_bar);
        this.f2801c = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f2799a && !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        super.onLayout(z3, i, i3, i4, i5);
        boolean z4 = true;
        if (this.f2805j) {
            Drawable drawable = this.f2804f;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z4 = false;
            }
        } else {
            if (this.f2802d != null) {
                if (this.f2800b.getVisibility() == 0) {
                    this.f2802d.setBounds(this.f2800b.getLeft(), this.f2800b.getTop(), this.f2800b.getRight(), this.f2800b.getBottom());
                } else {
                    View view = this.f2801c;
                    if (view != null && view.getVisibility() == 0) {
                        this.f2802d.setBounds(this.f2801c.getLeft(), this.f2801c.getTop(), this.f2801c.getRight(), this.f2801c.getBottom());
                    } else {
                        this.f2802d.setBounds(0, 0, 0, 0);
                    }
                }
            } else {
                z4 = false;
            }
            this.f2806k = false;
        }
        if (z4) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        int i4;
        if (this.f2800b == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.f2807l) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i3);
        if (this.f2800b == null) {
            return;
        }
        View.MeasureSpec.getMode(i3);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2802d;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2802d);
        }
        this.f2802d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2800b;
            if (view != null) {
                this.f2802d.setBounds(view.getLeft(), this.f2800b.getTop(), this.f2800b.getRight(), this.f2800b.getBottom());
            }
        }
        boolean z3 = false;
        if (!this.f2805j ? !(this.f2802d != null || this.f2803e != null) : this.f2804f == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2804f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2804f);
        }
        this.f2804f = drawable;
        boolean z3 = this.f2805j;
        boolean z4 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z3 && (drawable2 = this.f2804f) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z3 ? !(this.f2802d != null || this.f2803e != null) : this.f2804f == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f2803e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2803e);
        }
        this.f2803e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2806k && this.f2803e != null) {
                throw null;
            }
        }
        boolean z3 = false;
        if (!this.f2805j ? !(this.f2802d != null || this.f2803e != null) : this.f2804f == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z3) {
        int i;
        this.f2799a = z3;
        if (z3) {
            i = 393216;
        } else {
            i = 262144;
        }
        setDescendantFocusability(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z3;
        super.setVisibility(i);
        if (i == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Drawable drawable = this.f2802d;
        if (drawable != null) {
            drawable.setVisible(z3, false);
        }
        Drawable drawable2 = this.f2803e;
        if (drawable2 != null) {
            drawable2.setVisible(z3, false);
        }
        Drawable drawable3 = this.f2804f;
        if (drawable3 != null) {
            drawable3.setVisible(z3, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2802d;
        boolean z3 = this.f2805j;
        if (drawable != drawable2 || z3) {
            if (drawable != this.f2803e || !this.f2806k) {
                if ((drawable == this.f2804f && z3) || super.verifyDrawable(drawable)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    public void setTabContainer(T0 t02) {
    }
}
