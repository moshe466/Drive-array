package androidx.appcompat.widget;

import J.S;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.uh.sf.R;
import g.AbstractC0424a;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2865a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2866b;

    /* renamed from: c, reason: collision with root package name */
    public int f2867c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2867c = -1;
        int[] iArr = AbstractC0424a.f4636k;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        S.h(this, context, iArr, attributeSet, obtainStyledAttributes, 0);
        this.f2865a = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f2865a);
        }
    }

    private void setStacked(boolean z3) {
        int i;
        int i3;
        if (this.f2866b != z3) {
            if (!z3 || this.f2865a) {
                this.f2866b = z3;
                setOrientation(z3 ? 1 : 0);
                if (z3) {
                    i = 8388613;
                } else {
                    i = 80;
                }
                setGravity(i);
                View findViewById = findViewById(R.id.spacer);
                if (findViewById != null) {
                    if (z3) {
                        i3 = 8;
                    } else {
                        i3 = 4;
                    }
                    findViewById.setVisibility(i3);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        int i4;
        boolean z3;
        int i5;
        int size = View.MeasureSpec.getSize(i);
        int i6 = 0;
        if (this.f2865a) {
            if (size > this.f2867c && this.f2866b) {
                setStacked(false);
            }
            this.f2867c = size;
        }
        if (!this.f2866b && View.MeasureSpec.getMode(i) == 1073741824) {
            i4 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z3 = true;
        } else {
            i4 = i;
            z3 = false;
        }
        super.onMeasure(i4, i3);
        if (this.f2865a && !this.f2866b && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z3 = true;
        }
        if (z3) {
            super.onMeasure(i, i3);
        }
        int childCount = getChildCount();
        int i7 = 0;
        while (true) {
            i5 = -1;
            if (i7 < childCount) {
                if (getChildAt(i7).getVisibility() == 0) {
                    break;
                } else {
                    i7++;
                }
            } else {
                i7 = -1;
                break;
            }
        }
        if (i7 >= 0) {
            View childAt = getChildAt(i7);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f2866b) {
                int i8 = i7 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i8 >= childCount2) {
                        break;
                    }
                    if (getChildAt(i8).getVisibility() == 0) {
                        i5 = i8;
                        break;
                    }
                    i8++;
                }
                if (i5 >= 0) {
                    i6 = getChildAt(i5).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight;
                } else {
                    i6 = measuredHeight;
                }
            } else {
                i6 = getPaddingBottom() + measuredHeight;
            }
        }
        WeakHashMap weakHashMap = S.f954a;
        if (getMinimumHeight() != i6) {
            setMinimumHeight(i6);
            if (i3 == 0) {
                super.onMeasure(i, i3);
            }
        }
    }

    public void setAllowStacking(boolean z3) {
        if (this.f2865a != z3) {
            this.f2865a = z3;
            if (!z3 && this.f2866b) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
