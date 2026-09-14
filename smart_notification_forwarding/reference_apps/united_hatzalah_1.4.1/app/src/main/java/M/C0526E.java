package m;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.uh.sf.R;

/* renamed from: m.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0526E extends SeekBar {

    /* renamed from: a, reason: collision with root package name */
    public final C0527F f5518a;

    public C0526E(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarStyle);
        i1.a(this, getContext());
        C0527F c0527f = new C0527F(this);
        this.f5518a = c0527f;
        c0527f.b(attributeSet, R.attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0527F c0527f = this.f5518a;
        C0526E c0526e = c0527f.f5519e;
        Drawable drawable = c0527f.f5520f;
        if (drawable != null && drawable.isStateful() && drawable.setState(c0526e.getDrawableState())) {
            c0526e.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f5518a.f5520f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f5518a.g(canvas);
    }
}
