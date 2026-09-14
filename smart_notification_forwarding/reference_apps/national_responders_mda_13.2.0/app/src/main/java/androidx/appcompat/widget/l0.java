package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class l0 implements androidx.appcompat.view.menu.p {
    private static Method K;
    private static Method L;
    private static Method M;
    private AdapterView.OnItemSelectedListener A;
    final i B;
    private final h C;
    private final g D;
    private final e E;
    final Handler F;
    private final Rect G;
    private Rect H;
    private boolean I;
    PopupWindow J;

    /* renamed from: f, reason: collision with root package name */
    private Context f1413f;

    /* renamed from: g, reason: collision with root package name */
    private ListAdapter f1414g;

    /* renamed from: h, reason: collision with root package name */
    h0 f1415h;

    /* renamed from: i, reason: collision with root package name */
    private int f1416i;

    /* renamed from: j, reason: collision with root package name */
    private int f1417j;

    /* renamed from: k, reason: collision with root package name */
    private int f1418k;

    /* renamed from: l, reason: collision with root package name */
    private int f1419l;

    /* renamed from: m, reason: collision with root package name */
    private int f1420m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1421n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1422o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f1423p;

    /* renamed from: q, reason: collision with root package name */
    private int f1424q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1425r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f1426s;

    /* renamed from: t, reason: collision with root package name */
    int f1427t;

    /* renamed from: u, reason: collision with root package name */
    private View f1428u;

    /* renamed from: v, reason: collision with root package name */
    private int f1429v;

    /* renamed from: w, reason: collision with root package name */
    private DataSetObserver f1430w;

    /* renamed from: x, reason: collision with root package name */
    private View f1431x;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f1432y;

    /* renamed from: z, reason: collision with root package name */
    private AdapterView.OnItemClickListener f1433z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View t10 = l0.this.t();
            if (t10 == null || t10.getWindowToken() == null) {
                return;
            }
            l0.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            h0 h0Var;
            if (i10 == -1 || (h0Var = l0.this.f1415h) == null) {
                return;
            }
            h0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static int a(PopupWindow popupWindow, View view, int i10, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.this.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (l0.this.c()) {
                l0.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            l0.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 != 1 || l0.this.w() || l0.this.J.getContentView() == null) {
                return;
            }
            l0 l0Var = l0.this;
            l0Var.F.removeCallbacks(l0Var.B);
            l0.this.B.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = l0.this.J) != null && popupWindow.isShowing() && x10 >= 0 && x10 < l0.this.J.getWidth() && y10 >= 0 && y10 < l0.this.J.getHeight()) {
                l0 l0Var = l0.this;
                l0Var.F.postDelayed(l0Var.B, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            l0 l0Var2 = l0.this;
            l0Var2.F.removeCallbacks(l0Var2.B);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h0 h0Var = l0.this.f1415h;
            if (h0Var == null || !androidx.core.view.a0.R(h0Var) || l0.this.f1415h.getCount() <= l0.this.f1415h.getChildCount()) {
                return;
            }
            int childCount = l0.this.f1415h.getChildCount();
            l0 l0Var = l0.this;
            if (childCount <= l0Var.f1427t) {
                l0Var.J.setInputMethodMode(2);
                l0.this.a();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                K = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                M = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                L = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public l0(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public l0(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f1416i = -2;
        this.f1417j = -2;
        this.f1420m = 1002;
        this.f1424q = 0;
        this.f1425r = false;
        this.f1426s = false;
        this.f1427t = Integer.MAX_VALUE;
        this.f1429v = 0;
        this.B = new i();
        this.C = new h();
        this.D = new g();
        this.E = new e();
        this.G = new Rect();
        this.f1413f = context;
        this.F = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f9024g1, i10, i11);
        this.f1418k = obtainStyledAttributes.getDimensionPixelOffset(e.j.f9029h1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(e.j.f9034i1, 0);
        this.f1419l = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1421n = true;
        }
        obtainStyledAttributes.recycle();
        r rVar = new r(context, attributeSet, i10, i11);
        this.J = rVar;
        rVar.setInputMethodMode(1);
    }

    private void J(boolean z10) {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.J, z10);
            return;
        }
        Method method = K;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int q() {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.l0.q():int");
    }

    private int u(View view, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT > 23) {
            return c.a(this.J, view, i10, z10);
        }
        Method method = L;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.J, view, Integer.valueOf(i10), Boolean.valueOf(z10))).intValue();
            } catch (Exception unused) {
            }
        }
        return this.J.getMaxAvailableHeight(view, i10);
    }

    private void y() {
        View view = this.f1428u;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1428u);
            }
        }
    }

    public void A(int i10) {
        this.J.setAnimationStyle(i10);
    }

    public void B(int i10) {
        Drawable background = this.J.getBackground();
        if (background == null) {
            M(i10);
            return;
        }
        background.getPadding(this.G);
        Rect rect = this.G;
        this.f1417j = rect.left + rect.right + i10;
    }

    public void C(int i10) {
        this.f1424q = i10;
    }

    public void D(Rect rect) {
        this.H = rect != null ? new Rect(rect) : null;
    }

    public void E(int i10) {
        this.J.setInputMethodMode(i10);
    }

    public void F(boolean z10) {
        this.I = z10;
        this.J.setFocusable(z10);
    }

    public void G(PopupWindow.OnDismissListener onDismissListener) {
        this.J.setOnDismissListener(onDismissListener);
    }

    public void H(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1433z = onItemClickListener;
    }

    public void I(boolean z10) {
        this.f1423p = true;
        this.f1422o = z10;
    }

    public void K(int i10) {
        this.f1429v = i10;
    }

    public void L(int i10) {
        h0 h0Var = this.f1415h;
        if (!c() || h0Var == null) {
            return;
        }
        h0Var.setListSelectionHidden(false);
        h0Var.setSelection(i10);
        if (h0Var.getChoiceMode() != 0) {
            h0Var.setItemChecked(i10, true);
        }
    }

    public void M(int i10) {
        this.f1417j = i10;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        int q10 = q();
        boolean w10 = w();
        androidx.core.widget.i.b(this.J, this.f1420m);
        if (this.J.isShowing()) {
            if (androidx.core.view.a0.R(t())) {
                int i10 = this.f1417j;
                if (i10 == -1) {
                    i10 = -1;
                } else if (i10 == -2) {
                    i10 = t().getWidth();
                }
                int i11 = this.f1416i;
                if (i11 == -1) {
                    if (!w10) {
                        q10 = -1;
                    }
                    if (w10) {
                        this.J.setWidth(this.f1417j == -1 ? -1 : 0);
                        this.J.setHeight(0);
                    } else {
                        this.J.setWidth(this.f1417j == -1 ? -1 : 0);
                        this.J.setHeight(-1);
                    }
                } else if (i11 != -2) {
                    q10 = i11;
                }
                this.J.setOutsideTouchable((this.f1426s || this.f1425r) ? false : true);
                this.J.update(t(), this.f1418k, this.f1419l, i10 < 0 ? -1 : i10, q10 < 0 ? -1 : q10);
                return;
            }
            return;
        }
        int i12 = this.f1417j;
        if (i12 == -1) {
            i12 = -1;
        } else if (i12 == -2) {
            i12 = t().getWidth();
        }
        int i13 = this.f1416i;
        if (i13 == -1) {
            q10 = -1;
        } else if (i13 != -2) {
            q10 = i13;
        }
        this.J.setWidth(i12);
        this.J.setHeight(q10);
        J(true);
        this.J.setOutsideTouchable((this.f1426s || this.f1425r) ? false : true);
        this.J.setTouchInterceptor(this.C);
        if (this.f1423p) {
            androidx.core.widget.i.a(this.J, this.f1422o);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = M;
            if (method != null) {
                try {
                    method.invoke(this.J, this.H);
                } catch (Exception unused) {
                }
            }
        } else {
            d.a(this.J, this.H);
        }
        androidx.core.widget.i.c(this.J, t(), this.f1418k, this.f1419l, this.f1424q);
        this.f1415h.setSelection(-1);
        if (!this.I || this.f1415h.isInTouchMode()) {
            r();
        }
        if (this.I) {
            return;
        }
        this.F.post(this.E);
    }

    public void b(Drawable drawable) {
        this.J.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return this.J.isShowing();
    }

    public int d() {
        return this.f1418k;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        this.J.dismiss();
        y();
        this.J.setContentView(null);
        this.f1415h = null;
        this.F.removeCallbacks(this.B);
    }

    public Drawable g() {
        return this.J.getBackground();
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView h() {
        return this.f1415h;
    }

    public void j(int i10) {
        this.f1419l = i10;
        this.f1421n = true;
    }

    public void l(int i10) {
        this.f1418k = i10;
    }

    public int n() {
        if (this.f1421n) {
            return this.f1419l;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1430w;
        if (dataSetObserver == null) {
            this.f1430w = new f();
        } else {
            ListAdapter listAdapter2 = this.f1414g;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1414g = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1430w);
        }
        h0 h0Var = this.f1415h;
        if (h0Var != null) {
            h0Var.setAdapter(this.f1414g);
        }
    }

    public void r() {
        h0 h0Var = this.f1415h;
        if (h0Var != null) {
            h0Var.setListSelectionHidden(true);
            h0Var.requestLayout();
        }
    }

    h0 s(Context context, boolean z10) {
        return new h0(context, z10);
    }

    public View t() {
        return this.f1431x;
    }

    public int v() {
        return this.f1417j;
    }

    public boolean w() {
        return this.J.getInputMethodMode() == 2;
    }

    public boolean x() {
        return this.I;
    }

    public void z(View view) {
        this.f1431x = view;
    }
}
