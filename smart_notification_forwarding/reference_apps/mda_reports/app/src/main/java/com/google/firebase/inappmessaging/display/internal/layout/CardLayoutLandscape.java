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
public class CardLayoutLandscape extends BaseModalLayout {
    private static double IMAGE_MAX_WIDTH_PCT = 0.6d;
    private View actionBarChild;
    private View imageChild;
    private View scrollChild;
    private View titleChild;

    public CardLayoutLandscape(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Logging.logd("Layout image");
        int b = b(this.imageChild);
        a(this.imageChild, 0, 0, b, a(this.imageChild));
        Logging.logd("Layout title");
        int a = a(this.titleChild);
        a(this.titleChild, b, 0, measuredWidth, a);
        Logging.logd("Layout scroll");
        a(this.scrollChild, b, a, measuredWidth, a + a(this.scrollChild));
        Logging.logd("Layout action bar");
        a(this.actionBarChild, b, measuredHeight - a(this.actionBarChild), measuredWidth, measuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.imageChild = d(R.id.image_view);
        this.titleChild = d(R.id.message_title);
        this.scrollChild = d(R.id.body_scroll);
        this.actionBarChild = d(R.id.action_bar);
        int i3 = 0;
        List asList = Arrays.asList(this.titleChild, this.scrollChild, this.actionBarChild);
        int b = b(i);
        int a = a(i2);
        double d = IMAGE_MAX_WIDTH_PCT;
        double d2 = b;
        Double.isNaN(d2);
        int a2 = a((int) (d * d2), 4);
        Logging.logd("Measuring image");
        MeasureUtils.measureFullHeight(this.imageChild, b, a);
        if (b(this.imageChild) > a2) {
            Logging.logd("Image exceeded maximum width, remeasuring image");
            MeasureUtils.measureFullWidth(this.imageChild, a2, a);
        }
        int a3 = a(this.imageChild);
        int b2 = b(this.imageChild);
        int i4 = b - b2;
        float f = b2;
        Logging.logdPair("Max col widths (l, r)", f, i4);
        Logging.logd("Measuring title");
        MeasureUtils.measureAtMost(this.titleChild, i4, a3);
        Logging.logd("Measuring action bar");
        MeasureUtils.measureAtMost(this.actionBarChild, i4, a3);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureFullHeight(this.scrollChild, i4, (a3 - a(this.titleChild)) - a(this.actionBarChild));
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            i3 = Math.max(b((View) it.next()), i3);
        }
        Logging.logdPair("Measured columns (l, r)", f, i3);
        int i5 = b2 + i3;
        Logging.logdPair("Measured dims", i5, a3);
        setMeasuredDimension(i5, a3);
    }
}
