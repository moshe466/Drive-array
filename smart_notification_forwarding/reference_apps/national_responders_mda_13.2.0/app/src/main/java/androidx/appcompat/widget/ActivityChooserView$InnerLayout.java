package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f1089f = {R.attr.background};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y0 u10 = y0.u(context, attributeSet, f1089f);
        setBackgroundDrawable(u10.g(0));
        u10.w();
    }
}
