package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ModalLayoutLandscape extends BaseModalLayout {
    private static final int ITEM_SPACING_DP = 24;
    private static final float MAX_IMG_WIDTH_PCT = 0.4f;
    private int barrierWidth;
    private View buttonChild;
    private View imageChild;
    private int leftContentHeight;
    private int rightContentHeight;
    private View scrollChild;
    private View titleChild;
    private int vertItemSpacing;

    public ModalLayoutLandscape(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i7 = this.leftContentHeight;
        int i8 = this.rightContentHeight;
        if (i7 < i8) {
            i6 = (i8 - i7) / 2;
            i5 = 0;
        } else {
            i5 = (i7 - i8) / 2;
            i6 = 0;
        }
        Logging.logd("Layout image");
        int i9 = paddingTop + i6;
        int b = b(this.imageChild) + paddingLeft;
        a(this.imageChild, paddingLeft, i9, b, i9 + a(this.imageChild));
        int i10 = b + this.barrierWidth;
        Logging.logd("Layout getTitle");
        int i11 = paddingTop + i5;
        int a = a(this.titleChild) + i11;
        a(this.titleChild, i10, i11, measuredWidth, a);
        Logging.logd("Layout getBody");
        int i12 = a + (this.titleChild.getVisibility() == 8 ? 0 : this.vertItemSpacing);
        int a2 = a(this.scrollChild) + i12;
        a(this.scrollChild, i10, i12, measuredWidth, a2);
        Logging.logd("Layout button");
        a(this.buttonChild, i10, a2 + (this.scrollChild.getVisibility() != 8 ? this.vertItemSpacing : 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.imageChild = d(R.id.image_view);
        this.titleChild = d(R.id.message_title);
        this.scrollChild = d(R.id.body_scroll);
        this.buttonChild = d(R.id.button);
        int i3 = 0;
        this.barrierWidth = this.imageChild.getVisibility() == 8 ? 0 : c(24);
        this.vertItemSpacing = c(24);
        List asList = Arrays.asList(this.titleChild, this.scrollChild, this.buttonChild);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int b = b(i);
        int a = a(i2) - paddingBottom;
        int i4 = b - paddingLeft;
        Logging.logd("Measuring image");
        MeasureUtils.measureAtMost(this.imageChild, (int) (i4 * MAX_IMG_WIDTH_PCT), a);
        int b2 = b(this.imageChild);
        int i5 = i4 - (this.barrierWidth + b2);
        float f = b2;
        Logging.logdPair("Max col widths (l, r)", f, i5);
        Iterator it = asList.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() != 8) {
                i6++;
            }
        }
        int max = Math.max(0, (i6 - 1) * this.vertItemSpacing);
        int i7 = a - max;
        Logging.logd("Measuring getTitle");
        MeasureUtils.measureAtMost(this.titleChild, i5, i7);
        Logging.logd("Measuring button");
        MeasureUtils.measureAtMost(this.buttonChild, i5, i7);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureAtMost(this.scrollChild, i5, (i7 - a(this.titleChild)) - a(this.buttonChild));
        this.leftContentHeight = a(this.imageChild);
        this.rightContentHeight = max;
        Iterator it2 = asList.iterator();
        while (it2.hasNext()) {
            this.rightContentHeight += a((View) it2.next());
        }
        int max2 = Math.max(this.leftContentHeight + paddingBottom, this.rightContentHeight + paddingBottom);
        Iterator it3 = asList.iterator();
        while (it3.hasNext()) {
            i3 = Math.max(b((View) it3.next()), i3);
        }
        Logging.logdPair("Measured columns (l, r)", f, i3);
        int i8 = b2 + i3 + this.barrierWidth + paddingLeft;
        Logging.logdPair("Measured dims", i8, max2);
        setMeasuredDimension(i8, max2);
    }
}
