package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: p, reason: collision with root package name */
    private static e1 f1309p;

    /* renamed from: q, reason: collision with root package name */
    private static e1 f1310q;

    /* renamed from: f, reason: collision with root package name */
    private final View f1311f;

    /* renamed from: g, reason: collision with root package name */
    private final CharSequence f1312g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1313h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f1314i = new Runnable() { // from class: androidx.appcompat.widget.d1
        @Override // java.lang.Runnable
        public final void run() {
            e1.this.e();
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private final Runnable f1315j = new Runnable() { // from class: androidx.appcompat.widget.c1
        @Override // java.lang.Runnable
        public final void run() {
            e1.this.d();
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private int f1316k;

    /* renamed from: l, reason: collision with root package name */
    private int f1317l;

    /* renamed from: m, reason: collision with root package name */
    private f1 f1318m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1319n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1320o;

    private e1(View view, CharSequence charSequence) {
        this.f1311f = view;
        this.f1312g = charSequence;
        this.f1313h = androidx.core.view.c0.c(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f1311f.removeCallbacks(this.f1314i);
    }

    private void c() {
        this.f1320o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f1311f.postDelayed(this.f1314i, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(e1 e1Var) {
        e1 e1Var2 = f1309p;
        if (e1Var2 != null) {
            e1Var2.b();
        }
        f1309p = e1Var;
        if (e1Var != null) {
            e1Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        e1 e1Var = f1309p;
        if (e1Var != null && e1Var.f1311f == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new e1(view, charSequence);
            return;
        }
        e1 e1Var2 = f1310q;
        if (e1Var2 != null && e1Var2.f1311f == view) {
            e1Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean j(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (!this.f1320o && Math.abs(x10 - this.f1316k) <= this.f1313h && Math.abs(y10 - this.f1317l) <= this.f1313h) {
            return false;
        }
        this.f1316k = x10;
        this.f1317l = y10;
        this.f1320o = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (f1310q == this) {
            f1310q = null;
            f1 f1Var = this.f1318m;
            if (f1Var != null) {
                f1Var.c();
                this.f1318m = null;
                c();
                this.f1311f.removeOnAttachStateChangeListener(this);
            }
        }
        if (f1309p == this) {
            g(null);
        }
        this.f1311f.removeCallbacks(this.f1315j);
    }

    void i(boolean z10) {
        long longPressTimeout;
        if (androidx.core.view.a0.R(this.f1311f)) {
            g(null);
            e1 e1Var = f1310q;
            if (e1Var != null) {
                e1Var.d();
            }
            f1310q = this;
            this.f1319n = z10;
            f1 f1Var = new f1(this.f1311f.getContext());
            this.f1318m = f1Var;
            f1Var.e(this.f1311f, this.f1316k, this.f1317l, this.f1319n, this.f1312g);
            this.f1311f.addOnAttachStateChangeListener(this);
            if (this.f1319n) {
                longPressTimeout = 2500;
            } else {
                longPressTimeout = ((androidx.core.view.a0.K(this.f1311f) & 1) == 1 ? 3000L : 15000L) - ViewConfiguration.getLongPressTimeout();
            }
            this.f1311f.removeCallbacks(this.f1315j);
            this.f1311f.postDelayed(this.f1315j, longPressTimeout);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1318m != null && this.f1319n) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1311f.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f1311f.isEnabled() && this.f1318m == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1316k = view.getWidth() / 2;
        this.f1317l = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
