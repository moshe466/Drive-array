package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.m0;
import androidx.appcompat.widget.n0;
import androidx.core.view.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends k implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int G = e.g.f8960e;
    private boolean B;
    private m.a C;
    ViewTreeObserver D;
    private PopupWindow.OnDismissListener E;
    boolean F;

    /* renamed from: g, reason: collision with root package name */
    private final Context f877g;

    /* renamed from: h, reason: collision with root package name */
    private final int f878h;

    /* renamed from: i, reason: collision with root package name */
    private final int f879i;

    /* renamed from: j, reason: collision with root package name */
    private final int f880j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f881k;

    /* renamed from: l, reason: collision with root package name */
    final Handler f882l;

    /* renamed from: t, reason: collision with root package name */
    private View f890t;

    /* renamed from: u, reason: collision with root package name */
    View f891u;

    /* renamed from: w, reason: collision with root package name */
    private boolean f893w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f894x;

    /* renamed from: y, reason: collision with root package name */
    private int f895y;

    /* renamed from: z, reason: collision with root package name */
    private int f896z;

    /* renamed from: m, reason: collision with root package name */
    private final List<g> f883m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    final List<C0020d> f884n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f885o = new a();

    /* renamed from: p, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f886p = new b();

    /* renamed from: q, reason: collision with root package name */
    private final m0 f887q = new c();

    /* renamed from: r, reason: collision with root package name */
    private int f888r = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f889s = 0;
    private boolean A = false;

    /* renamed from: v, reason: collision with root package name */
    private int f892v = D();

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.c() || d.this.f884n.size() <= 0 || d.this.f884n.get(0).f904a.x()) {
                return;
            }
            View view = d.this.f891u;
            if (view == null || !view.isShown()) {
                d.this.dismiss();
                return;
            }
            Iterator<C0020d> it = d.this.f884n.iterator();
            while (it.hasNext()) {
                it.next().f904a.a();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.D;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.D = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.D.removeGlobalOnLayoutListener(dVar.f885o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    class c implements m0 {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ C0020d f900f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ MenuItem f901g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ g f902h;

            a(C0020d c0020d, MenuItem menuItem, g gVar) {
                this.f900f = c0020d;
                this.f901g = menuItem;
                this.f902h = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0020d c0020d = this.f900f;
                if (c0020d != null) {
                    d.this.F = true;
                    c0020d.f905b.e(false);
                    d.this.F = false;
                }
                if (this.f901g.isEnabled() && this.f901g.hasSubMenu()) {
                    this.f902h.L(this.f901g, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.m0
        public void e(g gVar, MenuItem menuItem) {
            d.this.f882l.removeCallbacksAndMessages(null);
            int size = d.this.f884n.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (gVar == d.this.f884n.get(i10).f905b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 == -1) {
                return;
            }
            int i11 = i10 + 1;
            d.this.f882l.postAtTime(new a(i11 < d.this.f884n.size() ? d.this.f884n.get(i11) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.m0
        public void f(g gVar, MenuItem menuItem) {
            d.this.f882l.removeCallbacksAndMessages(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.view.menu.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0020d {

        /* renamed from: a, reason: collision with root package name */
        public final n0 f904a;

        /* renamed from: b, reason: collision with root package name */
        public final g f905b;

        /* renamed from: c, reason: collision with root package name */
        public final int f906c;

        public C0020d(n0 n0Var, g gVar, int i10) {
            this.f904a = n0Var;
            this.f905b = gVar;
            this.f906c = i10;
        }

        public ListView a() {
            return this.f904a.h();
        }
    }

    public d(Context context, View view, int i10, int i11, boolean z10) {
        this.f877g = context;
        this.f890t = view;
        this.f879i = i10;
        this.f880j = i11;
        this.f881k = z10;
        Resources resources = context.getResources();
        this.f878h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.d.f8892d));
        this.f882l = new Handler();
    }

    private int A(g gVar) {
        int size = this.f884n.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (gVar == this.f884n.get(i10).f905b) {
                return i10;
            }
        }
        return -1;
    }

    private MenuItem B(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = gVar.getItem(i10);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(C0020d c0020d, g gVar) {
        f fVar;
        int i10;
        int firstVisiblePosition;
        MenuItem B = B(c0020d.f905b, gVar);
        if (B == null) {
            return null;
        }
        ListView a10 = c0020d.a();
        ListAdapter adapter = a10.getAdapter();
        int i11 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i10 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i10 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i11 >= count) {
                i11 = -1;
                break;
            }
            if (B == fVar.getItem(i11)) {
                break;
            }
            i11++;
        }
        if (i11 != -1 && (firstVisiblePosition = (i11 + i10) - a10.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a10.getChildCount()) {
            return a10.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return a0.z(this.f890t) == 1 ? 0 : 1;
    }

    private int E(int i10) {
        List<C0020d> list = this.f884n;
        ListView a10 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a10.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f891u.getWindowVisibleDisplayFrame(rect);
        return this.f892v == 1 ? (iArr[0] + a10.getWidth()) + i10 > rect.right ? 0 : 1 : iArr[0] - i10 < 0 ? 1 : 0;
    }

    private void F(g gVar) {
        C0020d c0020d;
        View view;
        int i10;
        int i11;
        int i12;
        LayoutInflater from = LayoutInflater.from(this.f877g);
        f fVar = new f(gVar, from, this.f881k, G);
        if (!c() && this.A) {
            fVar.d(true);
        } else if (c()) {
            fVar.d(k.x(gVar));
        }
        int o10 = k.o(fVar, null, this.f877g, this.f878h);
        n0 z10 = z();
        z10.p(fVar);
        z10.B(o10);
        z10.C(this.f889s);
        if (this.f884n.size() > 0) {
            List<C0020d> list = this.f884n;
            c0020d = list.get(list.size() - 1);
            view = C(c0020d, gVar);
        } else {
            c0020d = null;
            view = null;
        }
        if (view != null) {
            z10.Q(false);
            z10.N(null);
            int E = E(o10);
            boolean z11 = E == 1;
            this.f892v = E;
            if (Build.VERSION.SDK_INT >= 26) {
                z10.z(view);
                i11 = 0;
                i10 = 0;
            } else {
                int[] iArr = new int[2];
                this.f890t.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f889s & 7) == 5) {
                    iArr[0] = iArr[0] + this.f890t.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i10 = iArr2[0] - iArr[0];
                i11 = iArr2[1] - iArr[1];
            }
            if ((this.f889s & 5) == 5) {
                if (!z11) {
                    o10 = view.getWidth();
                    i12 = i10 - o10;
                }
                i12 = i10 + o10;
            } else {
                if (z11) {
                    o10 = view.getWidth();
                    i12 = i10 + o10;
                }
                i12 = i10 - o10;
            }
            z10.l(i12);
            z10.I(true);
            z10.j(i11);
        } else {
            if (this.f893w) {
                z10.l(this.f895y);
            }
            if (this.f894x) {
                z10.j(this.f896z);
            }
            z10.D(n());
        }
        this.f884n.add(new C0020d(z10, gVar, this.f892v));
        z10.a();
        ListView h10 = z10.h();
        h10.setOnKeyListener(this);
        if (c0020d == null && this.B && gVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(e.g.f8967l, (ViewGroup) h10, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.x());
            h10.addHeaderView(frameLayout, null, false);
            z10.a();
        }
    }

    private n0 z() {
        n0 n0Var = new n0(this.f877g, null, this.f879i, this.f880j);
        n0Var.P(this.f887q);
        n0Var.H(this);
        n0Var.G(this);
        n0Var.z(this.f890t);
        n0Var.C(this.f889s);
        n0Var.F(true);
        n0Var.E(2);
        return n0Var;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        if (c()) {
            return;
        }
        Iterator<g> it = this.f883m.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        this.f883m.clear();
        View view = this.f890t;
        this.f891u = view;
        if (view != null) {
            boolean z10 = this.D == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.D = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f885o);
            }
            this.f891u.addOnAttachStateChangeListener(this.f886p);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z10) {
        int A = A(gVar);
        if (A < 0) {
            return;
        }
        int i10 = A + 1;
        if (i10 < this.f884n.size()) {
            this.f884n.get(i10).f905b.e(false);
        }
        C0020d remove = this.f884n.remove(A);
        remove.f905b.O(this);
        if (this.F) {
            remove.f904a.O(null);
            remove.f904a.A(0);
        }
        remove.f904a.dismiss();
        int size = this.f884n.size();
        this.f892v = size > 0 ? this.f884n.get(size - 1).f906c : D();
        if (size != 0) {
            if (z10) {
                this.f884n.get(0).f905b.e(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.C;
        if (aVar != null) {
            aVar.b(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.D;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.D.removeGlobalOnLayoutListener(this.f885o);
            }
            this.D = null;
        }
        this.f891u.removeOnAttachStateChangeListener(this.f886p);
        this.E.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return this.f884n.size() > 0 && this.f884n.get(0).f904a.c();
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        int size = this.f884n.size();
        if (size > 0) {
            C0020d[] c0020dArr = (C0020d[]) this.f884n.toArray(new C0020d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                C0020d c0020d = c0020dArr[i10];
                if (c0020d.f904a.c()) {
                    c0020d.f904a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        for (C0020d c0020d : this.f884n) {
            if (rVar == c0020d.f905b) {
                c0020d.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        l(rVar);
        m.a aVar = this.C;
        if (aVar != null) {
            aVar.c(rVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z10) {
        Iterator<C0020d> it = this.f884n.iterator();
        while (it.hasNext()) {
            k.y(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView h() {
        if (this.f884n.isEmpty()) {
            return null;
        }
        return this.f884n.get(r0.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.C = aVar;
    }

    @Override // androidx.appcompat.view.menu.k
    public void l(g gVar) {
        gVar.c(this, this.f877g);
        if (c()) {
            F(gVar);
        } else {
            this.f883m.add(gVar);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    protected boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0020d c0020d;
        int size = this.f884n.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                c0020d = null;
                break;
            }
            c0020d = this.f884n.get(i10);
            if (!c0020d.f904a.c()) {
                break;
            } else {
                i10++;
            }
        }
        if (c0020d != null) {
            c0020d.f905b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void p(View view) {
        if (this.f890t != view) {
            this.f890t = view;
            this.f889s = androidx.core.view.e.b(this.f888r, a0.z(view));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(boolean z10) {
        this.A = z10;
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(int i10) {
        if (this.f888r != i10) {
            this.f888r = i10;
            this.f889s = androidx.core.view.e.b(i10, a0.z(this.f890t));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i10) {
        this.f893w = true;
        this.f895y = i10;
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.E = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(boolean z10) {
        this.B = z10;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i10) {
        this.f894x = true;
        this.f896z = i10;
    }
}
