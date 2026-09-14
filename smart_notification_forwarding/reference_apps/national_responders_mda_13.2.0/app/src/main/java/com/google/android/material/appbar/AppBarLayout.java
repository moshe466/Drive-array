package com.google.android.material.appbar;

import a3.k;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.a0;
import androidx.core.view.k0;
import androidx.core.view.o;
import java.lang.ref.WeakReference;
import java.util.List;

@CoordinatorLayout.d(Behavior.class)
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    private int f6678f;

    /* renamed from: g, reason: collision with root package name */
    private int f6679g;

    /* renamed from: h, reason: collision with root package name */
    private int f6680h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6681i;

    /* renamed from: j, reason: collision with root package name */
    private int f6682j;

    /* renamed from: k, reason: collision with root package name */
    private k0 f6683k;

    /* renamed from: l, reason: collision with root package name */
    private List<a> f6684l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6685m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6686n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6687o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6688p;

    /* renamed from: q, reason: collision with root package name */
    private int[] f6689q;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a<T> {

        /* renamed from: k, reason: collision with root package name */
        private int f6690k;

        /* renamed from: l, reason: collision with root package name */
        private int f6691l;

        /* renamed from: m, reason: collision with root package name */
        private ValueAnimator f6692m;

        /* renamed from: n, reason: collision with root package name */
        private int f6693n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f6694o;

        /* renamed from: p, reason: collision with root package name */
        private float f6695p;

        /* renamed from: q, reason: collision with root package name */
        private WeakReference<View> f6696q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f6697a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f6698b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f6697a = coordinatorLayout;
                this.f6698b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.O(this.f6697a, this.f6698b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes.dex */
        public static class b extends y.a {
            public static final Parcelable.Creator<b> CREATOR = new a();

            /* renamed from: h, reason: collision with root package name */
            int f6700h;

            /* renamed from: i, reason: collision with root package name */
            float f6701i;

            /* renamed from: j, reason: collision with root package name */
            boolean f6702j;

            /* loaded from: classes.dex */
            static class a implements Parcelable.ClassLoaderCreator<b> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public b createFromParcel(Parcel parcel) {
                    return new b(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new b(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public b[] newArray(int i10) {
                    return new b[i10];
                }
            }

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f6700h = parcel.readInt();
                this.f6701i = parcel.readFloat();
                this.f6702j = parcel.readByte() != 0;
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // y.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeInt(this.f6700h);
                parcel.writeFloat(this.f6701i);
                parcel.writeByte(this.f6702j ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
            this.f6693n = -1;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6693n = -1;
        }

        private void R(CoordinatorLayout coordinatorLayout, T t10, int i10, float f10) {
            int abs = Math.abs(L() - i10);
            float abs2 = Math.abs(f10);
            S(coordinatorLayout, t10, i10, abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / t10.getHeight()) + 1.0f) * 150.0f));
        }

        private void S(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11) {
            int L = L();
            if (L == i10) {
                ValueAnimator valueAnimator = this.f6692m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f6692m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f6692m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f6692m = valueAnimator3;
                valueAnimator3.setInterpolator(b3.a.f4093e);
                this.f6692m.addUpdateListener(new a(coordinatorLayout, t10));
            } else {
                valueAnimator2.cancel();
            }
            this.f6692m.setDuration(Math.min(i11, 600));
            this.f6692m.setIntValues(L, i10);
            this.f6692m.start();
        }

        private boolean U(CoordinatorLayout coordinatorLayout, T t10, View view) {
            return t10.g() && coordinatorLayout.getHeight() - view.getHeight() <= t10.getHeight();
        }

        private static boolean V(int i10, int i11) {
            return (i10 & i11) == i11;
        }

        private View W(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (childAt instanceof o) {
                    return childAt;
                }
            }
            return null;
        }

        private static View X(AppBarLayout appBarLayout, int i10) {
            int abs = Math.abs(i10);
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = appBarLayout.getChildAt(i11);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int Y(T t10, int i10) {
            int childCount = t10.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = t10.getChildAt(i11);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                b bVar = (b) childAt.getLayoutParams();
                if (V(bVar.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) bVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) bVar).bottomMargin;
                }
                int i12 = -i10;
                if (top <= i12 && bottom >= i12) {
                    return i11;
                }
            }
            return -1;
        }

        private int b0(T t10, int i10) {
            int abs = Math.abs(i10);
            int childCount = t10.getChildCount();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i12 >= childCount) {
                    break;
                }
                View childAt = t10.getChildAt(i12);
                b bVar = (b) childAt.getLayoutParams();
                Interpolator b10 = bVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i12++;
                } else if (b10 != null) {
                    int a10 = bVar.a();
                    if ((a10 & 1) != 0) {
                        i11 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
                        if ((a10 & 2) != 0) {
                            i11 -= a0.A(childAt);
                        }
                    }
                    if (a0.w(childAt)) {
                        i11 -= t10.getTopInset();
                    }
                    if (i11 > 0) {
                        float f10 = i11;
                        return Integer.signum(i10) * (childAt.getTop() + Math.round(f10 * b10.getInterpolation((abs - childAt.getTop()) / f10)));
                    }
                }
            }
            return i10;
        }

        private boolean m0(CoordinatorLayout coordinatorLayout, T t10) {
            List<View> s10 = coordinatorLayout.s(t10);
            int size = s10.size();
            for (int i10 = 0; i10 < size; i10++) {
                CoordinatorLayout.c f10 = ((CoordinatorLayout.f) s10.get(i10).getLayoutParams()).f();
                if (f10 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) f10).J() != 0;
                }
            }
            return false;
        }

        private void n0(CoordinatorLayout coordinatorLayout, T t10) {
            int L = L();
            int Y = Y(t10, L);
            if (Y >= 0) {
                View childAt = t10.getChildAt(Y);
                b bVar = (b) childAt.getLayoutParams();
                int a10 = bVar.a();
                if ((a10 & 17) == 17) {
                    int i10 = -childAt.getTop();
                    int i11 = -childAt.getBottom();
                    if (Y == t10.getChildCount() - 1) {
                        i11 += t10.getTopInset();
                    }
                    if (V(a10, 2)) {
                        i11 += a0.A(childAt);
                    } else if (V(a10, 5)) {
                        int A = a0.A(childAt) + i11;
                        if (L < A) {
                            i10 = A;
                        } else {
                            i11 = A;
                        }
                    }
                    if (V(a10, 32)) {
                        i10 += ((LinearLayout.LayoutParams) bVar).topMargin;
                        i11 -= ((LinearLayout.LayoutParams) bVar).bottomMargin;
                    }
                    if (L < (i11 + i10) / 2) {
                        i10 = i11;
                    }
                    R(coordinatorLayout, t10, v.a.b(i10, -t10.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void o0(int i10, T t10, View view, int i11) {
            if (i11 == 1) {
                int L = L();
                if ((i10 >= 0 || L != 0) && (i10 <= 0 || L != (-t10.getDownNestedScrollRange()))) {
                    return;
                }
                a0.G0(view, 1);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void p0(androidx.coordinatorlayout.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = X(r7, r8)
                if (r0 == 0) goto L6e
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$b r1 = (com.google.android.material.appbar.AppBarLayout.b) r1
                int r1 = r1.a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L41
                int r2 = androidx.core.view.a0.A(r0)
                if (r9 <= 0) goto L2f
                r9 = r1 & 12
                if (r9 == 0) goto L2f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
            L2d:
                r8 = 1
                goto L42
            L2f:
                r9 = r1 & 2
                if (r9 == 0) goto L41
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
                goto L2d
            L41:
                r8 = 0
            L42:
                boolean r9 = r7.i()
                if (r9 == 0) goto L57
                android.view.View r9 = r5.W(r6)
                if (r9 == 0) goto L57
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L55
                goto L56
            L55:
                r3 = 0
            L56:
                r8 = r3
            L57:
                boolean r8 = r7.n(r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L6e
                if (r10 != 0) goto L6b
                if (r8 == 0) goto L6e
                boolean r6 = r5.m0(r6, r7)
                if (r6 == 0) goto L6e
            L6b:
                r7.jumpDrawablesToCurrentState()
            L6e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.p0(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        @Override // com.google.android.material.appbar.a
        int L() {
            return D() + this.f6690k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: T, reason: merged with bridge method [inline-methods] */
        public boolean G(T t10) {
            WeakReference<View> weakReference = this.f6696q;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: Z, reason: merged with bridge method [inline-methods] */
        public int J(T t10) {
            return -t10.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: a0, reason: merged with bridge method [inline-methods] */
        public int K(T t10) {
            return t10.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: c0, reason: merged with bridge method [inline-methods] */
        public void M(CoordinatorLayout coordinatorLayout, T t10) {
            n0(coordinatorLayout, t10);
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: d0, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, T t10, int i10) {
            boolean l10 = super.l(coordinatorLayout, t10, i10);
            int pendingAction = t10.getPendingAction();
            int i11 = this.f6693n;
            if (i11 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t10.getChildAt(i11);
                O(coordinatorLayout, t10, (-childAt.getBottom()) + (this.f6694o ? a0.A(childAt) + t10.getTopInset() : Math.round(childAt.getHeight() * this.f6695p)));
            } else if (pendingAction != 0) {
                boolean z10 = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i12 = -t10.getUpNestedPreScrollRange();
                    if (z10) {
                        R(coordinatorLayout, t10, i12, 0.0f);
                    } else {
                        O(coordinatorLayout, t10, i12);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z10) {
                        R(coordinatorLayout, t10, 0, 0.0f);
                    } else {
                        O(coordinatorLayout, t10, 0);
                    }
                }
            }
            t10.j();
            this.f6693n = -1;
            F(v.a.b(D(), -t10.getTotalScrollRange(), 0));
            p0(coordinatorLayout, t10, D(), 0, true);
            t10.a(D());
            return l10;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: e0, reason: merged with bridge method [inline-methods] */
        public boolean m(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, int i12, int i13) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t10.getLayoutParams())).height != -2) {
                return super.m(coordinatorLayout, t10, i10, i11, i12, i13);
            }
            coordinatorLayout.J(t10, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0), i13);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: f0, reason: merged with bridge method [inline-methods] */
        public void q(CoordinatorLayout coordinatorLayout, T t10, View view, int i10, int i11, int[] iArr, int i12) {
            int i13;
            int i14;
            if (i11 != 0) {
                if (i11 < 0) {
                    int i15 = -t10.getTotalScrollRange();
                    i13 = i15;
                    i14 = t10.getDownNestedPreScrollRange() + i15;
                } else {
                    i13 = -t10.getUpNestedPreScrollRange();
                    i14 = 0;
                }
                if (i13 != i14) {
                    iArr[1] = N(coordinatorLayout, t10, i11, i13, i14);
                    o0(i11, t10, view, i12);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: g0, reason: merged with bridge method [inline-methods] */
        public void s(CoordinatorLayout coordinatorLayout, T t10, View view, int i10, int i11, int i12, int i13, int i14) {
            if (i13 < 0) {
                N(coordinatorLayout, t10, i13, -t10.getDownNestedScrollRange(), 0);
                o0(i13, t10, view, i14);
            }
            if (t10.i()) {
                t10.n(view.getScrollY() > 0);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: h0, reason: merged with bridge method [inline-methods] */
        public void w(CoordinatorLayout coordinatorLayout, T t10, Parcelable parcelable) {
            if (!(parcelable instanceof b)) {
                super.w(coordinatorLayout, t10, parcelable);
                this.f6693n = -1;
                return;
            }
            b bVar = (b) parcelable;
            super.w(coordinatorLayout, t10, bVar.a());
            this.f6693n = bVar.f6700h;
            this.f6695p = bVar.f6701i;
            this.f6694o = bVar.f6702j;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public Parcelable x(CoordinatorLayout coordinatorLayout, T t10) {
            Parcelable x10 = super.x(coordinatorLayout, t10);
            int D = D();
            int childCount = t10.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = t10.getChildAt(i10);
                int bottom = childAt.getBottom() + D;
                if (childAt.getTop() + D <= 0 && bottom >= 0) {
                    b bVar = new b(x10);
                    bVar.f6700h = i10;
                    bVar.f6702j = bottom == a0.A(childAt) + t10.getTopInset();
                    bVar.f6701i = bottom / childAt.getHeight();
                    return bVar;
                }
            }
            return x10;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public boolean z(CoordinatorLayout coordinatorLayout, T t10, View view, View view2, int i10, int i11) {
            ValueAnimator valueAnimator;
            boolean z10 = (i10 & 2) != 0 && (t10.i() || U(coordinatorLayout, t10, view));
            if (z10 && (valueAnimator = this.f6692m) != null) {
                valueAnimator.cancel();
            }
            this.f6696q = null;
            this.f6691l = i11;
            return z10;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void B(CoordinatorLayout coordinatorLayout, T t10, View view, int i10) {
            if (this.f6691l == 0 || i10 == 1) {
                n0(coordinatorLayout, t10);
            }
            this.f6696q = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public int P(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, int i12) {
            int L = L();
            int i13 = 0;
            if (i11 == 0 || L < i11 || L > i12) {
                this.f6690k = 0;
            } else {
                int b10 = v.a.b(i10, i11, i12);
                if (L != b10) {
                    int b02 = t10.e() ? b0(t10, b10) : b10;
                    boolean F = F(b02);
                    i13 = L - b10;
                    this.f6690k = b10 - b02;
                    if (!F && t10.e()) {
                        coordinatorLayout.g(t10);
                    }
                    t10.a(D());
                    p0(coordinatorLayout, t10, b10, b10 < L ? -1 : 1, false);
                }
            }
            return i13;
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.F);
            N(obtainStyledAttributes.getDimensionPixelSize(k.G, 0));
            obtainStyledAttributes.recycle();
        }

        private static int P(AppBarLayout appBarLayout) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (f10 instanceof BaseBehavior) {
                return ((BaseBehavior) f10).L();
            }
            return 0;
        }

        private void Q(View view, View view2) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (f10 instanceof BaseBehavior) {
                a0.Z(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f10).f6690k) + L()) - H(view2));
            }
        }

        private void R(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.i()) {
                    appBarLayout.n(view.getScrollY() > 0);
                }
            }
        }

        @Override // com.google.android.material.appbar.b
        float I(View view) {
            int i10;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int P = P(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + P > downNestedPreScrollRange) && (i10 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (P / i10) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        public int K(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.K(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public AppBarLayout G(List<View> list) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = list.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Q(view, view2);
            R(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean v(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            AppBarLayout G = G(coordinatorLayout.r(view));
            if (G != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f6715d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    G.k(false, !z10);
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface a<T extends AppBarLayout> {
        void a(T t10, int i10);
    }

    /* loaded from: classes.dex */
    public static class b extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f6703a;

        /* renamed from: b, reason: collision with root package name */
        Interpolator f6704b;

        public b(int i10, int i11) {
            super(i10, i11);
            this.f6703a = 1;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6703a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f136a);
            this.f6703a = obtainStyledAttributes.getInt(k.f138b, 0);
            int i10 = k.f140c;
            if (obtainStyledAttributes.hasValue(i10)) {
                this.f6704b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i10, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6703a = 1;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f6703a = 1;
        }

        public b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6703a = 1;
        }

        public int a() {
            return this.f6703a;
        }

        public Interpolator b() {
            return this.f6704b;
        }

        boolean c() {
            int i10 = this.f6703a;
            return (i10 & 1) == 1 && (i10 & 10) != 0;
        }
    }

    private boolean f() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((b) getChildAt(i10).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void h() {
        this.f6678f = -1;
        this.f6679g = -1;
        this.f6680h = -1;
    }

    private void l(boolean z10, boolean z11, boolean z12) {
        this.f6682j = (z10 ? 1 : 2) | (z11 ? 4 : 0) | (z12 ? 8 : 0);
        requestLayout();
    }

    private boolean m(boolean z10) {
        if (this.f6686n == z10) {
            return false;
        }
        this.f6686n = z10;
        refreshDrawableState();
        return true;
    }

    void a(int i10) {
        List<a> list = this.f6684l;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = this.f6684l.get(i11);
                if (aVar != null) {
                    aVar.a(this, i10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (Build.VERSION.SDK_INT < 19 || !(layoutParams instanceof LinearLayout.LayoutParams)) ? layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams) : new b((LinearLayout.LayoutParams) layoutParams);
    }

    boolean e() {
        return this.f6681i;
    }

    boolean g() {
        return getTotalScrollRange() != 0;
    }

    int getDownNestedPreScrollRange() {
        int i10 = this.f6679g;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i12 = bVar.f6703a;
            if ((i12 & 5) != 5) {
                if (i11 > 0) {
                    break;
                }
            } else {
                int i13 = i11 + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
                i11 = (i12 & 8) != 0 ? i13 + a0.A(childAt) : i13 + (measuredHeight - ((i12 & 2) != 0 ? a0.A(childAt) : getTopInset()));
            }
        }
        int max = Math.max(0, i11);
        this.f6679g = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i10 = this.f6680h;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
            int i13 = bVar.f6703a;
            if ((i13 & 1) == 0) {
                break;
            }
            i12 += measuredHeight;
            if ((i13 & 2) != 0) {
                i12 -= a0.A(childAt) + getTopInset();
                break;
            }
            i11++;
        }
        int max = Math.max(0, i12);
        this.f6680h = max;
        return max;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int A = a0.A(this);
        if (A == 0) {
            int childCount = getChildCount();
            A = childCount >= 1 ? a0.A(getChildAt(childCount - 1)) : 0;
            if (A == 0) {
                return getHeight() / 3;
            }
        }
        return (A * 2) + topInset;
    }

    int getPendingAction() {
        return this.f6682j;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        k0 k0Var = this.f6683k;
        if (k0Var != null) {
            return k0Var.k();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f6678f;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i13 = bVar.f6703a;
            if ((i13 & 1) == 0) {
                break;
            }
            i12 += measuredHeight + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
            if ((i13 & 2) != 0) {
                i12 -= a0.A(childAt);
                break;
            }
            i11++;
        }
        int max = Math.max(0, i12 - getTopInset());
        this.f6678f = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean i() {
        return this.f6688p;
    }

    void j() {
        this.f6682j = 0;
    }

    public void k(boolean z10, boolean z11) {
        l(z10, z11, true);
    }

    boolean n(boolean z10) {
        if (this.f6687o == z10) {
            return false;
        }
        this.f6687o = z10;
        refreshDrawableState();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        if (this.f6689q == null) {
            this.f6689q = new int[4];
        }
        int[] iArr = this.f6689q;
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z10 = this.f6686n;
        int i11 = a3.b.f100g;
        if (!z10) {
            i11 = -i11;
        }
        iArr[0] = i11;
        iArr[1] = (z10 && this.f6687o) ? a3.b.f101h : -a3.b.f101h;
        int i12 = a3.b.f99f;
        if (!z10) {
            i12 = -i12;
        }
        iArr[2] = i12;
        iArr[3] = (z10 && this.f6687o) ? a3.b.f98e : -a3.b.f98e;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        h();
        this.f6681i = false;
        int childCount = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount) {
                break;
            }
            if (((b) getChildAt(i14).getLayoutParams()).b() != null) {
                this.f6681i = true;
                break;
            }
            i14++;
        }
        if (this.f6685m) {
            return;
        }
        m(this.f6688p || f());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        h();
    }

    public void setExpanded(boolean z10) {
        k(z10, a0.S(this));
    }

    public void setLiftOnScroll(boolean z10) {
        this.f6688p = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (i10 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i10);
    }

    @Deprecated
    public void setTargetElevation(float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.a(this, f10);
        }
    }
}
