package com.groboot.mdaemergency.ui.lockpattern.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import il.org.mda.health.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import t6.f;
import w6.m;

/* loaded from: classes.dex */
public class LockPatternView extends View {
    private Bitmap A;
    private Bitmap B;
    private Bitmap C;
    private final Path D;
    private final Rect E;
    private final Rect F;
    private int G;
    private int H;
    private int I;
    private final Matrix J;
    private final Matrix K;

    /* renamed from: f, reason: collision with root package name */
    private Paint f8198f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f8199g;

    /* renamed from: h, reason: collision with root package name */
    private d f8200h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<b> f8201i;

    /* renamed from: j, reason: collision with root package name */
    private boolean[][] f8202j;

    /* renamed from: k, reason: collision with root package name */
    private float f8203k;

    /* renamed from: l, reason: collision with root package name */
    private float f8204l;

    /* renamed from: m, reason: collision with root package name */
    private long f8205m;

    /* renamed from: n, reason: collision with root package name */
    private c f8206n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f8207o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8208p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8209q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f8210r;

    /* renamed from: s, reason: collision with root package name */
    private float f8211s;

    /* renamed from: t, reason: collision with root package name */
    private float f8212t;

    /* renamed from: u, reason: collision with root package name */
    private float f8213u;

    /* renamed from: v, reason: collision with root package name */
    private float f8214v;

    /* renamed from: w, reason: collision with root package name */
    private Bitmap f8215w;

    /* renamed from: x, reason: collision with root package name */
    private Bitmap f8216x;

    /* renamed from: y, reason: collision with root package name */
    private Bitmap f8217y;

    /* renamed from: z, reason: collision with root package name */
    private Bitmap f8218z;

    /* loaded from: classes.dex */
    public static class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR;

        /* renamed from: h, reason: collision with root package name */
        static b[][] f8219h = (b[][]) Array.newInstance((Class<?>) b.class, 3, 3);

        /* renamed from: f, reason: collision with root package name */
        int f8220f;

