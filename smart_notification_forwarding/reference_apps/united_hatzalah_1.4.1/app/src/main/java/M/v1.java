package m;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.uh.sf.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class v1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: n, reason: collision with root package name */
    public static v1 f5800n;

    /* renamed from: o, reason: collision with root package name */
    public static v1 f5801o;

    /* renamed from: a, reason: collision with root package name */
    public final View f5802a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f5803b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5804c;

    /* renamed from: d, reason: collision with root package name */
    public final u1 f5805d;

    /* renamed from: e, reason: collision with root package name */
    public final u1 f5806e;

    /* renamed from: f, reason: collision with root package name */
    public int f5807f;

    /* renamed from: j, reason: collision with root package name */
    public int f5808j;

    /* renamed from: k, reason: collision with root package name */
    public w1 f5809k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5810l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5811m;

    /* JADX WARN: Type inference failed for: r0v0, types: [m.u1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [m.u1] */
    public v1(View view, CharSequence charSequence) {
        int scaledTouchSlop;
        final int i = 0;
        this.f5805d = new Runnable(this) { // from class: m.u1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v1 f5796b;

            {
                this.f5796b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.f5796b.c(false);
                        return;
                    default:
                        this.f5796b.a();
                        return;
                }
            }
        };
        final int i3 = 1;
        this.f5806e = new Runnable(this) { // from class: m.u1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v1 f5796b;

            {
                this.f5796b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i3) {
                    case 0:
                        this.f5796b.c(false);
                        return;
                    default:
                        this.f5796b.a();
                        return;
                }
            }
        };
        this.f5802a = view;
        this.f5803b = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = J.T.f959a;
        if (Build.VERSION.SDK_INT >= 28) {
            scaledTouchSlop = B.b.j(viewConfiguration);
        } else {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop() / 2;
        }
        this.f5804c = scaledTouchSlop;
        this.f5811m = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(v1 v1Var) {
        v1 v1Var2 = f5800n;
        if (v1Var2 != null) {
            v1Var2.f5802a.removeCallbacks(v1Var2.f5805d);
        }
        f5800n = v1Var;
        if (v1Var != null) {
            v1Var.f5802a.postDelayed(v1Var.f5805d, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        v1 v1Var = f5801o;
        View view = this.f5802a;
        if (v1Var == this) {
            f5801o = null;
            w1 w1Var = this.f5809k;
            if (w1Var != null) {
                View view2 = w1Var.f5828b;
                if (view2.getParent() != null) {
                    ((WindowManager) w1Var.f5827a.getSystemService("window")).removeView(view2);
                }
                this.f5809k = null;
                this.f5811m = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f5800n == this) {
            b(null);
        }
        view.removeCallbacks(this.f5806e);
    }

    public final void c(boolean z3) {
        int height;
        int i;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long longPressTimeout;
        long j2;
        long j3;
        WeakHashMap weakHashMap = J.S.f954a;
        View view = this.f5802a;
        if (!view.isAttachedToWindow()) {
            return;
        }
        b(null);
        v1 v1Var = f5801o;
        if (v1Var != null) {
            v1Var.a();
        }
        f5801o = this;
        this.f5810l = z3;
        w1 w1Var = new w1(view.getContext());
        this.f5809k = w1Var;
        int i9 = this.f5807f;
        int i10 = this.f5808j;
        boolean z4 = this.f5810l;
        View view2 = w1Var.f5828b;
        ViewParent parent = view2.getParent();
        Context context = w1Var.f5827a;
        if (parent != null && view2.getParent() != null) {
            ((WindowManager) context.getSystemService("window")).removeView(view2);
        }
        w1Var.f5829c.setText(this.f5803b);
        IBinder applicationWindowToken = view.getApplicationWindowToken();
        WindowManager.LayoutParams layoutParams = w1Var.f5830d;
        layoutParams.token = applicationWindowToken;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i9 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i10 + dimensionPixelOffset2;
            i = i10 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = context.getResources();
        if (z4) {
            i3 = R.dimen.tooltip_y_offset_touch;
        } else {
            i3 = R.dimen.tooltip_y_offset_non_touch;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i3);
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
        if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
            Context context2 = view.getContext();
            while (true) {
                if (!(context2 instanceof ContextWrapper)) {
                    break;
                }
                if (context2 instanceof Activity) {
                    rootView = ((Activity) context2).getWindow().getDecorView();
                    break;
                }
                context2 = ((ContextWrapper) context2).getBaseContext();
            }
        }
        if (rootView == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            i7 = 1;
        } else {
            Rect rect = w1Var.f5831e;
            rootView.getWindowVisibleDisplayFrame(rect);
            if (rect.left < 0 && rect.top < 0) {
                Resources resources2 = context.getResources();
                i7 = 1;
                i4 = i9;
                i5 = i;
                int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
                if (identifier != 0) {
                    i8 = resources2.getDimensionPixelSize(identifier);
                } else {
                    i8 = 0;
                }
                DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                i6 = 0;
                rect.set(0, i8, displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                i4 = i9;
                i5 = i;
                i6 = 0;
                i7 = 1;
            }
            int[] iArr = w1Var.f5833g;
            rootView.getLocationOnScreen(iArr);
            int[] iArr2 = w1Var.f5832f;
            view.getLocationOnScreen(iArr2);
            int i11 = iArr2[i6] - iArr[i6];
            iArr2[i6] = i11;
            iArr2[i7] = iArr2[i7] - iArr[i7];
            layoutParams.x = (i11 + i4) - (rootView.getWidth() / 2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, i6);
            view2.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredHeight = view2.getMeasuredHeight();
            int i12 = iArr2[i7];
            int i13 = ((i12 + i5) - dimensionPixelOffset3) - measuredHeight;
            int i14 = i12 + height + dimensionPixelOffset3;
            if (z4) {
                if (i13 >= 0) {
                    layoutParams.y = i13;
                } else {
                    layoutParams.y = i14;
                }
            } else if (measuredHeight + i14 <= rect.height()) {
                layoutParams.y = i14;
            } else {
                layoutParams.y = i13;
            }
        }
        ((WindowManager) context.getSystemService("window")).addView(view2, layoutParams);
        view.addOnAttachStateChangeListener(this);
        if (this.f5810l) {
            j3 = 2500;
        } else {
            if ((view.getWindowSystemUiVisibility() & 1) == i7) {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j2 = 3000;
            } else {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j2 = 15000;
            }
            j3 = j2 - longPressTimeout;
        }
        u1 u1Var = this.f5806e;
        view.removeCallbacks(u1Var);
        view.postDelayed(u1Var, j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if (java.lang.Math.abs(r5 - r3.f5808j) <= r2) goto L30;
     */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            m.w1 r4 = r3.f5809k
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.f5810l
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.f5802a
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.f5811m = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            m.w1 r4 = r3.f5809k
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.f5811m
            if (r1 != 0) goto L66
            int r1 = r3.f5807f
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f5804c
            if (r1 > r2) goto L66
            int r1 = r3.f5808j
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.f5807f = r4
            r3.f5808j = r5
            r3.f5811m = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.v1.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f5807f = view.getWidth() / 2;
        this.f5808j = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
