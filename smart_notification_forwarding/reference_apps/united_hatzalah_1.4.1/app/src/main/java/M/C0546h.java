package m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.uh.sf.R;
import l.C0504b;

/* renamed from: m.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0546h extends C0577x implements InterfaceC0550j {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0548i f5667d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0546h(C0548i c0548i, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f5667d = c0548i;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        p3.h.D(this, getContentDescription());
        setOnTouchListener(new C0504b(this, this));
    }

    @Override // m.InterfaceC0550j
    public final boolean a() {
        return false;
    }

    @Override // m.InterfaceC0550j
    public final boolean c() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f5667d.l();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i, i3, i4, i5);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            background.setHotspotBounds(paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
        }
        return frame;
    }
}
