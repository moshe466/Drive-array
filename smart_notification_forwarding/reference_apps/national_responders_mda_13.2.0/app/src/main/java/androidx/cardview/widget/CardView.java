package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f1574m = {R.attr.colorBackground};

    /* renamed from: n, reason: collision with root package name */
    private static final e f1575n;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1576f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1577g;

    /* renamed from: h, reason: collision with root package name */
    int f1578h;

    /* renamed from: i, reason: collision with root package name */
    int f1579i;

    /* renamed from: j, reason: collision with root package name */
    final Rect f1580j;

    /* renamed from: k, reason: collision with root package name */
    final Rect f1581k;

    /* renamed from: l, reason: collision with root package name */
    private final d f1582l;

    /* loaded from: classes.dex */
    class a implements d {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f1583a;

        a() {
        }

        @Override // androidx.cardview.widget.d
        public void a(int i10, int i11, int i12, int i13) {
            CardView.this.f1581k.set(i10, i11, i12, i13);
            CardView cardView = CardView.this;
            Rect rect = cardView.f1580j;
            CardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }

        @Override // androidx.cardview.widget.d
        public View b() {
            return CardView.this;
        }

        @Override // androidx.cardview.widget.d
        public void c(int i10, int i11) {
            CardView cardView = CardView.this;
            if (i10 > cardView.f1578h) {
                CardView.super.setMinimumWidth(i10);
            }
            CardView cardView2 = CardView.this;
            if (i11 > cardView2.f1579i) {
                CardView.super.setMinimumHeight(i11);
            }
        }

        @Override // androidx.cardview.widget.d
        public void d(Drawable drawable) {
            this.f1583a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean e() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.d
        public boolean f() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public Drawable g() {
            return this.f1583a;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f1575n = i10 >= 21 ? new b() : i10 >= 17 ? new androidx.cardview.widget.a() : new c();
        f1575n.f();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a.f11100a);
    }

    public CardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources;
        int i11;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f1580j = rect;
        this.f1581k = new Rect();
        a aVar = new a();
        this.f1582l = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.e.f11107a, i10, k.d.f11106a);
        int i12 = k.e.f11110d;
        if (obtainStyledAttributes.hasValue(i12)) {
            valueOf = obtainStyledAttributes.getColorStateList(i12);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1574m);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i11 = k.b.f11102b;
            } else {
                resources = getResources();
                i11 = k.b.f11101a;
            }
            valueOf = ColorStateList.valueOf(resources.getColor(i11));
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(k.e.f11111e, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(k.e.f11112f, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(k.e.f11113g, 0.0f);
        this.f1576f = obtainStyledAttributes.getBoolean(k.e.f11115i, false);
        this.f1577g = obtainStyledAttributes.getBoolean(k.e.f11114h, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(k.e.f11116j, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(k.e.f11118l, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(k.e.f11120n, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(k.e.f11119m, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(k.e.f11117k, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1578h = obtainStyledAttributes.getDimensionPixelSize(k.e.f11108b, 0);
        this.f1579i = obtainStyledAttributes.getDimensionPixelSize(k.e.f11109c, 0);
        obtainStyledAttributes.recycle();
        f1575n.c(aVar, context, colorStateList, dimension, dimension2, f10);
    }

    public ColorStateList getCardBackgroundColor() {
        return f1575n.b(this.f1582l);
    }

    public float getCardElevation() {
        return f1575n.e(this.f1582l);
    }

    public int getContentPaddingBottom() {
        return this.f1580j.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1580j.left;
    }

    public int getContentPaddingRight() {
        return this.f1580j.right;
    }

    public int getContentPaddingTop() {
        return this.f1580j.top;
    }

    public float getMaxCardElevation() {
        return f1575n.a(this.f1582l);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1577g;
    }

    public float getRadius() {
        return f1575n.g(this.f1582l);
    }

    public boolean getUseCompatPadding() {
        return this.f1576f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        if (!(f1575n instanceof b)) {
            int mode = View.MeasureSpec.getMode(i10);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.i(this.f1582l)), View.MeasureSpec.getSize(i10)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.h(this.f1582l)), View.MeasureSpec.getSize(i11)), mode2);
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        f1575n.m(this.f1582l, ColorStateList.valueOf(i10));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1575n.m(this.f1582l, colorStateList);
    }

    public void setCardElevation(float f10) {
        f1575n.k(this.f1582l, f10);
    }

    public void setMaxCardElevation(float f10) {
        f1575n.n(this.f1582l, f10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        this.f1579i = i10;
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        this.f1578h = i10;
        super.setMinimumWidth(i10);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f1577g) {
            this.f1577g = z10;
            f1575n.l(this.f1582l);
        }
    }

    public void setRadius(float f10) {
        f1575n.d(this.f1582l, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f1576f != z10) {
            this.f1576f = z10;
            f1575n.j(this.f1582l);
        }
    }
}
