package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import com.google.firebase.inappmessaging.display.internal.layout.util.VerticalViewGroupMeasure;
import com.google.firebase.inappmessaging.display.internal.layout.util.ViewMeasure;

/* loaded from: classes2.dex */
public class ModalLayoutPortrait extends BaseModalLayout {
    private static final int ITEM_SPACING_DP = 24;
    private int vertItemSpacing;
    private VerticalViewGroupMeasure vgm;

    public ModalLayoutPortrait(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vgm = new VerticalViewGroupMeasure();
    }

    private boolean isFlex(View view) {
        return view.getId() == R.id.body_scroll || view.getId() == R.id.image_view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int size = getVisibleChildren().size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = getVisibleChildren().get(i7);
            FrameLayout.LayoutParams c = c(view);
            int measuredHeight = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i8 = measuredHeight + paddingTop;
            if ((c.gravity & 1) == 1) {
                int i9 = (i3 - i) / 2;
                int i10 = measuredWidth / 2;
                i6 = i9 - i10;
                i5 = i9 + i10;
            } else {
                i5 = paddingLeft + measuredWidth;
                i6 = paddingLeft;
            }
            Logging.logd("Layout child " + i7);
            Logging.logdPair("\t(top, bottom)", (float) paddingTop, (float) i8);
            Logging.logdPair("\t(left, right)", (float) i6, (float) i5);
            view.layout(i6, paddingTop, i5, i8);
            paddingTop += view.getMeasuredHeight();
            if (i7 < size - 1) {
                paddingTop += this.vertItemSpacing;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.vertItemSpacing = c(24);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int b = b(i);
        int a = a(i2);
        int size = paddingBottom + ((getVisibleChildren().size() - 1) * this.vertItemSpacing);
        this.vgm.reset(b, a);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            this.vgm.add(childAt, isFlex(childAt));
        }
        Logging.logd("Screen dimens: " + getDisplayMetrics());
        Logging.logdPair("Max pct", getMaxWidthPct(), getMaxHeightPct());
        float f = (float) b;
        Logging.logdPair("Base dimens", f, (float) a);
        for (ViewMeasure viewMeasure : this.vgm.getViews()) {
            Logging.logd("Pre-measure child");
            viewMeasure.preMeasure(b, a);
        }
        int totalHeight = this.vgm.getTotalHeight() + size;
        Logging.logdNumber("Total reserved height", size);
        Logging.logdNumber("Total desired height", totalHeight);
        boolean z = totalHeight > a;
        Logging.logd("Total height constrained: " + z);
        if (z) {
            this.vgm.allocateSpace((a - size) - this.vgm.getTotalFixedHeight());
        }
        int i4 = b - paddingRight;
        for (ViewMeasure viewMeasure2 : this.vgm.getViews()) {
            Logging.logd("Measuring child");
            MeasureUtils.measureAtMost(viewMeasure2.getView(), i4, viewMeasure2.getMaxHeight());
            size += a(viewMeasure2.getView());
        }
        Logging.logdPair("Measured dims", f, size);
        setMeasuredDimension(b, size);
    }
}
