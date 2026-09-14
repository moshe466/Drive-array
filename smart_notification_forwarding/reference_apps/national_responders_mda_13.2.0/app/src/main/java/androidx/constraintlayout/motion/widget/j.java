package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.l;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class j extends ConstraintLayout implements r {

    /* renamed from: w0, reason: collision with root package name */
    public static boolean f1650w0;
    Interpolator A;
    Interpolator B;
    float C;
    private int D;
    int E;
    private int F;
    private boolean G;
    HashMap<View, g> H;
    private long I;
    private float J;
    float K;
    float L;
    private long M;
    float N;
    private boolean O;
    boolean P;
    private d Q;
    int R;
    private boolean S;
    private r.b T;
    private androidx.constraintlayout.motion.widget.b U;
    boolean V;
    float W;

    /* renamed from: a0, reason: collision with root package name */
    float f1651a0;

    /* renamed from: b0, reason: collision with root package name */
    long f1652b0;

    /* renamed from: c0, reason: collision with root package name */
    float f1653c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f1654d0;

    /* renamed from: e0, reason: collision with root package name */
    private ArrayList<h> f1655e0;

    /* renamed from: f0, reason: collision with root package name */
    private ArrayList<h> f1656f0;

    /* renamed from: g0, reason: collision with root package name */
    private ArrayList<h> f1657g0;

    /* renamed from: h0, reason: collision with root package name */
    private CopyOnWriteArrayList<d> f1658h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f1659i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f1660j0;

    /* renamed from: k0, reason: collision with root package name */
    protected boolean f1661k0;

    /* renamed from: l0, reason: collision with root package name */
    float f1662l0;

    /* renamed from: m0, reason: collision with root package name */
    private n.c f1663m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f1664n0;

    /* renamed from: o0, reason: collision with root package name */
    private c f1665o0;

    /* renamed from: p0, reason: collision with root package name */
    private Runnable f1666p0;

    /* renamed from: q0, reason: collision with root package name */
    private int[] f1667q0;

    /* renamed from: r0, reason: collision with root package name */
    int f1668r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f1669s0;

    /* renamed from: t0, reason: collision with root package name */
    e f1670t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f1671u0;

    /* renamed from: v0, reason: collision with root package name */
    ArrayList<Integer> f1672v0;

    /* renamed from: z, reason: collision with root package name */
    l f1673z;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f1665o0.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1675a;

        static {
            int[] iArr = new int[e.values().length];
            f1675a = iArr;
            try {
                iArr[e.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1675a[e.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1675a[e.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1675a[e.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        float f1676a = Float.NaN;

        /* renamed from: b, reason: collision with root package name */
        float f1677b = Float.NaN;

        /* renamed from: c, reason: collision with root package name */
        int f1678c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f1679d = -1;

        c() {
        }

        void a() {
            int i10 = this.f1678c;
            if (i10 != -1 || this.f1679d != -1) {
                if (i10 == -1) {
                    j.this.N(this.f1679d);
                } else {
                    int i11 = this.f1679d;
                    if (i11 == -1) {
                        j.this.K(i10, -1, -1);
                    } else {
                        j.this.L(i10, i11);
                    }
                }
                j.this.setState(e.SETUP);
            }
            if (Float.isNaN(this.f1677b)) {
                if (Float.isNaN(this.f1676a)) {
                    return;
                }
                j.this.setProgress(this.f1676a);
            } else {
                j.this.J(this.f1676a, this.f1677b);
                this.f1676a = Float.NaN;
                this.f1677b = Float.NaN;
                this.f1678c = -1;
                this.f1679d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f1676a);
            bundle.putFloat("motion.velocity", this.f1677b);
            bundle.putInt("motion.StartState", this.f1678c);
            bundle.putInt("motion.EndState", this.f1679d);
            return bundle;
        }

        public void c() {
            this.f1679d = j.this.F;
            this.f1678c = j.this.D;
            this.f1677b = j.this.getVelocity();
            this.f1676a = j.this.getProgress();
        }

        public void d(int i10) {
            this.f1679d = i10;
        }

        public void e(float f10) {
            this.f1676a = f10;
        }

        public void f(int i10) {
            this.f1678c = i10;
        }

        public void g(Bundle bundle) {
            this.f1676a = bundle.getFloat("motion.progress");
            this.f1677b = bundle.getFloat("motion.velocity");
            this.f1678c = bundle.getInt("motion.StartState");
            this.f1679d = bundle.getInt("motion.EndState");
        }

        public void h(float f10) {
            this.f1677b = f10;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(j jVar, int i10, int i11, float f10);

        void b(j jVar, int i10, int i11);

        void c(j jVar, int i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum e {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    private void F() {
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if ((this.Q == null && ((copyOnWriteArrayList = this.f1658h0) == null || copyOnWriteArrayList.isEmpty())) || this.f1660j0 == this.K) {
            return;
        }
        if (this.f1659i0 != -1) {
            d dVar = this.Q;
            if (dVar != null) {
                dVar.b(this, this.D, this.F);
            }
            CopyOnWriteArrayList<d> copyOnWriteArrayList2 = this.f1658h0;
            if (copyOnWriteArrayList2 != null) {
                Iterator<d> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().b(this, this.D, this.F);
                }
            }
        }
        this.f1659i0 = -1;
        float f10 = this.K;
        this.f1660j0 = f10;
        d dVar2 = this.Q;
        if (dVar2 != null) {
            dVar2.a(this, this.D, this.F, f10);
        }
        CopyOnWriteArrayList<d> copyOnWriteArrayList3 = this.f1658h0;
        if (copyOnWriteArrayList3 != null) {
            Iterator<d> it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().a(this, this.D, this.F, this.K);
            }
        }
    }

    private void I() {
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if (this.Q == null && ((copyOnWriteArrayList = this.f1658h0) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        Iterator<Integer> it = this.f1672v0.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            d dVar = this.Q;
            if (dVar != null) {
                dVar.c(this, next.intValue());
            }
            CopyOnWriteArrayList<d> copyOnWriteArrayList2 = this.f1658h0;
            if (copyOnWriteArrayList2 != null) {
                Iterator<d> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().c(this, next.intValue());
                }
            }
        }
        this.f1672v0.clear();
    }

    void D(float f10) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x021e, code lost:
    
        if (r1 != r2) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0221, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0222, code lost:
    
        r23.E = r2;
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x022e, code lost:
    
        if (r1 != r2) goto L160;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void E(boolean r24) {
        /*
            Method dump skipped, instructions count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.j.E(boolean):void");
    }

    protected void G() {
        int i10;
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if ((this.Q != null || ((copyOnWriteArrayList = this.f1658h0) != null && !copyOnWriteArrayList.isEmpty())) && this.f1659i0 == -1) {
            this.f1659i0 = this.E;
            if (this.f1672v0.isEmpty()) {
                i10 = -1;
            } else {
                ArrayList<Integer> arrayList = this.f1672v0;
                i10 = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i11 = this.E;
            if (i10 != i11 && i11 != -1) {
                this.f1672v0.add(Integer.valueOf(i11));
            }
        }
        I();
        Runnable runnable = this.f1666p0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f1667q0;
        if (iArr == null || this.f1668r0 <= 0) {
            return;
        }
        N(iArr[0]);
        int[] iArr2 = this.f1667q0;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.f1668r0--;
    }

    void H() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r4 > 0.0f) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        r0 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        D(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        if (r3 > 0.5f) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void J(float r3, float r4) {
        /*
            r2 = this;
            boolean r0 = r2.isAttachedToWindow()
            if (r0 != 0) goto L1c
            androidx.constraintlayout.motion.widget.j$c r0 = r2.f1665o0
            if (r0 != 0) goto L11
            androidx.constraintlayout.motion.widget.j$c r0 = new androidx.constraintlayout.motion.widget.j$c
            r0.<init>()
            r2.f1665o0 = r0
        L11:
            androidx.constraintlayout.motion.widget.j$c r0 = r2.f1665o0
            r0.e(r3)
            androidx.constraintlayout.motion.widget.j$c r3 = r2.f1665o0
            r3.h(r4)
            return
        L1c:
            r2.setProgress(r3)
            androidx.constraintlayout.motion.widget.j$e r0 = androidx.constraintlayout.motion.widget.j.e.MOVING
            r2.setState(r0)
            r2.C = r4
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 == 0) goto L35
            if (r4 <= 0) goto L30
            goto L31
        L30:
            r0 = 0
        L31:
            r2.D(r0)
            goto L44
        L35:
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 == 0) goto L44
            int r4 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r4 == 0) goto L44
            r4 = 1056964608(0x3f000000, float:0.5)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L30
            goto L31
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.j.J(float, float):void");
    }

    public void K(int i10, int i11, int i12) {
        setState(e.SETUP);
        this.E = i10;
        this.D = -1;
        this.F = -1;
        androidx.constraintlayout.widget.d dVar = this.f1709p;
        if (dVar != null) {
            dVar.d(i10, i11, i12);
        }
    }

    public void L(int i10, int i11) {
        if (isAttachedToWindow()) {
            return;
        }
        if (this.f1665o0 == null) {
            this.f1665o0 = new c();
        }
        this.f1665o0.f(i10);
        this.f1665o0.d(i11);
    }

    public void M() {
        D(1.0f);
        this.f1666p0 = null;
    }

    public void N(int i10) {
        if (isAttachedToWindow()) {
            O(i10, -1, -1);
            return;
        }
        if (this.f1665o0 == null) {
            this.f1665o0 = new c();
        }
        this.f1665o0.d(i10);
    }

    public void O(int i10, int i11, int i12) {
        P(i10, i11, i12, -1);
    }

    public void P(int i10, int i11, int i12, int i13) {
        int i14 = this.E;
        if (i14 == i10) {
            return;
        }
        if (this.D == i10) {
            D(0.0f);
            if (i13 > 0) {
                this.J = i13 / 1000.0f;
                return;
            }
            return;
        }
        if (this.F == i10) {
            D(1.0f);
            if (i13 > 0) {
                this.J = i13 / 1000.0f;
                return;
            }
            return;
        }
        this.F = i10;
        if (i14 != -1) {
            L(i14, i10);
            D(1.0f);
            this.L = 0.0f;
            M();
            if (i13 > 0) {
                this.J = i13 / 1000.0f;
                return;
            }
            return;
        }
        this.S = false;
        this.N = 1.0f;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = getNanoTime();
        this.I = getNanoTime();
        this.O = false;
        this.A = null;
        if (i13 == -1) {
            throw null;
        }
        this.D = -1;
        throw null;
    }

    @Override // androidx.core.view.q
    public void c(View view, View view2, int i10, int i11) {
        this.f1652b0 = getNanoTime();
        this.f1653c0 = 0.0f;
        this.W = 0.0f;
        this.f1651a0 = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        ArrayList<h> arrayList = this.f1657g0;
        if (arrayList != null) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().w(canvas);
            }
        }
        E(false);
        super.dispatchDraw(canvas);
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.E;
    }

    public ArrayList<l.a> getDefinedTransitions() {
        return null;
    }

    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.U == null) {
            this.U = new androidx.constraintlayout.motion.widget.b(this);
        }
        return this.U;
    }

    public int getEndState() {
        return this.F;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.L;
    }

    public l getScene() {
        return this.f1673z;
    }

    public int getStartState() {
        return this.D;
    }

    public float getTargetPosition() {
        return this.N;
    }

    public Bundle getTransitionState() {
        if (this.f1665o0 == null) {
            this.f1665o0 = new c();
        }
        this.f1665o0.c();
        return this.f1665o0.b();
    }

    public long getTransitionTimeMs() {
        return this.J * 1000.0f;
    }

    public float getVelocity() {
        return this.C;
    }

    @Override // androidx.core.view.q
    public void i(View view, int i10) {
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return Build.VERSION.SDK_INT >= 19 ? super.isAttachedToWindow() : getWindowToken() != null;
    }

    @Override // androidx.core.view.q
    public void j(View view, int i10, int i11, int[] iArr, int i12) {
    }

    @Override // androidx.core.view.r
    public void m(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (this.V || i10 != 0 || i11 != 0) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
        }
        this.V = false;
    }

    @Override // androidx.core.view.q
    public void n(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    @Override // androidx.core.view.q
    public boolean o(View view, View view2, int i10, int i11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Display display;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 17 && (display = getDisplay()) != null) {
            display.getRotation();
        }
        H();
        c cVar = this.f1665o0;
        if (cVar != null) {
            if (this.f1669s0) {
                post(new a());
            } else {
                cVar.a();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f1664n0 = true;
        try {
            super.onLayout(z10, i10, i11, i12, i13);
        } finally {
            this.f1664n0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.s
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof h) {
            h hVar = (h) view;
            if (this.f1658h0 == null) {
                this.f1658h0 = new CopyOnWriteArrayList<>();
            }
            this.f1658h0.add(hVar);
            if (hVar.v()) {
                if (this.f1655e0 == null) {
                    this.f1655e0 = new ArrayList<>();
                }
                this.f1655e0.add(hVar);
            }
            if (hVar.u()) {
                if (this.f1656f0 == null) {
                    this.f1656f0 = new ArrayList<>();
                }
                this.f1656f0.add(hVar);
            }
            if (hVar.t()) {
                if (this.f1657g0 == null) {
                    this.f1657g0 = new ArrayList<>();
                }
                this.f1657g0.add(hVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<h> arrayList = this.f1655e0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<h> arrayList2 = this.f1656f0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f1661k0) {
            int i10 = this.E;
        }
        super.requestLayout();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void s(int i10) {
        this.f1709p = null;
    }

    public void setDebugMode(int i10) {
        this.R = i10;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z10) {
        this.f1669s0 = z10;
    }

    public void setInteractionEnabled(boolean z10) {
        this.G = z10;
    }

    public void setInterpolatedProgress(float f10) {
        setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList<h> arrayList = this.f1656f0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f1656f0.get(i10).setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList<h> arrayList = this.f1655e0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f1655e0.get(i10).setProgress(f10);
            }
        }
    }

    public void setProgress(float f10) {
        e eVar;
        if (f10 >= 0.0f) {
            int i10 = (f10 > 1.0f ? 1 : (f10 == 1.0f ? 0 : -1));
        }
        if (!isAttachedToWindow()) {
            if (this.f1665o0 == null) {
                this.f1665o0 = new c();
            }
            this.f1665o0.e(f10);
            return;
        }
        if (f10 <= 0.0f) {
            if (this.L == 1.0f && this.E == this.F) {
                setState(e.MOVING);
            }
            this.E = this.D;
            if (this.L != 0.0f) {
                return;
            }
        } else if (f10 < 1.0f) {
            this.E = -1;
            eVar = e.MOVING;
            setState(eVar);
        } else {
            if (this.L == 0.0f && this.E == this.D) {
                setState(e.MOVING);
            }
            this.E = this.F;
            if (this.L != 1.0f) {
                return;
            }
        }
        eVar = e.FINISHED;
        setState(eVar);
    }

    public void setScene(l lVar) {
        q();
        throw null;
    }

    void setStartState(int i10) {
        if (isAttachedToWindow()) {
            this.E = i10;
            return;
        }
        if (this.f1665o0 == null) {
            this.f1665o0 = new c();
        }
        this.f1665o0.f(i10);
        this.f1665o0.d(i10);
    }

    void setState(e eVar) {
        e eVar2 = e.FINISHED;
        if (eVar == eVar2 && this.E == -1) {
            return;
        }
        e eVar3 = this.f1670t0;
        this.f1670t0 = eVar;
        e eVar4 = e.MOVING;
        if (eVar3 == eVar4 && eVar == eVar4) {
            F();
        }
        int i10 = b.f1675a[eVar3.ordinal()];
        if (i10 == 1 || i10 == 2) {
            if (eVar == eVar4) {
                F();
            }
            if (eVar != eVar2) {
                return;
            }
        } else if (i10 != 3 || eVar != eVar2) {
            return;
        }
        G();
    }

    public void setTransition(int i10) {
    }

    protected void setTransition(l.a aVar) {
        throw null;
    }

    public void setTransitionDuration(int i10) {
    }

    public void setTransitionListener(d dVar) {
        this.Q = dVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f1665o0 == null) {
            this.f1665o0 = new c();
        }
        this.f1665o0.g(bundle);
        if (isAttachedToWindow()) {
            this.f1665o0.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return androidx.constraintlayout.motion.widget.a.a(context, this.D) + "->" + androidx.constraintlayout.motion.widget.a.a(context, this.F) + " (pos:" + this.L + " Dpos/Dt:" + this.C;
    }
}
