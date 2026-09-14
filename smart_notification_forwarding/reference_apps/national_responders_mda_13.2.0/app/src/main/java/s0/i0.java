package s0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import s0.a;
import s0.m;

/* loaded from: classes.dex */
public abstract class i0 extends m {
    private static final String[] P = {"android:visibility:visibility", "android:visibility:parent"};
    private int O = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f13924a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f13925b;

        a(i0 i0Var, w wVar, View view) {
            this.f13924a = wVar;
            this.f13925b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f13924a.c(this.f13925b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements m.f, a.InterfaceC0285a {

        /* renamed from: a, reason: collision with root package name */
        private final View f13926a;

        /* renamed from: b, reason: collision with root package name */
        private final int f13927b;

        /* renamed from: c, reason: collision with root package name */
        private final ViewGroup f13928c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f13929d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f13930e;

        /* renamed from: f, reason: collision with root package name */
        boolean f13931f = false;

        b(View view, int i10, boolean z10) {
            this.f13926a = view;
            this.f13927b = i10;
            this.f13928c = (ViewGroup) view.getParent();
            this.f13929d = z10;
            f(true);
        }

        private void e() {
            if (!this.f13931f) {
                d0.i(this.f13926a, this.f13927b);
                ViewGroup viewGroup = this.f13928c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            f(false);
        }

        private void f(boolean z10) {
            ViewGroup viewGroup;
            if (!this.f13929d || this.f13930e == z10 || (viewGroup = this.f13928c) == null) {
                return;
            }
            this.f13930e = z10;
            x.b(viewGroup, z10);
        }

        @Override // s0.m.f
        public void a(m mVar) {
            f(false);
        }

        @Override // s0.m.f
        public void b(m mVar) {
            e();
            mVar.X(this);
        }

        @Override // s0.m.f
        public void c(m mVar) {
        }

        @Override // s0.m.f
        public void d(m mVar) {
            f(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f13931f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, s0.a.InterfaceC0285a
        public void onAnimationPause(Animator animator) {
            if (this.f13931f) {
                return;
            }
            d0.i(this.f13926a, this.f13927b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, s0.a.InterfaceC0285a
        public void onAnimationResume(Animator animator) {
            if (this.f13931f) {
                return;
            }
            d0.i(this.f13926a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f13932a;

        /* renamed from: b, reason: collision with root package name */
        boolean f13933b;

        /* renamed from: c, reason: collision with root package name */
        int f13934c;

        /* renamed from: d, reason: collision with root package name */
        int f13935d;

        /* renamed from: e, reason: collision with root package name */
        ViewGroup f13936e;

        /* renamed from: f, reason: collision with root package name */
        ViewGroup f13937f;

        c() {
        }
    }

    private void k0(s sVar) {
        sVar.f13987a.put("android:visibility:visibility", Integer.valueOf(sVar.f13988b.getVisibility()));
        sVar.f13987a.put("android:visibility:parent", sVar.f13988b.getParent());
        int[] iArr = new int[2];
        sVar.f13988b.getLocationOnScreen(iArr);
        sVar.f13987a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0075, code lost:
    
        if (r9 == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
    
        if (r0.f13936e == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
    
        if (r0.f13934c == 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private s0.i0.c l0(s0.s r8, s0.s r9) {
        /*
            r7 = this;
            s0.i0$c r0 = new s0.i0$c
            r0.<init>()
            r1 = 0
            r0.f13932a = r1
            r0.f13933b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f13987a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f13987a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f13934c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f13987a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f13936e = r6
            goto L37
        L33:
            r0.f13934c = r4
            r0.f13936e = r3
        L37:
            if (r9 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.f13987a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f13987a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f13935d = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f13987a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f13937f = r2
            goto L5e
        L5a:
            r0.f13935d = r4
            r0.f13937f = r3
        L5e:
            r2 = 1
            if (r8 == 0) goto L82
            if (r9 == 0) goto L82
            int r8 = r0.f13934c
            int r9 = r0.f13935d
            if (r8 != r9) goto L70
            android.view.ViewGroup r3 = r0.f13936e
            android.view.ViewGroup r4 = r0.f13937f
            if (r3 != r4) goto L70
            return r0
        L70:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L75
            goto L93
        L75:
            if (r9 != 0) goto L96
            goto L88
        L78:
            android.view.ViewGroup r8 = r0.f13937f
            if (r8 != 0) goto L7d
            goto L93
        L7d:
            android.view.ViewGroup r8 = r0.f13936e
            if (r8 != 0) goto L96
            goto L88
        L82:
            if (r8 != 0) goto L8d
            int r8 = r0.f13935d
            if (r8 != 0) goto L8d
        L88:
            r0.f13933b = r2
        L8a:
            r0.f13932a = r2
            goto L96
        L8d:
            if (r9 != 0) goto L96
            int r8 = r0.f13934c
            if (r8 != 0) goto L96
        L93:
            r0.f13933b = r1
            goto L8a
        L96:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.i0.l0(s0.s, s0.s):s0.i0$c");
    }

    @Override // s0.m
    public String[] J() {
        return P;
    }

    @Override // s0.m
    public boolean L(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f13987a.containsKey("android:visibility:visibility") != sVar.f13987a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c l02 = l0(sVar, sVar2);
        if (l02.f13932a) {
            return l02.f13934c == 0 || l02.f13935d == 0;
        }
        return false;
    }

    @Override // s0.m
    public void i(s sVar) {
        k0(sVar);
    }

    @Override // s0.m
    public void m(s sVar) {
        k0(sVar);
    }

    public abstract Animator m0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator n0(ViewGroup viewGroup, s sVar, int i10, s sVar2, int i11) {
        if ((this.O & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f13988b.getParent();
            if (l0(x(view, false), K(view, false)).f13932a) {
                return null;
            }
        }
        return m0(viewGroup, sVar2.f13988b, sVar, sVar2);
    }

    public abstract Animator o0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e9 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator p0(android.view.ViewGroup r7, s0.s r8, int r9, s0.s r10, int r11) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.i0.p0(android.view.ViewGroup, s0.s, int, s0.s, int):android.animation.Animator");
    }

    @Override // s0.m
    public Animator q(ViewGroup viewGroup, s sVar, s sVar2) {
        c l02 = l0(sVar, sVar2);
        if (!l02.f13932a) {
            return null;
        }
        if (l02.f13936e == null && l02.f13937f == null) {
            return null;
        }
        return l02.f13933b ? n0(viewGroup, sVar, l02.f13934c, sVar2, l02.f13935d) : p0(viewGroup, sVar, l02.f13934c, sVar2, l02.f13935d);
    }

    public void q0(int i10) {
        if ((i10 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.O = i10;
    }
}
