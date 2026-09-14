package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseModalLayout extends FrameLayout {
    private static final float DEFAULT_MAX_HEIGHT_PCT = -1.0f;
    private static final float DEFAULT_MAX_WIDTH_PCT = -1.0f;
    private DisplayMetrics mDisplay;
    private float mMaxHeightPct;
    private float mMaxWidthPct;
    private List<View> mVisibleChildren;

    public BaseModalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVisibleChildren = new ArrayList();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ModalLayout, 0, 0);
        try {
            this.mMaxWidthPct = obtainStyledAttributes.getFloat(R.styleable.ModalLayout_maxWidthPct, -1.0f);
            this.mMaxHeightPct = obtainStyledAttributes.getFloat(R.styleable.ModalLayout_maxHeightPct, -1.0f);
            obtainStyledAttributes.recycle();
            this.mDisplay = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i) {
        if (getMaxHeightPct() > 0.0f) {
            Logging.logd("Height: restrict by pct");
            return a((int) (getDisplayMetrics().heightPixels * getMaxHeightPct()), 4);
        }
        Logging.logd("Height: restrict by spec");
        return View.MeasureSpec.getSize(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i, int i2) {
        return i2 * Math.round(i / i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, int i, int i2) {
        a(view, i, i2, i + b(view), i2 + a(view));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, int i, int i2, int i3, int i4) {
        Logging.logdPair("\tleft, right", i, i3);
        Logging.logdPair("\ttop, bottom", i2, i4);
        view.layout(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(int i) {
        if (getMaxWidthPct() > 0.0f) {
            Logging.logd("Width: restrict by pct");
            return a((int) (getDisplayMetrics().widthPixels * getMaxWidthPct()), 4);
        }
        Logging.logd("Width: restrict by spec");
        return View.MeasureSpec.getSize(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(int i) {
        return (int) Math.floor(TypedValue.applyDimension(1, i, this.mDisplay));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameLayout.LayoutParams c(View view) {
        return (FrameLayout.LayoutParams) view.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public View d(@IdRes int i) {
        View findViewById = findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalStateException("No such child: " + i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DisplayMetrics getDisplayMetrics() {
        return this.mDisplay;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getMaxHeightPct() {
        return this.mMaxHeightPct;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getMaxWidthPct() {
        return this.mMaxWidthPct;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<View> getVisibleChildren() {
        return this.mVisibleChildren;
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        Logging.logdPair("\tdesired (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
        super.measureChildWithMargins(view, i, i2, i3, i4);
        Logging.logdPair("\tactual  (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Logging.logdHeader("BEGIN LAYOUT");
        Logging.logd("onLayout: l: " + i + ", t: " + i2 + ", r: " + i3 + ", b: " + i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Logging.logdHeader("BEGIN MEASURE");
        Logging.logdPair("Display", getDisplayMetrics().widthPixels, getDisplayMetrics().heightPixels);
        this.mVisibleChildren.clear();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                this.mVisibleChildren.add(childAt);
            } else {
                Logging.logdNumber("Skipping GONE child", i3);
            }
        }
    }
}