        /* renamed from: g, reason: collision with root package name */
        int f8221g;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i10) {
                return new b[i10];
            }
        }

        static {
            for (int i10 = 0; i10 < 3; i10++) {
                for (int i11 = 0; i11 < 3; i11++) {
                    f8219h[i10][i11] = new b(i10, i11);
                }
            }
            CREATOR = new a();
        }

        private b(int i10, int i11) {
            a(i10, i11);
            this.f8220f = i10;
            this.f8221g = i11;
        }

        private b(Parcel parcel) {
            e(parcel);
        }

        private static void a(int i10, int i11) {
            if (i10 < 0 || i10 > 2) {
                throw new IllegalArgumentException("row must be in range 0-2");
            }
            if (i11 < 0 || i11 > 2) {
                throw new IllegalArgumentException("column must be in range 0-2");
            }
        }

        public static synchronized b d(int i10, int i11) {
            b bVar;
            synchronized (b.class) {
                a(i10, i11);
                bVar = f8219h[i10][i11];
            }
            return bVar;
        }

        public int b() {
            return this.f8221g;
        }

        public int c() {
            return this.f8220f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void e(Parcel parcel) {
            this.f8221g = parcel.readInt();
            this.f8220f = parcel.readInt();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return super.equals(obj);
            }
            b bVar = (b) obj;
            return b() == bVar.b() && c() == bVar.c();
        }

        public String toString() {
            return "(ROW=" + c() + ",COL=" + b() + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(b());
            parcel.writeInt(c());
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        Correct,
        Animate,
        Wrong
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b(List<b> list);

        void c(List<b> list);

        void d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        private final String f8222f;

        /* renamed from: g, reason: collision with root package name */
        private final int f8223g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f8224h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f8225i;

        /* renamed from: j, reason: collision with root package name */
        private final boolean f8226j;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i10) {
                return new e[i10];
            }
        }

        private e(Parcel parcel) {
            super(parcel);
            this.f8222f = parcel.readString();
            this.f8223g = parcel.readInt();
            this.f8224h = ((Boolean) parcel.readValue(null)).booleanValue();
            this.f8225i = ((Boolean) parcel.readValue(null)).booleanValue();
            this.f8226j = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        private e(Parcelable parcelable, String str, int i10, boolean z10, boolean z11, boolean z12) {
            super(parcelable);
            this.f8222f = str;
            this.f8223g = i10;
            this.f8224h = z10;
            this.f8225i = z11;
            this.f8226j = z12;
        }

        public int a() {
            return this.f8223g;
        }

        public String b() {
            return this.f8222f;
        }

        public boolean c() {
            return this.f8225i;
        }

        public boolean d() {
            return this.f8224h;
        }

        public boolean e() {
            return this.f8226j;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f8222f);
            parcel.writeInt(this.f8223g);
            parcel.writeValue(Boolean.valueOf(this.f8224h));
            parcel.writeValue(Boolean.valueOf(this.f8225i));
            parcel.writeValue(Boolean.valueOf(this.f8226j));
        }
    }

    public LockPatternView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8198f = new Paint();
        this.f8199g = new Paint();
        this.f8201i = new ArrayList<>(9);
        this.f8202j = (boolean[][]) Array.newInstance((Class<?>) boolean.class, 3, 3);
        this.f8203k = -1.0f;
        this.f8204l = -1.0f;
        this.f8206n = c.Correct;
        this.f8207o = true;
        this.f8208p = false;
        this.f8209q = true;
        this.f8210r = false;
        this.f8211s = 0.1f;
        this.f8212t = 0.6f;
        this.D = new Path();
        this.E = new Rect();
        this.F = new Rect();
        this.J = new Matrix();
        this.K = new Matrix();
        this.I = 0;
        setClickable(true);
        this.f8199g.setAntiAlias(true);
        this.f8199g.setDither(true);
        this.f8199g.setColor(getContext().getResources().getColor(f.b(getContext(), R.attr.color_pattern_path)));
        this.f8199g.setAlpha(128);
        this.f8199g.setStyle(Paint.Style.STROKE);
        this.f8199g.setStrokeJoin(Paint.Join.ROUND);
        this.f8199g.setStrokeCap(Paint.Cap.ROUND);
        this.f8215w = g(f.b(getContext(), R.attr.drawable_btn_code_lock_default_holo));
        this.f8216x = g(f.b(getContext(), R.attr.drawable_btn_code_lock_touched_holo));
        this.f8217y = g(f.b(getContext(), R.attr.drawable_indicator_code_lock_point_area_default_holo));
        this.f8218z = g(f.b(getContext(), R.attr.aosp_drawable_indicator_code_lock_point_area_normal));
        this.A = g(R.drawable.aosp_indicator_code_lock_point_area_red_holo);
        this.B = g(R.drawable.aosp_indicator_code_lock_drag_direction_green_up);
        this.C = g(R.drawable.aosp_indicator_code_lock_drag_direction_red_up);
        Bitmap[] bitmapArr = {this.f8215w, this.f8216x, this.f8217y, this.f8218z, this.A};
        for (int i10 = 0; i10 < 5; i10++) {
            Bitmap bitmap = bitmapArr[i10];
            this.G = Math.max(this.G, bitmap.getWidth());
            this.H = Math.max(this.H, bitmap.getHeight());
        }
    }

    private void a(b bVar) {
        this.f8202j[bVar.c()][bVar.b()] = true;
        this.f8201i.add(bVar);
        o();
    }

    private b b(float f10, float f11) {
        int j10;
        int k10 = k(f11);
        if (k10 >= 0 && (j10 = j(f10)) >= 0 && !this.f8202j[k10][j10]) {
            return b.d(k10, j10);
        }
        return null;
    }

    private void c() {
        for (int i10 = 0; i10 < 3; i10++) {
            for (int i11 = 0; i11 < 3; i11++) {
                this.f8202j[i10][i11] = false;
            }
        }
    }

    private b d(float f10, float f11) {
        b b10 = b(f10, f11);
        b bVar = null;
        if (b10 == null) {
            return null;
        }
        ArrayList<b> arrayList = this.f8201i;
        if (!arrayList.isEmpty()) {
            b bVar2 = arrayList.get(arrayList.size() - 1);
            int i10 = b10.f8220f;
            int i11 = bVar2.f8220f;
            int i12 = i10 - i11;
            int i13 = b10.f8221g;
            int i14 = bVar2.f8221g;
            int i15 = i13 - i14;
            if (Math.abs(i12) == 2 && Math.abs(i15) != 1) {
                i11 = bVar2.f8220f + (i12 > 0 ? 1 : -1);
            }
            if (Math.abs(i15) == 2 && Math.abs(i12) != 1) {
                i14 = bVar2.f8221g + (i15 > 0 ? 1 : -1);
            }
            bVar = b.d(i11, i14);
        }
        if (bVar != null && !this.f8202j[bVar.f8220f][bVar.f8221g]) {
            a(bVar);
        }
        a(b10);
        if (this.f8209q) {
            performHapticFeedback(1, 3);
        }
        return b10;
    }

    private void e(Canvas canvas, float f10, float f11, b bVar, b bVar2) {
        boolean z10 = this.f8206n != c.Wrong;
        int i10 = bVar2.f8220f;
        int i11 = bVar.f8220f;
        int i12 = bVar2.f8221g;
        int i13 = bVar.f8221g;
        int i14 = (int) this.f8213u;
        int i15 = this.G;
        int i16 = (i14 - i15) / 2;
        int i17 = (int) this.f8214v;
        int i18 = this.H;
        int i19 = (i17 - i18) / 2;
        Bitmap bitmap = z10 ? this.B : this.C;
        float degrees = ((float) Math.toDegrees((float) Math.atan2(i10 - i11, i12 - i13))) + 90.0f;
        float min = Math.min(this.f8213u / this.G, 1.0f);
        float min2 = Math.min(this.f8214v / this.H, 1.0f);
        this.J.setTranslate(f10 + i16, f11 + i19);
        this.J.preTranslate(this.G / 2, this.H / 2);
        this.J.preScale(min, min2);
        this.J.preTranslate((-this.G) / 2, (-this.H) / 2);
        this.J.preRotate(degrees, i15 / 2.0f, i18 / 2.0f);
        this.J.preTranslate((i15 - bitmap.getWidth()) / 2.0f, 0.0f);
        this.f8198f.setColorFilter(new LightingColorFilter(m.m().getColors().b(), 0));
        canvas.drawBitmap(bitmap, this.J, this.f8198f);
    }

    private void f(Canvas canvas, int i10, int i11, boolean z10) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (!z10 || (this.f8208p && this.f8206n != c.Wrong)) {
            bitmap = this.f8217y;
        } else {
            if (this.f8210r) {
                bitmap = this.f8218z;
                bitmap2 = this.f8216x;
                int i12 = this.G;
                int i13 = this.H;
                float f10 = this.f8213u;
                int i14 = (int) ((f10 - i12) / 2.0f);
                int i15 = (int) ((this.f8214v - i13) / 2.0f);
                float min = Math.min(f10 / i12, 1.0f);
                float min2 = Math.min(this.f8214v / this.H, 1.0f);
                this.K.setTranslate(i10 + i14, i11 + i15);
                this.K.preTranslate(this.G / 2, this.H / 2);
                this.K.preScale(min, min2);
                this.K.preTranslate((-this.G) / 2, (-this.H) / 2);
                this.f8198f.setColorFilter(new PorterDuffColorFilter(androidx.core.content.a.d(getContext(), m.p().b()), PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, this.K, this.f8198f);
                canvas.drawBitmap(bitmap2, this.K, this.f8198f);
            }
            c cVar = this.f8206n;
            if (cVar == c.Wrong) {
                bitmap = this.A;
            } else {
                if (cVar != c.Correct && cVar != c.Animate) {
                    throw new IllegalStateException("unknown display mode " + this.f8206n);
                }
                bitmap = this.f8218z;
            }
        }
        bitmap2 = this.f8215w;
        int i122 = this.G;
        int i132 = this.H;
        float f102 = this.f8213u;
        int i142 = (int) ((f102 - i122) / 2.0f);
        int i152 = (int) ((this.f8214v - i132) / 2.0f);
        float min3 = Math.min(f102 / i122, 1.0f);
        float min22 = Math.min(this.f8214v / this.H, 1.0f);
        this.K.setTranslate(i10 + i142, i11 + i152);
        this.K.preTranslate(this.G / 2, this.H / 2);
        this.K.preScale(min3, min22);
        this.K.preTranslate((-this.G) / 2, (-this.H) / 2);
        this.f8198f.setColorFilter(new PorterDuffColorFilter(androidx.core.content.a.d(getContext(), m.p().b()), PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, this.K, this.f8198f);
        canvas.drawBitmap(bitmap2, this.K, this.f8198f);
    }

    private Bitmap g(int i10) {
        return BitmapFactory.decodeResource(getContext().getResources(), i10);
    }

    private float h(int i10) {
        float f10 = this.f8213u;
        return (i10 * f10) + 0.0f + (f10 / 2.0f);
    }

    private float i(int i10) {
        float f10 = this.f8214v;
        return (i10 * f10) + 0.0f + (f10 / 2.0f);
    }

    private int j(float f10) {
        float f11 = this.f8213u;
        float f12 = this.f8212t * f11;
        float f13 = ((f11 - f12) / 2.0f) + 0.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            float f14 = (i10 * f11) + f13;
            if (f10 >= f14 && f10 <= f14 + f12) {
                return i10;
            }
        }
        return -1;
    }

    private int k(float f10) {
        float f11 = this.f8214v;
        float f12 = this.f8212t * f11;
        float f13 = ((f11 - f12) / 2.0f) + 0.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            float f14 = (i10 * f11) + f13;
            if (f10 >= f14 && f10 <= f14 + f12) {
                return i10;
            }
        }
        return -1;
    }

    private void l(MotionEvent motionEvent) {
        s();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        b d10 = d(x10, y10);
        if (d10 != null) {
            this.f8210r = true;
            this.f8206n = c.Correct;
            r();
        } else {
            this.f8210r = false;
            p();
        }
        if (d10 != null) {
            float h10 = h(d10.f8221g);
            float i10 = i(d10.f8220f);
            float f10 = this.f8213u / 2.0f;
            float f11 = this.f8214v / 2.0f;
            invalidate((int) (h10 - f10), (int) (i10 - f11), (int) (h10 + f10), (int) (i10 + f11));
        }
        this.f8203k = x10;
        this.f8204l = y10;
    }

    private void m(MotionEvent motionEvent) {
        float f10 = this.f8213u * this.f8211s * 0.5f;
        int historySize = motionEvent.getHistorySize();
        this.F.setEmpty();
        int i10 = 0;
        boolean z10 = false;
        while (i10 < historySize + 1) {
            float historicalX = i10 < historySize ? motionEvent.getHistoricalX(i10) : motionEvent.getX();
            float historicalY = i10 < historySize ? motionEvent.getHistoricalY(i10) : motionEvent.getY();
            b d10 = d(historicalX, historicalY);
            int size = this.f8201i.size();
            if (d10 != null && size == 1) {
                this.f8210r = true;
                r();
            }
            float abs = Math.abs(historicalX - this.f8203k);
            float abs2 = Math.abs(historicalY - this.f8204l);
            if (abs > 0.0f || abs2 > 0.0f) {
                z10 = true;
            }
            if (this.f8210r && size > 0) {
                b bVar = this.f8201i.get(size - 1);
                float h10 = h(bVar.f8221g);
                float i11 = i(bVar.f8220f);
                float min = Math.min(h10, historicalX) - f10;
                float max = Math.max(h10, historicalX) + f10;
                float min2 = Math.min(i11, historicalY) - f10;
                float max2 = Math.max(i11, historicalY) + f10;
                if (d10 != null) {
                    float f11 = this.f8213u * 0.5f;
                    float f12 = this.f8214v * 0.5f;
                    float h11 = h(d10.f8221g);
                    float i12 = i(d10.f8220f);
                    min = Math.min(h11 - f11, min);
                    max = Math.max(h11 + f11, max);
                    min2 = Math.min(i12 - f12, min2);
                    max2 = Math.max(i12 + f12, max2);
                }
                this.F.union(Math.round(min), Math.round(min2), Math.round(max), Math.round(max2));
            }
            i10++;
        }
        this.f8203k = motionEvent.getX();
        this.f8204l = motionEvent.getY();
        if (z10) {
            this.E.union(this.F);
            invalidate(this.E);
            this.E.set(this.F);
        }
    }

    private void n(MotionEvent motionEvent) {
        if (this.f8201i.isEmpty()) {
            return;
        }
        this.f8210r = false;
        q();
        invalidate();
    }

    private void o() {
        d dVar = this.f8200h;
        if (dVar != null) {
            dVar.c(this.f8201i);
        }
    }

    private void p() {
        d dVar = this.f8200h;
        if (dVar != null) {
            dVar.a();
        }
    }

    private void q() {
        d dVar = this.f8200h;
        if (dVar != null) {
            dVar.b(this.f8201i);
        }
    }

    private void r() {
        d dVar = this.f8200h;
        if (dVar != null) {
            dVar.d();
        }
    }

    private void s() {
        this.f8201i.clear();
        c();
        this.f8206n = c.Correct;
        invalidate();
    }

    private int t(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : i11 : Math.max(size, i11);
    }

    public c getDisplayMode() {
        return this.f8206n;
    }

    public List<b> getPattern() {
        return (List) this.f8201i.clone();
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return this.G * 3;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return this.G * 3;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ArrayList<b> arrayList = this.f8201i;
        int size = arrayList.size();
        boolean[][] zArr = this.f8202j;
        if (this.f8206n == c.Animate) {
            int elapsedRealtime = (((int) (SystemClock.elapsedRealtime() - this.f8205m)) % ((size + 1) * 700)) / 700;
            c();
            for (int i10 = 0; i10 < elapsedRealtime; i10++) {
                b bVar = arrayList.get(i10);
                zArr[bVar.c()][bVar.b()] = true;
            }
            if (elapsedRealtime > 0 && elapsedRealtime < size) {
                float f10 = (r2 % 700) / 700.0f;
                b bVar2 = arrayList.get(elapsedRealtime - 1);
                float h10 = h(bVar2.f8221g);
                float i11 = i(bVar2.f8220f);
                b bVar3 = arrayList.get(elapsedRealtime);
                float h11 = (h(bVar3.f8221g) - h10) * f10;
                float i12 = f10 * (i(bVar3.f8220f) - i11);
                this.f8203k = h10 + h11;
                this.f8204l = i11 + i12;
            }
            invalidate();
        }
        float f11 = this.f8213u;
        float f12 = this.f8214v;
        this.f8199g.setStrokeWidth(this.f8211s * f11 * 0.5f);
        Path path = this.D;
        path.rewind();
        int i13 = 0;
        while (true) {
            if (i13 >= 3) {
                break;
            }
            float f13 = (i13 * f12) + 0.0f;
            int i14 = 0;
            for (int i15 = 3; i14 < i15; i15 = 3) {
                f(canvas, (int) ((i14 * f11) + 0.0f), (int) f13, zArr[i13][i14]);
                i14++;
            }
            i13++;
        }
        boolean z10 = !this.f8208p || this.f8206n == c.Wrong;
        boolean z11 = (this.f8198f.getFlags() & 2) != 0;
        this.f8198f.setFilterBitmap(true);
        if (z10) {
            int i16 = 0;
            while (i16 < size - 1) {
                b bVar4 = arrayList.get(i16);
                int i17 = i16 + 1;
                b bVar5 = arrayList.get(i17);
                if (!zArr[bVar5.f8220f][bVar5.f8221g]) {
                    break;
                }
                e(canvas, (bVar4.f8221g * f11) + 0.0f, (bVar4.f8220f * f12) + 0.0f, bVar4, bVar5);
                z11 = z11;
                i16 = i17;
            }
        }
        boolean z12 = z11;
        if (z10) {
            int i18 = 0;
            boolean z13 = false;
            while (i18 < size) {
                b bVar6 = arrayList.get(i18);
                boolean[] zArr2 = zArr[bVar6.f8220f];
                int i19 = bVar6.f8221g;
                if (!zArr2[i19]) {
                    break;
                }
                float h12 = h(i19);
                float i20 = i(bVar6.f8220f);
                if (i18 == 0) {
                    path.moveTo(h12, i20);
                } else {
                    path.lineTo(h12, i20);
                }
                i18++;
                z13 = true;
            }
            if ((this.f8210r || this.f8206n == c.Animate) && z13 && size > 0) {
                path.lineTo(this.f8203k, this.f8204l);
            }
            canvas.drawPath(path, this.f8199g);
        }
        this.f8198f.setFilterBitmap(z12);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int t10 = t(i10, suggestedMinimumWidth);
        int t11 = t(i11, suggestedMinimumHeight);
        int i12 = this.I;
        if (i12 == 0) {
            t10 = Math.min(t10, t11);
            t11 = t10;
        } else if (i12 == 1) {
            t11 = Math.min(t10, t11);
        } else if (i12 == 2) {
            t10 = Math.min(t10, t11);
        }
        setMeasuredDimension(t10, t11);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        u(c.Correct, com.groboot.mdaemergency.ui.lockpattern.widget.a.c(eVar.b()));
        this.f8206n = c.values()[eVar.a()];
        this.f8207o = eVar.d();
        this.f8208p = eVar.c();
        this.f8209q = eVar.e();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new e(super.onSaveInstanceState(), "", this.f8206n.ordinal(), this.f8207o, this.f8208p, this.f8209q);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.f8213u = ((i10 + 0) + 0) / 3.0f;
        this.f8214v = ((i11 + 0) + 0) / 3.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f8207o || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            l(motionEvent);
            return true;
        }
        if (action == 1) {
            n(motionEvent);
            return true;
        }
        if (action == 2) {
            m(motionEvent);
            return true;
        }
        if (action != 3) {
            return false;
        }
        this.f8210r = false;
        s();
        p();
        return true;
    }

    public void setDisplayMode(c cVar) {
        this.f8206n = cVar;
        if (cVar == c.Animate) {
            if (this.f8201i.size() == 0) {
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            }
            this.f8205m = SystemClock.elapsedRealtime();
            b bVar = this.f8201i.get(0);
            this.f8203k = h(bVar.b());
            this.f8204l = i(bVar.c());
            c();
        }
        invalidate();
    }

    public void setInStealthMode(boolean z10) {
        this.f8208p = z10;
    }

    public void setOnPatternListener(d dVar) {
        this.f8200h = dVar;
    }

    public void setTactileFeedbackEnabled(boolean z10) {
        this.f8209q = z10;
    }

    public void u(c cVar, List<b> list) {
        this.f8201i.clear();
        this.f8201i.addAll(list);
        c();
        for (b bVar : list) {
            this.f8202j[bVar.c()][bVar.b()] = true;
        }
        setDisplayMode(cVar);
    }
}
