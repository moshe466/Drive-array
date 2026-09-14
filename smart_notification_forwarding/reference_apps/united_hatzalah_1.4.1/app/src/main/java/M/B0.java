package m;

import F0.b3;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import g.AbstractC0424a;

/* loaded from: classes.dex */
public abstract class B0 extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5501a;

    /* renamed from: b, reason: collision with root package name */
    public int f5502b;

    /* renamed from: c, reason: collision with root package name */
    public int f5503c;

    /* renamed from: d, reason: collision with root package name */
    public int f5504d;

    /* renamed from: e, reason: collision with root package name */
    public int f5505e;

    /* renamed from: f, reason: collision with root package name */
    public int f5506f;

    /* renamed from: j, reason: collision with root package name */
    public float f5507j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5508k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f5509l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f5510m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f5511n;

    /* renamed from: o, reason: collision with root package name */
    public int f5512o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f5513q;

    /* renamed from: r, reason: collision with root package name */
    public int f5514r;

    public B0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5501a = true;
        this.f5502b = -1;
        this.f5503c = 0;
        this.f5505e = 8388659;
        int[] iArr = AbstractC0424a.f4639n;
        b3 t3 = b3.t(context, attributeSet, iArr, i);
        J.S.h(this, context, iArr, attributeSet, (TypedArray) t3.f470c, i);
        TypedArray typedArray = (TypedArray) t3.f470c;
        int i3 = typedArray.getInt(1, -1);
        if (i3 >= 0) {
            setOrientation(i3);
        }
        int i4 = typedArray.getInt(0, -1);
        if (i4 >= 0) {
            setGravity(i4);
        }
        boolean z3 = typedArray.getBoolean(2, true);
        if (!z3) {
            setBaselineAligned(z3);
        }
        this.f5507j = typedArray.getFloat(4, -1.0f);
        this.f5502b = typedArray.getInt(3, -1);
        this.f5508k = typedArray.getBoolean(7, false);
        setDividerDrawable(t3.o(5));
        this.f5513q = typedArray.getInt(8, 0);
        this.f5514r = typedArray.getDimensionPixelSize(6, 0);
        t3.v();
    }

    public final void c(Canvas canvas, int i) {
        this.f5511n.setBounds(getPaddingLeft() + this.f5514r, i, (getWidth() - getPaddingRight()) - this.f5514r, this.p + i);
        this.f5511n.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof A0;
    }

    public final void d(Canvas canvas, int i) {
        this.f5511n.setBounds(i, getPaddingTop() + this.f5514r, this.f5512o + i, (getHeight() - getPaddingBottom()) - this.f5514r);
        this.f5511n.draw(canvas);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [m.A0, android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [m.A0, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public A0 generateDefaultLayoutParams() {
        int i = this.f5504d;
        if (i == 0) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LinearLayout.LayoutParams(-1, -2);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [m.A0, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public A0 generateLayoutParams(AttributeSet attributeSet) {
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [m.A0, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public A0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LinearLayout.LayoutParams(layoutParams);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f5502b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f5502b;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f5502b == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i4 = this.f5503c;
            if (this.f5504d == 1 && (i = this.f5505e & 112) != 48) {
                if (i != 16) {
                    if (i == 80) {
                        i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f5506f;
                    }
                } else {
                    i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f5506f) / 2;
                }
            }
            return i4 + ((LinearLayout.LayoutParams) ((A0) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f5502b;
    }

    public Drawable getDividerDrawable() {
        return this.f5511n;
    }

    public int getDividerPadding() {
        return this.f5514r;
    }

    public int getDividerWidth() {
        return this.f5512o;
    }

    public int getGravity() {
        return this.f5505e;
    }

    public int getOrientation() {
        return this.f5504d;
    }

    public int getShowDividers() {
        return this.f5513q;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f5507j;
    }

    public final boolean h(int i) {
        if (i == 0) {
            if ((this.f5513q & 1) == 0) {
                return false;
            }
            return true;
        }
        if (i == getChildCount()) {
            if ((this.f5513q & 4) == 0) {
                return false;
            }
            return true;
        }
        if ((this.f5513q & 2) != 0) {
            for (int i3 = i - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int bottom;
        if (this.f5511n != null) {
            int i3 = 0;
            if (this.f5504d == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i3 < virtualChildCount) {
                    View childAt = getChildAt(i3);
                    if (childAt != null && childAt.getVisibility() != 8 && h(i3)) {
                        c(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((A0) childAt.getLayoutParams())).topMargin) - this.p);
                    }
                    i3++;
                }
                if (h(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    if (childAt2 == null) {
                        bottom = (getHeight() - getPaddingBottom()) - this.p;
                    } else {
                        bottom = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((A0) childAt2.getLayoutParams())).bottomMargin;
                    }
                    c(canvas, bottom);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean a2 = z1.a(this);
            while (i3 < virtualChildCount2) {
                View childAt3 = getChildAt(i3);
                if (childAt3 != null && childAt3.getVisibility() != 8 && h(i3)) {
                    A0 a02 = (A0) childAt3.getLayoutParams();
                    if (a2) {
                        left2 = childAt3.getRight() + ((LinearLayout.LayoutParams) a02).rightMargin;
                    } else {
                        left2 = (childAt3.getLeft() - ((LinearLayout.LayoutParams) a02).leftMargin) - this.f5512o;
                    }
                    d(canvas, left2);
                }
                i3++;
            }
            if (h(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 == null) {
                    if (a2) {
                        right = getPaddingLeft();
                    } else {
                        left = getWidth() - getPaddingRight();
                        i = this.f5512o;
                        right = left - i;
                    }
                } else {
                    A0 a03 = (A0) childAt4.getLayoutParams();
                    if (a2) {
                        left = childAt4.getLeft() - ((LinearLayout.LayoutParams) a03).leftMargin;
                        i = this.f5512o;
                        right = left - i;
                    } else {
                        right = childAt4.getRight() + ((LinearLayout.LayoutParams) a03).rightMargin;
                    }
                }
                d(canvas, right);
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.B0.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.B0.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z3) {
        this.f5501a = z3;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f5502b = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f5511n) {
            return;
        }
        this.f5511n = drawable;
        boolean z3 = false;
        if (drawable != null) {
            this.f5512o = drawable.getIntrinsicWidth();
            this.p = drawable.getIntrinsicHeight();
        } else {
            this.f5512o = 0;
            this.p = 0;
        }
        if (drawable == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.f5514r = i;
    }

    public void setGravity(int i) {
        if (this.f5505e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f5505e = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i3 = i & 8388615;
        int i4 = this.f5505e;
        if ((8388615 & i4) != i3) {
            this.f5505e = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z3) {
        this.f5508k = z3;
    }

    public void setOrientation(int i) {
        if (this.f5504d != i) {
            this.f5504d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f5513q) {
            requestLayout();
        }
        this.f5513q = i;
    }

    public void setVerticalGravity(int i) {
        int i3 = i & 112;
        int i4 = this.f5505e;
        if ((i4 & 112) != i3) {
            this.f5505e = i3 | (i4 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f4) {
        this.f5507j = Math.max(0.0f, f4);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
