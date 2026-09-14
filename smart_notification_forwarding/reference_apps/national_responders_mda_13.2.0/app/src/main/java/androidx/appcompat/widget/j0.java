package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class j0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    private final float f1376f;

    /* renamed from: g, reason: collision with root package name */
    private final int f1377g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1378h;

    /* renamed from: i, reason: collision with root package name */
    final View f1379i;

    /* renamed from: j, reason: collision with root package name */
    private Runnable f1380j;

    /* renamed from: k, reason: collision with root package name */
    private Runnable f1381k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1382l;

    /* renamed from: m, reason: collision with root package name */
    private int f1383m;

    /* renamed from: n, reason: collision with root package name */
    private final int[] f1384n = new int[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = j0.this.f1379i.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.e();
        }
    }

    public j0(View view) {
        this.f1379i = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1376f = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1377g = tapTimeout;
        this.f1378h = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f1381k;
        if (runnable != null) {
            this.f1379i.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1380j;
        if (runnable2 != null) {
            this.f1379i.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        h0 h0Var;
        View view = this.f1379i;
        androidx.appcompat.view.menu.p b10 = b();
        if (b10 == null || !b10.c() || (h0Var = (h0) b10.h()) == null || !h0Var.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(h0Var, obtainNoHistory);
        boolean e10 = h0Var.e(obtainNoHistory, this.f1383m);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return e10 && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r1 != 3) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1379i
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f1383m
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1376f
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f1383m = r6
            java.lang.Runnable r6 = r5.f1380j
            if (r6 != 0) goto L52
            androidx.appcompat.widget.j0$a r6 = new androidx.appcompat.widget.j0$a
            r6.<init>()
            r5.f1380j = r6
        L52:
            java.lang.Runnable r6 = r5.f1380j
            int r1 = r5.f1377g
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1381k
            if (r6 != 0) goto L65
            androidx.appcompat.widget.j0$b r6 = new androidx.appcompat.widget.j0$b
            r6.<init>()
            r5.f1381k = r6
        L65:
            java.lang.Runnable r6 = r5.f1381k
            int r1 = r5.f1378h
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j0.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        return f10 >= f13 && f11 >= f13 && f10 < ((float) (view.getRight() - view.getLeft())) + f12 && f11 < ((float) (view.getBottom() - view.getTop())) + f12;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1384n);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1384n);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    public abstract androidx.appcompat.view.menu.p b();

    protected abstract boolean c();

    protected boolean d() {
        androidx.appcompat.view.menu.p b10 = b();
        if (b10 == null || !b10.c()) {
            return true;
        }
        b10.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f1379i;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1382l = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f1382l;
        if (z11) {
            z10 = f(motionEvent) || !d();
        } else {
            z10 = g(motionEvent) && c();
            if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1379i.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1382l = z10;
        return z10 || z11;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1382l = false;
        this.f1383m = -1;
        Runnable runnable = this.f1380j;
        if (runnable != null) {
            this.f1379i.removeCallbacks(runnable);
        }
    }
}
