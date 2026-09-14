package com.google.android.material.bottomsheet;

import a3.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.a0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import z.a;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6765a;

    /* renamed from: b, reason: collision with root package name */
    private float f6766b;

    /* renamed from: c, reason: collision with root package name */
    private int f6767c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6768d;

    /* renamed from: e, reason: collision with root package name */
    private int f6769e;

    /* renamed from: f, reason: collision with root package name */
    private int f6770f;

    /* renamed from: g, reason: collision with root package name */
    int f6771g;

    /* renamed from: h, reason: collision with root package name */
    int f6772h;

    /* renamed from: i, reason: collision with root package name */
    int f6773i;

    /* renamed from: j, reason: collision with root package name */
    boolean f6774j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6775k;

    /* renamed from: l, reason: collision with root package name */
    int f6776l;

    /* renamed from: m, reason: collision with root package name */
    z.a f6777m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6778n;

    /* renamed from: o, reason: collision with root package name */
    private int f6779o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6780p;

    /* renamed from: q, reason: collision with root package name */
    int f6781q;

    /* renamed from: r, reason: collision with root package name */
    WeakReference<V> f6782r;

    /* renamed from: s, reason: collision with root package name */
    WeakReference<View> f6783s;

    /* renamed from: t, reason: collision with root package name */
    private VelocityTracker f6784t;

    /* renamed from: u, reason: collision with root package name */
    int f6785u;

    /* renamed from: v, reason: collision with root package name */
    private int f6786v;

    /* renamed from: w, reason: collision with root package name */
    boolean f6787w;

    /* renamed from: x, reason: collision with root package name */
    private Map<View, Integer> f6788x;

    /* renamed from: y, reason: collision with root package name */
    private final a.c f6789y;

    /* loaded from: classes.dex */
    class a extends a.c {
        a() {
        }

        @Override // z.a.c
        public int a(View view, int i10, int i11) {
            return view.getLeft();
        }

        @Override // z.a.c
        public int b(View view, int i10, int i11) {
            int I = BottomSheetBehavior.this.I();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return v.a.b(i10, I, bottomSheetBehavior.f6774j ? bottomSheetBehavior.f6781q : bottomSheetBehavior.f6773i);
        }

        @Override // z.a.c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.f6774j ? bottomSheetBehavior.f6781q : bottomSheetBehavior.f6773i;
        }

        @Override // z.a.c
        public void j(int i10) {
            if (i10 == 1) {
                BottomSheetBehavior.this.P(1);
            }
        }

        @Override // z.a.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.G(i11);
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a0, code lost:
        
            if (r9 < java.lang.Math.abs(r9 - r10.f6773i)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00b2, code lost:
        
            if (java.lang.Math.abs(r9 - r1) < java.lang.Math.abs(r9 - r7.f6790a.f6773i)) goto L41;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x00c8  */
        @Override // z.a.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 223
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a.l(android.view.View, float, float):void");
        }

        @Override // z.a.c
        public boolean m(View view, int i10) {
            WeakReference<V> weakReference;
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.f6776l;
            if (i11 == 1 || bottomSheetBehavior.f6787w) {
                return false;
            }
            return ((i11 == 3 && bottomSheetBehavior.f6785u == i10 && (view2 = bottomSheetBehavior.f6783s.get()) != null && view2.canScrollVertically(-1)) || (weakReference = BottomSheetBehavior.this.f6782r) == null || weakReference.get() != view) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b extends y.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: h, reason: collision with root package name */
        final int f6791h;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, (ClassLoader) null);
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
            this.f6791h = parcel.readInt();
        }

        public b(Parcelable parcelable, int i10) {
            super(parcelable);
            this.f6791h = i10;
        }

        @Override // y.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f6791h);
        }
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final View f6792f;

        /* renamed from: g, reason: collision with root package name */
        private final int f6793g;

        c(View view, int i10) {
            this.f6792f = view;
            this.f6793g = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.a aVar = BottomSheetBehavior.this.f6777m;
            if (aVar == null || !aVar.m(true)) {
                BottomSheetBehavior.this.P(this.f6793g);
            } else {
                a0.e0(this.f6792f, this);
            }
        }
    }

    public BottomSheetBehavior() {
        this.f6765a = true;
        this.f6776l = 4;
        this.f6789y = new a();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i10;
        this.f6765a = true;
        this.f6776l = 4;
        this.f6789y = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f142d);
        int i11 = k.f148g;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i11);
        if (peekValue == null || (i10 = peekValue.data) != -1) {
            N(obtainStyledAttributes.getDimensionPixelSize(i11, -1));
        } else {
            N(i10);
        }
        M(obtainStyledAttributes.getBoolean(k.f146f, false));
        L(obtainStyledAttributes.getBoolean(k.f144e, true));
        O(obtainStyledAttributes.getBoolean(k.f150h, false));
        obtainStyledAttributes.recycle();
        this.f6766b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void F() {
        this.f6773i = this.f6765a ? Math.max(this.f6781q - this.f6770f, this.f6771g) : this.f6781q - this.f6770f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I() {
        if (this.f6765a) {
            return this.f6771g;
        }
        return 0;
    }

    private float J() {
        VelocityTracker velocityTracker = this.f6784t;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f6766b);
        return this.f6784t.getYVelocity(this.f6785u);
    }

    private void K() {
        this.f6785u = -1;
        VelocityTracker velocityTracker = this.f6784t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6784t = null;
        }
    }

    private void R(boolean z10) {
        int intValue;
        WeakReference<V> weakReference = this.f6782r;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z10) {
                if (this.f6788x != null) {
                    return;
                } else {
                    this.f6788x = new HashMap(childCount);
                }
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (childAt != this.f6782r.get()) {
                    if (!z10) {
                        Map<View, Integer> map = this.f6788x;
                        intValue = (map != null && map.containsKey(childAt)) ? this.f6788x.get(childAt).intValue() : 4;
                    } else if (Build.VERSION.SDK_INT >= 16) {
                        this.f6788x.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    }
                    a0.u0(childAt, intValue);
                }
            }
            if (z10) {
                return;
            }
            this.f6788x = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        if (java.lang.Math.abs(r4 - r1) < java.lang.Math.abs(r4 - r3.f6773i)) goto L33;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B(androidx.coordinatorlayout.widget.CoordinatorLayout r4, V r5, android.view.View r6, int r7) {
        /*
            r3 = this;
            int r4 = r5.getTop()
            int r7 = r3.I()
            r0 = 3
            if (r4 != r7) goto Lf
            r3.P(r0)
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r4 = r3.f6783s
            java.lang.Object r4 = r4.get()
            if (r6 != r4) goto L9f
            boolean r4 = r3.f6780p
            if (r4 != 0) goto L1d
            goto L9f
        L1d:
            int r4 = r3.f6779o
            r6 = 0
            r7 = 4
            if (r4 <= 0) goto L28
            int r4 = r3.I()
            goto L81
        L28:
            boolean r4 = r3.f6774j
            if (r4 == 0) goto L3a
            float r4 = r3.J()
            boolean r4 = r3.Q(r5, r4)
            if (r4 == 0) goto L3a
            int r4 = r3.f6781q
            r0 = 5
            goto L81
        L3a:
            int r4 = r3.f6779o
            if (r4 != 0) goto L7e
            int r4 = r5.getTop()
            boolean r1 = r3.f6765a
            r2 = 6
            if (r1 == 0) goto L5b
            int r1 = r3.f6771g
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f6773i
            int r4 = r4 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r1 >= r4) goto L7e
            int r4 = r3.f6771g
            goto L81
        L5b:
            int r1 = r3.f6772h
            if (r4 >= r1) goto L6b
            int r7 = r3.f6773i
            int r7 = r4 - r7
            int r7 = java.lang.Math.abs(r7)
            if (r4 >= r7) goto L7a
            r4 = 0
            goto L81
        L6b:
            int r0 = r4 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r3.f6773i
            int r4 = r4 - r1
            int r4 = java.lang.Math.abs(r4)
            if (r0 >= r4) goto L7e
        L7a:
            int r4 = r3.f6772h
            r0 = 6
            goto L81
        L7e:
            int r4 = r3.f6773i
            r0 = 4
        L81:
            z.a r7 = r3.f6777m
            int r1 = r5.getLeft()
            boolean r4 = r7.O(r5, r1, r4)
            if (r4 == 0) goto L9a
            r4 = 2
            r3.P(r4)
            com.google.android.material.bottomsheet.BottomSheetBehavior$c r4 = new com.google.android.material.bottomsheet.BottomSheetBehavior$c
            r4.<init>(r5, r0)
            androidx.core.view.a0.e0(r5, r4)
            goto L9d
        L9a:
            r3.P(r0)
        L9d:
            r3.f6780p = r6
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.B(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean C(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f6776l == 1 && actionMasked == 0) {
            return true;
        }
        z.a aVar = this.f6777m;
        if (aVar != null) {
            aVar.E(motionEvent);
        }
        if (actionMasked == 0) {
            K();
        }
        if (this.f6784t == null) {
            this.f6784t = VelocityTracker.obtain();
        }
        this.f6784t.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f6778n && Math.abs(this.f6786v - motionEvent.getY()) > this.f6777m.y()) {
            this.f6777m.b(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f6778n;
    }

    void G(int i10) {
        this.f6782r.get();
    }

    View H(View view) {
        if (a0.T(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View H = H(viewGroup.getChildAt(i10));
            if (H != null) {
                return H;
            }
        }
        return null;
    }

    public void L(boolean z10) {
        if (this.f6765a == z10) {
            return;
        }
        this.f6765a = z10;
        if (this.f6782r != null) {
            F();
        }
        P((this.f6765a && this.f6776l == 6) ? 3 : this.f6776l);
    }

    public void M(boolean z10) {
        this.f6774j = z10;
    }

    public final void N(int i10) {
        WeakReference<V> weakReference;
        V v10;
        boolean z10 = true;
        if (i10 == -1) {
            if (!this.f6768d) {
                this.f6768d = true;
            }
            z10 = false;
        } else {
            if (this.f6768d || this.f6767c != i10) {
                this.f6768d = false;
                this.f6767c = Math.max(0, i10);
                this.f6773i = this.f6781q - i10;
            }
            z10 = false;
        }
        if (!z10 || this.f6776l != 4 || (weakReference = this.f6782r) == null || (v10 = weakReference.get()) == null) {
            return;
        }
        v10.requestLayout();
    }

    public void O(boolean z10) {
        this.f6775k = z10;
    }

    void P(int i10) {
        boolean z10;
        if (this.f6776l == i10) {
            return;
        }
        this.f6776l = i10;
        if (i10 != 6 && i10 != 3) {
            z10 = (i10 == 5 || i10 == 4) ? false : true;
            this.f6782r.get();
        }
        R(z10);
        this.f6782r.get();
    }

    boolean Q(View view, float f10) {
        if (this.f6775k) {
            return true;
        }
        return view.getTop() >= this.f6773i && Math.abs((((float) view.getTop()) + (f10 * 0.1f)) - ((float) this.f6773i)) / ((float) this.f6767c) > 0.5f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        z.a aVar;
        if (!v10.isShown()) {
            this.f6778n = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            K();
        }
        if (this.f6784t == null) {
            this.f6784t = VelocityTracker.obtain();
        }
        this.f6784t.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.f6786v = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.f6783s;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && coordinatorLayout.B(view, x10, this.f6786v)) {
                this.f6785u = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f6787w = true;
            }
            this.f6778n = this.f6785u == -1 && !coordinatorLayout.B(v10, x10, this.f6786v);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f6787w = false;
            this.f6785u = -1;
            if (this.f6778n) {
                this.f6778n = false;
                return false;
            }
        }
        if (!this.f6778n && (aVar = this.f6777m) != null && aVar.N(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.f6783s;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.f6778n || this.f6776l == 1 || coordinatorLayout.B(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f6777m == null || Math.abs(((float) this.f6786v) - motionEvent.getY()) <= ((float) this.f6777m.y())) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean l(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, int r7) {
        /*
            r4 = this;
            boolean r0 = androidx.core.view.a0.w(r5)
            r1 = 1
            if (r0 == 0) goto L10
            boolean r0 = androidx.core.view.a0.w(r6)
            if (r0 != 0) goto L10
            r6.setFitsSystemWindows(r1)
        L10:
            int r0 = r6.getTop()
            r5.I(r6, r7)
            int r7 = r5.getHeight()
            r4.f6781q = r7
            boolean r7 = r4.f6768d
            if (r7 == 0) goto L43
            int r7 = r4.f6769e
            if (r7 != 0) goto L31
            android.content.res.Resources r7 = r5.getResources()
            int r2 = a3.d.f107a
            int r7 = r7.getDimensionPixelSize(r2)
            r4.f6769e = r7
        L31:
            int r7 = r4.f6769e
            int r2 = r4.f6781q
            int r3 = r5.getWidth()
            int r3 = r3 * 9
            int r3 = r3 / 16
            int r2 = r2 - r3
            int r7 = java.lang.Math.max(r7, r2)
            goto L45
        L43:
            int r7 = r4.f6767c
        L45:
            r4.f6770f = r7
            r7 = 0
            int r2 = r4.f6781q
            int r3 = r6.getHeight()
            int r2 = r2 - r3
            int r7 = java.lang.Math.max(r7, r2)
            r4.f6771g = r7
            int r7 = r4.f6781q
            r2 = 2
            int r7 = r7 / r2
            r4.f6772h = r7
            r4.F()
            int r7 = r4.f6776l
            r3 = 3
            if (r7 != r3) goto L6b
            int r7 = r4.I()
        L67:
            androidx.core.view.a0.Z(r6, r7)
            goto L8d
        L6b:
            r3 = 6
            if (r7 != r3) goto L71
            int r7 = r4.f6772h
            goto L67
        L71:
            boolean r3 = r4.f6774j
            if (r3 == 0) goto L7b
            r3 = 5
            if (r7 != r3) goto L7b
            int r7 = r4.f6781q
            goto L67
        L7b:
            r3 = 4
            if (r7 != r3) goto L81
            int r7 = r4.f6773i
            goto L67
        L81:
            if (r7 == r1) goto L85
            if (r7 != r2) goto L8d
        L85:
            int r7 = r6.getTop()
            int r0 = r0 - r7
            androidx.core.view.a0.Z(r6, r0)
        L8d:
            z.a r7 = r4.f6777m
            if (r7 != 0) goto L99
            z.a$c r7 = r4.f6789y
            z.a r5 = z.a.o(r5, r7)
            r4.f6777m = r5
        L99:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r6)
            r4.f6782r = r5
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            android.view.View r6 = r4.H(r6)
            r5.<init>(r6)
            r4.f6783s = r5
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
        return view == this.f6783s.get() && (this.f6776l != 3 || super.o(coordinatorLayout, v10, view, f10, f11));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
        int i13;
        if (i12 != 1 && view == this.f6783s.get()) {
            int top = v10.getTop();
            int i14 = top - i11;
            if (i11 > 0) {
                if (i14 < I()) {
                    iArr[1] = top - I();
                    a0.Z(v10, -iArr[1]);
                    i13 = 3;
                    P(i13);
                } else {
                    iArr[1] = i11;
                    a0.Z(v10, -i11);
                    P(1);
                }
            } else if (i11 < 0 && !view.canScrollVertically(-1)) {
                int i15 = this.f6773i;
                if (i14 <= i15 || this.f6774j) {
                    iArr[1] = i11;
                    a0.Z(v10, -i11);
                    P(1);
                } else {
                    iArr[1] = top - i15;
                    a0.Z(v10, -iArr[1]);
                    i13 = 4;
                    P(i13);
                }
            }
            G(v10.getTop());
            this.f6779o = i11;
            this.f6780p = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void w(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.w(coordinatorLayout, v10, bVar.a());
        int i10 = bVar.f6791h;
        if (i10 == 1 || i10 == 2) {
            i10 = 4;
        }
        this.f6776l = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable x(CoordinatorLayout coordinatorLayout, V v10) {
        return new b(super.x(coordinatorLayout, v10), this.f6776l);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean z(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        this.f6779o = 0;
        this.f6780p = false;
        return (i10 & 2) != 0;
    }
}
