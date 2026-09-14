package com.groboot.mdaemergency.ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class ClearableAutoCompleteTextView extends androidx.appcompat.widget.d {

    /* renamed from: j, reason: collision with root package name */
    boolean f8304j;

    /* renamed from: k, reason: collision with root package name */
    private c f8305k;

    /* renamed from: l, reason: collision with root package name */
    private c f8306l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f8307m;

    /* loaded from: classes.dex */
    class a implements c {
        a() {
        }

        @Override // com.groboot.mdaemergency.ui.views.ClearableAutoCompleteTextView.c
        public void a() {
            ClearableAutoCompleteTextView.this.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (ClearableAutoCompleteTextView.this.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > (r4.getWidth() - r4.getPaddingRight()) - ClearableAutoCompleteTextView.this.f8307m.getIntrinsicWidth()) {
                ClearableAutoCompleteTextView.this.f8306l.a();
                ClearableAutoCompleteTextView.this.f8304j = true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    public ClearableAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a();
        this.f8305k = aVar;
        this.f8306l = aVar;
        this.f8307m = getResources().getDrawable(R.drawable.delete);
        c();
    }

    void c() {
        setDropDownBackgroundResource(R.color.autocompletet_background_color);
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f8307m, (Drawable) null);
        setOnTouchListener(new b());
    }

    public void setImgClearButton(Drawable drawable) {
        this.f8307m = drawable;
    }

    public void setOnClearListener(c cVar) {
        this.f8306l = cVar;
    }
}
