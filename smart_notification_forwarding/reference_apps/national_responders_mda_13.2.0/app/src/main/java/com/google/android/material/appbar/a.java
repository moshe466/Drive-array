package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.a0;

/* loaded from: classes.dex */
abstract class a<V extends View> extends c<V> {

    /* renamed from: d, reason: collision with root package name */
    private Runnable f6705d;

    /* renamed from: e, reason: collision with root package name */
    OverScroller f6706e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6707f;

    /* renamed from: g, reason: collision with root package name */
    private int f6708g;

    /* renamed from: h, reason: collision with root package name */
    private int f6709h;

    /* renamed from: i, reason: collision with root package name */
    private int f6710i;

    /* renamed from: j, reason: collision with root package name */
    private VelocityTracker f6711j;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.material.appbar.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0085a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final CoordinatorLayout f6712f;

        /* renamed from: g, reason: collision with root package name */
        private final V f6713g;

        RunnableC0085a(CoordinatorLayout coordinatorLayout, V v10) {
            this.f6712f = coordinatorLayout;
            this.f6713g = v10;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f6713g == null || (overScroller = a.this.f6706e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.M(this.f6712f, this.f6713g);
                return;
            }
            a aVar = a.this;
            aVar.O(this.f6712f, this.f6713g, aVar.f6706e.getCurrY());
            a0.e0(this.f6713g, this);
        }
    }

    public a() {
        this.f6708g = -1;
        this.f6710i = -1;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6708g = -1;
        this.f6710i = -1;
    }

    private void H() {
        if (this.f6711j == null) {
            this.f6711j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if (r0 != 3) goto L39;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean C(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.f6710i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.f6710i = r0
        L12:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8d
            r3 = -1
            if (r0 == r1) goto L5c
            r4 = 2
            if (r0 == r4) goto L25
            r12 = 3
            if (r0 == r12) goto L7e
            goto Lae
        L25:
            int r0 = r11.f6708g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r3) goto L2e
            return r2
        L2e:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.f6709h
            int r2 = r2 - r0
            boolean r3 = r11.f6707f
            if (r3 != 0) goto L49
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.f6710i
            if (r3 <= r4) goto L49
            r11.f6707f = r1
            if (r2 <= 0) goto L48
            int r2 = r2 - r4
            goto L49
        L48:
            int r2 = r2 + r4
        L49:
            r6 = r2
            boolean r2 = r11.f6707f
            if (r2 == 0) goto Lae
            r11.f6709h = r0
            int r7 = r11.J(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.N(r4, r5, r6, r7, r8)
            goto Lae
        L5c:
            android.view.VelocityTracker r0 = r11.f6711j
            if (r0 == 0) goto L7e
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f6711j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f6711j
            int r4 = r11.f6708g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.K(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.I(r6, r7, r8, r9, r10)
        L7e:
            r11.f6707f = r2
            r11.f6708g = r3
            android.view.VelocityTracker r12 = r11.f6711j
            if (r12 == 0) goto Lae
            r12.recycle()
            r12 = 0
            r11.f6711j = r12
            goto Lae
        L8d:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r3 = r14.getY()
            int r3 = (int) r3
            boolean r12 = r12.B(r13, r0, r3)
            if (r12 == 0) goto Lb6
            boolean r12 = r11.G(r13)
            if (r12 == 0) goto Lb6
            r11.f6709h = r3
            int r12 = r14.getPointerId(r2)
            r11.f6708g = r12
            r11.H()
        Lae:
            android.view.VelocityTracker r12 = r11.f6711j
            if (r12 == 0) goto Lb5
            r12.addMovement(r14)
        Lb5:
            return r1
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    abstract boolean G(V v10);

    final boolean I(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, float f10) {
        Runnable runnable = this.f6705d;
        if (runnable != null) {
            v10.removeCallbacks(runnable);
            this.f6705d = null;
        }
        if (this.f6706e == null) {
            this.f6706e = new OverScroller(v10.getContext());
        }
        this.f6706e.fling(0, D(), 0, Math.round(f10), 0, 0, i10, i11);
        if (!this.f6706e.computeScrollOffset()) {
            M(coordinatorLayout, v10);
            return false;
        }
        RunnableC0085a runnableC0085a = new RunnableC0085a(coordinatorLayout, v10);
        this.f6705d = runnableC0085a;
        a0.e0(v10, runnableC0085a);
        return true;
    }

    abstract int J(V v10);

    abstract int K(V v10);

    abstract int L();

    abstract void M(CoordinatorLayout coordinatorLayout, V v10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int N(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        return P(coordinatorLayout, v10, L() - i10, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int O(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        return P(coordinatorLayout, v10, i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    abstract int P(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12);

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r0 != 3) goto L35;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean k(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.f6710i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.f6710i = r0
        L12:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r4.f6707f
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L60
            r5 = -1
            if (r0 == r2) goto L51
            if (r0 == r1) goto L2f
            r6 = 3
            if (r0 == r6) goto L51
            goto L83
        L2f:
            int r6 = r4.f6708g
            if (r6 != r5) goto L34
            goto L83
        L34:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L3b
            goto L83
        L3b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.f6709h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.f6710i
            if (r6 <= r0) goto L83
            r4.f6707f = r2
            r4.f6709h = r5
            goto L83
        L51:
            r4.f6707f = r3
            r4.f6708g = r5
            android.view.VelocityTracker r5 = r4.f6711j
            if (r5 == 0) goto L83
            r5.recycle()
            r5 = 0
            r4.f6711j = r5
            goto L83
        L60:
            r4.f6707f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.G(r6)
            if (r2 == 0) goto L83
            boolean r5 = r5.B(r6, r0, r1)
            if (r5 == 0) goto L83
            r4.f6709h = r1
            int r5 = r7.getPointerId(r3)
            r4.f6708g = r5
            r4.H()
        L83:
            android.view.VelocityTracker r5 = r4.f6711j
            if (r5 == 0) goto L8a
            r5.addMovement(r7)
        L8a:
            boolean r5 = r4.f6707f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.k(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }
}
