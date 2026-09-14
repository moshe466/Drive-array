package e6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.a0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c implements e, View.OnTouchListener, g {

    /* renamed from: f, reason: collision with root package name */
    private final Context f9197f;

    /* renamed from: g, reason: collision with root package name */
    private final Resources f9198g;

    /* renamed from: h, reason: collision with root package name */
    private final WindowManager f9199h;

    /* renamed from: j, reason: collision with root package name */
    private e6.a f9201j;

    /* renamed from: k, reason: collision with root package name */
    private final d f9202k;

    /* renamed from: l, reason: collision with root package name */
    private final f f9203l;

    /* renamed from: m, reason: collision with root package name */
    private final b f9204m;

    /* renamed from: s, reason: collision with root package name */
    private boolean f9210s = true;

    /* renamed from: t, reason: collision with root package name */
    private int f9211t = -1;

    /* renamed from: i, reason: collision with root package name */
    private final DisplayMetrics f9200i = new DisplayMetrics();

    /* renamed from: n, reason: collision with root package name */
    private final Rect f9205n = new Rect();

    /* renamed from: o, reason: collision with root package name */
    private final Rect f9206o = new Rect();

    /* renamed from: p, reason: collision with root package name */
    private boolean f9207p = false;

    /* renamed from: q, reason: collision with root package name */
    private int f9208q = 3;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f9209r = new Rect();

    /* renamed from: u, reason: collision with root package name */
    private final ArrayList<e6.a> f9212u = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public float f9213a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        public int f9214b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f9215c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        public int f9216d = Integer.MIN_VALUE;

        /* renamed from: e, reason: collision with root package name */
        public int f9217e = -2;

        /* renamed from: f, reason: collision with root package name */
        public int f9218f = -2;

        /* renamed from: g, reason: collision with root package name */
        public int f9219g = 0;

        /* renamed from: h, reason: collision with root package name */
        public boolean f9220h = true;

        /* renamed from: i, reason: collision with root package name */
        public boolean f9221i = true;
    }

    public c(Context context, b bVar) {
        this.f9197f = context;
        this.f9198g = context.getResources();
        this.f9199h = (WindowManager) context.getSystemService("window");
        this.f9204m = bVar;
        this.f9202k = new d(context, this);
        this.f9203l = new f(context);
    }

    private boolean f() {
        if (!this.f9203l.n()) {
            return false;
        }
        this.f9203l.k(this.f9206o);
        this.f9201j.n(this.f9205n);
        return Rect.intersects(this.f9206o, this.f9205n);
    }

    private void h(View view) {
        if (a0.R(view)) {
            this.f9199h.removeViewImmediate(view);
        }
    }

    private void i(e6.a aVar) {
        b bVar;
        int indexOf = this.f9212u.indexOf(aVar);
        if (indexOf != -1) {
            h(aVar);
            this.f9212u.remove(indexOf);
        }
        if (!this.f9212u.isEmpty() || (bVar = this.f9204m) == null) {
            return;
        }
        bVar.a();
    }

    @Override // e6.g
    public void a(int i10) {
        if (i10 == 2 || i10 == 3) {
            int size = this.f9212u.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f9212u.get(i11).z(false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        if ((r7.bottom - r3.heightPixels) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0064, code lost:
    
        if ((r7.height() - r6.f9200i.heightPixels) <= 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0069, code lost:
    
        if ((r8 & 2) == 2) goto L23;
     */
    @Override // e6.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.graphics.Rect r7, int r8) {
        /*
            r6 = this;
            int r0 = r7.top
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 15
            r5 = -1
            if (r3 > r4) goto L1d
            if (r8 == r5) goto L1d
            if (r0 != 0) goto L1b
            r4 = r8 & 1
            if (r4 != r2) goto L19
            goto L1b
        L19:
            r4 = 0
            goto L1e
        L1b:
            r4 = 1
            goto L1e
        L1d:
            r4 = r0
        L1e:
            if (r8 != r5) goto L67
            r8 = 17
            if (r3 < r8) goto L45
            android.view.WindowManager r8 = r6.f9199h
            android.view.Display r8 = r8.getDefaultDisplay()
            android.util.DisplayMetrics r3 = r6.f9200i
            r8.getRealMetrics(r3)
            int r8 = r7.width()
            android.util.DisplayMetrics r3 = r6.f9200i
            int r5 = r3.widthPixels
            int r8 = r8 - r5
            if (r8 != 0) goto L43
            int r8 = r7.bottom
            int r3 = r3.heightPixels
            int r8 = r8 - r3
            if (r8 != 0) goto L43
        L41:
            r8 = 1
            goto L6c
        L43:
            r8 = 0
            goto L6c
        L45:
            android.view.WindowManager r8 = r6.f9199h
            android.view.Display r8 = r8.getDefaultDisplay()
            android.util.DisplayMetrics r3 = r6.f9200i
            r8.getMetrics(r3)
            int r8 = r7.width()
            android.util.DisplayMetrics r3 = r6.f9200i
            int r3 = r3.widthPixels
            int r8 = r8 - r3
            if (r8 > 0) goto L41
            int r8 = r7.height()
            android.util.DisplayMetrics r3 = r6.f9200i
            int r3 = r3.heightPixels
            int r8 = r8 - r3
            if (r8 <= 0) goto L43
            goto L41
        L67:
            r3 = 2
            r8 = r8 & r3
            if (r8 != r3) goto L43
            goto L41
        L6c:
            android.content.res.Resources r3 = r6.f9198g
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.orientation
            if (r3 != r2) goto L78
            r3 = 1
            goto L79
        L78:
            r3 = 0
        L79:
            e6.a r5 = r6.f9201j
            r5.w(r4, r8, r3, r7)
            int r7 = r6.f9208q
            r8 = 3
            if (r7 == r8) goto L84
            return
        L84:
            r6.f9207p = r1
            e6.a r7 = r6.f9201j
            int r7 = r7.l()
            if (r7 != 0) goto Lab
            java.util.ArrayList<e6.a> r7 = r6.f9212u
            int r7 = r7.size()
            r8 = 0
        L95:
            if (r8 >= r7) goto Lb2
            java.util.ArrayList<e6.a> r2 = r6.f9212u
            java.lang.Object r2 = r2.get(r8)
            e6.a r2 = (e6.a) r2
            if (r0 == 0) goto La4
            r3 = 8
            goto La5
        La4:
            r3 = 0
        La5:
            r2.setVisibility(r3)
            int r8 = r8 + 1
            goto L95
        Lab:
            if (r7 != r2) goto Lb7
            e6.a r7 = r6.f9201j
            r7.A()
        Lb2:
            e6.f r7 = r6.f9203l
            r7.h()
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.c.b(android.graphics.Rect, int):void");
    }

    @Override // e6.g
    public void c() {
        this.f9203l.v(this.f9201j.getMeasuredWidth(), this.f9201j.getMeasuredHeight(), this.f9201j.k());
    }

    @Override // e6.g
    public void d(int i10) {
        if (this.f9201j.l() == 2) {
            i(this.f9201j);
        }
        int size = this.f9212u.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f9212u.get(i11).z(true);
        }
    }

    public void e(View view, a aVar, Rect rect) {
        boolean isEmpty = this.f9212u.isEmpty();
        e6.a aVar2 = new e6.a(this.f9197f);
        aVar2.G(rect);
        aVar2.E(this.f9210s);
        aVar2.C(aVar.f9215c, aVar.f9216d);
        aVar2.setOnTouchListener(this);
        aVar2.L(aVar.f9213a);
        aVar2.I(aVar.f9214b);
        aVar2.F(aVar.f9219g);
        aVar2.Y(aVar.f9220h);
        aVar2.y(aVar.f9221i);
        aVar2.J(this.f9209r);
        int i10 = this.f9211t;
        if (i10 > -1) {
            aVar2.B(i10);
        }
        view.setLayoutParams(new FrameLayout.LayoutParams(aVar.f9217e, aVar.f9218f));
        aVar2.addView(view);
        if (this.f9208q == 2) {
            aVar2.setVisibility(8);
        }
        this.f9212u.add(aVar2);
        this.f9203l.u(this);
        this.f9199h.addView(aVar2, aVar2.o());
        if (isEmpty) {
            WindowManager windowManager = this.f9199h;
            d dVar = this.f9202k;
            windowManager.addView(dVar, dVar.a());
            this.f9201j = aVar2;
        } else {
            h(this.f9203l);
        }
        WindowManager windowManager2 = this.f9199h;
        f fVar = this.f9203l;
        windowManager2.addView(fVar, fVar.l());
    }

    public void g() {
        h(this.f9202k);
        h(this.f9203l);
        int size = this.f9212u.size();
        for (int i10 = 0; i10 < size; i10++) {
            h(this.f9212u.get(i10));
        }
        this.f9212u.clear();
    }

    public void j(int i10) {
        this.f9203l.p(i10);
    }

    public void k(int i10) {
        this.f9208q = i10;
        if (i10 == 1 || i10 == 3) {
            Iterator<e6.a> it = this.f9212u.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(0);
            }
        } else if (i10 == 2) {
            Iterator<e6.a> it2 = this.f9212u.iterator();
            while (it2.hasNext()) {
                it2.next().setVisibility(8);
            }
            this.f9203l.h();
        }
    }

    public void l(int i10) {
        this.f9203l.q(i10);
    }

    public void m(int i10) {
        this.f9211t = i10;
    }

    public void n(boolean z10) {
        this.f9210s = z10;
    }

    public void o(boolean z10) {
        this.f9203l.t(z10);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && !this.f9207p) {
            return false;
        }
        int l10 = this.f9201j.l();
        e6.a aVar = (e6.a) view;
        this.f9201j = aVar;
        if (action == 0) {
            this.f9207p = true;
        } else if (action == 2) {
            boolean f10 = f();
            boolean z10 = l10 == 1;
            if (f10) {
                this.f9201j.D((int) this.f9203l.i(), (int) this.f9203l.j());
            }
            if (f10 && !z10) {
                this.f9201j.performHapticFeedback(0);
                this.f9203l.r(true);
            } else if (!f10 && z10) {
                this.f9201j.H();
                this.f9203l.r(false);
            }
        } else if (action == 1 || action == 3) {
            if (l10 == 1) {
                aVar.A();
                this.f9203l.r(false);
                this.f9204m.c(0);
            }
            this.f9207p = false;
            if (this.f9204m != null) {
                boolean z11 = this.f9201j.l() == 2;
                WindowManager.LayoutParams o10 = this.f9201j.o();
                this.f9204m.b(z11, o10.x, o10.y);
            }
        }
        if (l10 == 1) {
            f fVar = this.f9203l;
            Rect rect = this.f9205n;
            fVar.o(motionEvent, rect.left, rect.top);
        } else {
            WindowManager.LayoutParams o11 = this.f9201j.o();
            this.f9203l.o(motionEvent, o11.x, o11.y);
        }
        return false;
    }
}
