package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.content.res.k;
import androidx.core.graphics.d;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class h extends androidx.vectordrawable.graphics.drawable.g {

    /* renamed from: o, reason: collision with root package name */
    static final PorterDuff.Mode f3767o = PorterDuff.Mode.SRC_IN;

    /* renamed from: g, reason: collision with root package name */
    private C0063h f3768g;

    /* renamed from: h, reason: collision with root package name */
    private PorterDuffColorFilter f3769h;

    /* renamed from: i, reason: collision with root package name */
    private ColorFilter f3770i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3771j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3772k;

    /* renamed from: l, reason: collision with root package name */
    private final float[] f3773l;

    /* renamed from: m, reason: collision with root package name */
    private final Matrix f3774m;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f3775n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends f {
        b() {
        }

        b(b bVar) {
            super(bVar);
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3802b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f3801a = androidx.core.graphics.d.d(string2);
            }
            this.f3803c = k.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (k.j(xmlPullParser, "pathData")) {
                TypedArray k10 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f3742d);
                f(k10, xmlPullParser);
                k10.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private int[] f3776e;

        /* renamed from: f, reason: collision with root package name */
        androidx.core.content.res.d f3777f;

        /* renamed from: g, reason: collision with root package name */
        float f3778g;

        /* renamed from: h, reason: collision with root package name */
        androidx.core.content.res.d f3779h;

        /* renamed from: i, reason: collision with root package name */
        float f3780i;

        /* renamed from: j, reason: collision with root package name */
        float f3781j;

        /* renamed from: k, reason: collision with root package name */
        float f3782k;

        /* renamed from: l, reason: collision with root package name */
        float f3783l;

        /* renamed from: m, reason: collision with root package name */
        float f3784m;

        /* renamed from: n, reason: collision with root package name */
        Paint.Cap f3785n;

        /* renamed from: o, reason: collision with root package name */
        Paint.Join f3786o;

        /* renamed from: p, reason: collision with root package name */
        float f3787p;

        c() {
            this.f3778g = 0.0f;
            this.f3780i = 1.0f;
            this.f3781j = 1.0f;
            this.f3782k = 0.0f;
            this.f3783l = 1.0f;
            this.f3784m = 0.0f;
            this.f3785n = Paint.Cap.BUTT;
            this.f3786o = Paint.Join.MITER;
            this.f3787p = 4.0f;
        }

        c(c cVar) {
            super(cVar);
            this.f3778g = 0.0f;
            this.f3780i = 1.0f;
            this.f3781j = 1.0f;
            this.f3782k = 0.0f;
            this.f3783l = 1.0f;
            this.f3784m = 0.0f;
            this.f3785n = Paint.Cap.BUTT;
            this.f3786o = Paint.Join.MITER;
            this.f3787p = 4.0f;
            this.f3776e = cVar.f3776e;
            this.f3777f = cVar.f3777f;
            this.f3778g = cVar.f3778g;
            this.f3780i = cVar.f3780i;
            this.f3779h = cVar.f3779h;
            this.f3803c = cVar.f3803c;
            this.f3781j = cVar.f3781j;
            this.f3782k = cVar.f3782k;
            this.f3783l = cVar.f3783l;
            this.f3784m = cVar.f3784m;
            this.f3785n = cVar.f3785n;
            this.f3786o = cVar.f3786o;
            this.f3787p = cVar.f3787p;
        }

        private Paint.Cap e(int i10, Paint.Cap cap) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i10, Paint.Join join) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f3776e = null;
            if (k.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f3802b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f3801a = androidx.core.graphics.d.d(string2);
                }
                this.f3779h = k.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f3781j = k.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f3781j);
                this.f3785n = e(k.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f3785n);
                this.f3786o = f(k.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f3786o);
                this.f3787p = k.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f3787p);
                this.f3777f = k.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f3780i = k.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f3780i);
                this.f3778g = k.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f3778g);
                this.f3783l = k.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f3783l);
                this.f3784m = k.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f3784m);
                this.f3782k = k.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f3782k);
                this.f3803c = k.g(typedArray, xmlPullParser, "fillType", 13, this.f3803c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean a() {
            return this.f3779h.i() || this.f3777f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean b(int[] iArr) {
            return this.f3777f.j(iArr) | this.f3779h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k10 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f3741c);
            h(k10, xmlPullParser, theme);
            k10.recycle();
        }

        float getFillAlpha() {
            return this.f3781j;
        }

        int getFillColor() {
            return this.f3779h.e();
        }

        float getStrokeAlpha() {
            return this.f3780i;
        }

        int getStrokeColor() {
            return this.f3777f.e();
        }

        float getStrokeWidth() {
            return this.f3778g;
        }

        float getTrimPathEnd() {
            return this.f3783l;
        }

        float getTrimPathOffset() {
            return this.f3784m;
        }

        float getTrimPathStart() {
            return this.f3782k;
        }

        void setFillAlpha(float f10) {
            this.f3781j = f10;
        }

        void setFillColor(int i10) {
            this.f3779h.k(i10);
        }

        void setStrokeAlpha(float f10) {
            this.f3780i = f10;
        }

        void setStrokeColor(int i10) {
            this.f3777f.k(i10);
        }

        void setStrokeWidth(float f10) {
            this.f3778g = f10;
        }

        void setTrimPathEnd(float f10) {
            this.f3783l = f10;
        }

        void setTrimPathOffset(float f10) {
            this.f3784m = f10;
        }

        void setTrimPathStart(float f10) {
            this.f3782k = f10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final Matrix f3788a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<e> f3789b;

        /* renamed from: c, reason: collision with root package name */
        float f3790c;

        /* renamed from: d, reason: collision with root package name */
        private float f3791d;

        /* renamed from: e, reason: collision with root package name */
        private float f3792e;

        /* renamed from: f, reason: collision with root package name */
        private float f3793f;

        /* renamed from: g, reason: collision with root package name */
        private float f3794g;

        /* renamed from: h, reason: collision with root package name */
        private float f3795h;

        /* renamed from: i, reason: collision with root package name */
        private float f3796i;

        /* renamed from: j, reason: collision with root package name */
        final Matrix f3797j;

        /* renamed from: k, reason: collision with root package name */
        int f3798k;

        /* renamed from: l, reason: collision with root package name */
        private int[] f3799l;

        /* renamed from: m, reason: collision with root package name */
        private String f3800m;

        public d() {
            super();
            this.f3788a = new Matrix();
            this.f3789b = new ArrayList<>();
            this.f3790c = 0.0f;
            this.f3791d = 0.0f;
            this.f3792e = 0.0f;
            this.f3793f = 1.0f;
            this.f3794g = 1.0f;
            this.f3795h = 0.0f;
            this.f3796i = 0.0f;
            this.f3797j = new Matrix();
            this.f3800m = null;
        }

        public d(d dVar, l.a<String, Object> aVar) {
            super();
            f bVar;
            this.f3788a = new Matrix();
            this.f3789b = new ArrayList<>();
            this.f3790c = 0.0f;
            this.f3791d = 0.0f;
            this.f3792e = 0.0f;
            this.f3793f = 1.0f;
            this.f3794g = 1.0f;
            this.f3795h = 0.0f;
            this.f3796i = 0.0f;
            Matrix matrix = new Matrix();
            this.f3797j = matrix;
            this.f3800m = null;
            this.f3790c = dVar.f3790c;
            this.f3791d = dVar.f3791d;
            this.f3792e = dVar.f3792e;
            this.f3793f = dVar.f3793f;
            this.f3794g = dVar.f3794g;
            this.f3795h = dVar.f3795h;
            this.f3796i = dVar.f3796i;
            this.f3799l = dVar.f3799l;
            String str = dVar.f3800m;
            this.f3800m = str;
            this.f3798k = dVar.f3798k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f3797j);
            ArrayList<e> arrayList = dVar.f3789b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                e eVar = arrayList.get(i10);
                if (eVar instanceof d) {
                    this.f3789b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f3789b.add(bVar);
                    String str2 = bVar.f3802b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f3797j.reset();
            this.f3797j.postTranslate(-this.f3791d, -this.f3792e);
            this.f3797j.postScale(this.f3793f, this.f3794g);
            this.f3797j.postRotate(this.f3790c, 0.0f, 0.0f);
            this.f3797j.postTranslate(this.f3795h + this.f3791d, this.f3796i + this.f3792e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f3799l = null;
            this.f3790c = k.f(typedArray, xmlPullParser, "rotation", 5, this.f3790c);
            this.f3791d = typedArray.getFloat(1, this.f3791d);
            this.f3792e = typedArray.getFloat(2, this.f3792e);
            this.f3793f = k.f(typedArray, xmlPullParser, "scaleX", 3, this.f3793f);
            this.f3794g = k.f(typedArray, xmlPullParser, "scaleY", 4, this.f3794g);
            this.f3795h = k.f(typedArray, xmlPullParser, "translateX", 6, this.f3795h);
            this.f3796i = k.f(typedArray, xmlPullParser, "translateY", 7, this.f3796i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3800m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean a() {
            for (int i10 = 0; i10 < this.f3789b.size(); i10++) {
                if (this.f3789b.get(i10).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean b(int[] iArr) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.f3789b.size(); i10++) {
                z10 |= this.f3789b.get(i10).b(iArr);
            }
            return z10;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k10 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f3740b);
            e(k10, xmlPullParser);
            k10.recycle();
        }

        public String getGroupName() {
            return this.f3800m;
        }

        public Matrix getLocalMatrix() {
            return this.f3797j;
        }

        public float getPivotX() {
            return this.f3791d;
        }

        public float getPivotY() {
            return this.f3792e;
        }

        public float getRotation() {
            return this.f3790c;
        }

        public float getScaleX() {
            return this.f3793f;
        }

        public float getScaleY() {
            return this.f3794g;
        }

        public float getTranslateX() {
            return this.f3795h;
        }

        public float getTranslateY() {
            return this.f3796i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f3791d) {
                this.f3791d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f3792e) {
                this.f3792e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f3790c) {
                this.f3790c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f3793f) {
                this.f3793f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f3794g) {
                this.f3794g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f3795h) {
                this.f3795h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f3796i) {
                this.f3796i = f10;
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class f extends e {

        /* renamed from: a, reason: collision with root package name */
        protected d.b[] f3801a;

        /* renamed from: b, reason: collision with root package name */
        String f3802b;

        /* renamed from: c, reason: collision with root package name */
        int f3803c;

        /* renamed from: d, reason: collision with root package name */
        int f3804d;

        public f() {
            super();
            this.f3801a = null;
            this.f3803c = 0;
        }

        public f(f fVar) {
            super();
            this.f3801a = null;
            this.f3803c = 0;
            this.f3802b = fVar.f3802b;
            this.f3804d = fVar.f3804d;
            this.f3801a = androidx.core.graphics.d.f(fVar.f3801a);
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            d.b[] bVarArr = this.f3801a;
            if (bVarArr != null) {
                d.b.e(bVarArr, path);
            }
        }

        public d.b[] getPathData() {
            return this.f3801a;
        }

        public String getPathName() {
            return this.f3802b;
        }

        public void setPathData(d.b[] bVarArr) {
            if (androidx.core.graphics.d.b(this.f3801a, bVarArr)) {
                androidx.core.graphics.d.j(this.f3801a, bVarArr);
            } else {
                this.f3801a = androidx.core.graphics.d.f(bVarArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: q, reason: collision with root package name */
        private static final Matrix f3805q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        private final Path f3806a;

        /* renamed from: b, reason: collision with root package name */
        private final Path f3807b;

        /* renamed from: c, reason: collision with root package name */
        private final Matrix f3808c;

        /* renamed from: d, reason: collision with root package name */
        Paint f3809d;

        /* renamed from: e, reason: collision with root package name */
        Paint f3810e;

        /* renamed from: f, reason: collision with root package name */
        private PathMeasure f3811f;

        /* renamed from: g, reason: collision with root package name */
        private int f3812g;

        /* renamed from: h, reason: collision with root package name */
        final d f3813h;

        /* renamed from: i, reason: collision with root package name */
        float f3814i;

        /* renamed from: j, reason: collision with root package name */
        float f3815j;

        /* renamed from: k, reason: collision with root package name */
        float f3816k;

        /* renamed from: l, reason: collision with root package name */
        float f3817l;

        /* renamed from: m, reason: collision with root package name */
        int f3818m;

        /* renamed from: n, reason: collision with root package name */
        String f3819n;

        /* renamed from: o, reason: collision with root package name */
        Boolean f3820o;

        /* renamed from: p, reason: collision with root package name */
        final l.a<String, Object> f3821p;

        public g() {
            this.f3808c = new Matrix();
            this.f3814i = 0.0f;
            this.f3815j = 0.0f;
            this.f3816k = 0.0f;
            this.f3817l = 0.0f;
            this.f3818m = 255;
            this.f3819n = null;
            this.f3820o = null;
            this.f3821p = new l.a<>();
            this.f3813h = new d();
            this.f3806a = new Path();
            this.f3807b = new Path();
        }

        public g(g gVar) {
            this.f3808c = new Matrix();
            this.f3814i = 0.0f;
            this.f3815j = 0.0f;
            this.f3816k = 0.0f;
            this.f3817l = 0.0f;
            this.f3818m = 255;
            this.f3819n = null;
            this.f3820o = null;
            l.a<String, Object> aVar = new l.a<>();
            this.f3821p = aVar;
            this.f3813h = new d(gVar.f3813h, aVar);
            this.f3806a = new Path(gVar.f3806a);
            this.f3807b = new Path(gVar.f3807b);
            this.f3814i = gVar.f3814i;
            this.f3815j = gVar.f3815j;
            this.f3816k = gVar.f3816k;
            this.f3817l = gVar.f3817l;
            this.f3812g = gVar.f3812g;
            this.f3818m = gVar.f3818m;
            this.f3819n = gVar.f3819n;
            String str = gVar.f3819n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f3820o = gVar.f3820o;
        }

        private static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f3788a.set(matrix);
            dVar.f3788a.preConcat(dVar.f3797j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f3789b.size(); i12++) {
                e eVar = dVar.f3789b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f3788a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            float f10 = i10 / this.f3816k;
            float f11 = i11 / this.f3817l;
            float min = Math.min(f10, f11);
            Matrix matrix = dVar.f3788a;
            this.f3808c.set(matrix);
            this.f3808c.postScale(f10, f11);
            float e10 = e(matrix);
            if (e10 == 0.0f) {
                return;
            }
            fVar.d(this.f3806a);
            Path path = this.f3806a;
            this.f3807b.reset();
            if (fVar.c()) {
                this.f3807b.setFillType(fVar.f3803c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f3807b.addPath(path, this.f3808c);
                canvas.clipPath(this.f3807b);
                return;
            }
            c cVar = (c) fVar;
            float f12 = cVar.f3782k;
            if (f12 != 0.0f || cVar.f3783l != 1.0f) {
                float f13 = cVar.f3784m;
                float f14 = (f12 + f13) % 1.0f;
                float f15 = (cVar.f3783l + f13) % 1.0f;
                if (this.f3811f == null) {
                    this.f3811f = new PathMeasure();
                }
                this.f3811f.setPath(this.f3806a, false);
                float length = this.f3811f.getLength();
                float f16 = f14 * length;
                float f17 = f15 * length;
                path.reset();
                if (f16 > f17) {
                    this.f3811f.getSegment(f16, length, path, true);
                    this.f3811f.getSegment(0.0f, f17, path, true);
                } else {
                    this.f3811f.getSegment(f16, f17, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f3807b.addPath(path, this.f3808c);
            if (cVar.f3779h.l()) {
                androidx.core.content.res.d dVar2 = cVar.f3779h;
                if (this.f3810e == null) {
                    Paint paint = new Paint(1);
                    this.f3810e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f3810e;
                if (dVar2.h()) {
                    Shader f18 = dVar2.f();
                    f18.setLocalMatrix(this.f3808c);
                    paint2.setShader(f18);
                    paint2.setAlpha(Math.round(cVar.f3781j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(h.a(dVar2.e(), cVar.f3781j));
                }
                paint2.setColorFilter(colorFilter);
                this.f3807b.setFillType(cVar.f3803c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f3807b, paint2);
            }
            if (cVar.f3777f.l()) {
                androidx.core.content.res.d dVar3 = cVar.f3777f;
                if (this.f3809d == null) {
                    Paint paint3 = new Paint(1);
                    this.f3809d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f3809d;
                Paint.Join join = cVar.f3786o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f3785n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f3787p);
                if (dVar3.h()) {
                    Shader f19 = dVar3.f();
                    f19.setLocalMatrix(this.f3808c);
                    paint4.setShader(f19);
                    paint4.setAlpha(Math.round(cVar.f3780i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(h.a(dVar3.e(), cVar.f3780i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f3778g * min * e10);
                canvas.drawPath(this.f3807b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a10 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(a10) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f3813h, f3805q, canvas, i10, i11, colorFilter);
        }

        public boolean f() {
            if (this.f3820o == null) {
                this.f3820o = Boolean.valueOf(this.f3813h.a());
            }
            return this.f3820o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f3813h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f3818m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f3818m = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.vectordrawable.graphics.drawable.h$h, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0063h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f3822a;

        /* renamed from: b, reason: collision with root package name */
        g f3823b;

        /* renamed from: c, reason: collision with root package name */
        ColorStateList f3824c;

        /* renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f3825d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3826e;

        /* renamed from: f, reason: collision with root package name */
        Bitmap f3827f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f3828g;

        /* renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f3829h;

        /* renamed from: i, reason: collision with root package name */
        int f3830i;

        /* renamed from: j, reason: collision with root package name */
        boolean f3831j;

        /* renamed from: k, reason: collision with root package name */
        boolean f3832k;

        /* renamed from: l, reason: collision with root package name */
        Paint f3833l;

        public C0063h() {
            this.f3824c = null;
            this.f3825d = h.f3767o;
            this.f3823b = new g();
        }

        public C0063h(C0063h c0063h) {
            this.f3824c = null;
            this.f3825d = h.f3767o;
            if (c0063h != null) {
                this.f3822a = c0063h.f3822a;
                g gVar = new g(c0063h.f3823b);
                this.f3823b = gVar;
                if (c0063h.f3823b.f3810e != null) {
                    gVar.f3810e = new Paint(c0063h.f3823b.f3810e);
                }
                if (c0063h.f3823b.f3809d != null) {
                    this.f3823b.f3809d = new Paint(c0063h.f3823b.f3809d);
                }
                this.f3824c = c0063h.f3824c;
                this.f3825d = c0063h.f3825d;
                this.f3826e = c0063h.f3826e;
            }
        }

        public boolean a(int i10, int i11) {
            return i10 == this.f3827f.getWidth() && i11 == this.f3827f.getHeight();
        }

        public boolean b() {
            return !this.f3832k && this.f3828g == this.f3824c && this.f3829h == this.f3825d && this.f3831j == this.f3826e && this.f3830i == this.f3823b.getRootAlpha();
        }

        public void c(int i10, int i11) {
            if (this.f3827f == null || !a(i10, i11)) {
                this.f3827f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f3832k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f3827f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f3833l == null) {
                Paint paint = new Paint();
                this.f3833l = paint;
                paint.setFilterBitmap(true);
            }
            this.f3833l.setAlpha(this.f3823b.getRootAlpha());
            this.f3833l.setColorFilter(colorFilter);
            return this.f3833l;
        }

        public boolean f() {
            return this.f3823b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f3823b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3822a;
        }

        public boolean h(int[] iArr) {
            boolean g10 = this.f3823b.g(iArr);
            this.f3832k |= g10;
            return g10;
        }

        public void i() {
            this.f3828g = this.f3824c;
            this.f3829h = this.f3825d;
            this.f3830i = this.f3823b.getRootAlpha();
            this.f3831j = this.f3826e;
            this.f3832k = false;
        }

        public void j(int i10, int i11) {
            this.f3827f.eraseColor(0);
            this.f3823b.b(new Canvas(this.f3827f), i10, i11, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new h(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new h(this);
        }
    }

    /* loaded from: classes.dex */
    private static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f3834a;

        public i(Drawable.ConstantState constantState) {
            this.f3834a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f3834a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3834a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVar = new h();
            hVar.f3766f = (VectorDrawable) this.f3834a.newDrawable();
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            h hVar = new h();
            hVar.f3766f = (VectorDrawable) this.f3834a.newDrawable(resources);
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            h hVar = new h();
            hVar.f3766f = (VectorDrawable) this.f3834a.newDrawable(resources, theme);
            return hVar;
        }
    }

    h() {
        this.f3772k = true;
        this.f3773l = new float[9];
        this.f3774m = new Matrix();
        this.f3775n = new Rect();
        this.f3768g = new C0063h();
    }

    h(C0063h c0063h) {
        this.f3772k = true;
        this.f3773l = new float[9];
        this.f3774m = new Matrix();
        this.f3775n = new Rect();
        this.f3768g = c0063h;
        this.f3769h = j(this.f3769h, c0063h.f3824c, c0063h.f3825d);
    }

    static int a(int i10, float f10) {
        return (i10 & 16777215) | (((int) (Color.alpha(i10) * f10)) << 24);
    }

    public static h b(Resources resources, int i10, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            h hVar = new h();
            hVar.f3766f = androidx.core.content.res.h.d(resources, i10, theme);
            new i(hVar.f3766f.getConstantState());
            return hVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i10);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
    }

    public static h c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = new h();
        hVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i10;
        int i11;
        b bVar;
        C0063h c0063h = this.f3768g;
        g gVar = c0063h.f3823b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f3813h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3789b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f3821p.put(cVar.getPathName(), cVar);
                    }
                    z10 = false;
                    bVar = cVar;
                } else if ("clip-path".equals(name)) {
                    b bVar2 = new b();
                    bVar2.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3789b.add(bVar2);
                    String pathName = bVar2.getPathName();
                    bVar = bVar2;
                    if (pathName != null) {
                        gVar.f3821p.put(bVar2.getPathName(), bVar2);
                        bVar = bVar2;
                    }
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3789b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f3821p.put(dVar2.getGroupName(), dVar2);
                    }
                    i10 = c0063h.f3822a;
                    i11 = dVar2.f3798k;
                    c0063h.f3822a = i11 | i10;
                }
                i10 = c0063h.f3822a;
                i11 = bVar.f3804d;
                c0063h.f3822a = i11 | i10;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z10) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        C0063h c0063h = this.f3768g;
        g gVar = c0063h.f3823b;
        c0063h.f3825d = g(k.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c10 = k.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c10 != null) {
            c0063h.f3824c = c10;
        }
        c0063h.f3826e = k.a(typedArray, xmlPullParser, "autoMirrored", 5, c0063h.f3826e);
        gVar.f3816k = k.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f3816k);
        float f10 = k.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f3817l);
        gVar.f3817l = f10;
        if (gVar.f3816k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f10 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f3814i = typedArray.getDimension(3, gVar.f3814i);
        float dimension = typedArray.getDimension(2, gVar.f3815j);
        gVar.f3815j = dimension;
        if (gVar.f3814i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(k.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f3819n = string;
            gVar.f3821p.put(string, gVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f3766f;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f3768g.f3823b.f3821p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f3775n);
        if (this.f3775n.width() <= 0 || this.f3775n.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f3770i;
        if (colorFilter == null) {
            colorFilter = this.f3769h;
        }
        canvas.getMatrix(this.f3774m);
        this.f3774m.getValues(this.f3773l);
        float abs = Math.abs(this.f3773l[0]);
        float abs2 = Math.abs(this.f3773l[4]);
        float abs3 = Math.abs(this.f3773l[1]);
        float abs4 = Math.abs(this.f3773l[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.f3775n.width() * abs));
        int min2 = Math.min(2048, (int) (this.f3775n.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.f3775n;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f3775n.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f3775n.offsetTo(0, 0);
        this.f3768g.c(min, min2);
        if (!this.f3772k) {
            this.f3768g.j(min, min2);
        } else if (!this.f3768g.b()) {
            this.f3768g.j(min, min2);
            this.f3768g.i();
        }
        this.f3768g.d(canvas, colorFilter, this.f3775n);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f3766f;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f3768g.f3823b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f3768g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f3766f;
        return drawable != null ? androidx.core.graphics.drawable.a.e(drawable) : this.f3770i;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f3766f != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f3766f.getConstantState());
        }
        this.f3768g.f3822a = getChangingConfigurations();
        return this.f3768g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f3768g.f3823b.f3815j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f3768g.f3823b.f3814i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z10) {
        this.f3772k = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0063h c0063h = this.f3768g;
        c0063h.f3823b = new g();
        TypedArray k10 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f3739a);
        i(k10, xmlPullParser, theme);
        k10.recycle();
        c0063h.f3822a = getChangingConfigurations();
        c0063h.f3832k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f3769h = j(this.f3769h, c0063h.f3824c, c0063h.f3825d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f3766f;
        return drawable != null ? androidx.core.graphics.drawable.a.h(drawable) : this.f3768g.f3826e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0063h c0063h;
        ColorStateList colorStateList;
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((c0063h = this.f3768g) != null && (c0063h.g() || ((colorStateList = this.f3768g.f3824c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f3771j && super.mutate() == this) {
            this.f3768g = new C0063h(this.f3768g);
            this.f3771j = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z10 = false;
        C0063h c0063h = this.f3768g;
        ColorStateList colorStateList = c0063h.f3824c;
        if (colorStateList != null && (mode = c0063h.f3825d) != null) {
            this.f3769h = j(this.f3769h, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!c0063h.g() || !c0063h.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f3768g.f3823b.getRootAlpha() != i10) {
            this.f3768g.f3823b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z10);
        } else {
            this.f3768g.f3826e = z10;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3770i = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i10) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        C0063h c0063h = this.f3768g;
        if (c0063h.f3824c != colorStateList) {
            c0063h.f3824c = colorStateList;
            this.f3769h = j(this.f3769h, colorStateList, c0063h.f3825d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
            return;
        }
        C0063h c0063h = this.f3768g;
        if (c0063h.f3825d != mode) {
            c0063h.f3825d = mode;
            this.f3769h = j(this.f3769h, c0063h.f3824c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
