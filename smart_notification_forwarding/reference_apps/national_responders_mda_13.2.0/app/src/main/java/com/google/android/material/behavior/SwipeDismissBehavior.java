package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.a0;
import z.a;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    z.a f6731a;

    /* renamed from: b, reason: collision with root package name */
    b f6732b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6733c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6735e;

    /* renamed from: d, reason: collision with root package name */
    private float f6734d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    int f6736f = 2;

    /* renamed from: g, reason: collision with root package name */
    float f6737g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    float f6738h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    float f6739i = 0.5f;

    /* renamed from: j, reason: collision with root package name */
    private final a.c f6740j = new a();

    /* loaded from: classes.dex */
    class a extends a.c {

        /* renamed from: a, reason: collision with root package name */
        private int f6741a;

        /* renamed from: b, reason: collision with root package name */
        private int f6742b = -1;

        a() {
        }

        private boolean n(View view, float f10) {
            if (f10 == 0.0f) {
                return Math.abs(view.getLeft() - this.f6741a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f6737g);
            }
            boolean z10 = a0.z(view) == 1;
            int i10 = SwipeDismissBehavior.this.f6736f;
            if (i10 == 2) {
                return true;
            }
            if (i10 == 0) {
                if (z10) {
                    if (f10 >= 0.0f) {
                        return false;
                    }
                } else if (f10 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i10 != 1) {
                return false;
            }
            if (z10) {
                if (f10 <= 0.0f) {
                    return false;
                }
            } else if (f10 >= 0.0f) {
                return false;
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        
            r5 = r2.f6741a;
            r3 = r3.getWidth() + r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        
            if (r5 != false) goto L10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
        
            if (r5 != false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        
            r5 = r2.f6741a - r3.getWidth();
            r3 = r2.f6741a;
         */
        @Override // z.a.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int a(android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = androidx.core.view.a0.z(r3)
                r0 = 1
                if (r5 != r0) goto L9
                r5 = 1
                goto La
            L9:
                r5 = 0
            La:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.f6736f
                if (r1 != 0) goto L24
                if (r5 == 0) goto L1c
            L12:
                int r5 = r2.f6741a
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.f6741a
                goto L37
            L1c:
                int r5 = r2.f6741a
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L37
            L24:
                if (r1 != r0) goto L29
                if (r5 == 0) goto L12
                goto L1c
            L29:
                int r5 = r2.f6741a
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.f6741a
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L37:
                int r3 = com.google.android.material.behavior.SwipeDismissBehavior.F(r5, r4, r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.a(android.view.View, int, int):int");
        }

        @Override // z.a.c
        public int b(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // z.a.c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // z.a.c
        public void i(View view, int i10) {
            this.f6742b = i10;
            this.f6741a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // z.a.c
        public void j(int i10) {
            b bVar = SwipeDismissBehavior.this.f6732b;
            if (bVar != null) {
                bVar.b(i10);
            }
        }

        @Override // z.a.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            float width = this.f6741a + (view.getWidth() * SwipeDismissBehavior.this.f6738h);
            float width2 = this.f6741a + (view.getWidth() * SwipeDismissBehavior.this.f6739i);
            float f10 = i10;
            if (f10 <= width) {
                view.setAlpha(1.0f);
            } else if (f10 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.E(0.0f, 1.0f - SwipeDismissBehavior.H(width, width2, f10), 1.0f));
            }
        }

        @Override // z.a.c
        public void l(View view, float f10, float f11) {
            int i10;
            boolean z10;
            b bVar;
            this.f6742b = -1;
            int width = view.getWidth();
            if (n(view, f10)) {
                int left = view.getLeft();
                int i11 = this.f6741a;
                i10 = left < i11 ? i11 - width : i11 + width;
                z10 = true;
            } else {
                i10 = this.f6741a;
                z10 = false;
            }
            if (SwipeDismissBehavior.this.f6731a.M(i10, view.getTop())) {
                a0.e0(view, new c(view, z10));
            } else {
                if (!z10 || (bVar = SwipeDismissBehavior.this.f6732b) == null) {
                    return;
                }
                bVar.a(view);
            }
        }

        @Override // z.a.c
        public boolean m(View view, int i10) {
            return this.f6742b == -1 && SwipeDismissBehavior.this.D(view);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(View view);

        void b(int i10);
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final View f6744f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f6745g;

        c(View view, boolean z10) {
            this.f6744f = view;
            this.f6745g = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            z.a aVar = SwipeDismissBehavior.this.f6731a;
            if (aVar != null && aVar.m(true)) {
                a0.e0(this.f6744f, this);
            } else {
                if (!this.f6745g || (bVar = SwipeDismissBehavior.this.f6732b) == null) {
                    return;
                }
                bVar.a(this.f6744f);
            }
        }
    }

    static float E(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    static int F(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    private void G(ViewGroup viewGroup) {
        if (this.f6731a == null) {
            this.f6731a = this.f6735e ? z.a.n(viewGroup, this.f6734d, this.f6740j) : z.a.o(viewGroup, this.f6740j);
        }
    }

    static float H(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean C(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        z.a aVar = this.f6731a;
        if (aVar == null) {
            return false;
        }
        aVar.E(motionEvent);
        return true;
    }

    public boolean D(View view) {
        return true;
    }

    public void I(float f10) {
        this.f6739i = E(0.0f, f10, 1.0f);
    }

    public void J(float f10) {
        this.f6738h = E(0.0f, f10, 1.0f);
    }

    public void K(int i10) {
        this.f6736f = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean z10 = this.f6733c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z10 = coordinatorLayout.B(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f6733c = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f6733c = false;
        }
        if (!z10) {
            return false;
        }
        G(coordinatorLayout);
        return this.f6731a.N(motionEvent);
    }
}
