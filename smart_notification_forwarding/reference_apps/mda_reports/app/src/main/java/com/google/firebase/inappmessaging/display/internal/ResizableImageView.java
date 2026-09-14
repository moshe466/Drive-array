package com.google.firebase.inappmessaging.display.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes2.dex */
public class ResizableImageView extends AppCompatImageView {
    private int mDensityDpi;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Dimensions {
        final int a;
        final int b;

        private Dimensions(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public ResizableImageView(Context context) {
        super(context);
        init(context);
    }

    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ResizableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private Dimensions bound(int i, int i2) {
        int maxWidth = getMaxWidth();
        int maxHeight = getMaxHeight();
        if (i > maxWidth) {
            Logging.logdNumber("Image: capping width", maxWidth);
            i2 = (i2 * maxWidth) / i;
            i = maxWidth;
        }
        if (i2 > maxHeight) {
            Logging.logdNumber("Image: capping height", maxHeight);
            i = (i * maxHeight) / i2;
            i2 = maxHeight;
        }
        return new Dimensions(i, i2);
    }

    private void checkMinDim() {
        int max = Math.max(getMinimumWidth(), getSuggestedMinimumWidth());
        int max2 = Math.max(getMinimumHeight(), getSuggestedMinimumHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = max;
        float f2 = max2;
        Logging.logdPair("Image: min width, height", f, f2);
        float f3 = measuredWidth;
        float f4 = measuredHeight;
        Logging.logdPair("Image: actual width, height", f3, f4);
        float f5 = measuredWidth < max ? f / f3 : 1.0f;
        float f6 = measuredHeight < max2 ? f2 / f4 : 1.0f;
        if (f5 <= f6) {
            f5 = f6;
        }
        if (f5 > 1.0d) {
            int ceil = (int) Math.ceil(f3 * f5);
            int ceil2 = (int) Math.ceil(f4 * f5);
            Logging.logd("Measured dimension (" + measuredWidth + "x" + measuredHeight + ") too small.  Resizing to " + ceil + "x" + ceil2);
            Dimensions bound = bound(ceil, ceil2);
            setMeasuredDimension(bound.a, bound.b);
        }
    }

    private void init(@NonNull Context context) {
        this.mDensityDpi = (int) (context.getResources().getDisplayMetrics().density * 160.0f);
    }

    private void scalePxToDp(Drawable drawable) {
        Logging.logdPair("Image: intrinsic width, height", drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Dimensions bound = bound((int) Math.ceil((r0 * this.mDensityDpi) / 160), (int) Math.ceil((r5 * this.mDensityDpi) / 160));
        Logging.logdPair("Image: new target dimensions", bound.a, bound.b);
        setMeasuredDimension(bound.a, bound.b);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (Build.VERSION.SDK_INT > 16) {
            Drawable drawable = getDrawable();
            boolean adjustViewBounds = getAdjustViewBounds();
            if (drawable == null || !adjustViewBounds) {
                return;
            }
            scalePxToDp(drawable);
            checkMinDim();
        }
    }
}
