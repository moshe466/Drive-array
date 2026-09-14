package m;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* renamed from: m.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0532a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f5623a;

    public C0532a(ActionBarContainer actionBarContainer) {
        this.f5623a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f5623a;
        if (actionBarContainer.f2805j) {
            Drawable drawable = actionBarContainer.f2804f;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2802d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f2803e;
        if (drawable3 != null && actionBarContainer.f2806k) {
            drawable3.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f5623a;
        if (actionBarContainer.f2805j) {
            if (actionBarContainer.f2804f != null) {
                actionBarContainer.f2802d.getOutline(outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f2802d;
            if (drawable != null) {
                drawable.getOutline(outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
