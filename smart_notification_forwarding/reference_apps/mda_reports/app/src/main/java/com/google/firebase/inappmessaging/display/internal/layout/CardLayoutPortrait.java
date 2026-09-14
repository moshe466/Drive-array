package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;

/* loaded from: classes2.dex */
public class CardLayoutPortrait extends BaseModalLayout {
    private static double IMAGE_MAX_HEIGHT_PCT = 0.8d;
    private View actionBarChild;
    private View imageChild;
    private View scrollChild;
    private View titleChild;

    public CardLayoutPortrait(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int size = getVisibleChildren().size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            View view = getVisibleChildren().get(i6);
            int measuredHeight = view.getMeasuredHeight() + i5;
            int measuredWidth = view.getMeasuredWidth() + 0;
            Logging.logd("Layout child " + i6);
            Logging.logdPair("\t(top, bottom)", (float) i5, (float) measuredHeight);
            Logging.logdPair("\t(left, right)", (float) 0, (float) measuredWidth);
            view.layout(0, i5, measuredWidth, measuredHeight);
            Logging.logdPair("Child " + i6 + " wants to be ", view.getMeasuredWidth(), view.getMeasuredHeight());
            i5 += view.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.imageChild = d(R.id.image_view);
        this.titleChild = d(R.id.message_title);
        this.scrollChild = d(R.id.body_scroll);
        this.actionBarChild = d(R.id.action_bar);
        int b = b(i);
        int a = a(i2);
        double d = IMAGE_MAX_HEIGHT_PCT;
        double d2 = a;
        Double.isNaN(d2);
        int a2 = a((int) (d * d2), 4);
        Logging.logd("Measuring image");
        MeasureUtils.measureFullWidth(this.imageChild, b, a);
        if (a(this.imageChild) > a2) {
            Logging.logd("Image exceeded maximum height, remeasuring image");
            MeasureUtils.measureFullHeight(this.imageChild, b, a2);
        }
        int b2 = b(this.imageChild);
        Logging.logd("Measuring title");
        MeasureUtils.measureFullWidth(this.titleChild, b2, a);
        Logging.logd("Measuring action bar");
        MeasureUtils.measureFullWidth(this.actionBarChild, b2, a);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureFullWidth(this.scrollChild, b2, ((a - a(this.imageChild)) - a(this.titleChild)) - a(this.actionBarChild));
        int size = getVisibleChildren().size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += a(getVisibleChildren().get(i4));
        }
        setMeasuredDimension(b2, i3);
    }
}
