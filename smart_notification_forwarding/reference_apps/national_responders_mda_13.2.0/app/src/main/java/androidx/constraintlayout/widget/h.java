package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import p.e;

/* loaded from: classes.dex */
public class h extends View {

    /* renamed from: f, reason: collision with root package name */
    private int f1922f;

    /* renamed from: g, reason: collision with root package name */
    private View f1923g;

    /* renamed from: h, reason: collision with root package name */
    private int f1924h;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f1923g == null) {
            return;
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f1923g.getLayoutParams();
        bVar2.f1754r0.g1(0);
        e.b y10 = bVar.f1754r0.y();
        e.b bVar3 = e.b.FIXED;
        if (y10 != bVar3) {
            bVar.f1754r0.h1(bVar2.f1754r0.U());
        }
        if (bVar.f1754r0.R() != bVar3) {
            bVar.f1754r0.I0(bVar2.f1754r0.v());
        }
        bVar2.f1754r0.g1(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f1922f == -1 && !isInEditMode()) {
            setVisibility(this.f1924h);
        }
        View findViewById = constraintLayout.findViewById(this.f1922f);
        this.f1923g = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.b) findViewById.getLayoutParams()).f1730f0 = true;
            this.f1923g.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f1923g;
    }

    public int getEmptyVisibility() {
        return this.f1924h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i10) {
        View findViewById;
        if (this.f1922f == i10) {
            return;
        }
        View view = this.f1923g;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.b) this.f1923g.getLayoutParams()).f1730f0 = false;
            this.f1923g = null;
        }
        this.f1922f = i10;
        if (i10 == -1 || (findViewById = ((View) getParent()).findViewById(i10)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i10) {
        this.f1924h = i10;
    }
}
