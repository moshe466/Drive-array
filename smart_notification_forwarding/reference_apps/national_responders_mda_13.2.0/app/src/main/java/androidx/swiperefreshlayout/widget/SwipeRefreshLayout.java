package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.view.a0;
import androidx.core.view.o;
import androidx.core.view.p;
import androidx.core.view.s;
import androidx.core.view.t;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements s, o {
    private static final String T = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] U = {R.attr.enabled};
    private int A;
    protected int B;
    float C;
    protected int D;
    int E;
    int F;
    androidx.swiperefreshlayout.widget.b G;
    private Animation H;
    private Animation I;
    private Animation J;
    private Animation K;
    private Animation L;
    boolean M;
    private int N;
    boolean O;
    private i P;
    private Animation.AnimationListener Q;
    private final Animation R;
    private final Animation S;

    /* renamed from: f, reason: collision with root package name */
    private View f3669f;

    /* renamed from: g, reason: collision with root package name */
    j f3670g;

    /* renamed from: h, reason: collision with root package name */
    boolean f3671h;

    /* renamed from: i, reason: collision with root package name */
    private int f3672i;

    /* renamed from: j, reason: collision with root package name */
    private float f3673j;

    /* renamed from: k, reason: collision with root package name */
    private float f3674k;

    /* renamed from: l, reason: collision with root package name */
    private final t f3675l;

    /* renamed from: m, reason: collision with root package name */
    private final p f3676m;

    /* renamed from: n, reason: collision with root package name */
    private final int[] f3677n;

    /* renamed from: o, reason: collision with root package name */
    private final int[] f3678o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f3679p;

    /* renamed from: q, reason: collision with root package name */
    private int f3680q;

    /* renamed from: r, reason: collision with root package name */
    int f3681r;

    /* renamed from: s, reason: collision with root package name */
    private float f3682s;

    /* renamed from: t, reason: collision with root package name */
    private float f3683t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f3684u;

    /* renamed from: v, reason: collision with root package name */
    private int f3685v;

    /* renamed from: w, reason: collision with root package name */
    boolean f3686w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f3687x;

    /* renamed from: y, reason: collision with root package name */
    private final DecelerateInterpolator f3688y;

    /* renamed from: z, reason: collision with root package name */
    androidx.swiperefreshlayout.widget.a f3689z;

    /* loaded from: classes.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f3671h) {
                swipeRefreshLayout.r();
                return;
            }
            swipeRefreshLayout.G.setAlpha(255);
            SwipeRefreshLayout.this.G.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.M && (jVar = swipeRefreshLayout2.f3670g) != null) {
                jVar.a();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.f3681r = swipeRefreshLayout3.f3689z.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends Animation {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3693f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3694g;

        d(int i10, int i11) {
            this.f3693f = i10;
            this.f3694g = i11;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.G.setAlpha((int) (this.f3693f + ((this.f3694g - r0) * f10)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f3686w) {
                return;
            }
            swipeRefreshLayout.x(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int abs = !swipeRefreshLayout.O ? swipeRefreshLayout.E - Math.abs(swipeRefreshLayout.D) : swipeRefreshLayout.E;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.B + ((int) ((abs - r1) * f10))) - swipeRefreshLayout2.f3689z.getTop());
            SwipeRefreshLayout.this.G.e(1.0f - f10);
        }
    }

    /* loaded from: classes.dex */
    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.p(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f11 = swipeRefreshLayout.C;
            swipeRefreshLayout.setAnimationProgress(f11 + ((-f11) * f10));
            SwipeRefreshLayout.this.p(f10);
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* loaded from: classes.dex */
    public interface j {
        void a();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3671h = false;
        this.f3673j = -1.0f;
        this.f3677n = new int[2];
        this.f3678o = new int[2];
        this.f3685v = -1;
        this.A = -1;
        this.Q = new a();
        this.R = new f();
        this.S = new g();
        this.f3672i = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3680q = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f3688y = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.N = (int) (displayMetrics.density * 40.0f);
        f();
        setChildrenDrawingOrderEnabled(true);
        int i10 = (int) (displayMetrics.density * 64.0f);
        this.E = i10;
        this.f3673j = i10;
        this.f3675l = new t(this);
        this.f3676m = new p(this);
        setNestedScrollingEnabled(true);
        int i11 = -this.N;
        this.f3681r = i11;
        this.D = i11;
        p(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, U);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void b(int i10, Animation.AnimationListener animationListener) {
        this.B = i10;
        this.R.reset();
        this.R.setDuration(200L);
        this.R.setInterpolator(this.f3688y);
        if (animationListener != null) {
            this.f3689z.b(animationListener);
        }
        this.f3689z.clearAnimation();
        this.f3689z.startAnimation(this.R);
    }

    private void d(int i10, Animation.AnimationListener animationListener) {
        if (this.f3686w) {
            y(i10, animationListener);
            return;
        }
        this.B = i10;
        this.S.reset();
        this.S.setDuration(200L);
        this.S.setInterpolator(this.f3688y);
        if (animationListener != null) {
            this.f3689z.b(animationListener);
        }
        this.f3689z.clearAnimation();
        this.f3689z.startAnimation(this.S);
    }

    private void f() {
        this.f3689z = new androidx.swiperefreshlayout.widget.a(getContext(), -328966);
        androidx.swiperefreshlayout.widget.b bVar = new androidx.swiperefreshlayout.widget.b(getContext());
        this.G = bVar;
        bVar.l(1);
        this.f3689z.setImageDrawable(this.G);
        this.f3689z.setVisibility(8);
        addView(this.f3689z);
    }

    private void g() {
        if (this.f3669f == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (!childAt.equals(this.f3689z)) {
                    this.f3669f = childAt;
                    return;
                }
            }
        }
    }

    private void h(float f10) {
        if (f10 > this.f3673j) {
            s(true, true);
            return;
        }
        this.f3671h = false;
        this.G.j(0.0f, 0.0f);
        d(this.f3681r, this.f3686w ? null : new e());
        this.G.d(false);
    }

    private boolean k(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void l(float f10) {
        this.G.d(true);
        float min = Math.min(1.0f, Math.abs(f10 / this.f3673j));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f10) - this.f3673j;
        int i10 = this.F;
        if (i10 <= 0) {
            i10 = this.O ? this.E - this.D : this.E;
        }
        float f11 = i10;
        double max2 = Math.max(0.0f, Math.min(abs, f11 * 2.0f) / f11) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i11 = this.D + ((int) ((f11 * min) + (f11 * pow * 2.0f)));
        if (this.f3689z.getVisibility() != 0) {
            this.f3689z.setVisibility(0);
        }
        if (!this.f3686w) {
            this.f3689z.setScaleX(1.0f);
            this.f3689z.setScaleY(1.0f);
        }
        if (this.f3686w) {
            setAnimationProgress(Math.min(1.0f, f10 / this.f3673j));
        }
        if (f10 < this.f3673j) {
            if (this.G.getAlpha() > 76 && !k(this.J)) {
                w();
            }
        } else if (this.G.getAlpha() < 255 && !k(this.K)) {
            v();
        }
        this.G.j(0.0f, Math.min(0.8f, max * 0.8f));
        this.G.e(Math.min(1.0f, max));
        this.G.g((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i11 - this.f3681r);
    }

    private void q(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3685v) {
            this.f3685v = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void s(boolean z10, boolean z11) {
        if (this.f3671h != z10) {
            this.M = z11;
            g();
            this.f3671h = z10;
            if (z10) {
                b(this.f3681r, this.Q);
            } else {
                x(this.Q);
            }
        }
    }

    private void setColorViewAlpha(int i10) {
        this.f3689z.getBackground().setAlpha(i10);
        this.G.setAlpha(i10);
    }

    private Animation t(int i10, int i11) {
        d dVar = new d(i10, i11);
        dVar.setDuration(300L);
        this.f3689z.b(null);
        this.f3689z.clearAnimation();
        this.f3689z.startAnimation(dVar);
        return dVar;
    }

    private void u(float f10) {
        float f11 = this.f3683t;
        float f12 = f10 - f11;
        int i10 = this.f3672i;
        if (f12 <= i10 || this.f3684u) {
            return;
        }
        this.f3682s = f11 + i10;
        this.f3684u = true;
        this.G.setAlpha(76);
    }

    private void v() {
        this.K = t(this.G.getAlpha(), 255);
    }

    private void w() {
        this.J = t(this.G.getAlpha(), 76);
    }

    private void y(int i10, Animation.AnimationListener animationListener) {
        this.B = i10;
        this.C = this.f3689z.getScaleX();
        h hVar = new h();
        this.L = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.f3689z.b(animationListener);
        }
        this.f3689z.clearAnimation();
        this.f3689z.startAnimation(this.L);
    }

    private void z(Animation.AnimationListener animationListener) {
        this.f3689z.setVisibility(0);
        this.G.setAlpha(255);
        b bVar = new b();
        this.H = bVar;
        bVar.setDuration(this.f3680q);
        if (animationListener != null) {
            this.f3689z.b(animationListener);
        }
        this.f3689z.clearAnimation();
        this.f3689z.startAnimation(this.H);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f3676m.a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f3676m.b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.f3676m.c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f3676m.f(i10, i11, i12, i13, iArr);
    }

    public boolean e() {
        i iVar = this.P;
        if (iVar != null) {
            return iVar.a(this, this.f3669f);
        }
        View view = this.f3669f;
        return view instanceof ListView ? androidx.core.widget.h.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        int i12 = this.A;
        return i12 < 0 ? i11 : i11 == i10 + (-1) ? i12 : i11 >= i12 ? i11 + 1 : i11;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3675l.a();
    }

    public int getProgressCircleDiameter() {
        return this.N;
    }

    public int getProgressViewEndOffset() {
        return this.E;
    }

    public int getProgressViewStartOffset() {
        return this.D;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f3676m.k();
    }

    @Override // android.view.View, androidx.core.view.o
    public boolean isNestedScrollingEnabled() {
        return this.f3676m.m();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        g();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3687x && actionMasked == 0) {
            this.f3687x = false;
        }
        if (!isEnabled() || this.f3687x || e() || this.f3671h || this.f3679p) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i10 = this.f3685v;
                    if (i10 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i10)) < 0) {
                        return false;
                    }
                    u(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        q(motionEvent);
                    }
                }
            }
            this.f3684u = false;
            this.f3685v = -1;
        } else {
            setTargetOffsetTopAndBottom(this.D - this.f3689z.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f3685v = pointerId;
            this.f3684u = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f3683t = motionEvent.getY(findPointerIndex2);
        }
        return this.f3684u;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f3669f == null) {
            g();
        }
        View view = this.f3669f;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f3689z.getMeasuredWidth();
        int measuredHeight2 = this.f3689z.getMeasuredHeight();
        int i14 = measuredWidth / 2;
        int i15 = measuredWidth2 / 2;
        int i16 = this.f3681r;
        this.f3689z.layout(i14 - i15, i16, i14 + i15, measuredHeight2 + i16);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f3669f == null) {
            g();
        }
        View view = this.f3669f;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f3689z.measure(View.MeasureSpec.makeMeasureSpec(this.N, 1073741824), View.MeasureSpec.makeMeasureSpec(this.N, 1073741824));
        this.A = -1;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (getChildAt(i12) == this.f3689z) {
                this.A = i12;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        if (i11 > 0) {
            float f10 = this.f3674k;
            if (f10 > 0.0f) {
                float f11 = i11;
                if (f11 > f10) {
                    iArr[1] = i11 - ((int) f10);
                    this.f3674k = 0.0f;
                } else {
                    this.f3674k = f10 - f11;
                    iArr[1] = i11;
                }
                l(this.f3674k);
            }
        }
        if (this.O && i11 > 0 && this.f3674k == 0.0f && Math.abs(i11 - iArr[1]) > 0) {
            this.f3689z.setVisibility(8);
        }
        int[] iArr2 = this.f3677n;
        if (dispatchNestedPreScroll(i10 - iArr[0], i11 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        dispatchNestedScroll(i10, i11, i12, i13, this.f3678o);
        if (i13 + this.f3678o[1] >= 0 || e()) {
            return;
        }
        float abs = this.f3674k + Math.abs(r11);
        this.f3674k = abs;
        l(abs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f3675l.b(view, view2, i10);
        startNestedScroll(i10 & 2);
        this.f3674k = 0.0f;
        this.f3679p = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return (!isEnabled() || this.f3687x || this.f3671h || (i10 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public void onStopNestedScroll(View view) {
        this.f3675l.d(view);
        this.f3679p = false;
        float f10 = this.f3674k;
        if (f10 > 0.0f) {
            h(f10);
            this.f3674k = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3687x && actionMasked == 0) {
            this.f3687x = false;
        }
        if (!isEnabled() || this.f3687x || e() || this.f3671h || this.f3679p) {
            return false;
        }
        if (actionMasked == 0) {
            this.f3685v = motionEvent.getPointerId(0);
            this.f3684u = false;
        } else {
            if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f3685v);
                if (findPointerIndex < 0) {
                    return false;
                }
                if (this.f3684u) {
                    float y10 = (motionEvent.getY(findPointerIndex) - this.f3682s) * 0.5f;
                    this.f3684u = false;
                    h(y10);
                }
                this.f3685v = -1;
                return false;
            }
            if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.f3685v);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                float y11 = motionEvent.getY(findPointerIndex2);
                u(y11);
                if (this.f3684u) {
                    float f10 = (y11 - this.f3682s) * 0.5f;
                    if (f10 <= 0.0f) {
                        return false;
                    }
                    l(f10);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        return false;
                    }
                    this.f3685v = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    q(motionEvent);
                }
            }
        }
        return true;
    }

    void p(float f10) {
        setTargetOffsetTopAndBottom((this.B + ((int) ((this.D - r0) * f10))) - this.f3689z.getTop());
    }

    void r() {
        this.f3689z.clearAnimation();
        this.G.stop();
        this.f3689z.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f3686w) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.D - this.f3681r);
        }
        this.f3681r = this.f3689z.getTop();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f3669f instanceof AbsListView)) {
            View view = this.f3669f;
            if (view == null || a0.T(view)) {
                super.requestDisallowInterceptTouchEvent(z10);
            }
        }
    }

    void setAnimationProgress(float f10) {
        this.f3689z.setScaleX(f10);
        this.f3689z.setScaleY(f10);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        g();
        this.G.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = androidx.core.content.a.d(context, iArr[i10]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i10) {
        this.f3673j = i10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            return;
        }
        r();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.f3676m.n(z10);
    }

    public void setOnChildScrollUpCallback(i iVar) {
        this.P = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.f3670g = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i10) {
        setProgressBackgroundColorSchemeResource(i10);
    }

    public void setProgressBackgroundColorSchemeColor(int i10) {
        this.f3689z.setBackgroundColor(i10);
    }

    public void setProgressBackgroundColorSchemeResource(int i10) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.d(getContext(), i10));
    }

    public void setRefreshing(boolean z10) {
        if (!z10 || this.f3671h == z10) {
            s(z10, false);
            return;
        }
        this.f3671h = z10;
        setTargetOffsetTopAndBottom((!this.O ? this.E + this.D : this.E) - this.f3681r);
        this.M = false;
        z(this.Q);
    }

    public void setSize(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.N = (int) (getResources().getDisplayMetrics().density * (i10 == 0 ? 56.0f : 40.0f));
            this.f3689z.setImageDrawable(null);
            this.G.l(i10);
            this.f3689z.setImageDrawable(this.G);
        }
    }

    public void setSlingshotDistance(int i10) {
        this.F = i10;
    }

    void setTargetOffsetTopAndBottom(int i10) {
        this.f3689z.bringToFront();
        a0.Z(this.f3689z, i10);
        this.f3681r = this.f3689z.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return this.f3676m.p(i10);
    }

    @Override // android.view.View, androidx.core.view.o
    public void stopNestedScroll() {
        this.f3676m.r();
    }

    void x(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.I = cVar;
        cVar.setDuration(150L);
        this.f3689z.b(animationListener);
        this.f3689z.clearAnimation();
        this.f3689z.startAnimation(this.I);
    }
}
