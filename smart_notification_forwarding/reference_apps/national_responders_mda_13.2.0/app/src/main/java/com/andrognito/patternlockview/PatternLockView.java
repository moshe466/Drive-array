package com.andrognito.patternlockview;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PatternLockView extends View {
    private static int M;
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private float F;
    private float G;
    private final Path H;
    private final Rect I;
    private final Rect J;
    private Interpolator K;
    private Interpolator L;

    /* renamed from: f, reason: collision with root package name */
    private g[][] f4505f;

    /* renamed from: g, reason: collision with root package name */
    private int f4506g;

    /* renamed from: h, reason: collision with root package name */
    private long f4507h;

    /* renamed from: i, reason: collision with root package name */
    private float f4508i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4509j;

    /* renamed from: k, reason: collision with root package name */
    private int f4510k;

    /* renamed from: l, reason: collision with root package name */
    private int f4511l;

    /* renamed from: m, reason: collision with root package name */
    private int f4512m;

    /* renamed from: n, reason: collision with root package name */
    private int f4513n;

    /* renamed from: o, reason: collision with root package name */
    private int f4514o;

    /* renamed from: p, reason: collision with root package name */
    private int f4515p;

    /* renamed from: q, reason: collision with root package name */
    private int f4516q;

    /* renamed from: r, reason: collision with root package name */
    private int f4517r;

    /* renamed from: s, reason: collision with root package name */
    private int f4518s;

    /* renamed from: t, reason: collision with root package name */
    private Paint f4519t;

    /* renamed from: u, reason: collision with root package name */
    private Paint f4520u;

    /* renamed from: v, reason: collision with root package name */
    private List<v0.a> f4521v;

    /* renamed from: w, reason: collision with root package name */
    private ArrayList<f> f4522w;

    /* renamed from: x, reason: collision with root package name */
    private boolean[][] f4523x;

    /* renamed from: y, reason: collision with root package name */
    private float f4524y;

    /* renamed from: z, reason: collision with root package name */
    private float f4525z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f4526f;

        a(g gVar) {
            this.f4526f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PatternLockView.this.N(r0.f4516q, PatternLockView.this.f4515p, PatternLockView.this.f4517r, PatternLockView.this.K, this.f4526f, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f4528a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f4529b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f4530c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f4531d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f4532e;

        b(g gVar, float f10, float f11, float f12, float f13) {
            this.f4528a = gVar;
            this.f4529b = f10;
            this.f4530c = f11;
            this.f4531d = f12;
            this.f4532e = f13;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            g gVar = this.f4528a;
            float f10 = 1.0f - floatValue;
            gVar.f4545e = (this.f4529b * f10) + (this.f4530c * floatValue);
            gVar.f4546f = (f10 * this.f4531d) + (floatValue * this.f4532e);
            PatternLockView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f4534a;

        c(PatternLockView patternLockView, g gVar) {
            this.f4534a = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4534a.f4547g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f4535a;

        d(g gVar) {
            this.f4535a = gVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f4535a.f4544d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PatternLockView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f4537a;

        e(PatternLockView patternLockView, Runnable runnable) {
            this.f4537a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f4537a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Parcelable {
        public static final Parcelable.Creator<f> CREATOR;

        /* renamed from: h, reason: collision with root package name */
        private static f[][] f4538h = (f[][]) Array.newInstance((Class<?>) f.class, PatternLockView.M, PatternLockView.M);

        /* renamed from: f, reason: collision with root package name */
        private int f4539f;

        /* renamed from: g, reason: collision with root package name */
        private int f4540g;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, (a) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i10) {
                return new f[i10];
            }
        }

        static {
            for (int i10 = 0; i10 < PatternLockView.M; i10++) {
                for (int i11 = 0; i11 < PatternLockView.M; i11++) {
                    f4538h[i10][i11] = new f(i10, i11);
                }
            }
            CREATOR = new a();
        }

        private f(int i10, int i11) {
            c(i10, i11);
            this.f4539f = i10;
            this.f4540g = i11;
        }

        private f(Parcel parcel) {
            this.f4540g = parcel.readInt();
            this.f4539f = parcel.readInt();
        }

        /* synthetic */ f(Parcel parcel, a aVar) {
            this(parcel);
        }

        private static void c(int i10, int i11) {
            if (i10 < 0 || i10 > PatternLockView.M - 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("mRow must be in range 0-");
                sb2.append(PatternLockView.M - 1);
                throw new IllegalArgumentException(sb2.toString());
            }
            if (i11 < 0 || i11 > PatternLockView.M - 1) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("mColumn must be in range 0-");
                sb3.append(PatternLockView.M - 1);
                throw new IllegalArgumentException(sb3.toString());
            }
        }

        public static synchronized f f(int i10, int i11) {
            f fVar;
            synchronized (f.class) {
                c(i10, i11);
                fVar = f4538h[i10][i11];
            }
            return fVar;
        }

        public int d() {
            return this.f4540g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int e() {
            return this.f4539f;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return super.equals(obj);
            }
            f fVar = (f) obj;
            return this.f4540g == fVar.f4540g && this.f4539f == fVar.f4539f;
        }

        public int hashCode() {
            return (this.f4539f * 31) + this.f4540g;
        }

        public String toString() {
            return "(Row = " + this.f4539f + ", Col = " + this.f4540g + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f4540g);
            parcel.writeInt(this.f4539f);
        }
    }

    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: d, reason: collision with root package name */
        float f4544d;

        /* renamed from: g, reason: collision with root package name */
        ValueAnimator f4547g;

        /* renamed from: a, reason: collision with root package name */
        float f4541a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        float f4542b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        float f4543c = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        float f4545e = Float.MIN_VALUE;

        /* renamed from: f, reason: collision with root package name */
        float f4546f = Float.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends View.BaseSavedState {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        private final String f4548f;

        /* renamed from: g, reason: collision with root package name */
        private final int f4549g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f4550h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f4551i;

        /* renamed from: j, reason: collision with root package name */
        private final boolean f4552j;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i10) {
                return new h[i10];
            }
        }

        private h(Parcel parcel) {
            super(parcel);
            this.f4548f = parcel.readString();
            this.f4549g = parcel.readInt();
            this.f4550h = ((Boolean) parcel.readValue(null)).booleanValue();
            this.f4551i = ((Boolean) parcel.readValue(null)).booleanValue();
            this.f4552j = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        /* synthetic */ h(Parcel parcel, a aVar) {
            this(parcel);
        }

        private h(Parcelable parcelable, String str, int i10, boolean z10, boolean z11, boolean z12) {
            super(parcelable);
            this.f4548f = str;
            this.f4549g = i10;
            this.f4550h = z10;
            this.f4551i = z11;
            this.f4552j = z12;
        }

        /* synthetic */ h(Parcelable parcelable, String str, int i10, boolean z10, boolean z11, boolean z12, a aVar) {
            this(parcelable, str, i10, z10, z11, z12);
        }

        public int a() {
            return this.f4549g;
        }

        public String b() {
            return this.f4548f;
        }

        public boolean c() {
            return this.f4551i;
        }

        public boolean d() {
            return this.f4550h;
        }

        public boolean e() {
            return this.f4552j;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f4548f);
            parcel.writeInt(this.f4549g);
            parcel.writeValue(Boolean.valueOf(this.f4550h));
            parcel.writeValue(Boolean.valueOf(this.f4551i));
            parcel.writeValue(Boolean.valueOf(this.f4552j));
        }
    }

    public PatternLockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4508i = 0.6f;
        this.f4524y = -1.0f;
        this.f4525z = -1.0f;
        this.A = 0;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = false;
        this.H = new Path();
        this.I = new Rect();
        this.J = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u0.d.f14341a);
        try {
            M = obtainStyledAttributes.getInt(u0.d.f14346f, 3);
            this.f4509j = obtainStyledAttributes.getBoolean(u0.d.f14343c, false);
            this.f4510k = obtainStyledAttributes.getInt(u0.d.f14342b, 0);
            this.f4514o = (int) obtainStyledAttributes.getDimension(u0.d.f14351k, w0.b.b(getContext(), u0.b.f14336c));
            int i10 = u0.d.f14349i;
            Context context2 = getContext();
            int i11 = u0.a.f14333b;
            this.f4511l = obtainStyledAttributes.getColor(i10, w0.b.a(context2, i11));
            this.f4513n = obtainStyledAttributes.getColor(u0.d.f14344d, w0.b.a(getContext(), i11));
            this.f4512m = obtainStyledAttributes.getColor(u0.d.f14352l, w0.b.a(getContext(), u0.a.f14332a));
            this.f4515p = (int) obtainStyledAttributes.getDimension(u0.d.f14347g, w0.b.b(getContext(), u0.b.f14335b));
            this.f4516q = (int) obtainStyledAttributes.getDimension(u0.d.f14348h, w0.b.b(getContext(), u0.b.f14334a));
            this.f4517r = obtainStyledAttributes.getInt(u0.d.f14345e, 190);
            this.f4518s = obtainStyledAttributes.getInt(u0.d.f14350j, 100);
            obtainStyledAttributes.recycle();
            int i12 = M;
            this.f4506g = i12 * i12;
            this.f4522w = new ArrayList<>(this.f4506g);
            int i13 = M;
            this.f4523x = (boolean[][]) Array.newInstance((Class<?>) boolean.class, i13, i13);
            int i14 = M;
            this.f4505f = (g[][]) Array.newInstance((Class<?>) g.class, i14, i14);
            for (int i15 = 0; i15 < M; i15++) {
                for (int i16 = 0; i16 < M; i16++) {
                    this.f4505f[i15][i16] = new g();
                    this.f4505f[i15][i16].f4544d = this.f4515p;
                }
            }
            this.f4521v = new ArrayList();
            x();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void A(List<f> list) {
        for (v0.a aVar : this.f4521v) {
            if (aVar != null) {
                aVar.b(list);
            }
        }
    }

    private void B() {
        for (v0.a aVar : this.f4521v) {
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    private void C() {
        J(u0.c.f14337a);
        y();
    }

    private void D() {
        J(u0.c.f14338b);
        z(this.f4522w);
    }

    private void E() {
        J(u0.c.f14339c);
        A(this.f4522w);
    }

    private void F() {
        J(u0.c.f14340d);
        B();
    }

    private void H() {
        this.f4522w.clear();
        m();
        this.A = 0;
        invalidate();
    }

    private int I(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : i11 : Math.max(size, i11);
    }

    private void J(int i10) {
        if (Build.VERSION.SDK_INT >= 16) {
            announceForAccessibility(getContext().getString(i10));
            return;
        }
        setContentDescription(getContext().getString(i10));
        sendAccessibilityEvent(4);
        setContentDescription(null);
    }

    private void L(f fVar) {
        g gVar = this.f4505f[fVar.f4539f][fVar.f4540g];
        N(this.f4515p, this.f4516q, this.f4517r, this.L, gVar, new a(gVar));
        M(gVar, this.f4524y, this.f4525z, p(fVar.f4540g), q(fVar.f4539f));
    }

    private void M(g gVar, float f10, float f11, float f12, float f13) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(gVar, f10, f12, f11, f13));
        ofFloat.addListener(new c(this, gVar));
        ofFloat.setInterpolator(this.K);
        ofFloat.setDuration(this.f4518s);
        ofFloat.start();
        gVar.f4547g = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(float f10, float f11, long j10, Interpolator interpolator, g gVar, Runnable runnable) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        ofFloat.addUpdateListener(new d(gVar));
        if (runnable != null) {
            ofFloat.addListener(new e(this, runnable));
        }
        ofFloat.setInterpolator(interpolator);
        ofFloat.setDuration(j10);
        ofFloat.start();
    }

    private void g(f fVar) {
        this.f4523x[fVar.f4539f][fVar.f4540g] = true;
        this.f4522w.add(fVar);
        if (!this.C) {
            L(fVar);
        }
        E();
    }

    private float i(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        return Math.min(1.0f, Math.max(0.0f, ((((float) Math.sqrt((f14 * f14) + (f15 * f15))) / this.F) - 0.3f) * 4.0f));
    }

    private void j() {
        for (int i10 = 0; i10 < M; i10++) {
            for (int i11 = 0; i11 < M; i11++) {
                g gVar = this.f4505f[i10][i11];
                ValueAnimator valueAnimator = gVar.f4547g;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    gVar.f4545e = Float.MIN_VALUE;
                    gVar.f4546f = Float.MIN_VALUE;
                }
            }
        }
    }

    private f k(float f10, float f11) {
        int r10;
        int t10 = t(f11);
        if (t10 >= 0 && (r10 = r(f10)) >= 0 && !this.f4523x[t10][r10]) {
            return f.f(t10, r10);
        }
        return null;
    }

    private void m() {
        for (int i10 = 0; i10 < M; i10++) {
            for (int i11 = 0; i11 < M; i11++) {
                this.f4523x[i10][i11] = false;
            }
        }
    }

    @TargetApi(5)
    private f n(float f10, float f11) {
        f k10 = k(f10, f11);
        f fVar = null;
        if (k10 == null) {
            return null;
        }
        ArrayList<f> arrayList = this.f4522w;
        if (!arrayList.isEmpty()) {
            f fVar2 = arrayList.get(arrayList.size() - 1);
            int i10 = k10.f4539f - fVar2.f4539f;
            int i11 = k10.f4540g - fVar2.f4540g;
            int i12 = fVar2.f4539f;
            int i13 = fVar2.f4540g;
            if (Math.abs(i10) == 2 && Math.abs(i11) != 1) {
                i12 = fVar2.f4539f + (i10 > 0 ? 1 : -1);
            }
            if (Math.abs(i11) == 2 && Math.abs(i10) != 1) {
                i13 = fVar2.f4540g + (i11 > 0 ? 1 : -1);
            }
            fVar = f.f(i12, i13);
        }
        if (fVar != null && !this.f4523x[fVar.f4539f][fVar.f4540g]) {
            g(fVar);
        }
        g(k10);
        if (this.D) {
            performHapticFeedback(1, 3);
        }
        return k10;
    }

    private void o(Canvas canvas, float f10, float f11, float f12, boolean z10, float f13) {
        this.f4519t.setColor(s(z10));
        this.f4519t.setAlpha((int) (f13 * 255.0f));
        canvas.drawCircle(f10, f11, f12 / 2.0f, this.f4519t);
    }

    private float p(int i10) {
        float paddingLeft = getPaddingLeft();
        float f10 = this.F;
        return paddingLeft + (i10 * f10) + (f10 / 2.0f);
    }

    private float q(int i10) {
        float paddingTop = getPaddingTop();
        float f10 = this.G;
        return paddingTop + (i10 * f10) + (f10 / 2.0f);
    }

    private int r(float f10) {
        float f11 = this.F;
        float f12 = this.f4508i * f11;
        float paddingLeft = getPaddingLeft() + ((f11 - f12) / 2.0f);
        for (int i10 = 0; i10 < M; i10++) {
            float f13 = (i10 * f11) + paddingLeft;
            if (f10 >= f13 && f10 <= f13 + f12) {
                return i10;
            }
        }
        return -1;
    }

    private int s(boolean z10) {
        if (!z10 || this.C || this.E) {
            return this.f4511l;
        }
        int i10 = this.A;
        if (i10 == 2) {
            return this.f4512m;
        }
        if (i10 == 0 || i10 == 1) {
            return this.f4513n;
        }
        throw new IllegalStateException("Unknown view mode " + this.A);
    }

    private int t(float f10) {
        float f11 = this.G;
        float f12 = this.f4508i * f11;
        float paddingTop = getPaddingTop() + ((f11 - f12) / 2.0f);
        for (int i10 = 0; i10 < M; i10++) {
            float f13 = (i10 * f11) + paddingTop;
            if (f10 >= f13 && f10 <= f13 + f12) {
                return i10;
            }
        }
        return -1;
    }

    private void u(MotionEvent motionEvent) {
        H();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        f n10 = n(x10, y10);
        if (n10 != null) {
            this.E = true;
            this.A = 0;
            F();
        } else {
            this.E = false;
            C();
        }
        if (n10 != null) {
            float p10 = p(n10.f4540g);
            float q10 = q(n10.f4539f);
            float f10 = this.F / 2.0f;
            float f11 = this.G / 2.0f;
            invalidate((int) (p10 - f10), (int) (q10 - f11), (int) (p10 + f10), (int) (q10 + f11));
        }
        this.f4524y = x10;
        this.f4525z = y10;
    }

    private void v(MotionEvent motionEvent) {
        float f10 = this.f4514o;
        int historySize = motionEvent.getHistorySize();
        this.J.setEmpty();
        int i10 = 0;
        boolean z10 = false;
        while (i10 < historySize + 1) {
            float historicalX = i10 < historySize ? motionEvent.getHistoricalX(i10) : motionEvent.getX();
            float historicalY = i10 < historySize ? motionEvent.getHistoricalY(i10) : motionEvent.getY();
            f n10 = n(historicalX, historicalY);
            int size = this.f4522w.size();
            if (n10 != null && size == 1) {
                this.E = true;
                F();
            }
            float abs = Math.abs(historicalX - this.f4524y);
            float abs2 = Math.abs(historicalY - this.f4525z);
            if (abs > 0.0f || abs2 > 0.0f) {
                z10 = true;
            }
            if (this.E && size > 0) {
                f fVar = this.f4522w.get(size - 1);
                float p10 = p(fVar.f4540g);
                float q10 = q(fVar.f4539f);
                float min = Math.min(p10, historicalX) - f10;
                float max = Math.max(p10, historicalX) + f10;
                float min2 = Math.min(q10, historicalY) - f10;
                float max2 = Math.max(q10, historicalY) + f10;
                if (n10 != null) {
                    float f11 = this.F * 0.5f;
                    float f12 = this.G * 0.5f;
                    float p11 = p(n10.f4540g);
                    float q11 = q(n10.f4539f);
                    min = Math.min(p11 - f11, min);
                    max = Math.max(p11 + f11, max);
                    min2 = Math.min(q11 - f12, min2);
                    max2 = Math.max(q11 + f12, max2);
                }
                this.J.union(Math.round(min), Math.round(min2), Math.round(max), Math.round(max2));
            }
            i10++;
        }
        this.f4524y = motionEvent.getX();
        this.f4525z = motionEvent.getY();
        if (z10) {
            this.I.union(this.J);
            invalidate(this.I);
            this.I.set(this.J);
        }
    }

    private void w(MotionEvent motionEvent) {
        if (this.f4522w.isEmpty()) {
            return;
        }
        this.E = false;
        j();
        D();
        invalidate();
    }

    private void x() {
        setClickable(true);
        Paint paint = new Paint();
        this.f4520u = paint;
        paint.setAntiAlias(true);
        this.f4520u.setDither(true);
        this.f4520u.setColor(this.f4511l);
        this.f4520u.setStyle(Paint.Style.STROKE);
        this.f4520u.setStrokeJoin(Paint.Join.ROUND);
        this.f4520u.setStrokeCap(Paint.Cap.ROUND);
        this.f4520u.setStrokeWidth(this.f4514o);
        Paint paint2 = new Paint();
        this.f4519t = paint2;
        paint2.setAntiAlias(true);
        this.f4519t.setDither(true);
        if (Build.VERSION.SDK_INT < 21 || isInEditMode()) {
            return;
        }
        this.K = AnimationUtils.loadInterpolator(getContext(), R.interpolator.fast_out_slow_in);
        this.L = AnimationUtils.loadInterpolator(getContext(), R.interpolator.linear_out_slow_in);
    }

    private void y() {
        for (v0.a aVar : this.f4521v) {
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    private void z(List<f> list) {
        for (v0.a aVar : this.f4521v) {
            if (aVar != null) {
                aVar.a(list);
            }
        }
    }

    public void G(v0.a aVar) {
        this.f4521v.remove(aVar);
    }

    public void K(int i10, List<f> list) {
        this.f4522w.clear();
        this.f4522w.addAll(list);
        m();
        for (f fVar : list) {
            this.f4523x[fVar.f4539f][fVar.f4540g] = true;
        }
        setViewMode(i10);
    }

    public int getAspectRatio() {
        return this.f4510k;
    }

    public int getCorrectStateColor() {
        return this.f4513n;
    }

    public int getDotAnimationDuration() {
        return this.f4517r;
    }

    public int getDotCount() {
        return M;
    }

    public int getDotNormalSize() {
        return this.f4515p;
    }

    public int getDotSelectedSize() {
        return this.f4516q;
    }

    public int getNormalStateColor() {
        return this.f4511l;
    }

    public int getPathEndAnimationDuration() {
        return this.f4518s;
    }

    public int getPathWidth() {
        return this.f4514o;
    }

    public List<f> getPattern() {
        return (List) this.f4522w.clone();
    }

    public int getPatternSize() {
        return this.f4506g;
    }

    public int getPatternViewMode() {
        return this.A;
    }

    public int getWrongStateColor() {
        return this.f4512m;
    }

    public void h(v0.a aVar) {
        this.f4521v.add(aVar);
    }

    public void l() {
        H();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ArrayList<f> arrayList = this.f4522w;
        int size = arrayList.size();
        boolean[][] zArr = this.f4523x;
        int i10 = 0;
        if (this.A == 1) {
            int elapsedRealtime = (((int) (SystemClock.elapsedRealtime() - this.f4507h)) % ((size + 1) * 700)) / 700;
            m();
            for (int i11 = 0; i11 < elapsedRealtime; i11++) {
                f fVar = arrayList.get(i11);
                zArr[fVar.f4539f][fVar.f4540g] = true;
            }
            if (elapsedRealtime > 0 && elapsedRealtime < size) {
                float f10 = (r2 % 700) / 700.0f;
                f fVar2 = arrayList.get(elapsedRealtime - 1);
                float p10 = p(fVar2.f4540g);
                float q10 = q(fVar2.f4539f);
                f fVar3 = arrayList.get(elapsedRealtime);
                float p11 = (p(fVar3.f4540g) - p10) * f10;
                float q11 = f10 * (q(fVar3.f4539f) - q10);
                this.f4524y = p10 + p11;
                this.f4525z = q10 + q11;
            }
            invalidate();
        }
        Path path = this.H;
        path.rewind();
        for (int i12 = 0; i12 < M; i12++) {
            float q12 = q(i12);
            int i13 = 0;
            while (i13 < M) {
                g gVar = this.f4505f[i12][i13];
                o(canvas, (int) p(i13), ((int) q12) + gVar.f4542b, gVar.f4544d * gVar.f4541a, zArr[i12][i13], gVar.f4543c);
                i13++;
                q12 = q12;
            }
        }
        if (!this.C) {
            this.f4520u.setColor(s(true));
            float f11 = 0.0f;
            float f12 = 0.0f;
            boolean z10 = false;
            while (i10 < size) {
                f fVar4 = arrayList.get(i10);
                if (!zArr[fVar4.f4539f][fVar4.f4540g]) {
                    break;
                }
                float p12 = p(fVar4.f4540g);
                float q13 = q(fVar4.f4539f);
                if (i10 != 0) {
                    g gVar2 = this.f4505f[fVar4.f4539f][fVar4.f4540g];
                    path.rewind();
                    path.moveTo(f11, f12);
                    float f13 = gVar2.f4545e;
                    if (f13 != Float.MIN_VALUE) {
                        float f14 = gVar2.f4546f;
                        if (f14 != Float.MIN_VALUE) {
                            path.lineTo(f13, f14);
                            canvas.drawPath(path, this.f4520u);
                        }
                    }
                    path.lineTo(p12, q13);
                    canvas.drawPath(path, this.f4520u);
                }
                i10++;
                f11 = p12;
                f12 = q13;
                z10 = true;
            }
            if ((this.E || this.A == 1) && z10) {
                path.rewind();
                path.moveTo(f11, f12);
                path.lineTo(this.f4524y, this.f4525z);
                this.f4520u.setAlpha((int) (i(this.f4524y, this.f4525z, f11, f12) * 255.0f));
                canvas.drawPath(path, this.f4520u);
            }
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i10;
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7) {
                i10 = 2;
            } else if (action != 9) {
                if (action == 10) {
                    i10 = 1;
                }
                onTouchEvent(motionEvent);
                motionEvent.setAction(action);
            } else {
                i10 = 0;
            }
            motionEvent.setAction(i10);
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f4509j) {
            int I = I(i10, getSuggestedMinimumWidth());
            int I2 = I(i11, getSuggestedMinimumHeight());
            int i12 = this.f4510k;
            if (i12 == 0) {
                I = Math.min(I, I2);
                I2 = I;
            } else if (i12 == 1) {
                I2 = Math.min(I, I2);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("Unknown aspect ratio");
                }
                I = Math.min(I, I2);
            }
            setMeasuredDimension(I, I2);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        K(0, w0.a.b(this, hVar.b()));
        this.A = hVar.a();
        this.B = hVar.d();
        this.C = hVar.c();
        this.D = hVar.e();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new h(super.onSaveInstanceState(), w0.a.a(this, this.f4522w), this.A, this.B, this.C, this.D, null);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.F = ((i10 - getPaddingLeft()) - getPaddingRight()) / M;
        this.G = ((i11 - getPaddingTop()) - getPaddingBottom()) / M;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.B || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            u(motionEvent);
            return true;
        }
        if (action == 1) {
            w(motionEvent);
            return true;
        }
        if (action == 2) {
            v(motionEvent);
            return true;
        }
        if (action != 3) {
            return false;
        }
        this.E = false;
        H();
        C();
        return true;
    }

    public void setAspectRatio(int i10) {
        this.f4510k = i10;
        requestLayout();
    }

    public void setAspectRatioEnabled(boolean z10) {
        this.f4509j = z10;
        requestLayout();
    }

    public void setCorrectStateColor(int i10) {
        this.f4513n = i10;
    }

    public void setDotAnimationDuration(int i10) {
        this.f4517r = i10;
        invalidate();
    }

    public void setDotCount(int i10) {
        M = i10;
        this.f4506g = i10 * i10;
        this.f4522w = new ArrayList<>(this.f4506g);
        int i11 = M;
        this.f4523x = (boolean[][]) Array.newInstance((Class<?>) boolean.class, i11, i11);
        int i12 = M;
        this.f4505f = (g[][]) Array.newInstance((Class<?>) g.class, i12, i12);
        for (int i13 = 0; i13 < M; i13++) {
            for (int i14 = 0; i14 < M; i14++) {
                this.f4505f[i13][i14] = new g();
                this.f4505f[i13][i14].f4544d = this.f4515p;
            }
        }
        requestLayout();
        invalidate();
    }

    public void setDotNormalSize(int i10) {
        this.f4515p = i10;
        for (int i11 = 0; i11 < M; i11++) {
            for (int i12 = 0; i12 < M; i12++) {
                this.f4505f[i11][i12] = new g();
                this.f4505f[i11][i12].f4544d = this.f4515p;
            }
        }
        invalidate();
    }

    public void setDotSelectedSize(int i10) {
        this.f4516q = i10;
    }

    public void setEnableHapticFeedback(boolean z10) {
        this.D = z10;
    }

    public void setInStealthMode(boolean z10) {
        this.C = z10;
    }

    public void setInputEnabled(boolean z10) {
        this.B = z10;
    }

    public void setNormalStateColor(int i10) {
        this.f4511l = i10;
    }

    public void setPathEndAnimationDuration(int i10) {
        this.f4518s = i10;
    }

    public void setPathWidth(int i10) {
        this.f4514o = i10;
        x();
        invalidate();
    }

    public void setTactileFeedbackEnabled(boolean z10) {
        this.D = z10;
    }

    public void setViewMode(int i10) {
        this.A = i10;
        if (i10 == 1) {
            if (this.f4522w.size() == 0) {
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            }
            this.f4507h = SystemClock.elapsedRealtime();
            f fVar = this.f4522w.get(0);
            this.f4524y = p(fVar.f4540g);
            this.f4525z = q(fVar.f4539f);
            m();
        }
        invalidate();
    }

    public void setWrongStateColor(int i10) {
        this.f4512m = i10;
    }
}
