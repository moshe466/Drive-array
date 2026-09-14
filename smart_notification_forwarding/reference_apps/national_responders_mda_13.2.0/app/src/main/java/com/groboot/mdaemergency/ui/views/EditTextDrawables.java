package com.groboot.mdaemergency.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/* loaded from: classes.dex */
public class EditTextDrawables extends EditText {

    /* renamed from: f, reason: collision with root package name */
    private Drawable f8341f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f8342g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f8343h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f8344i;

    /* renamed from: j, reason: collision with root package name */
    int f8345j;

    /* renamed from: k, reason: collision with root package name */
    int f8346k;

    /* renamed from: l, reason: collision with root package name */
    private a f8347l;

    /* loaded from: classes.dex */
    public interface a {

        /* renamed from: com.groboot.mdaemergency.ui.views.EditTextDrawables$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0133a {
            TOP,
            BOTTOM,
            LEFT,
            RIGHT
        }

        void a(EnumC0133a enumC0133a);
    }

    public EditTextDrawables(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void finalize() {
        this.f8341f = null;
        this.f8344i = null;
        this.f8342g = null;
        this.f8343h = null;
        super.finalize();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        a.EnumC0133a enumC0133a;
        a aVar2;
        a.EnumC0133a enumC0133a2;
        if (motionEvent.getAction() == 0) {
            this.f8345j = (int) motionEvent.getX();
            this.f8346k = (int) motionEvent.getY();
            Drawable drawable = this.f8344i;
            if (drawable == null || !drawable.getBounds().contains(this.f8345j, this.f8346k)) {
                Drawable drawable2 = this.f8343h;
                if (drawable2 == null || !drawable2.getBounds().contains(this.f8345j, this.f8346k)) {
                    Drawable drawable3 = this.f8342g;
                    if (drawable3 != null) {
                        Rect bounds = drawable3.getBounds();
                        int i10 = (int) ((getResources().getDisplayMetrics().density * 13.0f) + 0.5d);
                        int i11 = this.f8345j;
                        int i12 = this.f8346k;
                        if (!bounds.contains(i11, i12)) {
                            i11 = this.f8345j;
                            int i13 = i11 - i10;
                            int i14 = this.f8346k;
                            int i15 = i14 - i10;
                            if (i13 > 0) {
                                i11 = i13;
                            }
                            i12 = i15 <= 0 ? i14 : i15;
                            if (i11 < i12) {
                                i12 = i11;
                            }
                        }
                        if (bounds.contains(i11, i12) && (aVar = this.f8347l) != null) {
                            enumC0133a = a.EnumC0133a.LEFT;
                            aVar.a(enumC0133a);
                            motionEvent.setAction(3);
                            return false;
                        }
                    }
                    Drawable drawable4 = this.f8341f;
                    if (drawable4 != null) {
                        Rect bounds2 = drawable4.getBounds();
                        int i16 = this.f8345j + 13;
                        int i17 = this.f8346k - 13;
                        int width = getWidth() - i16;
                        if (width <= 0) {
                            width += 13;
                        }
                        if (i17 <= 0) {
                            i17 = this.f8346k;
                        }
                        if (!bounds2.contains(width, i17) || (aVar = this.f8347l) == null) {
                            return super.onTouchEvent(motionEvent);
                        }
                        enumC0133a = a.EnumC0133a.RIGHT;
                        aVar.a(enumC0133a);
                        motionEvent.setAction(3);
                        return false;
                    }
                } else {
                    aVar2 = this.f8347l;
                    enumC0133a2 = a.EnumC0133a.TOP;
                }
            } else {
                aVar2 = this.f8347l;
                enumC0133a2 = a.EnumC0133a.BOTTOM;
            }
            aVar2.a(enumC0133a2);
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            this.f8342g = drawable;
        }
        if (drawable3 != null) {
            this.f8341f = drawable3;
        }
        if (drawable2 != null) {
            this.f8343h = drawable2;
        }
        if (drawable4 != null) {
            this.f8344i = drawable4;
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setDrawableClickListener(a aVar) {
        this.f8347l = aVar;
    }
}
