package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.h;

/* loaded from: classes.dex */
public class y0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1568a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f1569b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f1570c;

    private y0(Context context, TypedArray typedArray) {
        this.f1568a = context;
        this.f1569b = typedArray;
    }

    public static y0 t(Context context, int i10, int[] iArr) {
        return new y0(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static y0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new y0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static y0 v(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new y0(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean a(int i10, boolean z10) {
        return this.f1569b.getBoolean(i10, z10);
    }

    public int b(int i10, int i11) {
        return this.f1569b.getColor(i10, i11);
    }

    public ColorStateList c(int i10) {
        int resourceId;
        ColorStateList a10;
        return (!this.f1569b.hasValue(i10) || (resourceId = this.f1569b.getResourceId(i10, 0)) == 0 || (a10 = f.a.a(this.f1568a, resourceId)) == null) ? this.f1569b.getColorStateList(i10) : a10;
    }

    public float d(int i10, float f10) {
        return this.f1569b.getDimension(i10, f10);
    }

    public int e(int i10, int i11) {
        return this.f1569b.getDimensionPixelOffset(i10, i11);
    }

    public int f(int i10, int i11) {
        return this.f1569b.getDimensionPixelSize(i10, i11);
    }

    public Drawable g(int i10) {
        int resourceId;
        return (!this.f1569b.hasValue(i10) || (resourceId = this.f1569b.getResourceId(i10, 0)) == 0) ? this.f1569b.getDrawable(i10) : f.a.b(this.f1568a, resourceId);
    }

    public Drawable h(int i10) {
        int resourceId;
        if (!this.f1569b.hasValue(i10) || (resourceId = this.f1569b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return k.b().d(this.f1568a, resourceId, true);
    }

    public float i(int i10, float f10) {
        return this.f1569b.getFloat(i10, f10);
    }

    public Typeface j(int i10, int i11, h.f fVar) {
        int resourceId = this.f1569b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1570c == null) {
            this.f1570c = new TypedValue();
        }
        return androidx.core.content.res.h.f(this.f1568a, resourceId, this.f1570c, i11, fVar);
    }

    public int k(int i10, int i11) {
        return this.f1569b.getInt(i10, i11);
    }

    public int l(int i10, int i11) {
        return this.f1569b.getInteger(i10, i11);
    }

    public int m(int i10, int i11) {
        return this.f1569b.getLayoutDimension(i10, i11);
    }

    public int n(int i10, int i11) {
        return this.f1569b.getResourceId(i10, i11);
    }

    public String o(int i10) {
        return this.f1569b.getString(i10);
    }

    public CharSequence p(int i10) {
        return this.f1569b.getText(i10);
    }

    public CharSequence[] q(int i10) {
        return this.f1569b.getTextArray(i10);
    }

    public TypedArray r() {
        return this.f1569b;
    }

    public boolean s(int i10) {
        return this.f1569b.hasValue(i10);
    }

    public void w() {
        this.f1569b.recycle();
    }
}
