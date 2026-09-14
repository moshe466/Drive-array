package m;

import F0.b3;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.uh.sf.R;
import g.AbstractC0424a;

/* renamed from: m.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0527F extends C0522A {

    /* renamed from: e, reason: collision with root package name */
    public final C0526E f5519e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f5520f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f5521g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f5522h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5523j;

    public C0527F(C0526E c0526e) {
        super(c0526e);
        this.f5521g = null;
        this.f5522h = null;
        this.i = false;
        this.f5523j = false;
        this.f5519e = c0526e;
    }

    @Override // m.C0522A
    public final void b(AttributeSet attributeSet, int i) {
        super.b(attributeSet, R.attr.seekBarStyle);
        C0526E c0526e = this.f5519e;
        Context context = c0526e.getContext();
        int[] iArr = AbstractC0424a.f4633g;
        b3 t3 = b3.t(context, attributeSet, iArr, R.attr.seekBarStyle);
        TypedArray typedArray = (TypedArray) t3.f470c;
        J.S.h(c0526e, c0526e.getContext(), iArr, attributeSet, (TypedArray) t3.f470c, R.attr.seekBarStyle);
        Drawable p = t3.p(0);
        if (p != null) {
            c0526e.setThumb(p);
        }
        Drawable o2 = t3.o(1);
        Drawable drawable = this.f5520f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f5520f = o2;
        if (o2 != null) {
            o2.setCallback(c0526e);
            o2.setLayoutDirection(c0526e.getLayoutDirection());
            if (o2.isStateful()) {
                o2.setState(c0526e.getDrawableState());
            }
            f();
        }
        c0526e.invalidate();
        if (typedArray.hasValue(3)) {
            this.f5522h = AbstractC0565q0.c(typedArray.getInt(3, -1), this.f5522h);
            this.f5523j = true;
        }
        if (typedArray.hasValue(2)) {
            this.f5521g = t3.n(2);
            this.i = true;
        }
        t3.v();
        f();
    }

    public final void f() {
        Drawable drawable = this.f5520f;
        if (drawable != null) {
            if (this.i || this.f5523j) {
                Drawable mutate = drawable.mutate();
                this.f5520f = mutate;
                if (this.i) {
                    mutate.setTintList(this.f5521g);
                }
                if (this.f5523j) {
                    this.f5520f.setTintMode(this.f5522h);
                }
                if (this.f5520f.isStateful()) {
                    this.f5520f.setState(this.f5519e.getDrawableState());
                }
            }
        }
    }

    public final void g(Canvas canvas) {
        int i;
        if (this.f5520f != null) {
            int max = this.f5519e.getMax();
            int i3 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f5520f.getIntrinsicWidth();
                int intrinsicHeight = this.f5520f.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i = intrinsicWidth / 2;
                } else {
                    i = 1;
                }
                if (intrinsicHeight >= 0) {
                    i3 = intrinsicHeight / 2;
                }
                this.f5520f.setBounds(-i, -i3, i, i3);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f5520f.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
