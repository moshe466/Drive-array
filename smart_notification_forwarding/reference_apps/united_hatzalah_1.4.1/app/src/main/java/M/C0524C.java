package m;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.uh.sf.R;

/* renamed from: m.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0524C extends RatingBar {

    /* renamed from: a, reason: collision with root package name */
    public final C0522A f5515a;

    public C0524C(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ratingBarStyle);
        i1.a(this, getContext());
        C0522A c0522a = new C0522A(this);
        this.f5515a = c0522a;
        c0522a.b(attributeSet, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        Bitmap bitmap = (Bitmap) this.f5515a.f5496c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
